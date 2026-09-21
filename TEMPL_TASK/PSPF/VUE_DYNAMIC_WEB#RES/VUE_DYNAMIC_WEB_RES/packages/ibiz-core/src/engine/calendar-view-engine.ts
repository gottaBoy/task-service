import { MDViewEngine } from "./md-view-engine";

/**
 * 日历视图引擎
 *
 * @export
 * @class CalendarViewEngine
 * @extends {MDViewEngine}
 */
export class CalendarViewEngine extends MDViewEngine {

  /**
   * 日历部件
   *
   * @protected
   * @type {*}
   * @memberof CalendarViewEngine
   */
  protected calendar: any;

  /**
   * 引擎初始化
   *
   * @param {*} [options={}]
   * @memberof CalendarViewEngine
   */
  public init(options: any = {}): void {
    this.calendar = options.calendar;
    super.init(options);
  }

  /**
   * 部件事件处理
   *
   * @param {string} ctrlName 部件标识
   * @param {string} eventName 事件标识
   * @param {*} args 事件参数
   * @memberof CalendarViewEngine
   */
  public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
    if (Object.is(ctrlName, 'calendar')) {
      this.MDCtrlEvent(eventName, args);
    }
    super.onCtrlEvent(ctrlName, eventName, args);
  }

  /**
   * 获取日历部件
   *
   * @return {*}  {*}
   * @memberof CalendarViewEngine
   */
  public getMDCtrl(): any {
    return this.calendar;
  }

    /**
     * @description 视图销毁
     * @memberof CalendarViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.calendar = null;
    }
}