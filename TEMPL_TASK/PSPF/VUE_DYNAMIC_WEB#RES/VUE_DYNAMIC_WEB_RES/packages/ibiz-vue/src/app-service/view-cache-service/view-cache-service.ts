/**
 * 视图缓存
 *
 * @export
 * @class ViewCache
 */
 export class ViewCache {
    /**
     * 唯一实例
     *
     * @private
     * @static
     * @memberof ViewCacheService
     */
    private static instance: ViewCache;

    /**
     * 获取唯一实例
     *
     * @static
     * @return {*}  {ViewCacheService}
     * @memberof ViewCacheService
     */
    public static getInstance(): ViewCache {
        if (!ViewCache.instance) {
            ViewCache.instance = new ViewCache();
        }
        return this.instance;
    }

    /**
     * 视图缓存
     *
     * @type {any[]}
     * @memberof ViewCacheService
     */
    private $viewCache: any[] = [];

    /**
     * 激活的视图缓存
     *
     * @type {string}
     * @memberof ViewCacheService
     */
    private $activeViewCache: string = '';

    /**
     * 是否启用缓存
     *
     * @private
     * @type {boolean}
     * @memberof ViewCache
     */
    private $enableCache: boolean = true;

    /**
     * 设置是否启用缓存
     *
     * @memberof ViewCache
     */
    set enableCache(value: boolean) {
        this.$enableCache = value;
        if (!this.$enableCache) {
            this.$viewCache = [];
        }
    }

    /**
     * 获取视图缓存
     *
     * @readonly
     * @memberof ViewCache
     */
    get viewCache() {
        return this.$viewCache;
    }

    /**
     * 获取当前激活视图
     *
     * @readonly
     * @memberof ViewCache
     */
    get activeViewCache() {
        return this.$activeViewCache
    }
    
    /**
     * 设置视图缓存(目前仅添加html视图的缓存)
     *
     * @param {*} appView
     * @memberof ViewCacheService
     */
    setViewCache(appView: any, fullPath: string) {
        const target = this.$viewCache.find((item: any) => {
            return item.fullPath == fullPath;
        });
        if (!target && this.$enableCache) {
            if (appView.viewType === 'DEHTMLVIEW') {
                this.$viewCache.push({ appView, fullPath: fullPath });
            }
        }
        this.$activeViewCache = fullPath;
    }

    /**
     * 设置当前激活的视图缓存
     *
     * @param {string} fullPath
     * @memberof ViewCacheService
     */
    setActiveViewCache(fullPath: string) {
        this.$activeViewCache = fullPath;
    }

    /**
     * 当前激活视图是否为缓存视图
     *
     * @readonly
     * @memberof ViewCacheService
     */
    get isViewCache() {
        let state: boolean = false;
        this.$viewCache.forEach((view: any) => {
            if (view.fullPath == this.$activeViewCache) {
                state = true
            }
        })
        return state
    }

    /**
     * 删除视图缓存
     *
     * @param {string} fullPath
     * @memberof ViewCacheService
     */
    removeViewCache(fullPath: string) {
        const index = this.$viewCache.findIndex((item: any) => {
            return item.fullPath == fullPath;
        });
        if (index != -1) {
            this.$viewCache.splice(index, 1);
        }
    }

    /**
     * 删除其他视图缓存
     *
     * @param {string} fullPath
     * @memberof ViewCacheService
     */
    removeOtherViewCache(fullPath: string) {
        const index = this.$viewCache.findIndex((item: any) => {
            return item.fullPath == fullPath;
        });
        if (index != -1) {
            const currentView = this.$viewCache[index];
            this.$viewCache = [currentView];
            this.$activeViewCache = fullPath;
        }
    }

    /**
     * 清空视图缓存
     *
     * @memberof ViewCacheService
     */
    clearViewCache() {
        this.$viewCache = [];
        this.$activeViewCache = '';
    }
}
export const ViewCacheService = ViewCache.getInstance();