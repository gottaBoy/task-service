import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobCalendarExpViewBase } from '../../../view/mob-calendar-exp-view-base';

/**
 * 应用列表导航视图基类
 *
 * @export
 * @class AppDefaultMobCalendarExpView
 * @extends {ListExpViewBase}
 */
@Component({})
export default class AppDefaultMobCalendarExpView extends MobCalendarExpViewBase {

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppDefaultMobCalendarExpView
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobCalendarExpView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobCalendarExpView
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
     * 监听静态参数变化
     * 
     * @memberof AppDefaultMobCalendarExpView
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
     * @memberof AppDefaultMobCalendarExpView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderMainContent(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                ...this.renderToolBars(),
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 实体移动端列表导航视图渲染
     * 
     * @memberof AppDefaultMobCalendarExpView
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

    /**
     * 销毁视图回调
     *
     * @memberof AppDefaultMobCalendarExpView
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
