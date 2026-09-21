import { IPSAppView, IPSDataViewExpBar, IPSDEDataView, IPSDERBase } from '@ibiz/dynamic-model-api';
import { DataViewExpBarControlInterface, Util } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';
/**
 * 卡片导航栏部件基类
 *
 * @export
 * @class FormControlBase
 * @extends {MainControlBase}
 */
export class DataViewExpBarControlBase extends ExpBarControlBase implements DataViewExpBarControlInterface {
    /**
     * 卡片视图导航栏的模型对象
     *
     * @type {*}
     * @memberof DataViewExpBarControlBase
     */
    public declare controlInstance: IPSDataViewExpBar;

    /**
     * 数据部件
     *
     * @memberof DataViewExpBarControlBase
     */
    protected declare $xDataControl: IPSDEDataView;

    /**
     * 处理数据部件参数
     *
     * @memberof GridExpBarControlBase
     */
     public async handleXDataCtrlOptions() {
        this.navViewModel = await this.$xDataControl?.getNavPSAppView()?.fill() as IPSAppView;
        if (this.navViewModel) {
            this.navViewName = this.navViewModel.modelPath;
        }
        this.navFilter = this.$xDataControl?.navFilter ? this.$xDataControl.navFilter : "";
        this.navPSDer = (this.$xDataControl?.getNavPSDER?.() as IPSDERBase) ? "n_" + (this.$xDataControl.getNavPSDER() as IPSDERBase).minorCodeName?.toLowerCase() + "_eq" : "";
        //  导航上下文
        const navContext = (this.$xDataControl as any).getPSNavigateContexts();
        if (navContext && navContext.length) {
            this.navigateContext = Util.formatNavParam(navContext);
        }
        //  导航参数
        const navParams = (this.$xDataControl as any).getPSNavigateParams();
        if (navParams && navParams.length) {
            this.navigateParams = Util.formatNavParam(navParams);
        }
  }

    /**
     * 部件事件处理
     *
     * @param {string} controlname 部件
     * @param {string} action 行为
     * @param {*} data 数据
     * @memberof DataViewExpBarControlBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (controlname != this.xDataControlName) {
            return;
        }
        super.onCtrlEvent(controlname, action, data);
    }

}
