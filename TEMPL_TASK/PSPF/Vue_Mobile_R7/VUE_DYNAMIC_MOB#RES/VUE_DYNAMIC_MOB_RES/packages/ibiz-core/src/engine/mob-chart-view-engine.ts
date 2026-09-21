import { MDViewEngineBase } from './md-view-engine-base';

/**
 * 实体移动端图表视图界面引擎
 *
 * @export
 * @class MobChartViewEngine
 * @extends {ViewEngine}
 */
export class MobChartViewEngine extends MDViewEngineBase {

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
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'chart')) {
            this.chartEvent(eventName, args);
        }
    }

    /**
     * 图表事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof ChartViewEngine
     */
    public chartEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'beforeload')) {
            this.MDCtrlBeforeLoad(args)
        }
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MDViewEngineBase
     */
    public getMDCtrl(): any {
        return this.chart;
    }
}