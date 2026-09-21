import { IPSAppView, IPSDEList, IPSDERBase, IPSListExpBar } from '@ibiz/dynamic-model-api';
import { ListExpBarControlInterface, Util } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';
/**
 * 列表导航栏部件基类
 *
 * @export
 * @class ListExpBarControlBase
 * @extends {MainControlBase}
 */
export class ListExpBarControlBase extends ExpBarControlBase implements ListExpBarControlInterface {

    /**
     * 列表导航栏的模型对象
     *
     * @type {*}
     * @memberof ListExpBarControlBase
     */
    public declare controlInstance: IPSListExpBar;

    /**
     * 数据部件
     *
     * @memberof ListExpBarControlBase
     */
    protected declare $xDataControl: IPSDEList;

    /**
     * 处理数据部件参数
     *
     * @memberof GridExpBarControlBase
     */
    public async handleXDataCtrlOptions() {
        //TODO 导航关系
        this.navViewModel = await this.$xDataControl?.getNavPSAppView()?.fill() as IPSAppView;
        if (this.navViewModel) {
            this.navViewName = this.navViewModel.modelFilePath;
        }
        this.navFilter = this.$xDataControl?.navFilter ? this.$xDataControl.navFilter : "";
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
    * 执行搜索
    *
    * @memberof ListExpBarControlBase
    */
    public search() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const list: any = (this.$refs[`${this.xDataControlName.toLowerCase()}`] as any).ctrl;
        if (list) {
            this.viewState.next({ tag: this.xDataControlName, action: "load", data: { query: this.searchText } });
        }
    }

}
