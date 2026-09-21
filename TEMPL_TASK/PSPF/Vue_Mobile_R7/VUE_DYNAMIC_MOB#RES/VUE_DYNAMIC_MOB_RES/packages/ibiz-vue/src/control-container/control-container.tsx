import { IPSAppCounterRef, IPSAppDataEntity, IPSAppDEField, IPSAppDERedirectView, IPSAppDEView, IPSAppUILogicRefView, IPSAppUINewDataLogic, IPSAppUIOpenDataLogic, IPSAppView, IPSAppViewLogic, IPSAppViewNavContext, IPSAppViewNavParam, IPSAppViewRef, IPSControl, IPSControlContainer, IPSDEToolbarItem, IPSNavigateContext, IPSNavigateParam } from "@ibiz/dynamic-model-api";
import { AppCtrlEventEngine, AppPanelEventEngine, AppServiceBase, AppTimerEngine, AppViewEventEngine, DataServiceHelp, LogUtil, ModelTool, Util, ViewTool } from "ibiz-core";
import { CounterService, UIServiceHelp } from "ibiz-core";
import Vue from "vue";
import { AppViewLogicService, ViewOpenService } from "../app-service";

/**
 * 容器对象
 *
 * @export
 * @class ControlContainer
 * @extends {Vue}
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
     * 视图打开服务
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public viewOpenService: any = ViewOpenService.getInstance();

    /**
     * 环境文件
     * 
     * @type {any}
     * @protected
     * @memberof ControlContainer
     */
    protected Environment: any = AppServiceBase.getInstance().getAppEnvironment();

    /**
     * 注册事件逻辑分隔符
     * 
     * @memberof ControlContainer
     */
    public registerEventSeparator: string = 'ibiz__';

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
     * 视图操作参数集合
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public viewCtx: any = {};

    /**
     * 导航数据（用于数据穿透）
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public navdatas!: any;

    /**
     * 实体服务对象
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public appEntityService: any;

    /**
     * 实体UI服务对象
     *
     * @type {*}
     * @memberof ControlContainer
     */
    public appUIService: any;

    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ControlContainer
     */
    public counterServiceArray: Array<any> = [];

    /**
     * 工具栏模型数据
     *
     * @protected
     * @type {boolean}
     * @memberof ControlContainer
     */
    protected toolbarModels: any = {};

    /**
     * 工具栏权限对象
     *
     * @protected
     * @type {boolean}
     * @memberof ControlContainer
     */
    public toolBarAuth: any = {};

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
     * 界面触发逻辑Map
     * 
     * @memberof ControlContainer
     */
    public containerTriggerLogicMap: Map<string, any> = new Map();

    /**
     * 部件UI是否存在权限
     *
     * @type {boolean}
     * @memberof ControlContainer
     */
    public enableControlUIAuth: boolean = true;

    /**
     * 引擎
     *
     * @memberof ControlContainer
     */
    public engine!: any;

    /**
     * 应用实体codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeCodeName() {
        return ModelTool.getContainerAppEntityCodeName(this.containerModel);
    }

    /**
     * 应用实体主键属性codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeKeyFieldName() {
        return (ModelTool.getAppEntityKeyField(this.containerModel?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName || '';
    }

    /**
     * 应用实体主信息属性codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeMajorFieldName() {
        return (ModelTool.getAppEntityMajorField(this.containerModel?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName || '';
    }

    /**
     * 应用实体映射实体名称
     *
     * @readonly
     * @memberof MainViewBase
     */
    get deName() {
        return (this.containerModel?.getPSAppDataEntity() as any)?.getPSDEName() || '';
    }

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
            if (item.controlType == "TOOLBAR" || item.controlType == "SEARCHBAR" || item.controlType == "SEARCHFORM") {
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
    public counterRefresh() {
        if (this.counterServiceArray && this.counterServiceArray.length > 0) {
            this.counterServiceArray.forEach((item: any) => {
                if (item?.service?.refreshData && item.service.refreshData instanceof Function) {
                    item.service.refreshData();
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
                this.containerModel?.getPSAppDataEntity(),
                this.context
            );
            this.appEntityService = await DataServiceHelp.getInstance().getService(this.containerModel?.getPSAppDataEntity(), { context: this.context });
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
     * 处理视图预置事件
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
     * 处理视图自定义事件
     *
     * @memberof ControlContainer
     */
    public handleContainerCustomEvent(name: string, data: any, args: any) {
        if (this.containerTriggerLogicMap.get(name)) {
            this.containerTriggerLogicMap.get(name).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, args: args }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
        }
    }

    /**
     * 处理视图定时器逻辑
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
     * 初始化容器默认工具栏数据
     *
     * @memberof ControlContainer
     */
    public initDefaultToolBar() {
        this.containerModel.getPSControls()?.forEach((item: any) => {
            if (item.controlType == 'TOOLBAR') {
                this.toolBarAuth[item.toolbarStyle] = this.initToolBarItems(item);
                this.toolbarModels[item.toolbarStyle] = item;
            }
        })
    }

    /**
     * 初始化按钮显示&禁用状态
     *
     * @param {*} toolbar
     * @memberof ControlContainer
     */
    public initToolBarItems(toolbar: any) {
        const findItems = (items: IPSDEToolbarItem[]): any => {
            const opt = {
            }
            items.forEach((item: any) => {
                Object.assign(opt, {
                    [item.name]: {
                        disabled: false,
                        visible: true,
                        oneself: item
                    }
                })
                const _items: any = item?.getPSDEToolbarItems?.();
                if (_items) {
                    Object.assign(opt, findItems(_items))
                }

            });
            return opt;
        }
        const items = toolbar.getPSDEToolbarItems() || [];
        return findItems(items);
    }

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
                ref: controlInstance.name,
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
     * 执行挂载部件事件拦截
     *
     * @param {string} eventName 事件名称
     * @param {*} data 数据
     * @memberof ControlContainer
     */
    public exeMountedCtrlEvent(eventName: string, data: any) { }

    /**
     * 部件事件
     * @param ctrl 部件 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof ControlContainer
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (action == 'controlIsMounted') {
            this.setContainerIsMounted(controlname)
        } else {
            if (Object.is(action, 'authlimit')) {
                this.enableControlUIAuth = false;
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
     * 销毁计数器定时器
     *
     * @memberof ControlContainer
     */
    public destroyContainerCounter() {
        if (this.counterServiceArray && this.counterServiceArray.length > 0) {
            this.counterServiceArray.forEach((item: any) => {
                if (item?.service?.destroyCounter && item.service.destroyCounter instanceof Function) {
                    item.service.destroyCounter();
                }
            })
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
     * 绘制目标部件
     * 
     * @memberof ControlContainer
     */
    public renderTargetControl(control: IPSControl, slotMode: boolean = true, args?: any) {
        if (Object.is(control.controlType, 'TOOLBAR')) {
            return (
                <view-toolbar
                    toolbarModel={control}
                    on-item-click={(data: any, $event: any) => {
                        this.handleItemClick(data, $event);
                    }}
                >
                </view-toolbar>
            );
        } else {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(control, args);
            if (Object.is(control.controlType, 'SEARCHFORM') || Object.is(control.controlType, 'SEARCHBAR')) {
                Object.assign(targetCtrlParam.dynamicProps, { isExpandSearchForm: true });
            }
            if (slotMode) {
                return this.$createElement(targetCtrlName, { slot: `layout-${control.name}`, props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            } else {
                return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            }
        }
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
        if (this.Environment?.isPreviewMode) {
            return;
        }
        AppViewLogicService.getInstance().executeViewLogic(`${data?.item?.toolbarName}_${data.tag}_click`, $event, this, undefined, this.containerModel.getPSAppViewLogics());
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
        const openAppViewLogic: IPSAppViewLogic | null = this.containerModel.findPSAppViewLogic("opendata");
        if (!openAppViewLogic || !openAppViewLogic.getPSAppUILogic()) {
            this.$Notice.warning(this.$t('app.warn.editLogicNotExist'));
            return;
        }
        let viewOpenAppUIlogic: IPSAppUIOpenDataLogic | undefined | null = (openAppViewLogic.getPSAppUILogic() as IPSAppUIOpenDataLogic);
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
            if (fullargs && (fullargs.length > 0) && fullargs[0]['srfprocessdefinitionkey'] && fullargs[0]['srftaskdefinitionkey'] && fullargs[0]['srfprocessinstanceid']) {
                Object.assign(data, { 'processDefinitionKey': fullargs[0]['srfprocessdefinitionkey'] });
                Object.assign(data, { 'taskDefinitionKey': fullargs[0]['srftaskdefinitionkey'] });
                Object.assign(data, { 'processinstanceid': fullargs[0]['srfprocessinstanceid'] });
                // 将待办任务标记为已读准备参数
                const that: any = this;
                if (that.quickGroupData && that.quickGroupData.hasOwnProperty("srfwf") && fullargs[0]['srftaskid']) {
                    Object.assign(data, { 'srfwf': that.quickGroupData['srfwf'] });
                    Object.assign(data, { 'srftaskid': fullargs[0]['srftaskid'] });
                }
            }
            let deResParameters: any[] = [];
            let parameters: any[] = [];
            const openView: IPSAppView | null = openViewRef.getRefPSAppView();
            if (!openView) return;
            await openView.fill();
            if (openView.getPSAppDataEntity()) {
                if (!openView.getPSAppDataEntity()?.isFill) {
                    await openView.getPSAppDataEntity()?.fill();
                }
                // 处理视图关系参数 （只是路由打开模式才计算）
                if (!openView.openMode || openView.openMode == 'INDEXVIEWTAB' || openView.openMode == 'POPUPAPP') {
                    deResParameters = Util.formatAppDERSPath(tempContext, (openView as any).getPSAppDERSPaths);
                }
            }
            if (!openView?.openMode || openView.openMode == 'INDEXVIEWTAB') {
                if (openView.getPSAppDataEntity()) {
                    parameters = [
                        { pathName: Util.srfpluralize((openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName).toLowerCase(), parameterName: (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase() },
                        { pathName: "views", parameterName: ((openView as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase() },
                    ];
                } else {
                    parameters = [
                        { pathName: "views", parameterName: openView.name?.toLowerCase() }
                    ];
                }
            } else {
                if (openView?.getPSAppDataEntity()) {
                    parameters = [{ pathName: Util.srfpluralize((openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName)?.toLowerCase(), parameterName: (openView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName?.toLowerCase() }];
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
            }
            // 重定向视图
            if (openView?.redirectView) {
                let targetRedirectView: IPSAppDERedirectView = openView as IPSAppDERedirectView;
                await targetRedirectView.fill();
                if (targetRedirectView.getRedirectPSAppViewRefs() && (targetRedirectView.getRedirectPSAppViewRefs()?.length === 0)) {
                    return;
                }
                this.appUIService.getRDAppView(
                    tempContext,
                    args[0][(ModelTool.getContainerAppEntityCodeName(this.containerModel) as string)?.toLowerCase()],
                    params).then(async (result: any) => {
                        if (!result) {
                            return;
                        }
                        let targetOpenViewRef: IPSAppViewRef | undefined = targetRedirectView.getRedirectPSAppViewRefs()?.find((item: IPSAppViewRef) => {
                            return item.name === result.param.toLocaleUpperCase();
                        })
                        if (!targetOpenViewRef) {
                            return;
                        }
                        if (targetOpenViewRef.getPSNavigateContexts() && (targetOpenViewRef.getPSNavigateContexts() as IPSNavigateContext[]).length > 0) {
                            let localContextRef: any = Util.formatNavParam(targetOpenViewRef.getPSNavigateContexts(), true);
                            let _context: any = Util.computedNavData(fullargs[0], tempContext, data, localContextRef);
                            Object.assign(tempContext, _context);
                        }
                        let targetOpenView: IPSAppView | null = targetOpenViewRef.getRefPSAppView();
                        if (!targetOpenView) {
                            return;
                        }
                        await targetOpenView.fill();
                        const view: any = {
                            viewname: Util.srfFilePath2(targetOpenView.codeName),
                            height: targetOpenView.height,
                            width: targetOpenView.width,
                            title: targetOpenView.title
                        };
                        if (!targetOpenView.openMode || targetOpenView.openMode == 'INDEXVIEWTAB') {
                            if (targetOpenView.getPSAppDataEntity()) {
                                parameters = [
                                    { pathName: Util.srfpluralize((targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName).toLowerCase(), parameterName: (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase() },
                                    { pathName: "views", parameterName: ((targetOpenView as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase() },
                                ];
                            } else {
                                parameters = [
                                    { pathName: targetOpenView.codeName.toLowerCase(), parameterName: targetOpenView.codeName.toLowerCase() }
                                ];
                            }
                        } else {
                            if (targetOpenView.getPSAppDataEntity()) {
                                parameters = [{ pathName: Util.srfpluralize((targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName).toLowerCase(), parameterName: (targetOpenView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase() }];
                            }
                            if (targetRedirectView && targetRedirectView.modelPath) {
                                Object.assign(tempContext, { viewpath: targetRedirectView.modelPath });
                            }
                        }
                        this.openTargtView(targetOpenView, view, tempContext, data, xData, $event, deResParameters, parameters, args, callback);
                    })
            } else {
                if (fullargs && fullargs.copymode) {
                    Object.assign(data, { copymode: true });
                }
                let view: any = {
                    viewname: 'app-view-shell',
                    height: openView.height,
                    width: openView.width,
                    title: openView.title
                };
                this.openTargtView(openView, view, tempContext, data, xData, $event, deResParameters, parameters, args, callback);
            }
        } else {
            // this.$Notice.warning('未指定关系视图');
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
        const newAppViewLogic: IPSAppViewLogic | null = this.containerModel.findPSAppViewLogic("newdata");
        if (!newAppViewLogic || !newAppViewLogic.getPSAppUILogic()) {
            this.$Notice.warning(this.$t('app.warn.newLogicNotExist'));
            return;
        }
        let viewNewAppUIlogic: IPSAppUINewDataLogic | undefined | null = (newAppViewLogic.getPSAppUILogic() as IPSAppUINewDataLogic);
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
                        title: wizardPSAppView.title
                    };
                    const tempContext: any = JSON.parse(JSON.stringify(this.context));
                    if (wizardPSAppView && wizardPSAppView.modelPath) {
                        Object.assign(tempContext, { viewpath: wizardPSAppView.modelPath });
                    }
                    let result: any = await this.viewOpenService.openModal(view, tempContext, args[0]);
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    if (result && result.datas && result.datas.length > 0) {
                        const newDataAppViews: Array<IPSAppUILogicRefView> | null = (viewNewAppUIlogic as IPSAppUINewDataLogic).getNewDataPSAppViews();
                        if (newDataAppViews) {
                            const targetNewDataAppViewRef: IPSAppUILogicRefView | undefined | null = newDataAppViews.find((item: IPSAppUILogicRefView) => {
                                return item.refMode === result.datas[0].srfkey;
                            });
                            if (!targetNewDataAppViewRef) return;
                            Object.assign(tempContext, Util.formatNavParam(targetNewDataAppViewRef.getPSNavigateContexts()));
                            const targetNewDataAppView: IPSAppView | null = targetNewDataAppViewRef.getRefPSAppView();
                            if (!targetNewDataAppView) return;
                            await targetNewDataAppView.fill();
                            const view: any = {
                                viewname: 'app-view-shell',
                                height: targetNewDataAppView.height,
                                width: targetNewDataAppView.width,
                                title: targetNewDataAppView.title
                            };
                            if (targetNewDataAppView && targetNewDataAppView.modelPath) {
                                Object.assign(tempContext, { viewpath: targetNewDataAppView.modelPath });
                            }
                            let result: any = await this.viewOpenService.openModal(view, tempContext, args[0]);
                            if (!result || !Object.is(result.ret, 'OK')) {
                                return;
                            }
                            if (result && result.datas && result.datas.length > 0) {
                                if (!xData || !(xData.refresh instanceof Function)) {
                                    return;
                                }
                                xData.refresh(result.datas);
                            }
                        }
                    }
                }
            } else if (viewNewAppUIlogic.enableBatchAdd) {
                let batchAddPSAppViews: Array<IPSAppUILogicRefView> = [];
                if (viewNewAppUIlogic.getBatchAddPSAppViews() && (viewNewAppUIlogic.getBatchAddPSAppViews() as IPSAppUILogicRefView[]).length > 0) {
                    batchAddPSAppViews = viewNewAppUIlogic.getBatchAddPSAppViews() as IPSAppUILogicRefView[];
                }
                if (batchAddPSAppViews.length == 0 || !this.context.srfparentdename) {
                    this.$Notice.warning(this.$t('app.warn.addNNInBatches'));
                    return;
                }
                let openViewModel: IPSAppUILogicRefView | undefined = batchAddPSAppViews.find((item: IPSAppUILogicRefView) => {
                    return (item.refMode && (item.refMode !== this.context.srfparentdename.toUpperCase()));
                })
                let otherViewModel: IPSAppUILogicRefView | undefined = batchAddPSAppViews.find((item: IPSAppUILogicRefView) => {
                    return (item.refMode && (item.refMode == this.context.srfparentdename.toUpperCase()));
                })
                if (!openViewModel || !otherViewModel) {
                    return;
                }
                let openView: IPSAppDEView = openViewModel.getRefPSAppView() as IPSAppDEView;
                await openView.fill();
                let view: any = {
                    viewname: 'app-view-shell',
                    height: openView.height,
                    width: openView.width,
                    title: openView.title,
                    placement: openView.openMode
                };
                let tempContext: any = Util.deepCopy(this.context)
                if (openView && openView.modelPath) {
                    Object.assign(tempContext, { viewpath: openView.modelPath });
                }
                let result: any = await this.viewOpenService.openModal(view, tempContext, args[0]);
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                if (result.datas && result.datas.length == 0) {
                    return;
                }
                let requestParam: Array<any> = [];
                result.datas.forEach((record: any) => {
                    let tempParam: any = {};
                    tempParam[(ModelTool.getAppEntityKeyField((otherViewModel as IPSAppUILogicRefView).getPSAppDataEntity()) as IPSAppDEField)?.codeName?.toLowerCase()] = this.context['srfparentkey'];
                    tempParam[(ModelTool.getAppEntityKeyField((openViewModel as IPSAppUILogicRefView).getPSAppDataEntity()) as IPSAppDEField)?.codeName?.toLowerCase()] = record.srfkey;
                    requestParam.push(tempParam);
                });
                this.appEntityService.createBatch(JSON.parse(JSON.stringify(this.context)), requestParam, true).then((response: any) => {
                    if (!response || response.status !== 200) {
                        this.$Notice.error(this.$t('app.error.batchError'));
                        return;
                    }
                    if (!xData || !(xData.refresh instanceof Function)) {
                        return;
                    }
                    xData.refresh(result.datas);
                });
            } else if (viewNewAppUIlogic.batchAddOnly) {
                console.warn(this.$t('app.warn.unbatchadd'));
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
                if (args.length > 0) {
                    Object.assign(tempContext, args[0]);
                }
                if (newviewRef.getPSAppViewNavContexts() && (newviewRef.getPSAppViewNavContexts() as IPSAppViewNavContext[]).length > 0) {
                    const localContext = Util.formatNavParam(newviewRef.getPSAppViewNavContexts());
                    let _context: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localContext);
                    Object.assign(tempContext, _context);
                }
                if (newviewRef.getPSAppViewNavParams() && (newviewRef.getPSAppViewNavParams() as IPSAppViewNavParam[]).length > 0) {
                    const localViewParam = Util.formatNavParam(newviewRef.getPSAppViewNavParams());
                    let _param: any = Util.computedNavData(fullargs[0], this.context, this.viewparams, localViewParam);
                    Object.assign(data, _param);
                }
                let deResParameters: any[] = [];
                let parameters: any[] = [];
                const dataview: IPSAppView | null = newviewRef.getRefPSAppView();
                if (!dataview) return;
                await dataview.fill(true);
                if (dataview.getPSAppDataEntity() && tempContext[(dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase()]) {
                    delete tempContext[(dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase()];
                }
                if (dataview.getPSAppDataEntity()) {
                    // 处理视图关系参数 （只是路由打开模式才计算）
                    if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB' || dataview.openMode == 'POPUPAPP') {
                        deResParameters = Util.formatAppDERSPath(tempContext, (dataview.getRefPSAppView() as IPSAppDEView)?.getPSAppDERSPaths());
                    }
                }
                if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB') {
                    if (dataview.getPSAppDataEntity()) {
                        parameters = [
                            { pathName: Util.srfpluralize((dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName).toLowerCase(), parameterName: ((dataview.getPSAppDataEntity() as IPSAppDataEntity))?.codeName.toLowerCase() },
                            { pathName: "views", parameterName: ((dataview as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase() },
                        ];
                    } else {
                        parameters = [
                            { pathName: "views", parameterName: dataview?.codeName.toLowerCase() },
                        ];
                    }
                } else {
                    if (dataview.getPSAppDataEntity()) {
                        parameters = [
                            { pathName: Util.srfpluralize((dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName).toLowerCase(), parameterName: (dataview.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase() },
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
                    title: dataview.title,
                    placement: dataview.openMode
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
                }
                if (!dataview.openMode || dataview.openMode == 'INDEXVIEWTAB') {
                    // 打开顶级分页视图
                    const _data: any = { w: (new Date().getTime()) };
                    Object.assign(_data, data);
                    if (tempContext.srfdynainstid) {
                        Object.assign(_data, { srfdynainstid: tempContext.srfdynainstid });
                    }
                    const routePath = ViewTool.buildUpRoutePath(_this.$route, tempContext, deResParameters, parameters, args, _data);
                    _this.$router.push(routePath);
                } else if (dataview.openMode == 'POPUPAPP') {
                    // 独立程序打开
                    const routePath = ViewTool.buildUpRoutePath(_this.$route, tempContext, deResParameters, parameters, args, data);
                    window.open('./#' + routePath, '_blank');
                } else if (dataview.openMode == 'POPUPMODAL') {
                    // 打开模态
                    let result: any = await _this.viewOpenService.openModal(view, tempContext, data);
                    callback(result, xData);
                } else if (dataview.openMode == 'POPOVER') {
                    // 打开模态
                    let result: any = await _this.viewOpenService.openPopOver(view, tempContext, data);
                    callback(result, xData);
                } else if (dataview.openMode.indexOf('DRAWER') !== -1) {
                    // 打开抽屉
                    let result: any = await _this.viewOpenService.openDrawer(view, tempContext, data);
                    callback(result, xData);
                } else {
                    this.$Notice.warning(`${dataview.title}${this.$t('app.warn.notSupportThisMode')}`);
                }
            }
        } else {
            this.$Notice.warning('未指定关系视图');
        }
    }

    /**
      * 打开目标视图
      *
      * @memberof ControlContainer
      */
    public openTargtView(openView: any, view: any, tempContext: any, data: any, xData: any, $event: any, deResParameters: any, parameters: any, args: any, callback: Function) {
        const _this: any = this;
        if (!openView.openMode || openView.openMode == 'INDEXVIEWTAB') {
            if (tempContext.srfdynainstid) {
                Object.assign(data, { srfdynainstid: tempContext.srfdynainstid });
            }
            const routePath = ViewTool.buildUpRoutePath(_this.$route, tempContext, deResParameters, parameters, args, data);
            _this.$router.push(routePath);
        } else if (openView.openMode == "POPUPAPP") {
            const routePath = ViewTool.buildUpRoutePath(_this.$route, tempContext, deResParameters, parameters, args, data);
            window.open('./#' + routePath, '_blank');
        } else if (openView.openMode == "POPUPMODAL") {
            // 打开模态
            _this.viewOpenService.openModal(view, tempContext, data).then((result: any) => {
                callback(result, xData);
            });
        } else if (openView.openMode == "POPOVER") {
            // 打开模态
            _this.viewOpenService.openPopOver(view, tempContext, data).then((result: any) => {
                callback(result, xData);
            });
        } else if (openView.openMode.indexOf('DRAWER') !== -1) {
            // 打开抽屉
            Object.assign(view, { placement: openView.openMode });
            _this.viewOpenService.openDrawer(view, tempContext, data).then((result: any) => {
                callback(result, xData);
            });
        } else {
            this.$Notice.warning(openView.title + this.$t('app.warn.notSupportThisMode'));
        }
    }

    /**
     * 绘制遮罩
     *
     * @memberof ControlContainer
     */
    public renderShade() {
        const currentViewKey = `${this.containerModel.codeName}`;
        const el: any = currentViewKey ? document.getElementById(currentViewKey) : null;
        if (el) {
            el.setAttribute('class', 'no-authority-shade');
            const shade = document.createElement('div');
            shade.setAttribute('class', 'no-authority-shade-child');
            el.appendChild(shade);
        }
    }


}