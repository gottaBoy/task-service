import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { GridView4Base } from '../../../view';

/**
 * 应用实体表格视图（上下关系）基类
 *
 * @export
 * @class AppGridView4Base
 * @extends {GridViewBase}
 */
export class AppGridView4Base extends GridView4Base {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppGridView4Base
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppGridView4Base
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppGridView4Base
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
     * @memberof AppGridView4Base
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
     * 渲染主表格
     *
     * @return {*} 
     * @memberof AppGridView4Base
     */
    public renderMainGrid() {
        if (!this.gridInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.gridInstance);
        Object.assign(targetCtrlParam.staticProps, { isSingleSelect: true, isSelectFirstDefault: true });
        return this.$createElement(targetCtrlName, {
            slot: 'mainGrid',
            props: targetCtrlParam,
            ref: this.gridInstance?.name,
            on: targetCtrlEvent
        });
    }

    /**
     * 渲染关系视图
     *
     * @return {*}  {*}
     * @memberof AppGridView4Base
     */
    public renderDrView(): any {
        if (this.drItem) {
            let viewData: any = Util.deepCopy(this.context);
            let viewParam = this.viewparams;
            if (this.drItem.disabled) {
                return;
            } else {
                if (this.drItem.localContext) {
                    Object.assign(viewData, this.drItem.localContext);
                }
                if (this.drItem.localViewParam) {
                    Object.assign(viewParam, this.drItem.localViewParam);
                }
            }
            Object.assign(viewData, { viewpath: this.drItem.getPSAppView()?.modelPath })
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
     * 渲染数据关系分页部件
     *
     * @return {*} 
     * @memberof AppGridView4Base
     */
    renderDrTab() {
        if (!this.drTabInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drTabInstance);
        Object.assign(targetCtrlParam.staticProps, { noPadding: true });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.drTabInstance?.name,
            on: targetCtrlEvent
        });
    }

    /**
     * 渲染主内容区
     *
     * @return {*} 
     * @memberof AppGridView4Base
     */
    public renderMainContent() {
        return (
            <div class="app-vc-drtab__content">
                {this.renderDrTab()}
                {this.renderDrView()}
            </div>
        )
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppGridView4Base
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
                this.renderMainGrid(),
                this.renderSearchForm(),
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
     * 编辑视图渲染
     * 
     * @memberof AppGridView4Base
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`,
            scopedSlots: {
                quickSearchFilter: (content: any) => {
                    return this.renderDefaultQuickSearchFilter(content);
                }
            }
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppGridView4Base
     */
    public destroyed() {
        this.viewDestroyed();
    }

}