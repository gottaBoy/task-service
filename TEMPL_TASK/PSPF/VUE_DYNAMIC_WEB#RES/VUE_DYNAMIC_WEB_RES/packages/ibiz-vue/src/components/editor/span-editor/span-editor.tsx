import { IPSAppCodeList, IPSAppDEField, IPSCodeListEditor } from '@ibiz/dynamic-model-api';
import { DataTypes, ModelTool, Util } from 'ibiz-core';
import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 文本框编辑器
 *
 * @export
 * @class SpanEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class SpanEditor extends EditorBase {

    /**
     * 编辑器初始化
     *
     * @memberof SpanEditor
     */
    public async initEditor() {
        await super.initEditor();
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        this.customProps.noValueShowMode = Object.is('FORM', this.containerCtrl?.controlType) ? 'STYLE1' : 'DEFAULT';
        switch (editorTypeStyle) {
            case 'SPAN':
                await this.initSpan();
                break;
            case 'SPANEX':
                this.initSpanEX();
                break;
            case 'SPAN_HTML':
                this.initSpanHtml();
                break;
            case 'SPAN_COLORSPAN':
                await this.initSpanColorSpan();
                break;
            case 'SPAN_AFTERTIME':
                this.initSpanAfterTime();
                break;
            case 'SPAN_ADDRESSPICKUP':
                await this.initAddressPickUp();
                break;

        }
    }

    /**
     * 解析标签值格式化参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public initFormatParams() {
        let unitName = this.parentItem?.unitName;
        let appDeField: IPSAppDEField = this.parentItem?.getPSAppDEField?.();
        if (appDeField?.stdDataType) {
            this.customProps.dataType = DataTypes.toString(appDeField.stdDataType);
        }
        if (appDeField?.valueFormat) {
            this.customProps.valueFormat = appDeField?.valueFormat;
        }
        if (this.valueFormat) {
            this.customProps.valueFormat = this.valueFormat;
        }
        if (this.editorInstance.editorParams?.valueFormat) {
            this.customProps.valueFormat = this.editorInstance.editorParams?.valueFormat;
        }
        if (unitName) {
            this.customProps.unitName = unitName;
        }
    }

    /**
     * 解析标签数值精度参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public initNumberParams() {
        let appDeField: IPSAppDEField = this.parentItem?.getPSAppDEField?.();
        this.customProps.precision = ModelTool.getPrecision(this.editorInstance, appDeField);
    }

    /**
     * 解析标签代码表参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public async initCodelistParams() {
        let codeList = (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList?.();
        if (codeList) {
            this.customProps.tag = codeList?.codeName;
            this.customProps.codelistType = codeList?.codeListType;
            this.customProps.renderMode = codeList?.orMode;
            this.customProps.valueSeparator = codeList?.valueSeparator;
            this.customProps.textSeparator = codeList?.textSeparator;
        }
    }


    /**
     * 解析标签参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public async initSpan() {
        let codeList: IPSAppCodeList | null = (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList?.();
        this.customProps.codeList = codeList;
        // 父项转换为代码项文本为true时,显示原值模式为true(排除面板项)
        if (!Object.is(this.parentItem.itemType, 'FIELD') && this.parentItem && this.parentItem.convertToCodeItemText) {
            this.customProps.showSourceMode = true;
        }
        // 面板项特殊识别
        if (Object.is(this.parentItem.itemType, 'FIELD')) {
            // 值格式化 
            this.customProps.valueFormat = this.parentItem.M.valueFormat;
        }
        this.customProps.context = this.context;
        this.customProps.viewparams = this.viewparams;
        this.initFormatParams();
        this.initNumberParams();
    }

    /**
     * 解析旧标签参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public initSpanEX() {
        this.customProps.data = JSON.stringify(this.contextData);
        this.customProps.readonly = true;
        this.customProps.disabled = true;
        this.customProps.placeholder = this.editorInstance?.placeHolder;
    }

    /**
     * 解析标签（格式化信息）参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public initSpanHtml() {
        this.customProps.data = JSON.stringify(this.contextData);
    }

    /**
     * 解析标签（颜色）参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public async initSpanColorSpan() {
        this.customProps.data = this.contextData;
        await this.initCodelistParams();
        this.customProps.context = this.context;
        this.customProps.viewparams = this.viewparams;
    }

    /**
     * 解析标签（多久之前）参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public initSpanAfterTime() {
        this.customProps.data = JSON.stringify(this.contextData);
        this.customProps.formState = this.contextState;
        this.customProps.context = this.context;
        this.customProps.viewparams = this.viewparams;
    }


    /**
     * @description 处理标题的编辑器参数
     * @author 姜林君
     * @date 2023/01/30 15:01:27
     * @returns {*}  
     * @memberof SpanEditor
     */
    public initSpanStyle() {
        let style: any = {};
        style = Object.assign({}, this.customStyle);
        if (!style.width) {
            style.width = "100%";
        }
        if (this.customProps['fontSize']) {
            style['font-sise'] = this.customProps['fontSize'];
        }
        if (this.customProps['color']) {
            style['color'] = this.customProps['color'];
        }
        if (this.customProps['textAlign']) {
            style['text-align'] = this.customProps['textAlign'];
            style.display = 'inline-block';
        }
        if (this.customProps['fontWeight']) {
            style['font-weight'] = this.customProps['font-weight'];
        }
        return style;
    }

    /**
     * 解析标签（地址栏）参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */
    public async initAddressPickUp() {
        let codeList: IPSAppCodeList | null = (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList?.();
        this.customProps.codeList = codeList;
        this.customProps.data = JSON.stringify(this.contextData);
        this.customProps.editorType = "ADDRESSPICKUP";
        this.customProps.context = this.context;
        this.customProps.viewparams = this.viewparams;
        this.initFormatParams();
        this.initNumberParams();
        await this.initCodelistParams();
    }

    /**
     * 绘制标签（格式化信息）
     *
     * @memberof SpanEditor
     */
    public renderSpanHtml() {
        const tempNode = this.$createElement('div', {
            domProps: {
                innerHTML: this.value,
            },
            class: 'span-html'
        })
        return tempNode;
    }

    /**
     * 绘制标签（标题）
     *
     * @memberof SpanEditor
     */
    public renderSpanTitle() {
        const style = this.initSpanStyle();
        const tempNode = this.$createElement('span', {
            domProps: {
                innerHTML: this.customProps['value'] || this.parentItem.caption,
            },
            class: 'span-title',
            style: style,
        })
        return tempNode;
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof SpanEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return
        }
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        if (editorTypeStyle == "SPAN_HTML") {
            return this.renderSpanHtml();
        }
        if (editorTypeStyle == "SPAN_TITLE") {
            return this.renderSpanTitle();
        }
        return this.$createElement(this.editorComponentName, {
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                data: this.contextData,
                ...this.customProps,
            },
            style: this.customStyle,
            class: this.dynaClass,
            on: { change: this.editorChange }
        })
    }
}
