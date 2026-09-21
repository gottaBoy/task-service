import { MDViewEngine } from './md-view-engine';


/**
 * 视图引擎基础
 *
 * @export
 * @class GridViewEngine
 * @extends {MDViewEngine}
 */
export class GridViewEngine extends MDViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected grid: any;

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof GridViewEngine
     */
    public init(options: any = {}): void {
        this.grid = options.grid;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GridViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (this.grid && Object.is(ctrlName, this.grid.name)) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof GridViewEngine
     */
    public getMDCtrl(): any {
        return this.grid;
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof GridViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowdblclick') && this.gridRowAllowActive(2)) {
            this.doEdit(args);
            return;
        }
        if (Object.is(eventName, 'rowclick') && this.gridRowAllowActive(1)) {
            this.doEdit(args);
            return;
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.selectionChange(args);
            return;
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 表格是否被允许激活
     *
     * @param {number} mode
     * @returns {boolean}
     * @memberof GridViewEngine
     */
    public gridRowAllowActive(mode: number): boolean {
        return this.view.viewInstance?.gridRowActiveMode === mode ? true : false;
    }

    /**
     * @description 多数据部件加载完成
     * @param {any[]} args 
     * @memberof GridViewEngine
     */
    public MDCtrlLoad(args: any[]) {
      super.MDCtrlLoad(args);
      this.view.$nextTick(() => {
        this.setViewContentHeight();
      });
    }

    /**
     * @description 设置视图内容区高度
     * @memberof GridViewEngine
     */
    public setViewContentHeight() {
      const viewHeader:any = this.view.$el.getElementsByClassName('ivu-card-head')[0];
      const viewContent: any = this.view.$el.getElementsByClassName('ivu-card-body')[0];
      if (viewHeader?.offsetHeight && viewHeader?.offsetHeight != 49) {
        viewContent.style.height = `calc(100% - ${viewHeader.offsetHeight}px)`
      }
    }

    /**
     * @description 视图销毁
     * @memberof GridViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.grid = null;
    }
}