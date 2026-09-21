import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 开关控件编辑器
 *
 * @export
 * @class SwitchEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class SwitchEditor extends EditorBase {

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof SwitchEditor
     */
    public handleChange($event: any){
        this.editorChange({name: this.editorInstance.name, value: $event})
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof SwitchEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if(params.dicData){
            if(typeof params.dicData === 'string'){
                let func = new Function('return (' + params.dicData + ');');
                param.dicData  = func();
            }
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof SwitchEditor
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
                disabled: this.disabled,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}
