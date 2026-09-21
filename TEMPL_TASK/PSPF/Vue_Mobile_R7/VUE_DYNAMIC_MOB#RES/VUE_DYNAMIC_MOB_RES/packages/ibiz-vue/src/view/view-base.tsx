import { Subject, Subscription } from 'rxjs';
import { Util, ViewTool, ViewState, AppServiceBase, GetModelService, AppModelService, ModelTool, MobViewInterface, SandboxInstance, LogUtil, appEngineService } from 'ibiz-core';
import { ViewMessageService } from 'ibiz-core';
import { IPSAppView, IPSControl, IPSLanguageRes } from '@ibiz/dynamic-model-api';
import { AppMessageBoxService, ViewLoadingService } from '../app-service';
import { ControlContainer } from '../control-container/control-container';
/**
 * 视图基类
 *
 * @export
 * @class ViewBase
 * @extends {Vue}
 */
export class ViewBase extends ControlContainer implements MobViewInterface {

    /**
     * 传入视图上下文
     *
     * @type {any}
     * @memberof ViewBase
     */
    public _context: any;

    /**
     * 传入视图参数
     *
     * @type {any}
     * @memberof ViewBase
     */
    public _viewparams: any;

    /**
     * 视图动态参数
     *
     * @type {*}
     * @memberof ViewBase
     */
    public dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {*}
     * @memberof ViewBase
     */
    public staticProps: any;

    /**
     * 视图loading服务
     *
     * @type {ViewLoadingService}
     * @memberof ViewBase
     */
    public viewLoadingService: ViewLoadingService = new ViewLoadingService();


    /**
     * 视图默认使用(首页：INDEXVIEW,路由：ROUTERVIEW，非路由：INCLUDEDVIEW)
     *
     * @type {string}
     * @memberof ViewBase
     */
    public viewDefaultUsage!: string;

    /**
     * 视图默认加载
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    public isLoadDefault: boolean = true;

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
     * 跨应用重定向回调路径
     *
     * @type {string}
     * @memberof ViewBase
     */
    public redirectURI: string = '';

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
     * 视图模型数据
     *
     * @type {*}
     * @memberof ViewBase
     */
    public model: any = {};

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
    public viewStateEvent: Subscription | undefined;

    /**
      * 传入通讯对象
      *
      * @type {Subject<ViewState>}
      * @memberof ViewBase
      */
    public inputState?: Subject<ViewState>;

    /**
     * 传入状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof ViewBase
     */
    public inputStateEvent: Subscription | undefined;

    /**
     * 视图实例
     * 
     * @memberof ViewBase
     */
    public viewInstance!: IPSAppView;

    /**
     * 模型数据是否加载完成
     * 
     * @memberof ViewBase
     */
    public viewIsLoaded: boolean = false;

