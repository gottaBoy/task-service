import { ModelTool, MobDataViewInterface } from 'ibiz-core';
import { MainViewBase } from './main-view-base';
import { IPSAppDEDashboardView, IPSDEDashboard } from '@ibiz/dynamic-model-api';

/**
 * 移动端实体数据看板视图基类
 *
 * @export
 * @class MobDashboardViewBase
 * @extends {MainViewBase}
 */
export class MobDashboardViewBase extends MainViewBase implements MobDataViewInterface {

    /**
     * 数据视图视图实例
     * 
     * @memberof MobDashboardViewBase
     */
    public declare viewInstance: IPSAppDEDashboardView;

    /**
     * 数据看板实例
     *
     * @public
     * @type {IBizDashboardModel}
     * @memberof MobDashboardViewBase
     */
    public dashboardInstance !: IPSDEDashboard;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof MobDashboardViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.dashboardInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            }, opts)
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化列表视图实例
     *
     * @memberof MobDashboardViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.dashboardInstance = ModelTool.findPSControlByName('dashboard', this.viewInstance.getPSControls() || []);
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobDashboardViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.dashboardInstance);
        return <ion-content scroll-y={this.enableControlUIAuth}>{this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.dashboardInstance.name,
            on: targetCtrlEvent,
        })}</ion-content>;
    }
}
