import { IPSControlHandler, IPSDESearchForm } from '@ibiz/dynamic-model-api';
import { MobSearchFormControlInterface } from 'ibiz-core';
import { MobFormControlBase } from './mob-form-control-base';

/**
 * 搜索表单部件基类
 *
 * @export
 * @class SearchFormControlBase
 * @extends {EditFormControlBase}
 */
export class MobSearchFormControlBase extends MobFormControlBase implements MobSearchFormControlInterface {

    /**
     * 部件模型实例对象
     *
     * @type {*}
     * @memberof MobFormControlBase
     */
    public declare controlInstance: IPSDESearchForm;

    /**
     * 是否展开搜索表单
     *
     * @type {*}
     * @memberof SearchFormControlBase
     */
    public isExpandSearchForm: any = false;


    /**
     * 搜索表单模式
     *
     * @type {('default' | 'modal')}
     * @memberof MobSearchFormControlBase
     */
    public searchFormModel: 'default' | 'modal' | string = 'default';

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.searchFormModel = newVal.searchFormModel || 'default';
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        this.isExpandSearchForm = newVal.isExpandSearchForm;
        super.onDynamicPropsChange(newVal, oldVal);
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof SearchFormControlBase
     */
    public async loadDraft(opt: any = {}, mode?: string): Promise<any> {
        if (!this.loadDraftAction) {
            this.$Notice.error(`${this.$t('app.view')} ${this.$t('app.ctrl.form')} loaddraftAction ${this.$t('app.notConfig')}`);
            return Promise.reject();
        }
        const arg: any = { ...opt };
        Object.assign(arg, this.viewparams);
        if (!(await this.handleCtrlEvents('onbeforeloaddraft', { action: this.loadDraftAction, data: opt }))) {
            return;
        }
        let response: any
        try {
            response = await this.service.loadDraft(this.loadDraftAction, { ...this.context }, arg, this.showBusyIndicator);
            if (response && response.status === 200) {
                if (!(await this.handleCtrlEvents('onloaddraftsuccess', { action: this.loadDraftAction, data: response?.data }))) {
                    return;
                }
                const data = response.data;
                if (this.appDeCodeName?.toLowerCase() && data[this.appDeCodeName.toLowerCase()]) {
                    Object.assign(this.context, { [this.appDeCodeName.toLowerCase()]: data[this.appDeCodeName.codeName.toLowerCase()] });
                }
                this.onFormLoad(data, 'loadDraft');
                this.ctrlEvent({
                    controlname: this.controlInstance.name,
                    action: 'load',
                    data: data,
                });
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        } catch (error) {
            if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loadDraftAction, data: response?.data }))) {
                return;
            }
        }
        return response;
    }

    /**
     * 表单值变化
     *
     * @param {{ name: string, newVal: any, oldVal: any }} param
     * @memberof SearchFormControlBase
     */
    public formDataChange(param: { name: string; newVal: any; oldVal: any }): void {
        super.formDataChange(param);
        this.ctrlEvent({
            controlname: this.controlInstance.name,
            action: 'valuechange',
            data: this.data,
        });
        this.autoSearch();
    }

    /**
     * 自动搜索
     *
     * @memberof MobSearchFormControlBase
     */
    public autoSearch() {
        if (!this.controlInstance.enableAutoSearch) {
            return;
        }
        this.search();
    }

    /**
     * 表单加载完成
     *
     * @param {*} [data={}]
     * @param {string} action
     * @memberof SearchFormControlBase
     */
    public async onFormLoad(data: any = {}, action: string): Promise<void> {
        this.setFormEnableCond(data);
        this.fillForm(data, action);
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 搜索
     *
     * @memberof SearchFormControlBase
     */
    public async search() {
        if (!(await this.handleCtrlEvents('onbeforesearch', { action: this.loadDraftAction, data: this.data }))) {
            return;
        }
        this.ctrlEvent({
            controlname: this.controlInstance.name,
            action: 'search',
            data: this.data,
        });
    }

    /**
     * 初始化搜索表单模型
     *
     * @memberof SearchFormControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.loadDraftAction = (this.controlInstance.getPSControlHandler() as IPSControlHandler)?.findPSControlHandlerAction('loaddraft')?.getPSAppDEMethod?.()?.codeName || 'GetDraft';
        this.loadAction = (this.controlInstance.getPSControlHandler() as IPSControlHandler)?.findPSControlHandlerAction('load')?.getPSAppDEMethod?.()?.codeName || 'Load';
    }

    /**
     * 重置
     *
     * @memberof SearchFormControlBase
     */
    public async reset() {
        if (!(await this.handleCtrlEvents('onbeforereset', { action: this.loadDraftAction, data: this.data }))) {
            return;
        }
        this.loadDraft({}, 'RESET');
    }

}
