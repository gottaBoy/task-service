<template>
    <div class="app-mpicker">
        <div class="app-mpicker-select-container" ref="appMpickerSelect">
            <el-select ref="dragSelect" :value="curValue" :placeholder="placeholder" multiple filterable remote :loading="loading" :remote-method="onSearch" size="small" @change="onSelect" @remove-tag="onRemove" :disabled="disabled || readonly"
            @blur.native.capture='blur'  @focus="focus" @visible-change="handleVisibleChange">
                <template v-if="loading" slot="empty">
                    <span class="is-empty el-icon-loading"></span>
                </template>
                <el-option v-for="item in items" :key="item[deKeyField]" :label="item[deMajorField]" :value="item[deKeyField]"></el-option>
            </el-select>
            <span class="app-mpicker-open-icon">
                <i class="el-icon-search" @click="openView"></i>
            </span>
        </div>
    </div>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject, Subscription } from 'rxjs';
import { LogUtil, Util } from 'ibiz-core';
import Sortable from 'sortablejs';

@Component({
})
export default class AppMpicker extends Vue {

    /**
     * 表单数据
     */
    @Prop() data?: any;

    /**
     * 是否禁用
     */
    @Prop() disabled?: boolean;

	/**
	 * 只读模式
	 * 
	 * @type {boolean}
	 */
	@Prop({default: false}) public readonly?: boolean;

    /**
     * 表单项值
     */
    @Prop() value?: any;

    /**
     * 值项
     */
    @Prop() valueitem?: any;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof AppMpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof AppMpicker
     */
    @Prop() public localParam!:any;

    /**
     * 表单项名称
     */
    @Prop() name: any;
    
    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * AC参数
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop({default: () => {}}) public acParams?: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppMpicker
     */
    @Prop({default: 'srfmajortext'}) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppMpicker
     */
    @Prop({default: 'srfkey'}) public deKeyField!: string;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public service?: any;

    /**
     * 打开对应的选择视图
     */
    @Prop() pickupView?: any;

    /**
     * 值类型
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop({ default: 'SIMPLE' })
    public valueType?: 'SIMPLE' | 'OBJECTS';

    /**
     * 值分隔符
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop({ default: ',' })
    public valueSeparator?: string;

    /**
     * 对象标识属性
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop()
    public objectIdField?: string;

    /**
     * 对象名称属性
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop()
    public objectNameField?: string;

    /**
     * 对象值属性
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop()
    public objectValueField?: string;

    /**
     * 占位提示
     *
     * @type {*}
     */
    @Prop({ default: '' }) public placeholder?: string;
    
    /**
     * 当前表单项绑定值key的集合
     */
    public curValue: any = [];

    /**
     * 所有操作过的下拉选选项
     */
    public items: Array<any> = [];

    /**
     * 选中项key-value键值对
     * 
     */
    public selectItems: Array<any> = [];

    /**
     * 下拉远程加载状态
     * 
     * @type {boolean}
     * @memberof AppMpicker
     */
    public loading: boolean = false;

    /**
     * 模态事件
     * 
     * @type {Subscription | undefined}
     * @memberof AppMpicker
     */
    public modalEvent: Subscription | undefined;

    /**
     * 监听curvalue值
     * @param newVal 
     * @param val 
     */
    @Watch('value', {immediate:true, deep: true })
    oncurvalueChange(newVal: any, val: any) {
        this.curValue = [];
        this.selectItems = [];
        if (newVal) {
            try {
                if (this.valueType == 'OBJECTS') {
                    this.value.forEach((item: any) => {
                        const _item = Util.deepCopy(item);
                        Object.assign(_item, {
                            [this.deKeyField]: item[this.objectIdField as string],
                            [this.deMajorField]: item[this.objectNameField as string]
                        })
                        if (this.objectValueField) {
                            Object.assign(_item, {
                                ...item[this.objectValueField]
                            })
                            delete _item[this.objectValueField]
                        }
                        if (_item[this.deKeyField]) {
                            this.selectItems.push(_item)
                        }
                    })
                } else {
                    if (this.objectIdField) {
                        let values = this.value.split(this.valueSeparator);
                        values.forEach((value: string) => {
                            this.selectItems.push({
                                [this.deKeyField]: value,
                            })
                        })
                    } else {
                        this.selectItems = JSON.parse(newVal);
                    }
                }
                this.selectItems.forEach((item: any) => {
                    this.curValue.push(item[this.deKeyField]);
                    let index = this.items.findIndex((i) => Object.is(i[this.deKeyField], item[this.deKeyField]));
                    if (index < 0) {
                        this.items.push({ [this.deMajorField]: item[this.deMajorField], [this.deKeyField]: item[this.deKeyField] });
                    }
                });
            } catch (error: any) {
              if(error.name === 'SyntaxError'){
                let srfkeys:any = newVal.split(',');
                let srfmajortexts:any = null;
                if(this.valueitem && this.data[this.valueitem]){
                    srfmajortexts = this.data[this.valueitem].split(',');
                }
                if(srfkeys.length && srfkeys.length > 0 && srfmajortexts.length && srfmajortexts.length > 0 && srfkeys.length == srfmajortexts.length){
                    srfkeys.forEach((id: any, index: number) => {
                        this.curValue.push(id);
                        this.selectItems.push({[this.deKeyField]: id, [this.deMajorField]: srfmajortexts[index]});
                        let _index = this.items.findIndex((i) => Object.is(i[this.deKeyField],id));
                        if (_index < 0) {
                            this.items.push({[this.deKeyField]: id, [this.deMajorField]: srfmajortexts[index]});
                        }
                    });
                }
              }
            }
        }
        this.$forceUpdate();
    }

