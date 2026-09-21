import { IParams } from "./i-params";

export interface IRedirectResult {
    /**
     * 原始数据
     *
     * @type {IParams}
     * @memberof IRedirectResult
     */
    srfdata?: IParams;

    /**
     * 重定向类型
     *
     * @type {string}
     * @memberof IRedirectResult
     */
    srfstate?: 'inwf' | 'multiform' | 'indextype' | 'redirectitem' | 'funcview';

    /**
     * 重定向计算目标值
     *
     * @type {string}
     * @memberof IRedirectResult
     */
    param?: string;
}
