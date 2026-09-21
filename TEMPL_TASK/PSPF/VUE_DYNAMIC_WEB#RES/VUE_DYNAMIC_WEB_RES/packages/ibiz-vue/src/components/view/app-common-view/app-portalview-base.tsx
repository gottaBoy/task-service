import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { PortalViewBase } from '../../../view/portalview-base';

/**
 * 应用门户视图基类
 *
 * @export
 * @class AppPortalViewBase
 * @extends {PortalViewBase}
 */
export class AppPortalViewBase extends PortalViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppPortalViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppPortalViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPortalViewBase
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
     * @memberof AppPortalViewBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
            this.noViewCaption = true;
        }
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppPortalViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 应用门户视图渲染
     *
     * @memberof AppPortalViewBase
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService, viewparams: this.viewparams, context: this.context },
            ref: `${this.viewInstance.codeName}Layout`,
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppPortalViewBase
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
