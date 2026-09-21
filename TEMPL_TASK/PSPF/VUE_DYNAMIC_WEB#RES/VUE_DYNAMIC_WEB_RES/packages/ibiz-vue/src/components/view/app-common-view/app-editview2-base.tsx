import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';
import { EditView2Base } from '../../../view/editview2-base';

/**
 * 应用实体编辑视图(左右关系)基类
 *
 * @export
 * @class AppEditView2Base
 * @extends {EditView2Base}
 */
export class AppEditView2Base extends EditView2Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppEditView2Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppEditView2Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppEditView2Base
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
     * @memberof AppEditView2Base
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
     * @memberof AppEditView2Base
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
     * 渲染关系视图
     *
     * @return {*} 
     * @memberof AppEditView2Base
     */
    public renderDrView() {
        if (this.drItem && this.drItem.id !== this.editFormInstance.name) {
            const viewData = this.drItem.srfnavdata?.context || this.context;
            const viewParam = this.drItem.srfnavdata?.viewparams || this.viewparams;
            return this.$createElement('app-view-shell', {
                props: {
                    staticProps: {
                        viewDefaultUsage: false,
                        appDeCodeName: this.appDeCodeName
                    },
                    dynamicProps: {
                        viewdata: JSON.stringify(viewData),
                        viewparam: JSON.stringify(viewParam)
                    }
                },
                key: Util.createUUID(),
                class: 'view-container2',
                //  事件处理
                on: {}
            })
        }
    }

    /**
     * 渲染分页栏
     *
     * @return {*} 
     * @memberof AppEditView2Base
     */
    public renderDrbar() {
        if (!this.drbarInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drbarInstance);
        return this.$createElement(targetCtrlName, {
            slot: 'default',
            props: targetCtrlParam,
            ref: this.drbarInstance?.name,
            on: targetCtrlEvent,
        });
    }

    /**
     * 渲染主内容区
     *
     * @return {*} 
     * @memberof AppEditView2Base
     */
    public renderMainContent() {
        const width = this.drbarInstance.width >= 240 ? this.drbarInstance.width : 240;
        return (
            <layout class="app-vc-dabar">
                <sider class="app-vc-dabar__left" width={width}>
                    {this.editFormInstance && this.drbarInstance ?
                        <div
                            class={{ "app-vc-dabar__left__caption": true, "is-active": !(this.drItem && this.drItem.id !== this.editFormInstance.name) }}
                            on-click={this.drbarChange.bind(this)}>
                            <span>{this.drbarInstance.editItemCaption}</span>
                        </div> : null}
                    {this.renderDrbar()}
                </sider>
                <content class="app-vc-dabar__content" style={{ width: `calc(100% - ${width + 1}px)` }}>
                    <div
                        class="app-vc-dabar__content__form"
                        style={this.drItem && this.drItem.id !== this.editFormInstance.name ? 'display: none;' : ''}>{this.renderForm()}</div>
                    {this.renderDrView()}
                </content>
            </layout>
        )
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppEditView2Base
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
     * @memberof AppEditView2Base
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
