import { IPSAppDEDashboardView, IPSDEDashboard, IPSDESearchForm } from '@ibiz/dynamic-model-api';
import { ModelTool, PortalViewEngine, DashboardViewInterface, DataServiceHelp } from 'ibiz-core';
import { MainViewBase } from './mainview-base';

/**
 * 实体数据看板视图基类
 *
 * @export
 * @class DashboardViewBase
 * @extends {MainViewBase}
 * @implements {DashboardViewInterface}
 */
export class DashboardViewBase extends MainViewBase implements DashboardViewInterface {

    /**
     * 数据视图视图实例
     * 
     * @memberof DashboardViewBase
     */
    public declare viewInstance: IPSAppDEDashboardView;

    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof DashboardViewBase
     */
    public declare engine: PortalViewEngine;

    /**
     * 数据看板实例
     *
     * @public
     * @type {IPSDEDashboard}
     * @memberof DashboardViewBase
     */
    public dashboardInstance !: IPSDEDashboard;

    /**
     * 搜索表单实例
     *
     * @public
     * @type {IPSDESearchForm}
     * @memberof DashboardViewBase
     */
    public searchFormInstance !: IPSDESearchForm;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof DashboardViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            dashboard: (this.$refs[this.dashboardInstance?.name] as any)?.ctrl,
            searchform: (this.$refs[this.searchFormInstance?.name] as any)?.ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

    /**
     * 初始化视图实例
     *
     * @memberof DashboardViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.dashboardInstance = ModelTool.findPSControlByName('dashboard', this.viewInstance.getPSControls()) as IPSDEDashboard;
        this.searchFormInstance = ModelTool.findPSControlByName('searchform', this.viewInstance.getPSControls()) as IPSDESearchForm;
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.appEntityService = await DataServiceHelp.getInstance().getService(this.viewInstance.getPSAppDataEntity(), { context: this.context });
        }
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof DashboardViewBase
     */
    public renderMainContent() {
        if (!this.dashboardInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.dashboardInstance);
        Object.assign(targetCtrlParam.staticProps, { noPadding: true });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.dashboardInstance?.name,
            on: targetCtrlEvent,
        });
    }

    /**
     * 渲染搜索表单
     * 
     * @memberof DashboardViewBase
     */
    public renderSearchForm() {
        if (!this.searchFormInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.searchFormInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            isExpandSearchForm: true
        });
        return this.$createElement(targetCtrlName, { slot: 'searchForm', props: targetCtrlParam, ref: this.searchFormInstance?.name, on: targetCtrlEvent });
    }

}
