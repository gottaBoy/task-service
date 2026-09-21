import { Subject, Subscription } from 'rxjs';
import { IPSAppView, IPSControl, IPSLanguageRes } from '@ibiz/dynamic-model-api';
import { ViewMessageService, Util, ViewTool, AppServiceBase, ViewContext, ModelTool, GetModelService, AppModelService, LogUtil, SandboxInstance, ViewInterface, appEngineService, throttle, IParams } from 'ibiz-core';
import { AppMessageBoxService, AppNavHistory, NavDataService, ViewCache, ViewCacheService } from '../app-service';
import { createUUID, isNilOrEmpty } from 'qx-util';
import { ControlContainer } from '../control-container/control-container';

/**
 * 视图基类
 *
 * @export
 * @class ViewBase
 * @extends {Vue}
 * @implements {ViewInterface}
 */
export class ViewBase extends ControlContainer implements ViewInterface {

    /**
     * 视图动态参数
     *
     * @type {*}
     * @memberof ViewBase
     */
    public dynamicProps!: any;

    /**
     * 视图静态参数
     *
     * @type {*}
     * @memberof ViewBase
     */
    public staticProps!: any;

    /**
     * 视图缓存服务
     *
     * @type {ViewCache}
     * @memberof ViewBase
     */
    public viewCacheService: ViewCache = ViewCacheService;
    
    /**
     * 传入视图上下文
     *
     * @type {any}
     * @memberof ViewBase
     */
    public viewdata!: any;

    /**
     * 传入视图参数
     *
     * @type {any}
     * @memberof ViewBase
     */
    public viewparam!: any;

    /**
      * 当前视图环境参数
      * 
      * @memberof ViewBase
      */
    public ctx!: ViewContext;

    /**
     * 部件自定义参数（传入布局）
     *
     * @type {IParams}
     * @memberof ViewBase
     */
    public ctrlCustomParams: IParams = {};

    /**
     * 视图默认使用(路由：true,非路由：false)
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    public viewDefaultUsage!: boolean;

    /**
     * 是否为嵌入导航视图
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    public isNavView: boolean = false;

    /**
     * 视图默认加载
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    public isLoadDefault: boolean = true;

    /**
     * 是否禁用视图标题（不显示标题：true）
     *
     * @memberof ViewBase
     */
    public noViewCaption = false;

    /**
     * 缓存路由Path
     *
     * @type {string}
     * @memberof ViewBase
     */
    public cacheRoutePath: string = '';

    /**
     * 视图传递对象
     *
     * @type {Subject}
     * @memberof ViewBase
     */
    public viewState: Subject<any> = new Subject();

    /**
    * 视图状态订阅对象
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof ViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 传入视图传递对象
     *
     * @type {*}
     * @memberof ViewBase
     */
    public inputState?: any;

    /**
     * 传入视图状态订阅对象
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof ViewBase
     */
    public inputStateEvent: Subscription | undefined;

    /**
     * 模型数据
     *
     * @memberof ViewBase
     */
    public modelData: any;

    /**
     * 视图实例
     * 
     * @memberof ViewBase
     */
    public viewInstance!: IPSAppView;

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ViewBase
     */
    public model: any = {};

    /**
     * 模型数据是否加载完成
     * 
     * @memberof ViewBase
     */
    public viewIsLoaded: boolean = false;

    /**
     * 视图codeName
     *
     * @type {string}
     * @memberof ViewBase
     */
    public viewCodeName!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof ViewBase
     */
    public viewtag: string = '';

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof ViewBase
     */
    public viewCacheData: any;

    /**
     * 自定义视图导航上下文集合
     *
     * @type {*}
     * @memberof ViewBase
     */
    public customViewNavContexts: any = {};

    /**
     * 自定义视图导航参数集合
     *
     * @type {*}
     * @memberof ViewBase
     */
    public customViewParams: any = {};

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ViewBase
     */
    public containerModel: any = {};

    /**
     * 视图按钮模型（选择类视图使用）
     *
     * @type {*}
     * @memberof ViewBase
     */
    public viewButtonModel: any = {};

    /**
     * 视图消息服务
     *
     * @type {ViewMessageService}
     * @memberof ViewBase
     */
    public viewMessageService: ViewMessageService = new ViewMessageService();

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof ViewBase
     */
    public navDataService: NavDataService = NavDataService.getInstance(this.$store);

    /**
     * 模型服务
     *
     * @type {AppModelService}
     * @memberof ViewBase
     */
    public modelService !: AppModelService;

    /**
     * 使用默认布局
     *
     * @type {(boolean | undefined)}
     * @memberof ViewBase
     */
    public useDefaultLayout: boolean | undefined = undefined;

    /**
     * 视图代理模式
     *
     * @type {(boolean | undefined)}
     * @memberof ViewBase
     */
    public viewProxyMode: boolean | undefined = undefined;

