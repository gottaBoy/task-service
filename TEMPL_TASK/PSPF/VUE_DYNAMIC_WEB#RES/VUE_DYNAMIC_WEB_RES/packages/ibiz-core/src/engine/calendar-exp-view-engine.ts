import { ExpViewEngine } from './exp-view-engine';

/**
 * 日历导航视图界面引擎
 *
 * @export
 * @class CalendarExpViewEngine
 * @extends {ViewEngine}
 */
export class CalendarExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof CalendarExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.calendarexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof CalendarExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}