import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import {
    IPSDEFormDetail,
    IPSDEFormItem,
    IPSDEFormMDCtrl,
    IPSGridLayoutPos,
    IPSFlexLayout,
    IPSFlexLayoutPos,
    IPSDEEditFormItem,
    IPSDEFDCatGroupLogic,
    IPSDEFDLogic,
    IPSDEFDSingleLogic,
    IPSCodeListEditor,
    IPSDEFormItemVR,
    IPSDEFormItemEx,
    IPSDEFormButton,
    IPSDEFormRawItem,
    IPSAppDEUIAction,
} from '@ibiz/dynamic-model-api';
import { AppDefaultFormItem } from '../app-default-form-item/app-default-form-item';
import { Subject, Subscription } from 'rxjs';
import { AppServiceBase, dynamicMatch, FormButtonModel, FormItemModel, FormMDControlModel, FormRawItemModel, LayoutTool, ModelTool, Util, Verify } from 'ibiz-core';
import moment from 'moment';
@Component({
    components: {
        AppDefaultFormItem,
    },
})
export class AppDefaultFormMdCtrlRepeater extends Vue {
    /**
     * 模型实例
     *
     * @type {IPSDEFormMDCtrl}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() detailInstance!: IPSDEFormMDCtrl;

    /**
     * 下标
     *
     * @type {number}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop({ default: 0 }) public level!: number;

    /**
     * 数据
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop()
    public parentData: any;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() public service: any;

    /**
     * 表单模型对象
     *
     * @type {any}
     * @memberof AppDefaultFormDetail
     */
    @Prop() public controlInstance!: any;

    /**
     * 父数据监听变化
     *
     * @param {*} newVal
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Watch('parentData', { immediate: true, deep: true })
    public handleParentDataChange(newVal: any) {
        if (!this.dataItemName) {
            this.init();
            this.initDetails();
        }
        const items = newVal[this.dataItemName] ? this.mode === 'STYLE3' ? [newVal[this.dataItemName]] : newVal[this.dataItemName] : [];
        this.initChildrenDetailModel(items);
        this.data = items;
        // 1:1表单无值时默认展开一个空表单
        if (this.mode === 'STYLE3' && this.data.length === 0) {
            this.handleAdd();
        }
    }

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() public viewparams: any;

    /**
     * 项模型集合
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() public detailsModel: any;

    /**
     * 表单状态通知对象
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop() public contextState!: Subject<any>;

    /**
     * 是否展示标题
     *
     * @type {boolean}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    @Prop({ default: true }) public showCaption?: boolean;

    /**
     * 模式
     *
     * @type {string}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public mode: 'DEFAULT' | 'STYLE2' | 'STYLE3' | string = 'DEFAULT';

    /**
     * 数据项标识
     *
     * @type {string}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public dataItemName: string = '';

    /**
     * 当前重复器数据
     *
     * @type {any[]}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public data: any[] = [];

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppDefaultFormMdCtrl
     */
    public contextStateEvent: Subscription | undefined;

