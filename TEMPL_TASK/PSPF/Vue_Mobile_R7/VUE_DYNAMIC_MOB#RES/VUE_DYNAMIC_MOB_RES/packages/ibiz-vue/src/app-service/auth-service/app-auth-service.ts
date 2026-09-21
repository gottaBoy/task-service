import { AppServiceBase, Http, IParams, LogUtil, ViewTool } from "ibiz-core";
import { clearCookie, getCookie, setCookie } from "qx-util";

/**
 * 应用权限类
 *
 * @export
 * @class AppAuthService
 */
export class AppAuthService {

    /**
     * 唯一实例
     * 
     * @private
     * @static
     * @memberof AppAuthService
     */
    private static readonly instance = new AppAuthService();

    /**
     * token 刷新结果（防止单一时间重复刷新token）
     * 
     * @private
     * @memberof AppAuthService
     */
    private tokenResult: any;

    /**
     * 获取唯一实例
     *
     * @static
     * @return {*}  {AppAuthService}
     * @memberof AppAuthService
     */
    public static getInstance(): AppAuthService {
        return AppAuthService.instance;
    }

    /**
     * 用户登录
     *
     * @memberof AppAuthService
     */
    public async login(loginForm: IParams) {
        //  请求头
        const headers = {};
        const tempViewParam = ViewTool.getDcSystemIdViewParam();
        if (tempViewParam && tempViewParam.srfdcsystem) {
            Object.assign(headers, { srfdcsystem: tempViewParam.srfdcsystem });
        }
        const post: any = await Http.getInstance().post('/v7/login', loginForm, true, headers);
        const { status, data } = post;
        if (status == 200) {
            this.setExpiredDate(data.expirein);
        }
        return post;
    }

    /**
     * 刷新token
     *
     * @public
     * @param {*} [data={}]
     * @memberof AppAuthService
     */
    public async refreshToken(data: any = {}) {
        if (this.tokenResult) {
            return this.tokenResult;
        }
        this.tokenResult = new Promise((resolve: any, reject: any) => {
            if (data && (data.url.startsWith("/v7") || data.url.startsWith('./assets') || data.url == "/uaa/refreshtoken2")) {
                this.tokenResult = null;
                return resolve(true);
            } else {
                Http.getInstance().get('/uaa/refreshtoken2').then((response: any) => {
                    this.tokenResult = null;
                    if (response && response.status === 200) {
                        const data = response.data;
                        this.setExpiredDate(data.expirein);
                        if (data) {
                            setCookie('ibzuaa-token', data.token, 7, true);
                        }
                        resolve(true);
                    } else {
                        LogUtil.warn(`[刷新token出错]:${JSON.stringify(response)}`);
                        resolve(false);
                    }
                }).catch((error: any) => {
                    this.tokenResult = null;
                    LogUtil.warn(`[刷新token出错]:${JSON.stringify(error)}`);
                    resolve(false);
                })
            }
        })
        return this.tokenResult;
    }

    /**
     * 是否过期
     *
     * @public
     * @param {Date} [date]
     * @memberof AppAuthService
     */
    public isExpired(date: Date, args: IParams): boolean {
        if (args && (args.url.startsWith("/v7") || args.url.startsWith('./assets') || args.url == "/uaa/refreshtoken2")) {
            return false;
        }
        const environment = AppServiceBase.getInstance().getAppEnvironment();
        if (this.getExpiredDate()) {
            if (environment) {
                return date.getTime() > ((this.getExpiredDate() as Date).getTime() - (environment.refreshTokenTime / 1000));
            } else {
                return date.getTime() > (this.getExpiredDate() as Date).getTime();
            }
        } else {
            return false;
        }
    }

    /**
     * 获取过期时间
     *
     * @memberof AppAuthService
     */
    public getExpiredDate() {
        const expiredTime = getCookie('ibzuaa-expired');
        if (expiredTime) {
            return new Date(Number(expiredTime));
        } else {
            return null;
        }
    }

    /**
     * 设置过期时间
     *
     * @param expirein 过期秒数
     * @memberof AppAuthService
     */
    public setExpiredDate(expirein: number) {
        if (expirein) {
            const curTime = new Date();
            const expireinTime = new Date(curTime.setSeconds(curTime.getSeconds() + expirein));
            setCookie('ibzuaa-expired', expireinTime.getTime().toString(), 7, true);
        } else {
            clearCookie('ibzuaa-expired', true);
        }
    }

}