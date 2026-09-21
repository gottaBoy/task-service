import { IPSAppDEACMode, IPSAutoComplete, IPSDEACModeDataItem } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { Component, Prop } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 自动完成编辑器
 *
 * @export
 * @class AutocompleteEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AutocompleteEditor extends EditorBase {

    /**
     * 编辑器模型
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() declare editorInstance: IPSAutoComplete;

    /**
     * 编辑器初始化
     *
     * @memberof AutocompleteEditor
     */
    public async initEditor() {
        await super.initEditor();
        if (this.editorInstance.getPSAppDEACMode() &&
            (this.editorInstance.getPSAppDEACMode() as IPSAppDEACMode).getPSDEACModeDataItems() &&
            ((this.editorInstance.getPSAppDEACMode() as IPSAppDEACMode).getPSDEACModeDataItems() as IPSDEACModeDataItem[]).length > 0) {
            this.customProps.dataItems = (this.editorInstance.getPSAppDEACMode() as IPSAppDEACMode).getPSDEACModeDataItems();
        }
        this.customProps.acParams = ModelTool.getAcParams(this.editorInstance);
        this.customProps.deMajorField = ModelTool.getEditorMajorName(this.editorInstance);
        this.customProps.deKeyField = ModelTool.getEditorKeyName(this.editorInstance);
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof AutocompleteEditor
     */
    public handleParams(params: any) {
        const param :any= {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        return Object.assign(params,param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AutocompleteEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        return this.$createElement(this.editorComponentName, {
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                data: this.contextData,
                service: this.service,
                context: this.context,
                editorType: this.editorInstance.editorType,
                viewparams: this.viewparams,
                valueitem: this.parentItem?.valueItemName || '',
                ...this.handleParams(this.customProps),
            },
            on: { formitemvaluechange: this.editorChange, enter: this.editorEnter, blur: this.editorBlur },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}
