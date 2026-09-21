<template>
    <div class="app-picker-importability">
        <el-input @input="onInput" @change="onChange" :placeholder="placeholder" :value="curValue" size='small' :disabled="disabled" :readonly="!importability">
            <template slot="suffix">
                <i v-if="curValue && !disabled" class='el-icon-circle-close' @click="onClear"></i>
                <i class='el-icon-search' @click="openView"></i>
            </template>
        </el-input>
    </div>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject, Subscription } from 'rxjs';
import { Util } from 'ibiz-core';

@Component({})
export default class AppPickerImportability extends Vue {

    /**
     * 表单数据
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() data?: any;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppPickerImportability
     */
    @Prop() disabled?: boolean;

    /**
     * 是否可输入
     *
     * @type {boolean}
     * @memberof AppPickerImportability
     */
    @Prop({ default: false }) public importability?: boolean;

    /**
     * 表单项值
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() value?: any;

    /**
     * 值项
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() valueitem?: any;

    /**
     * 占位提示符
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() public placeholder?: string;

    /**
     * 局部上下文导航参数
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() public localContext!: any;

    /**
     * 局部导航参数
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() public localParam!: any;

    /**
     * 表单项名称
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() name!: string;

    /**
     * 视图上下文
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {any}
     * @memberof AppPickerImportability
     */
    @Prop() public viewparams!: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppPickerImportability
     */
    @Prop({ default: 'srfmajortext' }) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppPickerImportability
     */
    @Prop({ default: 'srfkey' }) public deKeyField!: string;

    /**
     * 选择视图
     *
     * @type {string}
     * @memberof AppPickerImportability
     */
    @Prop() pickupView?: any;

    /**
     * 当前显示值
     *
     * @type {string}
     * @memberof AppPickerImportability
     */
    public curValue: string = '';

    /**
     * 当前显示值主键
     *
     * @type {string}
     * @memberof AppPickerImportability
     */
    public curValueId: any;

    /**
     * 订阅对象
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof AppListBox
     */
    protected formStateEvent: Subscription | undefined;

    /**
     * 监听value
     * 
     * @param newVal
     * @param oldVal
     * @memberof AppPickerImportability
     */
    @Watch('value', { immediate: true, deep: true })
    onValueChange(newVal: any, oldVal: any) {
        this.curValue = newVal;
        if (this.valueitem) {
            this.curValueId = this.data[this.valueitem];
        }
    }

    /**
     * 清除数据
     * 
     * @param $event
     * @memberof AppPickerImportability
     */
    public onClear($event: any): void {
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: null });
        }
        if (this.valueitem) {
            this.$emit('formitemvaluechange', { name: this.valueitem, value: null });
        }
    }

    /**
     * 输入值
     * 
     * @param $event
     * @memberof AppPickerImportability
     */
    public onInput($event: any): void {
        this.curValue = $event;
        this.curValueId = null;
    }

    /**
     * 值改变
     * 
     * @param $event
     * @memberof AppPickerImportability
     */
    public onChange($event: any): void {
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: this.curValue });
        }
        if (this.valueitem) {
            this.$emit('formitemvaluechange', { name: this.valueitem, value: this.curValueId });
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
            this.$throw(this.$t('components.AppMpicker.formdataException') as any, 'handlePublicParams');
            return false;
        }
        // 合并表单参数
        arg.param = this.viewparams ? Util.deepCopy(this.viewparams) : {};
        arg.context = this.context ? Util.deepCopy(this.context) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length > 0) {
            let _context = Util.computedNavData(this.data, arg.context, arg.param, this.localContext);
            Object.assign(arg.context, _context);
        }
        if (this.localParam && Object.keys(this.localParam).length > 0) {
            let _param = Util.computedNavData(this.data, arg.param, arg.param, this.localParam);
            Object.assign(arg.param, _param);
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
            const selectedData = [];
            if (this.curValue && this.curValueId) {
                selectedData.push({srfkey: this.curValueId, srfmajortext: this.curValue});
            }
            _viewparams = Object.assign(_viewparams, { selectedData: selectedData });
            if (view && view.viewpath) {
                _context.viewpath = view.viewpath;
            }
            const modal: Subject<any> = this.$appmodal.openModal(view, _context, _viewparams);
            this.formStateEvent = modal.subscribe((result: any) => {
                if (result && Object.is(result.ret, 'OK')) {
                    let item: any = {};
                    if (result.datas && Array.isArray(result.datas)) {
                        Object.assign(item, result.datas[0]);
                    }
                    if (this.name) {
                        this.$emit('formitemvaluechange', { name: this.name, value: item[this.deMajorField] ? item[this.deMajorField] : item["srfmajortext"] });
                    }
                    if (this.valueitem) {
                        this.$emit('formitemvaluechange', { name: this.valueitem, value: item[this.deKeyField] ? item[this.deKeyField] : item["srfkey"] });
                    }
                }
            });
        }
    }

    public destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

}
</script>