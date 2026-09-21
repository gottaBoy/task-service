import { ExpViewEngine } from './exp-view-engine';

/**
 * 地图导航视图界面引擎
 *
 * @export
 * @class MapExpViewEngine
 * @extends {ViewEngine}
 */
export class MapExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof MapExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.mapexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof MapExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }

}