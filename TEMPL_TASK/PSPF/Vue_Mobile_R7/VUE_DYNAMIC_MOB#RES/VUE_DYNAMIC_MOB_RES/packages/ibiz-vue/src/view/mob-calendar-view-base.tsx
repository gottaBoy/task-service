import { MDViewBase } from './md-view-base';
import { MobCalendarViewEngine, MobCalendarViewInterface, ModelTool } from 'ibiz-core';
import { IPSAppDEMobCalendarView, IPSDECalendar } from '@ibiz/dynamic-model-api';

export class MobCalendarViewBase extends MDViewBase implements MobCalendarViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobCalendarViewBase
     */
    public declare viewInstance: IPSAppDEMobCalendarView;

    /**
     * 日历实例
     * 
     * @memberof MobCalendarViewBase
     */
    public calendarInstance!: IPSDECalendar;

    /**
     * 引擎初始化
     * 
     * @memberof MobCalendarViewBase
     */
    public engineInit() {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            calendar: (this.$refs[this.calendarInstance.name] as any).ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault
        });
    }

    /**
     * 初始化日历视图实例
     * 
     * @param opts 
     * @memberof MobCalendarViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.calendarInstance = ModelTool.findPSControlByName('calendar', this.viewInstance.getPSControls() || []);
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {*} controlInstance
     * @returns
     * @memberof MobCalendarViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobCalendarViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.calendarInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.calendarInstance.name, on: targetCtrlEvent });
    }

}