import { Component } from 'vue-property-decorator';
import { AppCustomViewBase, VueLifeCycleProcessing } from "ibiz-vue";
import { Util } from 'ibiz-core';
import { IPSControl } from '@ibiz/dynamic-model-api';

/**
 *  ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {AppPortalViewBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppCustomViewBase {

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
    public renderViewHeader(): any {
        return [
            this.showCaption ? <span class='caption-info'>{this.model?.srfCaption}</span> : null
        ]
    }

    /**
     * @description 绘制内容
     *
     * @return {*} 
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderContent() {
        let cardClass = {
            'view-card': true,
            'view-no-caption': !this.showCaption,
            'view-no-toolbar': !this.showToolbar,
        };
        return (
            <card class={cardClass} disHover={true} bordered={false}>
                {(this.showCaption || this.showToolbar) && (
                    <div slot='title' class='header-container' key='view-header'>
                        {this.renderViewHeader()}
                    </div>
                )}
                {this.renderTopMessage()}
                <div class='content-container'>
                    {this.renderBodyMessage()}
                </div>
                {this.renderBottomMessage()}
            </card>
        );
    }

    /**
     * 实体自定义视图渲染
     * 
     * @memberof ${srfclassname('${view.name}')}
     */
   public render() {
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