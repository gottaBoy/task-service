import { Subject, Subscription } from 'rxjs';
import { ModelTool, Verify, AppErrorCode, EntityFieldErrorCode, FormControlInterface, EntityFieldError, IParams, Util } from 'ibiz-core';
import { MainControlBase } from './main-control-base';
import { IPSDEEditFormItem, IPSDEFDCatGroupLogic, IPSDEForm, IPSDEFormItem } from '@ibiz/dynamic-model-api';

/**
 * 表单部件基类
 *
 * @export
 * @class FormControlBase
 * @extends {MainControlBase}
 */
export class FormControlBase extends MainControlBase implements FormControlInterface {

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public data: any = {};

    /**
     * 表单的模型对象
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public declare controlInstance: IPSDEForm;

    /**
     * 表单服务对象
     *
     * @type {*}
     * @memberof ControlBase
     */
    public declare service: any;

    /**
     * 部件行为--loaddraft
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public loaddraftAction: any;

    /**
     * 部件行为--load
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public loadAction: any;

    /**
     * 是否为本地模式
     *
     * @type {*}
     * @memberof EditFormControlBase
     */
    public isLocalMode?:any;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof FormControlBase
     */
    public formState!: Subject<any>;

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof FormControlBase
     */
    public ignorefieldvaluechange?: boolean;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof FormControlBase
     */
    public dataChang!: Subject<any>;

    /**
     * 表单部件事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof FormControlBase
     */
    public formControlEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof FormControlBase
     */
    public oldData: any;

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public detailsModel: any;

    /**
     * 值规则
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public rules: any = {}

    /**
     * 转化代码项值映射
     *
     * @type {Map<string,IParams>}
     * @memberof FormControlBase
     */
    public codeItemTextMap: Map<string, IParams> = new Map();

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof FormControlBase
     */
    public getDatas(): any[] {
        const data = Util.deepCopy(this.data);
        if (this.codeItemTextMap.size > 0) {
            this.codeItemTextMap.forEach((value, key) => {
                const { val } = value;
                data[key] = val;
            })
        }
        return [data];
    }

