import { IPSAppDEField, IPSCodeListEditor } from '@ibiz/dynamic-model-api';
import { DataTypes, ModelTool, Util } from 'ibiz-core';
import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 文本框编辑器
 *
 * @export
 * @class SpanEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class SpanEditor extends EditorBase {

    /**
     * 编辑器初始化
     *
     * @memberof SpanEditor
     */
    public async initEditor() {
        this.customProps.itemParam = {};
        this.customProps.context = this.context;
        this.customProps.viewparams = this.viewparams;
        this.customProps.isCache = false;
        // 父项转换为代码项文本为false时,显示原值模式为true
        if(this.parentItem && !this.parentItem.convertToCodeItemText){
            this.customProps.showSourceMode = true;
        }
        this.initFormatParams();
        this.initNumberParams();  
        // 处理代码表 
        let codeList: any = (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList();
        if(!codeList){
            return
        }
        if (!codeList?.isFill) {
            await codeList.fill()
        }
        Object.assign(this.customProps, {
            tag: codeList.codeName,
            codeList: codeList,
            codeListType: codeList.codeListType
        });      
    }

    /**
     * 解析标签值格式化参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */     
    public initFormatParams(){
        this.customProps.valueFormat = "";
        let unitName = this.parentItem?.unitName;
        let appDeField: IPSAppDEField= this.parentItem?.getPSAppDEField?.();
        if (appDeField?.stdDataType) {
            this.customProps.dataType = DataTypes.toString(appDeField.stdDataType);
        }
        if (appDeField?.valueFormat) {
            this.customProps.valueFormat = appDeField?.valueFormat;
        }
        if (this.valueFormat) {
          this.customProps.valueFormat = this.valueFormat;
        }
        if (this.editorInstance.editorParams?.valueFormat) {
          this.customProps.valueFormat = this.editorInstance.editorParams?.valueFormat;
        }
        if (unitName) {
            this.customProps.unitName = unitName;
        }
    }

    /**
     * 解析标签数值精度参数
     *
     * @return {*} 
     * @memberof SpanEditor
     */     
    public initNumberParams(){
        let appDeField: IPSAppDEField = this.parentItem?.getPSAppDEField?.();
        this.customProps.precision = ModelTool.getPrecision(this.editorInstance, appDeField);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof SpanEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return
        }
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_'+style : ''}`;        
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                data: JSON.stringify(this.contextData),
                editorType: editorTypeStyle,
                ...this.customProps,
            },
            key:Util.createUUID(),
            class:this.dynaClass,
            style: this.customStyle,
            on: { 
              change: this.editorChange,
              enter: this.editorEnter,
              leave: this.editorLeave
            }
        })
    }
}
