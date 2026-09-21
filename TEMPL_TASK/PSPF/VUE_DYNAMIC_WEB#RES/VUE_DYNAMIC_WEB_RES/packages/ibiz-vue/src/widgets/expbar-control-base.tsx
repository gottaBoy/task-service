import { IPSAppDataEntity, IPSAppDEMultiDataView, IPSControlNavigatable, IPSDECalendar, IPSDETBUIActionItem, IPSDEToolbar, IPSDEToolbarItem, IPSDETree, IPSDEUIAction, IPSExpBar, IPSSysImage, IPSLanguageRes, IPSSysMap, IPSDEChart, IPSAppDERedirectView, IPSAppView, IPSNavigateContext, IPSNavigateParam, IPSAppViewRef } from '@ibiz/dynamic-model-api';
import { throttle, ExpBarControlInterface, ModelTool, Util, ViewTool, IParams, StringUtil, AppServiceBase } from 'ibiz-core';
import { Subscription } from 'rxjs';
import { AppGlobalService, AppViewLogicService } from '../app-service';
import { MainControlBase } from './main-control-base';

/**
 * 导航栏部件基类
 *
 * @export
 * @class ExpBarControlBase
 * @extends {MainControlBase}
 */
export class ExpBarControlBase extends MainControlBase implements ExpBarControlInterface {
    /**
     * 导航栏部件模型对象
     *
     * @memberof ExpBarControlBase
     */
    public declare controlInstance: IPSExpBar;

    /**
     * 数据部件
     *
     * @memberof ExpBarControlBase
     */
    protected $xDataControl!: IPSDECalendar | IPSControlNavigatable | IPSDETree | IPSSysMap | IPSDEChart;

    /**
     * 父导航视图模型对象
     *
     * @memberof ExpBarControlBase
     */
    protected parentModel!: IPSAppDEMultiDataView;

    /**
     * 数据部件名称
     *
     * @memberof ExpBarControlBase
     */
    public xDataControlName!: string;

    /**
     * 视图唯一标识
     *
     * @type {boolean}
     * @memberof ExpBarControlBase
     */
    public viewUID: string = '';

    /**
     * 搜素值
     *
     * @type {(string)}
     * @memberof ExpBarControlBase
     */
    public searchText: string = '';

    /**
     * 导航视图名称
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navViewName: any = {};

    /**
     * 导航视图模型
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navViewModel: IPSAppView | null = null;

    /**
     * 导航参数
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navParam: any = {};

    /**
     * 导航上下文参数
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navigateContext: any = {};

    /**
     * 导航视图参数
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navigateParams: any = {};

    /**
     * 导航过滤项
     *
     * @type {string}
     * @memberof ExpBarControlBase
     */
    public navFilter: string = "";

    /**
     * 导航关系
     *
     * @type {string}
     * @memberof ExpBarControlBase
     */
    public navPSDer: string = "";

    /**
     * 选中数据
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public selection: any = {};

    /**
     * 工具栏模型数据
     *
     * @protected
     * @type {*}
     * @memberof ExpBarControlBase
     */
    protected toolbarModels: any;

