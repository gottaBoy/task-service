/**
 * 加载服务接口
 *
 * @export
 * @interface ILoadingService
 */
export interface ILoadingService {

    /**
     * 是否加载中
     *
     * @type {boolean}
     * @memberof ILoadingService
     */
    isLoading: boolean;

    /**
     * 开始加载
     *
     * @param {string} [elementKey] 加载附加dom标识
     * @memberof ILoadingService
     */
    beginLoading(elementKey?: string): void;

    /**
     * 结束加载
     *
     * @memberof ILoadingService
     */
    endLoading(): void;
}