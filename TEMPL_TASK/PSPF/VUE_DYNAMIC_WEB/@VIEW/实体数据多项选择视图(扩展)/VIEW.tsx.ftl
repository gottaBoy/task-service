import { CreateElement } from "vue";
import { Component } from 'vue-property-decorator';
import { throttle } from "ibiz-core";
import { AppMPickUpViewBase, VueLifeCycleProcessing } from "ibiz-vue";

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppMPickUpViewBase {

    /**
    * 绘制内容
    * 
    * @memberof ${srfclassname('${view.name}')}
    */
    public renderContent() {
        let cardClass = {
            'view-card': true,
            'view-no-caption': true,
            'view-no-toolbar': true,
        };
        return (
            <card class={cardClass} disHover={true} bordered={false}>                
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
     * 选择表格视图渲染
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