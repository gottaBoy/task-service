import { IPSAppDEField, IPSControlAction, IPSDEEditForm, IPSDEStateWizardPanel, IPSDEWizard, IPSDEWizardEditForm, IPSDEWizardForm, IPSDEWizardPanel, IPSDEWizardStep } from '@ibiz/dynamic-model-api';
import { ViewState } from 'ibiz-core';
import { Subject } from 'rxjs';
import { AppCenterService } from '../app-service';
import { AppMobWizardPanelService } from '../ctrl-service';
import { MainControlBase } from './main-control-base';

export class MobWizardPanelControlBase extends MainControlBase {

    /**
     * 向导面板部件实例
     * 
     * @memberof MobWizardPanelControlBase
     */
    public declare controlInstance: IPSDEWizardPanel | IPSDEStateWizardPanel;

    /**
     * 部件行为--init
     *
     * @type {string}
     * @memberof MobWizardPanelControlBase
     */
    public initAction!: string;

    /**
     * 部件行为--finish
     *
     * @type {string}
     * @memberof MobWizardPanelControlBase
     */
    public finishAction!: string;

    /**
     * 向导表单参数
     *
     * @type {*}
     * @memberof MobWizardPanelControlBase
     */
    public formParam: any = {};

    /**
     * 执行过的表单
     *
     * @public
     * @type {Array<string>}
     * @memberof MobWizardPanelControlBase
     */
    public historyForms: Array<string> = [];

    /**
     * 步骤行为集合
     *
     * @type {*}
     * @memberof MobWizardPanelControlBase
     */
    public stepActions: any = {};

    /**
     * 向导表单集合
     *
     * @type {Array<any>}
     * @memberof MobWizardPanelControlBase
     */
    public wizardForms: Array<any> = [];

    /**
     * 当前状态
     *
     * @memberof MobWizardPanelControlBase
     */
    public curState = '';

    /**
     * 当前激活表单
     *
     * @type {string}
     * @memberof MobWizardPanelControlBase
     */
    public activeForm: string = '';

    /**
     * 首表单
     *
     * @type {string}
     * @memberof StateWizardPanelControlBase
     */
    public firstForm: string = '';

    /**
     * 步骤标识集合
     *
     * @type {*}
     * @memberof MobWizardPanelControlBase
     */
    public stepTags: any = {};

    /**
     * 步骤集合
     *
     * @type {*}
     * @memberof MobWizardPanelControlBase
     */
    public steps: any[] = [];

    /**
     * 状态属性
     *
     * @type {string}
     * @memberof MobWizardPanelControlBase
     */
    public stateField: string = '';

    /**
     * 是否是状态向导
     *
     * @type {boolean}
     * @memberof MobWizardPanelControlBase
     */
    public isStateWizard: boolean = false;

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof MobWizardPanelControlBase
     */
    public wizardState: Subject<ViewState> = new Subject();

    /**
     * 是否FormLoad被阻塞
     *
     * @type {boolean}
     * @memberof MobWizardPanelControlBase
     */
    public hasFormLoadBlocked: boolean = false;

    /**
     * 步骤值
     *
     * @readonly
     * @memberof MobWizardPanelControlBase
     */
    get stepsValue() {
        const index = this.wizardForms.findIndex(((item: IPSDEWizardForm) => {
            return `${this.controlInstance.name}_form_${item.formTag?.toLowerCase()}` === this.activeForm;
        }))
        if (index != -1) {
            return this.wizardForms[index].formTag;
        }
        return this.wizardForms[0].formTag;
    }


    /**
     * 部件模型数据初始化实例
     *
     * @memberof MobWizardPanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit(args);
        await this.ctrlModelFill();
        this.stateField = (this.controlInstance.getStatePSAppDEField() as IPSAppDEField)?.codeName?.toLowerCase();
        this.isStateWizard = this.controlInstance.getPSDEWizard()?.stateWizard || false;
        this.initAction = (this.controlInstance.getInitPSControlAction() as IPSControlAction)?.getPSAppDEMethod()?.codeName || 'Get';
        this.finishAction = (this.controlInstance.getFinishPSControlAction() as IPSControlAction)?.getPSAppDEMethod()?.codeName || 'Update';
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.service = new AppMobWizardPanelService(this.controlInstance, this.context);
            await this.service.loaded();
        }
        this.initFirstForm();
    }

    /**
     * 部件模型填充
     *
     * @return {*} 
     * @memberof MobWizardPanelControlBase
     */
    public async ctrlModelFill() {
        const wizard: IPSDEWizard | null = this.controlInstance.getPSDEWizard();
        if (!wizard) {
            return;
        }
        await this.controlInstance.fill();
        const wizardForms: Array<IPSDEWizardForm> = wizard.getPSDEWizardForms() || [];
        for (const form of wizardForms) {
            await form.fill();
            await form.getPSDEWizardStep()?.fill();
        }
    }

