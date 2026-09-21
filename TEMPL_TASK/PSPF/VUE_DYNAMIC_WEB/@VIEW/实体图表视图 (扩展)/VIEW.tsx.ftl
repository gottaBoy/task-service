import { CreateElement } from "vue";
import { Component } from 'vue-property-decorator';
import { throttle } from "ibiz-core";
import { AppChartViewBase, VueLifeCycleProcessing } from "ibiz-vue";

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppChartViewBase {

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
     * 支持快速分组搜索
     *
     * @type {boolean}
     * @memberof ${srfclassname('${view.name}')}
     */
    public quickGroupSearch: boolean = ${view.isEnableQuickGroup()?c};

    /**
     * 支持快速搜索
     *
     * @type {boolean}
     * @memberof ${srfclassname('${view.name}')}
     */
    public quickSearch: boolean = ${view.isEnableQuickSearch()?c};

    /**
     * 绘制头部内容
     * 
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewHeader() {
        return [
            <div class="caption-container">
                {this.showCaption ? <span class='caption-info'>{this.renderCaptionInfo()}</span> : null}
                {this.quickGroupSearch ? this.renderQuickGroup() : null}
            </div>,
            <div class="bar-container">
                {this.quickSearch ? this.renderViewQuickSearch() : null}
                {this.showToolbar ? this.renderToolBar() : null}
            </div>
        ]
    }

    /**
     * 渲染快速搜索
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewQuickSearch() {
        <#if view.isEnableQuickSearch()>
            <#if view.isExpandSearchForm() == false>
                <#if view.hasPSControl('searchform')>
        const searchFormVNode = this.renderSearchForm();
        return this.renderDefaultQuickSearchFilter(searchFormVNode);
                <#elseif view.hasPSControl('searchbar')>
        const searchBarVNode = this.renderSearchBar();
        return this.renderDefaultQuickSearchFilter(searchBarVNode);
                <#else>
        return this.renderQuickSearch();
                </#if>
            <#else>
        return this.renderQuickSearch();
            </#if>
        <#else>
        return null;
        </#if>
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
        const noHeader = !this.showCaption && !this.showToolbar && !this.quickGroupSearch && !this.quickSearch
        let cardClass = {
            'view-card': true,
            'mdview-card': true,
            'view-no-caption': !this.showCaption,
            'view-no-toolbar': !this.showToolbar,
            'view-no-header': noHeader
        };
        return (
            <card class={cardClass} disHover={true} bordered={false}>
                {!noHeader ? <div slot='title' class='header-container' key='view-header'>
                    {this.renderViewHeader()}
                </div> : null}
                {this.renderTopMessage()}
                <#if view.isEnableQuickSearch() == false || view.isExpandSearchForm()>
                {this.renderSearchForm()}
                </#if>
                <div class='content-container'>
                    {this.renderBodyMessage()}
                    {this.renderMainContent()}
                </div>
                {this.renderBottomMessage()}
            </card>
        );
    }

    /**
     * 图表视图渲染
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