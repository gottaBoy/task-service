<template>
    <div class="app-tag-picker" ref="tagPicker">
        <el-select
            ref="dragSelect"
            :popper-class="`app-tag-picker__popper ${!showPopper ? 'is-hidden' : ''}`"
            :value="curValue"
            clearable
            :placeholder="placeholder"
            multiple
            filterable
            remote
            :loading="loading"
            :remote-method="onSearch"
            size="small"
            @change="onSelect"
            @remove-tag="onRemove"
            :disabled="disabled || readonly"
            @blur.native.capture="blur"
            @focus="focus"
            @visible-change="handleVisibleChange"
        >
            <template slot="prefix">
                <span
                    v-for="item in allItems"
                    :key="item[deKeyField]"
                    :style="getItemColor(item)"
                    v-show="curValue.includes(item[deKeyField])"
                >
                    <i :class="getItemIcon(item)" />
                    <span>{{ item[deMajorField] }}</span>
                </span>
            </template>
            <template v-if="loading" slot="empty">
                <span class="is-empty el-icon-loading"></span>
            </template>
            <template v-if="pValue">
                <el-option-group
                v-for="group in items"
                :key="group[deKeyField]"
                :label="group[deMajorField]">
                    <el-option
                        v-for="item in group.children"
                        :key="item[deKeyField]"
                        :label="item[deMajorField]"
                        :value="item[deKeyField]"
                        :style="getItemColor(item)">
                            <i :class="getItemIcon(item)" />
                            <span>{{ item[deMajorField] }}</span>
                    </el-option>
                </el-option-group>
            </template>
            <template v-else>
            <el-option
                v-for="item in items"
                :key="item[deKeyField]"
                :label="item[deMajorField]"
                :value="item[deKeyField]"
                :style="getItemColor(item)"
            >
                <i :class="getItemIcon(item)" />
                <span>{{ item[deMajorField] }}</span>
            </el-option>
            </template>
            <el-option v-if="linkview" class="app-tag-picker__more" label="标签管理" value="manager">
                <i class="el-icon-edit-outline" />
                <span>标签管理</span>
            </el-option>
        </el-select>
    </div>
</template>
<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { LogUtil, Util } from 'ibiz-core';
import Sortable from 'sortablejs';

@Component({})
export default class AppTagPicker extends Vue {
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
    @Prop({ default: false }) public readonly?: boolean;

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
     * @memberof AppTagPicker
     */
    @Prop() public localContext!: any;

    /**
     * 局部导航参数
     *
     * @type {any}
     * @memberof AppTagPicker
     */
    @Prop() public localParam!: any;

    /**
     * 表单项名称
     */
    @Prop() name: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop() public viewparams!: any;

    /**
     * AC参数
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop({ default: () => {} }) public acParams?: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppTagPicker
     */
    @Prop({ default: 'srfmajortext' }) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppTagPicker
     */
    @Prop({ default: 'srfkey' }) public deKeyField!: string;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop() public service?: any;

    /**
     * 标签管理视图
     */
    @Prop() linkview?: any;

    /**
     * 值类型
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop({ default: 'SIMPLE' })
    public valueType?: 'SIMPLE' | 'OBJECTS';

    /**
     * 值分隔符
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop({ default: ',' })
    public valueSeparator?: string;

    /**
     * 对象标识属性
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop()
    public objectIdField?: string;

    /**
     * 对象名称属性
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop()
    public objectNameField?: string;

    /**
     * 对象值属性
     *
     * @type {*}
     * @memberof AppTagPicker
     */
    @Prop()
    public objectValueField?: string;

    /**
     * 图标属性字段
     *
     * @type {string}
     * @memberof AppTagPicker
     */
    @Prop()
    public iconField?: string;

    /**
     * 颜色属性字段
     *
     * @type {string}
     * @memberof AppTagPicker
     */
    @Prop()
    public colorField?: string;

    /**
     * 父属性id
     *
     * @type {string}
     * @memberof AppTagPicker
     */
    @Prop()
    public pValue?: string;

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
     * 所有选项
     */
    public allItems: any[] = [];

    /**
     * 选中项key-value键值对
     *
     */
    public selectItems: Array<any> = [];

    /**
     * 下拉远程加载状态
     *
     * @type {boolean}
     * @memberof AppTagPicker
     */
    public loading: boolean = false;

    /**
     * 是否显示下拉框
     *
     * @type {boolean}
     * @memberof AppTagPicker
     */
    public showPopper: boolean = false;

