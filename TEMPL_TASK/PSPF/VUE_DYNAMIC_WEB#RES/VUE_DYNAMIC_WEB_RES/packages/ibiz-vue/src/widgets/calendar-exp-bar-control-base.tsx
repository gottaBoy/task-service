import { IPSCalendarExpBar, IPSDERBase, IPSSysCalendar, IPSSysCalendarItem, IPSAppDERedirectView } from '@ibiz/dynamic-model-api';
import { IPSAppDataEntity } from '@ibiz/dynamic-model-api';
import { CalendarExpBarControlInterface, Util } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';
/**
 * 日历导航部件基类
 * 
 * 
 */
export class CalendarExpBarControlBase extends ExpBarControlBase implements CalendarExpBarControlInterface {

    /**
     * 导航栏部件模型对象
     * 
     * @memberof CalendarExpBarControlBase
     */
    public declare controlInstance: IPSCalendarExpBar;

    /**
     * 数据部件
     *
     * @memberof CalendarExpBarControlBase
     */
    public declare $xDataControl: IPSSysCalendar;

    /**
     * 导航过滤项
     *
     * @type {*}
     * @memberof CalendarExpBarControlBase
     */
    public navFilter: any = {};

    /**
     * 导航关系
     *
     * @type {*}
     * @memberof CalendarExpBarControlBase
     */
    public navPSDer: any = {};

    /**
     * 初始化日历导航部件实例
     *
     * @memberof CalendarExpBarControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.initNavView();
    }

    /**
     * 初始化导航视图参数
     * 
     * @memberof CalendarExpBarControlBase
     */
    public initNavView() {
        const calendarItems = this.$xDataControl?.getPSSysCalendarItems();
        let navViewName = {};
        let navParam = {};
        let navFilter = {};
        let navPSDer = {};
        if (calendarItems && calendarItems.length > 0) {
            calendarItems.forEach((item: IPSSysCalendarItem) => {
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
     * 刷新
     *
     * @memberof CalendarExpBarControlBase
     */
    public refresh(): void {
        if (this.$xDataControl) {
            const calendarContainer: any = (this.$refs[this.xDataControlName] as any).ctrl;
            calendarContainer.refresh();
        }
    }

    /**
     * 日历部件的选中数据事件
     * 
     *
     * @param {any[]} args 选中数据
     * @return {*}  {void}
     * @memberof CalendarExpBarControlBase
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
        const calendarItem: IPSSysCalendarItem | null | undefined = ((this.$xDataControl as IPSSysCalendar).getPSSysCalendarItems() || []).find((item: IPSSysCalendarItem) => {
            return item.itemType === arg.itemType;
        });
        const calendarItemEntity: IPSAppDataEntity | null | undefined = calendarItem?.getPSAppDataEntity();
        if (calendarItem && calendarItemEntity) {
            Object.assign(tempContext, { [calendarItemEntity.codeName?.toLowerCase()]: arg[calendarItemEntity.codeName?.toLowerCase()] });
            Object.assign(tempContext, { srfparentdename: calendarItemEntity.codeName, srfparentdemapname: (calendarItemEntity as any)?.getPSDEName(), srfparentkey: arg[calendarItemEntity.codeName?.toLowerCase()] });
            if (this.navFilter && this.navFilter[arg.itemType] && !Object.is(this.navFilter[arg.itemType], "")) {
                Object.assign(tempViewParam, { [this.navFilter[arg.itemType]]: arg[calendarItemEntity.codeName?.toLowerCase()] });
            }
            if (this.navPSDer && this.navFilter[arg.itemType] && !Object.is(this.navPSDer[arg.itemType], "")) {
                Object.assign(tempViewParam, { [this.navPSDer[arg.itemType]]: arg[calendarItemEntity.codeName?.toLowerCase()] });
            }
            if (this.navParam && this.navParam[arg.itemType] && this.navParam[arg.itemType].navigateContext && Object.keys(this.navParam[arg.itemType].navigateContext).length > 0) {
                let _context: any = Util.computedNavData(arg.curdata, tempContext, tempViewParam, this.navParam[arg.itemType].navigateContext);
                Object.assign(tempContext, _context);
            }
            if (this.navParam && this.navParam[arg.itemType] && this.navParam[arg.itemType].navigateParams && Object.keys(this.navParam[arg.itemType].navigateParams).length > 0) {
                let _params: any = Util.computedNavData(arg.curdata, tempContext, tempViewParam, this.navParam[arg.itemType].navigateParams);
                Object.assign(tempViewParam, _params);
            }
            const navViewModel = calendarItem.getNavPSAppView();
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
                const params = {
                    data: args,
                    srfnavdata: {
                        context: tempContext,
                        viewparams: tempViewParam
                    }
                };
                this.calcNavigationToolbarState(false, arg);
                this.$emit("ctrl-event", { controlname: this.controlInstance.name, action: "selectionchange", data: params });
            }
        })
    }
}