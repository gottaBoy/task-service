import { Component} from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';
import { isArray } from 'qx-util';

/**
 * 地图选择编辑器
 *
 * @export
 * @class MapPickerEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class MapPickerEditor extends EditorBase {

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof MapPickerEditor
     */
     public handleChange($event: any){
        this.editorChange({name: this.editorInstance.name, value: $event})
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
     * @memberof MapPickerEditor
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
