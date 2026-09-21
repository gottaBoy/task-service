import { IPSAppDECalendarView, IPSDECalendar } from '@ibiz/dynamic-model-api';
import { ModelTool, CalendarViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 日历视图基类
 *
 * @export
 * @class CalendarViewBase
 * @extends {MDViewBase}
 * @implements {CalendarViewInterface}
 */
export class CalendarViewBase extends MDViewBase implements CalendarViewInterface {

    /**
     * 视图实例
     * 
     * @memberof CalendarViewBase
     */
    public declare viewInstance: IPSAppDECalendarView;

    /**
     * 日历实例
     * 
     * @memberof CalendarViewBase
     */
    public calendarInstance!: IPSDECalendar;

    /**
     * 引擎初始化
     * 
     * @memberof CalendarViewBase
     */
    public engineInit(opts: any = {}) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.calendarInstance) {
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
                calendar: (this.$refs[this.calendarInstance?.name] as any).ctrl,
            }, opts)
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if(this.quickSearchFormInstance?.name && this.$refs[this.quickSearchFormInstance.name] ){
                engineOpts.quicksearchform = ((this.$refs[this.quickSearchFormInstance.name] as any).ctrl);
            }
            if(this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化日历视图实例
     * 
     * @param opts 
     * @memberof CalendarViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDECalendarView;
        await super.viewModelInit();
        this.calendarInstance = ModelTool.findPSControlByType("CALENDAR",this.viewInstance.getPSControls());
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof CalendarViewBase
     */
    public renderMainContent() {
        if (this.calendarInstance) {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.calendarInstance);
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.calendarInstance?.name, on: targetCtrlEvent });
        }
    }
}