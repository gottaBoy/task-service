import { IPSAppCodeList, IPSAppDEField, IPSDropDownList } from '@ibiz/dynamic-model-api';
import { ModelTool, Util } from 'ibiz-core';
import { Component, Prop } from 'vue-property-decorator';
import { VueLifeCycleProcessing, Watch } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 下拉列表编辑器
 *
 * @export
 * @class DropdownListEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class DropdownListEditor extends EditorBase {

    /**
     * 编辑器模型
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() editorInstance!: IPSDropDownList;

    /**
     * 缓存UUID
     * 
     * @memberof EditorBase
     */
    public cacheUUID: any;

    /**
     * 编辑器初始化
     *
     * @memberof DropdownListEditor
     */
    public async initEditor() {
        await super.initEditor();
        const { placeHolder} = this.editorInstance;
        let appDEField: IPSAppDEField = this.parentItem?.getPSAppDEField?.();
        this.customProps.dataType = ModelTool.isNumberField(appDEField) ? 'number' : 'string';
        this.customProps.placeholder = placeHolder|| this.$t('components.dropdownlist.placeholder');
        switch (this.editorInstance?.editorType) {
            // 下拉列表框
            case 'DROPDOWNLIST':
                break;
            // 下拉列表框(100宽度)
            case 'DROPDOWNLIST_100':
                this.customStyle.width = '100px';
                break;
            // 下拉列表框(100宽度)
            case 'MDROPDOWNLIST':
                break;
            // 下拉列表框(corn表达式)
            case 'MDROPDOWNLIST_CRONEDITOR':
                break;
            // 下拉列表框(隐藏选项)
            case 'DROPDOWNLIST_HIDDEN':
                break;
            // 下拉列表框(多选穿梭框)
            case 'MDROPDOWNLIST_TRANSFER':
                break;
        }
        let codeList: any= this.editorInstance?.getPSAppCodeList();
        if(codeList && codeList.isFill) {
            Object.assign(this.customProps, {
                valueSeparator:codeList.valueSeparator,
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
     * @memberof DropdownListEditor
     */
    public handleChange($event: any){
        this.editorChange({name: this.editorInstance.name, value: $event})
    }

    /**
     * @description 处理自定义参数
     * @param {*} params
     * @return {*} 
     * @memberof DropdownListEditor
     */
    public handleParams(params: any) {
        const param: any = {};
        if (params.readonly) {
            param.readonly = this.handleBoolean(params.readonly);
        }
        if (params.multiple) {
            param.multiple = this.handleBoolean(params.multiple);
        }
        if (params.parent) {
            param.parent = this.handleBoolean(params.parent);
        }
        if (params.checkStrictly) {
            param.checkStrictly = this.handleBoolean(params.checkStrictly);
        }
        if (params.filterable) {
            param.filterable = this.handleBoolean(params.filterable);
        }
        if (params.clearable) {
            param.clearable = this.handleBoolean(params.clearable);
        }
        if (params.showAllLevels) {
            param.showAllLevels = this.handleBoolean(params.showAllLevels);
        }
        return Object.assign(params, param);
    }

    /**
     * 绘制下拉列表组件
     * 
     * @memberof DropdownListEditor
     */
    public renderDropdownList(){
        return this.$createElement(this.editorComponentName, {
            key: this.cacheUUID,
            ref: 'editor',
            props: {
                name: this.editorInstance.name,
                itemValue: this.value,
                disabled: this.disabled,
                data: this.contextData,
                context: this.context,
                viewparams: this.viewparams,
                formState: this.contextState,
                valueitem: this.parentItem && this.parentItem.valueItemName ? this.parentItem.valueItemName : (this.editorInstance as any).valueItemName ? (this.editorInstance as any).valueItemName : '',
                ...this.handleParams(this.customProps),
            },
            on: { formitemvaluechange: this.editorChange.bind(this), change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur.bind(this), click:this.editorClick.bind(this) },
            class:this.dynaClass,
            style: this.customStyle,
        });
    }

    /**
     * 绘制下拉列表(cron表达式)组件
     * 
     * @memberof DropdownListEditor
     */
    public renderDropdownCron(){
        return this.$createElement(this.editorComponentName, {
            props: {
              name: this.editorInstance.name,
              itemValue: this.value,
              disabled: this.disabled,
              data: this.contextData,
              context: this.context,
              viewparams: this.viewparams,
              formState: this.contextState,
              ...this.handleParams(this.customProps),
            },
            on: { change: this.handleChange, enter: this.editorEnter, blur: this.editorBlur },
            class:this.dynaClass,
        });
    }

    /**
     * 绘制下拉列表(多选穿梭框)组件
     * 
     * @memberof DropdownListEditor
     */
    public DropdownTransfer(){
        return this.$createElement(this.editorComponentName, {
            props: {
                disabled: this.disabled,
                ...this.handleParams(this.customProps),
            },
            class:this.dynaClass,
        });
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof DropdownListEditor
     */
    public render(): any {
        if(!this.editorIsLoaded) {
            return null;
        }
        if (!this.cacheUUID) {
            this.cacheUUID = Util.createUUID();
        }
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_'+style : ''}`;
        switch(editorTypeStyle){
            case 'MDROPDOWNLIST_CRONEDITOR':
                return this.renderDropdownCron();
            case 'DROPDOWNLIST':
            case 'DROPDOWNLIST_100':
            case 'DROPDOWNLIST_HIDDEN':
            case 'MDROPDOWNLIST_TRANSFER':
            case 'MDROPDOWNLIST':
            default:
                return this.renderDropdownList();
        }
    }
}
