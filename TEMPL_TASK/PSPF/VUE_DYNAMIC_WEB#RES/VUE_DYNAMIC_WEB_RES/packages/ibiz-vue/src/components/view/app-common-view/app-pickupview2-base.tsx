import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { Util, throttle } from 'ibiz-core';
import { PickupView2Base } from '../../../view/pickupview2-base';
import { AppLayoutService } from '../../..';

export class AppPickupView2Base extends PickupView2Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppPickupView2Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppPickupView2Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPickupView2Base
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
     * @memberof AppPickupView2Base
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
     * 渲染树导航栏
     *
     * @return {*} 
     * @memberof AppPickupView2Base
     */
    public renderTreeExpBar() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.treeExpBarInstance);
        Object.assign(targetCtrlParam.staticProps, { expMode: 'PICKUPVIEW' });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.treeExpBarInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染选择视图布局面板
     *
     * @return {*} 
     * @memberof AppPickupView2Base
     */
    public renderPickupViewPanel() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.pickupViewPanelInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            selectedData: this.selectedData,
            context: this.navItem && Object.keys(this.navItem).length ? this.navItem.srfnavdata.context : Util.deepCopy(this.context),
            viewparams: this.navItem && Object.keys(this.navItem).length ? this.navItem.srfnavdata.viewparams : Util.deepCopy(this.viewparams)
        });
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: true,
            isShowButton: this.staticProps?.isShowButton,
            viewMode: 1
        });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.pickupViewPanelInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染选择视图面板
     * 
     * @memberof AppPickupView2Base
     */
    public renderMainContent() {
        return (
            <split
                v-model={this.split}
                mode="horizontal"
                on-on-move-end={() => this.handleSplitChange()}>
                <div class="view-content__body__left" slot='left'>
                    {this.renderTreeExpBar()}
                </div>
                <div class="view-content__body__right" slot='right'>
                    {this.renderPickupViewPanel()}
                </div>
            </split>
        )
    }

    /**
     * 渲染选择视图按钮
     * 
     * @memberof AppPickupView2Base
     */
    public renderFooter() {
        if (this.isShowButton) {
            return (
                <div slot="footer" class="view-footer__buttons">
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
     * 绘制目标部件
     *
     * @memberof AppPickupView2Base
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
     * 数据视图渲染
     * 
     * @memberof AppPickupView2Base
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
     * @memberof AppPickupView2Base
     */
    public destroyed() {
        this.viewDestroyed();
    }
}