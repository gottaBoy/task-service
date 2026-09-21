import { Vue, Component, Prop, Watch, Model, Emit } from 'vue-property-decorator';
import ArrayEditor from './array-editor/array-editor';
import RawEditor from './raw-editor/raw-editor';
import RateEditor from './rate-editor/rate-editor';
import SliderEditor from './slider-editor/slider-editor';
import SpanEditor from './span-editor/span-editor';
import StepperEditor from './stepper-editor/stepper-editor';
import TextboxEditor from './textbox-editor/textbox-editor';
import AutocompleteEditor from './autocomplete-editor/autocomplete-editor';
import HtmlEditor from './html-editor/html-editor';
import UploadEditor from './upload-editor/upload-editor';
import CheckboxEditor from './checkbox-editor/checkbox-editor';
import DropdownListEditor from './dropdown-list-editor/dropdown-list-editor';
import DatePickerEditor from './date-picker-editor/date-picker-editor';
import DataPickerEditor from './data-picker-editor/data-picker-editor';
import SwitchEditor from './switch-editor/switch-editor';
import IpAddressEditor from './ipaddress-editor/ipaddress-editor';
import { IPSEditor } from '@ibiz/dynamic-model-api';
import CodeEditor from './code-editor/code-editor';
import MapPickerEditor from './map-picker-editor/map-picker-editor';
import DateRangeEditor from './date-range-editor/date-range-editor';
import NumberRangeEditor from './number-range-editor/number-range-editor';
import { AppServiceBase, LogUtil, Util } from 'ibiz-core';
import CascaderEditor from './cascader-editor/cascader-editor';
import ColorPickerEditor from './color-picker-editor/color-picker-editor';

/**
 * editor解析器
 *
 * @export
 * @class AppDefaultEditor
 * @extends {Vue}
 */
@Component({
    components: {
        'textbox-editor': TextboxEditor,
        'slider-editor': SliderEditor,
        'rate-editor': RateEditor,
        'raw-editor': RawEditor,
        'span-editor': SpanEditor,
        'stepper-editor': StepperEditor,
        'autocomplete-editor': AutocompleteEditor,
        'html-editor': HtmlEditor,
        'upload-editor': UploadEditor,
        'checkbox-editor': CheckboxEditor,
        'dropdown-list-editor': DropdownListEditor,
        'date-picker-editor': DatePickerEditor,
        'data-picker-editor': DataPickerEditor,
        'switch-editor': SwitchEditor,
        'ipaddress-editor': IpAddressEditor,
        'code-editor': CodeEditor,
        'map-picker-editor': MapPickerEditor,
        'array-editor': ArrayEditor,
        'date-range-editor': DateRangeEditor,
        'number-range-editor': NumberRangeEditor,
        'cascader-editor': CascaderEditor,
        'color-picker-editor': ColorPickerEditor,
    },
})
export class AppDefaultEditor extends Vue {

    /**
     * 编辑器值(支持双向绑定)
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Model('change') value!: any;

    /**
     * editor的实例
     *
     * @type {string}
     * @memberof AppDefaultEditor
     */
    @Prop() public editorInstance!: IPSEditor;

    /**
     * 外层部件容器模型
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() containerCtrl!: any;

    /**
     * 外层容器组件（主要用于视图布局面板）
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() containerComponent?: any;

    /**
     * 父级项模型（表单项，表格项）
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() parentItem!: any;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop() public viewparams!: any;

    /**
     * 上下文data数据(form里的data，表格里的row)
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop() public contextData?: any;

    /**
     * 是否禁用
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop({ default: false }) public disabled!: boolean;


    /**
     * 编辑器状态(表单里的formState)
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop() public contextState?: any;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    @Prop() public service?: any;

    /**
     * 是否忽略表单项值变化
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public ignorefieldvaluechange?: any

    /**
     * 是否开启行内预览
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public rowPreview?: any

    /**
     * 值格式化
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public valueFormat?: any

    /**
     * 是否防抖（数值输入框特有）
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public isDebounce?: boolean

    /**
     * 编辑器值规则
     *
     * @type {any[]}
     * @memberof AppDefaultEditor
     */
    @Prop() public rules?: any[];

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof AppDefaultEditor
     */
    @Emit('change')
    public editorChange(value: any): void { }

    /**
    * 编辑器change事件
    *
    * @param {*} value
    * @memberof AppDefaultEditor
    */
    @Emit('error')
    public error(value: any): void { }

    /**
     * 编辑器enter事件
     *
     * @memberof AppDefaultEditor
     */
    public editorEnter(event: any) {
        this.$emit('enter', event);
    }

    /**
     * 编辑器blur事件
     *
     * @memberof AppDefaultEditor
     */
    public editorBlur(event: any) {
        this.$emit('blur', event);
    }