    /**
     * 获取单项数据
     *
     * @returns {*}
     * @memberof FormControlBase
     */
    public getData(): any {
        const data = Util.deepCopy(this.data);
        if (this.codeItemTextMap.size > 0) {
            this.codeItemTextMap.forEach((value, key) => {
                const { val } = value;
                data[key] = val;
            })
        }
        return data;
    }

    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal } 名称,新值，旧值
     * @memberof FormControlBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void { }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal } 名称,新值，旧值
     * @memberof FormControlBase
     */
    public async formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }) { }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal } 名称,新值，旧值
     * @returns {void}
     * @memberof FormControlBase
     */
    public formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void { }

    /**
    * 表单编辑器点击
    *
    * @public
    * @param {{ name: string, value: any}} { name, value}
    * @memberof FormControlBase
    */
    public formDetailClick($event: { name: string, value: any }, modelJson: IPSDEFormItem) {
        this.handleLogicScript(modelJson, 'SCRIPTCODE_CLICK', $event);
    }

    /**
     * 表单编辑器聚焦事件
     *
     * @public
     * @param {{ name: string, value: any}} { name, value}
     * @memberof FormControlBase
     */
    public formDetailFocus($event: { name: string, value: any }, modelJson: IPSDEFormItem) {
        this.handleLogicScript(modelJson, 'SCRIPTCODE_FOCUS', $event);
    }

    /**
     * 表单编辑器失去焦点事件
     *
     * @public
     * @param {{ name: string, value: any}} { name, value}
     * @memberof FormControlBase
     */
    public formDetailBlur($event: { name: string, value: any }, modelJson: IPSDEFormItem) {
        this.handleLogicScript(modelJson, 'SCRIPTCODE_BLUR', $event);
    }

    /**
     * 处理表单分组收缩变化事件
     *
     * @param {string} name 名称
     * @param {*} value 值
     * @memberof FormControlBase
     */
    public formDetailGroupChange(name:string,value:boolean){
        //todo 处理表单分组收缩变化事件
        console.log(name+'表单分组收缩变化',value);
    }

    /**
     * @description 处理脚本代码 ({name, value, context, viewparams, data, details}: any) => {......}
     * @param {IPSDEFormItem} modelJson
     * @param {string} logicCat
     * @param {*} $event
     * @memberof FormControlBase
     */
    public handleLogicScript(modelJson: IPSDEFormItem, logicCat: string, $event: any) {
        const groupLogics = modelJson.getPSDEFDGroupLogics() || [];
        if (groupLogics.length > 0) {
            const groupLogic = groupLogics.find((logic: IPSDEFDCatGroupLogic) => logic.logicCat && Object.is(logic.logicCat, logicCat));
            if (groupLogic && Object.is(groupLogic.logicType, 'GROUP')) {
                const logics = groupLogic.getPSDEFDLogics() || [];
                const logic: any = logics.length > 0 ? logics[0] : null;
                if (logic && logic.value) {
                    try {
                        const params = {
                            name: $event.name,
                            value: $event.value,
                            data: this.data,
                            context: this.context,
                            viewparams: this.viewparams,
                            details: this.detailsModel
                        }
                        const script = logic.value.replace(/:(.*?){(.*?)}/, '');
                        const tempLogic = eval(script);
                        tempLogic(params);
                    } catch (error) {
                        this.$throw(error, 'handleLogicScript');
                    }
                }
            }
        }
    }


    /**
     * 表单加载完成
     *
     * @public
     * @param {*} [data={}] 表单数据
     * @param {string} [action] 行为标识
     * @memberof FormControlBase
     */
    public async onFormLoad(data: any = {}, action: string): Promise<void> { }

    /**
     * 值填充
     *
     * @param {*} [_datas={}] 表单数据
     * @param {string} [action] 行为标识
     * @memberof FormControlBase
     */
    public async fillForm(_datas: any = {}, action: string) {
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        if (Object.is(action, 'loadDraft')) {
            this.createDefault();
        }
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data 表单数据
     * @memberof FormControlBase
     */
    public setFormEnableCond(data: any): void {
        // 拷贝模式srfuf设置为0
        if (this.viewparams && this.viewparams.copymode) {
            data.srfuf = '0';
        }
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: any = detail;
            formItem.setEnableCond(data.srfuf);
        });
        this.$forceUpdate();
    }

    /**
     * 新建默认值
     * @memberof FormControlBase
     */
    public createDefault() { }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof FormControlBase
     */
    public resetDraftFormStates(): void {
        const form: any = this.$refs[this.controlInstance.name];
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof FormControlBase
     */
    public resetValidates(): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: any = detail;
            formItem.setError('');
        });
    }

    /**
     * 填充校验结果 （后台）
     *
     * @param {any[]} fieldErrors 校验数组
     * @memberof FormControlBase
     */
    public fillValidates(fieldErrors: any[]): void {
        fieldErrors.forEach((error: any) => {
            const formItem: any = this.detailsModel[error.field];
            if (!formItem) {
                return;
            }
            this.$nextTick(() => {
                formItem.setError(error.message);
            });
        });
    }

    /**
     * 表单校验状态
     *
     * @returns {boolean} 
     * @memberof FormControlBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs[this.controlInstance.name];
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        return validatestate;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event 名称，值 
     * @returns {void}
     * @memberof FormControlBase
     */
    public onFormItemValueChange($event: { name: string, value: any }, modelJson?: IPSDEFormItem): void {
        if (modelJson) {
            this.handleLogicScript(modelJson, 'SCRIPTCODE_CHANGE', $event);
        }
        if (!$event || !$event.name || Object.is($event.name, '') || !this.data.hasOwnProperty($event.name)) {
            return;
        }
        if (this.checkIgnoreInput($event.name, 'before')) {
            return;
        }
        this.validateEditorRuleAction($event.name, $event.value);
        this.data[$event.name] = $event.value;
        this.formDataChange({ name: $event.name, newVal: $event.value, oldVal: null });
    }

    /**
     * 校验编辑器基础规则后续行为
     *
     * @param {string} name 名称
     * @param {*} value 值
     * @returns {void}
     * @memberof FormControlBase
     */
    public validateEditorRuleAction(name: string, value: any) {
        let allFormItems: IPSDEEditFormItem[] = ModelTool.getAllFormItems(this.controlInstance);
        if (allFormItems?.length > 0) {
            let curFormItem: IPSDEEditFormItem | undefined = allFormItems?.find((item: any) => {
                return item.name === name;
            })
            if (!curFormItem)
                return;
            let condition: any = Verify.buildVerConditions(curFormItem.getPSEditor());
            if (condition && condition.length > 0) {
                // todo 提示info
            }
        }
    }

    /**
     * @description 校验是否忽略输入值
     * @protected
     * @param {string} name
     * @param {('before' | 'change')} [step='change'] {before：表单值变化之前，change：表单值变化}
     * @return {*}  {boolean}
     * @memberof FormControlBase
     */
    protected checkIgnoreInput(name: string, step: 'before' | 'change' = 'change'): boolean {
        const formDetail = this.detailsModel[name];
        if (formDetail) {
            switch (formDetail.ignoreInput) {
                case 4: //表单项禁用
                    if (formDetail.disabled) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }


    /**
     * 设置数据项值
     *
     * @param {string} name 名称
     * @param {*} value 值
     * @returns {void}
     * @memberof FormControlBase
     */
    public setDataItemValue(name: string, value: any): void {
        if (!name || Object.is(name, '') || !this.data.hasOwnProperty(name)) {
            return;
        }
        if (Object.is(this.data[name], value)) {
            return;
        }
        this.data[name] = value;
    }

    /**
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof FormControlBase
     */
    public groupUIActionClick($event: any): void { }

    /**
     * 编辑表单初始化
     *
     * @memberof FormControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        // 初始化默认值
        this.formState = new Subject();
        this.dataChang = new Subject();
        this.ignorefieldvaluechange = false

        if (this.viewState) {
            this.formControlEvent = this.viewState.subscribe(({ tag, action, data }: { tag: string, action: string, data: any }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('autoload', action)) {
                    this.autoLoad(data);
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('loaddraft', action)) {
                    this.loadDraft(data);
                }
            });
        }
    }

    /**
     * 表单销毁
     *
     * @memberof FormControlBase
     */
    public ctrlDestroyed(args?: any) {
        super.ctrlDestroyed();
        if (this.formControlEvent) {
            this.formControlEvent.unsubscribe();
        }
    }

    /**
     * 表单自动加载
     *
     * @param {*} [arg={}] 加载参数
     * @returns {void}
     * @memberof FormControlBase
     */
    public autoLoad(arg: any = {}): void {
        if (arg.srfkey && !Object.is(arg.srfkey, '')) {
            Object.assign(arg, { srfkey: arg.srfkey });
            this.load(arg);
            return;
        }
        if (arg.srfkeys && !Object.is(arg.srfkeys, '')) {
            Object.assign(arg, { srfkey: arg.srfkeys });
            this.load(arg);
            return;
        }
        this.loadDraft(arg);
    }

    /**
     * 加载
     *
     * @public
     * @param {*} [opt={}] 加载参数
     * @memberof FormControlBase
     */
    public async load(opt: any = {}) {
        const requestAction = this.isLocalMode? 'getAppLocal':this.loadAction;
        if (!requestAction) {
            this.$throw(`${this.controlInstance.codeName}` + (this.$t('app.formpage.notconfig.loadaction') as string), 'load');
            return;
        }
        const arg: any = { ...opt };
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        let viewparamResult: any = Object.assign(arg, this.viewparams);
        if (!(await this.handleCtrlEvents('onbeforeload', { action: requestAction, navParam: viewparamResult }))) {
            return;
        }
        this.onControlRequset('load', tempContext, viewparamResult);
        const get: Promise<any> = this.service.get(requestAction, tempContext, { viewparams: viewparamResult }, this.showBusyIndicator);
        get.then(async (response: any) => {
            this.onControlResponse('load', response);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('onloaderror', { action: requestAction, navParam: viewparamResult, data: response?.data }))) {
                    return;
                }
                this.$throw(response, 'load');
                return;
            }
            const data = response.data;
            if (!(await this.handleCtrlEvents('onloadsuccess', { action: requestAction, navParam: viewparamResult, data: data }))) {
                return;
            }
            await this.onFormLoad(data, 'load');
            this.ctrlEvent({
                controlname: this.controlInstance.name,
                action: 'load',
                data: this.data
            });
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
        }).catch(async (error: any) => {
            this.onControlResponse('load', error);
            if (!(await this.handleCtrlEvents('onloaderror', { action: requestAction, navParam: viewparamResult, data: error?.data }))) {
                return;
            }
            this.$throw(error, 'load');
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof FormControlBase
     */
    public async loadDraft(opt: any = {}, mode?: string): Promise<void> {
        if (!this.loaddraftAction) {
            this.$throw((this.$t('app.searchform.notconfig.loaddraftaction') as string), 'loadDraft');
            return;
        }
        const arg: any = { ...opt };
        Object.assign(arg, { viewparams: this.viewparams });
        const tempContext: any = JSON.parse(JSON.stringify(this.context));
        if (!(await this.handleCtrlEvents('onbeforeloaddraft', { action: this.loaddraftAction, navParam: arg }))) {
            return;
        }
        this.onControlRequset('loadDraft', tempContext, arg);
        try {
            const response: any = await this.service.loadDraft(this.loaddraftAction, tempContext, arg, this.showBusyIndicator);
            this.onControlResponse('loadDraft', response);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, navParam: arg, data: response?.data }))) {
                    return;
                }
                this.$throw(response, 'loadDraft');
                return;
            }
            const data = response.data;
            if (!(await this.handleCtrlEvents('onloaddraftsuccess', { action: this.loaddraftAction, navParam: arg, data: data }))) {
                return;
            }
            this.resetDraftFormStates();
            await this.onFormLoad(data, 'loadDraft');
            setTimeout(() => {
                const form: any = this.$refs[this.controlInstance.name];
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
            if (Object.is(mode, 'RESET')) {
                if (!this.formValidateStatus()) {
                    return;
                }
            }
            this.ctrlEvent({
                controlname: this.controlInstance.name,
                action: 'load',
                data: data,
            });
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
        } catch (error: any) {
            this.onControlResponse('loadDraft', error);
            if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, navParam: arg, data: error?.data }))) {
                return;
            }
            this.$throw(error, 'loadDraft');
        }
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof FormControlBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void { }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof FormControlBase
     */
    public onEnter($event: any): void { }

    /**
     * 搜索
     *
     * @memberof FormControlBase
     */
    public search() {
        if (!this.formValidateStatus()) {
            return;
        }
        this.ctrlEvent({
            controlname: this.controlInstance.name,
            action: 'search',
            data: this.data,
        });
    }

    /**
     * 重置
     *
     * @memberof FormControlBase
     */
    public reset() {
        if(this.data && Object.keys(this.data).length >0){
            Object.keys(this.data).forEach((key:string) =>{
                this.data[key] = null;
            })
        }
        this.loadDraft({}, 'RESET');
    }

    /**
     * 通过属性名获取表单项
     *
     * @memberof FormControlBase
     */
    public findFormItemByField(fieldName: string) {
        const formItems: IPSDEEditFormItem[] = ModelTool.getAllFormItems(this.controlInstance);
        return formItems.find((formItem: any) => {
            return formItem.getPSAppDEField()?.name == fieldName;
        })
    }

    /**
     * 处理部件UI请求
     *
     * @param {string} action 行为名称
     * @param {*} context 上下文
     * @param {*} viewparam 视图参数
     * @memberof FormControlBase
     */
    public onControlRequset(action: string, context: any, viewparam: any) {
        if (!Object.is(action, 'updateFormItems')) {
            this.ctrlBeginLoading();
        }
    }

    /**
     * 处理部件UI响应
     *
     * @param {string} action 行为名称
     * @param {*} response 响应
     * @memberof FormControlBase
     */
    public onControlResponse(action: string, response: any) {
        if (!Object.is(action, 'updateFormItems')) {
            this.ctrlEndLoading();
        }
        if (response && response.status && response.status == 403) {
            this.enableControlUIAuth = false;
            this.ctrlEvent({
                controlname: this.controlInstance.name,
                action: 'authlimit',
                data: response,
            });
        }
        if (response && response.status && response.status != 200 && response.data) {
            const data: any = response.data;
            if (data.code && Object.is(AppErrorCode.INPUTERROR, data.code) && data.details?.length > 0) {
                let errorMsg: string = '';
                data.details.forEach((detail: any) => {
                    if (!Object.is(EntityFieldErrorCode.ERROR_OK, detail.fielderrortype) && detail.fieldname) {
                        // 解析错误信息
                        let entityFieldError = new EntityFieldError(detail);
                        let fieldErrorInfo = entityFieldError.fieldlogicname + entityFieldError.fielderrorinfo;

                        // 填充有detailModel字段的错误信息。
                        const tempFormItem: any = this.findFormItemByField(detail.fieldname);
                        if (tempFormItem) {
                            Object.assign(this.detailsModel[tempFormItem.name], { error: new String(detail.fielderrorinfo ? detail.fielderrorinfo : data.message) });
                        }

                        // notice显示的错误信息，默认只显示没有detailModel字段的错误信息,noticeAllFieldsError为true时显示所有的字段。
                        if (this.Environment.noticeAllFieldsError || !tempFormItem) {
                            errorMsg += `${fieldErrorInfo}<br/>`;
                        }
                    }
                })
                response.data.message = errorMsg ? errorMsg : (this.$t('app.searchform.globalerrortip') as string);
                this.$forceUpdate();
            }
        }
    }
}