    /**
     * 视图布局引用
     *
     * @type {*}
     * @memberof ViewBase
     */
    public viewLayoutRef: any;

    /**
     * 获取顶层视图
     *
     * @memberof ViewBase
     */
    public getTopView() {
        return this.viewCtx.topview;
    }

    /**
     * 设置部件自定义参数（传入布局）
     *
     * @param {string} name
     * @param {IParams} params
     * @memberof ViewBase
     */
    public setCtrlCustomParams(name: string, params: IParams) {
        if (!this.ctrlCustomParams[name]) {
            this.ctrlCustomParams[name] = params;
        } else {
            Object.assign(this.ctrlCustomParams[name], params);
        }
    }

    /**
     * 获取父级视图
     *
     * @memberof ViewBase
     */
    public getParentView() {
        return this.viewCtx.parentview;
    }

    /**
     * 获取指定名称部件
     *
     * @memberof ViewBase
     */
    public getCtrlByName(name: string) {
        return (this.$refs[name] as any).ctrl;
    }

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        // 处理viewparam
        if (newVal.viewparam && newVal.viewparam !== oldVal?.viewparam) {
            this.viewparam = newVal.viewparam;
            if (typeof this.viewparam == 'string') {
                this.viewparams = JSON.parse(this.viewparam);
            } else {
                this.viewparams = Util.deepCopy(this.viewparam);
            }
        }
        // 处理viewdata
        if (newVal.viewdata && newVal.viewdata !== oldVal?.viewdata) {
            this.viewDefaultUsage = this.staticProps?.viewDefaultUsage;
            this.viewdata = newVal.viewdata;
            this.parseViewParam();
            if (this.viewIsLoaded) {
                setTimeout(() => {
                    this.viewReload();
                }, 0);
            }
        }
        // 处理navdatas
        if (newVal.navdatas && newVal.navdatas !== oldVal?.navdatas) {
            this.navdatas = newVal.navdatas;
        }
        this.initViewCtx();
    }

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (!(newVal?.modeldata)) {
            return
        }
        this.beforeViewModelInit(newVal);
        this.viewModelInit().then((res: any) => {
            this.viewInit();
            this.viewIsLoaded = true;
            setTimeout(() => {
                this.setContainerIsMounted();
            }, 0);
        });
    }

    /**
     * 执行初始化视图模型实例前逻辑
     * 
     * @param data 静态数据
     * @memberof ViewBase
     */
    public beforeViewModelInit(data: any) {
        this.cacheRoutePath = this.$route.fullPath;
        this.isLoadDefault = data.isLoadDefault == false ? false : true;
        this.viewDefaultUsage = data.viewDefaultUsage !== false;
        this.isNavView = data.isNavView == true;
        this.noViewCaption = data.noViewCaption == true;
        this.viewtag = data.viewtag;
        this.inputState = data.inputState;
        this.viewInstance = data?.modeldata;
        this.customViewNavContexts = this.viewInstance.getPSAppViewNavContexts() ? this.viewInstance.getPSAppViewNavContexts() : [];
        this.customViewParams = this.viewInstance.getPSAppViewNavParams() ? this.viewInstance.getPSAppViewNavParams() : [];
        this.viewCodeName = this.viewInstance?.codeName;
        this.context = data.viewcontainer;
        this.initUIContainerModel('VIEW', data?.modeldata);
        this.useDefaultLayout = this.viewInstance.getPSViewLayoutPanel()?.useDefaultLayout;
        this.viewProxyMode = this.viewInstance.getPSViewLayoutPanel()?.viewProxyMode;
        const tempEngine = appEngineService.getEngine(this.viewInstance.viewType);
        if (tempEngine && !this.viewProxyMode) {
            this.engine = appEngineService.getEngine(this.viewInstance.viewType);
        }
    }

    /**
     * 视图模型数据初始化实例
     *
     * @memberof ViewBase
     */
    public async viewModelInit() {
        try {
            await this.initModelService();
            await this.initUIContainerBeforeCtx();
            // 初始化时需要计算context和viewparams
            this.parseViewParam();
            // 初始化viewCtx
            this.initViewCtx();
            if (this.staticProps && this.staticProps.modeldata) {
                this.initContainerModel(this.staticProps);
                await this.initViewMessageService(this.staticProps.modeldata);
                await this.initUIContainerAfterCtx();
            }
        } catch (error) {
            LogUtil.warn(error);
        }
    }

    /**
     * 初始化视图操作参数
     *
     * @public
     * @memberof ViewBase
     */
    public initViewCtx(args?: any): void {
        this.viewCtx = { viewNavContext: this.context, viewNavParam: this.viewparams };
        if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
            this.viewCtx['appGlobal'] = AppServiceBase.getInstance().getAppStore().getters.getAppGlobal();
        };
        if (AppServiceBase.getInstance().getAppStore().getters.getRouteViewGlobal(this.context.srfsessionid)) {
            this.viewCtx['routeViewGlobal'] = AppServiceBase.getInstance().getAppStore().getters.getRouteViewGlobal(this.context.srfsessionid);
        } else {
            AppServiceBase.getInstance().getAppStore().commit('addRouteViewGlobal', { tag: this.context.srfsessionid, param: {} });
            this.viewCtx['routeViewGlobal'] = AppServiceBase.getInstance().getAppStore().getters.getRouteViewGlobal(this.context.srfsessionid);
        }
        this.viewCtx['viewGlobal'] = {};
        this.viewCtx['viewNavData'] = {};
        this.viewCtx['messagebox'] = AppMessageBoxService.getInstance();
        this.viewCtx['app'] = AppServiceBase.getInstance();
        this.viewCtx['view'] = this;
        // 处理顶层视图
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            // 嵌入视图
            if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                this.viewCtx['topview'] = AppServiceBase.getInstance().getAppStore().getters.getView(this.context.srfsessionid);;
            }
        } else {
            // 顶层路由视图
            if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                AppServiceBase.getInstance().getAppStore().commit('addView', { tag: this.context.srfsessionid, param: this });
            }
            this.viewCtx['topview'] = this;
        }
        // 处理父层视图
        this.handleParentView();
    }

    /**
     * 处理父级视图数据
     *
     * @memberof ViewBase
     */
    public handleParentView() {
        if (this.context && this.context.parentviewpath) {
            if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                this.viewCtx['parentview'] = AppServiceBase.getInstance().getAppStore().getters.getView(this.context.parentviewpath);;
            } else {
                this.viewCtx['parentview'] = null;
            }
        } else {
            this.viewCtx['parentview'] = null;
        }
        if (this.viewInstance && this.viewInstance.modelPath) {
            if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                AppServiceBase.getInstance().getAppStore().commit('addView', { tag: this.viewInstance.modelPath, param: this });
            }
            Object.assign(this.context, { parentviewpath: this.viewInstance.modelPath });
        }
    }

    /**
     * 初始化模型服务
     *
     * @memberof ViewBase
     */
    public async initModelService() {
        let _this: any = this;
        let tempContext: any = {};
        if (AppServiceBase.getInstance()) {
            this.mergeAppData(AppServiceBase.getInstance().getAppStore().getters.getAppData());
        }
        if (!_this.viewDefaultUsage && _this.viewdata && !Object.is(_this.viewdata, '')) {
            if (typeof _this.viewdata == 'string') {
                Object.assign(tempContext, JSON.parse(_this.viewdata));
            } else {
                tempContext = Util.deepCopy(_this.viewdata);
            }
        } else {
            const path = (_this.$route.matched[_this.$route.matched.length - 1]).path;
            const keys: Array<any> = [];
            const curReg = _this.$pathToRegExp.pathToRegexp(path, keys);
            const matchArray = curReg.exec(_this.$route.path);
            let tempValue: Object = {};
            keys.forEach((item: any, index: number) => {
                if (matchArray[index + 1]) {
                    Object.defineProperty(tempValue, item.name, {
                        enumerable: true,
                        value: decodeURIComponent(matchArray[index + 1])
                    });
                }
            });
            ViewTool.formatRouteParams(tempValue, _this.$route, tempContext, _this.viewparams);
            if (_this.viewparams && _this.viewparams.srfdynainstid) {
                Object.assign(tempContext, { srfdynainstid: this.viewparams.srfdynainstid });
            }
            if (_this.viewparams.srfinsttag && _this.viewparams.srfinsttag2) {
                Object.assign(tempContext, { instTag: _this.viewparams.srfinsttag, instTag2: _this.viewparams.srfinsttag2 });
            }
            // 补充沙箱实例参数（路由）
            if (_this.viewparams && _this.viewparams.hasOwnProperty('srfsandboxtag')) {
                Object.assign(tempContext, { 'srfsandboxtag': _this.viewparams.srfsandboxtag });
            }
        }
        try {
            this.modelService = await GetModelService(tempContext);
        } catch (error) {
            await this.initSandBoxInst(tempContext);
            this.modelService = await GetModelService(tempContext);
        }
    }

    /**
     * 初始化沙箱实例
     *
     * @memberof ViewBase
     */
    public async initSandBoxInst(args: any) {
        if (args && args.srfsandboxtag) {
            const tempSandboxInst: SandboxInstance = new SandboxInstance(args);
            await tempSandboxInst.initSandBox();
        }
    }

    /**
     * 初始化containerModel
     * 
     * @memberof ViewBase
     */
    public initContainerModel(opts: any) {
        const { modeldata } = opts;
        if (!modeldata) {
            return;
        }
        if (Object.is(modeldata.viewType, 'DEPICKUPVIEW')
            || Object.is(modeldata.viewType, 'DEPICKUPVIEW2')
            || Object.is(modeldata.viewType, 'DEPICKUPVIEW3')
            || Object.is(modeldata.viewType, 'DEMPICKUPVIEW')
            || Object.is(modeldata.viewType, 'DEMPICKUPVIEW2')
            || Object.is(modeldata.viewType, 'DEOPTVIEW')
            || Object.is(modeldata.viewType, 'DEWFSTARTVIEW')
            || Object.is(modeldata.viewType, 'DEWFACTIONVIEW')) {
            this.viewButtonModel = {
                view_okbtn: { name: 'okbtn', type: 'button', text: this.$t('app.commonwords.ok'), disabled: true },
                view_cancelbtn: { name: 'cancelbtn', type: 'button', text: this.$t('app.commonwords.cancel'), disabled: false },
                view_leftbtn: { name: 'leftbtn', type: 'button', text: this.$t('app.button.leftbtn'), disabled: true },
                view_rightbtn: { name: 'rightbtn', type: 'button', text: this.$t('app.button.rightbtn'), disabled: true },
                view_allleftbtn: { name: 'allleftbtn', type: 'button', text: this.$t('app.button.allleftbtn'), disabled: true },
                view_allrightbtn: { name: 'allrightbtn', type: 'button', text: this.$t('app.button.allrightbtn'), disabled: true },
            }
        }
    }

    /**
     * 初始化视图消息服务
     *
     * @memberof ViewBase
     */
    public async initViewMessageService(param: any) {
        const viewMsgGroup: any = (param as IPSAppView).getPSAppViewMsgGroup?.();
        await this.viewMessageService.initBasicParam(viewMsgGroup, this.context, this.viewparams);
    }

    /**
     * 初始化视图标题数据
     *
     * @param {*} view 视图实例
     * @memberof ViewBase
     */
    public initModel(view: IPSAppView) {
        if (!view) {
            return;
        }
        this.model = { dataInfo: '' };
        Object.assign(this.model, { srfCaption: this.viewInstance.getCapPSLanguageRes() ? this.$tl((this.viewInstance.getCapPSLanguageRes() as IPSLanguageRes).lanResTag, this.viewInstance.caption) : this.viewInstance.caption });
        Object.assign(this.model, { srfTitle: this.viewInstance.getTitlePSLanguageRes() ? this.$tl((this.viewInstance.getTitlePSLanguageRes() as IPSLanguageRes).lanResTag, this.viewInstance.title) : this.viewInstance.title });
        Object.assign(this.model, { srfSubTitle: this.viewInstance.getSubCapPSLanguageRes() ? this.$tl((this.viewInstance.getSubCapPSLanguageRes() as IPSLanguageRes).lanResTag, this.viewInstance.subCaption) : this.viewInstance.subCaption });
    }

    /**
     *  视图初始化
     *
     * @memberof ViewBase
     */
    public viewInit() {
        this.initModel(this.viewInstance)
        // 初始化部件自定义参数（传入布局）
        this.initCtrlCustomParams();
        this.viewtag = Util.createUUID();
        if (this.viewDefaultUsage) {
            const navHistory: AppNavHistory = AppServiceBase.getInstance().getAppNavDataService();
            if (navHistory) {
                navHistory.setViewTag(this.viewtag, this.$route);
                navHistory.setCaption({ tag: this.viewtag, caption: this.model.srfCaption, info: '' });
            }
            this.$store.commit('viewAction/initAppViews', { viewTag: this.viewtag, path: this.$route.fullPath });
        }
        if (this.navDataService) {
            this.serviceStateEvent = this.navDataService.serviceState.subscribe(({ action, name, data }: { action: string, name: any, data: any }) => {
                if (!Object.is(name, this.viewCodeName)) {
                    return;
                }
                if (Object.is(action, 'viewrefresh')) {
                    this.parseViewParam(data);
                    setTimeout(() => {
                        this.viewReload();
                        this.$forceUpdate();
                    }, 0);
                }
            });
        }
        if (this.inputState) {
            this.inputStateEvent = this.inputState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.viewInstance.name)) {
                    return;
                }
                if (Object.is(action, 'refresh') && this.refresh && this.refresh instanceof Function) {
                    this.refresh();
                }
                if (Object.is(action, 'load')) {
                    this.viewReload();
                }
                if (Object.is(action, 'save')) {
                    if (this?.viewInstance) {
                        const xDataControlName = (this.viewInstance as any).xDataControlName;
                        let targetCtrl: any;
                        if (xDataControlName) {
                            targetCtrl = this.viewProxyMode ? this.viewLayoutRef.$refs[xDataControlName].ctrl : (this.$refs[xDataControlName] as any).ctrl;
                        }
                        if (targetCtrl && targetCtrl.save && (targetCtrl.save instanceof Function)) {
                            this.viewState.next({ tag: xDataControlName, action: action, data: Object.assign(this.viewparams, { showResultInfo: false }) });
                        } else {
                            if (this.viewInstance.viewType !== 'DEMEDITVIEW9') {
                                this.$emit('view-event', { viewName: this.viewCodeName, action: 'drdatasaved', data: {} });
                            }
                        }
                    }
                }
                if (Object.is(action, 'remove')) {
                    if (this?.viewInstance) {
                        const xDataControlName = (this.viewInstance as any).xDataControlName;
                        if (xDataControlName) {
                            this.viewState.next({ tag: xDataControlName, action: 'remove', data: data });
                        }
                    }
                }
            })
        }
        // 视图加载服务初始化操作
        this.viewLoadingService.srfsessionid = this.context.srfsessionid;
        this.$store.commit("loadingService/addViewLoadingService", this.viewLoadingService);
        // 视图初始化向导航栈里面加数据
        this.$nextTick(() => {
            this.navDataService.addNavData({ title: this.model.srfCaption, viewType: this.viewInstance.viewType, path: this.$route?.fullPath, viewmode: this.viewDefaultUsage, tag: this.viewInstance.codeName, key: null, data: {} });
        })
    }

    /**
     *  视图销毁
     *
     * @memberof ViewBase
     */
    public viewDestroyed() {
        if (!this.viewProxyMode) {
            this.handleContainerPreEvent('onViewDestroyed').then((result: boolean) => {
                if (!result) {
                    return;
                }
                if (this.viewDefaultUsage) {
                    let localStoreLength = Object.keys(localStorage);
                    if (localStoreLength.length > 0) {
                        localStoreLength.forEach((item: string) => {
                            if (item.startsWith(this.context.srfsessionid)) {
                                localStorage.removeItem(item);
                            }
                        })
                    }
                    if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                        // 清除顶层路由参数
                        AppServiceBase.getInstance().getAppStore().commit('removeRouteViewGlobal', this.context.srfsessionid);
                        // 清除顶层视图
                        AppServiceBase.getInstance().getAppStore().commit('removeView', this.context.srfsessionid);
                    }
                }
                // 清除当前视图
                if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                    if (this.viewInstance && this.viewInstance.modelPath) {
                        AppServiceBase.getInstance().getAppStore().commit('removeView', this.viewInstance.modelPath);
                    }
                }
            })
        }
        // 视图销毁从导航栈里面删除数据
        this.navDataService.removeNavData(this.viewInstance.codeName);
        // 销毁当前视图数据变更状态
        this.$store.commit('viewAction/removeViewByViewTag', this.viewtag);
        // 销毁容器
        this.destroyUIContainer();
        // 取消订阅视图状态订阅对象
        if (this.serviceStateEvent) {
            this.serviceStateEvent.unsubscribe();
        }
        // 取消订阅传入视图状态订阅对象
        if (this.inputStateEvent) {
            this.inputStateEvent.unsubscribe();
        }
        this.viewCtx = null;
        this.viewLayoutRef = null;
    }

    /**
     * 解析视图参数
     *
     * @public
     * @memberof ViewBase
     */
    public parseViewParam(inputvalue: any = null): void {
        let _this: any = this;
        this.context = {};
        if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
            this.mergeAppData(AppServiceBase.getInstance().getAppStore().getters.getAppData());
        }
        if (!_this.viewDefaultUsage && _this.viewdata && !Object.is(_this.viewdata, '')) {
            if (typeof _this.viewdata == 'string') {
                Object.assign(_this.context, JSON.parse(_this.viewdata));
            }
            if (isNilOrEmpty(_this.context.srfsessionid) && isNilOrEmpty(_this.context.srfsessionkey)) {
                _this.context.srfsessionid = createUUID();
            }
            if (_this.context && _this.context.srfparentdename) {
                Object.assign(_this.viewparams, { srfparentdename: _this.context.srfparentdename });
            }
            if (_this.context && _this.context.srfparentdemapname) {
                Object.assign(_this.viewparams, { srfparentdemapname: _this.context.srfparentdemapname });
            }
            if (_this.context && _this.context.srfparentkey) {
                Object.assign(_this.viewparams, { srfparentkey: _this.context.srfparentkey });
            }
            _this.handleCustomViewData();
            return;
        }
        const path = (_this.$route.matched[_this.$route.matched.length - 1]).path;
        const keys: Array<any> = [];
        const curReg = _this.$pathToRegExp.pathToRegexp(path, keys);
        const matchArray = curReg.exec(_this.$route.path);
        let tempValue: Object = {};
        keys.forEach((item: any, index: number) => {
            if (matchArray[index + 1]) {
                Object.defineProperty(tempValue, item.name, {
                    enumerable: true,
                    value: decodeURIComponent(matchArray[index + 1])
                });
            }
        });
        ViewTool.formatRouteParams(tempValue, _this.$route, _this.context, _this.viewparams);
        if (inputvalue && ModelTool.getContainerAppEntityCodeName(this.viewInstance)) {
            Object.assign(_this.context, { [(ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase()]: inputvalue });
        }
        if (_this.viewInstance && ModelTool.getContainerAppEntityCodeName(this.viewInstance)) {
            Object.assign(_this.context, { srfsessionid: Util.createUUID() });
        }
        // 补充沙箱实例参数（路由）
        if (_this.viewparams && _this.viewparams.hasOwnProperty('srfsandboxtag')) {
            Object.assign(_this.context, { 'srfsandboxtag': _this.viewparams.srfsandboxtag });
        }
        _this.handleCustomViewData();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof ViewBase
     */
    public handleCustomViewData() {
        this.handleviewRes();
        if (this.customViewNavContexts.length > 0) {
            this.customViewNavContexts.forEach((item: any) => {
                let tempContext: any = {};
                let curNavContext: any = item;
                this.handleCustomDataLogic(curNavContext, tempContext, item.key);
                Object.assign(this.context, tempContext);
            })
        }
        if (this.customViewParams.length > 0) {
            this.customViewParams.forEach((item: any) => {
                let tempParam: any = {};
                let curNavParam: any = item;
                this.handleCustomDataLogic(curNavParam, tempParam, item.key);
                Object.assign(this.viewparams, tempParam);
            })
        }
    }

    /**
     * 处理指定视图控制关系将父键转为父实体上下文
     *
     * @memberof ViewBase
     */
    public async handleviewRes() { }

    /**
     * 处理自定义视图数据逻辑
     *
     * @memberof ViewBase
     */
    public handleCustomDataLogic(curNavData: any, tempData: any, item: string) {
        // 直接值直接赋值
        if (curNavData.rawValue) {
            if (Object.is(curNavData.value, "null") || Object.is(curNavData.value, "")) {
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: null,
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            } else {
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: curNavData.value,
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            }
        } else {
            // 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
            if (this.context[(curNavData.value).toLowerCase()] != null) {
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: this.context[(curNavData.value).toLowerCase()],
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            } else {
                if (this.viewparams[(curNavData.value).toLowerCase()] != null) {
                    Object.defineProperty(tempData, item.toLowerCase(), {
                        value: this.viewparams[(curNavData.value).toLowerCase()],
                        writable: true,
                        enumerable: true,
                        configurable: true
                    });
                } else {
                    Object.defineProperty(tempData, item.toLowerCase(), {
                        value: null,
                        writable: true,
                        enumerable: true,
                        configurable: true
                    });
                }
            }
        }
    }

    /**
     *  合入应用数据到当前视图的导航参数中
     * 
     * @param 应用数据
     * @memberof ViewBase
     */
    public mergeAppData(appData: any) {
        for (let key in this.context) {
            delete this.context[key];
        }
        if (appData && appData.context) {
            Object.assign(this.context, appData.context);
        }
    }

    /**
     * 视图重新加载
     *
     * @memberof ViewBase
     */
    public viewReload() {
        if (this.viewProxyMode) {
            if (this.viewLayoutRef) {
                if (this.viewLayoutRef.engine && this.viewLayoutRef.engine.view) {
                    this.viewLayoutRef.engine.load();
                } else if (this.refresh && this.refresh instanceof Function) {
                    this.refresh();
                }
            }
        } else {
            if (this.engine && this.engine.view) {
                this.engine.load();
            } else if (this.refresh && this.refresh instanceof Function) {
                this.refresh();
            }
        }
    }

    /**
     * 视图刷新
     *
     * @param {*} args
     * @memberof ViewBase
     */
    public refresh(args?: any): void {
        try {
            const xDataControlName = this.staticProps?.modeldata?.xDataControlName;
            const refs: any = this.viewProxyMode ? this.viewLayoutRef.$refs : this.$refs;
            if (refs && refs[xDataControlName]) {
                refs[xDataControlName]?.ctrl?.refresh(args);
            }
        } catch (error: any) {
            LogUtil.log(error);
        }
    }

    /**
     *  关闭视图
     *
     * @memberof ViewBase
     */
    public closeView(args: any[]) {
        // if (window.opener && Boolean(this.$store.getters['getCustomParamByTag']('srffullscreen'))) {
        //     window.opener.postMessage({ type: 'CLOSE', data: args }, '*');
        //     window.close();
        //     return;
        // }
        if (this.viewdata) {
            this.$emit('view-event', { action: 'viewdataschange', data: Array.isArray(args) ? args : [args] });
            this.$emit('view-event', { action: 'close', data: Array.isArray(args) ? args : [args] });
        } else {
            if (this.viewInstance && this.viewInstance.viewStyle && Object.is(this.viewInstance.viewStyle, "STYLE2")) {
                this.closeViewWithStyle2(this);
            } else {
                this.closeViewWithDefault(this);
            }
        }
        // 视图关闭从导航栈里面删除数据
        this.navDataService.removeNavDataLast();
    }

    /**
     * 关闭视图(视图样式为style2样式)
     *
     * @view {*} 当前视图
     * @memberof ViewBase
     */
    public closeViewWithStyle2(view: any) {
        const navHistory: any = AppServiceBase.getInstance().getAppNavDataService();
        const item: any = navHistory.historyList[navHistory.findHistoryIndex(view.$route)];
        navHistory.remove(item);
        if (navHistory.historyList.length > 0) {
            if (navHistory.isRouteSame(item.to, this.$route)) {
                let go: any = navHistory.historyList[
                    navHistory.historyList.length - 1
                ].to;
                this.$router.push({ path: go.path, params: go.params, query: go.query });
            }
        } else {
            const path: string | null = window.sessionStorage.getItem(AppServiceBase.getInstance().getAppEnvironment().AppName);
            if (path) {
                this.$router.push({ path: path });
            } else {
                const name: any = this.$route?.matched[0].name;
                const param = this.$route.params[name];
                const path = `/${name}${param ? `/${param}` : ''}`;
                this.$router.push({ path });
            }
        }
    }

    /**
     * 关闭视图(视图样式为默认样式)
     *
     * @view {*} 当前视图
     * @memberof ViewBase
     */
    public closeViewWithDefault(view: any) {
        const microAppService = AppServiceBase.getInstance().getMicroAppService();
        if (microAppService && microAppService.getIsMicroApp()) {
            const data = {};
            Object.assign(data, { microAppName: this.Environment.microAppName, fullPath: view.$route.fullPath });
            microAppService.noticeBaseApp({ action: 'REMOVE_PAGE', data })
        } else {
            view.$store.commit("deletePage", view.$route.fullPath);
            const length = view.$store.state.historyPathList.length;
            if (length > 0) {
                const path = view.$store.state.historyPathList[length - 1];
                if (Object.is(path, view.$route.fullPath)) {
                    return;
                }
                const index = view.$store.state.pageTagList.findIndex((page: any) =>
                    Object.is(page.fullPath, path)
                );
                if (index >= 0) {
                    const page = view.$store.state.pageTagList[index];
                    view.$router.push({
                        path: page.path,
                        params: page.params,
                        query: page.query
                    });
                }
            } else {
                let path: string | null = window.sessionStorage.getItem(
                    AppServiceBase.getInstance().getAppEnvironment().AppName
                );
                if (path) {
                    this.$router.push({ path: path });
                } else {
                    this.$router.push("/");
                }
            }
        }
    }

    /**
     * 容器挂载完成（重写）
     *
     * @memberof ViewBase
     */
    public containerMounted() {
        // 初始化视图布局引用
        if (this.$refs && this.$refs[`${this.viewInstance.codeName}Layout`]) {
            this.viewLayoutRef = this.$refs && this.$refs[`${this.viewInstance.codeName}Layout`];
        }
        if (this.viewProxyMode) {
            this.handleViewProxyEvent();
        } else {
            super.containerMounted();
            const _this: any = this;
            this.$emit('view-event', { viewname: this.viewInstance.name, action: 'viewIsMounted', data: true });
            this.handleContainerPreEvent('onViewMounted').then((result: boolean) => {
                if (!result) {
                    return;
                }
                if (this.engine) {
                    this.engineInit();
                    if (this.engine.loadModel instanceof Function) {
                        this.engine.loadModel();
                    }
                }
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewIsInited', data: null });
                // 默认不加载，需要重新刷新视图（导航视图专用）
                if (this.viewInstance && ((this.viewInstance as any).loadDefault === false)) {
                    this.$emit('view-event', { viewName: this.viewInstance.name, action: 'viewNeedRefresh', data: true });
                }
            })
        }
    }

    /**
     * 初始化部件自定义参数（传入布局）（子视图需重写）
     *
     * @memberof ViewBase
     */
    public initCtrlCustomParams() { }

    /**
     * 处理视图代理层事件逻辑
     * 
     * @param args 
     * @memberof ViewBase
     */
    public handleViewProxyEvent() {
        if (this.viewLayoutRef) {
            this.viewLayoutRef.$on('view-event', (args: any) => {
                const { action, data } = args;
                // 关闭视图需代理到视图层处理
                if (Object.is(action, 'viewClosed')) {
                    this.closeView(data);
                } else {
                    this.$emit('view-event', args);
                }
            })
        }
    }

    /**
     * 绘制视图部件集合
     * 
     * @memberof ViewBase
     */
    public renderViewControls() {
        const viewLayoutPanel = this.viewInstance.getPSViewLayoutPanel();
        if (viewLayoutPanel && viewLayoutPanel.useDefaultLayout) {
            return [];
        } else {
            const controlArray: Array<any> = [];
            if (this.viewInstance.getPSControls() && (this.viewInstance.getPSControls() as IPSControl[]).length > 0) {
                (this.viewInstance.getPSControls() as IPSControl[]).forEach((control: IPSControl) => {
                    const targetCtrl = this.renderTargetControl(control);
                    controlArray.push(targetCtrl);
                });
            }
            return controlArray;
        }
    }

    /**
     * 计算目标部件所需参数(重写)
     *
     * @memberof ViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        if (Object.is(controlInstance?.controlType, 'SEARCHFORM') || Object.is(controlInstance?.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.dynamicProps, { isExpandSearchForm: true });
        }
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.closeView($event);
            }
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 渲染容器默认工具栏(重写)
     *
     * @memberof ViewBase
     */
    public renderToolBar() {
        if (!(this.toolbarModels && this.toolbarModels.length > 0)) {
            return null;
        }
        const slotName = this.useDefaultLayout ? 'toolbar' : 'layout-toolbar';
        return (
            <view-toolbar
                slot={slotName}
                mode={this.viewInstance?.viewStyle || 'DEFAULT'}
                counterServiceArray={this.counterServiceArray}
                isViewLoading={this.viewLoadingService?.isLoading}
                context={this.context}
                viewparams={this.viewparams}
                toolbarModels={this.toolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, [data, $event], this);
                }}
            ></view-toolbar>
        );
    }

    /**
     * 渲染视图头部视图消息
     * 
     * @memberof ViewBase
     */
    public renderTopMessage() {
        const msgDetails: any[] = this.viewMessageService.getViewMsgDetails('TOP');
        if (msgDetails.length == 0) {
            return null;
        }
        const topStyle = (this.viewInstance.getPSAppViewMsgGroup() as any)?.topStyle;
        return (
            <div slot="topMessage" class="view-top-message">
                <app-alert
                    position="TOP"
                    showStyle={topStyle}
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparam)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-alert>
            </div>
        );
    }

    /**
     * 渲染视图Body视图消息
     * 
     * @memberof ViewBase
     */
    public renderBodyMessage() {
        const msgDetails: any[] = this.viewMessageService.getViewMsgDetails('BODY');
        if (msgDetails.length == 0) {
            return null;
        }
        const bodyStyle = (this.viewInstance.getPSAppViewMsgGroup() as any)?.bodyStyle;
        return (
            <div slot="bodyMessage" class="view-body-message">
                <app-alert
                    position="BODY"
                    showStyle={bodyStyle}
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparam)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-alert>
            </div>
        );
    }

    /**
     * 渲染视图底部视图消息
     * 
     * @memberof ViewBase
     */
    public renderBottomMessage() {
        const msgDetails: any[] = this.viewMessageService.getViewMsgDetails('BOTTOM');
        if (msgDetails.length == 0) {
            return null;
        }
        const bottomStyle = (this.viewInstance.getPSAppViewMsgGroup() as any)?.bottomStyle;
        return (
            <div slot="bottomMessage" class="view-bottom-message">
                <app-alert
                    position="BOTTOM"
                    showStyle={bottomStyle}
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparam)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-alert>
            </div>
        );
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof ViewBase
     */
    public renderMainContent() { }

    /**
     *  绘制标题栏
     *
     * @memberof ViewBase
     */
    public renderCaptionBar() {
        const captionBar: any = ModelTool.findPSControlByName('captionbar', this.viewInstance.getPSControls());
        if (this.viewInstance.showCaptionBar && captionBar) {
            return (
                <app-default-captionbar
                    slot="layout-captionbar"
                    viewModelData={this.viewInstance}
                    modelData={captionBar}
                    context={this.context}
                    viewparam={this.viewparam}
                ></app-default-captionbar>
            );
        }
    }

    /**
     *  绘制信息栏
     *
     * @memberof ViewBase
     */
    public renderDataInfoBar() {
        const datainfoBar: any = ModelTool.findPSControlByName('datainfobar', this.viewInstance.getPSControls());
        if (datainfoBar) {
            return (
                <app-default-datainfobar
                    slot="layout-datainfobar"
                    modelData={datainfoBar}
                    viewInfo={this.model}
                    context={this.context}
                    viewparam={this.viewparam}
                ></app-default-datainfobar>
            );
        }
    }

    /**
     * 渲染内容区
     * 
     * @memberof ViewBase
     */
    public renderContent() { }
}