    /**
     * 生命周期
     *
     * @memberof AppMpicker
     */
    public mounted() {
        this.setSort();
        if(this.objectNameField){
            this.onSearch("");
        }
    }

    /**
     * 生命周期
     * 
     * @memberof AppMpicker
     */
    public updated() {
        const appMpickerSelect = this.$refs.appMpickerSelect as HTMLElement
        if (appMpickerSelect) {
            const el = appMpickerSelect.querySelectorAll('.el-select__tags-text')
            // 获取元素内文本值，添加到title
            if (el.length > 0) {
                el.forEach((item: any) => {
                    item.title = item.innerText
                })
            }
        }
    }

    /**
     * 设置拖拽排序
     *
     * @memberof AppMpicker
     */
    public setSort() {
        const el = (this.$refs.dragSelect as any).$el.querySelectorAll('.el-select__tags > span')[0]
        Sortable.create(el, {
            ghostClass: 'sortable-ghost', 
            setData: (dataTransfer: any) => {
                dataTransfer.setData('Text', '')
            },
            onEnd: (evt: any) => {
                const targetRow = this.curValue.splice(evt.oldIndex, 1)[0]
                this.curValue.splice(evt.newIndex, 0, targetRow);
                this.onSelect(this.curValue);
            }
        })
    }

    /**
     * 远程执行搜索
     *
     * @param {*} query
     * @memberof AppMpicker
     */
    public onSearch(query: any) {
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        let _context = data.context;
        let _param = data.param;
        // TODO 防止查询参数过长
        if (query) {
            Object.assign(_param, { query });
        }
        // 错误信息国际化
        let error: string = (this.$t('components.appmpicker.error') as any);
        let miss: string = (this.$t('components.appmpicker.miss') as any);
        let requestException: string = (this.$t('components.appmpicker.requestexception') as any);
        if(!this.service){
            this.$throw(miss+'service','onSearch');
        } else if(!this.acParams.serviceName) {
            this.$throw(miss+'serviceName','onSearch');
        } else if(!this.acParams.interfaceName) {
            this.$throw(miss+'interfaceName','onSearch');
        } else {
          this.loading = true;
          this.service.getItems(this.acParams.serviceName,this.acParams.interfaceName, _context, _param).then((response: any) => {
              this.loading = false;
              if (!response) {
                  this.$throw(requestException,'onSearch');
              } else {
                  this.items = [...response];
              }
          }).catch((error: any) => {
              this.loading = false;
              LogUtil.log(error);
          });
        }
    }

