import { ContainerLoadingService } from ".";
import { ILoadingService } from "ibiz-core";

/**
 * 视图布局面板加载服务
 *
 * @export
 * @class LayoutLoadingService
 */
export class LayoutLoadingService implements ILoadingService {

    /**
     * 加载计数
     *
     * @type {number}
     * @memberof LayoutLoadingService
     */
    private loadingCount: number = 0;

    /**
     * 容器loading服务集合
     *
     * @protected
     * @type {Map<string, ContainerLoadingService>}
     * @memberof LayoutLoadingService
     */
    protected containerLoadingServiceMap: Map<string, ContainerLoadingService> = new Map();

    /**
     * 是否加载中
     *
     * @type {boolean}
     * @memberof LayoutLoadingService
     */
    public isLoading: boolean = false;

    /**
     * 添加容器loading服务
     *
     * @param {string} name
     * @param {ContainerLoadingService} service
     * @memberof LayoutLoadingService
     */
    public addCLService(name: string, service: ContainerLoadingService) {
        this.containerLoadingServiceMap.set(name, service);
    }

    /**
     * 获取容器loading服务
     *
     * @param {string} name
     * @return {*}  {(ILoadingService | null)}
     * @memberof LayoutLoadingService
     */
    public getCLService(name: string): ILoadingService | null {
        if (this.containerLoadingServiceMap.has(name)) {
            return this.containerLoadingServiceMap.get(name) as ILoadingService;
        }
        return null;
    }

    /**
     * 获取是否加载中
     *
     * @param {string} name 容器标识
     * @return {*}  {boolean}
     * @memberof LayoutLoadingService
     */
    public getIsLoading(name: string): boolean {
        if (this.containerLoadingServiceMap.has(name)) {
            return (this.containerLoadingServiceMap.get(name) as ILoadingService).isLoading;
        }
        return this.isLoading;
    }

    /**
     * 开始加载
     *
     * @memberof LayoutLoadingService
     */
    public beginLoading() {
        this.loadingCount++;
        if (!this.isLoading) {
            this.isLoading = true;
        }
    }

    /**
     * 结束加载
     *
     * @memberof LayoutLoadingService
     */
    public endLoading() {
        this.loadingCount--;
        if (this.isLoading && this.loadingCount === 0) {
            this.isLoading = false;
        }
    }
}