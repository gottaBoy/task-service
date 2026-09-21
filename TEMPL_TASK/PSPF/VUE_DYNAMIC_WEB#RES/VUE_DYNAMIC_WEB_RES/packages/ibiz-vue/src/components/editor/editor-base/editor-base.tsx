import { IPSCodeListEditor, IPSEditor } from '@ibiz/dynamic-model-api';
import { AppServiceBase, ModelTool, Util } from 'ibiz-core';
import { Vue, Prop, Emit } from 'vue-property-decorator';
import { Watch } from '../../../decorators/vue-lifecycleprocessing';

/**
 * editor解析器基类
 *
 * @export
 * @class EditorBase
 * @extends {Vue}
 */
export class EditorBase extends Vue {

    /**
     * 编辑器值
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() value!: any;

    /**
     * 编辑器模型
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() editorInstance!: IPSEditor;

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
     * 应用上下文
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() public viewparams!: any;

    /**
     * 上下文data数据(form里的data，表格里的row)
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop() public contextData?: any;

    /**
     * 是否禁用
     *
     * @type {*}
     * @memberof EditorBase
     */
    @Prop({default: false}) public disabled!: boolean;

    /**
     * 编辑器状态(表单里的formState)
     *
     * @type {*}
     * @memberof EditorBase
     */    
    @Prop() public contextState?: any;
    
    /**
     * 表单服务
     *
     * @type {*}
     * @memberof EditorBase
     */    
    @Prop() public service?: any;

    /**
     * 值格式化
     *
     * @type {boolean}
     * @memberof AppDefaultEditor
     */
    @Prop() public valueFormat?:any
    
    /**
     * 值规则
     *
     * @type {any[]}
     * @memberof EditorBase
     */
    @Prop() public rules?: any[];
    
    /**
     * 编辑器组件名称
     *
     * @type {*}
     * @memberof EditorBase
     */
    public editorComponentName!: string;

    /**
     * 动态样式表
     *
     * @type {*}
     * @memberof EditorBase
     */
    get dynaClass():any{
        if(this.editorInstance.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.contextData;
            return eval(this.editorInstance.dynaClass);
        }
        return {};
    }

    /**
     * 自定义样式的对象
     *
     * @type {*}
     * @memberof EditorBase
     */
    public customStyle: any = {};

    /**
     * 设置自定义props
     *
     * @type {*}
     * @memberof EditorBase
     */
    public customProps: any = {};

    /**
     * 编辑器是否初始化完成
     * 
     * @type {boolean}
     * @memberof EditorBase
     */
    public editorIsLoaded: boolean = false;
    
    /**
     * 编辑器change事件
     *
     * @param {*} value
     * @memberof EditorBase
     */
    @Emit('change')
    public editorChange(value: any): void {}

    /**
     * 编辑器blur事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    @Emit('blur')
    public editorBlur(event: any): any {
        return { name: this.editorInstance.name, value: this.value, event: event };
    }
    
    /**
     * 编辑器focus事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    @Emit('focus')
    public editorFocus(event: any): any {
        return { name: this.editorInstance.name, value: this.value, event: event };
    }

    /**
     * 编辑器enter事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    @Emit('enter')
    public editorEnter(event: any): any {
        return { name: this.editorInstance.name, value: this.value, event: event };
    }

    /**
     * 编辑器click事件
     *
     * @param {*} event
     * @memberof EditorBase
     */
    @Emit('click')
    public editorClick(event: any): any {
        return { name: this.editorInstance.name, value: this.value, event: event };
    }

    /**
     * 生命周期-created
     *
     * @memberof EditorBase
     */
    created() {}

    /**
     * editorJsonStr值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof EditorBase
     */
    @Watch('editorInstance', { immediate: true})
    public onEditorInstanceChange(newVal: any, oldVal: any) {
        if (newVal && newVal != oldVal) {
            this.initEditorBase();
        }
    }

    /**
     * 编辑器初始化(基类)
     *
     * @memberof EditorBase
     */
    public async initEditorBase() {
        this.editorChange = this.editorChange.bind(this);
        this.editorBlur = this.editorBlur.bind(this);
        this.editorEnter = this.editorEnter.bind(this);
        this.editorFocus = this.editorFocus.bind(this);
        this.editorComponentName = AppServiceBase.getInstance().getAppComponentService().getEditorComponents(this.editorInstance.editorType,this.editorInstance.editorStyle);
        this.setCustomStyle();
        this.setCustomProps();
        await this.initEditor();
        this.setEditorParams();
        this.valueTypeValidate();
        this.editorIsLoaded = true;
    }

