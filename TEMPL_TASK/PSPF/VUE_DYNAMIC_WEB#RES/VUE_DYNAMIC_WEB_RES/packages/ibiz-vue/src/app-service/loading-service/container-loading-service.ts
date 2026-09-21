import { Loading } from "element-ui";
import { ElLoadingComponent } from "element-ui/types/loading";
import { ILoadingService } from "ibiz-core";
import { LayoutLoadingService } from "..";

export class ContainerLoadingService implements ILoadingService {

    /**
     * 视图布局面板loading服务
     *
     * @protected
     * @type {LayoutLoadingService}
     * @memberof ContainerLoadingService
     */
    protected layoutLoadingService?: LayoutLoadingService;

    /**
     * loading Dom
     *
     * @protected
     * @type {ElLoadingComponent}
     * @memberof ContainerLoadingService
     */
    protected loadingComponent?: ElLoadingComponent;

    /**
     * 是否加载中
     *
     * @type {boolean}
     * @memberof ContainerLoadingService
     */
    public isLoading: boolean = false;

    /**
     * Creates an instance of ContainerLoadingService.
     * @param {*} layoutLoadingService
     * @memberof ContainerLoadingService
     */
    constructor(name: string, layoutLoadingService: LayoutLoadingService) {
        this.layoutLoadingService = layoutLoadingService;
        this.layoutLoadingService?.addCLService(name, this);
    }

    /**
     * 开始加载
     *
     * @param {string} elementKey 获取dom标识
     * @return {*} 
     * @memberof ContainerLoadingService
     */
    public beginLoading(elementKey: string): void {
        const element: any = document.querySelector(elementKey);
        if (!element || this.isLoading) {
            return;
        }
        this.loadingComponent = Loading.service({
            fullscreen: true,
            target: element,
            customClass: 'app-loading',
        });
        this.isLoading = true;
        //  loading Dom
        const userEle = `<div class="app-loading__icon">
            <div class="app-loading__icon__content">
                <div class="content__item is-active"></div>
                <div class="content__item"></div>
            </div>
            <div class="app-loading__icon__content">
                <div class="content__item"></div>
                <div class="content__item"></div>
            </div>
        </div>`;
        const loadingEle = element.lastChild;
        if (loadingEle) {
            loadingEle.innerHTML = userEle;
        }
        //  开启布局面板loading服务
        if (this.layoutLoadingService) {
            this.layoutLoadingService.beginLoading();
        }
    }

    /**
     * 结束loading
     *
     * @return {*} 
     * @memberof ContainerLoadingService
     */
    public endLoading() {
        if (!this.isLoading) {
            return;
        }
        this.isLoading = false;
        //  删除loading Dom
        if (this.loadingComponent) {
            this.loadingComponent.close();
        }
        //  关闭布局面板loading服务
        if (this.layoutLoadingService) {
            this.layoutLoadingService.endLoading();
        }
    }
}