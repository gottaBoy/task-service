import { IPSCodeListEditor } from '@ibiz/dynamic-model-api';
import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 评分器编辑器
 *
 * @export
 * @class RateEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class RateEditor extends EditorBase {

    /**
     * 编辑器模型是否加载完成
     * 
     * @memberof RateEditor
     */
    public editorIsLoaded: boolean = false;

    /**
     * 编辑器初始化
     *
     * @memberof RateEditor
     */
    public async initEditor() {
        await super.initEditor();
        let codeList: any = (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList?.();
        if (this.editorInstance.editorParams?.['MAXVALUE']) {
            Object.assign(this.customProps, {
                max: !isNaN(Number(this.editorInstance.editorParams?.['MAXVALUE'])) ? Number(this.editorInstance.editorParams?.['MAXVALUE']) : 5,
            });
        }
        if (codeList) {
            Object.assign(this.customProps, {
                tag: codeList.codeName,
                codeList: codeList,
                codelistType: codeList.codeListType
            });
        }
    }

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof RateEditor
     */
    public handleChange($event: any) {
        this.editorChange({ name: this.editorInstance.name, value: $event })
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof RateEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.disabled) {
            param.disabled = this.handleBoolean(params.disabled);
        }
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.max) {
            param.max = this.handleNumber(params.max);
        }
        if(params.texts){
            if(typeof params.texts === 'string'){
                let func = new Function('return (' + params.texts + ');');
                param.texts  = func();
            }
        }
        if(params.colors){
            if(typeof params.colors === 'string'){
                let func = new Function('return (' + params.colors + ');');
                param.colors  = func();
            }
        }
        if(params.showText){
            param.showText = this.handleBoolean(params.showText);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof RateEditor
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
                ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur },
            class:this.dynaClass,
            style: this.customStyle
        })
    }
}
