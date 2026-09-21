import { Store } from 'vuex';
import Router from 'vue-router';
import i18n from '@/locale';
import { Environment } from '@/environments/environment';
import { Http, getSessionStorage, Util, IParams, ViewTool } from 'ibiz-core';
import { AppAuthService, AppLoadingService } from 'ibiz-vue';
import { clearCookie, getCookie, notNilEmpty, SyncSeriesHook } from 'qx-util';
import { MicroAppService } from '@/micro';

/**
 * 拦截器
 *
 * @export
 * @class Interceptors
 */
export class Interceptors {

    /**
     * 路由对象
     *
     * @private
     * @type {(Router | any)}
     * @memberof Interceptors
     */
    private router: Router | any;

    /**
     * 缓存对象
     *
     * @private
     * @type {(Store<any> | any)}
     * @memberof Interceptors
     */
    private store: Store<any> | any;

    /**
     *  单列对象
     *
     * @private
     * @static
     * @type { Interceptors }
     * @memberof Interceptors
     */
    private static readonly instance: Interceptors = new Interceptors();

    /**
     * Creates an instance of Interceptors.
     * 私有构造，拒绝通过 new 创建对象
     * 
     * @memberof Interceptors
     */
    private constructor() {
        if (Interceptors.instance) {
            return Interceptors.instance;
        } else {
            this.intercept();
        }
    }

    /**
     * 获取 Interceptors 单例对象
     *
     * @static
     * @param {Router} route
     * @param {Store<any>} store
     * @returns {Interceptors}
     * @memberof Interceptors
     */
    public static getInstance(route: Router, store: Store<any>): Interceptors {
        this.instance.router = route;
        this.instance.store = store;
        return this.instance;
    }

    /**
     * 执行钩子(请求、响应)
     *
     * @memberof Interceptors
     */
    public static hooks = {
        request: new SyncSeriesHook<[], { config: any }>(),
        response: new SyncSeriesHook<[], { response: any }>()
    };

    /**
     * 拦截器实现接口
     *
     * @private
     * @memberof Interceptors
     */
    private intercept(): void {
        Http.getHttp().interceptors.request.use((config: any) => {
            Interceptors.hooks.request.callSync({ config: config });
            let appdata: any;
            if (this.router) {
                appdata = this.store.getters.getAppData();
            }
            if (appdata && appdata.context) {
                config.headers['srforgsectorid'] = appdata.context.srforgsectorid;
            }
            if (Environment.SaaSMode) {
                let activeOrgData = getSessionStorage('activeOrgData');
                config.headers['srforgid'] = activeOrgData?.orgid;
                if (!config.headers['srfsystemid']) {
                    config.headers['srfsystemid'] = activeOrgData?.systemid;
                }
            }
            if (getCookie('ibzuaa-token')) {
                config.headers['Authorization'] = `Bearer ${getCookie('ibzuaa-token')}`;
            } else {
                // 第三方应用打开免登
                if (sessionStorage.getItem("srftoken")) {
                    const token = sessionStorage.getItem('srftoken');
                    config.headers['Authorization'] = `Bearer ${token}`;
                }
            }
            const appAuthService: AppAuthService = AppAuthService.getInstance();
            if (appAuthService.isExpired(new Date(), config)) {
                let refresh = new Promise((resolve, reject) => {
                    appAuthService.refreshToken(config).then((result: any) => {
                        if (result) {
                            if (getCookie('ibzuaa-token')) {
                                config.headers['Authorization'] = `Bearer ${getCookie('ibzuaa-token')}`;
                            } else {
                                // 第三方应用打开免登
                                if (sessionStorage.getItem("srftoken")) {
                                    const token = sessionStorage.getItem('srftoken');
                                    config.headers['Authorization'] = `Bearer ${token}`;
                                }
                            }
                            config.headers['Accept-Language'] = i18n.locale;
                            if (!Object.is(Environment.BaseUrl, "") && !config.url.startsWith('https://') && !config.url.startsWith('http://') && !config.url.startsWith('./assets') && !config.url.startsWith(`./${MicroAppService.getInstance().getMicroAppFolder()}/assets`)) {
                                config.url = Environment.BaseUrl + config.url;
                            }
                            // 开启loading
                            this.beginLoading();
                            return resolve(config);
                        } else {
                            this.doNoLogin(null);
                        }
                    })
                })
                return refresh;
            } else {
                config.headers['Accept-Language'] = i18n.locale;
                if (!Object.is(Environment.BaseUrl, "") && !config.url.startsWith('https://') && !config.url.startsWith('http://') && !config.url.startsWith('./assets') && !config.url.startsWith(`./${MicroAppService.getInstance().getMicroAppFolder()}/assets`)) {
                    config.url = Environment.BaseUrl + config.url;
                }
                // 开启loading
                this.beginLoading();
                return config;
            }
        }, (error: any) => {
            return Promise.reject(error);
        });

        Http.getHttp().interceptors.response.use((response: any) => {
            Interceptors.hooks.response.callSync({ response: response });
            // 关闭loading
            this.endLoading();

            return response;
        }, (error: any) => {
            // 关闭loading
            this.endLoading();

            error = error ? error : { response: {} };
            let { response: res } = error;
            let { data: _data } = res;
            // 处理异常
            if (res.headers && res.headers['x-ibz-error']) {
                res.data.errorKey = res.headers['x-ibz-error'];
            }
            if (res.headers && res.headers['x-ibz-params']) {
                res.data.entityName = res.headers['x-ibz-params'];
            }
            if (res.status === 401) {
                this.doNoLogin(res, _data.data);
            }
            if (res.status === 403) {
                if (res.data && res.data.status && Object.is(res.data.status, "FORBIDDEN")) {
                    let alertMessage: string = "非常抱歉，您无权操作此数据，如需操作请联系管理员！";
                    Object.assign(res.data, { localizedMessage: alertMessage, message: alertMessage });
                }
            }
            // if (res.status === 404) {
            //     this.router.push({ path: '/404' });
            // } else if (res.status === 500) {
            //     this.router.push({ path: '/500' });
            // }

            return Promise.reject(res);
        });
    }

