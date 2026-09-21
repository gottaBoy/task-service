import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 级联编辑器
 *
 * @export
 * @class CascaderEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class CascaderEditor extends EditorBase {

    /**
     * 编辑器模型是否加载完成
     * 
     * @memberof CascaderEditor
     */
    public editorIsLoaded: boolean = false;

    /**
     * 编辑器初始化
     *
     * @memberof CascaderEditor
     */
    public async initEditor() {
        await super.initEditor();
        const editItems = this.editorInstance.getPSEditorItems();
        this.customProps.valueItems = [];
        if (editItems) {
            for (const editItem of editItems) {
                await editItem.getPSAppDataEntity()?.fill();
                this.customProps.valueItems.push({
                    name: editItem.name,
                    appDataEntity: editItem.getPSAppDataEntity(),
                    dataSet: editItem.getPSAppDEDataSet()?.codeName,
                })
            }
        }
    }

    /**
     * 编辑器change事件
     *
     * @param {*} $event
     * @memberof CascaderEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: $event.name, value: $event.value });
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof CascaderEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.disabled) {
            param.disabled = this.handleBoolean(params.disabled);
        }
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.multiple) {
            param.multiple = this.handleBoolean(params.multiple);
        }
        if (params.filterable) {
            param.filterable = this.handleBoolean(params.filterable);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof CascaderEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null
        }
        return this.$createElement(this.editorComponentName, {
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                context: this.context,
                data: this.contextData,
                viewparams: this.viewparams,
                formState: this.contextState,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur, focus: this.editorFocus },
            class: this.dynaClass,
            style: this.customStyle
        })
    }
}
