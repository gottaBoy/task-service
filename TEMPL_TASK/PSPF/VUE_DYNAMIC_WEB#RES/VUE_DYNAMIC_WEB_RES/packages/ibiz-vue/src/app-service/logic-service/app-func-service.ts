import { IPSAppDataEntity } from '@ibiz/dynamic-model-api';
import { ViewTool, Util, LogUtil, AppServiceBase, Http, removeSessionStorage } from 'ibiz-core';
import { clearCookie } from 'qx-util';
import { CreateElement } from 'vue';
import { ViewCacheService } from '..';

/**
 * 应用功能服务
 *
 * @memberof AppFuncService
 */
export class AppFuncService {
    /**
     * 单例变量声明
     *
     * @memberof AppFuncService
     */
    private static appFuncService: AppFuncService;

    /**
     * 构造 AppFuncService 对象
     *
     * @memberof AppViewLogicService
     */
    constructor() { }

    /**
     * vue对象
     *
     * @memberof AppFuncService
     */
    public v!: any;

    /**
     * 初始化
     *
     * @memberof AppFuncService
     */
    public init(vueInstance: any): void {
        this.v = vueInstance;
    }

    /**
     * 获取 AppFuncService 单例对象
     *
     * @memberof AppFuncService
     */
    public static getInstance() {
        if (!this.appFuncService) {
            this.appFuncService = new AppFuncService();
        }
        return this.appFuncService;
    }

    /**
     * 执行应用功能
     *
     * @memberof AppFuncService
     */
    public async executeApplication(appFunc: any, context: any) {
        if (appFunc) {
            let viewParam: any = {};
            if (appFunc?.getPSAppView) {
                await appFunc.getPSAppView.fill();
            }
            if (appFunc.getPSNavigateContexts) {
                const localContext = Util.formatNavParam(appFunc.getPSNavigateContexts);
                Object.assign(context, localContext);
            }
            if (appFunc.getPSNavigateParams) {
                const localViewParam = Util.formatNavParam(appFunc.getPSNavigateParams);
                Object.assign(viewParam, localViewParam);
            }
            switch (appFunc.appFuncType) {
                case 'APPVIEW':
                    this.openAppView(appFunc.getPSAppView, context, viewParam);
                    return;
                case 'OPENHTMLPAGE':
                    this.openHtmlPage(appFunc, context, viewParam);
                    return;
                case 'PDTAPPFUNC':
                    this.openPdAppFunc(appFunc, context, viewParam);
                    return;
                case 'JAVASCRIPT':
                    this.executeJavaScript(appFunc, context, viewParam);
                    return;
                case 'CUSTOM':
                    this.custom(appFunc, context, viewParam);
                    return;
                default:
                    LogUtil.warn('无该应用功能');
            }
        }
    }

    /**
     * 打开应用视图
     *
     * @memberof AppFuncService
     */
    public async openAppView(appView: any, context: any, viewparam: any = {}, openMode?: string) {
        if (Object.values(appView).length == 0) {
            console.error('未找到应用视图');
            return;
        }
        if (appView.redirectView) {
            this.v.$warning('重定向视图暂不支持应用功能打开', 'openAppView');
        } else {
            if (appView.openViewParam) {
                Object.assign(viewparam, appView.openViewParam);
            }
            const deResParameters: any[] = [];
            const parameters: any[] = [];
            const viewOpenMode = openMode ? openMode : appView.openMode;
            await this.processingParameter(context, appView, deResParameters, parameters, viewOpenMode);
            if (viewOpenMode && Object.is(viewOpenMode, 'INDEXVIEWTAB')) {
                this.openIndexViewTab(appView, context, viewparam, deResParameters, parameters);
            } else if (viewOpenMode && Object.is(viewOpenMode, 'POPUP')) {
                this.openPopup(viewparam, deResParameters, parameters);
            } else if (viewOpenMode && Object.is(viewOpenMode, 'POPUPMODAL')) {
                this.openModal(context, viewparam, appView);
            } else if (viewOpenMode && Object.is(viewOpenMode, 'POPUPAPP')) {
                this.openApp(context, viewparam, deResParameters, parameters);
            } else if (viewOpenMode && Object.is(viewOpenMode, 'POPOVER')) {
                this.openPopover(context, viewparam, appView, viewOpenMode);
            } else if (viewOpenMode && viewOpenMode.indexOf('DRAWER') != -1) {
                this.openDrawer(context, viewparam, appView, viewOpenMode);
            } else if (viewOpenMode && viewOpenMode.indexOf('USER') != -1) {
                this.openUser(context, viewparam, deResParameters, parameters);
            } else {
                this.openIndexViewTab(appView, context, viewparam, deResParameters, parameters);
            }
        }
    }

