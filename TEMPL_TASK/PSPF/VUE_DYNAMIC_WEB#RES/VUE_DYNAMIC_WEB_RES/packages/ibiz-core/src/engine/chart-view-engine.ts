import { MDViewEngine } from './md-view-engine';

/**
 * 实体图表视图界面引擎
 *
 * @export
 * @class ChartViewEngine
 * @extends {SearchViewEngine}
 */
export class ChartViewEngine extends MDViewEngine {

    /**
     * 图表对象
     *
     * @type {*}
     * @memberof ChartViewEngine
     */
    public chart: any;

    /**
     * 图表初始化
     *
     * @param {*} options
     * @memberof ChartViewEngine
     */
    public init(options: any): void {
        this.chart = options.chart;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof ChartViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'chart')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 获取数据部件
     *
     * @returns {*}
     * @memberof ChartViewEngine
     */
    public getMDCtrl(): any {
        return this.chart;
    }

    /**
     * @description 视图销毁
     * @memberof ChartViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.chart = null;
    }
}