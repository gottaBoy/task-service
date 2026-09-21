import Vue from "vue";
import { IPSAppCounterRef, IPSAppDataEntity, IPSAppDEField, IPSAppDERedirectView, IPSAppDERS, IPSAppDEView, IPSAppUILogicRefView, IPSAppUINewDataLogic, IPSAppUIOpenDataLogic, IPSAppView, IPSAppViewLogic, IPSAppViewRef, IPSControl, IPSControlContainer, IPSControlLogic, IPSDETBGroupItem, IPSDETBRawItem, IPSDEToolbar, IPSDEToolbarItem, IPSDEUIAction, IPSLanguageRes, IPSNavigateContext, IPSNavigateParam } from "@ibiz/dynamic-model-api";
import { AppCtrlEventEngine, AppItemEngine, AppPanelEventEngine, AppServiceBase, AppTimerEngine, AppViewEventEngine, CounterService, DataServiceHelp, IParams, LogUtil, ModelTool, throttle, UIServiceHelp, Util, ViewTool } from "ibiz-core";
import { AppGlobalService, AppViewLogicService, LayoutLoadingService, ViewLoadingService } from "../app-service";
import { Subject } from "rxjs";

/**
 *  容器对象
 */
export class ControlContainer extends Vue {

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public containerModel: any;

    /**
     * 容器类型
     *
     * @type {('VIEW' | 'VIEWLAYOUT' | 'CTRL')}
     * @memberof ControlContainer
     */
    public type: 'VIEW' | 'VIEWLAYOUT' | 'CTRL' = 'VIEW';

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public context: any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public viewparams: any = {};

    /**
     * 导航数据（用于数据穿透）
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public navdatas!: any;

    /**
     * 视图操作参数集合
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public viewCtx: any = {};

    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ControlContainer
     */
    public counterServiceArray: Array<any> = [];

    /**
     * 界面触发逻辑Map
     * 
     * @memberof ControlContainer
     */
    public containerTriggerLogicMap: Map<string, any> = new Map();

    /**
     * 工具栏逻辑Map
     *
     * @type {Map<string, AppItemEngine[]>}
     * @memberof ControlContainer
     */
    public toolBarLogicMap: Map<string, AppItemEngine[]> = new Map();

    /**
     * 注册事件逻辑分隔符
     * 
     * @memberof ControlContainer
     */
    public registerEventSeparator: string = 'ibiz__';

    /**
     * 挂载状态集合
     *
     * @type {Map<string,boolean>}
     * @memberof ControlContainer
     */
    public mountedMap: Map<string, boolean> = new Map();

    /**
     * 容器是否已经完成挂载
     *
     * @type {boolean}
     * @memberof ControlContainer
     */
    public hasContainerMounted: boolean = false;

    /**
     * 实体服务对象
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public appEntityService: any;

    /**
     * 环境文件
     * 
     * @protected
     * @memberof ControlContainer
     */
    protected Environment: any = AppServiceBase.getInstance().getAppEnvironment();

    /**
     * 视图loading服务
     *
     * @type {ViewLoadingService}
     * @memberof ControlContainer
     */
    public viewLoadingService: ViewLoadingService = new ViewLoadingService();

    /**
     * 视图布局面板loading服务
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public layoutLoadingService: LayoutLoadingService = new LayoutLoadingService();

    /**
     * 实体UI服务对象
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public appUIService: any;

    /**
     * 视图引擎
     *
     * @public
     * @type {*}
     * @memberof ControlContainer
     */
    public engine: any;

    /**
     * 默认工具栏模型数据
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public toolbarModels: any;

    /**
     * 初始化容器模型(初始化调用，需外部调用)
     *
     * @memberof ControlContainer
     */
    public initUIContainerModel(type: 'VIEW' | 'VIEWLAYOUT' | 'CTRL', opts: any) {
        this.type = type;
        this.containerModel = opts;
    }

    /**
     * 初始化容器基础数聚（上下文构造之前）
     *
     * @memberof ControlContainer
     */
    public async initUIContainerBeforeCtx() {
        if (!this.containerModel) {
            return;
        }
        // 容器模型数据加载
        await this.UIContainerModelLoad();
        // 初始化挂载状态集合
        this.initUIContainerMountedMap();
    }

    /**
     * 初始化容器基础数聚（上下文构造之后）
     *
     * @memberof ControlContainer
     */
    public async initUIContainerAfterCtx() {
        if (!this.containerModel) {
            return;
        }
        // 初始化容器计数器服务
        await this.initUICounterService(this.containerModel, this.context, this.viewparams);
        // 初始化应用界面基础服务
        await this.initContainerBasicService();
        // 初始化容器逻辑
        await this.initUIContainerLogic(this.containerModel);
        // 初始化容器默认工具栏
        this.initDefaultToolBar();
    }

    /**
     * @description 容器销毁
     * @memberof ControlContainer
     */
    public containerDestroyed() {
        if (this.engine) {
            this.engine.destroyed();
        }
        this.viewCtx = null;
    }

    /**
     * 销毁容器
     *
     * @memberof ControlContainer
     */
    public destroyUIContainer() {
        // 销毁计数器定时器
        this.destroyContainerCounter();
        // 销毁容器定时器逻辑
        this.destroyContainerLogicTimer();
    }

    /**
     * 容器模型数据加载
     *
     * @memberof ControlContainer
     */
    public async UIContainerModelLoad() {
        // 视图部件数据加载
        if (this.containerModel.getPSControls()) {
            for (const control of this.containerModel.getPSControls() as IPSControl[]) {
                await control.fill();
            }
        }
        // 视图应用实体加载
        await this.containerModel?.getPSAppDataEntity?.()?.fill();
    }

    /**
     * 初始化挂载状态集合
     *
     * @memberof ControlContainer
     */
    public initUIContainerMountedMap() {
        let controls = this.containerModel?.getPSControls?.();
        controls?.forEach((item: any) => {
            if (item.controlType == "TOOLBAR" || item.controlType == "SEARCHBAR" || item.controlType == "CAPTIONBAR" || item.controlType == "DATAINFOBAR") {
                this.mountedMap.set(item.name, true);
            } else {
                this.mountedMap.set(item.name, false);
            }
        })
        this.mountedMap.set('self', false);
    }

    /**
     * 设置已经绘制完成状态
     *
     * @memberof ControlContainer
     */
    public setContainerIsMounted(name: string = 'self') {
        this.mountedMap.set(name, true);
        if ([...this.mountedMap.values()].indexOf(false) == -1) {
            if (!this.hasContainerMounted) {
                this.$nextTick(() => {
                    this.containerMounted();
                })
            }
        }
    }

    /**
     * 容器挂载完成
     *
     * @memberof ControlContainer
     */
    public containerMounted() {
        this.hasContainerMounted = true;
        // 处理视图定时器逻辑
        this.handleContainerTimerLogic();
    }

    /**
     * 初始化容器计数器服务
     *
     * @param {*} model 视图实例
     * @memberof ControlContainer
     */
    public async initUICounterService(model: any, context: any, viewParam: any) {
        const appCounterRef: Array<IPSAppCounterRef> = (model as IPSControlContainer).getPSAppCounterRefs() || [];
        if (appCounterRef && appCounterRef.length > 0) {
            for (const counterRef of appCounterRef) {
                const counter = counterRef.getPSAppCounter?.();
                if (counter) {
                    await counter.fill(true);
                    const counterService: any = new CounterService();
                    await counterService.loaded(counter, { context: context, viewparams: viewParam });
                    const tempData: any = { id: counterRef.id, path: counter.modelPath, service: counterService };
                    this.counterServiceArray.push(tempData);
                }
            }
        }
    }