    /**
     * 下拉选中回调
     *
     * @param {*} selects
     * @memberof AppMpicker
     */
    public onSelect(selects: any) {
        let val: Array<any> = [];
        let value: any = null;
        if (selects.length > 0) {
            selects.forEach((select: any) => {
                let index = this.items.findIndex((item) => Object.is(item[this.deKeyField], select));
                let item: any = {};
                if (index >= 0) {
                    item = this.items[index];
                } else {
                    index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], select));
                    if (index >= 0) {
                        item = this.selectItems[index];
                    }
                }
                if (this.valueType == 'OBJECTS') {
                    val.push(this.handleObjectParams(item))
                } else {
                    if (this.objectIdField) {
                        val.push(item[this.deKeyField])
                    } else {
                        val.push({ [this.deKeyField]: item[this.deKeyField], [this.deMajorField]: item[this.deMajorField] })
                    }
                }
            });
            if (val.length > 0) {
                if (this.valueType == 'OBJECTS') {
                    value = val;
                } else {
                    value = this.objectIdField ? val.join(this.valueSeparator) : JSON.stringify(val);
                }
            }
            this.$emit('formitemvaluechange', { name: this.name, value: value });
        }
    }

    /**
     * 处理对象数据类型抛值
     * @param select 选中数据
     */
    public handleObjectParams(select: any): any {
        const object: any = {};
        if (this.objectIdField) {
            Object.assign(object, {
                [this.objectIdField]: select[this.deKeyField],
            })
        }
        if (this.objectNameField) {
            Object.assign(object, {
                [this.objectNameField]: select[this.deMajorField],
            })
        }
        if (this.objectValueField) {
            Object.assign(object, {
                [this.objectValueField]: Util.deepCopy(select)
            })
        }
        return object
    }

    /**
     * 移除标签回调
     *
     * @param {*} tag
     * @memberof AppMpicker
     */
    public onRemove(tag: any) {
        let index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], tag));
        if (index >= 0) {
            this.selectItems.splice(index, 1);
            let val: Array<any> = [];
            let value: any = null;
            this.selectItems.forEach((select: any) => {
                if (this.valueType == 'OBJECTS') {
                    val.push(this.handleObjectParams(select))
                } else {
                    if (this.objectIdField) {
                        val.push(select[this.deKeyField])
                    } else {
                        val.push({ [this.deKeyField]: select[this.deKeyField], [this.deMajorField]: select[this.deMajorField] })
                    }
                }
            })
            if (val.length > 0) {
                if (this.valueType == 'OBJECTS') {
                    value = val;
                } else {
                    value = this.objectIdField ? val.join(this.valueSeparator) : JSON.stringify(val);
                }
            }
            this.$emit('formitemvaluechange', { name: this.name, value: value });
        }
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppMpicker
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            this.$throw((this.$t('components.AppMpicker.formdataException') as any),'handlePublicParams');
            return false;
        }
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
        return true;
    }

    /**
     * 打开视图
     *
     * @returns
     * @memberof AppMpicker
     */
    public openView() {
        if (this.disabled) {
            return;
        }
        if (this.pickupView && Object.keys(this.pickupView).length > 0) {
            // 参数处理
            const view = { ...this.pickupView };
            // 公共参数处理
            let data: any = {};
            const bcancel: boolean = this.handlePublicParams(data);
            if (!bcancel) {
                return;
            }
            // 参数处理
            let _context = data.context;
            let _viewparams = data.param;
            let _selectItems = JSON.parse(JSON.stringify(this.selectItems));
            if(!Object.is(this.deKeyField,"srfkey")){
                _selectItems.forEach((item:any, index:number)=>{
                    _selectItems[index].srfkey = item[this.deKeyField];
                });
            }
            if(!Object.is(this.deMajorField,"srfmajortext")){
                _selectItems.forEach((item:any, index:number)=>{
                    _selectItems[index].srfmajortext = item[this.deMajorField];
                });
            }
            _context = Object.assign(_context, { srfparentdata: { srfparentkey: this.data[this.deKeyField] }, });
            _viewparams = Object.assign(_viewparams,{ selectedData: [..._selectItems]});
            if (view && view.viewpath) {
              _context.viewpath = view.viewpath;
            }
            let formdata = this.data;
            const modal: Subject<any> = this.$appmodal.openModal(view, _context, _viewparams)
            this.modalEvent = modal.subscribe((result: any) => {
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                let selects: Array<any> = [];
                if (result.datas && Array.isArray(result.datas)) {
                    result.datas.forEach((select: any) => {
                        Object.assign(select, {
                            [this.deKeyField]: select[this.deKeyField] ? select[this.deKeyField] : select.srfkey,
                            [this.deMajorField]: select[this.deMajorField] ? select[this.deMajorField] : select.srfmajortext,
                        })
                        if (this.valueType == 'OBJECTS') {
                            selects.push(this.handleObjectParams(select));
                        } else {
                            if (this.objectIdField) {
                                selects.push(select[this.deKeyField])
                            } else {
                                selects.push({ [this.deKeyField]: select[this.deKeyField], [this.deMajorField]: select[this.deMajorField] })
                            }
                        }
                        let index = this.items.findIndex((item) => Object.is(item[this.deKeyField], select[this.deKeyField]));
                        if (index < 0) {
                            this.items.push(select);
                        }
                    });
                }
                if (this.name && this.data) {
                    let value: any = null;
                    if (selects.length > 0) {
                        if (this.valueType == 'OBJECTS') {
                            value = selects;
                        } else {
                            value = this.objectIdField ? selects.join(this.valueSeparator) : JSON.stringify(selects);
                        }
                    }
                    this.$emit('formitemvaluechange', { name: this.name, value: value });
                }
            })
        }
    }

    /**
     * 处理下拉显示改变
     */
    public handleVisibleChange(visible: boolean) {
        if (visible) {
            this.onSearch('')
        }
    }

    public destroyed() {
        if (this.modalEvent) {
            this.modalEvent.unsubscribe();
        }
    }

    /**
     * 输入框失焦
     * 
     * @memberof AppMpicker
     */
     public blur(){
        this.$emit('blur',{ name: this.name, value: this.value })
    }
    
    /**
     * 输入框聚焦
     * 
     * @memberof AppMpicker
     */
    public focus(){
        this.$emit('focus',{ name: this.name, value: this.value })
    }
}
</script>