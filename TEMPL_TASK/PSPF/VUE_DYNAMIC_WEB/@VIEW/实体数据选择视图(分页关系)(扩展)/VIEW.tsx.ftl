import { Component, Prop, Vue } from 'vue-property-decorator';
import { Util } from "ibiz-core";
import { AppPickupView3Base , VueLifeCycleProcessing } from "ibiz-vue";

/**
 *  ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppPickupView3Base {

    /**
     * @description 绘制内容
     * @return {*} 
     * @memberof ${srfclassname('${view.name}')}
     */
    renderContent() {
        let cardClass = {
            'view-card': true,
            'view-no-caption': true,
            'view-no-toolbar': true
        };
        return (
            <card class={cardClass} disHover={true} bordered={false}>
                {this.renderTopMessage()}
                <div class='content-container'>
                    {this.renderBodyMessage()}
                    {this.renderMainContent()}
                    {this.renderPickButton()}
                </div>
                {this.renderBottomMessage()}
            </card>
        );
    }

    /**
     * 实体数据选择视图(分页关系)绘制
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