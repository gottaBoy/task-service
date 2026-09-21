import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 时间范围编辑器
 *
 * @export
 * @class DateRangeEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class DateRangeEditor extends EditorBase {

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof DateRangeEditor
     */
     public handleChange($event: any){
        this.editorChange({name: this.editorInstance.name, value: $event})
    }

    /**
     * 编辑器初始化
     *
     * @memberof AutocompleteEditor
     */
    public async initEditor() {
        await super.initEditor();
        switch (this.editorInstance?.editorType) {
            case 'DATERANGE':
                this.customProps.type = 'datetimerange';
                this.customProps.format = 'yyyy-MM-dd HH:mm:ss';
                this.customProps.valueFormat = 'yyyy-MM-dd HH:mm:ss';
                break;
            case 'DATERANGE_NOTIME':
                this.customProps.type = 'daterange';
                this.customProps.format = 'yyyy-MM-dd';
                this.customProps.valueFormat = 'yyyy-MM-dd';
                break;
        }
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof AutocompleteEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.unlinkPanels) {
            param.unlinkPanels = this.handleBoolean(params.unlinkPanels);
        }
        const valueItems: any[] = this.editorInstance.M.getPSEditorItems || [];
        if (valueItems.length > 0) {
            const valueItemNames: string[] = valueItems.map(( item: any) => item.name);
            param.valueItemNames = valueItemNames.join(',');
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof DateRangeEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        return this.$createElement(this.editorComponentName,{
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                value: this.value,
                data: this.contextData,
                disabled: this.disabled,
                context: this.context,
                formState: this.contextState,
                viewparams: this.viewparams,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, itemChange: this.editorChange, focus: this.editorFocus, blur: this.editorBlur },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}
