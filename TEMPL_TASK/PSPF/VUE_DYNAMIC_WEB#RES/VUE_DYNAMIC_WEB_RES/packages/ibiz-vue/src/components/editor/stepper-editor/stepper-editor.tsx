import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 滑动输入条编辑器
 *
 * @export
 * @class StepperEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class StepperEditor extends EditorBase {

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof StepperEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.disabled) {
            param.disabled = this.handleBoolean(params.disabled);
        }
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.step) {
            param.step = this.handleNumber(params.step);
        }
        if (params.min) {
            param.min = this.handleNumber(params.min);
        }
        if (params.max) {
            param.max = this.handleNumber(params.max);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof StepperEditor
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
                ...this.handleParams(this.customProps)
            },
            on: { change: this.editorChange, enter: this.editorEnter, blur: this.editorBlur, focus:this.editorFocus },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}
