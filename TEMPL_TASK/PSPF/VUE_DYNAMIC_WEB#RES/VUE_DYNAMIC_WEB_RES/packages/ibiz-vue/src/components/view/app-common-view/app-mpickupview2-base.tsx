import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MPickUpView2Base } from '../../../view/mpickupview2-base';
import { AppLayoutService } from '../../..';

export class AppMPickUpView2Base extends MPickUpView2Base {
    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppMPickUpView2Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppMPickUpView2Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMPickUpView2Base
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
     * @memberof AppMPickUpView2Base
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
     * @memberof AppMPickUpView2Base
     */
    public destroyed(){
        this.viewDestroyed();
    }
    
    /**
     * 渲染树导航栏
     *
     * @return {*} 
     * @memberof AppMPickUpView2Base
     */
    public renderTreeExpBar() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.treeExpBarInstance);
        Object.assign(targetCtrlParam.staticProps, { expMode: 'PICKUPVIEW' });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.treeExpBarInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染选择视图面板
     *
     * @return {*} 
     * @memberof AppMPickUpView2Base
     */
    public renderPickupViewPanel() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.pickupViewPanelInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            selectedData: this.selectedData,
            context: this.navItem && Object.keys(this.navItem).length ? this.navItem.srfnavdata.context : Util.deepCopy(this.context),
            viewparams: this.navItem && Object.keys(this.navItem).length ? this.navItem.srfnavdata.viewparams : Util.deepCopy(this.viewparams)
        });
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: false,
            isShowButton: this.staticProps?.isShowButton,
            viewMode: 1
        });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.pickupViewPanelInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染部件内容
     *
     * @return {*} 
     * @memberof AppMPickUpView2Base
     */
    public renderControlContent() {
        return (
            <split
                v-model={this.split}
                mode="horizontal"
                on-on-move-end={() => this.handleSplitChange()}>
                <div class="view-content__body__transfer__left__treeexpbar" slot='left'>
                    {this.renderTreeExpBar()}
                </div>
                <div class="view-content__body__transfer__left__pickupviewpanel" slot='right'>
                    {this.renderPickupViewPanel()}
                </div>
            </split>
        )
    }

    /**
     * 渲染主内容区
     *
     * @return {*} 
     * @memberof AppMPickUpView2Base
     */
    public renderMainContent() {
        return (
            <div class="view-content__body__transfer">
                <div class="view-content__body__transfer__left" style={{ width: !this.isShowButton ? '100%' : '' }}>
                    {this.renderControlContent()}
                </div>
                {this.isShowButton && <div class="view-content__body__transfer__center">
                    {this.renderButtons()}
                </div>}
                {this.isShowButton && <div class="view-content__body__transfer__right">
                    {this.renderMpickerSelect()}
                </div>}
            </div>
        )
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppMPickUpView2Base
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
     * 渲染
     * 
     * @memberof AppMPickUpView2Base
     */
    public render(h: any) {
        if (!this.viewIsLoaded) {
            return;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance?.viewType}-${this.viewInstance?.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`
        }, this.renderTargetControls());
    }
}