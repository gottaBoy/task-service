import { ContainerLoadingService } from "./container-loading-service";
import { LoadingServiceBase } from "./loading-service-base";

/**
 * 面板加载服务
 *
 * @export
 * @class LayoutLoadingService
 * @extends {LoadingServiceBase}
 */
export class LayoutLoadingService extends LoadingServiceBase {
    /**
     * 容器加载服务集合
     *
     * @private
     * @type {Map<string, ContainerLoadingService>}
     * @memberof LayoutLoadingService
     */
    private containerLoadingServiceMap: Map<string, ContainerLoadingService> = new Map();

    /**
     * 添加容器加载服务
     *
     * @param {string} name
     * @param {ContainerLoadingService} service
     * @memberof LayoutLoadingService
     */
    public addCLService(name: string, service: ContainerLoadingService) {
        this.containerLoadingServiceMap.set(name, service);
    }

    /**
     * 获取容器加载服务
     *
     * @param {string} name
     * @return {*}  {(ContainerLoadingService | null)}
     * @memberof LayoutLoadingService
     */
    public getCLService(name: string): ContainerLoadingService | null {
        if (this.containerLoadingServiceMap.has(name)) {
            return this.containerLoadingServiceMap.get(name) as ContainerLoadingService;
        }
        return null;
    }

}