    /**
     * 编辑器focus事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    public editorFocus(event: any): any {
        this.$emit('focus', event);
    }

    /**
     * 编辑器click事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    public editorClick(event: any): any {
        this.$emit('click', event);
    }

    /**
     * 编辑器解析器模型映射集合
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    public appDefaultEditorModels: Map<string, string[]> = new Map([
        ['autocomplete-editor', ['AC', 'AC_FS', 'AC_NOBUTTON', 'AC_FS_NOBUTTON']],
        ['raw-editor', ['RAW']],
        ['stepper-editor', ['STEPPER']],
        ['slider-editor', ['SLIDER']],
        ['switch-editor', ['SWITCH']],
        ['rate-editor', ['RATING']],
        ['html-editor', [
            'HTMLEDITOR',
            "HTMLEDITOR_INFO"
        ]],
        ['ipaddress-editor', ['IPADDRESSTEXTBOX']],
        ['span-editor', ['SPANEX', 'SPAN', 'SPAN_COLORSPAN']],
        ['upload-editor', [
            'FILEUPLOADER',
            'PICTURE',
            'PICTURE_ONE',
            'PICTURE_ONE_RAW',
            'FILEUPLOADER_DISK',
            'PICTURE_ROMATE',
            'PICTURE_DISKPIC',
            'FILEUPLOADER_DRAG',
            'PICTURE_INFO',
            'FILEUPLOADER_INFO',
            'FILEUPLOADER_CAMERA',
            'FILEUPLOADER_ONE',
            'FILEUPLOADER_USEWORKTEMP'
        ]],
        ['checkbox-editor', [
            'RADIOBUTTONLIST',
            'CHECKBOX',
            'CHECKBOXLIST',
            'LISTBOX',
            'LISTBOXPICKUP',
        ]],
        ['dropdown-list-editor', [
            'DROPDOWNLIST',
            'DROPDOWNLIST_100',
            'MDROPDOWNLIST',
            'MDROPDOWNLIST_CRONEDITOR',
            'DROPDOWNLIST_HIDDEN',
            'DROPDOWNLIST_CASCADER',
            'DROPDOWNLIST_TREESELECT',
            'MDROPDOWNLIST_TRANSFER'
        ]],
        ['textbox-editor', [
            'TEXTBOX',
            'PASSWORD',
            'TEXTAREA',
            'TEXTAREA_10',
            'MARKDOWN',
            'NUMBER',
            "TEXTBOX_COLORPICKER",
            'TEXTAREA_WFAPPROVAL',
            "TEXTAREA_WFAPPROVALTIMELINE",
            "TEXTAREA_WFAPPROVALEXTENDTIMELINE",
            "TEXTBOX_ICONPICKER"
        ]],
        ['date-picker-editor', [
            'DATEPICKEREX',
            'DATEPICKEREX_MINUTE',
            'DATEPICKEREX_SECOND',
            'DATEPICKEREX_NODAY',
            'DATEPICKEREX_NODAY_NOSECOND',
            'DATEPICKEREX_NOTIME',
            'DATEPICKEREX_HOUR',
            'DATEPICKER',
        ]],
        ['data-picker-editor', [
            'PICKEREX_LINKONLY',
            'PICKER',
            'PICKEREX_NOAC_LINK',
            'PICKEREX_TRIGGER_LINK',
            'PICKEREX_TRIGGER',
            'PICKEREX_NOAC',
            'PICKEREX_LINK',
            'PICKER_IMPORTABILITY',
            'PICKEREX_DROPDOWNVIEW',
            'PICKEREX_DROPDOWNVIEW_LINK',
            'PICKUPVIEW',
            'PICKEREX_NOBUTTON',
            'ADDRESSPICKUP',
            'ADDRESSPICKUP_AC',
            'ADDRESSPICKUP_IMPORTABILITY',
            'PICKER_ORGSELECT',
            'PICKER_ORGMULTIPLE',
            'PICKER_ALLORGSELECT',
            'PICKER_ALLORGMULTIPLE',
            'PICKER_ALLDEPTPERSONSELECT',
            'PICKER_ALLDEPTPERSONMULTIPLE',
            'PICKER_DEPTPERSONSELECT',
            'PICKER_DEPTPERSONMULTIPLE',
            'PICKER_ALLEMPSELECT',
            'PICKER_ALLEMPMULTIPLE',
            'PICKER_EMPSELECT',
            'PICKER_EMPMULTIPLE',
            'PICKER_ALLDEPATMENTSELECT',
            'PICKER_ALLDEPATMENTMULTIPLE',
            'PICKER_DEPATMENTSELECT',
            'PICKER_DEPATMENTMULTIPLE',
            'PICKER_COMMONMICROCOM',
        ]],
        ['code-editor', [
            'CODE',
        ]],
        ['map-picker-editor', [
            'MAPPICKER',
        ]],
        ['array-editor',[
            'ARRAY'
        ]],
        ['date-range-editor', [
            'DATERANGE',
            'DATERANGE_NOTIME'
        ]],
        ['number-range-editor', [
            'NUMBERRANGE',
        ]],
        ['cascader-editor', [
            'CASCADER'
        ]],
        ['color-picker-editor', [
            'COLORPICKER'
        ]],
    ]);

    /**
     * 预置类型编辑器
     *
     * @type {Map<string,string>}
     * @memberof AppDefaultEditor
     */
    public appPredefinedType: Map<string, string> = new Map([
        ['APP_APPTITLE', 'app-preset-title'],
        ['AUTH_USERID', 'app-preset-input'],
        ['AUTH_PASSWORD', 'app-preset-input'],
        ['VIEW_PAGECAPTION', 'app-preset-caption'],
        ['FIELD_TEXT_DYNAMIC', 'app-preset-rawitem'],
        ['FIELD_IMAGE', 'app-preset-rawitem'],
        ['FIELD_CAROUSEL', 'app-preset-rawitem'],
        ['AUTH_LOGINMSG', 'app-preset-loginmessage'],
        ['AUTH_VERIFICATIONCODE', 'app-preset-smsverification'],
        ['AUTH_ORGPICK', "app-preset-org-picker"],
        ['FIELD_SWITCH', "app-preset-switch"],
        ['FIELD_QRCODE', "app-preset-qrcode"],
        ['FIELD_CAROUSEL',"app-preset-carousel"]
    ])

