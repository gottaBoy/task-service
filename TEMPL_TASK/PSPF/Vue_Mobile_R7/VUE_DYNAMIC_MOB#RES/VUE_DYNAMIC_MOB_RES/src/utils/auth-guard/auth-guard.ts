import i18n from '@/locale';
import { handleLocaleMap } from '@/locale/local-util';
import { Environment } from '@/environments/environment';
import { GlobalHelp } from '@ibiz/dynamic-model-api';
import { AppModelService, AppServiceBase, Http, setSessionStorage, getSessionStorage } from 'ibiz-core';
import { LogUtil } from 'ibiz-core';
import { AppCenterService, AppLoadingService, AppViewLogicService } from 'ibiz-vue';
import qs from 'qs';
import { getCookie, SyncSeriesHook } from 'qx-util';
import { AppComponentService } from '../service/app-component-service';

/**
 * AuthGuard net 对象
 * 调用 getInstance() 获取实例
 *
 * @class Http
 */
export class AuthGuard {

    /**
     * 执行钩子(包含获取租户前、获取租户后、获取应用数据前、获取应用数据后)
     *
     * @memberof AuthGuard
     */
    public static hooks = {
        dcSystemBefore: new SyncSeriesHook<[], { dcsystem: string }>(),
        dcSystemAfter: new SyncSeriesHook<[], { dcsystem: string, data: any }>(),
        appBefore: new SyncSeriesHook<[], { url: string, param: any }>(),
        appAfter: new SyncSeriesHook<[], { data: any }>()
    };

    /**
     * 获取 Auth 单例对象
     *
     * @static
     * @returns {Auth}
     * @memberof Auth
     */
    public static getInstance(): AuthGuard {
        if (!AuthGuard.auth) {
            AuthGuard.auth = new AuthGuard();
        }
        return this.auth;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AuthGuard}
     * @memberof AuthGuard
     */
    private static auth: AuthGuard;

    /**
     * Creates an instance of AuthGuard.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof AuthGuard
     */
    private constructor() { }

    /**
     * 获取应用数据
     *
     * @param {string} url url 请求路径
     * @param {*} [params={}] 请求参数
     * @param {*} [router] 路由对象
     * @returns {Promise<any>} 请求相响应对象
     * @memberof AuthGuard
     */
    public authGuard(url: string, params: any = {}, router: any): any {
        return new Promise((resolve: any, reject: any) => {
            const appStore = router.app.$store;
            let appData: any = appStore?.getters.getAppData();
            getSessionStorage('activeOrgData')
            let activeOrgData = getSessionStorage('activeOrgData');
            if (appData && activeOrgData?.systemid) {
                return resolve(true);
            }
            if (Environment && Environment.SaaSMode) {
                this.getOrgsByDcsystem(router).then((result: boolean) => {
                    if (!result) {
                        reject(false);
                    }
                    this.getAppData(url, params, router).then((result: any) => {
                        result ? resolve(true) : reject(false);
                    });
                });
            } else {
                this.getAppData(url, params, router).then((result: any) => {
                    result ? resolve(true) : reject(false);
                });
            }
        });
    }

    /**
     * 通过租户获取组织数据
     * 
     * @memberof AuthGuard
     */
    public getOrgsByDcsystem(router: any): Promise<boolean> {
        return new Promise((resolve: any) => {
            let tempViewParam = this.hanldeViewParam(window.location.href);
            if (!tempViewParam.srfdcsystem) {
                if (!tempViewParam.redirect) {
                    if (getSessionStorage('dcsystem')) {
                        tempViewParam = getSessionStorage('dcsystem');
                    }
                } else {
                    tempViewParam = this.hanldeViewParam(tempViewParam.redirect);
                }
            }
            if (!tempViewParam.srfdcsystem && Environment.mockDcSystemId) {
                Object.assign(tempViewParam, { srfdcsystem: Environment.mockDcSystemId });
            }
            if (tempViewParam.srfdcsystem) {
                AuthGuard.hooks.dcSystemBefore.callSync({ dcsystem: tempViewParam.srfdcsystem });
                setSessionStorage('dcsystem', tempViewParam);
                let requestUrl: string = `/uaa/getbydcsystem/${tempViewParam.srfdcsystem}`;
                const get: Promise<any> = Http.getInstance().get(requestUrl);
                get.then((response: any) => {
                    if (response && response.status === 200) {
                        let { data }: { data: any } = response;
                        AuthGuard.hooks.dcSystemAfter.callSync({ dcsystem: tempViewParam.srfdcsystem, data: data });
                        if (data && data.length > 0) {
                            setSessionStorage('orgsData', data);
                            setSessionStorage('activeOrgData', data[0]);
                        }
                        resolve(true);
                    } else {
                        resolve(false);
                    }
                }).catch(() => {
                    resolve(false);
                    this.doNoLogin(router, "登录失败，请联系管理员");
                });
            } else {
                resolve(false);
                this.doNoLogin(router, "登录失败，请联系管理员");
            }
        });
    }

