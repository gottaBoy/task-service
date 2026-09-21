import { Vue, Component, Prop, Watch, Model, Emit } from 'vue-property-decorator';
import RateEditor from './rate-editor/rate-editor';
import SliderEditor from './slider-editor/slider-editor';
import SpanEditor from './span-editor/span-editor';
import StepperEditor from './stepper-editor/stepper-editor';
import TextboxEditor from './textbox-editor/textbox-editor';
import HtmlEditor from './html-editor/html-editor';
import UploadEditor from './upload-editor/upload-editor';
import CheckboxEditor from './checkbox-editor/checkbox-editor';
import DropdownListEditor from './dropdown-list-editor/dropdown-list-editor';
import DatePickerEditor from './date-picker-editor/date-picker-editor';
import DataPickerEditor from './data-picker-editor/data-picker-editor';
import SwitchEditor from './switch-editor/switch-editor';
import { IPSEditor } from '@ibiz/dynamic-model-api';
import { AppServiceBase } from 'ibiz-core';


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
        'span-editor': SpanEditor,
        'stepper-editor': StepperEditor,
        'html-editor': HtmlEditor,
        'upload-editor': UploadEditor,
        'checkbox-editor': CheckboxEditor,
        'dropdown-list-editor': DropdownListEditor,
        'date-picker-editor': DatePickerEditor,
        'data-picker-editor': DataPickerEditor,
        'switch-editor': SwitchEditor,
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
     * 父级项模型（表单项，表格项）
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() parentItem!: any;

    /**
     * 外层容器组件（主要用于视图布局面板）
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() containerComponent?: any;

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
     * 值格式化
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public valueFormat?: any

    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof AppDefaultEditor
     */
    @Emit('change')
    public editorChange(value: any): void { }

    /**
     * 编辑器focus事件
     *
     * @param {*} value
     * @memberof AppDefaultEditor
     */
    @Emit('enter')
    public editorEnter(value: any): void { }

    /**
     * 编辑器blur事件
     *
     * @param {*} value
     * @memberof AppDefaultEditor
     */
    @Emit('leave')
    public editorLeave(value: any): void { }

    /**
     * 编辑器error事件
     *
     * @param {*} value
     * @memberof AppDefaultEditor
     */
    @Emit('error')
    public error(value: any): void { }

    /**
     * 编辑器解析器模型映射集合
     *
     * @type {*}
     * @memberof AppDefaultEditor
     */
    public AppDefaultEditorModels: Map<string, string[]> = new Map([
        ['stepper-editor', ['MOBSTEPPER','STEPPER']],
        ['slider-editor', ['MOBSLIDER','SLIDER']],
        ['switch-editor', ['MOBSWITCH','SWITCH']],
        ['rate-editor', ['MOBRATING','RATING']],
        ['html-editor', [
            'MOBHTMLTEXT'
        ]],
        ['span-editor', ['SPAN']],
        ['upload-editor', [
            'MOBMULTIFILEUPLOAD',
            'MOBSINGLEFILEUPLOAD',
            'MOBPICTURE',
            'MOBPICTURELIST',
            'MULTIFILEUPLOAD',
            'SINGLEFILEUPLOAD',
            'PICTURE',
            'PICTURELIST',
            'FILEUPLOADER'
        ]],
        ['checkbox-editor', [
            'MOBRADIOLIST',
            'RADIOLIST',
            'RADIOBUTTONLIST',
        ]],
        ['dropdown-list-editor', [
            'MOBDROPDOWNLIST',
            'MOBCHECKLIST',
            'DROPDOWNLIST',
            'CHECKLIST',
            'MDROPDOWNLIST'
        ]],
        ['textbox-editor', [
            'MOBTEXT',
            'MOBTEXTAREA',
            'MOBPASSWORD',
            'MOBNUMBER',
            'TEXTBOX',
            'TEXTAREA',
            'PASSWORD',
            'NUMBER'
        ]],
        ['date-picker-editor', [
            'MOBDATE',
            'DATE',
            'DATEPICKER'
        ]],
        ['data-picker-editor', [
            'MOBPICKER',
            'MOBMPICKER',
            'MOBPICKER_DROPDOWNVIEW',
            'PICKER',
            'MPICKER',
            'PICKER_DROPDOWNVIEW'
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
        ['AUTH_ORGPICK', "app-preset-mob-org-picker"],
        ['FIELD_SWITCH', "app-preset-switch"],
        ['FIELD_QRCODE', "app-preset-qrcode"],
        ['FIELD_CAROUSEL', "app-preset-mob-carousel"]
    ])

    /**
     * 绘制未支持的编辑器类型
     *
     * @param {*} editor
     * @returns {*}
     * @memberof AppDynamicForm
     */
    public renderUnSupportEditorType(editor: any): any {
        return <div class='unsupport'>{`暂未支持编辑器型为${editor.editorType}`}</div>;
    }

    /**
     * 通过编辑器类型绘制编辑器
     *
     * @param {*} editor 编辑器实例对象
     * @returns {*}
     * @memberof AppDynamicForm
     */
    public renderByEditorType(editor: any): any {
        if (!editor || !editor.editorType || editor.editorType == 'HIDDEN') {
            return;
        }
        let editorName: string = '';
        let isPresetEditor: boolean = false;
        this.AppDefaultEditorModels.forEach((editorTypes: any, key: string) => {
            if (editorTypes.indexOf(editor.editorType) > -1) {
                editorName = key;
            }
            if (editorTypes.indexOf(`${editor.editorType}_${editor.editorStyle ? editor.editorStyle : 'DEFAULT'}`) > -1) {
                isPresetEditor = true;
            }
        });
        if (editorName || editor.editorType == 'USERCONTROL') {
            let editorComponentName = '';
            if (!editorName || editor.getPSSysPFPlugin()?.pluginCode) {
                editorComponentName = AppServiceBase.getInstance().getAppComponentService().getEditorComponents(editor.editorType, editor.editorStyle);
                if (!editorComponentName) {
                    console.warn("目标编辑器查找不到");
                    return;
                }
            } else {
                editorComponentName = editorName;
            }
            return this.$createElement(editorComponentName, {
                props: {
                    editorInstance: editor,
                    context: this.context,
                    value: this.value,
                    valueFormat: this.valueFormat,
                    containerCtrl: this.containerCtrl,
                    viewparams: this.viewparams,
                    contextData: this.contextData,
                    parentItem: this.parentItem,
                    contextState: this.contextState,
                    service: this.service,
                    disabled: this.disabled,
                    ignorefieldvaluechange: this.ignorefieldvaluechange,
                },
                on: {
                    change: this.editorChange,
                    enter: this.editorEnter,
                    leave: this.editorLeave,
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
        const renderMode = (editor as any).renderMode;
        if (editorComponentName) {
            return this.$createElement(editorComponentName, {
                class: this.editorInstance?.getPSSysCss()?.cssName,
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
                    leave: this.editorLeave,
                    error: this.error,
                }
            }, [
                this.containerComponent?.renderViewCaption?.(renderMode)
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
        const type = (this.editorInstance as any).predefinedType;
        if (this.editorInstance) {
            if ((this.editorInstance as any).predefinedType && !Object.is('FIELD_TEXTBOX', type)) {
                return this.renderPredefinedType(this.editorInstance);
            } else {
                return this.renderByEditorType(this.editorInstance);
            }
        } else {
            return 'editor实例不存在！';
        }
    }
}