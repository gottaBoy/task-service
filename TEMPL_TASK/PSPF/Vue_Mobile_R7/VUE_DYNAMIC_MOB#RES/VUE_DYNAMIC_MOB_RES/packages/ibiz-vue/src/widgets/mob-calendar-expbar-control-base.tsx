import { IPSCalendarExpBar, IPSSysCalendar, IPSDERBase, IPSSysCalendarItem, IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { MobCalendarExpBarControlInterface, Util } from "ibiz-core";
import { MobExpBarControlBase } from './mob-expbar-control-base';
/**
 * 日历导航栏部件基类
 *
 * @export
 * @class MobCalendarExpBarControlBase
 * @extends {MainControlBase}
 */
export class MobCalendarExpBarControlBase extends MobExpBarControlBase implements MobCalendarExpBarControlInterface {

    /**
     * 日历导航栏的模型对象
     *
     * @type {*}
     * @memberof MobCalendarExpBarControlBase
     */
    public declare controlInstance: IPSCalendarExpBar;

    /**
     * 数据部件
     *
     * @memberof MobCalendarExpBarControlBase
     */
    protected declare $xDataControl: IPSSysCalendar;

    /**
     * 导航过滤项
     *
     * @type {*}
     * @memberof MobCalendarExpBarControlBase
     */
    public navFilter: any = {};

    /**
     * 导航关系
     *
     * @type {*}
     * @memberof MobCalendarExpBarControlBase
     */
    public navPSDer: any = {};

    /**
     * 导航视图名称
     *
     * @type {*}
     * @memberof MobCalendarExpBarControlBase
     */
    public navViewName: any = {};

    /**
     * 导航参数
     *
     * @type {*}
     * @memberof MobCalendarExpBarControlBase
     */
    public navParam: any = {};

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MobCalendarExpBarControlBase
     */
    public computeTargetCtrlData(controlInstance: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.staticProps, {
            calendarMode: "EXPBAR"
        });
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * load完成事件
     * 
     * @memberof MobCalendarExpBarControlBase
     */
    public onLoad(args: any, tag?: string, $event2?: any) {
        if (!this.selection.view) {
            this.onSelectionChange(args);
        }
        if (this.$xDataControl) {
            this.$emit('ctrl-event', { controlname: this.$xDataControl.name, action: "load", data: args });
        }
    }

    /**
     * 处理数据部件参数
     *
     * @memberof GridExpBarControlBase
     */
    public async handleXDataCtrlOptions() {
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
     * 初始化导航参数
     * 
     * @param params 初始化参数
     * @memberof ExpBarControlBase
     */
    public initNavParam(params: any) {
        if (params && params.length > 0) {
            let navParams: any = {};
            params.forEach((param: any) => {
                const navParam = {
                    [param.key]: param.rawValue ? param.value : "%" + param.value + "%",
                }
                Object.assign(navParams, navParam);
            });
            return navParams;
        } else {
            return null;
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
    public onSelectionChange(args: any[]): void {
        let tempContext: any = {};
        let tempViewParam: any = {};
        if (args.length === 0) {
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
            if (calendarItem.getNavPSAppView()) {
                Object.assign(tempContext, {
                    viewpath: calendarItem.getNavPSAppView()?.modelPath
                })
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
                this.$emit("ctrl-event", { controlname: this.controlInstance.name, action: "selectionchange", data: params });
            }
        })
    }
}
