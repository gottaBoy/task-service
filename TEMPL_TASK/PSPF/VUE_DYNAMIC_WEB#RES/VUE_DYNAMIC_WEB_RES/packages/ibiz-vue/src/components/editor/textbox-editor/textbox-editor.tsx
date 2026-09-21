import { IPSAppDEField } from '@ibiz/dynamic-model-api';
import { DataTypes, ModelTool, Util } from 'ibiz-core';
import { Component, Prop } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 文本框编辑器
 *
 * @export
 * @class TextboxEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class TextboxEditor extends EditorBase {

    /**
     * 是否防抖
     *
     * @type {boolean}
     * @memberof TextboxEditor
     */
    @Prop() public isDebounce?: boolean;

    /**
     * 编辑器初始化
     *
     * @memberof TextboxEditor
     */
    public async initEditor() {
        await super.initEditor();
        let unitName = this.parentItem?.unitName;
        let appDeField: IPSAppDEField = this.parentItem?.getPSAppDEField?.();
        switch (this.editorInstance?.editorType) {
            case 'TEXTBOX':
                this.customProps.isDebounce = this.isDebounce;
                this.customProps.type = ModelTool.isNumberField(appDeField) ? 'number' : 'text';
                this.customProps.unit = unitName;
                this.customProps.precision = ModelTool.getPrecision(this.editorInstance, appDeField);
                break;
            case 'PASSWORD':
                this.customProps.isDebounce = this.isDebounce;
                this.customProps.type = 'password';
                this.customProps.enableShowPwd = this.editorInstance.editorParams?.['enableShowPwd'] ? JSON.parse(this.editorInstance.editorParams['enableShowPwd'] as string) : false;
                break;
            case 'TEXTAREA':
                this.initTextAreaParams();
                break;
            case 'TEXTAREA_10':
                this.initTextAreaParams();
                this.customProps.rows = 10;
                break;
            case 'NUMBER':
                this.customProps.isDebounce = this.isDebounce;
                this.customProps.type = 'number';
                this.customProps.unit = unitName;
                this.customProps.precision = ModelTool.getPrecision(this.editorInstance, appDeField);
                break;
            case 'MARKDOWN':
                this.customProps.mode = (this.editorInstance as any).mode ? (this.editorInstance as any).mode : 'EDIT';
                break;
        }
        this.initFormatParams();
    }

    /**
     * 初始化多行文本输入框参数
     *
     * @memberof TextboxEditor
     */
    initTextAreaParams() {
        this.customProps.isDebounce = this.isDebounce;
        this.customProps.type = 'textarea';
        this.customProps.textareaId = Util.createUUID();
        let textareaStyle = {};
        if (Object.is('FORM', this.containerCtrl?.controlType)) {
            textareaStyle = {
                height: '100px',
                minHeight: '100px',
            }
            if (this.editorInstance.editorHeight) {
                Object.assign(textareaStyle, {
                    height: `${this.editorInstance.editorHeight}px`,
                    minHeight: `${this.editorInstance.editorHeight}px`,
                })
            }
            if (this.parentItem.contentHeight) {
                Object.assign(textareaStyle, {
                    maxHeight: `${this.parentItem.contentHeight - 16}px`,
                })
            }
        } else {
            textareaStyle = {
                height: '32px',
                minHeight: '32px',
            }
        }
        this.customProps.textareaStyle = textareaStyle;
    }

    /**
     * 初始化格式化参数
     *
     * @memberof TextboxEditor
     */
    public initFormatParams() {
        this.customProps.valueFormat = '';
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
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof TextboxEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: this.editorInstance.name, value: $event })
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof TextboxEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.isDebounce) {
            param.isDebounce = this.handleBoolean(params.isDebounce);
        }
        if (params.rows) {
            param.rows = this.handleNumber(params.rows);
        }
        if (params.precision) {
            param.precision = this.handleNumber(params.precision);
        }
        if (params.min) {
            param.min = this.handleNumber(params.min);
        }
        if (params.max) {
            param.max = this.handleNumber(params.max);
        }
        if (params.showToolbar) {
            param.showToolbar = this.handleBoolean(params.showToolbar);
        }
        if (params.showCatalog) {
            param.showCatalog = this.handleBoolean(params.showCatalog);
        }
        if (params.shortCut) {
            param.shortCut = this.handleBoolean(params.shortCut);
        }
        if (params.boxShadow) {
            param.boxShadow = this.handleBoolean(params.boxShadow);
        }
        if (params.highLight) {
            param.highLight = this.handleBoolean(params.highLight);
        }
        if (params.subfield) {
            param.subfield = this.handleBoolean(params.subfield);
        }
        if (params.fontSize) {
            param.fontSize = this.handleNumber(params.fontSize);
        }
        if (params.enableShowPwd) {
            param.enableShowPwd = this.handleBoolean(params.enableShowPwd);
        }
        if (params.iconList) {
            if(typeof params.iconList === 'string'){
                let func = new Function('return (' + params.iconList + ');');
                param.iconList  = func();
            }
        }
        if (params.showWordLimit) {
            param.showWordLimit = this.handleBoolean(params.showWordLimit);
        }
        if (params.enableAdvancedSetting) {
            param.enableAdvancedSetting = this.handleBoolean(params.enableAdvancedSetting);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制默认内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public renderTextbox() {
        return this.$createElement(this.editorComponentName, {
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                itemValue: this.value,
                disabled: this.disabled,
                ...this.handleParams(this.customProps),
            },
            on: {
                change: this.handleChange,
                enter: this.editorEnter,
                blur: this.editorBlur,
                focus: this.editorFocus
            },
            class: this.dynaClass,
            style: this.customProps.type == 'textarea' ? {} : this.customStyle
        })
    }

    /**
     * 绘制内置插件内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public renderTextboxColorPicker() {
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                editorType: this.editorInstance.editorType,
                data: this.contextData,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, colorChange: ($event: any) => { this.editorChange($event) }, enter: this.editorEnter, blur: this.editorBlur},
            class: this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制工作流审批组件
     *
     * @returns {*}
     * @memberof TextareaEditor
     */
    public renderWfapproval(editorTypeStyle: string) {
        const param = {
            context: this.context,
            viewparams: this.viewparams,
            appEntityCodeName: this.containerCtrl?.getPSAppDataEntity?.()?.codeName,
            appEntity: this.containerCtrl?.getPSAppDataEntity?.()
        }
        if (Object.is(editorTypeStyle, 'TEXTAREA_WFAPPROVAL') || Object.is(editorTypeStyle, 'TEXTAREA_WFAPPROVALEXTENDTIMELINE')) {
            Object.assign(param, {
                value: this.value,
            })
        }
        return this.$createElement(this.editorComponentName, {
            props: param,
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur},
            class:this.dynaClass,
            style: this.customStyle
        })
    }


    /**
     * @description 绘制JsonSchema编辑器
     * @memberof TextboxEditor
     */
    public renderJsonSchema() {
        return this.$createElement(this.editorComponentName, {
            props: {
                value: this.value,
                disabled: this.disabled,
                ...this.handleParams(this.customProps),
            },
            on: {
                change: this.handleChange,
            },
            class:this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        switch (editorTypeStyle) {
            case "TEXTBOX":
            case "PASSWORD":
            case "TEXTAREA":
            case "TEXTAREA_10":
            case "NUMBER":
                if (this.editorInstance.editorParams?.['max']) {
                    this.customProps.max = parseInt(this.editorInstance.editorParams?.['max']);
                }
                if (this.editorInstance.editorParams?.['min']) {
                    this.customProps.min = parseInt(this.editorInstance.editorParams?.['min']);
                }
            case 'MARKDOWN':
            case "TEXTBOX_ICONPICKER":
            case "TEXTAREA_10_WFOPINION":
            case "TEXTBOX_ICONLIST":
                return this.renderTextbox();
            case "TEXTBOX_JSONSCHEMA":
                return this.renderJsonSchema();
            case "TEXTBOX_COLORPICKER":
                return this.renderTextboxColorPicker();
            case "TEXTAREA_WFAPPROVAL":
            case "TEXTAREA_WFAPPROVALTIMELINE":
            case "TEXTAREA_WFAPPROVALEXTENDTIMELINE":
                return this.renderWfapproval(editorTypeStyle);
        }
    }
}
