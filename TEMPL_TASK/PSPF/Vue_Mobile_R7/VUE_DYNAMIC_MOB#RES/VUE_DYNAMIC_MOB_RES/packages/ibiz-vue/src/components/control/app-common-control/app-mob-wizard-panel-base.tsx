import { Prop, Watch, Emit } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core';
import { MobWizardPanelControlBase } from '../../../widgets';
import { IPSDEEditForm, IPSDEWizard, IPSDEWizardEditForm, IPSDEWizardStep, IPSLanguageRes } from '@ibiz/dynamic-model-api';

export class AppMobWizardPanelBase extends MobWizardPanelControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMobWizardPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobWizardPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobWizardPanelBase
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobWizardPanelBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppMobWizardPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobWizardPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制步骤标题栏
     *
     * @memberof AppMobWizardPanelBase
     */
    public renderStepsTitle() {
        const wizardSteps: Array<IPSDEWizardStep> = (this.controlInstance.getPSDEWizard() as IPSDEWizard).getPSDEWizardSteps() || [];
        if (this.controlInstance.showStepBar && wizardSteps.length > 0) {
            return (
                <van-steps class="app-control-wizardpanel__header__steps" active={this.steps.indexOf(this.stepTags[this.activeForm])}>
                    {wizardSteps.map((step: IPSDEWizardStep) => {
                        const title = this.$tl((step.getTitlePSLanguageRes() as IPSLanguageRes)?.lanResTag, step.title);
                        const stepClassName = step.getTitlePSSysCss()?.cssName;
                        const sysImg = step.getPSSysImage();
                        return <van-step name={step.stepTag} class={stepClassName} >
                            <span slot="default">{title}</span>
                            {sysImg ? <app-ps-sys-image imageModel={sysImg} slot="active-icon"></app-ps-sys-image> : null}
                        </van-step>
                    })}
                </van-steps>
            );
        }
    }

    /**
     * 绘制步骤表单
     *
     * @memberof AppMobWizardPanelBase
     */
    public renderStepForm(form: IPSDEWizardEditForm) {
        if (form?.controlType != "FORM" || this.activeForm != form.name || form.formFuncMode != "WIZARDFORM") {
            return;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(form);
        Object.assign(targetCtrlParam.staticProps, { viewState: this.wizardState });
        return this.$createElement(targetCtrlName, { key: Util.createUUID(), props: targetCtrlParam, ref: form.name, on: targetCtrlEvent});
    }

    /**
     * 绘制向导面板footer
     *
     * @memberof AppMobWizardPanelBase
     */
    public renderStepsFooter() {
        const wizard = this.controlInstance.getPSDEWizard() as IPSDEWizard;
        const finishCaption = wizard.finishCaption ? wizard.finishCaption : this.$t('app.wizardpanel.complete');
        const nextCaption = wizard.nextCaption ? wizard.nextCaption : this.$t('app.wizardpanel.next');
        const prevCaption = wizard.prevCaption ? wizard.prevCaption : this.$t('app.wizardpanel.back');
        const prev = this.$tl((wizard.getPrevCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, prevCaption);
        const next = this.$tl((wizard.getNextCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, nextCaption);
        const finish = this.$tl((wizard.getFinishCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, finishCaption);
        return (
            <footer class="app-control-wizardpanel__footer__buttons">
                {!this.isHidden('PREV') ? <app-mob-button on-click={(...params: any[]) => throttle(this.prevStep, params, this)} type="primary" text={prev}></app-mob-button> : null}
                {!this.isHidden('NEXT') ? <app-mob-button on-click={(...params: any[]) => throttle(this.nextStep, params, this)} type="primary" text={next}></app-mob-button> : null}
                {!this.isHidden('FINISH') ? <app-mob-button on-click={(...params: any[]) => throttle(this.onFinish, params, this)} type="primary" text={finish}></app-mob-button> : null}
            </footer>
        );
    }




    /**
     * 绘制向导面板
     *
     * @memberof AppMobWizardPanelBase
     */
    public render() {
        if (!this.controlIsLoaded || !this.activeForm) {
            return null;
        }
        const editForms: Array<IPSDEEditForm> = this.controlInstance.getPSDEEditForms() || [];
        const controlClassNames = this.renderOptions.controlClassNames;
        return (
            <div class={controlClassNames}>
                <div class="control-header app-control-wizardpanel__header">
                    {
                        this.renderStepsTitle()
                    }
                </div>
                <div class="control-content app-control-wizardpanel__content">
                    {
                        [
                            editForms.length > 0 ?
                                editForms.map((editForm: IPSDEEditForm) => {
                                    return this.renderStepForm(editForm as IPSDEWizardEditForm);
                                }) : null,
                        ]
                    }
                </div>
                <div class="control-footer app-control-wizardpanel__footer">
                    {
                        this.renderStepsFooter()
                    }
                </div>
            </div>
        );
    }
}