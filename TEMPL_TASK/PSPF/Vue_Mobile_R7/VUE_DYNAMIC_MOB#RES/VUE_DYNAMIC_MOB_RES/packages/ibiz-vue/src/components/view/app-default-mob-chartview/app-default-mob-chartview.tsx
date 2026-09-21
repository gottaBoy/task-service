import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MobChartViewBase } from '../../../view/mob-chart-view-base';
import { AppLayoutService } from '../../../app-service';

/**
 * 应用图表视图基类
 *
 * @export
 * @class AppDefaultMobChartView
 * @extends {ChartViewBase}
 */
@Component({})
export default class AppDefaultMobChartView extends MobChartViewBase {

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppDefaultMobChartView
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobChartView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobChartView
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
     * 监听当前视图环境参数变化
     * 
     * @memberof AppDefaultMobChartView
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
     * @memberof AppDefaultMobChartView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderViewHeaderButton(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                this.renderQuickGroup(),
                this.renderQuickSearch(),
                this.renderMainContent(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 实体移动端图表视图渲染
     * 
     * @memberof AppDefaultMobChartView
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-DEFAULT`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, showCaptionBar: this.showCaptionBar },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDefaultMobChartView
     */
    public destroyed() {
        this.viewDestroyed();
    }

}