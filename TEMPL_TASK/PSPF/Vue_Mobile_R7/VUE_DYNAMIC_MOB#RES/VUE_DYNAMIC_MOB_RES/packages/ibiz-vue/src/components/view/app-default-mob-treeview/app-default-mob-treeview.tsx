import { Component, Prop, Emit, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobTreeViewBase } from '../../../view/mob-tree-view-base';

@Component({})
export default class AppDefaultMobTreeView extends MobTreeViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobTreeView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobTreeView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobTreeView
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
     * @memberof AppDefaultMobTreeView
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
     * @memberof AppDefaultMobTreeView
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderViewHeaderButton(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderQuickSearch(),
                this.renderBottomMessage(),
                this.renderMainContent(),
                ...this.renderToolBars(),
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 树视图渲染
     * 
     * @memberof AppDefaultMobTreeView
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
     * @memberof AppDefaultMobTreeView
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
