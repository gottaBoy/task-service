import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 数组编辑器
 *
 * @export
 * @class ArrayEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class ArrayEditor extends EditorBase {

    /**
     * 编辑器模型是否加载完成
     * 
     * @memberof ArrayEditor
     */
    public editorIsLoaded: boolean = false;

    /**
     * 编辑器初始化
     *
     * @memberof ArrayEditor
     */
    public async initEditor() {
        await super.initEditor();
        this.customProps.type = 'text';
        const dataType = this.editorInstance.M.dataType;
        if (dataType) {
            this.customProps.type = Object.is(dataType, 'NUMBER') || Object.is(dataType, 'INTEGER') ? 'number' : 'text';
            if (Object.is(this.customProps.type, 'number')) {
                this.customProps.editorType = 'default';
            }
        }
    }

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof ArrayEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: this.editorInstance.name, value: $event })
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof ArrayEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.disabled) {
            param.disabled = this.handleBoolean(params.disabled);
        }
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.limit) {
            param.limit = this.handleNumber(params.limit);
        }
        if (params.maxlength) {
            param.maxlength = this.handleNumber(params.maxlength);
        }
        if (params.showWordLimit) {
            param.showWordLimit = this.handleBoolean(params.showWordLimit);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof ArrayEditor
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
                rules: this.rules,
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur, focus: this.editorFocus },
            class: this.dynaClass,
            style: this.customStyle
        })
    }
}