    /**
     * 子成员模型
     *
     * @type {IPSDEFormItem[]}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public details: IPSDEFormItem[] = [];

    /**
     * 运行时重复器成员模型
     *
     * @type {any[]}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public childrenDetailModel: any[] = [];

    /**
     * 是否初始化完成
     *
     * @type {boolean}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public inited: boolean = false;

    /**
     * 值规则
     *
     * @type {any[]}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public rules: any[] = [];

    /**
     * Vue生命周期 --- created
     *
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    created() {
        this.initDetails();
        if (this.contextState) {
            this.init();
            this.contextStateEvent = this.contextState.subscribe((event: any) => {
                if (Object.is(event.type, 'load')) {
                    this.updateDefault();
                }
            })
        }
    }

    /**
     * 初始化运行时重复器子成员模型
     *
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    initChildrenDetailModel(items: any[]) {
        this.childrenDetailModel = [];
        this.rules = [];
        if (items?.length > 0) {
            items.forEach((item: any, index: number) => {
                this.$set(this.childrenDetailModel, index, this.getRepeaterDetailsModel())
                this.fillData(item)
                this.repeaterDynamicLogic('', index, item);
            })
        }
        this.inited = true;
    }

    /**
     * 填充数据
     *
     * @param {*} item
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    fillData(item: any) {
        this.details.forEach((detail: IPSDEFormItem) => {
            const name = this.getDataItemName(detail);
            if (!item.hasOwnProperty(name)) {
                Object.assign(item, { [name]: detail.detailType === 'MDCTRL' ? [] : null });
            }
        })
    }

    /**
     * 获取重复器成员模型
     *
     * @return {*} 
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    getRepeaterDetailsModel() {
        const detailsModel = {};
        this.details.forEach((detail: IPSDEFormDetail) => {
            const isShowMore = detail.showMoreMode == 1;
            const detailOpts: any = {
                name: detail.name,
                parentModel: detail.getParentPSModelObject() as IPSDEFormDetail,
                caption: detail.caption,
                isShowCaption: detail.showCaption,
                detailType: detail.detailType,
                visible: !ModelTool.findGroupLogicByLogicCat('PANELVISIBLE', detail.getPSDEFDGroupLogics()) && !isShowMore,
                disabled: ModelTool.findGroupLogicByLogicCat('ITEMENABLE', detail.getPSDEFDGroupLogics()),
                form: this,
                isControlledContent: isShowMore,
            };
            let detailModel: any = null;
            switch (detail.detailType) {
                case 'FORMITEM':
                    Object.assign(detailOpts, {
                        required: !(detail as IPSDEFormItem).allowEmpty,
                        enableCond: (detail as IPSDEFormItem).enableCond,
                        ignoreInput: (detail as IPSDEFormItem).ignoreInput,
                        captionItemName: (detail as IPSDEFormItem).captionItemName,
                        convertToCodeItemText: (detail as IPSDEFormItem).convertToCodeItemText ? true : false,
                    });
                    if ((detail as IPSDEFormItem).getPSEditor() && ((detail as IPSDEFormItem).getPSEditor() as IPSCodeListEditor).getPSAppCodeList instanceof Function) {
                        Object.assign(detailOpts, {
                            codelist: ((detail as IPSDEFormItem).getPSEditor() as IPSCodeListEditor).getPSAppCodeList()
                        });
                    }
                    detailModel = new FormItemModel(detailOpts);
                    break;
                case 'MDCTRL':
                    detailModel = new FormMDControlModel(detailOpts);
                    break;
                case 'BUTTON':
                    Object.assign(detailOpts, {
                        disabled: false,
                    });
                    const uiAction = (detail as IPSDEFormButton).getPSUIAction?.();
                    if (uiAction) {
                        detailOpts.uiaction = {
                            type: uiAction.uIActionType,
                            tag: uiAction.uIActionTag,
                            visabled: true,
                            disabled: false,
                        }
                        if (uiAction.actionTarget) {
                            detailOpts.uiaction.actiontarget = uiAction.actionTarget;
                        }
                        if ((uiAction as IPSAppDEUIAction).noPrivDisplayMode) {
                            detailOpts.uiaction.noprivdisplaymode = (uiAction as IPSAppDEUIAction).noPrivDisplayMode;
                        }
                        if (uiAction.dataAccessAction) {
                            detailOpts.uiaction.dataaccaction = uiAction.dataAccessAction;
                            if (AppServiceBase.getInstance().getAppEnvironment().enablePermissionValid) {
                                detailOpts.visible = false;
                            }
                        }
                    }
                    detailModel = new FormButtonModel(detailOpts);
                    break;
                case 'RAWITEM':
                    detailModel = new FormRawItemModel(detailOpts);
            }
            this.$set(detailsModel, detail.name, detailModel)
        })
        this.rules.push(
            this.getValueRules()
        )
        return detailsModel
    }

    /**
     * 获取值规则
     *
     * @param {number} index
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public getValueRules() {
        let valueRules: any = {};
        const allFormItemVRs = this.controlInstance.getPSDEFormItemVRs() as IPSDEFormItemVR[];
        this.details.forEach((detail: IPSDEEditFormItem) => {
            // 初始化非空值规则和数据类型值规则
            valueRules[detail.name] = []
            if (detail.detailType == 'FORMITEM' && detail.getPSEditor()?.editorType != 'HIDDEN') {
                if (detail.compositeItem) {
                    // 复合表单项值规则
                    if (detail.getPSEditor()?.editorType == 'DATEPICKER') {
                        const formItems = (detail as IPSDEFormItemEx).getPSDEFormItems();
                        if (formItems && formItems.length === 2) {
                            valueRules[detail.name] = [
                                {
                                    validator: (rule: any, value: any, callback: any) => {
                                        const index = rule.index;
                                        const start = this.data[index]?.[formItems[0].name];
                                        const end = this.data[index]?.[formItems[1].name];
                                        return start && end && moment(start).isAfter(end) ? false : true;
                                    },
                                    message: this.$t('app.formpage.compositeitem.datepicker'),
                                    trigger: "blur"
                                }
                            ]
                        }
                    }
                } else {
                    let editorRules = Verify.buildVerConditions(detail.getPSEditor());
                    valueRules[detail.name] = [
                        // 非空值规则
                        { 
                            validator: (rule: any, value: any, callback: any) => {
                                const index = rule.index;
                                if (this.childrenDetailModel[index]?.[detail.name].required) {
                                    const curValue = this.data[index]?.[detail.name];
                                    if (Util.typeOf(curValue) == 'array') {
                                        for (let index = 0; index < curValue.length; index++) {
                                            if (curValue[index] === null || curValue[index] === undefined || curValue[index] === "") {
                                                return false;
                                            }
                                        }
                                        return true;
                                    } else {
                                        return !(curValue === null || curValue === undefined || curValue === "");
                                    }
                                }
                                return true
                            },
                            message: `${this.$t('app.formpage.valueverify') as string}${detail.caption}`,
                            trigger: "blur"
                        },
                        // 编辑器基础值规则
                        ...editorRules
                    ]
                }
                // 始化系统值规则和属性值规则
                allFormItemVRs?.forEach((item: IPSDEFormItemVR) => {
                    const formItemName = item.getPSDEFormItemName();
                    const { checkMode, valueRuleType } = item;
                    if (detail.name === formItemName && checkMode !== 2) {
                        const sysRule = item.getPSSysValueRule();
                        const deRule = item.getPSDEFValueRule();
                        if (valueRuleType == 'SYSVALUERULE' && sysRule) {
                            // 正则值规则
                            if (sysRule.ruleType == 'REG') {
                                valueRules[formItemName].push({
                                    pattern: new RegExp(sysRule.regExCode),
                                    message: sysRule.ruleInfo,
                                    trigger: "blur"
                                })
                                // 脚本值规则
                            } else if (sysRule.ruleType == 'SCRIPT') {
                                valueRules[formItemName].push({
                                    validator: (rule: any, value: any, callback: any) => {
                                        // 空值时不校验
                                        const index = rule.index;
                                        if (Util.isEmpty(this.data[index]?.[formItemName])) {
                                            return true
                                        }
                                        const data = this.data[index][formItemName];
                                        const context = this.context;
                                        const viewParams = this.viewparams;
                                        try {
                                            eval(sysRule.scriptCode);
                                        } catch (error) {
                                            this.$throw(error, 'initRules');
                                        }
                                        return true;
                                    },
                                    trigger: "blur"
                                })
                            }
                            // 属性值规则
                        } else if (valueRuleType == 'DEFVALUERULE' && deRule) {
                            // 有值项的情况，校验值项的值
                            let formItem = this.controlInstance.findPSDEFormItem(formItemName);
                            let valueName = formItem?.valueItemName || formItemName;
                            valueRules[formItemName].push({
                                validator: (rule: any, value: any, callback: any, source: any) => {
                                    // 空值时不校验
                                    const index = rule.index;
                                    if (Util.isEmpty(this.data[index]?.[formItemName])) {
                                        return true
                                    }
                                    const { isPast, infoMessage } = Verify.verifyDeRules(valueName, this.data[index], deRule.getPSDEFVRGroupCondition());
                                    if (!isPast) {
                                        callback(new Error(infoMessage || deRule.ruleInfo));
                                    }
                                    return true;
                                },
                                trigger: "blur"
                            })
                        }
                    }
                })
            }
        })
        return valueRules;
    }

    /**
     * 初始化
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public init() {
        this.dataItemName =
            this.detailInstance.getPSAppDEField?.()?.codeName?.toLowerCase() ||
            (this.detailInstance as any).fieldName?.toLowerCase() ||
            this.detailInstance.codeName.toLowerCase();
        this.mode = this.detailInstance.detailStyle;
    }

    /**
     * 新建默认值
     *
     * @memberof AppDefaultFormMdCtrlRepeater
     */
     public createDefault(item: any) {
        const formDetails: IPSDEEditFormItem[] = this.detailInstance.getPSDEFormDetails() as IPSDEEditFormItem[];
        if (formDetails && formDetails.length > 0) {
            for (const detail of formDetails) {
                const property = detail.codeName.toLowerCase();
                if ((detail.createDV || detail.createDVT) && item.hasOwnProperty(property)) {
                    switch (detail.createDVT) {
                        case 'CONTEXT':
                            item[property] = this.viewparams[detail.createDV];
                            break;
                        case 'SESSION':
                            item[property] = this.context[detail.createDV];
                            break;
                        case 'APPDATA':
                            item[property] = this.context[detail.createDV];
                            break;
                        case 'OPERATORNAME':
                            item[property] = this.context['srfusername'];
                            break;
                        case 'OPERATOR':
                            item[property] = this.context['srfuserid'];
                            break;
                        case 'CURTIME':
                            item[property] = Util.dateFormat(new Date(), detail.getPSAppDEField()?.valueFormat);
                            break;
                        case 'PARAM':
                            item[property] = this.service.getRemoteCopyData()?.[property] || null;
                            break;
                        default:
                            item[property] = ModelTool.isNumberField(detail.getPSAppDEField()) ? Number(detail.createDV) : detail.createDV;
                            break;
                    }
                }
            }
        }
    }

