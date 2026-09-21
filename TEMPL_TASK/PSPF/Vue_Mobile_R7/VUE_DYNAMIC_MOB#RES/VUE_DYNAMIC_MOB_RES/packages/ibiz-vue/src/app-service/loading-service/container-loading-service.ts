import { LayoutLoadingService } from "./layout-loading-service";

/**
 * 容器加载服务
 *
 * @export
 * @class ContainerLoadingService
 */
export class ContainerLoadingService {
    /**
     * 容器标识
     *
     * @private
     * @type {string}
     * @memberof ContainerLoadingService
     */
    private name!: string;

    /**
     * 面板加载服务
     *
     * @private
     * @type {LayoutLoadingService}
     * @memberof ContainerLoadingService
     */
    private layoutLoadingService!: LayoutLoadingService;

    /**
     * 是否加载中
     *
     * @type {boolean}
     * @memberof ContainerLoadingService
     */
    public isLoading: boolean = false;

    /**
     * Creates an instance of ContainerLoadingService.
     * @param {string} name
     * @param {LayoutLoadingService} layoutLoadingService
     * @memberof ContainerLoadingService
     */
    constructor(name: string, layoutLoadingService: LayoutLoadingService) {
        this.name = name;
        this.layoutLoadingService = layoutLoadingService;
        this.layoutLoadingService.addCLService(name, this);
    }

    /**
     * 开始加载
     *
     * @param {*} elementTag
     * @return {*}  {void}
     * @memberof ContainerLoadingService
     */
    public beginLoading(elementTag: any): void {
        const element = document.querySelector(elementTag);
        if (elementTag || !element || this.isLoading) {
            return;
        }
        this.isLoading = true;
        // 自定义loading元素
        const userEle = document.createElement('div');
        userEle.setAttribute('id', `${elementTag}_cover`);
        const innerDiv = document.createElement('div');
        innerDiv.classList.add('loading');
        for (let i = 0; i < 4; i++) {
        const dot = document.createElement('span');
        innerDiv.appendChild(dot);
        }
        userEle.appendChild(innerDiv);
        // 挂载
        if (element) {
            element.appendChild(userEle);
        }
    }

    /**
     * 结束加载
     *
     * @param {*} elementTag
     * @return {*}  {void}
     * @memberof ContainerLoadingService
     */
    public endLoading(elementTag: any): void {
        const element = document.querySelector(elementTag);
        if (elementTag || !element || !this.isLoading) {
            return;
        }
        let cover = element.querySelector(`#${elementTag}_cover`);
        if (cover && element.contains(cover)) {
            element.removeChild(cover);
        }
        this.isLoading = false;
    }

}