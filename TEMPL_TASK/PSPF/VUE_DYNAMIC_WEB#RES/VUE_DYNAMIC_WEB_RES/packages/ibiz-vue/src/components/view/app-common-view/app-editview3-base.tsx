import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';
import { CreateElement } from 'vue';
import { EditView3Base } from '../../../view/editview3-base';

/**
 * 实体编辑视图（分页关系）视图基类
 *
 * @export
 * @class AppEditView3Base
 * @extends {EditViewBase}
 */
export class AppEditView3Base extends EditView3Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppEditView3Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppEditView3Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppEditView3Base
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
     * @memberof AppEditView3Base
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
     * @memberof AppEditView3Base
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderDataPanelInfo(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderToolBar(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 渲染表单
     *
     * @return {*} 
     * @memberof AppEditView3Base
     */
    public renderForm() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染关系视图
     *
     * @return {*}  {*}
     * @memberof AppEditView3Base
     */
    public renderDrView(): any {
        if (this.drItem && this.drItem.name !== 'form') {
            if (this.drItem.disabled) {
                return;
            }
            const viewData = this.drItem.srfnavdata?.context || this.context;
            const viewParam = this.drItem.srfnavdata?.viewparams || this.viewparams;
            return (
                this.$createElement('app-view-shell', {
                    props: {
                        staticProps: {
                            viewDefaultUsage: false,
                            appDeCodeName: this.appDeCodeName,
                            appDE:this.containerModel?.getPSAppDataEntity()
                        },
                        dynamicProps: {
                            viewdata: JSON.stringify(viewData),
                            viewparam: JSON.stringify(viewParam),
                        }
                    },
                    key: this.drItem.name,
                    class: "view-container2",
                    on: {
                    }
                })
            )
        }
    }

    /**
     * 渲染数据关系分页部件
     *
     * @return {*} 
     * @memberof AppEditView3Base
     */
    public renderDrTab() {
        if (!this.drtabInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drtabInstance);
        Object.assign(targetCtrlParam.staticProps, {
            needFirstSelected: false
        });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.drtabInstance?.name,
            on: targetCtrlEvent
        });
    }

    /**
     * 传染主内容区
     *
     * @return {*} 
     * @memberof AppEditView3Base
     */
    public renderMainContent() {
        return (
            <div class="app-vc-tab">
                <div class="app-vc-tab__header">
                    <span
                        class={["app-vc-tab__header__caption", (this.drItem && this.drItem.name === 'form') || !this.drItem ? 'is-active' : '']}
                        on-click={(event: any) => this.drTabChange({ name: 'form' }, event)}>
                        {this.drtabInstance ? this.$tl((this.drtabInstance.getEditItemCapPSLanguageRes()?.lanResTag, this.drtabInstance.editItemCaption)) : ''}
                    </span>
                    {this.renderDrTab()}
                </div>
                <div class="app-vc-tab__content">
                    <div class="app-vc-tab__content__form" style={this.drItem && this.drItem.name !== 'form' ? 'display: none;' : ''}>{this.renderForm()}</div>
                    {this.renderDrView()}
                </div>
            </div>
        )
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppEditView3Base
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            ref: `${this.viewInstance.codeName}Layout`,
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService }
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppEditView3Base
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
