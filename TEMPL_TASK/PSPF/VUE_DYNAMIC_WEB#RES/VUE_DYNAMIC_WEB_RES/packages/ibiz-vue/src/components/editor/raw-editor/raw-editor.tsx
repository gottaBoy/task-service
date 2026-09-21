import { Util } from 'ibiz-core';
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';
/**
 * 直接内容编辑器
 *
 * @export
 * @class RawEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class RawEditor extends EditorBase {

    /**
     * 直接内容类型
     * 
     * @memberof RawEditor
     */
    public contentType: string = '';

    /**
     * 编辑器初始化
     *
     * @memberof RawEditor
     */
    public async initEditor() {
        await super.initEditor();
        this.contentType = this.editorInstance.editorParams?.['CONTENTTYPE'] || 'RAW';
        this.customProps.contentType = this.contentType;
    }

    /**
     * 设置编辑器参数
     *
     * @memberof RawEditor
     */
    public setEditorParams() {
        super.setEditorParams();
        if (this.customProps.TEMPLATE) {
            this.customProps.contentType = 'MARKDOWN';
        }
    }

    /**
     * 绘制直接内容的值
     * 
     * @memberof RawEditor
     */
    public getContentValue(value: any) {
        if (this.customProps.TEMPLATE) {
            return;
        }
        const data = this.contextData;
        let content = value;
        if (content && typeof content == 'string') {
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;', '<');
            content = content.replaceAll('&gt;', '>');
            content = content.replaceAll('&amp;nbsp;', ' ');
            content = content.replaceAll('&nbsp;', ' ');
        }
        return content;
    }

    /**
     * 处理自定义参数格式
     * 
     * @memberof RawEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.dividerParams) {
            if (typeof params.dividerParams === 'string') {
                let func = new Function('return (' + params.dividerParams + ');');
                param.dividerParams = func();
            }
        };
        if (params.videoParams) {
            if (typeof params.videoParams === 'string') {
                let func = new Function('return (' + params.videoParams + ');');
                param.videoParams = func();
            }
        };
        if (params.alertParams) {
            if (typeof params.alertParams === 'string') {
                let func = new Function('return (' + params.alertParams + ');');
                param.alertParams = func();
            }
        }
        return Object.assign(params, param);
    }

    /**
     * 编译模板
     *
     * @param {*} value
     * @return {*} 
     * @memberof RawEditor
     */
    public compileTemplate(value: any) {
        if (this.customProps.TEMPLATE) { 
            let curValue = value;
            try {
                if (Util.typeOf(value) === 'string') {
                    curValue = JSON.parse(curValue);
                }
            } catch (error) {
                this.$throw(error)
            }
            const template = this.customProps.TEMPLATE.replaceAll("//n",'\n')
            const templateResult = (window as any).Handlebars.compile(template);
            const result = templateResult(curValue);
            return result;
        } else {
            return value;
        }
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof RawEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        return this.$createElement(this.editorComponentName, {
            ref: 'editor',
            props: {
                content: this.getContentValue(this.value),
                imgUrl: this.value,
                itemValue: this.compileTemplate(this.value),
                ...this.handleParams(this.customProps),
            },
            class: this.dynaClass,
            style: this.customStyle,
        });
    }
}



