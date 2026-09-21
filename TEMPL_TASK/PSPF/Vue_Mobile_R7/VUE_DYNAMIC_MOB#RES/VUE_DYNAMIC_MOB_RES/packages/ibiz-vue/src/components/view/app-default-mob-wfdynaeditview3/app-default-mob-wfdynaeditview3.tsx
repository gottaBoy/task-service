import { Component, Prop, Emit, Watch } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Util } from 'ibiz-core';
import { MobWFDynaEditView3Base } from '../../../view';
import { AppLayoutService } from '../../../app-service';

/**
 * 工作流动态编辑视图（分页关系）
 *
 * @export
 * @class 
 * @extends {MobWFDynaEditView3Base}
 */
@Component({})
export default class AppDefaultMobWFDynaEditView3 extends MobWFDynaEditView3Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaEditView3
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaEditView3
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobWFDynaEditView3
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
     * @memberof AppDefaultMobWFDynaEditView3
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
     * @memberof AppDefaultMobWFDynaEditView3
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
    * 绘制目标部件
    *
    * @memberof AppDefaultMobEditView
    */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                this.renderMainContent(),
                this.renderViewFooter(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }
    
    /**
     * 编辑视图渲染
     * 
     * @memberof AppDefaultMobWFDynaEditView3
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, viewparams: this.viewparams, context: this.context }
        }, this.renderTargetControls());
    }

}