    /**
     * 监听curvalue值
     * @param newVal
     * @param val
     */
    @Watch('value', { immediate: true, deep: true })
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
                            [this.deMajorField]: item[this.objectNameField as string],
                        });
                        if (this.objectValueField) {
                            Object.assign(_item, {
                                ...item[this.objectValueField],
                            });
                            delete _item[this.objectValueField];
                        }
                        if (_item[this.deKeyField]) {
                            this.selectItems.push(_item);
                        }
                    });
                } else {
                    if (this.objectIdField) {
                        let values = this.value.split(this.valueSeparator);
                        values.forEach((value: string) => {
                            this.selectItems.push({
                                [this.deKeyField]: value,
                            });
                        });
                    } else {
                        this.selectItems = JSON.parse(newVal);
                    }
                }
                this.selectItems.forEach((item: any) => {
                    this.curValue.push(item[this.deKeyField]);
                    let index = this.items.findIndex(i => Object.is(i[this.deKeyField], item[this.deKeyField]));
                    if (index < 0) {
                        this.items.push({
                            [this.deMajorField]: item[this.deMajorField],
                            [this.deKeyField]: item[this.deKeyField],
                        });
                    }
                });
            } catch (error: any) {
                if (error.name === 'SyntaxError') {
                    let srfkeys: any = newVal.split(',');
                    let srfmajortexts: any = null;
                    if (this.valueitem && this.data[this.valueitem]) {
                        srfmajortexts = this.data[this.valueitem].split(',');
                    }
                    if (
                        srfkeys.length &&
                        srfkeys.length > 0 &&
                        srfmajortexts.length &&
                        srfmajortexts.length > 0 &&
                        srfkeys.length == srfmajortexts.length
                    ) {
                        srfkeys.forEach((id: any, index: number) => {
                            this.curValue.push(id);
                            this.selectItems.push({ [this.deKeyField]: id, [this.deMajorField]: srfmajortexts[index] });
                            let _index = this.items.findIndex(i => Object.is(i[this.deKeyField], id));
                            if (_index < 0) {
                                this.items.push({ [this.deKeyField]: id, [this.deMajorField]: srfmajortexts[index] });
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
     * @memberof AppTagPicker
     */
    public mounted() {
        this.setSort();
        if (this.objectNameField) {
            this.onSearch('');
        }
    }

    /**
     * 生命周期
     *
     * @memberof AppTagPicker
     */
    public updated() {
        const tagPicker = this.$refs.tagPicker as HTMLElement;
        if (tagPicker) {
            const el = tagPicker.querySelectorAll('.el-select__tags-text');
            // 获取元素内文本值，添加到title
            if (el.length > 0) {
                el.forEach((item: any) => {
                    item.title = item.innerText;
                });
            }
        }
    }

    /**
     * 设置拖拽排序
     *
     * @memberof AppTagPicker
     */
    public setSort() {
        const el = (this.$refs.dragSelect as any).$el.querySelectorAll('.el-select__tags > span')[0];
        Sortable.create(el, {
            ghostClass: 'sortable-ghost',
            setData: (dataTransfer: any) => {
                dataTransfer.setData('Text', '');
            },
            onEnd: (evt: any) => {
                const targetRow = this.curValue.splice(evt.oldIndex, 1)[0];
                this.curValue.splice(evt.newIndex, 0, targetRow);
                this.onSelect(this.curValue);
            },
        });
    }

    /**
     * 远程执行搜索
     *
     * @param {*} query
     * @memberof AppTagPicker
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
        let miss: string = this.$t('components.appmpicker.miss') as any;
        let requestException: string = this.$t('components.appmpicker.requestexception') as any;
        if (!this.service) {
            this.$throw(miss + 'service', 'onSearch');
        } else if (!this.acParams.serviceName) {
            this.$throw(miss + 'serviceName', 'onSearch');
        } else if (!this.acParams.interfaceName) {
            this.$throw(miss + 'interfaceName', 'onSearch');
        } else {
            this.loading = true;
            this.service
                .getItems(this.acParams.serviceName, this.acParams.interfaceName, _context, _param)
                .then((response: any) => {
                    this.loading = false;
                    if (!response) {
                        this.$throw(requestException, 'onSearch');
                    } else {
                        if (this.pValue) {
                            this.items = this.handleLevelData(response) || [...response];
                        } else {
                            this.items = [...response];
                        }
                        if (!query) {
                            this.allItems = [...response];
                        }
                    }
                })
                .catch((error: any) => {
                    this.loading = false;
                    LogUtil.log(error);
                });
        }
    }

    /**
     * 下拉选中回调
     *
     * @param {*} selects
     * @memberof AppTagPicker
     */
    public onSelect(selects: any) {
        if (selects.includes('manager')) {
            this.showPopper = false;
            this.openManagerView();
            return;
        }
        let val: Array<any> = [];
        let value: any = null;
        if (selects.length > 0) {
            selects.forEach((select: any) => {
                let index = this.allItems.findIndex(item => Object.is(item[this.deKeyField], select));
                let item: any = {};
                if (index >= 0) {
                    item = this.allItems[index];
                } else {
                    index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], select));
                    if (index >= 0) {
                        item = this.selectItems[index];
                    }
                }
                if (this.valueType == 'OBJECTS') {
                    val.push(this.handleObjectParams(item));
                } else {
                    if (this.objectIdField) {
                        val.push(item[this.deKeyField]);
                    } else {
                        val.push({
                            [this.deKeyField]: item[this.deKeyField],
                            [this.deMajorField]: item[this.deMajorField],
                        });
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
        } else {
            this.$emit('formitemvaluechange', { name: this.name, value: null });
        }
    }

    /**
     * 打开视图
     *
     * @returns
     * @memberof AppMpicker
     */
    public openManagerView() {
        if (this.disabled) {
            return;
        }
        if (this.linkview && Object.keys(this.linkview).length > 0) {
            const view = { ...this.linkview };
            // 公共参数处理
            let data: any = {};
            const bcancel: boolean = this.handlePublicParams(data);
            if (!bcancel) {
                return;
            }
            // 参数处理
            let context = data.context;
            const routePath = this.$viewTool.buildUpRoutePath(
                this.$route,
                context,
                view.deResParameters,
                view.parameters,
                [this.data],
                {},
            );
            this.$router.push(routePath);
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
            });
        }
        if (this.objectNameField) {
            Object.assign(object, {
                [this.objectNameField]: select[this.deMajorField],
            });
        }
        if (this.objectValueField) {
            Object.assign(object, {
                [this.objectValueField]: Util.deepCopy(select),
            });
        }
        return object;
    }

    /**
     * 移除标签回调
     *
     * @param {*} tag
     * @memberof AppTagPicker
     */
    public onRemove(tag: any) {
        let index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], tag));
        if (index >= 0) {
            this.selectItems.splice(index, 1);
            let val: Array<any> = [];
            let value: any = null;
            this.selectItems.forEach((select: any) => {
                if (this.valueType == 'OBJECTS') {
                    val.push(this.handleObjectParams(select));
                } else {
                    if (this.objectIdField) {
                        val.push(select[this.deKeyField]);
                    } else {
                        val.push({
                            [this.deKeyField]: select[this.deKeyField],
                            [this.deMajorField]: select[this.deMajorField],
                        });
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
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppTagPicker
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            this.$throw(this.$t('components.AppTagPicker.formdataException') as any, 'handlePublicParams');
            return false;
        }
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length > 0) {
            let _context = this.$util.computedNavData(this.data, arg.context, arg.param, this.localContext);
            Object.assign(arg.context, _context);
        }
        if (this.localParam && Object.keys(this.localParam).length > 0) {
            let _param = this.$util.computedNavData(this.data, arg.param, arg.param, this.localParam);
            Object.assign(arg.param, _param);
        }
        return true;
    }

    /**
     * 处理层级数据
     * 
     * @param {*} items
     * @memberof AppTagPicker
     */
    public handleLevelData(items: Array<any>){
        if(items && items.length >0){
            const hasChildren = items.some((item:any) =>{
                if (this.pValue) {
                    return item[this.pValue];
                }
            })
            if(hasChildren){
                let list:Array<any> = [];
                items.forEach((codeItem:any) =>{
                    if(this.pValue && !codeItem[this.pValue]){
                        let valueField:string = codeItem[this.deKeyField];
                        this.setChildItems(valueField,items,codeItem);
                        list.push(codeItem);
                    }
                })
                return list;
            }
        }
    }

    /**
     * 计算子类数据
     * 
     * @param {*} items
     * @memberof AppTagPicker
     */
    public setChildItems(pValue:string,result:Array<any>,codeItem:any){
        result.forEach((item:any) =>{
            if(this.pValue && item[this.pValue] == pValue){
                let valueField:string = item[this.deKeyField];
                this.setChildItems(valueField,result,item);
                if(!codeItem.children){
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        })
    }

    /**
     * 获取项图标
     */
    public getItemIcon(item: any) {
        if (this.iconField && item[this.iconField]) {
            return item[this.iconField];
        } else {
            return 'ivu-icon ivu-icon-ios-pricetag';
        }
    }

    /**
     * 获取项颜色
     */
    public getItemColor(item: any) {
        if (this.colorField && item[this.colorField]) {
            return { color: `${item[this.colorField]} !important` };
        }
    }

    /**
     * 处理下拉显示改变
     */
    public handleVisibleChange(visible: boolean) {
        this.showPopper = visible;
        if (visible) {
            this.onSearch('');
        }
    }

    /**
     * 输入框失焦
     *
     * @memberof AppTagPicker
     */
    public blur() {
        this.$emit('blur', { name: this.name, value: this.value });
    }

    /**
     * 输入框聚焦
     *
     * @memberof AppTagPicker
     */
    public focus() {
        this.$emit('focus', { name: this.name, value: this.value });
    }
}
</script>
