import { ModelTool, Util } from 'ibiz-core';
import { Component, Emit } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';
// import { AppCodeEditor } from 'ibiz-plugin';

/**
 * 代码编辑器
 *
 * @export
 * @class TextboxEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class CodeEditor extends EditorBase {
    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof EditorBase
     */
    @Emit('change')
    public editorChange(value: any): void { }

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof TextboxEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: this.editorInstance.name, value: $event });
    }

    /**
     * 编辑器enter事件
     *
     * @param {*} value
     * @memberof TextboxEditor
     */
    public handleEnter($event: any) {
        this.$emit('enter', arguments);
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof CodeEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readOnly) {
            param.readOnly = this.handleBoolean(params.readOnly);
        }
        if (params.changeLanguage) {
            param.changeLanguage = this.handleBoolean(params.changeLanguage);
        }
        if (params.LANGUAGE) {
            param.language = params.LANGUAGE;
        }
        if (params.showLanguage) {
            param.showLanguage = this.handleBoolean(params.showLanguage);
        }
        if (params.showLineNum) {
            param.showLineNum = this.handleBoolean(params.showLineNum);
        }
        if (params.showMinimap) {
            param.showMinimap = this.handleBoolean(params.showMinimap);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof TextboxEditor
     */
    public render(): any {
        if(!this.editorIsLoaded) {
            return null;
        }
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                ...this.handleParams(this.customProps),
            },
            on: {
                change: this.handleChange,
                enter: this.handleEnter,
                blur: this.editorBlur
            },
            class:this.dynaClass,
            style: this.customStyle,
        });
    }
}