    /**
     * 缓存UUID
     * (导航部件抛出值时，renderNavView创建视图容器需要UUID来创建一个新的，才能重绘刷新右侧)
     * 
     * 
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public cacheUUID: any;

    /**
     * @description 导航栏部件事件
     * @type {(Subscription | undefined)}
     * @memberof ExpBarControlBase
     */
    public expbarControlEvent: Subscription | undefined;

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ExpBarControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.viewUID = newVal.viewUID;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 部件模型数据初始化实例
     *
     * @memberof ExpBarControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        this.xDataControlName = this.controlInstance.xDataControlName;
        this.$xDataControl = ModelTool.findPSControlByName(this.xDataControlName, this.controlInstance.getPSControls());
        this.showBusyIndicator = this.controlInstance?.showBusyIndicator;
        this.navigateContext = null;
        this.navigateParams = null;
        await this.handleXDataCtrlOptions();
    }

    /**
     * 处理数据部件参数
     *
     * @memberof ExpBarControlBase
     */
    public async handleXDataCtrlOptions() { }

    /**
     * 获取重定向视图模型路径
     *
     * @param {IParams} tempContext
     * @param {IParams} tempViewParams
     * @param {IPSAppDERedirectView} redirectView
     * @memberof ExpBarControlBase
     */
    public async getRedirectViewModelPath(tempContext: IParams, tempViewParams: IParams, redirectView: IPSAppDERedirectView): Promise<any> {
        let localParams: any = {};
        if (tempViewParams && tempViewParams.srfwf) {
            localParams = { srfwf: tempViewParams.srfwf.toLowerCase() };
        }
        const response = await this.getRDAppView(tempContext, localParams, redirectView);
        let targetOpenViewRef: IPSAppViewRef | null = ViewTool.computeRedirectViewRef(
            redirectView,
            localParams,
            response,
        );
        if (!targetOpenViewRef) {
            return;
        }
        //  导航上下文
        if (
            targetOpenViewRef.getPSNavigateContexts() &&
            (targetOpenViewRef.getPSNavigateContexts() as IPSNavigateContext[]).length > 0
        ) {
            let localContextRef: any = Util.formatNavParam(targetOpenViewRef.getPSNavigateContexts(), true);
            let _context: any = Util.computedNavData(response, tempContext, tempViewParams, localContextRef);
            //  填充字符串数据
            if (_context && Object.keys(_context).length > 0) {
                for (const key of Object.keys(_context)) {
                    _context[key] = StringUtil.fillStrData(_context[key], tempContext, response);
                }
            }
            Object.assign(tempContext, _context);
        }
        //  导航视图参数
        if (
            targetOpenViewRef.getPSNavigateParams() &&
            (targetOpenViewRef.getPSNavigateParams() as IPSNavigateParam[]).length > 0
        ) {
            let localViewParamsRef: any = Util.formatNavParam(targetOpenViewRef.getPSNavigateParams(), true);
            let _viewParams: any = Util.computedNavData(response, tempContext, tempViewParams, localViewParamsRef);
            //  填充字符串数据
            if (_viewParams && Object.keys(_viewParams).length > 0) {
                for (const key of Object.keys(_viewParams)) {
                    _viewParams[key] = StringUtil.fillStrData(_viewParams[key], tempContext, response);
                }
            }
            Object.assign(tempViewParams, _viewParams);
        }
        if (targetOpenViewRef.getRefPSAppView()) {
            let targetOpenView: IPSAppView | null = targetOpenViewRef.getRefPSAppView();
            if (!targetOpenView) {
                return;
            }
            await targetOpenView.fill(true);
            if (targetOpenView.modelPath) {
                return { tempContext, tempViewParams, modelPath: targetOpenView.modelPath };
            }
        }
    };

    /**
     * 获取重定向视图
     *
     * @param {IParams} context
     * @param {IParams} viewParams
     * @param {IPSAppDERedirectView} redirectView
     * @return {*} 
     * @memberof ExpBarControlBase
     */
    public async getRDAppView(context: IParams, viewParams: IParams, redirectView: IPSAppDERedirectView) {
        let dataSetParams: any = {};
        if (redirectView.enableCustomGetDataAction) {
            const action = redirectView.getGetDataPSAppDEAction();
            const filed = redirectView.getTypePSAppDEField();
            if (action) {
                Object.assign(dataSetParams, {
                    action: action.codeName,
                });
            }
            if (filed) {
                Object.assign(dataSetParams, {
                    type: filed.codeName.toLowerCase(),
                });
            }
        }
        if (this.appUIService) {
            const response = await this.appUIService.getRDAppView(context, viewParams, {}, dataSetParams);
            return response;
        }
    }

    /**
     * 部件初始化
     *
     * @param {*} [args]
     * @memberof ExpBarControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        this.initCtrlToolBar();
        if (this.viewState) {
            this.expbarControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (this.$xDataControl) {
                    this.viewState.next({ tag: this.xDataControlName, action: action, data: data });
                }
            });
        }
    }

    /**
     * @description 计算导航区工具栏状态
     * @param {boolean} state 状态值
     * @param {*} [data] 选中数据
     * @memberof ExpBarControlBase
     */
    public calcNavigationToolbarState(state: boolean, data?: any) {
        ViewTool.calcToolbarItemState(state, this.toolbarModels);
        ViewTool.calcToolbarItemAuthState(data, this.toolbarModels, this.appUIService);
    }

    /**
     * 初始化工具栏数据
     * 
     * @memberof ExpBarControlBase
     */
    public initCtrlToolBar() {
        let targetViewToolbarItems: any[] = [];
        const toolbar: IPSDEToolbar = ModelTool.findPSControlByType("TOOLBAR", this.controlInstance.getPSControls() || []) as IPSDEToolbar;
        if (toolbar) {
            const toolbarItems: Array<IPSDEToolbarItem> = toolbar.getPSDEToolbarItems() || [];
            toolbarItems.forEach((item: IPSDEToolbarItem) => {
                const img = item.getPSSysImage();
                const css = item.getPSSysCss();
                let itemModel: any = {
                    name: item.name,
                    showCaption: item.showCaption,
                    showIcon: item.showIcon,
                    tooltip: this.$tl((item.getTooltipPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.tooltip),
                    iconcls: (item.getPSSysImage() as IPSSysImage)?.cssClass,
                    icon: (item.getPSSysImage() as IPSSysImage)?.glyph,
                    caption: this.$tl((item.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.caption),
                    disabled: false,
                    itemType: item.itemType,
                    visabled: true,
                    getPSSysImage: img ? { cssClass: img.cssClass, imagePath: img.imagePath } : '',
                };
                if (item.itemType && item.itemType == "DEUIACTION") {
                    const uiAction: IPSDEUIAction = (item as IPSDETBUIActionItem).getPSUIAction() as IPSDEUIAction;
                    Object.assign(itemModel, {
                        actiontarget: (item as IPSDETBUIActionItem).uIActionTarget,
                        noprivdisplaymode: (item as IPSDETBUIActionItem).noPrivDisplayMode,
                        dataaccaction: uiAction?.dataAccessAction,
                        uiaction: {
                            tag: uiAction?.uIActionTag,
                            actionTarget: uiAction?.actionTarget,
                        }
                    });
                }
                targetViewToolbarItems.push(itemModel);
            })
        }
        this.toolbarModels = targetViewToolbarItems;
    }

    /**
     * 初始化导航参数
     * 
     * @param params 初始化参数
     * @memberof ExpBarControlBase
     */
    public initNavParam(params: any) {
        if (params && params.length > 0) {
            let navParams: any = {};
            params.forEach((param: any) => {
                const navParam = {
                    [param.key]: param.rawValue ? param.value : "%" + param.value + "%",
                }
                Object.assign(navParams, navParam);
            });
            return navParams;
        } else {
            return null;
        }
    }

    /**
     * 初始化部件的绘制参数
     *
     * @type {Array<*>}
     * @memberof ViewBase
     */
    public initRenderOptions(opts?: any) {
        this.renderOptions = {};
        const { controlType, codeName } = this.controlInstance;
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            'app-control-expbar': true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        Object.assign(controlClassNames, opts);
        if (this.controlInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(controlClassNames, { [this.controlInstance.getPSSysCss()?.cssName || '']: true });
        }
        const quickGroupSearch = this.$parent.$slots?.['quickGroupSearch'];
        if ((!quickGroupSearch && !this.controlInstance.showTitleBar && !this.controlInstance.enableSearch && !(this.toolbarModels && this.toolbarModels.length))) {
            Object.assign(controlClassNames, { 'app-control-expbar--noheader': true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }

    /**
     * 绘制数据部件
     *
     * @memberof ExpBarControlBase
     */
    public renderXDataControl() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.$xDataControl);
        Object.assign(targetCtrlParam.staticProps, {
            isSelectFirstDefault: true,
            isSingleSelect: true
        });
        return this.$createElement(targetCtrlName, { key: this.xDataControlName, props: targetCtrlParam, ref: this.xDataControlName, on: targetCtrlEvent });
    }

    /**
     * 绘制工具栏
     * 
     * @memberof ExpBarControlBase
     */
    public renderToolbar() {
        return (<view-toolbar slot='toolbar' toolbarModels={this.toolbarModels} counterServiceArray={this.counterServiceArray} on-item-click={(data: any, $event: any) => { throttle(this.handleItemClick, [data, $event], this) }}></view-toolbar>);
    }

    /**
     * 工具栏点击
     * 
     * @param {*} data 事件数据
     * @param {*} $event 事件对象
     * @return {*} 
     * @memberof ExpBarControlBase
     */
    public handleItemClick(data: any, $event: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const toolbar: IPSDEToolbar = ModelTool.findPSControlByType("TOOLBAR", this.controlInstance.getPSControls() || []) as IPSDEToolbar;
            const uiAction = ModelTool.getToolBarUIActionByItemName(toolbar, data.tag);
            const actionParam = { xDataControlName: this.xDataControlName, entityName: this.appDeCodeName.toLowerCase() };
            AppGlobalService.getInstance().executeGlobalUIAction(uiAction, $event, this, actionParam);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(`${this.controlInstance.name?.toLowerCase()}_toolbar_${data.tag}_click`, $event, this, undefined, this.controlInstance.getPSAppViewLogics() || []);
        }
    }

    /**
     * 刷新
     *
     * @memberof ExpBarControlBase
     */
    public refresh(): void {
        if (this.$xDataControl) {
            const xDataControl: any = (this.$refs[`${(this.xDataControlName)?.toLowerCase()}`] as any).ctrl;
            if (xDataControl && xDataControl.refresh && xDataControl.refresh instanceof Function) {
                xDataControl.refresh();
            }
        }
    }

    /**
     * 选中数据事件
     * 
     *
     * @param {any[]} args 选中数据
     * @return {*}  {Promise<void>}
     * @memberof ExpBarControlBase
     */
    public async onSelectionChange(args: any[]): Promise<void> {
        let tempContext: any = {};
        let tempViewParam: any = {};
        if (args.length === 0) {
            this.calcNavigationToolbarState(true);
            return;
        }
        const arg: any = args[0];
        if (this.context) {
            Object.assign(tempContext, Util.deepCopy(this.context));
        }
        if (this.$xDataControl) {
            const appDataEntity: IPSAppDataEntity | null = this.$xDataControl?.getPSAppDataEntity();
            if (appDataEntity) {
                Object.assign(tempContext, { [`${appDataEntity.codeName?.toLowerCase()}`]: arg[appDataEntity.codeName?.toLowerCase()] });
                Object.assign(tempContext, { srfparentdename: appDataEntity.codeName, srfparentdemapname: (appDataEntity as any)?.getPSDEName(), srfparentkey: arg[appDataEntity.codeName?.toLowerCase()] });
                if (this.navFilter && !Object.is(this.navFilter, "")) {
                    Object.assign(tempViewParam, { [this.navFilter]: arg[appDataEntity.codeName?.toLowerCase()] });
                }
                if (this.navPSDer && !Object.is(this.navPSDer, "")) {
                    Object.assign(tempViewParam, { [this.navPSDer]: arg[appDataEntity.codeName?.toLowerCase()] });
                }
            }
            if (this.navigateContext && Object.keys(this.navigateContext).length > 0) {
                let _context: any = this.$util.computedNavData(arg, tempContext, tempViewParam, this.navigateContext);
                Object.assign(tempContext, _context);
            }
            if (this.navigateParams && Object.keys(this.navigateParams).length > 0) {
                let _params: any = this.$util.computedNavData(arg, tempContext, tempViewParam, this.navigateParams);
                Object.assign(tempViewParam, _params);
            }
            if (this.navViewModel) {
                if (Object.is(this.navViewModel.viewType, 'DEREDIRECTVIEW')) {
                    const { modelPath } = await this.getRedirectViewModelPath(tempContext, tempViewParam, this.navViewModel as IPSAppDERedirectView);
                    Object.assign(tempContext, { viewpath: modelPath });
                } else {
                    Object.assign(tempContext, { viewpath: this.navViewModel.modelPath });
                }
            }
            this.handleCtrlEvents('onselectionchange', { action: 'selectionchange', data: args }).then((res: boolean) => {
                if (res) {
                    const params = {
                        data: args,
                        srfnavdata: {
                            context: tempContext,
                            viewparams: tempViewParam
                        }
                    }
                    const key: any = this.$xDataControl?.getPSAppDataEntity()?.codeName.toLowerCase();
                    this.calcNavigationToolbarState(arg && key && arg[key] ? false : true, arg);
                    this.$emit("ctrl-event", { controlname: this.controlInstance.name, action: "selectionchange", data: params });
                }
            })
        } else {
            this.calcNavigationToolbarState(true);
            return;
        }
    }

    /**
     * load完成事件
     * 
     * @param {*} args 加载数据
     * @param {string} [tag]
     * @param {*} [$event2]
     * @memberof ExpBarControlBase
     */
    public onLoad(args: any, tag?: string, $event2?: any) {
        this.calcNavigationToolbarState(true);
        if (this.$xDataControl) {
            this.$emit('ctrl-event', { controlname: this.xDataControlName, action: "load", data: args });
        }
    }

    /**
     * 部件事件
     * @param ctrl 部件 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof ExpBarControlBase
     */
    public onCtrlEvent(controlname: any, action: any, data: any) {
        if (controlname && Object.is(controlname, this.xDataControlName)) {
            switch (action) {
                case "selectionchange":
                    this.onSelectionChange(data);
                    return;
                case "load":
                    this.onLoad(data, action);
                    return;
                case 'beforeload':
                    Object.assign(data, { query: this.searchText });
                    break;
            }
        }
        super.onCtrlEvent(controlname, action, data);
    }

    /**
     * 搜索
     *
     * @param {*} event
     * @memberof ExpBarControlBase
     */
    public onSearch(event: any) {
        if (this.xDataControlName) {
            this.viewState.next({ tag: this.xDataControlName, action: 'load', data: { query: event } });
        }
    }

    /**
     * 渲染头部
     *
     * @return {*} 
     * @memberof ExpBarControlBase
     */
    public renderHeader() {
        const quickGroupSearch = this.$parent.$slots?.['quickGroupSearch'];
        if (!quickGroupSearch && !this.controlInstance.showTitleBar && !this.controlInstance.enableSearch && !(this.toolbarModels && this.toolbarModels.length)) {
            return null;
        }
        const image = this.controlInstance.M.getPSSysImage;
        return (
            <div class="control-header">
                {this.controlInstance.showTitleBar ? <div class="control-header__left">
                    <div class="control-header__left__caption">
                        {image?.imagePath && <img src={image.imagePath} />}
                        {image?.cssClass && <i class={image.cssClass}></i>}
                        <span class="text">{this.$tl(this.controlInstance.getTitlePSLanguageRes()?.lanResTag, this.controlInstance.title)}</span>
                    </div>
                </div> : null}
                <div class="control-header__right">
                    {quickGroupSearch ? <div class="control-header__right__quickgroupsearch"> {quickGroupSearch}</div> : null}
                    {this.controlInstance.enableSearch ?
                        <div class="control-header__right__quicksearch">
                            <app-quick-search v-model={this.searchText} on-search={(event: any) => this.onSearch(event)} appDataEntity={this.controlInstance.getPSAppDataEntity?.()} />
                        </div> : null}
                    <div class="control-header__right__toolbar">
                        {this.renderToolbar()}
                    </div>
                </div>
            </div>
        )
    }

    /**
     * 绘制导航栏主体内容
     * 
     * @memberof ExpBarControlBase
     */
    public renderMainContent() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div
                ref={`${this.appDeCodeName}-${this.controlInstance.codeName?.toLowerCase()}`}
                class={[controlClassNames]}>
                {this.renderHeader()}
                <div class='control-content'>
                    {this.renderXDataControl()}
                </div>
            </div>
        )
    }

    /**
     * @description 部件销毁
     * @memberof ExpBarControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.expbarControlEvent) {
            this.expbarControlEvent.unsubscribe();
        }
    }

}
