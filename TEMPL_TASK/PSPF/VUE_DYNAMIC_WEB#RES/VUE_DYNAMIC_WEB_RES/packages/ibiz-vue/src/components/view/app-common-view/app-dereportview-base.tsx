import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { DeReportViewBase } from '../../../view/dereportview-base';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';

/**
 * 应用实体报表视图基类
 *
 * @export
 * @class AppDeReportViewBase
 * @extends {DeReportViewBase}
 */
export class AppDeReportViewBase extends DeReportViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDeReportViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDeReportViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDeReportViewBase
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
     * @memberof AppDeReportViewBase
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
     * @memberof AppDeReportViewBase
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppDeReportViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderToolBar(),
                this.renderQuickGroup(),
                this.renderQuickSearch(),
                this.renderQuickSearchForm(),
                this.renderSearchBar(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 实体报表视图渲染
     * 
     * @memberof AppDeReportViewBase
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`,
        }, this.renderTargetControls());
    }
}