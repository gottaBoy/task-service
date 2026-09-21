import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
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
     * 编辑器初始化
     *
     * @memberof TextboxEditor
     */
    public async initEditor() {
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        if(editorTypeStyle == 'MOBNUMBER_POSITIVENUMBER'){
            this.customProps.min = "0";
        }
        switch (type) {
            case 'TEXTBOX':
                this.customProps.type = 'text';
                break;
            case 'MOBPASSWORD':
            case 'PASSWORD':
                this.customProps.type = 'password';
                break;
            case 'TEXTAREA':
                this.customProps.type = 'textarea';
                break;
            case 'MOBNUMBER':
            case 'NUMBER':
                this.customProps.type = 'number';
                break;
        }
    }

    /**
     * 绘制默认内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public renderTextbox() {
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                ...this.customProps,
            },
            on: { 
              change: this.editorChange,
              enter: this.editorEnter,
              leave: this.editorLeave           
            },
            class:this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制内置插件内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public renderTextboxArea() {
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                data: this.contextData,
				disabled: this.disabled,
                ...this.customProps,
            },
            on: { 
              change: this.editorChange, 
              enter: this.editorEnter,
              leave: this.editorLeave,             
              colorChange: ($event: any) => { this.editorChange($event) } 
            },
            class:this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制工作流审批意见控件内容
     *
     * @returns {*}
     * @memberof TextareaEditor
     */
    public renderWfapproval() {
        return this.$createElement(this.editorComponentName, {
            props: {
                value: this.value,
				disabled: this.disabled,
                ...this.customProps,
            },
            on: { change: this.editorChange },
            class:this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制工作流审批意见控件时光轴格式内容
     *
     * @returns {*}
     * @memberof TextareaEditor
     */
    public renderWfapprovalTimeline() {
        return this.$createElement(this.editorComponentName, {
            props: {
                ...this.customProps,
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
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        switch (editorTypeStyle) {
            case "MOBTEXT":
            case "MOBPASSWORD":
            case "MOBNUMBER":
            case "MOBNUMBER_POSITIVENUMBER":
                return this.renderTextbox();
            case "MOBTEXTAREA":
                return this.renderTextboxArea();
            case "TEXTAREA_WFAPPROVAL":
                return this.renderWfapproval();
            case "TEXTAREA_WFAPPROVALTIMELINE":
                return this.renderWfapprovalTimeline();
                default:
                    return this.renderTextbox();
        }
    }
}
