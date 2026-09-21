import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MPickUpViewBase } from '../../../view/mpickupview-base';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';

/**
 * 应用数据多项选择视图基类
 *
 * @export
 * @class AppMPickUpViewBase
 * @extends {MPickUpViewBase}
 */
export class AppMPickUpViewBase extends MPickUpViewBase {


    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppMPickUpViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppMPickUpViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMPickUpViewBase
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
     * @memberof AppMPickUpViewBase
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
     * @memberof AppMPickUpViewBase
     */
    public destroyed(){
        this.viewDestroyed();
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppMPickUpViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderToolBar(),
                this.renderMainContent(),
                this.renderBottomMessage(),
                this.renderFooter()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 视图渲染
     * 
     * @memberof AppMPickUpViewBase
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance?.viewType}-${this.viewInstance?.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }
}
