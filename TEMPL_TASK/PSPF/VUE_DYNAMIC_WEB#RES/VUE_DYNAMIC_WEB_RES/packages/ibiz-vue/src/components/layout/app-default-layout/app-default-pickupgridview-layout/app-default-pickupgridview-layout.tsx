import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop,Component } from 'vue-property-decorator';
import { ModelTool, Util } from "ibiz-core";
import { IPSDESearchForm, IPSSearchBar } from "@ibiz/dynamic-model-api";

@Component({})
export class AppDefaultPickupGridViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultPickupGridViewLayout
     */
     public engineInit(opts: any): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 表格实例对象
        const gridInstance = ModelTool.findPSControlByType("GRID", controls);
        // 搜索表单实例
        const searchFormInstance = ModelTool.findPSControlByType('SEARCHFORM', controls) as IPSDESearchForm;
        // 快速搜索表单实例
        const quickSearchFormInstance = ModelTool.findPSControlByType('QUICKSEARCHFORM', controls) as IPSDESearchForm;
        // 搜索栏实例
        const searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', controls) as IPSSearchBar;
        if (this.engine && gridInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                grid: (this.$refs[gridInstance.name] as any).ctrl,
            }, opts)
            if (searchFormInstance?.name && this.$refs[searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[searchFormInstance.name] as any).ctrl);
            }
            if (quickSearchFormInstance?.name && this.$refs[quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[quickSearchFormInstance.name] as any).ctrl);
            }
            if (searchBarInstance?.name && this.$refs[searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

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
     * 绘制内容
     * 
     * @memberof AppDefaultPickupGridViewLayout
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
        ]
    }
}