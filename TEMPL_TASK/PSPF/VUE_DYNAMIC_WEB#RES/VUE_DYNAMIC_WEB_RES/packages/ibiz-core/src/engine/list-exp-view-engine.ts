import { ExpViewEngine } from './exp-view-engine';

/**
 * 列表导航视图界面引擎
 *
 * @export
 * @class ListExpViewEngine
 * @extends {ViewEngine}
 */
export class ListExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof ListExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.listexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof ListExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}