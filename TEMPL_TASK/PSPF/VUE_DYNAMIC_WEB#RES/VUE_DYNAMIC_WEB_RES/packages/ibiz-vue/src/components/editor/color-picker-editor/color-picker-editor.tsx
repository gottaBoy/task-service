import { IPSAppDEField } from '@ibiz/dynamic-model-api';
import { DataTypes, ModelTool, Util } from 'ibiz-core';
import { Component, Prop } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 颜色选择器编辑器
 *
 * @export
 * @class ColorPickerEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class ColorPickerEditor extends EditorBase {

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof ColorPickerEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: this.editorInstance.name, value: $event })
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof ColorPickerEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内置插件内容
     *
     * @returns {*}
     * @memberof ColorPickerEditor
     */
    public renderColorPicker() {
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
     * 绘制内容
     *
     * @returns {*}
     * @memberof ColorPickerEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        switch (editorTypeStyle) {
            case "COLORPICKER":
                return this.renderColorPicker();
        }
    }
}
