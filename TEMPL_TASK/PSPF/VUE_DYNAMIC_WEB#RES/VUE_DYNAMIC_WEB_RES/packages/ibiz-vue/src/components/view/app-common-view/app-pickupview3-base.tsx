import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core';
import { PickupView3Base } from '../../../view/pickupview3-base';
import { AppLayoutService } from '../../../app-service';
import { IPSDEPickupViewPanel } from '@ibiz/dynamic-model-api';

export class AppPickupView3Base extends PickupView3Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppPickupView3Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppPickupView3Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPickupView3Base
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
     * @memberof AppPickupView3Base
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
     * 渲染选择视图按钮
     * 
     * @memberof AppPickupView3Base
     */
    public renderFooter() {
        if (this.isShowButton) {
            return (
                <div class="view-footer__buttons" slot="footer">
                    <app-button
                        type="primary"
                        disabled={this.viewSelections.length > 0 ? false : true}
                        caption={this.viewButtonModel?.view_okbtn?.text}
                        on-onClick={(e: any) => throttle(this.onClickOk, e, this)}>
                    </app-button>
                    &nbsp;&nbsp;
                    <app-button
                        caption={this.viewButtonModel?.view_cancelbtn?.text}
                        on-onClick={(e: any) => throttle(this.onClickCancel, e, this)}>
                    </app-button>
                </div>
            )
        }
    }

    /**
     * 绘制视图布局面板
     *
     * @param {IPSDEPickupViewPanel} panel
     * @return {*} 
     * @memberof AppPickupView3Base
     */
    public renderPickupViewPanel(panel: IPSDEPickupViewPanel) {
        let { targetCtrlParam, targetCtrlEvent, targetCtrlName } = this.computeTargetCtrlData(panel);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: panel.name, on: targetCtrlEvent });
    }

    /**
     * 绘制分页
     *
     * @param {IPSDEPickupViewPanel} panel
     * @param {string} tabName
     * @return {*} 
     * @memberof AppPickupView3Base
     */
    public renderPickupViewPanelTab(panel: IPSDEPickupViewPanel, tabName: string) {
        const name = panel.name || panel.codeName;
        return (
            <tab-pane lazy={true} name={name} tab={tabName} label={this.$tl(panel.getCapPSLanguageRes()?.lanResTag, panel.caption)}>
                {this.renderPickupViewPanel(panel)}
            </tab-pane>
        )
    }

    /**
     * 绘制主内容区
     *
     * @return {*} 
     * @memberof AppPickupView3Base
     */
    public renderMainContent() {
        const tabName = `${this.appDeCodeName}_${this.viewInstance.viewType}_${this.viewInstance.name}`;
        return (
            <tabs value={this.activedPickupViewPanel} class="view-content__body__pickupview3tabs" name={tabName} on-on-click={($event: any) => throttle(this.tabPanelClick, [$event], this)} >
                {this.pickupViewPanelModels.map((panel: IPSDEPickupViewPanel) => {
                    return this.renderPickupViewPanelTab(panel, tabName);
                })}
            </tabs>
        )
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppPickupView3Base
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage(),
                this.renderFooter()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 数据视图渲染
     * 
     * @memberof AppPickupViewBase
     */
    render(h: CreateElement) {
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
     * @memberof AppPickupViewBase
     */
    public destroyed() {
        this.viewDestroyed();
    }
}