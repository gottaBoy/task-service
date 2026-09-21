import { IPSAppDECalendarExplorerView, IPSCalendarExpBar } from '@ibiz/dynamic-model-api';
import { CalendarExpViewEngine, CalendarExpViewInterface, ModelTool } from 'ibiz-core';
import { ExpViewBase } from './expview-base';


/**
 * 日历导航视图基类
 *
 * @export
 * @class CalendarExpViewBase
 * @extends {ExpViewBase}
 * @implements {CalendarExpViewInterface}
 */
export class CalendarExpViewBase extends ExpViewBase implements CalendarExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof CalendarExpViewBase
     */
    public declare viewInstance: IPSAppDECalendarExplorerView;

    /**
     * 导航栏实例
     * 
     * @memberof CalendarExpViewBase
     */
    public declare expBarInstance: IPSCalendarExpBar;

    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof CalendarExpViewBase
     */
    public declare engine: CalendarExpViewEngine;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof CalendarExpViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            calendarexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化实体日历导航视图实例
     * 
     * @memberof CalendarExpViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDECalendarExplorerView;
        await super.viewModelInit();
        this.expBarInstance = ModelTool.findPSControlByType('CALENDAREXPBAR', this.viewInstance.getPSControls() || []);
    }

    /**
     * 处理占位比例变化
     *
     * @protected
     * @memberof CalendarExpViewBase
     */
    protected handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`, viewSplit: this.split });
            if (this.viewState && this.expBarInstance) {
                this.viewState.next({ tag: this.expBarInstance.name, action: 'updateSize', data: null });
            }
        }
    }

}