import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';
import { CreateElement } from 'vue';
import { EditView4Base } from '../../../view/editview4-base';

/**
 * 应用实体编辑视图（上下关系）基类
 *
 * @export
 * @class AppEditView4Base
 * @extends {EditViewBase}
 */
export class AppEditView4Base extends EditView4Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppEditView4Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppEditView4Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppEditView4Base
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
     * @memberof AppEditView4Base
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
     * 绘制表单
     *
     * @return {*} 
     * @memberof EditView3Base
     */
    public renderMainForm() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { slot: 'mainform', props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染关系视图
     *
     * @return {*}  {*}
     * @memberof AppEditView4Base
     */
    public renderDrView(): any {
        if (this.drItem) {
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
                        },
                        dynamicProps: {
                            viewdata: JSON.stringify(viewData),
                            viewparam: JSON.stringify(viewParam),
                        }
                    },
                    key: Util.createUUID(),
                    class: "view-container2",
                    on: {
                    }
                })
            )
        }
    }

    /**
     * 渲染数据分页栏部件
     *
     * @return {*} 
     * @memberof AppEditView4Base
     */
    public renderDrTab() {
        if (!this.drtabInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drtabInstance);
        return this.$createElement(targetCtrlName, {
            slot: 'default',
            props: targetCtrlParam,
            ref: this.drtabInstance?.name,
            on: targetCtrlEvent
        });
    }

    /**
     * 渲染主内容区
     *
     * @return {*} 
     * @memberof AppEditView4Base
     */
    public renderMainContent() {
        return (
            <div class="app-vc-tab__content">
                {this.renderDrTab()}
                {this.renderDrView()}
            </div>
        )
        
    }

    /**
      * 绘制目标部件
      *
      * @memberof AppEditView4Base
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
                this.renderMainForm(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppEditView4Base
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
     * @memberof AppEditView4Base
     */
    public destroyed() {
        this.viewDestroyed();
    }
}
