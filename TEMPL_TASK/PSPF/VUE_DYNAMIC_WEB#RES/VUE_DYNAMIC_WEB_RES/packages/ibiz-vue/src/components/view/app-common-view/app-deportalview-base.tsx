import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { DashboardViewBase } from '../../../view/dashboardview-base';
import { AppLayoutService } from '../../../app-service';

/**
 * 应用实体数据看板视图基类
 *
 * @export
 * @class AppDePortalViewBase
 * @extends {DashboardViewBase}
 */
export class AppDePortalViewBase extends DashboardViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDePortalViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDePortalViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDePortalViewBase
     */
    @Watch('dynamicProps',{
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal,oldVal)) {
           super.onDynamicPropsChange(newVal,oldVal);
        }
    }

    /**
     * 监听视图静态参数变化
     * 
     * @memberof AppDePortalViewBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal,oldVal)) {
            super.onStaticPropsChange(newVal,oldVal);
            this.noViewCaption = true;
        }
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppGridViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderToolBar(),
                this.renderSearchForm(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 实体数据看板视图渲染
     *
     * @memberof AppDePortalViewBase
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent:any = AppLayoutService.getLayoutComponent(`${this.viewInstance?.viewType}-${this.viewInstance?.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDePortalViewBase
     */
    public destroyed(){
        this.viewDestroyed();
    }
}