    /**
     * 整合参数
     *
     * @memberof AppFuncService
     */
    public async processingParameter(context: any, appView: any, deResParameters: any[], parameters: any[], viewOpenMode: string) {
        let params = [];
        if (appView.getPSAppDataEntity()) {
            let result: IPSAppDataEntity = appView.getPSAppDataEntity();
            await result.fill();
            if (!result) {
                console.error('未找到应用实体');
                return;
            }
            if (
                !viewOpenMode ||
                viewOpenMode == 'INDEXVIEWTAB' ||
                viewOpenMode== 'POPUPAPP'
            ) {
                params = [
                    {
                        pathName: Util.srfpluralize(result.codeName).toLowerCase(),
                        parameterName: result.codeName.toLowerCase(),
                    },
                    { pathName: 'views', parameterName: appView.getPSDEViewCodeName().toLowerCase() },
                ];
            } else {
                params = [
                    {
                        pathName: Util.srfpluralize(result.codeName).toLowerCase(),
                        parameterName: result.codeName.toLowerCase(),
                    },
                ];
            }
        } else {
            params = [{ pathName: 'views', parameterName: appView.name.toLowerCase() }];
        }
        Object.assign(parameters, params);
    }

    /**
     * 顶级分页打开
     *
     * @memberof AppFuncService
     */
    public openIndexViewTab(appView: any, context: any, viewparam: any, deResParameters: any[], parameters: any[]) {
        if (context && context.srfdynainstid) {
            Object.assign(viewparam, { srfdynainstid: context.srfdynainstid });
        }
        const path: string = ViewTool.buildUpRoutePath(
            this.v.$route,
            context,
            deResParameters,
            parameters,
            [],
            viewparam,
        );
        let isMicroApp: boolean = false;
        const microAppService = AppServiceBase.getInstance().getMicroAppService();
        if (microAppService) {
            isMicroApp = microAppService.getIsMicroApp();
        }
        ViewCacheService.setViewCache(appView, path);
        if (!isMicroApp) {
            if (Object.is(this.v.$route.fullPath, path)) {
                return;
            }
            this.v.$nextTick(() => {
                this.v.$router.push(path);
            });
        } else {
            this.v.$nextTick(() => {
                this.v.$router.push(path);
            });
        }
    }

    /**
     * 非模式弹出
     *
     * @memberof AppFuncService
     */
    public openPopup(viewparam: any, deResParameters: any[], parameters: any[]) {
        LogUtil.log('-----POPUP-----非模式弹出，暂时不实现');
    }

    /**
     * 模态打开
     *
     * @memberof AppFuncService
     */
    public openModal(context: any, viewparam: any, appView: any) {
        const view = {
            viewname: 'app-view-shell',
            title: this.v.$tl(appView.getTitlePSLanguageRes()?.lanResTag, appView.title),
            height: appView.height,
            width: appView.width,
        };
        if (appView.modelPath) {
            Object.assign(context, { viewpath: appView.modelPath });
        }
        const appmodal = this.v.$appmodal.openModal(view, Util.deepCopy(context), viewparam);
        appmodal.subscribe((result: any) => {
            LogUtil.log(result);
        });
    }

    /**
     * 独立程序弹出
     *
     * @memberof AppFuncService
     */
    public openApp(context: any, viewparam: any, deResParameters: any[], parameters: any[]) {
        if (context && context.srfdynainstid) {
            Object.assign(viewparam, { srfdynainstid: context.srfdynainstid });
        }
        const routePath = ViewTool.buildUpRoutePath(this.v.$route, context, deResParameters, parameters, [], viewparam);
        window.open('./#' + routePath, '_blank');
    }

    /**
     * 气泡打开
     *
     * @memberof AppFuncService
     */
    public openPopover(context: any, viewparam: any, appView: any, viewOpenMode: string) {
        const view = {
            viewname: 'app-view-shell',
            title: this.v.$tl(appView.getTitlePSLanguageRes()?.lanResTag, appView.title),
            height: appView.height,
            width: appView.width,
            placement: viewOpenMode,
        };
        if (appView.modelPath) {
            Object.assign(context, { viewpath: appView.modelPath });
        }
        const appPopover = this.v.$apppopover.openPop({}, view, Util.deepCopy(context), viewparam);
        appPopover.subscribe((result: any) => {
            LogUtil.log(result);
        });
    }

    /**
     * 抽屉打开
     *
     * @memberof AppFuncService
     */
    public openDrawer(context: any, viewparam: any, appView: any, viewOpenMode: string) {
        const view = {
            viewname: 'app-view-shell',
            title: this.v.$tl(appView.getTitlePSLanguageRes()?.lanResTag, appView.title),
            height: appView.height,
            width: appView.width,
            placement: viewOpenMode,
        };
        const appdrawer = this.v.$appdrawer.openDrawer(view, Util.getViewProps(context, viewparam), {
            viewModelData: appView,
        });
        appdrawer.subscribe((result: any) => {
            LogUtil.log(result);
        });
    }

    /**
     * 用户自定义
     *
     * @memberof AppFuncService
     */
    public openUser(context: any, viewparam: any, deResParameters: any[], parameters: any[]) {
        LogUtil.log('用户自定义，暂时不实现');
    }

