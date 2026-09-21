import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { ModelTool, Util } from "ibiz-core";

@Component({})
export class AppDefaultPickupViewLayout extends AppDefaultViewLayout {

    /**
     * 初始化视图的绘制参数
     *
     * @memberof AppDefaultPickupViewLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'view-container': true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`view-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`view-style-default`]: true });
        }
        if (codeName) {
            Object.assign(viewClassNames, { [Util.srfFilePath2(codeName)]: true });
        }
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [this.viewInstance.getPSSysCss()?.cssName]: true });
        }
        if (this.viewProxyMode) {
            Object.assign(viewClassNames, { 'isproxy': true });
        }
        // 无视图头
        const noHeader = !this.showCaption && !this.viewIsshowToolbar && !this.$slots.quickGroupSearch && !this.$slots.quickSearch;
        if (noHeader) {
            Object.assign(viewClassNames, { 'noheader': true });
        }
        // 无视图标题
        if (!this.showCaption) {
            Object.assign(viewClassNames, { 'nocaption': true });
        }
        // 无工具栏
        if (!this.viewIsshowToolbar) {
            Object.assign(viewClassNames, { 'notoolbar': true });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultPickupViewLayout
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 选择视图面板实例
        const pickUpViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", controls);
        this.engine.init({
            view: this,
            pickupViewPanel: (this.$refs[pickUpViewPanelInstance?.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderContent() {
        return [
            <div class='view-content'>
                {this.$slots.topMessage || this.$slots.quickGroupSearch || this.$slots.quickSearch || this.$slots.searchForm ? <div class="view-content__top">
                    {this.$slots.topMessage}
                    {this.$slots.quickGroupSearch}
                    {this.$slots.quickSearch}
                    {this.$slots.searchForm}
                </div> : null}
                <div class="view-content__body">
                    {this.$slots.default}
                </div>
                {this.$slots.bottomMessage ? <div class="view-content__bottom">
                    {this.$slots.bottomMessage}
                </div> : null}
            </div>,
            this.$slots.footer ? <div class="view-footer">
                {this.$slots.footer}
            </div> : null
        ]
    }
}