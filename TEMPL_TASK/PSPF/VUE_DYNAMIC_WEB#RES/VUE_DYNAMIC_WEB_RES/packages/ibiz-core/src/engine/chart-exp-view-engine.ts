import { ExpViewEngine } from './exp-view-engine';

/**
 * 图表导航视图界面引擎
 *
 * @export
 * @class ChartExpViewEngine
 * @extends {ViewEngine}
 */
export class ChartExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof ChartExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.chartexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof ChartExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}