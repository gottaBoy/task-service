import { MDViewEngine } from "./md-view-engine";

/**
 * 实体索引选择数据视图引擎
 *
 * @export
 * @class IndexPickupDataViewEngine
 * @extends {MDViewEngine}
 */
export class IndexPickupDataViewEngine extends MDViewEngine {

  /**
   * 数据视图部件
   *
   * @protected
   * @type {*}
   * @memberof IndexPickupDataViewEngine
   */
  protected dataView: any;

  /**
   * 引擎初始化
   *
   * @param {*} options
   * @memberof IndexPickupDataViewEngine
   */
  init(options: any) {
    this.dataView = options.dataview;
    super.init(options);
  }

  /**
   * 处理部件事件
   *
   * @param {string} ctrlName
   * @param {string} eventName
   * @param {*} args
   * @memberof IndexPickupDataViewEngine
   */
  public onCtrlEvent(ctrlName: string, eventName: string, args: any) {
    if (Object.is(ctrlName, 'dataview')) {
      this.MDCtrlEvent(eventName, args);
    }
    super.onCtrlEvent(ctrlName, eventName, args);
  }

  /**
   * 多数据部件事件处理
   *
   * @param {string} eventName
   * @param {*} args
   * @memberof IndexPickupDataViewEngine
   */
  public MDCtrlEvent(eventName: string, args: any) {
    if (Object.is(eventName, 'selectionchange')) {
      this.emitViewEvent('viewdataschange', args);
    }
  }

  /**
   * 获取多数据部件
   *
   * @return {*} 
   * @memberof IndexPickupDataViewEngine
   */
  getMDCtrl() {
    return this.dataView;
  }

    /**
     * @description 视图销毁
     * @memberof IndexPickupDataViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.dataView = null;
    }
}