import { Component, Prop, Emit, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobPanelViewBase } from '../../../view';

@Component({})
export default class AppDefaultMobDePanelView extends MobPanelViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobDePanelView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobDePanelView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobDePanelView
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
     * @memberof AppDefaultMobDePanelView
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
     * @memberof AppDefaultMobDePanelView
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof AppDefaultMobDePanelView
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.panelInstance);
        if (this.panelInstance) {
            Object.assign(targetCtrlParam.dynamicProps, {
                navdatas: this.navdatas
            });
            Object.assign(targetCtrlParam.staticProps, {
                isLoadDefault: true
            });
        }
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.panelInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppDefaultMobDePanelView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage(),
                ...this.renderToolBars(),
            ]
        } else {
            return this.renderViewControls();
        }
    }
    /**
     * 选择多数据视图渲染
     * 
     * @memberof AppDefaultMobDePanelView
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, showCaptionBar: this.showCaptionBar },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }

}
