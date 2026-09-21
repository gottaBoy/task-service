import { CreateElement } from "vue";
import { Component } from 'vue-property-decorator';
import { throttle } from "ibiz-core";
import { AppWizardViewBase, VueLifeCycleProcessing } from "ibiz-vue";

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {AppWizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppWizardViewBase {
    /**
     * 是否展示标题
     *
     * @type {boolean}
     * @memberof ${srfclassname('${view.name}')}
     */
    public showCaption: boolean = ${view.isShowCaptionBar()?c} && !this.noViewCaption;

    /**
     * 是否展示工具栏
     *
     * @type {boolean}
     * @memberof ${srfclassname('${view.name}')}
     */
    public showToolbar: boolean = ${view.hasPSControl('toolbar')?c};

    /**
     * 绘制头部内容
     * 
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewHeader() {
        return [
            <div class="caption-container">
                {this.showCaption ? <span class='caption-info'>{this.renderCaptionInfo()}</span> : null}
            </div>,
            <div class="bar-container">
                {this.showToolbar ? this.renderToolBar() : null}
            </div>
        ]
    }

    /**
     * 渲染视图工具栏
     *
     * @memberof ${srfclassname('${view.name}')}
     */
     public renderToolBar() {
        if (!(this.toolbarModels && this.toolbarModels.length > 0)) {
            return null;
        }
        return (
            <view-toolbar
                slot='toolbar'
                mode='<#if view.getViewStyle?? && view.getViewStyle()??>${view.getViewStyle()}<#else>DEFAULT</#if>'
                counterServiceArray={this.counterServiceArray}
                isViewLoading={this.viewLoadingService?.isLoading}
                toolbarModels={this.toolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, [data, $event], this);
                }}
            ></view-toolbar>
        );
    }

    /**
    * 绘制内容
    * 
    * @memberof ${srfclassname('${view.name}')}
    */
    public renderContent() {
        const noHeader = !this.showCaption || !this.showToolbar
        let cardClass = {
            'view-card': true,
            'view-no-caption': !this.showCaption,
            'view-no-toolbar': !this.showToolbar
        };
        return (
            <card class={cardClass} disHover={true} bordered={false}>
                {!noHeader ? <div slot='title' class='header-container' key='view-header'>
                    {this.renderViewHeader()}
                </div> : null}
                {this.renderTopMessage()}
                <div class='content-container'>
                    {this.renderBodyMessage()}
                    {this.renderMainContent()}
                </div>
                {this.renderBottomMessage()}
            </card>
        );
    }

    /**
     * 实体向导视图渲染
     * 
     * @memberof ${srfclassname('${view.name}')}
     */
    public render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        let viewClass = {
            'view-container': true,
            'view-default': true,
            '${view.getViewType()?lower_case}': true,
            '${srffilepath2(view.getCodeName())}': true,
            <#if view.getPSSysCss?? && view.getPSSysCss()??>'${view.getPSSysCss().getCssName()}': true</#if>
        };
        return (
            <div class={viewClass}>
                <app-studioaction
                    viewInstance={this.viewInstance}
                    context={this.context}
                    viewparams={this.viewparams}
                    viewName={'${view.getCodeName()?lower_case}'}
                    viewTitle={this.model?.srfCaption} />
                {this.renderContent()}
            </div>
        );
    }
}