    /**
     * 获取应用数据
     *
     * @param {string} url url 请求路径
     * @param {*} [params={}] 请求参数
     * @param {*} [router] 路由对象
     * @returns {Promise<boolean>} 是否通过
     * @memberof AuthGuard
     */
    public getAppData(url: string, params: any = {}, router: any): Promise<boolean> {
        return new Promise((resolve: any, reject: any) => {
            AuthGuard.hooks.appBefore.callSync({ url: url, param: params });
            const get: Promise<any> = Http.getInstance().get(url);
            get.then((response: any) => {
                if (response && response.status === 200) {
                    let { data }: { data: any } = response;
                    AuthGuard.hooks.appAfter.callSync({ data: data });
                    if (data) {
                        // token认证把用户信息放入应用级数据
                        if (getCookie('ibzuaa-user')) {
                            let user: any = JSON.parse(getCookie('ibzuaa-user') as string);
                            let localAppData: any = {};
                            if (user.sessionParams) {
                                localAppData = { context: user.sessionParams };
                                Object.assign(localAppData, data);
                            }
                            data = JSON.parse(JSON.stringify(localAppData));
                        }
                        if (localStorage.getItem('localdata')) {
                            router.app.$store.commit(
                                'addLocalData',
                                JSON.parse(localStorage.getItem('localdata') as string),
                            );
                        }
                        router.app.$store.commit('addAppData', data);
                        // 提交统一资源数据
                        router.app.$store.dispatch('authresource/commitAuthData', data);
                    }
                }
                this.initAppService(router).then(() => {
                    resolve(true);
                });
            }).catch((error: any) => {
                this.initAppService(router).then(() => {
                    resolve(false);
                    console.error('获取应用数据出现异常');
                });
            });
        });
    }

    /**
     * 初始化应用服务
     *
     * @param {*} [router] 路由对象
     *
     * @memberof AuthGuard
     */
    public async initAppService(router: any) {
        const service = new AppModelService()
        AppServiceBase.getInstance().setAppEnvironment(Environment);
        if (!AppServiceBase.getInstance().getAppStore()) {
            AppServiceBase.getInstance().setAppStore(router.app.$store);
        }
        await GlobalHelp.install(service, async (strPath: string) => {
            let url: string = "";
            if (Environment.bDynamic) {
                url = `${Environment.remoteDynaPath}${strPath}`;
                const queryParam = {};
                const { dynamodeltag } = AppServiceBase.getInstance().getAppStore().getters.getAppData();
                if (dynamodeltag) {
                    Object.assign(queryParam, { dynamodeltag });
                }
                if (queryParam && Object.keys(queryParam).length > 0) {
                    url += `?${qs.stringify(queryParam)}`;
                }
            } else {
                url = `./assets/model${strPath}`;
            }
            try {
                const result: any = await Http.getInstance().get(url);
                return result.data ? result.data : null;
            } catch (error) {
                return null;
            }
        }, { lang: handleLocaleMap(i18n.locale) });
        await this.initAppStyle('PSSYSAPP.json.css');
        AppServiceBase.getInstance().setAppModelDataObject(service.app);
        AppServiceBase.getInstance().setI18n(i18n);
        AppCenterService.getInstance(router.app.$store);
        const appLoadingService = AppLoadingService.getInstance();
        AppServiceBase.getInstance().setLoadingService(appLoadingService);
        AppServiceBase.getInstance().setViewLogicService(AppViewLogicService.getInstance());
        AppServiceBase.getInstance().setAppComponentService(AppComponentService);
    }