    /**
     *  计数器刷新
     *
     * @memberof ControlContainer
     */
    public counterRefresh(arg?: any) {
        if (this.counterServiceArray && this.counterServiceArray.length > 0) {
            this.counterServiceArray.forEach((item: any) => {
                let counterService = item.service;
                if (counterService && counterService.refreshCounterData && counterService.refreshCounterData instanceof Function) {
                    const tempParams = Util.deepCopy(this.viewparams);
                    if (arg && Object.keys(arg).length > 0) {
                        Object.assign(tempParams, arg);
                    }
                    counterService.refreshCounterData(this.context, tempParams);
                }
            })
        }
    }

    /**
     * 销毁计数器定时器
     *
     * @memberof ControlContainer
     */
    public destroyContainerCounter() {
        if (this.counterServiceArray && this.counterServiceArray.length > 0) {
            this.counterServiceArray.forEach((item: any) => {
                let counterService = item.service;
                if (counterService && counterService.destroyCounter && counterService.destroyCounter instanceof Function) {
                    counterService.destroyCounter();
                }
            })
        }
    }

    /**
     * 初始化应用界面基础服务
     *
     * @memberof ControlContainer
     */
    public async initContainerBasicService() {
        if (
            this.containerModel &&
            this.containerModel.getPSAppDataEntity() &&
            ModelTool.getContainerAppEntityCodeName(this.containerModel)
        ) {
            this.appUIService = await UIServiceHelp.getInstance().getService(
                this.containerModel.getPSAppDataEntity(),
                { context: this.context }
            );
            if (this.appUIService) {
                await this.appUIService.loaded();
            }
            this.appEntityService = await DataServiceHelp.getInstance().getService(
                this.containerModel?.getPSAppDataEntity(),
                { context: this.context }
            );
        }
    }

    /**
     * 初始化容器逻辑
     * 
     * @memberof ControlContainer
     */
    public async initUIContainerLogic(model: any) {
        if (model.getPSAppViewLogics() && model.getPSAppViewLogics().length > 0) {
            model.getPSAppViewLogics().forEach((element: any) => {
                // 目标逻辑类型类型为实体界面逻辑、系统预置界面逻辑、前端扩展插件、脚本代码
                if (element && element.logicTrigger && (Object.is(element.logicType, 'DEUILOGIC') ||
                    Object.is(element.logicType, 'SYSVIEWLOGIC') ||
                    Object.is(element.logicType, 'PFPLUGIN') ||
                    Object.is(element.logicType, 'SCRIPT'))) {
                    switch (element.logicTrigger) {
                        case 'TIMER':
                            this.containerTriggerLogicMap.set(element.name.toLowerCase(), new AppTimerEngine(element));
                            break;
                        case 'CTRLEVENT':
                            if (element?.getPSViewCtrlName() && element?.eventNames) {
                                this.containerTriggerLogicMap.set(`${element.getPSViewCtrlName()?.toLowerCase()}-${element.eventNames?.toLowerCase()}`, new AppCtrlEventEngine(element));
                            }
                            break;
                        case 'PANELEVENT':
                            if (element?.getPSViewCtrlName() && element?.eventNames) {
                                this.containerTriggerLogicMap.set(`${element.getPSViewCtrlName()?.toLowerCase()}-${element.eventNames?.toLowerCase()}`, new AppPanelEventEngine(element));
                            }
                            break;
                        case 'VIEWEVENT':
                            if (element?.eventNames) {
                                this.containerTriggerLogicMap.set(`${element.eventNames?.toLowerCase()}`, new AppViewEventEngine(element));
                            }
                            break;
                        default:
                            console.log(`视图${element.logicTrigger}类型暂未支持`);
                            break;
                    }
                }
                // 绑定用户自定义事件
                if (element.eventNames && element.eventNames.toLowerCase().startsWith(this.registerEventSeparator)) {
                    this.$on(element.eventNames, (...args: any) => {
                        this.handleContainerCustomEvent(element.name?.toLowerCase(), null, args);
                    });
                }
            });
        }
    }

