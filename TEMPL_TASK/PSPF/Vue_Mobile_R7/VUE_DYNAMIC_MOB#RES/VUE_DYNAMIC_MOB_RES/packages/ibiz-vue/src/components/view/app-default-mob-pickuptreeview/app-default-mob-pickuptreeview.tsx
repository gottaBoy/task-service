import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobPickupTreeViewBase } from '../../../view';

@Component({})
export default class AppDefaultMobPickUpTreeView extends MobPickupTreeViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobPickUpTreeView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobPickUpTreeView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobPickUpTreeView
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
     * @memberof AppDefaultMobPickUpTreeView
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
     * @memberof AppDefaultPickUpMDView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderQuickSearch(),
                this.renderMainContent(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 选择树视图渲染
     * 
     * @memberof AppDefaultMobPickUpTreeView
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
     * @memberof AppDefaultMobPickUpTreeView
     */
     public destroyed() {
        this.viewDestroyed();
    }


}
