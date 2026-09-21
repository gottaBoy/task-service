import { IPSApplication } from "@ibiz/dynamic-model-api";

/**
 * 应用服务基类
 *
 * @export
 * @class AppServiceBase
 */
export class AppServiceBase {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppServiceBase}
     * @memberof AppServiceBase
     */
    private static appService: AppServiceBase;

    /**
     * 应用模型数据对象
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appModelDataObject: IPSApplication;

    /**
     * 应用存储对象
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appStore: any;

    /**
     * 应用消息通知中心
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appMessageCenter: any;

    /**
     * 应用导航中心
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appNavDataService: any;

    /**
     * 环境配置
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appEnvironment: any;

    /**
     * 动态环境配置
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static appDynaEnvironment: any;

    /**
     * 国际化
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static i18n: any;

    /**
     * 路由对象
     *
     * @private
     * @type {(any)}
     * @memberof AppServiceBase
     */
    private static router: any;

    /**
     * 通知对象
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static notification: any;

    /**
     * 微应用服务
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static microAppService: any;

    /**
     * 视图逻辑服务
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static viewLogicService: any;

    /**
     * 重定向来源路由
     *
     * @private
     * @static
     * @type {string}
     * @memberof AppServiceBase
     */
    private static redirectedFromRoute: string;

    /**
     * 组件服务
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static appComponentService: any;

    /**
     * 应用自定义样式表
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static appUserStyle:any;

    /**
     * 应用无权限数据
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static appNoAuthData:any;

    /**
     * 界面模型增强
     *
     * @private
     * @static
     * @type {*}
     * @memberof AppServiceBase
     */
    private static enableUIModelEx: boolean = false;

    /**
     * 获取AppServiceBase单例对象
     *
     * @static
     * @returns {AppServiceBase}
     * @memberof AppServiceBase
     */
    public static getInstance(): AppServiceBase {
        if (!this.appService) {
            this.appService = new AppServiceBase();
        }
        return this.appService;
    }

    /**
     * 获取应用模型数据对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public getAppModelDataObject(): IPSApplication {
        return AppServiceBase.appModelDataObject;
    }

    /**
     * 获取界面模型增强enableUIModelEx
     *
     * @return {*}  {boolean}
     * @memberof AppServiceBase
     */
    public getEnableUIModelEx(): boolean {
        return AppServiceBase.enableUIModelEx;
    }

    /**
     * 设置应用模型数据对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public setAppModelDataObject(opts: IPSApplication) {
        AppServiceBase.appModelDataObject = opts;
        AppServiceBase.enableUIModelEx = opts.M.enableUIModelEx;
    }

    /**
     * 获取应用存储对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public getAppStore() {
        return AppServiceBase.appStore;
    }

    /**
     * 设置应用存储对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public setAppStore(opts: any) {
        AppServiceBase.appStore = opts;
    }

    /**
     * 获取应用消息通知中心
     *
     * @public
     * @memberof AppServiceBase
     */
    public getAppMessageCenter() {
        return AppServiceBase.appMessageCenter;
    }

    /**
     * 设置应用消息通知中心
     *
     * @public
     * @memberof AppServiceBase
     */
    public setAppMessageCenter(opts: any) {
        AppServiceBase.appMessageCenter = opts;
    }

    /**
     * 获取应用导航服务
     *
     * @public
     * @memberof AppServiceBase
     */
    public getAppNavDataService() {
        return AppServiceBase.appNavDataService;
    }

    /**
     * 设置应用导航服务
     *
     * @public
     * @memberof AppServiceBase
     */
    public setAppNavDataService(opts: any) {
        AppServiceBase.appNavDataService = opts;
    }

    /**
     * 获取环境配置对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public getAppEnvironment() {
        if(!AppServiceBase.appDynaEnvironment){
            return AppServiceBase.appEnvironment;
        }
        return Object.assign(AppServiceBase.appEnvironment, AppServiceBase.appDynaEnvironment);
    }

    /**
     * 设置环境配置对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public setAppEnvironment(opts: any) {
        AppServiceBase.appEnvironment = opts;
    }

    /**
     * 设置动态环境配置对象
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setAppDynaEnvironment(opts: any){
        AppServiceBase.appDynaEnvironment = opts;
    }

    /**
     * 获取国际化信息
     *
     * @public
     * @memberof AppServiceBase
     */
    public getI18n() {
        return AppServiceBase.i18n;
    }

    /**
     * 设置国际化信息
     *
     * @public
     * @memberof AppServiceBase
     */
    public setI18n(opts: any) {
        AppServiceBase.i18n = opts;
    }

    /**
     * 获取重定向来源路由
     *
     * @return {*}  {string}
     * @memberof AppServiceBase
     */
     public getRedirectedFromRoute(): string {
        return AppServiceBase.redirectedFromRoute;
    }

    /**
     * 设置重定向来源路由
     *
     * @param {string} route
     * @memberof AppServiceBase
     */
    public setRedirectedFromRoute(route:string){
        AppServiceBase.redirectedFromRoute = route;
    }
    
    /**
     * 获取组件服务
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
    public getAppComponentService() {
        return AppServiceBase.appComponentService;
    }

    /**
     * 设置组件服务
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setAppComponentService(opts: any) {
        AppServiceBase.appComponentService = opts;
    }

    /**
     * 获取路由对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public getRouter() {
        return AppServiceBase.router;
    }

    /**
     * 设置路由对象
     *
     * @public
     * @memberof AppServiceBase
     */
    public setRouter(opts: any) {
        AppServiceBase.router = opts;
    }

    /**
     * 获取数据域状态
     *
     * @param {string} tag
     * @memberof AppServiceBase
     */
    public getDataAreaState(tag: string) {
        const AppStore = this.getAppStore();
        if (AppStore) {
            return AppStore.getters['dataareastate/getDataAreaState'](tag);
        }
    }

    /**
     * 设置数据域状态
     *
     * @param {string} tag
     * @param {*} { key, value }: { key: string, value: any }
     * @memberof AppServiceBase
     */
    public setDataAreaState(tag: string, value: any) {
        const AppStore = this.getAppStore();
        if (AppStore) {
            AppStore.commit('dataareastate/setDataAreaState', { tag, value });
        }
    }

    /**
     * 清除数据域状态
     *
     * @param {string} tag
     * @memberof AppServiceBase
     */
    public clearDataAreaState(tag: string) {
        const AppStore = this.getAppStore();
        if (AppStore) {
            AppStore.commit('dataareastate/clearDataAreaState', tag);
        }
    }

    /**
     * 获取通知对象
     *
     * @memberof AppServiceBase
     */
    public getNotification() {
        return AppServiceBase.notification;
    }

    /**
     * 设置通知对象
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setNotification(opts: any) {
        AppServiceBase.notification = opts;
    }

    /**
     * 获取微应用服务
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
    public getMicroAppService() {
        return AppServiceBase.microAppService;
    }

    /**
     * 设置微应用服务
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
    public setMicroAppService(opts: any) {
        AppServiceBase.microAppService = opts;
    }

    /**
     * 获取视图逻辑服务
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
    public getViewLogicService() {
        return AppServiceBase.viewLogicService;
    }

    /**
     * 设置视图逻辑服务
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setViewLogicService(opts: any) {
        AppServiceBase.viewLogicService = opts;
    }

    /**
     * 获取应用自定义样式表
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
     public getAppUserStyle() {
        return AppServiceBase.appUserStyle;
    }

    /**
     * 设置应用自定义样式表
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setAppUserStyle(opts: any) {
        AppServiceBase.appUserStyle = opts;
    }

    /**
     * 获取应用无权限数据
     *
     * @return {*} 
     * @memberof AppServiceBase
     */
     public getAppNoAuthData() {
        return AppServiceBase.appNoAuthData;
    }

    /**
     * 设置应用无权限数据
     *
     * @param {*} opts
     * @memberof AppServiceBase
     */
    public setAppNoAuthData(opts: any) {
        AppServiceBase.appNoAuthData = opts;
    }

    /**
     * 应用级抛事件
     *
     * @public
     * @memberof AppServiceBase
     */
    public $emit(eventName: string, args: any) {
        if (this.getRouter().app) {
            (this.getRouter().app as Vue).$emit(eventName, args);
        }
    }

    /**
     * 应用级接收事件
     *
     * @public
     * @memberof AppServiceBase
     */
    public $on(eventName: string, callback: Function) {
        if (this.getRouter().app) {
            (this.getRouter().app as Vue).$on(eventName, callback);
        }
    }

}