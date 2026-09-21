import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobWFDynaEditViewBase } from '../../../view/mob-wf-dyna-edit-view-base';

/**
 * 应用实体工作流动态编辑视图
 *
 * @export
 * @class AppDefaultMobWFDynaEditView
 * @extends {MobWFDynaEditViewBase}
 */
@Component({})
export default class AppDefaultMobWFDynaEditView extends MobWFDynaEditViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaEditView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaEditView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobWFDynaEditView
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
     * @memberof AppDefaultMobWFDynaEditView
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
     * @memberof AppDefaultMobWFDynaEditView
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
     * 初始化工具栏数据
     *
     * @memberof MobWFDynaEditViewBase
     */
    public renderToolBar() {
        return (
            <div class="wf-button-content">
                <div class="toolbar-container" on-click={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }}>
                    <ion-fab-button>
                        <ion-icon name="chevron-back-circle-outline"></ion-icon>
                    </ion-fab-button>
                </div>
            </div>
        );
    }

    /**
     * 绘制工作流按钮
     *
     * @return {*} 
     * @memberof MobWFDynaEditViewBase
     */
    public renderToolBarInfo() {
        return (
            <van-action-sheet actions={this.linkModel} cancel-text="取消" class="wf-action-sheet" get-container="#app" value={this.toolBarVisible} on-select={(item: any) => { this.WFViewEvent({ tag: 'WFButtonClick', value: item }), this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }} on-cancel={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }} on-click-overlay={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }}>
            </van-action-sheet>
        )
    }

    /**
     * 绘制底部按钮
     *
     * @memberof MobWFDynaEditViewBase
     */
    public renderFooter() {
        return (
            <div class="fab_container" slot="footer">
                {this.renderToolBar()}
                {this.renderToolBarInfo()}
            </div>
        )
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobWFDynaEditViewBase
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return;
        }
        let {
            targetCtrlName,
            targetCtrlParam,
            targetCtrlEvent,
        } = this.computeTargetCtrlData(this.editFormInstance);
        Object.assign(targetCtrlParam.staticProps, {
            isAutoLoad: true,
        });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.editFormInstance.name,
            on: targetCtrlEvent,
        });
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
                this.renderFooter(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppDefaultMobWFDynaEditView
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, viewparams: this.viewparams, context: this.context }
        }, this.renderTargetControls());
    }

}