    /**
     * 部件初始化
     * 
     * @memberof MobWizardPanelControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        this.regFormActions();
        if (this.activeForm) {
            this.historyForms.push(this.activeForm);
        }
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (Object.is(tag, this.name)) {
                    if (Object.is('load', action)) {
                        this.doInit(data);
                    }
                }
            });
        }
    }

    /**
     * 部件挂载
     *
     * @memberof ControlBase
     */
    public ctrlMounted(args?: any) {
        super.ctrlMounted(args);
    }

    /**
     * 初始化当前激活表单
     * 
     * @memberof StateWizardPanelControlBase
     */
    public initFirstForm() {
        const wizard: IPSDEWizard | null = this.controlInstance.getPSDEWizard();
        const wizardForms: Array<IPSDEWizardForm> = wizard?.getPSDEWizardForms() || [];
        if (wizard && wizardForms.length > 0) {
            const firstForm = wizardForms.find((form: any) => { return form.firstForm; })
            if (firstForm) {
                this.firstForm = `${this.controlInstance.name}_form_${firstForm.formTag?.toLowerCase()}`;
            }
        }
    }

    /**
     * 注册表单步骤行为
     *
     * @memberof MobWizardPanelControlBase
     */
    public regFormActions() {
        const wizard: IPSDEWizard | null = this.controlInstance.getPSDEWizard();
        const wizardForms: Array<IPSDEWizardForm> = wizard?.getPSDEWizardForms() || [];
        const wizardSteps: Array<IPSDEWizardStep> = wizard?.getPSDEWizardSteps() || [];
        if (wizard && wizardForms.length > 0) {
            wizardForms.forEach((stepForm: IPSDEWizardForm) => {
                const formName = `${this.controlInstance.name}_form_${stepForm.formTag?.toLowerCase()}`;
                const editForm: IPSDEWizardEditForm = (this.controlInstance.getPSDEEditForms() || []).find((form: IPSDEEditForm) => {
                    return form.name === formName;
                }) as IPSDEWizardEditForm;
                const action = {
                    loadAction: editForm?.getGetPSControlAction()?.actionName || 'Get',
                    preAction: editForm?.getGoBackPSControlAction()?.actionName,
                    saveAction: editForm?.getUpdatePSControlAction()?.actionName || "Update",
                    actions: stepForm.getStepActions() || [],
                }
                this.regFormAction(formName, action, this.getStepTag(wizardSteps, stepForm?.getPSDEWizardStep()?.stepTag as string));
            })
        }
        if (wizardSteps.length > 0) {
            wizardSteps.forEach((steps: IPSDEWizardStep) => {
                this.steps.push(steps.stepTag);
            })
        }
    }

    /**
     * 上一步
     *
     * @memberof MobWizardPanelControlBase
     */
    public async prevStep() {
        const length = this.historyForms.length;
        if (length > 1) {
            this.curState = 'PREV';
            if (this.stepActions[this.activeForm].preAction) {
                if (!(await this.handleCtrlEvents('onbeforeprev', { action: this.stepActions[this.activeForm].preAction, data: this.formParam }))) {
                    return;
                }
                this.wizardState.next({ tag: this.activeForm, action: 'panelaction', data: { action: this.stepActions[this.activeForm].preAction, emitAction: 'save', data: this.formParam } });
                if (!(await this.handleCtrlEvents('onprevsuccess', { action: this.stepActions[this.activeForm].preActionn, data: this.formParam }))) {
                    return;
                }
            } else {
                this.activeForm = this.historyForms[length - 1];
                setTimeout(() => {
                    this.formLoad();
                }, 1);
                this.historyForms.splice(length - 1, 1);
            }
        }
    }