    /**
     * 处理未登录异常情况
     *
     * @private
     * @param {*} [data={}]
     * @memberof Interceptors
     */
    private doNoLogin(response: any, data: any = {}): void {
        // 交由路由守卫自行处理
        if (response && response.config && response.config.url && Object.is(response.config.url, '/appdata')) {
            return;
        }
        this.clearAppData();
        if (MicroAppService.getInstance().getIsMicroApp()) {
            MicroAppService.getInstance().noticeBaseApp({ action: 'LOGOUT' })
        } else {
            const routeParams: IParams = Util.getRouteParams(window.location.href);
            if (routeParams && routeParams.redirect_uri) {
                this.router.push({ name: 'login' });
            } else {
                if ((Environment as any).casLoginUrl) {
                    let pathname = location.pathname;
                    pathname = pathname.substring(0, pathname.lastIndexOf('/'));
                    let redirect = '';
                    if (notNilEmpty(Environment.casRedirectUrl)) {
                        redirect = `redirectUrl=${encodeURIComponent(Environment.casRedirectUrl)}&`;
                    }
                    window.location.href = `${(Environment as any).casLoginUrl}/login?${redirect}service=${encodeURIComponent(
                        `${location.origin}${pathname}/cas-login.html?RU=${encodeURIComponent(location.href)}`,
                    )}`;
                } else if (Environment.loginUrl) {
                    window.location.href = `${Environment.loginUrl}?redirect=${window.location.href}`;
                } else {
                    if (Object.is(this.router.currentRoute.name, 'login')) {
                        return;
                    }
                    this.router.push({ name: 'login', query: { redirect: window.location.hash.replace("#", '') } });
                }
            }
        }
    }

    /**
     * 清除应用数据
     *
     * @private
     * @memberof Interceptors
     */
    private clearAppData() {
        // 清除user、token
        clearCookie('ibzuaa-token', true);
        clearCookie('ibzuaa-expired', true);
        clearCookie('ibzuaa-user', true);
        // 清除应用级数据
        localStorage.removeItem('localdata')
        this.store.commit('addAppData', {});
        this.store.dispatch('authresource/commitAuthData', {});
    }

    /**
     * 开始加载
     *
     * @private
     * @memberof Http
     */
    private beginLoading(): void {
        AppLoadingService.getInstance().beginLoading();
    }

    /**
     * 加载结束
     *
     * @private
     * @memberof Http
     */
    private endLoading(): void {
        AppLoadingService.getInstance().endLoading();
    }

}