    /**
     * 更新默认值
     *
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public updateDefault() {
        const formDetails: IPSDEEditFormItem[] = this.detailInstance.getPSDEFormDetails() as IPSDEEditFormItem[];
        if (formDetails && formDetails.length > 0) {
            for (const detail of formDetails) {
                const property = this.getDataItemName(detail);
                if (detail.createDV || detail.createDVT) {
                    const data = this.parentData[this.dataItemName] ? this.mode === 'STYLE3' ? [this.parentData[this.dataItemName]] : this.parentData[this.dataItemName] : [];
                    data.forEach((item: any) => {
                        if (item && (item[property] == null || item[property] == undefined)) {
                            switch (detail.updateDVT) {
                                case 'CONTEXT':
                                    item[property] = this.viewparams[detail.updateDV];
                                    break;
                                case 'SESSION':
                                    item[property] = this.context[detail.updateDV];
                                    break;
                                case 'APPDATA':
                                    item[property] = this.context[detail.updateDV];
                                    break;
                                case 'OPERATORNAME':
                                    item[property] = this.context['srfusername'];
                                    break;
                                case 'OPERATOR':
                                    item[property] = this.context['srfuserid'];
                                    break;
                                case 'CURTIME':
                                    item[property] = Util.dateFormat(new Date(), detail.getPSAppDEField()?.valueFormat);
                                    break;
                                case 'PARAM':
                                    item[property] = this.service.getRemoteCopyData()?.[property] || null;
                                    break;
                                case 'RESET':
                                    item[property] = null;
                                default:
                                    item[property] = ModelTool.isNumberField(detail?.getPSAppDEField()) ? Number(detail.updateDV) : detail.updateDV;
                                    break;
                            }
                        }
                    })
                }
            }
        }
        this.$forceUpdate();
    }

    /**
     * 值变化
     *
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public valueChange() {
        this.$emit('valueChange', this.dataItemName, this.mode === 'STYLE3' ? this.data[0] : this.data);
    }

    /**
     * 销毁
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public destroyed() {
        if (this.contextStateEvent) {
            this.contextStateEvent.unsubscribe();
        }
    }

    /**
     * 获取数据项标识
     *
     * @protected
     * @param {IPSDEFormDetail} detail 表单成员模型
     * @return {*}  {string}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected getDataItemName(detail: IPSDEFormDetail): string {
        if (detail.detailType === 'FORMITEM') {
            return (detail as IPSDEFormItem).getPSEditor?.()?.name || detail.codeName;
        }
        if (detail.detailType === 'MDCTRL') {
            return (
                (detail as IPSDEFormMDCtrl).getPSAppDEField?.()?.codeName ||
                (detail as any).fieldName ||
                detail.codeName
            );
        }
        return detail.codeName;
    }

    /**
     * 处理表单项值变化
     *
     * @protected
     * @param {*} value
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected handleChildValueChange({ name, value }: any, index: number, formItem?: IPSDEFormItem) {
        if (!name) {
            return;
        }
        this.resetFormData({ name, index });
        this.data[index][name] = value;
        this.repeaterDynamicLogic(name, index, this.data[index]);
        this.$emit('valueChange', name, value, formItem);
        this.valueChange();
    }

    /**
     * 重置项
     *
     * @protected
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public resetFormData({ name, index }: { name: string, index: number }): void {
        const formItems: any = this.detailInstance.getPSDEFormDetails();
        if (formItems && formItems.length > 0) {
            for (const item of formItems) {
                if (item.resetItemName && item.resetItemName == name) {
                    this.handleChildValueChange({ name: item.name, value: null }, index, item);
                    if (item.valueItemName) {
                        this.handleChildValueChange({ name: item.valueItemName, value: null }, index, item);
                    }
                }
            }
        }
    }

    /**
     * 处理数据添加
     *
     * @protected
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected handleAdd() {
        const newData = {};
        this.childrenDetailModel.push(
            this.getRepeaterDetailsModel()
        );
        this.details.forEach((item: IPSDEFormDetail) => {
            const name = this.getDataItemName(item);
            Object.assign(newData, { [name]: item.detailType === 'MDCTRL' ? [] : null });
        });
        this.createDefault(newData);
        this.data.push(newData);
        this.repeaterDynamicLogic('', this.data.length - 1, newData);
        this.valueChange();
    }

    /**
     * 处理数据删除
     *
     * @protected
     * @param {*} data
     * @param {number} index
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected handleRemove(data: any, index: number) {
        this.data.splice(index, 1);
        this.childrenDetailModel.splice(index, 1);
        this.rules.splice(index, 1);
        this.valueChange();
    }

    /**
     * 重复器动态逻辑
     *
     * @param {string} name 项名称
     * @param {number} index 行号
     * @param {*} row 行数据
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    repeaterDynamicLogic(name: string, index: number, row: any) {
        const data = {};
        // 重复器动态逻辑合入主表单的数据(暂不考虑重复器嵌套)
        Object.assign(data, this.parentData);
        Object.assign(data, row);
        this.details.forEach((detail: IPSDEFormDetail) => {
            detail.getPSDEFDGroupLogics()?.forEach((logic: IPSDEFDCatGroupLogic) => {
                // todo lxm 缺少getRelatedDetailNames
                let relatedNames = logic.getRelatedDetailNames() || [];
                if (Object.is(name, '') || relatedNames.indexOf(name) != -1) {
                    let ret = logic.logicCat.startsWith('SCRIPTCODE') ? false : this.verifyGroupLogic(data, logic);
                    if (this.childrenDetailModel[index]?.[detail.name]) {
                        switch (logic.logicCat) {
                            // 动态空输入，不满足则必填
                            case 'ITEMBLANK':
                                this.childrenDetailModel[index][detail.name].required = !ret;
                                break;
                            // 动态启用，满足则启用
                            case 'ITEMENABLE':
                                this.childrenDetailModel[index][detail.name].setDisabled(!ret);
                                break;
                            // 动态显示，满足则显示
                            case 'PANELVISIBLE':
                                this.childrenDetailModel[index][detail.name].setVisible(ret);
                                break;
                        }
                    }
                }
            })
        })
    }

    /**
     * 校验动态逻辑
     *
     * @param {*} data
     * @param {IPSDEFDCatGroupLogic} logic
     * @return {*}  {boolean}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public verifyGroupLogic(data: any, logic: IPSDEFDCatGroupLogic): boolean {
        if (logic.logicType == 'GROUP' && logic?.getPSDEFDLogics()?.length) {
            let result: boolean = true;
            if (logic.groupOP == 'AND') {
                let falseItem: IPSDEFDLogic | undefined = logic.getPSDEFDLogics()?.find((childLogic: any) => {
                    return !this.verifyGroupLogic(data, childLogic);
                })
                result = falseItem == undefined;
            } else if (logic.groupOP == 'OR') {
                let trueItem: IPSDEFDLogic | undefined = logic.getPSDEFDLogics()?.find((childLogic: any) => {
                    return this.verifyGroupLogic(data, childLogic);
                })
                result = trueItem != undefined;
            }
            // 是否取反
            return logic.notMode ? !result : result;
        } else if (logic.logicType == 'SINGLE') {
            let singleLogic: IPSDEFDSingleLogic = logic as any;
            let value = singleLogic.value;
            // 动态匹配${}
            const regex = /\${(.*?)}/g;
            if (value && regex.test(value)) {
                value = dynamicMatch(value,{
                    context: this.context ? this.context: {},
                    viewParams: this.viewparams? this.viewparams : {},
                    data
                });
            }
            return Verify.testCond(data[singleLogic.dEFDName.toLowerCase()], singleLogic.condOP, value);
        }
        return false;
    }
    
    /**
     * 获取子成员
     *
     * @protected
     * @param {IPSDEFormMDCtrl} detail
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected initDetails(): void {
        this.details = []
        ModelTool.parserFormDetail(this.detailInstance, (item: any) => {
            if (item.codeName !== this.detailInstance.codeName) {
                const parent = item.getParentPSModelObject?.();
                //  父不是当前多数据部件
                if (
                    !(
                        parent &&
                        parent.detailType === 'MDCTRL' &&
                        parent.codeName !== this.detailInstance.codeName
                    )
                ) {
                    this.details.push(item);
                }
            }
        });
    }

    /**
     * 获取内建行为权限
     *
     * @protected
     * @param {('add' | 'remove')} action
     * @return {*} 
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected calcBuildInActionsAuth(action: 'add' | 'remove') {
        let state: boolean = false;
        if (action == 'add') {
            if (
                this.detailInstance.buildInActions == 1 ||
                this.detailInstance.buildInActions == 3 ||
                this.detailInstance.buildInActions == 5 ||
                this.detailInstance.buildInActions == 7
            ) {
                state = true;
            }
        } else {
            if (
                this.detailInstance.buildInActions == 4 ||
                this.detailInstance.buildInActions == 5 ||
                this.detailInstance.buildInActions == 6 ||
                this.detailInstance.buildInActions == 7
            ) {
                state = true;
            }
        }
        return state;
    }

    /**
     * 处理表单按钮行为触发
     *
     * @protected
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    protected handleButtonActionClick(event: any) {
        this.$emit('actionClick', event);
    }

    /**
     * 渲染多数据部件
     *
     * @param {IPSDEFormMDCtrl} detail
     * @param {number} index
     * @param {*} data
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderMDCtrl(detail: IPSDEFormMDCtrl, index: number, data: any) {
        //	只识别重复器类型
        if (detail.contentType === 'REPEATER') {
            return (
                <app-default-form-md-ctrl-repeater
                    detailInstance={detail}
                    controlInstance={this.controlInstance}
                    parentData={data}
                    showCaption={this.mode !== 'STYLE2'}
                    level={this.level + 1}
                    contextState={this.contextState}
                    detailsModel={this.detailsModel}
                    context={this.context}
                    service={this.service}
                    viewparams={this.viewparams}
                    on-valueChange={(name: string, value: any, formItem?: IPSDEFormItem) => this.handleChildValueChange({ name, value }, index, formItem)}
                    on-actionClick={(event: any) => this.handleButtonActionClick(event)}
                ></app-default-form-md-ctrl-repeater>
            );
        }
    }

    /**
     * 渲染表单项
     *
     * @param {IPSDEFormItem} detail
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderFormItem(detail: IPSDEFormItem, vIndex: number, data: any) {
        const editor = detail.getPSEditor();
        if (this.mode === 'STYLE2' && editor) {
            return (
                <app-default-editor
                    editorInstance={editor}
                    parentItem={detail}
                    value={data[editor.name]}
                    contextData={data}
                    context={this.context}
                    service={this.service}
                    viewparams={this.viewparams}
                    disabled={this.childrenDetailModel[vIndex]?.[detail.name]?.disabled}
                    on-change={(value: any) => this.handleChildValueChange(value, vIndex, detail)}
                ></app-default-editor>
            );
        }
        return (
            <app-default-form-item
                detailsInstance={detail}
                index={vIndex}
                data={data}
                context={this.context}
                viewparams={this.viewparams}
                rules={this.rules[vIndex]?.[detail.name]}
                runtimeModel={this.childrenDetailModel[vIndex]?.[detail.name]}
                on-onFormItemValueChange={(value: any) => this.handleChildValueChange(value, vIndex, detail)}
            >
                {editor ? (
                    <app-default-editor
                        parentItem={detail}
                        editorInstance={editor}
                        value={data[editor.name]}
                        contextData={data}
                        service={this.service}
                        context={this.context}
                        viewparams={this.viewparams}
                        disabled={this.childrenDetailModel[vIndex]?.[detail.name]?.disabled}
                        on-change={(value: any) => this.handleChildValueChange(value, vIndex, detail)}
                    ></app-default-editor>
                ) : null}
            </app-default-form-item>
        );
    }

    /**
     * 绘制按钮
     *
     * @param {IPSDEFormButton} detail
     * @param {number} vIndex
     * @param {*} data
     * @return {*}  {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderButton(detail: IPSDEFormButton, index: number, data: any): any {
        // 自定义类名
        const dynaClass: any = { 'app-form-button': true };        
        if(detail.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            Object.assign(dynaClass,...eval(detail.dynaClass))
        }
        return (
                <app-model-button
                    data={this.data}
                    modelJson={detail}
                    dynaClass={dynaClass}
                    dynaType='primary'
                    disabled={this.detailsModel[detail.name]?.disabled}
                    on-onClick={($event: any) => this.handleButtonActionClick({ formdetail: detail, event: $event, index, data })}
                >
                </app-model-button>
        );
    }

    /**
     * 绘制直接内容
     *
     * @param {IPSDEFormRawItem} detail
     * @param {number} index
     * @param {*} data
     * @return {*}  {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    public renderRawitem(detail: IPSDEFormRawItem, index: number, data: any): any {
        let { rawItemHeight, rawItemWidth, contentType, htmlContent, rawContent } = detail;
        let sysCssName = detail.getPSSysCss()?.cssName;
        let sysImage = detail.getPSSysImage()?.cssClass;
        let sysImgurl = detail.getPSSysImage()?.imagePath;
        const style: any = {
            width: rawItemWidth > 0 ? `${rawItemWidth}px` : false,
            height: rawItemHeight > 0 ? `${rawItemHeight}px` :false,
        }
        let content: any;
        if (['RAW','VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)) {
            content = rawContent;
        } else if (Object.is(contentType,'HTML')){
            content = htmlContent;
        }else if(Object.is(contentType,'PLACEHOLDER')){
            content = null;
        }
        if (content) {
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;','<');
            content = content.replaceAll('&gt;','>');
            content = content.replaceAll('&amp;nbsp;',' ');
            content = content.replaceAll('&nbsp;',' ');
        }
        if(['VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)){
            if(content){
                try{
                    if(typeof content === 'string'){
                        let func = new Function('return (' + content + ');');
                        content  = func();
                    }
                }catch{
                    console.error(`${contentType}类型自定义参数配置错误`);
                    content = null;
                }
            }else{
                content = null;
            }
        }
        return (
            <app-rawitem
                class={sysCssName}
                style={style}
                viewparams={this.viewparams}
                context={this.context}
                contentType={contentType}
                rawItemDetail={detail.M.rawItemDetail}
                imageClass={sysImage}
                imgUrl={sysImgurl}
                content={content}
                videoParams={content}
                dividerParams={content}
                alertParams={content}
            >
            </app-rawitem>
        );
    }

    /**
     * 渲染项
     *
     * @param {IPSDEFormDetail} detail
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderByDetailType(detail: IPSDEFormDetail, index: number, data: any) {
        switch (detail.detailType) {
            case 'FORMITEM':
                return this.renderFormItem(detail as IPSDEFormItem, index, data);
            case 'MDCTRL':
                return this.renderMDCtrl(detail as IPSDEFormMDCtrl, index, data);
            case 'BUTTON':
                return this.renderButton(detail as IPSDEFormButton, index, data);
            case 'RAWITEM':
                return this.renderRawitem(detail as IPSDEFormRawItem, index, data);
            default:
                console.warn(`表单多数据部件(重复器)子成员类型 ${detail.detailType} 暂未支持`);
                return null;
        }
    }

    /**
     * 渲染子项
     *
     * @param {number} index 数据下标
     * @param {*} data 数据
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderDetails(index: number, data: any) {
        const layout = this.detailInstance.getPSLayout();
        //  没有子成员
        if (!this.details || this.details.length === 0) {
            return null;
        }
        if (!layout) {
            return this.details.map((item: IPSDEFormDetail) => {
                return this.renderByDetailType(item, index, data);
            });
        }

        //  栅格布局
        if (layout.layout == 'TABLE_24COL' || layout.layout == 'TABLE_12COL' || layout.layout == 'TABLE') {
            return (
                <row>
                    {this.details.map((item: IPSDEFormDetail) => {
                        if ((item as any).hidden) {
                            return;
                        }
                        let attrs = LayoutTool.getGridOptions(item.getPSLayoutPos() as IPSGridLayoutPos);
                        let style: any = this.getGridLayoutStyle(item, index);
                        return (
                            <i-col class='form-item__layout' {...{ props: attrs }} style={style}>
                                {this.renderByDetailType(item, index, data)}
                            </i-col>
                        );
                    })}
                </row>
            );
        }
        //  FLEX布局
        if (layout.layout === 'FLEX') {
            const flexStyle = LayoutTool.getFlexStyle(layout as IPSFlexLayout);
            return (
                <div style={flexStyle}>
                    {this.details.map((item: IPSDEFormDetail, index: number) => {
                        if ((item as any).hidden) {
                            return;
                        }
                        let detailStyle = LayoutTool.getFlexStyle2(item?.getPSLayoutPos() as IPSFlexLayoutPos);
                        detailStyle += this.childrenDetailModel[index]?.[item.name].visible ? '' : 'display: none;';
                        return (
                            <div style={detailStyle} class='repeater-item__layout'>
                                {this.renderByDetailType(item, index, data)}
                            </div>
                        );
                    })}
                </div>
            );
        }
    }

    /**
     * 获取栅格布局样式
     *
     * @param {*} item
     * @memberof AppFormBase
     */
    public getGridLayoutStyle(item: IPSDEFormDetail, index: number) {
        const { name, width, height } = item;
        let style: any = {};
        if (!this.childrenDetailModel[index]?.[name]?.visible) {
            Object.assign(style, { display: 'none' });
        }
        if (width && width > 0) {
            Object.assign(style, { width: `${width}px` });
        }
        if (height && height > 0) {
            Object.assign(style, { height: `${height}px` });
        }
        return style;
    }

