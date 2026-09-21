import { ExpViewEngine } from './exp-view-engine';

/**
 * 实体树导航视图界面引擎
 *
 * @export
 * @class TreeExpViewEngine
 * @extends {ViewEngine}
 */
export class TreeExpViewEngine extends ExpViewEngine {

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof TreeExpViewEngine
     */
    public init(options: any): void {
        this.expBar = options.treeexpbar;
        super.init(options);
    }

    /**
     * @description 视图销毁
     * @memberof TreeExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }
    
    /**
     * 导航栏数据部件加载之前
     *
     * @protected
     * @param {*} arg
     * @memberof TreeExpViewEngine
     */
    protected handleBeforeLoad(args: any = {}) {
        let otherQueryParam: any = {};
        if (this.view && this.view.quickGroupData) {
            Object.assign(otherQueryParam, this.view.quickGroupData);
        }
        let isSearch = false;
        if (args.query) {
            isSearch = true;
        }
        Object.assign(args, { viewparams: otherQueryParam , isSearch });
    }
}