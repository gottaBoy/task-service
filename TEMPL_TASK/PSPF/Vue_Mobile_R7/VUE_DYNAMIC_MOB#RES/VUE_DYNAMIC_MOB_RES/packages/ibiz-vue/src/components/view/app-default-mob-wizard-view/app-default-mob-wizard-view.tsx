import { Util } from 'ibiz-core';
import { Component, Prop, Watch } from 'vue-property-decorator';
import { AppLayoutService } from '../../../app-service';
import { MobWizardViewBase } from '../../../view/mob-wizard-view-base';

@Component({})
export default class AppDefaultMobWizardView extends MobWizardViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWizardView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWizardView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobWizardView
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
     * 监听视图静态参数变化
     * 
     * @memberof AppDefaultMobWizardView
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
     * 绘制目标部件
     *
     * @memberof AppDefaultMobWizardView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                this.renderMainContent(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 实体移动端向导视图渲染
     *
     * @memberof AppDefaultMobWizardView
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService, viewparams: this.viewparams, context: this.context },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDefaultMobWizardView
     */
    public destroyed() {
        this.viewDestroyed();
    }
}