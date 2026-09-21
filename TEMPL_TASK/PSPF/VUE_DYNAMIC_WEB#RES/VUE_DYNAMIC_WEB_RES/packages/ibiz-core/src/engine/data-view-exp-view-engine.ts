import { ExpViewEngine } from './exp-view-engine';

/**
 * 卡片视图导航视图界面引擎
 *
 * @export
 * @class DataViewExpViewEngine
 * @extends {ViewEngine}
 */
export class DataViewExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof DataViewExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.dataviewexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof DataViewExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}