    /**
     * 编辑器初始化
     *
     * @memberof EditorBase
     */
    public async initEditor() {
        try {
            // 加载编辑器实体
            await (this.editorInstance as any)?.getPSAppDataEntity?.()?.fill();
            // 加载编辑器代码表
            await (this.editorInstance as IPSCodeListEditor)?.getPSAppCodeList?.()?.fill();
        } catch (error) {
            console.error(error)
        }
    }

    /**
     * 设置编辑器的自定义高宽
     *
     * @memberof EditorBase
     */
    public setCustomStyle() {
        let { editorWidth, editorHeight } = this.editorInstance;
        this.customStyle = {};
        if (!Util.isEmpty(editorWidth) && editorWidth != 0) {
            this.customStyle.width = editorWidth > 1 ? editorWidth + "px" : editorWidth * 100 + "%";
        }
        if (!Util.isEmpty(editorHeight) && editorHeight != 0) {
            this.customStyle.height = editorHeight > 1 ? editorHeight + "px" : editorHeight * 100 + "%";
        }
    }

    /**
     * 设置编辑器的自定义参数
     * 
     * @memberof EditorBase
     */
    public setCustomProps() {
        this.customProps = {
            placeholder: this.editorInstance.placeHolder,
        };
        // 只读状态
        if (this.editorInstance.readOnly) {
            Object.assign(this.customProps, {
                readonly: this.editorInstance.readOnly,
            });
        }
        if (this.editorInstance.M.valueType) {
            Object.assign(this.customProps, {
                valueType: this.editorInstance.M.valueType
            })
        }
        if (this.editorInstance.M.valueSeparator) {
            Object.assign(this.customProps, {
                valueSeparator: this.editorInstance.M.valueSeparator
            })
        }
        if (this.editorInstance.M.textSeparator) {
            Object.assign(this.customProps, {
                textSeparator: this.editorInstance.M.textSeparator
            })
        }
        if (this.editorInstance.M.objectIdField) {
            Object.assign(this.customProps, {
                objectIdField: this.editorInstance.M.objectIdField.toLowerCase()
            })
        }
        if (this.editorInstance.M.objectNameField) {
            Object.assign(this.customProps, {
                objectNameField: this.editorInstance.M.objectNameField.toLowerCase()
            })
        }
        if (this.editorInstance.M.objectValueField) {
            Object.assign(this.customProps, {
                objectValueField: this.editorInstance.M.objectValueField.toLowerCase()
            })
        }
    }

    /**
     * 设置编辑器导航参数
     * 
     * @param keys 编辑器参数key
     * @memberof EditorBase
     */
    public setEditorParams() {
        let _this = this;
        if(!this.editorInstance.editorParams){
            return 
        }
        Object.assign(this.customProps, {
            localContext: ModelTool.getNavigateContext(this.editorInstance),
            localParam: ModelTool.getNavigateParams(this.editorInstance)
        });
        for (const key in this.editorInstance.editorParams) {
            let param: any;
            if (key == 'uploadparams' || key == 'exportparams' || key == 'readonly') {
                param = eval('(' + this.editorInstance.editorParams[key] + ')');
            }else {
                param = this.editorInstance.editorParams[key];
            }
            if(key.indexOf('.') != -1) {
                let splitArr: Array<any> = key.split('.');
                switch (splitArr[0]) {
                    case "SRFNAVPARAM":
                        Object.assign(this.customProps.localParam, { [splitArr[1]]: param });
                        break;
                    case "SRFNAVCTX":
                        Object.assign(this.customProps.localContext, { [splitArr[1]]: param });
                        break;
                }
            } else {
                if(param) {
                    this.customProps[key] = param;
                }
            }
        }
    }