    /**
     * 处理路径数据
     *
     * @param {*} [urlStr] 路径
     *
     * @memberof AuthGuard
     */
    public hanldeViewParam(urlStr: string) {
        let tempViewParam: any = {};
        const tempViewparam: any = urlStr.slice(urlStr.indexOf('?') + 1);
        const viewparamArray: Array<string> = decodeURIComponent(tempViewparam).split(';');
        if (viewparamArray.length > 0) {
            viewparamArray.forEach((item: any) => {
                Object.assign(tempViewParam, qs.parse(item));
            });
        }
        return tempViewParam;
    }
    
    /**
     * 处理未登录异常情况
     *
     * @memberof AuthGuard
     */
    public doNoLogin(router: any, message: string) {
        this.clearAppData(router.app.$store);
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (Environment.loginUrl) {
            window.location.href = `${Environment.loginUrl}?redirect=${window.location.href}`;
        } else {
            if (Object.is(router.currentRoute.name, 'login')) {
                return;
            }
            router.push({ name: 'login', query: { redirect: router.currentRoute.fullPath } });
        }
    }

    /**
     * 清除应用数据
     *
     * @private
     * @memberof AuthGuard
     */
    private clearAppData(store: any) {
        // 清除user、token
        let leftTime = new Date();
        leftTime.setTime(leftTime.getSeconds() - 1);
        document.cookie = "ibzuaa-token=;expires=" + leftTime.toUTCString();
        document.cookie = "ibzuaa-user=;expires=" + leftTime.toUTCString();
        // 清除应用级数据
        localStorage.removeItem('localdata')
        store.commit('addAppData', {});
        store.dispatch('authresource/commitAuthData', {});
    }

    /**
     * 初始化应用样式表
     * 
     * @param cssUrl 样式路径
     */
    public async initAppStyle(cssUrl: string) {
        const cssContent = await this.loadAppStyle(cssUrl);
        if(!cssContent){
            LogUtil.warn("暂无应用样式表");
            return;
        }
        this.mountedAppStyle(cssContent);
    }

    /**
     * 加载应用样式表
     * 
     * @param cssUrl 样式路径
     */
    public async loadAppStyle(cssUrl: string) {
        let url = '';
        if (Environment.bDynamic) {
            url = `${Environment.remoteDynaPath}/${cssUrl}`;
            const queryParam = {};
            const { dynamodeltag } = AppServiceBase.getInstance().getAppStore().getters.getAppData();
            if (dynamodeltag) {
                Object.assign(queryParam, { dynamodeltag });
            }
            if (queryParam && Object.keys(queryParam).length > 0) {
                url += `?${qs.stringify(queryParam)}`;
            }
        } else {
            const microAppService = AppServiceBase.getInstance().getMicroAppService();
            if (microAppService && microAppService.getIsMicroApp() && microAppService.getMicroAppFolder()) {
                url = `./${microAppService.getMicroAppFolder()}/assets/model/${cssUrl}`;
            } else {
                url = `./assets/model/${cssUrl}`;
            }
        }
        try {
            const result: any = await Http.getInstance().get(url);
            return result.data ? result.data : null;
        } catch (error) {
            return null;
        }
    }

    /**
     * 挂载应用样式表
     * 
     * @param cssContent 
     */
    public mountedAppStyle(cssContent:string){
        let appStyleDom:any;
        for (let i = document.head.childNodes.length - 1; i >= 0; i--) {
            const children: any = document.head.childNodes[i]
            if (children.nodeName == "STYLE" && children.getAttribute('title') && children.getAttribute('title') == 'app-style-css') {
                appStyleDom = children;
            }
        }
        if (appStyleDom) {
            appStyleDom.innerText = cssContent;
        } else {
            const styleDom = document.createElement('style');
            styleDom.type = "text/css";
            styleDom.setAttribute('title', 'app-style-css');
            styleDom.innerText = cssContent;
            document.head.appendChild(styleDom);
        }
    }
}