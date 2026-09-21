import { Component } from 'vue-property-decorator';
import { AppMPickUpView2Base, VueLifeCycleProcessing } from "ibiz-vue";

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {AppMPickUpView2Base}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppMPickUpView2Base {

    /**
     * @description 绘制内容
     * @return {*} 
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
                <div class='content-container pickup-view'>
                    {this.renderBodyMessage()}
                    {this.renderMainContent()}
                </div>
                {this.renderBottomMessage()}
            </card>
        );
    }

    /**
     * @description 绘制实体数据多项选择视图(左右关系)
     * @return {*} 
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