    /**
     * 绘制未支持的编辑器类型
     *
     * @param {*} editor
     * @returns {*}
     * @memberof AppDynamicForm
     */
    public renderUnSupportEditorType(editor: any): any {
        return <div class='unsupport'>{`${this.$t('app.editor.unsupport')}${editor.editorType}`}</div>;
    }

    /**
     * 通过编辑器类型绘制编辑器
     *
     * @param {*} editor 编辑器实例对象
     * @returns {*}
     * @memberof AppDynamicForm
     */
    public renderByEditorType(editor: IPSEditor): any {
        if (!editor || !editor.editorType || editor.editorType == 'HIDDEN') {
            return;
        }
        let editorName: string = '';
        this.appDefaultEditorModels.forEach((editorTypes: any, key: string) => {
            if (editorTypes.indexOf(editor.editorType) > -1) {
                editorName = key;
            }
        });
        if (editorName || editor.editorType == 'USERCONTROL') {
            let editorComponentName = '';
            if (!editorName || editor.getPSSysPFPlugin()?.pluginCode) {
                editorComponentName = AppServiceBase.getInstance().getAppComponentService().getEditorComponents(editor.editorType, editor.editorStyle);
                if (!editorComponentName) {
                    LogUtil.warn(this.$t('app.editor.nofind'));
                    return;
                }
            } else {
                editorComponentName = editorName;
            }
            return this.$createElement(editorComponentName, {
                class: this.editorInstance?.getPSSysCss()?.cssName,
                ref: 'editor',
                props: {
                    editorInstance: editor,
                    containerCtrl: this.containerCtrl,
                    parentItem: this.parentItem,
                    context: this.context,
                    value: this.value,
                    rules: this.rules,
                    valueFormat: this.valueFormat,
                    viewparams: this.viewparams,
                    contextData: this.contextData,
                    isDebounce: this.isDebounce,
                    contextState: this.contextState,
                    service: this.service,
                    disabled: this.disabled,
                    ignorefieldvaluechange: this.ignorefieldvaluechange,
                    rowPreview: this.rowPreview,
                },
                on: {
                    change: this.editorChange,
                    enter: this.editorEnter,
                    blur: this.editorBlur,
                    focus:this.editorFocus,
                    click:this.editorClick,
                }
            });
        }
        return this.renderUnSupportEditorType(editor);
    }

    /**
     * 绘制预定义类型
     *
     * @param {IPSEditor} editor
     * @return {*}  {*}
     * @memberof AppDefaultEditor
     */
    public renderPredefinedType(editor: IPSEditor): any {
        let editorComponentName = this.appPredefinedType.get((editor as any).predefinedType);
        const renderMode = (editor as any).renderMode
        if (editorComponentName) {
            return this.$createElement(editorComponentName, {
                class: this.editorInstance?.getPSSysCss()?.cssName,
                key: Util.createUUID(),
                ref: 'editor',
                props: {
                    editorInstance: editor,
                    name: editor.name,
                    value: this.value,
                    contextData: this.contextData,
                    type: (editor as any).predefinedType,
                    containerType: this.containerComponent?.viewInstance?.viewType
                },
                on: {
                    valueChange: this.editorChange,
                    enter: this.editorEnter,
                    blur: this.editorBlur,
                    error: this.error,
                    focus:this.editorFocus,
                }
            }, [
                this.containerComponent?.renderViewCaption(renderMode)
            ]);
        }
        return this.renderUnSupportEditorType(editor);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppDynamicForm
     */
    public render(): any {
        if (this.editorInstance) {
            if (this.editorInstance.predefinedType) {
                let editorComponentName = this.appPredefinedType.get(this.editorInstance.predefinedType);
                if (editorComponentName) {
                    return this.renderPredefinedType(this.editorInstance);
                }else{
                    return this.renderByEditorType(this.editorInstance);
                }
            } else {
                return this.renderByEditorType(this.editorInstance);
            }
        } else {
            return this.$t('app.editor.noexist');
        }
    }
}