    /**
     * 渲染样式2表格列
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderStyle2GridColumn() {
        return this.details.map((detail: IPSDEFormDetail, index: number) => {
            if (detail && (detail as any).hidden) {
                return;
            }
            const name = this.getDataItemName(detail).toLowerCase();
            return (
                <el-table-column
                    prop={name}
                    align={
                        (this.detailInstance as any).columnAlign
                            ? (this.detailInstance as any).columnAlign.toLowerCase()
                            : 'center'
                    }
                    scopedSlots={{
                        header: () => {
                            return <span>{this.$tl(detail.getCapPSLanguageRes()?.lanResTag, detail.caption)}</span>;
                        },
                        default: ({ row, column, $index }: any) => {
                            if (this.childrenDetailModel[$index]?.[column.property]?.visible) {
                                return this.renderByDetailType(detail, $index, row);
                            }
                        },
                    }}
                ></el-table-column>
            );
        });
    }

    /**
     * 渲染样式2内容
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderStyle2() {
        return (
            <div class='app-form-mdctrl-repeater__content'>
                <el-table show-header={true} border={true} data={this.data}>
                    <el-table-column
                        align='center'
                        class-name='grid-column__localaction'
                        width='64'
                        scopedSlots={{
                            header: ({ column, $index }: any) => {
                                return (
                                    this.calcBuildInActionsAuth('add') ?
                                    <el-button
                                        class='repeater-add'
                                        type='primary'
                                        size='mini'
                                        icon='el-icon-plus'
                                        circle
                                        on-click={() => {
                                            this.handleAdd();
                                        }}
                                    ></el-button> : null
                                );
                            },
                            default: ({ row, column, $index }: any) => {
                                return (
                                    <div class='repeater-grid-column'>
                                        {
                                            this.calcBuildInActionsAuth('remove') ? 
                                            <el-button
                                                class='grid-column__localaction__remove'
                                                type='danger'
                                                size='mini'
                                                icon='el-icon-delete'
                                                circle
                                                on-click={() => {
                                                    this.handleRemove(row, $index);
                                                }}
                                            ></el-button> : null
                                        }
                                        <span class='grid-column__localaction__index'>{$index + 1}</span>
                                    </div>
                                );
                            },
                        }}
                    ></el-table-column>
                    {this.renderStyle2GridColumn()}
                </el-table>
            </div>
        );
    }

    /**
     * 渲染默认样式内容
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    renderDefault() {
        const caption = this.$tl(this.detailInstance.getCapPSLanguageRes()?.lanResTag, this.detailInstance.caption);
        return [
            <div
                class='app-form-mdctrl-repeater__header'
                style={this.mode === 'STYLE3' && this.data.length >= 1 ? 'display: none;' : ''}
            >
                {this.showCaption && caption ? <span class='repeater-caption'>{caption}</span> : null}
                {
                    this.calcBuildInActionsAuth('add') ?
                    <el-button
                        type='primary'
                        class='repeater-add'
                        icon='el-icon-plus'
                        size='mini'
                        circle
                        on-click={() => {
                            this.handleAdd();
                        }}
                    ></el-button> : null
                }
            </div>,
            <div class='app-form-mdctrl-repeater__content'>
                {this.data.map((item: any, vIndex: number) => {
                    if (this.mode === 'STYLE3' && vIndex > 0) {
                        return null;
                    }
                    return (
                        <div class='app-form-mdctrl-repeater__row'>
                            {
                                this.calcBuildInActionsAuth('remove') ? <el-button
                                    class='repeater-remove-default'
                                    type='danger'
                                    size='mini'
                                    icon='el-icon-delete'
                                    circle
                                    on-click={() => {
                                        this.handleRemove(item, vIndex);
                                    }}
                                ></el-button> : null
                            }
                            {this.renderDetails(vIndex, item)}
                        </div>
                    );
                })}
            </div>,
        ];
    }

    /**
     * 渲染
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrlRepeater
     */
    render() {
        if (this.inited) {
            const classNames = {
                'app-form-mdctrl-repeater': true,
                [`app-form-mdctrl-repeater--${this.detailInstance.name.toLowerCase()}`]: true,
                [`app-form-mdctrl-repeater--${this.mode.toLowerCase()}`]: true,
                [`app-form-mdctrl-repeater__level-${this.level}`]: true,
            };
            return <div class={classNames}>{this.mode === 'STYLE2' ? this.renderStyle2() : this.renderDefault()}</div>;
        }
    }
}
