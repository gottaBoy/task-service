import { CreateElement } from "vue";
import { Component, Prop, Watch } from 'vue-property-decorator';
import { MobWizardViewBase } from "ibiz-vue";
import { Util, ThirdPartyService } from "ibiz-core";
import './${srffilepath2(view.name)}.less';

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {MobWizardViewBase}
 */
@Component({})
export class ${srfclassname('${view.name}')} extends MobWizardViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof ${srfclassname('${view.name}')}
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof ${srfclassname('${view.name}')}
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ${srfclassname('${view.name}')}
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
     * @memberof ${srfclassname('${view.name}')}
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
     * 渲染视图头部
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewHeader(): any {
        const captionBar = this.renderViewHeaderCaptionBar();
        return this.showCaptionBar ?
            <ion-header class='view-header'>
                <ion-toolbar class="view-header__top">
                    {!ThirdPartyService.getInstance().platform && captionBar ? captionBar : null}
                    {!this.toolbarModels['MOBNAVLEFTMENU'] ?
                        this.renderBackButton() :
                        this.toolbarModels['MOBNAVLEFTMENU'] ? <view-toolbar toolbarModel={this.toolbarModels['MOBNAVLEFTMENU']} toolBarAuth={this.toolBarAuth['MOBNAVLEFTMENU']} viewtag={this.viewtag} on-item-click={(data: any, $event: any) => { this.handleItemClick(data, $event); }}></view-toolbar> : null}
                    <view-toolbar toolbarModel={this.toolbarModels['MOBNAVRIGHTMENU']} toolBarAuth={this.toolBarAuth['MOBNAVRIGHTMENU']} viewtag={this.viewtag} on-item-click={(data: any, $event: any) => { this.handleItemClick(data, $event); }}></view-toolbar>
                </ion-toolbar>
                {this.renderTopMessage()}
            </ion-header> : null;
    }

    /**
     * 渲染视图主体内容
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewContent(): any {
        return (
            <div class='view-content'>
                {this.renderBodyMessage()}
                {this.renderMainContent()}
            </div>
        );
    }

    /**
     * 渲染视图底部
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderViewFooter() {
        return (
           (this.toolbarModels['MOBBOTTOMMENU'] || this.renderBottomMessage()) ? <ion-footer class="view-footer">
                {<view-toolbar toolbarModel={this.toolbarModels['MOBBOTTOMMENU']} toolBarAuth={this.toolBarAuth['MOBBOTTOMMENU']} viewtag={this.viewtag} on-item-click={(data: any, $event: any) => { this.handleItemClick(data, $event) }}></view-toolbar>}
                {this.renderBottomMessage()}
            </ion-footer>:null
        )
    }

    /**
     * 绘制内容
     * 
     * @memberof ${srfclassname('${view.name}')}
     */
    public renderContent(): any {
        return [
            this.renderViewHeader(),
            this.renderViewContent(),
            this.renderViewFooter()
        ];
    }

    /**
     * 渲染视图
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const viewClass = {
            'view-container': true,
            '${view.getViewType()?lower_case}': true,
            '${srffilepath2(view.codeName)?lower_case}': true,
            <#if view.getPSSysCss?? && view.getPSSysCss()??>'${view.getPSSysCss().cssName}': true</#if>
        };
        return (
            <ion-page className={viewClass}>
               {this.renderContent()}
            </ion-page>
        );
    }

    /**
     * 销毁视图回调
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public destroyed() {
        this.viewDestroyed();
    }
}