    /**
     * 值类型校验
     *
     * @memberof EditorBase
     */
    public valueTypeValidate(): boolean {
        const valueType = this.customProps['VALUETYPE'];
        const editorType = this.editorInstance.editorType;
        const editorStyle = this.editorInstance.editorStyle;
        let result: boolean = true;
        if (!valueType) {
            return result;
        }
        switch (editorType) {
            case 'CHECKBOX': // 选项框
            case 'DATEPICKEREX': // 时间选择器（旧）
            case 'DATEPICKEREX_NOTIME': // 时间选择器（YYYY-MM-DD）
            case 'DATEPICKER': // 时间选择器
            case 'DATEPICKEREX_HOUR': // 时间选择器（YYYY-MM-DD HH）
            case 'DATEPICKEREX_MINUTE': // 时间选择器（YYYY-MM-DD HH:mm）
            case 'DATEPICKEREX_SECOND': // 时间选择器（YYYY-MM-DD HH:mm:ss）
            case 'DATEPICKEREX_NODAY': // 时间选择器（HH:mm:ss）
            case 'DATEPICKEREX_NODAY_NOSECOND': // 时间选择器（HH:mm）
            case 'DATEPICKEREX_NOSECOND': // 时间选择器（YYYY-MM-DD HH:mm）
            case 'TEXTBOX': // 文本框
            case 'NUMBER': // 数值框
            case 'PASSWORD': // 密码框
            case 'TEXTAREA': // 多行输入框
            case 'TEXTAREA_10': // 多行输入框（10行）
            case "HTMLEDITOR": // HTML编辑框
            case "SPAN_COLORSPAN": // 颜色文字
            case "SPAN_AFTERTIME": // 多久之前
            case "SPAN_ADDRESSPICKUP": // 地址栏信息数据
            case "SLIDER_PROGRESS": // 进度条
            case "MAPPICKER": // 地图选择器
            case 'MARKDOWN': // Markdown编辑框
            case 'RADIOBUTTONLIST': // 单选项列表
            case 'RAW': // 直接内容
            case 'RATING': // 评分器
            case 'SPAN': // 标签
            case 'SPAN_TITLE': // 标签扩展样式
            case 'STEPPER': // 步进器
            case 'SWITCH': // 开关部件
            case 'IPADDRESSTEXTBOX': // IP地址输入框
            case 'DROPDOWNLIST': // 下拉列表框
            case 'DROPDOWNLIST_TREESELECT': // 下拉树
            case 'DROPDOWNLIST_CASCADER': // 下拉级联选择
            case 'MDROPDOWNLIST_TREESELECT':// 下拉树选择（多选）
            case 'MDROPDOWNLIST_CASCADER': // 下拉级联选择（多选）
            case 'MDROPDOWNLIST': // 下拉列表框（多选）
            case 'DROPDOWNLIST_100': // 下拉列表框（100宽度）
            case "NUMBERRANGE": // 数值范围编辑框
            case "DATERANGE": // 时间范围选择器
            case "DATERANGE_NOTIME": // 时间范围选择器（YYYY-MM-DD）
            case 'AC': // 自动填充
            case 'AC_FS': // 自动填充（只能选择）
            case 'AC_NOBUTTON': // 自动填充（无按钮）
            case 'AC_FS_NOBUTTON': // 自动填充（只能选择、无按钮）
            case 'CASCADER': // 级联选择 暂不支持
            case 'CASCADER_TREESELECT': // 级联选择树 暂不支持
                // 自定义数据源下拉树
                if (editorStyle == 'TREEDROPDOWNLIST') {
                    if (!(valueType === 'SIMPLE' || valueType === 'SIMPLES' || valueType === 'OBJECT' || valueType === 'OBJECTS')) {
                        console.error(`${editorType}类型编辑器不支持非SIMPLE、SIMPLES、OBJECT、OBJECTS数据类型`);
                        result = false;
                    }
                } else if (valueType !== 'SIMPLE') {
                    console.error(`${editorType}类型编辑器不支持非SIMPLE数据类型`);
                    result = false;
                }
                break;
            case "ARRAY": //数组编辑器
                if (valueType !== 'SIMPLES') {
                    console.error(`${editorType}类型编辑器不支持非SIMPLES数据类型`);
                    result = false;
                }
                break;
            case 'SLIDER': // 滑动输入条
            case 'CHECKBOXLIST': // 选项框列表
            case 'LISTBOXPICKUP': // 列表框（选择）
            case 'LISTBOX': // 列表框
                if (!(valueType === 'SIMPLE' || valueType === 'SIMPLES')) {
                    console.error(`${editorType}类型编辑器不支持非SIMPLE、SIMPLES数据类型`);
                    result = false;
                }
                break;
            case "PICTURE_ONE": // 图片控件（单项）
            case "PICTURE_ONE_RAW": // 图片控件（单项、直接内容）
            case 'FILEUPLOADER_ONE': // 文件控件（单项）
            case 'FILEUPLOADER': // 文件控件
            case 'PICTURE': // 图片控件
                if (!(valueType === 'SIMPLE' || valueType === 'OBJECT' || valueType === 'OBJECTS')) {
                    console.error(`${editorType}类型编辑器不支持非SIMPLE、OBJECT、OBJECTS数据类型`);
                    result = false;
                }
                break;
            case "DROPDOWNLIST_TREEDROPDOWNLIST": // 自定义数据源下拉树
            case 'PICKEREX_LINKONLY': // 数据链接
            case "PICKUPVIEW": // 数据选择（嵌入选择视图）
            case "PICKEREX_DROPDOWNVIEW": // 数据选择（下拉视图）
            case "PICKEREX_DROPDOWNVIEW_LINK": // 数据选择（下拉视图、数据链接）
            case "PICKER_ORGSELECT": // 单位选择 暂不支持
            case "PICKER_ORGMULTIPLE":// 单位选择 暂不支持
            case "PICKER_ALLORGSELECT":// 单位选择 暂不支持
            case "PICKER_ALLORGMULTIPLE":// 单位选择 暂不支持
            case "PICKER_ALLDEPATMENTSELECT": // 部门选择 暂不支持
            case "PICKER_ALLDEPATMENTMULTIPLE":// 部门选择 暂不支持
            case "PICKER_DEPATMENTSELECT":// 部门选择 暂不支持
            case "PICKER_DEPATMENTMULTIPLE":// 部门选择 暂不支持
            case "PICKER_ALLDEPTPERSONSELECT": // 人员选择-部门 暂不支持
            case "PICKER_ALLDEPTPERSONMULTIPLE":// 人员选择-部门 暂不支持
            case "PICKER_DEPTPERSONSELECT":// 人员选择-部门 暂不支持
            case "PICKER_DEPTPERSONMULTIPLE":// 人员选择-部门 暂不支持
            case "PICKER_ALLEMPSELECT": // 人员选择- 单位 暂不支持
            case "PICKER_ALLEMPMULTIPLE":// 人员选择- 单位 暂不支持
            case "PICKER_EMPSELECT":// 人员选择- 单位 暂不支持
            case "PICKER_EMPMULTIPLE":// 人员选择- 单位 暂不支持
            case 'PICKER': // 数据选择
            case 'PICKEREX_NOBUTTON': // 数据选择（无按钮）
            case 'PICKEREX_NOAC_LINK': // 数据选择（无AC、数据链接）
            case 'PICKEREX_TRIGGER_LINK':// 数据选择（下拉、数据链接）
            case 'PICKEREX_TRIGGER': // 数据选择（下拉）
            case 'PICKEREX_NOAC': // 数据选择（无AC）
            case 'PICKEREX_LINK': // 数据选择（数据链接）
                if (!(valueType === 'SIMPLE' || valueType === 'SIMPLES' || valueType === 'OBJECT' || valueType === 'OBJECTS')) {
                    console.error(`${editorType}类型编辑器不支持非SIMPLE、SIMPLES、OBJECT、OBJECTS数据类型`);
                    result = false;
                }
                break;
            case 'ADDRESSPICKUP': // 地址框（选择）
            case 'ADDRESSPICKUP_AC': // 地址框（支持选择、AC）
                if (!(valueType === 'SIMPLE' || valueType === 'OBJECTS')) {
                    console.error(`${editorType}类型编辑器不支持非SIMPLE、OBJECTS数据类型`);
                    result = false;
                }
                break;
        }
        return result;
    }

    /**
     * @description 处理boolean
     * @param {string} value
     * @return {*} 
     * @memberof EditorBase
     */
    public handleBoolean(value: string) {
        return Object.is("string", typeof (value)) ? Object.is("true", value) ? true : false : value;
    }

    /**
     * @description 处理number
     * @param {string} value
     * @return {*} 
     * @memberof EditorBase
     */
    public handleNumber(value: string) {
        return Object.is("string", typeof (value)) ? +value : value;
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof EditorBase
     */
    public render(): any {
        return <div>{this.editorInstance ? this.$t('app.editor.nooutput') : this.$t('app.editor.noexist')}</div>;
    }
}
