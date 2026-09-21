import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';
import { Util } from 'ibiz-core';

/**
 * ip地址编辑器
 *
 * @export
 * @class IpAddressEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class IpAddressEditor extends EditorBase {

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof IpAddressEditor
     */
    public handleChange($event: any){
        this.editorChange({name: this.editorInstance.name, value: $event})
    }

    /**
     * 设置编辑器的自定义高宽
     *
     * @memberof EditorBase
     */
     public setCustomStyle() {
        let { editorWidth, editorHeight } = this.editorInstance;
        this.customStyle = {
            width: '300px',
        };
        if (!Util.isEmpty(editorWidth) && editorWidth != 0) {
            this.customStyle.width = editorWidth > 1 ? editorWidth + "px" : editorWidth * 100 + "%";
        }
        if (!Util.isEmpty(editorHeight) && editorHeight != 0) {
            this.customStyle.height = editorHeight > 1 ? editorHeight + "px" : editorHeight * 100 + "%";
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
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof IpAddressEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        return this.$createElement(this.editorComponentName,{
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                ipdata: this.value,
                disabled: this.disabled,
                context: this.context,
                formState: this.contextState,
                viewparams: this.viewparams,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur, focus:this.editorFocus },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}