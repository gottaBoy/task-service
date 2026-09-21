import { ExpViewEngine } from './exp-view-engine';

/**
 * 表格导航视图界面引擎
 *
 * @export
 * @class GridExpViewEngine
 * @extends {ViewEngine}
 */
export class GridExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof GridExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.gridexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof GridExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}