    /**
     * 下一步
     *
     * @memberof MobWizardPanelControlBase
     */
    public async nextStep() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.activeForm) {
            if (this.$refs && (this.$refs[this.activeForm] as any)?.ctrl) {
                let form: any = (this.$refs[this.activeForm] as any).ctrl;
                if (await form.formValidateStatus()) {
                    this.curState = 'NEXT';
                    if (!(await this.handleCtrlEvents('onbeforenext', { action: this.stepActions[this.activeForm].preAction, data: this.formParam }))) {
                        return;
                    }
                    this.wizardState.next({ tag: this.activeForm, action: 'panelaction', data: { action: this.stepActions[this.activeForm].saveAction, emitAction: 'save', data: this.formParam } });
                    if (!(await this.handleCtrlEvents('onnextsuccess', { action: this.stepActions[this.activeForm].preActionn, data: this.formParam }))) {
                        return;
                    }
                } else {
                    this.$Notice.error(this.$t('app.commonWords.rulesException'));
                }
            }
        }
    }

    /**
     * 完成
     *
     * @memberof MobWizardPanelControlBase
     */
    public async onFinish() {
        if (this.activeForm) {
            if (this.$refs && this.$refs[this.activeForm] && (this.$refs[this.activeForm] as any).ctrl) {
                let form: any = (this.$refs[this.activeForm] as any).ctrl;
                if (await form.formValidateStatus()) {
                    this.curState = 'FINISH';
                    this.wizardState.next({ tag: this.activeForm, action: 'panelaction', data: { action: this.stepActions[this.activeForm].saveAction, emitAction: 'save', data: this.formParam,callBack:()=>{
                        this.$Notice.success('操作完成');
                        this.closeView(this.formParam);
                    } } });
                } else {
                    this.$Notice.error(this.$t('app.commonWords.rulesException'));
                }
            }
        }
    }

    /**
    * 向导表单加载完成
    *
    * @param {*} args
    * @param {string} name
    * @memberof MobWizardPanelControlBase
    */
    public wizardpanelFormload(args: any, name: string) {
        if (args) {
            Object.assign(this.formParam, args);
        }
    }

    /**
     * 向导表单保存完成
     *
     * @param {*} args 
     * @param {string} name
     * @memberof MobWizardPanelControlBase
     */
    public wizardpanelFormsave(args: any, name: string) {
        Object.assign(this.formParam, args);
        if (Object.is(this.curState, 'NEXT')) {
            if(this.historyForms.findIndex((item:any)=>{return item == name}) === -1){
                this.historyForms.push(name);
            }
            if (this.getNextForm()) {
                this.activeForm = this.getNextForm();
                setTimeout(() => {
                    this.formLoad();
                }, 1);
            } else {
                this.doFinish();
            }
        } else if (Object.is(this.curState, 'PREV')) {
            const length = this.historyForms.length;
            if (length > 1) {
                this.activeForm = this.historyForms[length - 1];
                setTimeout(() => {
                    this.formLoad();
                }, 1);
                this.historyForms.splice(length - 1, 1);
            }
        } else if (Object.is(this.curState, 'FINISH')) {
            this.doFinish();
        }
    }

    /**
     * 获取步骤标识
     *
     * @memberof MobWizardPanelControlBase
     */
    public getStepTag(wizardSteps: Array<any>, tag: string) {
        if (wizardSteps && (wizardSteps.length > 0) && tag) {
            const curStep: any = wizardSteps.find((step: any) => {
                return step.stepTag === tag;
            })
            return curStep.stepTag || tag;
        } else {
            return tag;
        }
    }

    /**
     * 注册表单步骤行为
     *
     * @memberof MobWizardPanelControlBase
     */
    public regFormAction(name: string, actionParams: any, stepTag: any) {
        this.stepActions[name] = actionParams;
        this.stepTags[name] = stepTag;
        this.wizardForms.push(name);
    }

    /**
     * 初始化行为
     *
     * @memberof MobWizardPanelControlBase
     */
    public async doInit(opt: any = {}): Promise<any> {
        if (!(await this.handleCtrlEvents('onbeforeinit', { action: this.initAction, data: opt }))) {
            return null;
        }
        const arg: any = { ...opt };
        Object.assign(arg, { viewparams: this.viewparams });
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        this.onControlRequset('doInit', tempContext, arg);
        try {
            const response: any = await this.service.init(this.initAction, tempContext, arg, this.showBusyIndicator);
            this.onControlResponse('doInit', response);
            if (response && response.status === 200) {
                if (!(await this.handleCtrlEvents('oninitsuccess', { action: this.initAction, data: response?.data }))) {
                    return null;
                }
                this.formParam = response.data;
                if (response.data[this.appDeCodeName.toLowerCase()]) {
                    Object.assign(this.context, { [this.appDeCodeName.toLowerCase()]: response.data[this.appDeCodeName.toLowerCase()] });
                }
                this.computedActiveForm(this.formParam);
                this.formLoad();
                return response;
            }
        } catch (response: any) {
            if (!(await this.handleCtrlEvents('oniniterror', { action: this.initAction, data: response?.data }))) {
                return null;
            }
            this.onControlResponse('doInit', response);
            this.$Notice.error(this.$t('app.commonWords.rulesException'));
            return response;
        }
    }

    /**
     * 计算激活表单
     *
     * @param {*} data 数据
     * @memberof StateWizardPanelControlBase
     */
    public computedActiveForm(data: any) {
        if (data[this.stateField]) {
            if (Object.keys(this.stepTags).length > 0) {
                Object.keys(this.stepTags).forEach((name: string) => {
                    if (this.stepTags[name] === data[this.stateField]) {
                        this.activeForm = name;
                    }
                })
            }
            if (!this.activeForm) {
                this.activeForm = this.firstForm;
            }
        } else {
            this.activeForm = this.firstForm;
        }
        if (this.activeForm) {
            let index = this.wizardForms.indexOf(this.activeForm);
            this.wizardForms.forEach((item: any, inx: number) => {
                if (inx <= index) {
                    this.historyForms.push(item);
                }
            })
        }
    }

    /**
     * 表单加载
     *
     * @memberof MobWizardPanelControlBase
     */
    public formLoad() {
        if (!this.mountedMap.get(this.activeForm)) {
            this.hasFormLoadBlocked = true;
            return;
        }
        if (this.activeForm) {
            this.wizardState.next({ tag: this.activeForm, action: 'panelaction', data: { action: this.stepActions[this.activeForm].loadAction, emitAction: 'load', data: this.formParam } });
        }
    }

    /**
     * 完成行为
     *
     * @memberof MobWizardPanelControlBase
     */
    public async doFinish() {
        let arg: any = {};
        Object.assign(arg, this.formParam);
        Object.assign(arg, { viewparams: this.viewparams });
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        this.onControlRequset('doFinish', tempContext, arg);
        if (!(await this.handleCtrlEvents('onbeforefinish', { action: this.finishAction, data: arg }))) {
            return null;
        }
        try {
            const response: any = await this.service.finish(this.finishAction, tempContext, arg, this.showBusyIndicator);
            this.onControlResponse('doFinish', response);
            if (response && response.status === 200) {
                if (!(await this.handleCtrlEvents('onfinishsuccess', { action: this.finishAction, data: response?.data }))) {
                    return null;
                }
                const data = response.data;
                this.ctrlEvent({
                    controlname: this.controlInstance.name,
                    action: 'finish',
                    data: data,
                });
                AppCenterService.notifyMessage({ name: this.appDeCodeName, action: 'appRefresh', data: data });
                return response
            }
        } catch (response: any) {
            if (!(await this.handleCtrlEvents('onfinisherror', { action: this.finishAction, data: response?.data }))) {
                return null;
            }
            this.onControlResponse('doFinish', response);
            this.$Notice.error(this.$t('app.commonWords.rulesException'));
            return response;
        }
    }

    /**
     * 获取下一步向导表单
     *
     * @memberof MobWizardPanelControlBase
     */
    public getNextForm() {
        if (this.formParam && this.formParam['srfnextform']) {
            return `${this.controlInstance.name}_form_${this.formParam['srfnextform'].toLowerCase()}`;
        } else {
            let index = this.wizardForms.indexOf(this.activeForm);
            if (index >= 0) {
                if (this.wizardForms[index + 1]) {
                    return this.wizardForms[index + 1];
                }
            }
            return undefined;
        }
    }

    /**
     * 是否隐藏
     *
     * @param {string} type
     * @memberof MobWizardPanelControlBase
     */
    public isHidden(type: string) {
        const actions: Array<string> = this.stepActions[this.activeForm].actions;
        if (actions && actions.indexOf(type) < 0) {
            return true;
        }
        return false;
    }

    /**
     * 初始化挂载状态集合
     *
     * @memberof ControlBase
     */
    public initMountedMap() {
        this.controlInstance.getPSDEEditForms()?.forEach((item: any) => {
            this.mountedMap.set(item.name, false);
        })
    }


    /**
     * 部件事件
     * @param ctrl 部件 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof MobWizardPanelControlBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (action == 'controlIsMounted') {
            this.setIsMounted(controlname);
            if (this.hasFormLoadBlocked) {
                this.formLoad();
                this.hasFormLoadBlocked = false;
            }
        } else if (Object.is(action, "save")) {
            this.wizardpanelFormsave(data, controlname);
        } else if (Object.is(action, "load")) {
            this.wizardpanelFormload(data, controlname);
        }
    }

}