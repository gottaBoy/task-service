import { ViewEngine } from './view-engine';
/**
 * 实体移动端日历导航视图界面引擎
 *
 * @export
 * @class MDViewEngine
 * @extends {ViewEngine}
 */
export class MobCalendarExpViewEngine extends ViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof MobCalendarExpViewEngine
     */
    protected calendarexpbar: any;


    /**
     * Creates an instance of MobCalendarExpViewEngine.
     * @memberof MobCalendarExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof MobCalendarExpViewEngine
     */
    public init(options: any = {}): void {
        this.calendarexpbar = options.calendarexpbar;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MobCalendarExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(eventName, 'selectionchange')) {
            this.calendarExpBarSelectionChange(args);
        }
    }



    /**
     * 数据关系栏选中
     *
     * @param {any[]} args
     * @memberof MobCalendarExpViewEngine
     */
    public calendarExpBarSelectionChange(data: any): void {
        if (data) {
            this.view.selection = data;
        }
        this.emitViewEvent('selectionchange', data);
    }

    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MobCalendarExpViewEngine
     */
    public getCalendarExpBar(): any {
        return this.calendarexpbar;
    }

    /**
     * 引擎加载
     *
     * @param {*} opts
     * @return {*}  {*}
     * @memberof MobCalendarExpViewEngine
     */
    public load(opts: any): any {
        super.load(opts);
        if (this.getCalendarExpBar()) {
            const tag = this.getCalendarExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { ...this.view.viewparams } });
        } else {
            this.isLoadDefault = true;
        }
    }
}