    /**
     * 打开HTML页面
     *
     * @memberof AppFuncService
     */
    public openHtmlPage(appFunc: any, context: any, viewparam: any) {
        // openMode: INDEXVIEWTAB(应用容器分页)/INDEXVIEWPOPUP（应用容器弹出）/INDEXVIEWPOPUPMODAL（应用容器弹出（模式））/HTMLPOPUP（独立网页弹出）/TOP（顶级页面）
        const { htmlPageUrl, openMode, menuItem } = appFunc;
        switch (openMode) {
            case 'INDEXVIEWTAB':
            case 'TOP':
                const indexPath = ViewTool.getIndexRoutePath(this.v.$route);
                let path = `${indexPath}/apphtmlview/${encodeURIComponent(htmlPageUrl)}`;
                if (menuItem && menuItem.caption) {
                    path += `?caption=${encodeURIComponent(menuItem.caption)}`;
                }
                this.v.$router.push(path);
                break;
            case 'INDEXVIEWPOPUP':
            case 'INDEXVIEWPOPUPMODAL':
                const view = {
                    viewname: 'app-html-container',
                    title: menuItem && menuItem.caption ? menuItem.caption : '应用HTML视图',
                    height: 800,
                    width: 1200
                };
                const tempViewParam = Util.deepCopy(viewparam);
                Object.assign(tempViewParam, { caption: menuItem?.caption, htmlPageUrl });
                const appmodal = this.v.$appmodal.openModal(view, Util.deepCopy(context), tempViewParam);
                appmodal.subscribe((result: any) => {
                    LogUtil.log(result);
                });
                break;
            case 'HTMLPOPUP':
                window.open(htmlPageUrl, '_blank');
                break;
            default:
                window.open(htmlPageUrl, '_blank');
                break;
        }
    }

    /**
     * 预置应用功能
     *
     * @memberof AppFuncService
     */
    public openPdAppFunc(appFunc: any, context: any, viewparam: any) {
        // todo 类型标识待补充
        if (appFunc.name) {
            switch (appFunc.name) {
                case '系统登录':
                    this.login();
                    break;
                case '系统登出':
                    this.logout();
                    break;
                case '清空缓存':
                    this.clearAppData();
                    break;
                case '检查系统更新':
                    this.v.$warning('暂未实现', 'openPdAppFunc');
                    break;
                case '关于系统':
                    this.openAbout();
                    break;
                case '我的收藏':
                    this.v.$warning('暂未实现', 'openPdAppFunc');
                    break;
            }
        }
    }

    /**
     * 执行JS
     *
     * @memberof AppFuncService
     */
    public executeJavaScript(appFunc: any, context: any, viewparam: any) {
        this.v.$warning('执行JS暂不支持', 'executeJavaScript');
    }

    /**
     * 自定义
     *
     * @memberof AppFuncService
     */
    public custom(appFunc: any, context: any, viewparam: any) {
        this.v.$warning('自定义暂不支持', 'custom');
    }

    /**
     * @description 登录
     * @memberof AppFuncService
     */
    public login() {
        this.v.$router.push({ name: 'login' });
    }

    /**
     * @description 登出
     * @memberof AppFuncService
     */
    public logout() {
        this.v.$Modal.confirm({
            title: this.v.$t('components.appuser.surelogout'),
            onOk: () => {
                Http.getInstance().get('/v7/logout').then((response: any) => {
                    if (response && response.status === 200) {
                        this.clearAppData(true);
                    }
                }).catch((error: any) => {
                    console.error(error);
                });
            },
        });
    }

    /**
     * @description 关于系统
     * @memberof AppFuncService
     */
    public openAbout() {
        this.v.$Modal.info({
            title: '系统信息',
            render: (h: CreateElement) => {
                return h('app-about');
            }
        })
    }

    /**
     * 清除应用数据
     *
     * @param isLogout 是否为登出
     * @memberof AppFuncService
     */
    public clearAppData(isLogout: boolean = false) {
        // 清除user、token
        clearCookie('ibzuaa-token', true);
        clearCookie('ibzuaa-expired', true);
        clearCookie('ibzuaa-user', true);
        // 清除应用级数据
        localStorage.removeItem('localdata');
        this.v.$store.commit('addAppData', {});
        this.v.$store.dispatch('authresource/commitAuthData', {});
        // 清除租户相关信息
        removeSessionStorage('activeOrgData');
        removeSessionStorage('srfdynaorgid');
        removeSessionStorage('dcsystem');
        removeSessionStorage('orgsData');
        if (isLogout) {
            let leftTime = new Date();
            leftTime.setTime(leftTime.getSeconds() - 1);
            // 重置路由缓存
            const navHistory: any = AppServiceBase.getInstance().getAppNavDataService();
            navHistory.reset();
        }
        const loginUrl = AppServiceBase.getInstance().getAppEnvironment().loginUrl;
        if (loginUrl) {
            window.location.href = `${loginUrl}?redirect=${window.location.href}`;
        } else {
            this.v.$router.push({ name: 'login' });
        }
    }
}