import { MDViewEngine } from "./md-view-engine";

/**
 * 实体多编辑视图引擎
 *
 * @export
 * @class MEditViewEngine
 * @extends {MDViewEngine}
 */
export class MEditViewEngine extends MDViewEngine {

  /**
   * 多编辑视图面板
   *
   * @type {*}
   * @memberof MEditViewEngine
   */
  public mEditViewPanel: any;

  /**
   * 多编辑视图引擎初始化
   *
   * @param {*} options
   * @memberof MEditViewEngine
   */
  public init(options: any) {
    this.mEditViewPanel = options.meditviewpanel;
    super.init(options);
  }

  /**
   * 多编辑视图引擎加载
   *
   * @param {*} options
   * @memberof MEditViewEngine
   */
  public load(opts: any = {}): void {
    Object.assign(this.view.viewparams, opts);
    if (!this.isLoadDefault && this.view && this.view.isNavView) {
      this.view.renderNoDataShade();
    } else {
      this.view.removeNoDataShade();
    }
    if (!this.view.viewDefaultUsage) {
      return;
    }
    if (this.getSearchForm() && (this.isLoadDefault)) {
      const tag = this.getSearchForm().name;
      this.setViewState2({ tag: tag, action: 'loaddraft', viewdata: this.view.viewparams });
    } else if (this.getMDCtrl() && (this.isLoadDefault)) {
      const tag = this.getMDCtrl().name;
      this.setViewState2({ tag: tag, action: 'load', viewdata: Object.assign(this.view.viewparams, opts) });
    } else {
      this.isLoadDefault = true;
    }
  }

  /**
   * 部件事件处理
   *
   * @param {string} ctrlName 部件标识
   * @param {string} eventName 事件标识
   * @param {*} args 事件参数
   * @memberof MEditViewEngine
   */
  public onCtrlEvent(ctrlName: string, eventName: string, args: any) {
    if (Object.is(ctrlName, 'meditviewpanel')) {
      this.MDCtrlEvent(eventName, args);
    }
    super.onCtrlEvent(ctrlName, eventName, args);
  }

  public MDCtrlEvent(eventName: string, args: any) {
    if (Object.is(eventName, 'drdatasaved')) {
      this.emitViewEvent('drdatasaved', args);
    }
    if (Object.is(eventName, 'drdatachange')) {
      this.emitViewEvent('drdatachange', args);
    }
    super.MDCtrlEvent(eventName, args);
  }

  /**
   * 获取多编辑视图面板
   *
   * @return {*} 
   * @memberof MEditViewEngine
   */
  public getMDCtrl() {
    return this.mEditViewPanel;
  }

  /**
   * @description 视图销毁
   * @memberof MEditViewEngine
   */
  public destroyed() {
    super.destroyed();
    this.mEditViewPanel = null;
  }

}