import { ViewBase } from './view-base';
import { IPSAppPortalView, IPSDEDashboard } from '@ibiz/dynamic-model-api';
import { MobPortalViewInterface, ModelTool } from 'ibiz-core';

/**
 * 应用看板视图基类
 *
 * @export
 * @class MobPortalViewBase
 * @extends {MainViewBase}
 */
export class MobPortalViewBase extends ViewBase implements MobPortalViewInterface {

    /**
     * 数据视图视图实例
     * 
     * @memberof GanttViewBase
     */
    public declare viewInstance: IPSAppPortalView;

    /**
     * 数据看板实例
     *
     * @public
     * @type {IBizMobDashboardModel}
     * @memberof MobPortalViewBase
     */
    public dashboardInstance !: IPSDEDashboard;

    /**
     *  视图挂载
     *
     * @memberof ViewBase
     */
    public containerMounted() {
        this.viewState.next({ tag: 'dashboard', action: 'load', data: {} });
    }

    /**
     * 初始化列表视图实例
     *
     * @memberof MobPortalViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.dashboardInstance = ModelTool.findPSControlByName('dashboard', this.viewInstance.getPSControls()) as IPSDEDashboard;
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobPortalViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.dashboardInstance);
        return this.$createElement(targetCtrlName, {
                props: targetCtrlParam,
                ref: this.dashboardInstance.name,
                on: targetCtrlEvent,
            });
    }
}