    /**
     * 处理容器预置事件
     *
     * @param {string} eventName
     * @memberof ControlContainer
     */
    public async handleContainerPreEvent(eventName: string) {
        if (this.containerTriggerLogicMap.get(eventName.toLowerCase())) {
            return await this.containerTriggerLogicMap.get(eventName.toLowerCase()).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: {}, args: {} }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
        } else {
            return true;
        }
    }

    /**
     * 处理容器自定义事件
     *
     * @memberof ControlContainer
     */
    public handleContainerCustomEvent(name: string, data: any, args: any) {
        if (this.containerTriggerLogicMap.get(name)) {
            this.containerTriggerLogicMap.get(name).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, args: args }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
        }
    }

    /**
     * 处理容器定时器逻辑
     *
     * @memberof ControlContainer
     */
    public handleContainerTimerLogic() {
        if (this.containerTriggerLogicMap && this.containerTriggerLogicMap.size > 0) {
            for (let item of this.containerTriggerLogicMap.values()) {
                if (item && (item instanceof AppTimerEngine)) {
                    item.executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: null }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
                }
            }
        }
    }

    /**
     * 处理工具栏预置逻辑
     *
     * @memberof ControlContainer
     */
    public handleToolBarLogic(data: any[]) {
        const viewToolBarLogics = this.toolBarLogicMap.get('toolbar');
        if (viewToolBarLogics && viewToolBarLogics.length > 0) {
            viewToolBarLogics.forEach((logic: AppItemEngine) => {
                logic.executeUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, itemModels: this.toolbarModels }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
            });
        }
    }

    /**
     * 销毁容器定时器逻辑
     *
     * @memberof ControlContainer
     */
    public destroyContainerLogicTimer() {
        if (this.containerTriggerLogicMap && this.containerTriggerLogicMap.size > 0) {
            for (let item of this.containerTriggerLogicMap.values()) {
                if (item && (item instanceof AppTimerEngine)) {
                    item.destroyTimer();
                }
            }
        }
    }

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof ControlContainer
     */
    public engineInit(opts: any = {}): void {
        const conatinerEngine = this.containerModel.findPSAppViewEngine('engine');
        if (!conatinerEngine) {
            LogUtil.log(`${this.containerModel.codeName}容器无引擎`);
            return;
        }
        let engineOpts = Object.assign({
            view: this,
            p2k: '0',
            isLoadDefault: true,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase()
        }, opts);
        const appUIEngineParams = conatinerEngine.getPSUIEngineParams();
        if (appUIEngineParams && (appUIEngineParams.length > 0)) {
            appUIEngineParams.forEach((element: any) => {
                // 逻辑
                if (Object.is(element.paramType, 'LOGIC')) {
                    if (Object.is(element.name, 'OPENDATA')) {
                        Object.assign(engineOpts, {
                            opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                                this.opendata(args, fullargs, params, $event, xData);
                            }
                        })
                    }
                    if (Object.is(element.name, 'NEWDATA')) {
                        Object.assign(engineOpts, {
                            newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                                this.newdata(args, fullargs, params, $event, xData);
                            }
                        })
                    }
                }
                // 部件
                if (Object.is(element.paramType, 'CTRL')) {
                    Object.assign(engineOpts, {
                        [element.ctrlName]: (this.$refs[element.ctrlName] as any).ctrl
                    })
                }
            });
        }
        this.engine.init(engineOpts);
    }

    /**
     * 部件事件
     * 
     * @param controlname 部件名称 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof ControlContainer
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (action == 'controlIsMounted') {
            this.setContainerIsMounted(controlname);
        } else if (action === 'destoryCounter') {
            this.destroyContainerCounter();
        } else {
            if (Object.is(action, 'authlimit')) {
                this.renderShade();
            } else {
                if (controlname && action && this.containerTriggerLogicMap.get(`${controlname.toLowerCase()}-${action.toLowerCase()}`)) {
                    if (this.containerTriggerLogicMap.get(`${controlname.toLowerCase()}-${action.toLowerCase()}`)) {
                        this.containerTriggerLogicMap.get(`${controlname.toLowerCase()}-${action.toLowerCase()}`).executeAsyncUILogic({ arg: data, utils: this.viewCtx, app: this.viewCtx.app, view: this, ctrl: (this.$refs[controlname] as any).ctrl }).then((args: any) => {
                            if (args && args?.hasOwnProperty('srfret') && !args.srfret) {
                                return;
                            }
                            if (this.engine) {
                                this.exeMountedCtrlEvent(action, data);
                                this.engine.onCtrlEvent(controlname, action, data);
                            }
                        })
                    }
                } else {
                    if (this.engine) {
                        this.exeMountedCtrlEvent(action, data);
                        this.engine.onCtrlEvent(controlname, action, data);
                    }
                }
            }
        }
    }

    /**
     * 绘制容器部件集合
     * 
     * @memberof ControlContainer
     */
    public renderContainerControls() {
        const controlArray: Array<any> = [];
        if (this.containerModel.getPSControls() && (this.containerModel.getPSControls() as IPSControl[]).length > 0) {
            (this.containerModel.getPSControls() as IPSControl[]).forEach((control: IPSControl) => {
                const targetCtrl = this.renderTargetControl(control);
                controlArray.push(targetCtrl);
            });
        }
        return controlArray;
    }

    /**
     * 初始化容器默认工具栏数据
     *
     * @memberof ControlContainer
     */
    public initDefaultToolBar() {
        const targetViewToolbarItems: any[] = [];
        const viewToolBar: IPSDEToolbar = ModelTool.findPSControlByName('toolbar', this.containerModel.getPSControls());
        if (viewToolBar && viewToolBar.getPSDEToolbarItems()) {
            this.initToolBarUILogic(viewToolBar);
            viewToolBar.getPSDEToolbarItems()?.forEach((toolbarItem: IPSDEToolbarItem) => {
                targetViewToolbarItems.push(this.initToolBarItems(toolbarItem));
            });
        }
        this.toolbarModels = targetViewToolbarItems;
    }

    /**
     * 初始化工具栏预定义逻辑
     *
     * @param {IPSDEToolbar} viewToolBar
     * @memberof ControlContainer
     */
    public initToolBarUILogic(viewToolBar: IPSDEToolbar) {
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const ToolbarItems = viewToolBar.getPSDEToolbarItems();
            if (ToolbarItems && ToolbarItems.length > 0) {
                ToolbarItems.forEach((toolbarItem: IPSDEToolbarItem) => {
                    const itemLogics = toolbarItem.M.getPSControlLogics;
                    if (itemLogics && itemLogics.length > 0) {
                        itemLogics.forEach((logic: any) => {
                            if (
                                logic.triggerType === 'ITEMVISIBLE' ||
                                logic.triggerType === 'ITEMENABLE' ||
                                logic.triggerType === 'ITEMBLANK'
                            ) {
                                const logics = this.toolBarLogicMap.get(`${viewToolBar.name}`);
                                if (logics && logics.length > 0) {
                                    logics.push(new AppItemEngine(logic));
                                    this.toolBarLogicMap.set(`${viewToolBar.name}`, logics);
                                } else {
                                    this.toolBarLogicMap.set(`${viewToolBar.name}`, [new AppItemEngine(logic)]);
                                }
                            }
                        })
                    }
                })
            }
        } else {
            const tooBarLogics = viewToolBar.getPSControlLogics();
            if (tooBarLogics && tooBarLogics.length > 0) {
                tooBarLogics.forEach((logic: IPSControlLogic) => {
                    if (
                        logic.triggerType === 'ITEMVISIBLE' ||
                        logic.triggerType === 'ITEMENABLE' ||
                        logic.triggerType === 'ITEMBLANK'
                    ) {
                        const logics = this.toolBarLogicMap.get(`${viewToolBar.name}`);
                        if (logics && logics.length > 0) {
                            logics.push(new AppItemEngine(logic));
                            this.toolBarLogicMap.set(`${viewToolBar.name}`, logics);
                        } else {
                            this.toolBarLogicMap.set(`${viewToolBar.name}`, [new AppItemEngine(logic)]);
                        }
                    }
                })
            }
        }
    }

    /**
     * 初始化工具栏项
     *
     * @param {IPSDEToolbarItem} item
     * 
     * @@memberof ControlContainer
     */
    public initToolBarItems(item: IPSDEToolbarItem): void {
        if (item.itemType === 'ITEMS') {
            const items = (item as IPSDETBGroupItem).getPSDEToolbarItems();
            if (items && items.length != 0) {
                const models: Array<any> = [];
                const tempModel: any = {
                    name: item.name,
                    showCaption: item.showCaption,
                    showIcon: item.showIcon,
                    caption: this.$tl((item.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.caption),
                    tooltip: this.$tl((item.getTooltipPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.tooltip),
                    disabled: false,
                    visabled: true,
                    itemType: item.itemType,
                    dataaccaction: '',
                    actionLevel: (item as any).actionLevel,
                    dynaClass: item.dynaClass,
                    iconcls: item.getPSSysImage()?.cssClass,
                    hiddenItem: (item as any).hiddenItem
                };
                items.forEach((_item: any) => {
                    models.push(this.initToolBarItems(_item));
                });
                Object.assign(tempModel, {
                    model: models,
                });
                return tempModel;
            }
        }
        const img = item.getPSSysImage();
        const css = item.getPSSysCss();
        const uiAction = (item as any)?.getPSUIAction?.() as IPSDEUIAction;
        const tempModel: any = {
            name: item.name,
            showCaption: item.showCaption,
            caption: this.$tl((item.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.caption),
            tooltip: this.$tl((item.getTooltipPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.tooltip),
            disabled: false,
            visabled: uiAction?.dataAccessAction && this.Environment.enablePermissionValid ? false : true,
            itemType: item.itemType,
            dataaccaction: uiAction?.dataAccessAction,
            noprivdisplaymode: uiAction?.noPrivDisplayMode,
            uiaction: uiAction,
            showIcon: item.showIcon,
            class: css ? css.cssName : '',
            dynaClass: item.dynaClass,
            getPSSysImage: img ? { cssClass: img.cssClass, imagePath: img.imagePath } : '',
            actionLevel: (item as any).actionLevel,
            hiddenItem: (item as any).hiddenItem
        };
        if (item.itemType == 'RAWITEM') {
            Object.assign(tempModel, {
                rawType: (item as IPSDETBRawItem).contentType,
                rawContent: (item as IPSDETBRawItem).rawContent,
                htmlContent: (item as IPSDETBRawItem).htmlContent,
                dynaClass: item.dynaClass,
                style: {}
            })
            if (item.height) {
                Object.assign(tempModel.style, { height: item.height + 'px' });
            }
            if (item.width) {
                Object.assign(tempModel.style, { width: item.width + 'px' });
            }
        }
        return tempModel;
    }

    /**
     * 渲染容器默认工具栏
     *
     * @memberof MainViewBase
     */
    public renderToolBar() {
        if (!(this.toolbarModels && this.toolbarModels.length > 0)) {
            return null;
        }
        const slotName = `toolbar`;
        return (
            <view-toolbar
                slot={slotName}
                mode={'DEFAULT'}
                counterServiceArray={this.counterServiceArray}
                isViewLoading={this.viewLoadingService?.isLoading}
                toolbarModels={this.toolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, [data, $event], this);
                }}
            ></view-toolbar>
        );
    }

    /**
     * 绘制目标部件
     * 
     * @memberof ControlContainer
     */
    public renderTargetControl(control: IPSControl, slotMode: boolean = true, args?: any) {
        if (Object.is(control.controlType, 'TOOLBAR')) {
            if (Object.is(control.name, 'toolbar')) {
                return this.renderToolBar();
            } else {
                const viewToolBar: IPSDEToolbar = control as IPSDEToolbar;
                const targetViewToolbarItems: any[] = [];
                if (viewToolBar && viewToolBar.getPSDEToolbarItems()) {
                    viewToolBar.getPSDEToolbarItems()?.forEach((toolbarItem: IPSDEToolbarItem) => {
                        targetViewToolbarItems.push(this.initToolBarItems(toolbarItem));
                    });
                }
                return (
                    <view-toolbar
                        slot={`layout-${control.name}`}
                        mode={'DEFAULT'}
                        counterServiceArray={this.counterServiceArray}
                        isViewLoading={this.viewLoadingService?.isLoading}
                        toolbarModels={targetViewToolbarItems}
                        on-item-click={(data: any, $event: any) => {
                            throttle(this.handleItemClick, [data, $event], this);
                        }}
                    ></view-toolbar>
                );
            }
        } else if(Object.is(control.controlType, 'CAPTIONBAR')){
          return this.renderCaptionBar();
        } else  {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(control, args);
            if (slotMode) {
                return this.$createElement(targetCtrlName, { slot: `layout-${control.name}`, props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            } else {
                return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            }
        }
    }

    /**
     * 绘制标题栏
     *
     * @return {*} 
     * @memberof ControlContainer
     */
    public renderCaptionBar() {}

    /**
     * 执行挂载部件事件拦截
     *
     * @param {string} eventName 事件名称
     * @param {*} data 数据
     * @memberof ControlContainer
     */
    public exeMountedCtrlEvent(eventName: string, data: any) { }

    /**
     * 计算目标部件所需参数
     * 
     * @param controlInstance 部件模型
     * @param args 额外参数 {staticProps:{xxx},dynamicProps:{xxx},customEvent:{xxx}}
     * @memberof ControlContainer
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let targetCtrlName: string = `app-control-shell`;
        let targetCtrlParam: any = {
            staticProps: {
                containerInstance: this.containerModel,
                modelData: controlInstance,
                ref: controlInstance?.name,
                viewLoadingService: this.viewLoadingService,
                layoutLoadingService: this.layoutLoadingService
            },
            dynamicProps: {
                viewparams: this.viewparams,
                context: this.context,
                viewCtx: this.viewCtx
            }
        };
        if (!Object.is(controlInstance?.controlType, 'SEARCHFORM') &&
            !Object.is(controlInstance?.controlType, 'FORM') &&
            !Object.is(controlInstance?.controlType, 'TOOLBAR') &&
            !Object.is(controlInstance?.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.staticProps, {
                opendata: this.opendata,
                newdata: this.newdata,
            });
        }
        Object.defineProperty(targetCtrlParam.staticProps, 'containerInstance', { enumerable: false, writable: true });
        Object.defineProperty(targetCtrlParam.staticProps, 'modelData', { enumerable: false, writable: true });
        let targetCtrlEvent: any = {
            'ctrl-event': ({ controlname, action, data }: { controlname: string, action: string, data: any }) => {
                this.onCtrlEvent(controlname, action, data);
            }
        }
        // 合并传入自定义参数
        if (args && args.staticProps && Object.keys(args.staticProps).length > 0) {
            Object.assign(targetCtrlParam.staticProps, args.staticProps);
        }
        if (args && args.dynamicProps && Object.keys(args.dynamicProps).length > 0) {
            Object.assign(targetCtrlParam.dynamicProps, args.dynamicProps);
        }
        if (args && args.customEvent && Object.keys(args.customEvent).length > 0) {
            Object.assign(targetCtrlEvent, args.customEvent);
        }
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 工具栏点击
     *
     * @param ctrl 部件
     * @param action  行为
     * @param data 数据
     * @param $event 事件源对象
     *
     * @memberof ControlContainer
     */
    public handleItemClick(data: any, $event: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const viewToolBar: IPSDEToolbar = ModelTool.findPSControlByType('TOOLBAR', this.containerModel.getPSControls());
        let toolbarTag: string = 'toolbar';
        if (viewToolBar) {
            toolbarTag = viewToolBar.name;
        }
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const uiAction = ModelTool.getToolBarUIActionByItemName(viewToolBar, data.tag);
            const actionParam = { xDataControlName: this.containerModel.xDataControlName, entityName: this.appDeCodeName.toLowerCase() };
            AppGlobalService.getInstance().executeGlobalUIAction(uiAction, $event, this, actionParam);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(
                `${toolbarTag}_${data.tag}_click`,
                $event,
                this,
                undefined,
                this.containerModel.getPSAppViewLogics(),
            );
        }
    }

    /**
     * 绘制权限遮罩
     *
     * @memberof ControlContainer
     */
    public renderShade() {
        const currentViewKey = `${this.containerModel.codeName}`;
        const el: any = currentViewKey ? document.getElementById(currentViewKey) : null;
        if (el) {
            el.classList.add('no-authority-shade');
            const shade = document.createElement('div');
            shade.setAttribute('class', 'no-authority-shade-child');
            el.appendChild(shade);
        }
    }

    /**
     * 删除权限遮罩
     *
     * @memberof ControlContainer
     */
     public removeShade() {
        const currentViewKey = `${this.containerModel.codeName}`;
        const el: any = currentViewKey ? document.getElementById(currentViewKey) : null;
        if (el) {
            el.classList.remove('no-authority-shade');
            const targetElement = document.getElementsByClassName("no-authority-shade-child")[0];
            if(targetElement){
                el.removeChild(targetElement);
            }
        }
    }

    /**
     * 绘制无数据遮罩
     *
     * @memberof ControlContainer
     */
     public renderNoDataShade() {
        const currentViewKey = `${this.containerModel.codeName}`;
        const el: any = currentViewKey ? document.getElementById(currentViewKey) : null;
        if (el) {
            el.classList.add('no-nodata-shade');
            const shade = document.createElement('div');
            shade.setAttribute('class', 'no-nodata-shade-child');
            const span = document.createElement('span');
            span.setAttribute('class', 'empty-data-shade-tip')
            span.append(`${this.$t('app.commonwords.nodata')}`);
            shade.appendChild(span);
            el.appendChild(shade);
        }
    }

    /**
     * 删除权限遮罩
     *
     * @memberof ControlContainer
     */
     public removeNoDataShade() {
        const currentViewKey = `${this.containerModel.codeName}`;
        const el: any = currentViewKey ? document.getElementById(currentViewKey) : null;
        if (el) {
            el.classList.remove('no-nodata-shade');
            const targetElement = document.getElementsByClassName("no-nodata-shade-child")[0];
            if(targetElement){
                el.removeChild(targetElement);
            }
        }
    }

    /**
     * 应用实体代码名称
     *
     * @readonly
     * @memberof ControlContainer
     */
    get appDeCodeName() {
        return ModelTool.getContainerAppEntityCodeName(this.containerModel);
    }

    /**
     * 应用实体主键属性代码名称
     *
     * @readonly
     * @memberof ControlContainer
     */
    get appDeKeyFieldName() {
        return (
            (ModelTool.getAppEntityKeyField(
                this.containerModel?.getPSAppDataEntity() as IPSAppDataEntity,
            ) as IPSAppDEField)?.codeName || ''
        );
    }

    /**
     * 应用实体映射实体名称
     *
     * @readonly
     * @memberof ControlContainer
     */
    get deName() {
        return (this.containerModel?.getPSAppDataEntity() as any)?.getPSDEName() || '';
    }

    /**
     * 应用实体主信息属性代码名称
     *
     * @readonly
     * @memberof ControlContainer
     */
    get appDeMajorFieldName() {
        return (
            (ModelTool.getAppEntityMajorField(
                this.containerModel?.getPSAppDataEntity() as IPSAppDataEntity,
            ) as IPSAppDEField)?.codeName || ''
        );
    }

    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args 数据参数
     * @param {*} [fullargs] 全量参数
     * @param {*} [params]  额外参数
     * @param {*} [$event] 事件源数据
     * @param {*} [xData] 数据部件
     * @memberof ControlContainer
     */
    public async opendata(args: any[], fullargs?: any, params?: any, $event?: any, xData?: any) {
        const openAppViewLogic: IPSAppViewLogic | null = this.containerModel.findPSAppViewLogic('opendata');
        if (!openAppViewLogic || !openAppViewLogic.getPSAppUILogic()) {
            return;
        }
        let viewOpenAppUIlogic:
            | IPSAppUIOpenDataLogic
            | undefined
            | null = openAppViewLogic.getPSAppUILogic() as IPSAppUIOpenDataLogic;
        if (viewOpenAppUIlogic && viewOpenAppUIlogic?.getParentPSModelObject()?.M.viewType) {
            // todo
        }
        if (viewOpenAppUIlogic?.getOpenDataPSAppView()) {
            const openViewRef: IPSAppUILogicRefView = viewOpenAppUIlogic.getOpenDataPSAppView() as IPSAppUILogicRefView;
            const data: any = {};
            let tempContext = JSON.parse(JSON.stringify(this.context));
            // 准备参数
            if (args.length > 0) {
                Object.assign(tempContext, args[0]);
            }
            if (
                openViewRef?.getPSNavigateContexts() &&
                (openViewRef?.getPSNavigateContexts() as IPSNavigateContext[])?.length > 0
            ) {
                const localContext = Util.formatNavParam(openViewRef.getPSNavigateContexts());
                let _context: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localContext);
                Object.assign(tempContext, _context);
            }
            if (
                openViewRef?.getPSNavigateParams() &&
                (openViewRef.getPSNavigateParams() as IPSNavigateParam[])?.length > 0
            ) {
                const localViewParam = Util.formatNavParam(openViewRef.getPSNavigateParams());
                let _param: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localViewParam);
                Object.assign(data, _param);
            }
            if (
                fullargs &&
                fullargs.length > 0 &&
                fullargs[0]['srfprocessdefinitionkey'] &&
                fullargs[0]['srftaskdefinitionkey']
            ) {
                Object.assign(data, { processDefinitionKey: fullargs[0]['srfprocessdefinitionkey'] });
                Object.assign(data, { taskDefinitionKey: fullargs[0]['srftaskdefinitionkey'] });
                // 将待办任务标记为已读准备参数
                const that: any = this;
                if (that.quickGroupData && that.quickGroupData.hasOwnProperty('srfwf') && fullargs[0]['srftaskid']) {
                    Object.assign(data, { srfwf: that.quickGroupData['srfwf'] });
                    Object.assign(data, { srftaskid: fullargs[0]['srftaskid'] });
                }
            }
            let deResParameters: any[] = [];
            let parameters: any[] = [];
            const openView: IPSAppView | null = openViewRef.getRefPSAppView();
            if (!openView) return;
            await openView.fill(true);
            if (openView.getPSAppDataEntity()) {
                // 处理视图关系参数 （只是路由打开模式才计算）
                if (!openView.openMode || openView.openMode == 'INDEXVIEWTAB' || openView.openMode == 'POPUPAPP') {
                    deResParameters = Util.formatAppDERSPath(
                        tempContext,
                        await ModelTool.fillAppDERSPath((openView as IPSAppDEView).getPSAppDERSPaths()),
                    );
                }
            }
            if (!openView?.openMode || openView.openMode == 'INDEXVIEWTAB' || openView.openMode == 'POPUPAPP') {
                if (openView.getPSAppDataEntity()) {
                    parameters = [
                        {
                            pathName: Util.srfpluralize(
                                (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                            ).toLowerCase(),
                            parameterName: (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                        },
                        {
                            pathName: 'views',
                            parameterName: ((openView as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase(),
                        },
                    ];
                } else {
                    parameters = [{ pathName: 'views', parameterName: openView.name?.toLowerCase() }];
                }
            } else {
                if (openView?.getPSAppDataEntity()) {
                    parameters = [
                        {
                            pathName: Util.srfpluralize(
                                (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                            )?.toLowerCase(),
                            parameterName: (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName?.toLowerCase(),
                        },
                    ];
                }
                if (openView && openView.modelPath) {
                    Object.assign(tempContext, { viewpath: openView.modelPath });
                }
            }
            // 关闭视图回调
            let callback: Function = (result: any, xData: any) => {
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                if (!xData || !(xData.refresh instanceof Function)) {
                    return;
                }
                xData.refresh(result.datas);
            };
            // 重定向视图
            if (openView?.redirectView) {
                let targetRedirectView: IPSAppDERedirectView = openView as IPSAppDERedirectView;
                await targetRedirectView.fill();
                if (
                    targetRedirectView.getRedirectPSAppViewRefs() &&
                    targetRedirectView.getRedirectPSAppViewRefs()?.length === 0
                ) {
                    return;
                }
                const targetViewparams: IParams = {};
                if (params && Object.keys(params).length > 0) {
                    Object.assign(targetViewparams, params);
                }
                Object.assign(targetViewparams, data);
                const redirectUIService: any = await UIServiceHelp.getInstance().getService(targetRedirectView.getPSAppDataEntity(), { context: this.context });
                await redirectUIService.loaded();
                const redirectAppEntity: IPSAppDataEntity | null = targetRedirectView.getPSAppDataEntity();
                await ViewTool.calcRedirectContext(tempContext, fullargs[0], redirectAppEntity);
                if (targetRedirectView.getPSAppViewNavContexts()) {
                    const localContextRef: any = Util.formatNavParam(targetRedirectView.getPSAppViewNavContexts(), true);
                    const _context: any = Util.computedNavData(args[0], tempContext, targetViewparams, localContextRef);
                    Object.assign(tempContext, _context);
                }
                if (targetRedirectView.getPSAppViewNavParams()) {
                    const localContextRef: any = Util.formatNavParam(targetRedirectView.getPSAppViewNavParams(), true);
                    const _params: any = Util.computedNavData(args[0], tempContext, targetViewparams, localContextRef);
                    Object.assign(targetViewparams, _params);
                }
                redirectUIService.getRDAppView(
                    tempContext,
                    targetViewparams,
                    args[0],
                    { action: targetRedirectView.getGetDataPSAppDEAction()?.codeName, type: targetRedirectView.getTypePSAppDEField()?.codeName }
                )
                    .then(async (result: any) => {
                        if (!result) {
                            return;
                        }
                        const data = result.srfdata;
                        if (data) {
                            let linkUrl: string = data.linkurl;
                            if (linkUrl && linkUrl !== '') {
                                if (linkUrl.startsWith('http://') || linkUrl.startsWith('https://')) {
                                    window.open(linkUrl, '_blank');
                                } else {
                                    if (linkUrl.startsWith('appredirectview')) {
                                        linkUrl = "/"+linkUrl;
                                    }
                                    this.$router.push(linkUrl);
                                }
                                return;
                            }
                        }
                        let targetOpenViewRef:
                            | IPSAppViewRef
                            | undefined = ViewTool.computeRedirectViewRef(targetRedirectView, params, result);
                        if (!targetOpenViewRef) {
                            return;
                        }
                        let targetOpenView: IPSAppView | null = targetOpenViewRef.getRefPSAppView();
                        if (!targetOpenView) {
                            return;
                        }
                        await targetOpenView.fill(true);
                        if (result && result.indextype) {
                            const indexContext: any = Util.formatNavParam(
                                [{ key: targetOpenView?.getPSAppDataEntity()?.codeName, rawValue: false, value: this.appDeCodeName }],
                                true,
                            );
                            const _context: any = Util.computedNavData(fullargs[0], tempContext, data, indexContext);
                            Object.assign(tempContext, _context);
                        }
                        if (
                            targetOpenViewRef.getPSNavigateContexts() &&
                            (targetOpenViewRef.getPSNavigateContexts() as IPSNavigateContext[]).length > 0
                        ) {
                            let localContextRef: any = Util.formatNavParam(
                                targetOpenViewRef.getPSNavigateContexts(),
                                true,
                            );
                            let _context: any = Util.computedNavData(fullargs[0], tempContext, data, localContextRef);
                            Object.assign(tempContext, _context);
                        }
                        ViewTool.clearParentParams(tempContext,data);
                        const view: any = {
                            viewname: 'app-view-shell',
                            height: targetOpenView.height,
                            width: targetOpenView.width,
                            title: this.$tl(targetOpenView.getTitlePSLanguageRes()?.lanResTag, targetOpenView.title),
                        };
                        if (!targetOpenView.openMode || targetOpenView.openMode == 'INDEXVIEWTAB' || targetOpenView.openMode == 'POPUPAPP') {
                            if (targetOpenView.getPSAppDataEntity()) {
                                deResParameters = Util.formatAppDERSPath(
                                    tempContext,
                                    await ModelTool.fillAppDERSPath((targetOpenView as IPSAppDEView).getPSAppDERSPaths()),
                                );
                                parameters = [
                                    {
                                        pathName: Util.srfpluralize(
                                            (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                        ).toLowerCase(),
                                        parameterName: (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                                    },
                                    {
                                        pathName: 'views',
                                        parameterName: ((targetOpenView as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase(),
                                    },
                                ];
                            } else {
                                parameters = [
                                    {
                                        pathName: targetOpenView.codeName.toLowerCase(),
                                        parameterName: targetOpenView.codeName.toLowerCase(),
                                    },
                                ];
                            }
                        } else {
                            if (targetOpenView.getPSAppDataEntity()) {
                                parameters = [
                                    {
                                        pathName: Util.srfpluralize(
                                            (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                        ).toLowerCase(),
                                        parameterName: (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                                    },
                                ];
                            }
                            if (targetOpenView && targetOpenView.modelPath) {
                                Object.assign(tempContext, { viewpath: targetOpenView.modelPath });
                            }
                        }
                        this.openTargtView(
                            targetOpenView,
                            view,
                            tempContext,
                            data,
                            xData,
                            $event,
                            deResParameters,
                            parameters,
                            args,
                            callback,
                        );
                    });
            } else {
                if (fullargs && fullargs.copymode) {
                    Object.assign(data, { copymode: true });
                }
                let view: any = {
                    viewname: 'app-view-shell',
                    height: openView.height,
                    width: openView.width,
                    title: this.$tl(openView.getCapPSLanguageRes()?.lanResTag, openView.caption),
                    customClass: '',
                };
                const params = openView.M.getPSAppViewParams;
                if (params && params.length > 0) {
                    const modalclass = params.find((item: any) => {
                        return item.key === 'MODALCLASS';
                    });
                    if (modalclass) {
                        Object.assign(view, { customClass: modalclass.value });
                    }
                }
                this.openTargtView(
                    openView,
                    view,
                    tempContext,
                    data,
                    xData,
                    $event,
                    deResParameters,
                    parameters,
                    args,
                    callback,
                );
            }
        } else {
            LogUtil.warn(this.$t('app.nosupport.unassign'), 'opendata');
        }
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args 数据参数
     * @param {*} [fullargs] 全量参数
     * @param {*} [params]  额外参数
     * @param {*} [$event] 事件源数据
     * @param {*} [xData] 数据部件
     * @memberof ControlContainer
     */
    public async newdata(args: any[], fullargs?: any, params?: any, $event?: any, xData?: any) {
        const newAppViewLogic: IPSAppViewLogic | null = this.containerModel?.findPSAppViewLogic('newdata');
        if (!newAppViewLogic || !newAppViewLogic.getPSAppUILogic()) {
            return;
        }
        let viewNewAppUIlogic: IPSAppUINewDataLogic | undefined | null = newAppViewLogic.getPSAppUILogic() as IPSAppUINewDataLogic;
        if (viewNewAppUIlogic) {
            if (viewNewAppUIlogic.enableWizardAdd) {
                let wizardPSAppView: IPSAppView | null;
                if (viewNewAppUIlogic.getWizardPSAppView()) {
                    wizardPSAppView = (viewNewAppUIlogic.getWizardPSAppView() as IPSAppUILogicRefView).getRefPSAppView();
                    if (!wizardPSAppView) return;
                    await wizardPSAppView.fill();
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: wizardPSAppView.height,
                        width: wizardPSAppView.width,
                        title: this.$tl(wizardPSAppView.getTitlePSLanguageRes()?.lanResTag, wizardPSAppView.title),
                    };
                    const tempContext: any = JSON.parse(JSON.stringify(this.context));
                    if (wizardPSAppView && wizardPSAppView.modelPath) {
                        Object.assign(tempContext, { viewpath: wizardPSAppView.modelPath });
                    }
                    let container: Subject<any> = this.$appmodal.openModal(view, tempContext, args[0]);
                    container.subscribe(async (result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        if (result && result.datas && result.datas.length > 0) {
                            const newDataAppViews: Array<
                                IPSAppUILogicRefView
                            > | null = (viewNewAppUIlogic as IPSAppUINewDataLogic).getNewDataPSAppViews();
                            if (newDataAppViews) {
                                const targetNewDataAppViewRef:
                                    | IPSAppUILogicRefView
                                    | undefined
                                    | null = newDataAppViews.find((item: IPSAppUILogicRefView) => {
                                        return item.refMode === result.datas[0].srfkey;
                                    });
                                if (!targetNewDataAppViewRef) return;
                                Object.assign(
                                    tempContext,
                                    Util.formatNavParam(targetNewDataAppViewRef.getPSNavigateContexts()),
                                );
                                const targetNewDataAppView: IPSAppView | null = targetNewDataAppViewRef.getRefPSAppView();
                                if (!targetNewDataAppView) return;
                                await targetNewDataAppView.fill();
                                const view: any = {
                                    viewname: 'app-view-shell',
                                    height: targetNewDataAppView.height,
                                    width: targetNewDataAppView.width,
                                    title: this.$tl(targetNewDataAppView.getTitlePSLanguageRes()?.lanResTag, targetNewDataAppView.title),
                                };
                                if (targetNewDataAppView && targetNewDataAppView.modelPath) {
                                    Object.assign(tempContext, { viewpath: targetNewDataAppView.modelPath });
                                }
                                let container: Subject<any> = this.$appmodal.openModal(view, tempContext, args[0]);
                                container.subscribe((result: any) => {
                                    if (!result || !Object.is(result.ret, 'OK')) {
                                        return;
                                    }
                                    if (result && result.datas && result.datas.length > 0) {
                                        if (!xData || !(xData.refresh instanceof Function)) {
                                            return;
                                        }
                                        xData.refresh(result.datas);
                                    }
                                });
                            }
                        }
                    });
                }
            } else if (viewNewAppUIlogic.enableBatchAdd) {
                let batchAddPSAppViews: Array<IPSAppUILogicRefView> = [];
                let minorPSAppDERSs: IPSAppDERS[] = (this.containerModel.getPSAppDataEntity() as IPSAppDataEntity).getMinorPSAppDERSs() as IPSAppDERS[];
                if (!minorPSAppDERSs) return;
                await (minorPSAppDERSs[0] as IPSAppDERS).fill();
                if (
                    viewNewAppUIlogic.getBatchAddPSAppViews() &&
                    (viewNewAppUIlogic.getBatchAddPSAppViews() as IPSAppUILogicRefView[]).length > 0
                ) {
                    batchAddPSAppViews = viewNewAppUIlogic.getBatchAddPSAppViews() as IPSAppUILogicRefView[];
                }
                if (batchAddPSAppViews.length == 0) {
                    this.$warning(this.$t('app.warn.nton'), 'newdata');
                    return;
                }
                let openViewModel: IPSAppUILogicRefView | undefined = batchAddPSAppViews.find(
                    (item: IPSAppUILogicRefView) => {
                        return item.refMode && item.refMode !== this.context.srfparentdename.toUpperCase();
                    },
                );
                let otherViewModel: IPSAppUILogicRefView | undefined = batchAddPSAppViews.find(
                    (item: IPSAppUILogicRefView) => {
                        return item.refMode && item.refMode == this.context.srfparentdename.toUpperCase();
                    },
                );
                if (!openViewModel) {
                    this.$warning(this.$t('app.warn.nton'), 'newdata');
                    return;
                }
                let openView: IPSAppDEView = openViewModel.getRefPSAppView() as IPSAppDEView;
                await openView.fill(true);
                let otherView: IPSAppDEView;
                if (otherViewModel) {
                    otherView = otherViewModel.getRefPSAppView() as IPSAppDEView;
                    await otherView.fill(true);
                }
                let view: any = {
                    viewname: 'app-view-shell',
                    height: openView.height,
                    width: openView.width,
                    title: this.$tl(openView.getCapPSLanguageRes()?.lanResTag, openView.caption),
                };
                let tempContext: any = Util.deepCopy(this.context);
                if (openView && openView.modelPath) {
                    Object.assign(tempContext, { viewpath: openView.modelPath });
                }
                let container: Subject<any> = this.$appmodal.openModal(view, tempContext, args[0]);
                container.subscribe(async (result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    if (result.datas && result.datas.length == 0) {
                        return;
                    }
                    let requestParam: Array<any> = [];
                    // 从数据模式
                    // if (this.containerModel.tempMode === 2) {
                    //     let tempMajorAppEntity: any;
                    //     if (this.context['srfparentdename']) {
                    //         const activedAppDERS = minorPSAppDERSs.find((item: IPSAppDERS) => {
                    //             return item.M.majorDECodeName === this.context['srfparentdename'];
                    //         })
                    //         tempMajorAppEntity = activedAppDERS?.getMajorPSAppDataEntity();
                    //         await tempMajorAppEntity?.fill();
                    //     }
                    //     if (!tempMajorAppEntity) {
                    //         this.$warning(this.$t('app.warn.batcherror'), 'newdata');
                    //     }
                    //     const tempMajorKey = (ModelTool.getAppEntityKeyField(tempMajorAppEntity) as IPSAppDEField)?.codeName.toLowerCase();
                    //     const tempOpenKey = (ModelTool.getAppEntityKeyField(openView?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase();
                    //     const tempOpenText = (ModelTool.getAppEntityMajorField(openView?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase();
                    //     result.datas.forEach((record: any) => {
                    //         let tempParam: any = {};
                    //         tempParam[tempMajorKey] = this.context['srfparentkey'];
                    //         tempParam[tempOpenKey] = record.srfkey;
                    //         tempParam[tempOpenText] = record.srfmajortext;
                    //         requestParam.push(tempParam);
                    //     });
                    //     const tempContext = JSON.parse(JSON.stringify(this.context));
                    //     if (tempContext.srfsessionid) {
                    //         Object.assign(tempContext, { srfsessionkey: tempContext.srfsessionid });
                    //         delete tempContext.srfsessionid;
                    //     }
                    //     const storeItems = await this.appEntityService.getLocals(tempContext);
                    //     if (requestParam && requestParam.length > 0) {
                    //         let response: any;
                    //         if (storeItems && storeItems.length > 0) {
                    //             for (let i = 0; i < requestParam.length; i++) {
                    //                 const storeItem = storeItems.find((ele: any) => {
                    //                     return ele[tempOpenKey] === requestParam[i][tempOpenKey];
                    //                 })
                    //                 if (storeItem) {
                    //                     const requestData = Object.assign(storeItem, requestParam[i]);
                    //                     response = await this.appEntityService.UpdateTemp(tempContext, requestData);
                    //                 } else {
                    //                     response = await this.appEntityService.CreateTemp(tempContext, requestParam[i]);
                    //                 }
                    //                 if (!response || response.status !== 200) {
                    //                     this.$throw(this.$t('app.warn.batcherror'), 'newdata');
                    //                     return;
                    //                 }
                    //             }
                    //         } else {
                    //             // 纯添加
                    //             response = await this.appEntityService.CreateBatchTemp(tempContext, requestParam);
                    //             if (!response || response.status !== 200) {
                    //                 this.$throw(this.$t('app.warn.batcherror'), 'newdata');
                    //                 return;
                    //             }
                    //         }
                    //         if (!xData || !(xData.refresh instanceof Function)) {
                    //             return;
                    //         }
                    //         xData.refresh(result.datas);
                    //     }

                    // } else {
                    const getActiveField: Function = (path: string) => {
                        const activeAppDER = minorPSAppDERSs.find((item: IPSAppDERS) => {
                            return (item.getMajorPSAppDataEntity() as IPSAppDataEntity).modelPath == path;
                        })
                        return activeAppDER?.getParentPSAppDEField();
                    }
                    result.datas.forEach((record: any) => {
                        let tempParam: any = {};
                        if (otherView) {
                            const key = (getActiveField((otherView.getPSAppDataEntity() as IPSAppDataEntity).modelPath))?.codeName;
                            if (key) {
                                tempParam[key] = this.context['srfparentkey'];
                            }
                        }
                        if (getActiveField((openView.getPSAppDataEntity() as IPSAppDataEntity).modelPath)) {
                            tempParam[
                                (getActiveField((openView.getPSAppDataEntity() as IPSAppDataEntity).modelPath))?.codeName.toLowerCase()
                            ] = record.srfkey;
                        } else {
                            tempParam[
                                (ModelTool.getAppEntityKeyField(
                                    openView?.getPSAppDataEntity() as IPSAppDataEntity,
                                ) as IPSAppDEField)?.codeName.toLowerCase()
                            ] = record.srfkey;
                        }
                        requestParam.push(tempParam);
                    });
                    let promises: any;
                    const entityCodeName = (ModelTool.getAppEntityKeyField(
                        openView?.getPSAppDataEntity() as IPSAppDataEntity,
                    ) as IPSAppDEField)?.codeName.toLowerCase();
                    if (requestParam && requestParam.length) {
                        const promiseArr: any[] = [];
                        requestParam.forEach((param: any) => {
                            let _context = Util.deepCopy(this.context);
                            Object.assign(_context, { [entityCodeName]: param[entityCodeName] });
                            if (this.viewparams && Object.keys(this.viewparams).length) {
                                Object.assign(param, this.viewparams);
                            }
                            promiseArr.push(this.appEntityService.execute('Create', _context, param));
                        });
                        promises = Promise.all(promiseArr);
                    }
                    if (promises) {
                        promises.then((response: any) => {
                            if ((!response || response.status !== 200) && !Array.isArray(response)) {
                                this.$throw(this.$t('app.warn.batcherror'), 'newdata');
                                return;
                            } else {
                                this.$success(this.$t('app.commonwords.batchaddsuccess'), 'newdata');
                            }
                            if (!xData || !(xData.refresh instanceof Function)) {
                                return;
                            }
                            xData.refresh(result.datas);
                        }).catch((error: any) => {
                            this.$throw(error && error.data && error.data.message ? error.data.message : this.$t('app.warn.batcherror'));
                        })
                    }
                    // }
                });
            } else if (viewNewAppUIlogic.batchAddOnly) {
                LogUtil.warn(this.$t('app.warn.onlybatchadd'));
            } else if (viewNewAppUIlogic.getNewDataPSAppView()) {
                const _this: any = this;
                const newviewRef: IPSAppUILogicRefView | null = viewNewAppUIlogic.getNewDataPSAppView();
                if (!newviewRef) return;
                const data: any = {};
                if (args[0].srfsourcekey) {
                    data.srfsourcekey = args[0].srfsourcekey;
                }
                if (fullargs && (fullargs as any).copymode) {
                    Object.assign(data, { copymode: (fullargs as any).copymode });
                }
                let tempContext = JSON.parse(JSON.stringify(this.context));
                const dataview: IPSAppView | null = newviewRef.getRefPSAppView();
                if (!dataview) return;
                await dataview.fill(true);
                if (
                    dataview.getPSAppDataEntity() &&
                    tempContext[(dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase()]
                ) {
                    delete tempContext[(dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase()];
                }
                if (args.length > 0) {
                    Object.assign(tempContext, args[0]);
                }
                if (
                    newviewRef.getPSNavigateContexts() &&
                    (newviewRef.getPSNavigateContexts() as IPSNavigateContext[]).length > 0
                ) {
                    const localContext = Util.formatNavParam(newviewRef.getPSNavigateContexts());
                    let _context: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localContext);
                    Object.assign(tempContext, _context);
                }
                if (
                    newviewRef.getPSNavigateParams() &&
                    (newviewRef.getPSNavigateParams() as IPSNavigateParam[]).length > 0
                ) {
                    const localViewParam = Util.formatNavParam(newviewRef.getPSNavigateParams());
                    let _param: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localViewParam);
                    Object.assign(data, _param);
                }
                let deResParameters: any[] = [];
                let parameters: any[] = [];
                if (dataview.getPSAppDataEntity()) {
                    // 处理视图关系参数 （只是路由打开模式才计算）
                    if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB' || dataview.openMode == 'POPUPAPP') {
                        deResParameters = Util.formatAppDERSPath(
                            tempContext,
                            await ModelTool.fillAppDERSPath((dataview as IPSAppDEView)?.getPSAppDERSPaths()),
                        );
                    }
                }
                if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB' || dataview.openMode == 'POPUPAPP') {
                    if (dataview.getPSAppDataEntity()) {
                        parameters = [
                            {
                                pathName: Util.srfpluralize(
                                    (dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                ).toLowerCase(),
                                parameterName: (dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                            },
                            {
                                pathName: 'views',
                                parameterName: ((dataview as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase(),
                            },
                        ];
                    } else {
                        parameters = [{ pathName: 'views', parameterName: dataview?.codeName.toLowerCase() }];
                    }
                } else {
                    if (dataview.getPSAppDataEntity()) {
                        parameters = [
                            {
                                pathName: Util.srfpluralize(
                                    (dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                ).toLowerCase(),
                                parameterName: (dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                            },
                        ];
                    }
                    if (dataview && dataview.modelPath) {
                        Object.assign(tempContext, { viewpath: dataview.modelPath });
                    }
                }
                let view: any = {
                    viewname: 'app-view-shell',
                    height: dataview.height,
                    width: dataview.width,
                    title: this.$tl(dataview.getCapPSLanguageRes()?.lanResTag, dataview.caption),
                };
                // 关闭视图回调
                let callback: Function = (result: any, xData: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    if (!xData || !(xData.refresh instanceof Function)) {
                        return;
                    }
                    xData.refresh(result.datas);
                };
                if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB') {
                    // 打开顶级分页视图
                    const _data: any = { w: new Date().getTime() };
                    Object.assign(_data, data);
                    if (tempContext.srfdynainstid) {
                        Object.assign(_data, { srfdynainstid: tempContext.srfdynainstid });
                    }
                    const routePath = ViewTool.buildUpRoutePath(
                        _this.$route,
                        tempContext,
                        deResParameters,
                        parameters,
                        args,
                        _data,
                    );
                    _this.$router.push(routePath);
                } else if (dataview.openMode == 'POPUPAPP') {
                    // 独立程序打开
                    const routePath = ViewTool.buildUpRoutePath(
                        _this.$route,
                        tempContext,
                        deResParameters,
                        parameters,
                        args,
                        data,
                    );
                    window.open('./#' + routePath, '_blank');
                } else if (dataview.openMode == 'POPUPMODAL') {
                    // 打开模态
                    let container: Subject<any> = _this.$appmodal.openModal(view, tempContext, data);
                    container.subscribe((result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        callback(result, xData);
                    });
                } else if (dataview.openMode.indexOf('DRAWER') !== -1) {
                    // 打开抽屉
                    if (Object.is(dataview.openMode, 'DRAWER_TOP')) {
                        Object.assign(view, { isfullscreen: true });
                        let container: Subject<any> = _this.$appdrawer.openTopDrawer(
                            view,
                            Util.getViewProps(tempContext, data),
                        );
                        container.subscribe((result: any) => {
                            callback(result, xData);
                        });
                    } else {
                        Object.assign(view, { placement: dataview.openMode });
                        let container: Subject<any> = _this.$appdrawer.openDrawer(
                            view,
                            Util.getViewProps(tempContext, data),
                        );
                        container.subscribe((result: any) => {
                            callback(result, xData);
                        });
                    }
                } else if (dataview.openMode == 'POPOVER') {
                    // 打开气泡卡片
                    Object.assign(view, { placement: dataview.openMode });
                    let container: Subject<any> = _this.$apppopover.openPop($event, view, tempContext, data);
                    container.subscribe((result: any) => {
                        callback(result, xData);
                    });
                } else {
                    this.$warning(`${dataview.title}${this.$t('app.nosupport.unopen')}`, 'newdata');
                }
            } else {
                LogUtil.warn(this.$t('app.nosupport.unassign'), 'newdata');
            }
        } else {
            LogUtil.warn(this.$t('app.nosupport.unassign'), 'newdata');
        }
    }

    /**
     * 打开目标视图
     *
     * @param {*} openView 目标视图模型对象
     * @param {*} view 视图对象
     * @param {*} tempContext 临时上下文
     * @param {*} data 数据
     * @param {*} xData 数据部件实例
     * @param {*} $event 事件源
     * @param {*} deResParameters 
     * @param {*} parameters
     * @param {*} args 额外参数
     * @param {Function} callback 回调
     * @memberof ControlContainer
     */
    public openTargtView(
        openView: any,
        view: any,
        tempContext: any,
        data: any,
        xData: any,
        $event: any,
        deResParameters: any,
        parameters: any,
        args: any,
        callback: Function,
    ) {
        const _this: any = this;
        if (!openView?.openMode || openView.openMode == 'INDEXVIEWTAB') {
            if (tempContext.srfdynainstid) {
                Object.assign(data, { srfdynainstid: tempContext.srfdynainstid });
            }
            const routePath = ViewTool.buildUpRoutePath(
                _this.$route,
                tempContext,
                deResParameters,
                parameters,
                args,
                data,
            );
            _this.$router.push(routePath);
        } else if (openView.openMode == 'POPUPAPP') {
            const routePath = ViewTool.buildUpRoutePath(
                _this.$route,
                tempContext,
                deResParameters,
                parameters,
                args,
                data,
            );
            window.open('./#' + routePath, '_blank');
        } else if (openView.openMode == 'POPUPMODAL') {
            // 打开模态
            let container: Subject<any> = _this.$appmodal.openModal(view, tempContext, data);
            container.subscribe((result: any) => {
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                callback(result, xData);
            });
        } else if (openView.openMode.indexOf('DRAWER') !== -1) {
            // 打开抽屉
            if (Object.is(openView.openMode, 'DRAWER_TOP')) {
                Object.assign(view, { isfullscreen: true });
                let container: Subject<any> = _this.$appdrawer.openTopDrawer(
                    view,
                    Util.getViewProps(tempContext, data),
                );
                container.subscribe((result: any) => {
                    callback(result, xData);
                });
            } else {
                Object.assign(view, { placement: openView.openMode });
                let container: Subject<any> = _this.$appdrawer.openDrawer(view, Util.getViewProps(tempContext, data));
                container.subscribe((result: any) => {
                    callback(result, xData);
                });
            }
        } else if (openView.openMode == 'POPOVER') {
            // 打开气泡卡片
            Object.assign(view, { placement: openView.openMode });
            let container: Subject<any> = _this.$apppopover.openPop($event, view, tempContext, data);
            container.subscribe((result: any) => {
                callback(result, xData);
            });
        } else {
            this.$warning(openView.title + this.$t('app.nosupport.unopen'), 'openTargtView');
        }
    }

}