    /**
     * 获取顶层视图
     *
     * @memberof ViewBase
     */
    public getTopView() {
        return this.viewCtx.topview;
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
     * 模型服务
     *
     * @type {AppModelService}
     * @memberof ControlBase
     */
    public modelService !: AppModelService;

    /**
     * 视图消息服务
     *
     * @type {AppModelService}
     * @memberof ControlBase
     */
    public viewMessageService: ViewMessageService = new ViewMessageService();

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    public showCaptionBar: boolean = true;

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
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        // 处理viewparam
        if (newVal._viewparams && newVal._viewparams !== oldVal?._viewparams) {
            this._viewparams = newVal._viewparams;
            if (typeof this._viewparams == 'string') {
                this.viewparams = JSON.parse(this._viewparams);
            } else {
                this.viewparams = Util.deepCopy(this._viewparams);
            }
        }
        // 处理_context
        if (newVal._context && newVal._context !== oldVal?._context) {
            this._context = newVal._context;
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
        // 初始化时需要计算context和viewparams
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
        this.isLoadDefault = data.isLoadDefault ? true : false;
        this.viewDefaultUsage = data.hasOwnProperty('viewDefaultUsage') ? this.staticProps.viewDefaultUsage : 'ROUTERVIEW';
        this.viewtag = data.viewtag;
        this.viewInstance = data?.modeldata;
        this.inputState = data.inputState;
        this.initUIContainerModel('VIEW', data?.modeldata);
        this.customViewNavContexts = this.viewInstance.getPSAppViewNavContexts() ? this.viewInstance.getPSAppViewNavContexts() : [];
        this.customViewParams = this.viewInstance.getPSAppViewNavParams() ? this.viewInstance.getPSAppViewNavParams() : [];
        this.viewCodeName = this.viewInstance?.codeName;
        this.showCaptionBar = data.showCaptionBar === false || this.viewInstance.showCaptionBar === false ? false : true;
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
                await this.initViewMessageService(this.staticProps.modeldata);
                await this.initUIContainerAfterCtx();
            }
        } catch (error) {
            console.warn(error);
        }
    }

    /**
     *  视图初始化
     *
     * @memberof ViewBase
     */
    public viewInit() {
        let _this: any = this;
        this.initModel(this.viewInstance)
        this.viewtag = Util.createUUID();
        this.$store.commit("viewaction/createdView", {
            viewtag: this.viewtag,
            secondtag: this.viewtag
        });
        this.subscribeEvent();
        // 视图加载服务初始化操作
        this.viewLoadingService.srfsessionid = this.context?.srfsessionid;
        this.$store.commit("loadingService/addViewLoadingService", this.viewLoadingService);
        // 处理视图定时器逻辑
        this.handleContainerTimerLogic();
    }


    /**
     * 订阅事件
     *
     * @memberof ViewBase
     */
    public subscribeEvent() {
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
                    if (this.viewInstance && (this.viewInstance as any).xDataControlName) {
                        this.viewState.next({ tag: (this.viewInstance as any).xDataControlName, action: action, data: Object.assign(data, this.viewparams) });
                    } else {
                        this.$emit('view-event', { viewName: this.viewCodeName, action: 'drdatasaved', data: {} });
                    }
                }
            })
        }
    }

    /**
     *  容器挂载完成（重写）
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
            this.$emit('view-event', { viewname: this.viewInstance.name, action: 'viewIsMounted', data: true })
            this.handleContainerPreEvent('onViewMounted').then((result: boolean) => {
                if (!result) {
                    return;
                }
                if (this.engine) {
                    this.engineInit();
                }
                this.$emit('view-event', { viewName: this.viewCodeName, action: 'viewLoaded', data: null });
            })
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
        if ((this.viewDefaultUsage === "INCLUDEDVIEW") && _this._context) {
            if (typeof _this._context == 'string') {
                Object.assign(tempContext, JSON.parse(_this._context));
            } else {
                tempContext = Util.deepCopy(_this._context);
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
     * 初始化视图标题数据
     *
     * @param {*} result
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
     * 初始化视图消息服务
     *
     * @memberof ViewBase
     */
    public async initViewMessageService(param: any) {
        const viewMsgGroup: any = (param as IPSAppView).getPSAppViewMsgGroup?.();
        await this.viewMessageService.initBasicParam(viewMsgGroup, this.context, this.viewparams);
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
            this.viewCtx['appGlobal'] = AppServiceBase.getInstance().getAppStore().getters.getAppGlobal()
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
        if ((this.viewDefaultUsage === "INCLUDEDVIEW") && this._context && !Object.is(this._context, '')) {
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
     * 解析视图参数
     *
     * @public
     * @memberof ViewBase
     */
    public parseViewParam(inputvalue: any = null): void {
        const _this: any = this;
        const setSrfsessionid = () => {
            if (_this.viewInstance && ModelTool.getContainerAppEntityCodeName(this.viewInstance)) {
                Object.assign(_this.context, { srfsessionid: Util.createUUID() });
            }
        }
        if (AppServiceBase.getInstance()) {
            this.mergeAppData(AppServiceBase.getInstance().getAppStore().getters.getAppData());
        }
        if (Object.is(this.viewDefaultUsage, 'INCLUDEDVIEW')) {
            if (this._context) {
                if (typeof this._context == 'string') {
                    Object.assign(this.context, JSON.parse(this._context));
                }
            }
            if (this.context && this.context.srfparentdename) {
                Object.assign(this.viewparams, { srfparentdename: this.context.srfparentdename });
            }
            if (this.context && this.context.srfparentkey) {
                Object.assign(this.viewparams, { srfparentkey: this.context.srfparentkey });
            }
            if (_this.context && _this.context.srfparentdemapname) {
                Object.assign(_this.viewparams, { srfparentdemapname: _this.context.srfparentdemapname });
            }
            this.handleCustomViewData();
            return;
        }
        if (!_this.$route) {
            return;
        }
        const path = (_this.$route.matched[_this.$route.matched.length - 1]).path;
        const keys: Array<any> = [];
        const curReg = _this.$pathToRegExp.pathToRegexp(path, keys);
        const matchArray = curReg.exec(_this.$route.path);
        let tempValue: any = {};
        keys.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item.name, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
        // 处理跨应用重定向回调路径
        if (this.viewparams.redirect_uri) {
            this.redirectURI = decodeURIComponent(this.viewparams.redirect_uri)
            delete this.viewparams.redirect_uri;
        }
        ViewTool.formatRouteParams(tempValue, this.$route, this.context, this.viewparams);
        if (inputvalue && ModelTool.getContainerAppEntityCodeName(this.viewInstance)) {
            Object.assign(_this.context, { [(ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase()]: inputvalue });
        }
        setSrfsessionid();
        if (_this.viewparams && _this.viewparams.srfdynainstid) {
            Object.assign(_this.context, { srfdynainstid: this.viewparams.srfdynainstid });
        }
        this.handleCustomViewData();
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
    public handleviewRes() {
    }

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
    public async refresh(args?: any): Promise<any> {
        try {
            const xDataControlName = this.staticProps?.modeldata?.xDataControlName;
            const refs: any = this.viewProxyMode ? this.viewLayoutRef.$refs : this.$refs;
            if (refs && refs[xDataControlName]) {
                return refs[xDataControlName]?.ctrl?.refresh(args);
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
    public closeView(args?: any[]) {
        let backUrl  = this.viewparams.invalidCount;
        if(backUrl){
            this.$router.go(-(1 + Number(backUrl)));
            return;
        }
        let _view: any = this;
        switch (this.viewDefaultUsage) {
            case 'ROUTERVIEW':
                _view.$store.commit("deletePage", _view.$route.fullPath);
                if (this.redirectURI) {
                    window.location.href = this.redirectURI;
                } else {
                    _view.$router.go(-1);
                }
                break;
            case 'INCLUDEDVIEW':
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'close', data: null });
                break;
            case 'INDEXVIEW':
                this.exitApplication();
                break;
        }
    }

    /**
     * 退出应用
     *
     * @param {any[]} args
     * @memberof ViewBase
     */
    public exitApplication() {
        let exitTimer: any = sessionStorage.getItem("exitTimer");
        if (!exitTimer) {  // 首次返回时
            // 缓存首次返回的时间
            window.sessionStorage.setItem("exitTimer", new Date().getTime().toString());
            // 提示再按一次退出
            this.$toast("再按一次退出");
            // 两秒后清除缓存（与提示的持续时间一致）
            setTimeout(() => { sessionStorage.removeItem("exitTimer") }, 2000);
        } else {
            // 如果时间差小于两秒 直接关闭
            if (new Date().getTime() - exitTimer < 2000) {
                Util.exitApp();
            }
        }
    }

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
            controlArray.push(this.renderCaptionBar());
            controlArray.push(this.renderDataInfoBar());
            return controlArray;
        }
    }

    /**
     *  视图销毁
     *
     * @memberof ViewBase
     */
    public viewDestroyed() {
        if (!this.viewProxyMode) {
            this.handleContainerPreEvent('onViewDestroyed').then((result: boolean) => {
                // 非嵌入模式下
                if (!Object.is(this.viewDefaultUsage, 'INCLUDEDVIEW')) {
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
            });
        }
        // 销毁容器
        this.destroyUIContainer();
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if (this.inputStateEvent) {
            this.inputStateEvent.unsubscribe();
        }
    }

    /**
     * 渲染视图头部
     * 
     * @memberof ViewBase
     */
    public renderViewHeader() { }

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
        return (
            <div slot="topMessage" class="view-top-message">
                <app-mob-alert
                    position="TOP"
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparams)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-mob-alert>
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
        return (
            <div slot="bodyMessage" class="view-body-message">
                <app-mob-alert
                    position="BODY"
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparams)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-mob-alert>
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
        return (
            <div slot="bottomMessage" class="view-bottom-message">
                <app-mob-alert
                    position="BOTTOM"
                    messageDetails={msgDetails}
                    context={Util.deepCopy(this.context)}
                    viewparam={Util.deepCopy(this.viewparams)}
                    infoGroup={this.viewInstance.getPSAppViewMsgGroup()?.codeName}
                    viewname={this.viewInstance.codeName.toLowerCase()}
                ></app-mob-alert>
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
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof ViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.closeView($event);
            }
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }


    /**
     * 渲染内容区
     * 
     * @memberof ViewBase
     */
    public renderContent() {
        const id = this.viewInstance.codeName;
        const content = [this.renderBodyMessage(), this.renderMainContent()]
        return this.renderMainContent()

    }

    /**
     * 是否显示返回按钮
     *
     * @readonly
     * @type {boolean}
     * @memberof ViewBase
     */
    get isShowBackButton(): boolean {
        // 存在路由，非路由使用，嵌入
        return this.viewDefaultUsage === "INDEXVIEW" ? false : true;
    }
    /**
     * 是否为部件视图
     * 
     * @memberof AppDefaultViewLayout
     */
    get isEmbedView() {
        return this.viewInstance.viewType.indexOf('VIEW9') != -1
    }

    /**
     *  绘制标题栏
     *
     * @memberof ViewBase
     */
    public renderCaptionBar() {
        const captionBar: any = ModelTool.findPSControlByName('captionbar', this.viewInstance.getPSControls());
        if (captionBar && this.viewInstance.showCaptionBar) {
            return (
                <div slot="layout-captionbar" class="app-captionbar-container">
                    <app-default-captionbar
                        viewModelData={this.viewInstance}
                        modelData={captionBar}
                        context={this.context}
                        viewparam={this.viewparams}
                    ></app-default-captionbar>
                </div>
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
        return (
            <div slot="layout-datainfobar" class="app-datainfobar-container">
                <app-default-datainfobar
                    modelData={datainfoBar}
                    viewInfo={this.model}
                    context={this.context}
                    viewparam={this.viewparams}
                ></app-default-datainfobar>
            </div>
        );
    }

    /**
     * 绘制头部标题栏
     * 
     * @memberof ViewBase
     */
    public renderViewHeaderCaptionBar() {
        if (!this.showCaptionBar) {
            return null;
        }
        const srfCaption = this.model.srfCaption;
        const dataInfo: string = this.model.dataInfo ? (`-${this.model.dataInfo}`) : '';
        const psimage = this.viewInstance.getPSSysImage();
        return <ion-title slot="captionbar" class="view-title"><app-ps-sys-image imageModel={psimage}></app-ps-sys-image>{dataInfo ? srfCaption + dataInfo : srfCaption}</ion-title>
    }
    /**
     * 绘制返回
     *
     * @return {*} 
     * @memberof ViewBase
     */
    public renderBackButton() {
        return (
            this.$createElement(
                'ion-buttons',
                {
                    slot: 'mobnavleftmenu',
                    attrs: { slot: 'start' },
                },
                [this.isShowBackButton && (
                    <app-mob-button on-click={this.closeView.bind(this)}>
                        <ion-icon name="chevron-back" />
                        {this.$t('app.button.back')}
                    </app-mob-button>
                )],
            )
        );
    }

    /**
     * 绘制工具栏
     *
     * @return {*} 
     * @memberof ViewBase
     */
    public renderToolBars() {
        if (!this.toolbarModels) {
            return [this.renderBackButton()];
        }
        const toolbars = Object.keys(this.toolbarModels).map((item: any) => {
            return (
                <view-toolbar
                    slot={item.toLowerCase()}
                    toolbarModel={this.toolbarModels[item]}
                    toolBarAuth={this.toolBarAuth[item]}
                    viewtag={this.viewtag}
                    on-item-click={(data: any, $event: any) => {
                        this.handleItemClick(data, $event);
                    }}
                >
                </view-toolbar>
            );
        });
        if (!this.toolbarModels['MOBNAVLEFTMENU']) {
            toolbars.push(this.renderBackButton());
        }
        return toolbars;
    }
}
