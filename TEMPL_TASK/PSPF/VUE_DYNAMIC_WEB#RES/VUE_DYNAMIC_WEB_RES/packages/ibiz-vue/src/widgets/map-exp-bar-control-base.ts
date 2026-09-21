import { IPSDERBase, IPSMapExpBar, IPSSysMap, IPSSysMapItem, IPSAppDERedirectView } from '@ibiz/dynamic-model-api';
import { IPSAppDataEntity } from '@ibiz/dynamic-model-api';
import { MapExpBarControlInterface, Util } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';
/**
 * 地图导航部件基类
 * 
 * 
 */
export class MapExpBarControlBase extends ExpBarControlBase implements MapExpBarControlInterface {

    /**
     * 导航栏部件模型对象
     * 
     * @memberof MapExpBarControlBase
     */
    public declare controlInstance: IPSMapExpBar;

    /**
     * 数据部件
     *
     * @memberof MapExpBarControlBase
     */
    public declare $xDataControl: IPSSysMap;

    /**
     * 导航过滤项
     *
     * @type {*}
     * @memberof MapExpBarControlBase
     */
    public navFilter: any = {};

    /**
     * 导航关系
     *
     * @type {*}
     * @memberof MapExpBarControlBase
     */
    public navPSDer: any = {};

    /**
     * 初始化地图导航部件实例
     *
     * @memberof MapExpBarControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.initNavView();
    }

    /**
     * 初始化导航视图参数
     * 
     * @memberof MapExpBarControlBase
     */
    public initNavView() {
        const mapItems: IPSSysMapItem[] | null = this.$xDataControl?.getPSSysMapItems();
        let navViewName = {};
        let navParam = {};
        let navFilter = {};
        let navPSDer = {};
        if (mapItems && mapItems.length > 0) {
            mapItems.forEach((item: IPSSysMapItem) => {
                const viewName = {
                    [item.itemType]: item.getNavPSAppView() ? item.getNavPSAppView()?.modelPath : "",
                };
                Object.assign(navViewName, viewName);
                const param = {
                    [item.itemType]: {
                        navigateContext: this.initNavParam(item.getPSNavigateContexts()),
                        navigateParams: this.initNavParam(item.getPSNavigateParams()),
                    }
                }
                Object.assign(navParam, param);
                const filter = {
                    [item.itemType]: item.navFilter ? item.navFilter : "",
                }
                Object.assign(navFilter, filter);
                const psDer = {
                    [item.itemType]: item.getNavPSDER() ? "n_" + (item.getNavPSDER() as IPSDERBase).minorCodeName?.toLowerCase() + "_eq" : "",
                }
                Object.assign(navPSDer, psDer);
            })
        }
        this.navViewName = navViewName;
        this.navParam = navParam;
        this.navFilter = navFilter;
        this.navPSDer = navPSDer;
    }

    /**
     * 执行搜索
     *
     * @memberof GridExpBarControlBase
     */
    public onSearch() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let map: any = (this.$refs[`${this.xDataControlName}`] as any).ctrl;
        if (map) {
            map.load({ query: this.searchText });
        }
    }

    /**
     * 刷新
     *
     * @memberof MapExpBarControlBase
     */
    public refresh(): void {
        let map: any = (this.$refs[`${this.xDataControlName}`] as any).ctrl;
        if (map) {
            map.refresh({ query: this.searchText });
        }
    }

    /**
     * 地图部件的选中数据事件
     * 
     *
     * @param {any[]} args 选中数据
     * @return {*}  {Promise<void>}
     * @memberof MapExpBarControlBase
     */
    public async onSelectionChange(args: any[]): Promise<void> {
        let tempContext: any = {};
        let tempViewParam: any = {};
        if (args.length === 0) {
            this.calcNavigationToolbarState(true);
            return;
        }
        const arg: any = args[0];
        if (this.context) {
            Object.assign(tempContext, Util.deepCopy(this.context));
        }
        const mapItem: IPSSysMapItem | null | undefined = ((this.$xDataControl as IPSSysMap).getPSSysMapItems() || []).find((item: IPSSysMapItem) => {
            return item.itemType === arg.itemType;
        });
        const mapItemEntity: IPSAppDataEntity | null | undefined = mapItem?.getPSAppDataEntity();
        if (mapItem && mapItemEntity) {
            Object.assign(tempContext, { [mapItemEntity.codeName?.toLowerCase()]: arg[mapItemEntity.codeName?.toLowerCase()] });
            Object.assign(tempContext, { srfparentdename: mapItemEntity.codeName, srfparentdemapname: (mapItemEntity as any)?.getPSDEName(), srfparentkey: arg[mapItemEntity.codeName?.toLowerCase()] });
            if (this.navFilter && this.navFilter[arg.itemType] && !Object.is(this.navFilter[arg.itemType], "")) {
                Object.assign(tempViewParam, { [this.navFilter[arg.itemType]]: arg[mapItemEntity.codeName?.toLowerCase()] });
            }
            if (this.navPSDer && this.navFilter[arg.itemType] && !Object.is(this.navPSDer[arg.itemType], "")) {
                Object.assign(tempViewParam, { [this.navPSDer[arg.itemType]]: arg[mapItemEntity.codeName?.toLowerCase()] });
            }
            if (this.navParam && this.navParam[arg.itemType] && this.navParam[arg.itemType].navigateContext && Object.keys(this.navParam[arg.itemType].navigateContext).length > 0) {
                let _context: any = Util.computedNavData(arg.curdata, tempContext, tempViewParam, this.navParam[arg.itemType].navigateContext);
                Object.assign(tempContext, _context);
            }
            if (this.navParam && this.navParam[arg.itemType] && this.navParam[arg.itemType].navigateParams && Object.keys(this.navParam[arg.itemType].navigateParams).length > 0) {
                let _params: any = Util.computedNavData(arg.curdata, tempContext, tempViewParam, this.navParam[arg.itemType].navigateParams);
                Object.assign(tempViewParam, _params);
            }
            const navViewModel = mapItem.getNavPSAppView();
            if (navViewModel) {
                if (Object.is(navViewModel.viewType, 'DEREDIRECTVIEW')) {
                    const { modelPath } = await this.getRedirectViewModelPath(tempContext, tempViewParam, navViewModel as IPSAppDERedirectView);
                    Object.assign(tempContext, { viewpath: modelPath });
                } else {
                    Object.assign(tempContext, { viewpath: navViewModel.modelPath });
                }
            }
        }
        this.handleCtrlEvents('onselectionchange', { action: 'selectionchange', data: args }).then((res: boolean) => {
            if (res) {
                const param = {
                    data: args,
                    srfnavdata: {
                        context: tempContext,
                        viewparams: tempViewParam
                    }
                }
                this.calcNavigationToolbarState(false, arg);
                this.$emit("ctrl-event", { controlname: this.controlInstance.name, action: "selectionchange", data: param });
            }
        })
    }

}