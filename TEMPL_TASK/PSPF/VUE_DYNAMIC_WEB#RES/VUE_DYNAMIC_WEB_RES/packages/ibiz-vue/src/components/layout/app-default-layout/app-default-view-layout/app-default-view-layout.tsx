import { IPSControl, IPSDEToolbar, IPSPanelButton, IPSPanelContainer, IPSPanelItem, IPSPanelItemGroupLogic, IPSPanelItemSingleLogic, IPSPanelRawItem, IPSPanelTabPage, IPSPanelTabPanel, IPSSysPanelButton, IPSSysPanelField, IPSViewLayoutPanel } from '@ibiz/dynamic-model-api';
import { appEngineService, AppServiceBase, debounce, dynamicMatch, ModelTool, PanelButtonModel, PanelContainerModel, PanelControlModel, PanelCtrlPosModel, PanelFieldModel, PanelRawitemModel, PanelTabPageModel, PanelTabPanelModel, PanelUserControlModel, PluginService, throttle, Util, Verify } from 'ibiz-core';
import { Subject } from 'rxjs';
import { Prop, Component } from 'vue-property-decorator';
import { AppGlobalService, AppPredefinedService, AppViewLogicService, ContainerLoadingService } from '../../../../app-service';
import { ControlContainer } from '../../../../control-container/control-container';

/**
 * 视图基础布局
 *
 * @export
 * @class AppDefaultViewLayout
 * @extends {Vue}
 */
@Component({})
export class AppDefaultViewLayout extends ControlContainer {

    /**
     * 视图模型数据
     * 
     * @memberof AppDefaultViewLayout
     */
    @Prop() public viewInstance!: any;

    /**
     * 模型服务对象
     * 
     * @memberof AppDefaultViewLayout
     */
    @Prop() public modelService!: any;

    /**
     * 视图模型数据
     * 
     * @memberof AppDefaultViewLayout
     */
    @Prop() public model!: any;

    /**
     * 部件自定义参数（传入对应的部件）
     *
     * @type {*}
     * @memberof AppDefaultViewLayout
     */
    public ctrlCustomParams: any;

    /**
     * 状态传递对象
     *
     * @type {(Subject<any> | undefined)}
     * @memberof AppDefaultViewLayout
     */
    public viewState: Subject<any> | undefined = undefined;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof AppDefaultViewLayout
     */
    public viewtag: string = '';

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof AppDefaultViewLayout
     */
    public viewCodeName: string = '';

    /**
     * 视图布局面板
     * 
     * @memberof AppDefaultViewLayout
     */
    public viewLayoutPanel?: IPSViewLayoutPanel | null;

    /**
     * 视图代理模式（默认为false）
     *
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    public viewProxyMode: boolean = false;

    /**
     * 视图布局模型
     *
     * @type {*}
     * @memberof AppDefaultViewLayout
     */
    public layoutDetailsModel: any = {};

    /**
     * 所有面板项动态逻辑集合
     *
     * @type {any[]}
     * @memberof AppDefaultViewLayout
     */
    public allPanelItemGroupLogic: any[] = [];

    /**
     * 面板数据
     *
     * @type {*}
     * @memberof AppDefaultViewLayout
     */
    public layoutData: any = {};

    /**
     * 是否展示视图工具栏
     * 
     * @memberof AppDefaultViewLayout
     */
    public viewIsshowToolbar: boolean = false;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    public viewIsInit: boolean = false;

    /**
     * 视图默认加载
     *
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    public isLoadDefault: boolean = true;

    /**
     * 绘制参数
     *
     * @readonly
     * @memberof AppDefaultViewLayout
     */
    public renderOptions: any = {
        viewClassNames: {}
    };

    /**
     * 是否显示标题栏
     *
     * @readonly
     * @memberof AppDefaultViewLayout
     */
    get showCaption() {
        if (this.viewInstance && this.$parent) {
            return this.viewInstance.showCaptionBar && !(this.$parent as any).noViewCaption
        } else {
            return true;
        }
    }

    /**
     * 视图默认使用(路由：true,非路由：false)
     *
     * @readonly
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    get viewDefaultUsage(): boolean {
        if (this.$parent) {
            return (this.$parent as any).viewDefaultUsage;
        }
        return true;
    }

    /**
     * 初始化视图的绘制参数
     *
     * @memberof AppDefaultViewLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'view-container': true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`view-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`view-style-default`]: true });
        }
        if (codeName) {
            Object.assign(viewClassNames, { [Util.srfFilePath2(codeName)]: true });
        }
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [this.viewInstance.getPSSysCss()?.cssName]: true });
        }
        if (this.viewProxyMode) {
            Object.assign(viewClassNames, { 'isproxy': true });
        }
        if (!this.showCaption) {
            Object.assign(viewClassNames, { 'nocaption': true });
        }
        if (!this.viewIsshowToolbar) {
            Object.assign(viewClassNames, { 'notoolbar': true });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * Vue生命周期，实例创建完成
     *
     * @memberof AppDefaultViewLayout
     */
    public created() {
        this.initViewSpecificData();
        this.initViewLayOutContainer();
    }

    /**
     * Vue生命周期，实例销毁完成
     *
     * @memberof AppDefaultViewLayout
     */
    public destroyed() {
        if (this.viewProxyMode) {
            this.handleContainerPreEvent('onViewDestroyed').then((result: boolean) => {
                if (!result) {
                    return;
                }
                const parentRef: any = this.$parent;
                if (parentRef.viewDefaultUsage) {
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
        this.containerDestroyed();
        this.destroyUIContainer();
    }

    /**
     * 初始化视图特有参数
     *
     * @memberof AppDefaultViewLayout
     */
    public initViewSpecificData() { }

    /**
     * 初始化面板容器
     *
     * @memberof AppDefaultViewLayout
     */
    public async initViewLayOutContainer() {
        this.viewLayoutPanel = this.viewInstance?.getPSViewLayoutPanel();
        if (this.viewLayoutPanel && this.viewLayoutPanel.viewProxyMode) {
            this.viewProxyMode = this.viewLayoutPanel.viewProxyMode;
        }
        // 初始化容器
        this.initUIContainerModel('VIEWLAYOUT', this.viewLayoutPanel);
        // 初始化基础数据
        if (this.viewProxyMode) {
            const parentRef: any = this.$parent;
            this.isLoadDefault = parentRef.isLoadDefault;
            this.viewState = parentRef.viewState;
            this.viewtag = parentRef.viewtag;
            this.viewCodeName = parentRef.viewCodeName;
            this.opendata = this.opendata.bind(this);
            this.newdata = this.newdata.bind(this);
            this.engine = appEngineService.getEngine(this.viewInstance.viewType);
        }
        await this.initUIContainerBeforeCtx();
        this.initViewLayoutCtx();
        await this.initUIContainerAfterCtx();
        await this.initViewLayOut();
        // 初始化视图容器样式
        if (this.viewInstance) {
            this.initRenderOptions();
        }
        if (this.viewProxyMode) {
            setTimeout(() => {
                this.setContainerIsMounted();
            }, 0);
        }
    }

    /**
     * 容器挂载完成(重写)
     *
     * @memberof AppDefaultViewLayout
     */
    public containerMounted() {
        if (this.viewProxyMode) {
            const _this: any = this;
            super.containerMounted();
            this.$emit('view-event', { viewname: this.viewInstance.name, action: 'viewIsMounted', data: true })
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
            })
        }
    }

    /**
     * 执行挂载部件事件拦截（重写）
     *
     * @param {string} eventName 事件名称
     * @param {*} data 数据
     * @memberof AppDefaultViewLayout
     */
    public exeMountedCtrlEvent(eventName: string, data: any) {
        // 识别导航区占位
        if (eventName && Object.is(eventName, 'selectionchange') && data && data.srfnavdata) {
            const navPos: any = Object.values(this.layoutDetailsModel).find((item: any) => {
                return item.panelItemModel.M?.getPSRawItem?.predefinedType === "NAV_POS" || item.panelItemModel.M?.getPSRawItem?.predefinedType === "NAV_POS_INDEX";
            })
            if (navPos && navPos.setNavData instanceof Function) {
                navPos.setNavData(data.srfnavdata);
                this.$forceUpdate();
            }
        }
    }

    /**
     * 计算目标部件所需参数(重写)
     *
     * @memberof AppDefaultViewLayout
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, {
            viewState: this.viewState,
            viewtag: this.viewtag,
            viewIsProxyMode: this.viewProxyMode,
            layoutLoadingService: this.layoutLoadingService
        });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
            }
        })
        const curCtrlCustomParams = this.ctrlCustomParams[controlInstance.name];
        if (curCtrlCustomParams && Object.keys(curCtrlCustomParams).length > 0) {
            if (curCtrlCustomParams.dynamicProps) {
                Object.assign(targetCtrlParam.dynamicProps, curCtrlCustomParams.dynamicProps);
            }
            if (curCtrlCustomParams.staticProps) {
                Object.assign(targetCtrlParam.staticProps, curCtrlCustomParams.staticProps);
            }

        }
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 初始化视图面板应用上下文、视图参数和ctx
     *
     * @memberof AppDefaultViewLayout
     */
    public initViewLayoutCtx() {
        const parentRef: any = this.$parent;
        // 处理应用上下文
        this.context = parentRef?.context ? parentRef.context : {};
        // 处理视图参数
        this.viewparams = parentRef?.viewparams ? parentRef.viewparams : {};
        // 处理部件自定义参数（传入对应的部件）
        this.ctrlCustomParams = parentRef?.ctrlCustomParams ? parentRef.ctrlCustomParams : {};
        if (this.viewProxyMode) {
            // 处理ctx
            const tempViewCtx = parentRef?.viewCtx ? parentRef?.viewCtx : {};
            tempViewCtx['view'] = this;
            // 顶层路由视图
            if (parentRef.viewDefaultUsage) {
                if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                    AppServiceBase.getInstance().getAppStore().commit('addView', { tag: this.context.srfsessionid, param: this });
                }
                tempViewCtx['topview'] = this;
            }
            // 处理父级视图
            if (this.viewInstance && this.viewInstance.modelPath) {
                if (AppServiceBase.getInstance() && AppServiceBase.getInstance().getAppStore()) {
                    AppServiceBase.getInstance().getAppStore().commit('addView', { tag: this.viewInstance.modelPath, param: this });
                }
            }
            this.viewCtx = tempViewCtx;
        }
    }

    /**
     * 初始化视图布局
     *
     * @memberof AppDefaultViewLayout
     */
    public async initViewLayOut() {
        const viewToolBar: IPSDEToolbar = ModelTool.findPSControlByType("TOOLBAR", this.viewInstance?.getPSControls());
        if (viewToolBar && viewToolBar.getPSDEToolbarItems()) {
            this.viewIsshowToolbar = true;
        } else {
            // 工作流视图默认显示工具栏
            if(this.viewInstance && this.viewInstance.viewType == 'DEWFDYNAEDITVIEW' || this.viewInstance.viewType == 'DEWFDYNAEDITVIEW3'){
                this.viewIsshowToolbar = true;
            }else{
                this.viewIsshowToolbar = false;
            }
        }
        if (this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout) {
            await this.initDetailsModel(null, this.viewLayoutPanel?.getRootPSPanelItems());
            this.viewIsInit = true;
        } else {
            this.viewIsInit = true;
        }
    }

    /**
     * 初始化面板集合
     *
     * @param {*} parentItem 父容器
     * @param {(IPSPanelItem[] | undefined | null)} [panelItems] 面板项集合
     * @param {number} [_index=0] 下标
     * @param {boolean} [hasMulParent=false] 是否存在多数据容器父成员
     * @memberof AppDefaultViewLayout
     */
    public async initDetailsModel(parentItem: any, panelItems?: IPSPanelItem[] | undefined | null, dataIndex: number = 0, hasMulParent: boolean = false) {
        if (panelItems && panelItems.length > 0) {
            //  父面板成员为多项数据容器时，构建多份子面板成员
            this.allPanelItemGroupLogic = [];
            if (parentItem && parentItem.dataRegionType === 'MULTIDATA' && parentItem.getData()?.length > 0) {
                for (let index = 0; index <= parentItem.getData().length - 1; index++) {
                    await this.initDetailsModelItem(parentItem, panelItems, index, true);
                }
            } else {
                await this.initDetailsModelItem(parentItem, panelItems, dataIndex, hasMulParent);
            }
        }
        this.panelLogic('');
    }

    /**
     * 初始化面板项成员 
     *
     * @param {*} parentItem 父面板项成员
     * @param {any[]} [panelItems=[]] 面板项集合
     * @param {number} [index=0] 标识
     * @param {boolean} [hasMulParent=false] 是否存在多容器父面板项
     * @memberof AppDefaultViewLayout
     */
    public async initDetailsModelItem(parentItem: any, panelItems: any[] = [], index: number = 0, hasMulParent: boolean = false) {
        for (let i = 0; i < panelItems.length; i++) {
            const panelItem: IPSPanelItem = panelItems[i];
            if (panelItem.getPSPanelItemGroupLogics()) {
                this.allPanelItemGroupLogic.push(panelItem.getPSPanelItemGroupLogics());
            }
            let detailModel: any = {
                context: Util.deepCopy(this.context),
                viewparams: Util.deepCopy(this.viewparams),
                panel: this,
                disabled: false,
                name: panelItem.name,
                caption: panelItem.caption,
                itemType: panelItem.itemType,
                visible: true,
                model: panelItem,
                parentItem: parentItem,
                $index: index,
                hasMulParent: hasMulParent
            };
            let panelItemModel: any;
            switch (panelItem.itemType) {
                case 'BUTTON':
                    const panelButtomItem = panelItem as IPSSysPanelButton
                    Object.assign(detailModel, {
                        uiaction: {
                            type: panelButtomItem.getPSUIAction()?.uIActionType,
                            tag: panelButtomItem.getPSUIAction()?.uIActionTag,
                            actiontarget: panelButtomItem.getPSUIAction()?.actionTarget,
                            noprivdisplaymode: panelButtomItem.getPSUIAction()?.uIActionMode,
                            dataaccaction: panelButtomItem.getPSUIAction()?.dataAccessAction,
                            visible: true,
                            disabled: false
                        }
                    });
                    panelItemModel = new PanelButtonModel(detailModel);
                    break;
                case 'TABPANEL':
                    const tabPages: IPSPanelTabPage[] = (panelItem as IPSPanelTabPanel).getPSPanelTabPages() || [];
                    const pageNames: any[] = [];
                    if (tabPages.length > 0) {
                        tabPages.forEach((page: IPSPanelTabPage) => {
                            pageNames.push({ name: page.name });
                        })
                    }
                    Object.assign(detailModel, {
                        tabPages: pageNames
                    });
                    panelItemModel = new PanelTabPanelModel(detailModel);
                    break;
                case 'TABPAGE':
                    panelItemModel = new PanelTabPageModel(detailModel);
                    break;
                case 'CONTAINER':
                    const dataRegionType = (panelItem as IPSPanelContainer).dataRegionType;
                    if (dataRegionType === 'MULTIDATA' || dataRegionType === 'SINGLEDATA') {
                        new ContainerLoadingService(hasMulParent ? `${panelItem.name}_${index}` : panelItem.name, this.layoutLoadingService);
                    }
                    panelItemModel = new PanelContainerModel(detailModel);
                    break;
                case 'FIELD':
                    panelItemModel = new PanelFieldModel(detailModel);
                    break;
                case 'RAWITEM':
                    panelItemModel = new PanelRawitemModel(detailModel);
                    break;
                case 'CONTROL':
                    panelItemModel = new PanelControlModel(detailModel);
                    break;
                case 'CTRLPOS':
                    panelItemModel = new PanelCtrlPosModel(detailModel);
                    break;
                case 'USERCONTROL':
                    panelItemModel = new PanelUserControlModel(detailModel);
                    break;
            }
            await panelItemModel.loaded();
            // 设置面板模型 （父成员存在多数据容器时拼接下标）
            if (hasMulParent) {
                this.$set(this.layoutDetailsModel, `${panelItem.name}_${index}`, panelItemModel);
            } else {
                this.$set(this.layoutDetailsModel, panelItem.name, panelItemModel);
            }
            // 设置面板数据 （父成员存在多数据容器时拼接下标）
            if (hasMulParent) {
                this.$set(this.layoutData, `${panelItem.name}_${index}`, this.layoutDetailsModel[`${panelItem.name}_${index}`].getData());
            } else {
                this.$set(this.layoutData, panelItem.name, this.layoutDetailsModel[panelItem.name].getData());
            }
            if ((panelItem as any).getPSPanelItems?.()?.length > 0) {
                await this.initDetailsModel(panelItemModel, (panelItem as any)?.getPSPanelItems?.(), index, hasMulParent);
            }
            if ((panelItem as any).getPSPanelTabPages?.()?.length > 0) {
                await this.initDetailsModel(panelItemModel, (panelItem as any)?.getPSPanelTabPages?.(), index, hasMulParent);
            }
        }
    }

    /**
     * 面板逻辑
     *
     * @param {string} name
     * @memberof AppDefaultViewLayout
     */
    public panelLogic(name: string): void {
        const allPanelItemGroupLogic = this.allPanelItemGroupLogic;
        if (allPanelItemGroupLogic.length > 0) {
            allPanelItemGroupLogic.forEach((panelItemGroupLogics: any) => {
                panelItemGroupLogics.forEach((logic: any) => {
                    let relatedNames = logic.getRelatedItemNames() || [];
                    if (Object.is(name, '') || relatedNames.indexOf(name) != -1) {
                        let ret = this.verifyGroupLogic(this.layoutData, logic);
                        switch (logic.logicCat) {
                            // 动态空输入，不满足则必填
                            case 'ITEMBLANK':
                                this.layoutDetailsModel[logic.parentModel.name].required = !ret;
                                break;
                            // 动态启用，满足则启用
                            case 'ITEMENABLE':
                                this.layoutDetailsModel[logic.parentModel.name].disabled = !ret;
                                break;
                            // 动态显示，满足则显示
                            case 'PANELVISIBLE':
                                this.layoutDetailsModel[logic.parentModel.name].visible = ret;
                                break;
                        }
                    }
                })
            })
        }
    }

    /**
     * 校验动态逻辑结果
     *
     * @param {*} data 数据对象
     * @param {*} logic 逻辑对象
     * @returns
     * @memberof PanelControlBase
     */
    public verifyGroupLogic(data: any, logic: any) {
        if (logic.logicType == 'GROUP' && (logic?.getPSPanelItemLogics() as any)?.length > 0) {
            const _logic = logic as IPSPanelItemGroupLogic
            let result: boolean = true;
            if (_logic.groupOP == 'AND') {
                let falseItem: any = _logic?.getPSPanelItemLogics()?.find((childLogic: any) => {
                    return !this.verifyGroupLogic(data, childLogic);
                })
                result = falseItem == undefined;
            } else if (_logic.groupOP == 'OR') {
                let trueItem: any = _logic?.getPSPanelItemLogics()?.find((childLogic: any) => {
                    return this.verifyGroupLogic(data, childLogic);
                })
                result = trueItem != undefined;
            }
            // 是否取反
            return logic.notMode ? !result : result;
        } else if (logic.logicType == 'SINGLE') {
            const _logic = logic as IPSPanelItemSingleLogic;
            let value = _logic.value;
            // 动态匹配${}
            const regex = /\${(.*?)}/g;
            if (value && regex.test(value)) {
                value = dynamicMatch(value,{
                    context: this.context ? this.context: {},
                    viewParams: this.viewparams? this.viewparams : {},
                    data
                });
            }
            return Verify.testCond(data[_logic.dstModelField.toLowerCase()], _logic.condOp, value)
        }
        return false;
    }

    /**
     * @description 切换容器展开状态
     * @param {PanelContainerModel} container 容器类对象
     * @memberof AppDefaultViewLayout
     */
    public switchExtendState(container: PanelContainerModel) {
        if (container.titleBarClose) {
            container.extendState = !container.extendState;
        }
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewHeader(): any {
        return [
            <div class="view-header__left">
                {this.showCaption ? <div class="view-header__left__caption">{this.renderViewCaption()}</div> : null}
            </div>,
            this.viewIsshowToolbar && this.$slots.toolbar ? <div class="view-header__right">
                <div class="view-header__right__toolbar">{this.$slots.toolbar}</div>
            </div> : null
        ]
    }

    /**
     * 绘制正文内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewContent(): any {
        return [
            this.$slots.topMessage ? <div class="view-content__top">
                {this.$slots.topMessage}
            </div> : null,
            <div class="view-content__body">
                {this.$slots.bodyMessage}
                {this.$slots.default}
            </div>,
            this.$slots.bottomMessage ? <div class="view-content__bottom">
                {this.$slots.bottomMessage}
            </div> : null
        ]
    }

    /**
     * 绘制底部内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewFooter(): any {
        return this.$slots.footer;
    }

    /**
     * 绘制文本绘制模式
     * @param renderMode 文本绘制模式
     * @return {*}  {*}
     * @memberof AppDefaultViewLayout
     */
    public renderViewCaption(renderMode?: any): any {
        const content = this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout ?
            [this.renderCaptionBar(), this.renderDataInfoBar()] :
            [
                this.$slots['layout-captionbar'] ? this.$slots['layout-captionbar'] : this.model?.srfCaption,
                this.$slots['layout-datainfobar'] ? this.$slots['layout-datainfobar'] : this.model.dataInfo ? [<span class="view__caption__separate">-</span>, this.model.dataInfo] : null
            ];
        switch (renderMode) {
            case 'TEXT':
                return <span class="view__caption__info">{content}</span>
            case 'HEADING1':
            case 'HEADING2':
            case 'HEADING3':
            case 'HEADING4':
            case 'HEADING5':
            case 'HEADING6':
                return this.$createElement(`h${renderMode.charAt(renderMode.length - 1)}`,
                    {},
                    content
                );
            case 'PARAGRAPH':
                return <p class="view__caption__info">{content}</p>
            default:
                return <div class="view__caption__info">{content}</div>
        }
    }

    /**
     * 绘制标题栏
     *
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderCaptionBar() {
        const captionBar: any = ModelTool.findPSControlByName('captionbar', this.containerModel.getPSControls());
        if (this.viewInstance.showCaptionBar && captionBar) {
            return (
                <app-default-captionbar
                    viewModelData={this.viewInstance}
                    modelData={captionBar}
                    context={this.context}
                    viewparam={this.viewparams}
                ></app-default-captionbar>
            );
        } else {
            return this.model?.srfCaption;
        }
    }

    /**
     * 绘制信息栏
     *
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderDataInfoBar() {
        const datainfoBar: any = ModelTool.findPSControlByName('datainfobar', this.containerModel.getPSControls());
        if (datainfoBar) {
            return [
                <span class="view__caption__separate">-</span>,
                <app-default-datainfobar
                    modelData={datainfoBar}
                    viewInfo={this.model}
                    context={this.context}
                    viewparam={this.viewparams}
                ></app-default-datainfobar>
            ]
        } else {
            return this.model.dataInfo ? [<span class="view__caption__separate">-</span>, this.model.dataInfo] : null
        }
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderContent() {
        return [
            (this.showCaption || (this.viewIsshowToolbar && this.$slots.toolbar) || this.$slots.quickSearch) && (
                <div class='view-header'>
                    {this.renderViewHeader()}
                </div>
            ),
            <div class='view-content'>
                {this.renderViewContent()}
            </div>,
            this.$slots.footer && (
                <div class="view-footer">
                    {this.renderViewFooter()}
                </div>
            )
        ]
    }

    /**
     * 绘制布局
     * 
     * @memberof AppDefaultViewLayout
     */
    public render(h: any) {
        const { viewClassNames } = this.renderOptions;
        return (
            <div class={viewClassNames}>
                <app-studioaction
                    viewInstance={this.viewInstance}
                    context={this.context}
                    viewparams={this.viewparams}
                    viewName={this.viewInstance.codeName.toLowerCase()}
                    viewTitle={this.model?.srfCaption} />
                {this.viewIsInit ? (this.viewLayoutPanel && this.viewLayoutPanel.useDefaultLayout) ? this.renderContent() : this.renderViewLayoutPanel() : this.renderInitLoading()}
            </div>
        );
    }

    /**
     * 渲染初始化loading效果
     *
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderInitLoading() {
        return <app-loading></app-loading>
    }

    /**
     * 绘制视图布局面板
     *
     * @memberof AppDefaultViewLayout
     */
    public renderViewLayoutPanel() {
        if(this.viewProxyMode){
            return this.renderRootPSPanelItems();
        }else{
            if ((this.viewLayoutPanel as any)?.layoutBodyOnly) {
                return this.renderLayouBodyOnly();
            } else {
                return this.renderRootPSPanelItems();
            }
        }
    }

    /**
     * 绘制顶级面板成员集合
     *
     * @memberof AppDefaultViewLayout
     */
    public renderRootPSPanelItems() {
        let rootStyle = { height: '100%', width: '100%' };
        let layoutMode = this.viewLayoutPanel?.getPSLayout()?.layout;
        if (layoutMode && layoutMode == 'FLEX') {
            Object.assign(rootStyle, { 'display': 'flex', 'flex-direction': 'column' });
        } else {
            Object.assign(rootStyle, { overflow: 'auto' });
        }
        const cssNames = { 'app-view-layout': true };
        if (this.viewLayoutPanel && this.viewLayoutPanel.getPSSysCss()) {
            Object.assign(cssNames, {
                [this.viewLayoutPanel.getPSSysCss()?.cssName as string]: true
            })
        }
        return <div class={cssNames} style={rootStyle}>
            {this.viewLayoutPanel?.getRootPSPanelItems()?.map((panelItem: any) => {
                return this.renderByDetailType(panelItem);
            })}
        </div>
    }

    /**
    * 仅布局内容区模式绘制
    *
    * @memberof AppDefaultViewLayout
    */
    public renderLayouBodyOnly() {
        return [
            (this.showCaption || (this.viewIsshowToolbar && this.$slots.toolbar) || this.$slots.quickSearch) && (
                <div class='view-header'>
                    {this.renderViewHeader()}
                </div>
            ),
            <div class='view-content'>
                {this.$slots.topMessage ? <div class="view-content__top">
                    {this.$slots.topMessage}
                </div> : null}
                <div class="view-content__body">
                    {this.$slots.bodyMessage}
                    {this.renderRootPSPanelItems()}
                </div>
                {this.$slots.bottomMessage ? <div class="view-content__bottom">
                    {this.$slots.bottomMessage}
                </div> : null}
            </div>
        ];
    }

    /**
     * 根据detailType绘制对应detail
     *
     * @param {*} modelJson
     * @memberof AppDefaultViewLayout
     */
    public renderByDetailType(modelJson: any, parent?: any, index?: number) {
        if (modelJson.getPSSysPFPlugin()) {
            const pluginInstance: any = PluginService.getInstance().getPluginInstance("CONTROLITEM", modelJson.getPSSysPFPlugin().pluginCode);
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, modelJson, this, this.context);
            }
        }
        switch (modelJson.itemType) {
            case 'CONTAINER':
                return this.renderContainer(modelJson, parent, index);
            case 'TABPANEL':
                return this.renderTabPanel(modelJson, parent, index);
            case 'TABPAGE':
                return this.renderTabPage(modelJson, index);
            case 'FIELD':
                return this.renderField(modelJson, index);
            case 'RAWITEM':
                return this.renderRawItem(modelJson, index);
            case 'BUTTON':
                return this.renderButton(modelJson, index);
            case 'CTRLPOS':
                return this.renderCtrlPos(modelJson, parent, index);
            case 'USERCONTROL':
                return this.renderUserControl(modelJson, parent, index);
            default:
                return <span>{`${modelJson.itemType} 类型未支持`}</span>
        }
    }

    /**
     * 绘制面板Container
     *
     * @memberof AppDefaultViewLayout
     */
    public renderContainer(container: IPSPanelContainer, parent?: any, index?: number) {
        const panelItems: IPSPanelItem[] = container.getPSPanelItems() || [];
        let name: string = `${container.name}${index === undefined || index === null ? '' : '_' + index}`;
        //  父容器为多数据容器
        let hasMulParent: boolean = false;
        if (index !== undefined || index !== null) {
            hasMulParent = true;
        }
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const layout = container.getPSLayout()?.layout;
        // 盒子自身应有样式
        const detailStyle = {};
        // 获取布局设置(约束子,如：flex布局及相关设置)
        const boxLayoutStyle = this.layoutDetailsModel[name].getBoxLayoutStyle();
        Object.assign(detailStyle, boxLayoutStyle);
        // 获取盒子宽高/间隔模式
        const boxStyle = this.layoutDetailsModel[name].getBoxStyle();
        Object.assign(detailStyle, boxStyle);
        // 获取盒子样式表
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        // 合并盒子动态样式表
        if (container.dynaClass) {
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.layoutData[name];
            detailClass.push(...eval(container.dynaClass))
        }
        if (layout && Object.is(layout, 'BORDER')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <div style={detailStyle} class={[detailClass, "app-view-layout__container", "layout-container__border"]} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }}>
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        // this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                        //     return <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container>;
                        // })
                        <div>多数据容器下不能嵌入边缘布局容器</div> : hasMulParent ?
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container> :
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems)}</app-scroll-container>}
                </div>
            )
        } else if (layout && Object.is(layout, 'FLEX')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <div style={container.showCaption ? '' : detailStyle} class={[detailClass, "app-view-layout__container", "layout-container__flex"]} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }} >
                    {container.showCaption ? <row class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__caption': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState }} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    {
                        container.showCaption ?
                            <div style={{ ...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none' }} class="layout__content">
                                {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                    this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                        return this.renderChildItems(container, panelItems, index);
                                    }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)}
                            </div> :
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return this.renderChildItems(container, panelItems, index);
                                }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                    }
                </div>
            );
        } else if (layout && Object.is(layout, 'SIMPLEFLEX')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <div style={container.showCaption ? '' : detailStyle} class={[detailClass, "app-view-layout__container", "layout-container__simpleflex"]} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }} >
                    {container.showCaption ? <row class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__caption': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState }} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    {
                        container.showCaption ?
                            <div style={{ ...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none' }} class="app-view-layout__container__content">
                                {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                    this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                        return <app-simpleflex-container inMulParent={true} panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>;
                                    }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                                }
                            </div> :
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return <app-simpleflex-container inMulParent={true} panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                                }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                    }
                </div>
            );
        } else {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <row style={detailStyle} class={[detailClass, "app-view-layout__container", "layout-container__standard"]} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }}>
                    {container.showCaption ? <row class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__caption': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState }} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    <div style={{ ...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none' }} class="app-view-layout__container__content">
                        {
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return this.renderChildItems(container, panelItems, index);
                                }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                        }
                    </div>
                </row>
            );
        }
    }

    /**
     * 渲染子项
     *
     * @param {IPSPanelContainer} parent 父容器模型
     * @param {IPSPanelItem[]} panelItems 父容器下所有子项
     * @param {number} [index] 多数据域下标
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderChildItems(parent: IPSPanelContainer, panelItems: IPSPanelItem[], index?: number) {
        if (!parent || !panelItems || (panelItems.length === 0)) {
            return null;
        }
        const layout = parent.getPSLayout()?.layout;
        return panelItems.map((item: any) => {
            const name = `${item.name}${index === undefined || index === null ? '' : '_' + index}`;
            const childDetailStyle: any = {};
            if (Object.is(layout, 'BORDER')) {
                Object.assign(childDetailStyle, this.layoutDetailsModel[name]?.getBorderLayoutStyle());
            } else {
                Object.assign(childDetailStyle, this.layoutDetailsModel[name]?.getBoxLayoutPosStyle());
            }
            // 多数据容器下多数据部件只绘制一个
            if (this.layoutDetailsModel[name]?.isEnableMount === false) {
                return null;
            }
            // 隐藏属性项不绘制
            if (Object.is(item.itemType, 'FIELD') && (item as IPSSysPanelField).hidden) {
                return null;
            }
            if (Object.is(layout, 'BORDER')) {
                return (
                    <div style={childDetailStyle} slot={item.name} class={'container-item__pos container-item__border'}>
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'FLEX')) {
                return (
                    <div style={childDetailStyle} class={'container-item__pos container-item__flex'} >
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'TABLE_12COL') || Object.is(layout, 'TABLE_24COL')) {
                const attrs = this.layoutDetailsModel[name]?.getGridLayoutProps(item, layout);
                return (
                    <i-col {...{ props: attrs }} style={childDetailStyle} class={'container-item__pos'}>
                        {this.renderByDetailType(item, parent, index)}
                    </i-col>
                );
            }
        })
    }

    /**
     * 绘制面板TabPanel
     *
     * @memberof AppDefaultViewLayout
     */
    public renderTabPanel(modelJson: IPSPanelTabPanel, parent?: any, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const tabPages: IPSPanelTabPage[] = modelJson.getPSPanelTabPages() || [];
        const activedTabPage: any = this.layoutDetailsModel[name]?.activatedPage;
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        return (
            <el-tabs
                value={activedTabPage}
                class={detailClass}
                style={parent ? {} : detailStyle}
                on-tab-click={(event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) }}
            >
                {tabPages.length > 0 ?
                    tabPages.map((item: IPSPanelTabPage) => {
                        return this.renderTabPage(item, index);
                    }) : null}
            </el-tabs>
        );
    }

    /**
     * 绘制面板TabPage
     *
     * @memberof AppDefaultViewLayout
     */

    public renderTabPage(modelJson: IPSPanelTabPage, index?: number) {
        let name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        let label = this.$tl(modelJson.getCapPSLanguageRes?.()?.lanResTag, modelJson.caption);
        const panelItems: IPSPanelItem[] = modelJson.getPSPanelItems() || [];
        return (
            <el-tab-pane label={label} name={modelJson.name} class={detailClass}>
                {this.renderChildItems(modelJson, panelItems, index)}
            </el-tab-pane>
        );
    }

    /**
     * 绘制面板Field
     *
     * @memberof AppDefaultViewLayout
     */
    public renderField(modelJson: IPSSysPanelField, index?: number) {
        const { caption, hidden, showCaption } = modelJson;
        //  存在多份属性模型时根据下标获取对应 name
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        const editor: any = modelJson.getPSEditor();
        const labelPos = 'LEFT';
        return (
            !hidden && (
                <app-panel-field
                    name={name}
                    labelPos={labelPos}
                    caption={this.$tl(modelJson.getCapPSLanguageRes()?.lanResTag, caption)}
                    isEmptyCaption={!showCaption}
                    class={detailClass}
                    style={detailStyle}
                    data={this.layoutData}
                    value={this.layoutData[name]}
                >
                    {editor && (
                        <app-default-editor
                            value={this.layoutData[name]}
                            editorInstance={editor}
                            containerCtrl={this.viewInstance}
                            containerComponent={this}
                            parentItem={modelJson}
                            contextData={this.layoutData}
                            context={this.context}
                            viewparams={this.viewparams}
                            disabled={false}
                            on-change={(event: any) => {
                                this.onValueChange(modelJson.name, event);
                            }}
                            on-enter={(event: any) => {
                                this.onEnter(modelJson.name, event);
                            }}
                            on-blur={(event: any) => {
                                this.onLeave(modelJson.name, event);
                            }}
                            on-error={(event: string) => {
                                this.onError(event);
                            }}
                        />
                    )}
                </app-panel-field>
            )
        );
    }

    /**
     * 值变化
     *
     * @param {*} $event
     * @memberof AppDefaultViewLayout
     */
    public async onValueChange(tag: string, event: any) {
        const { name, value } = event;
        const result = await this.handlePanelItemEvent(tag, name, 'onvaluechange', { oldvalue: this.layoutData[name], value });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
        this.layoutData[name] = value;
        if (this.layoutDetailsModel && this.layoutDetailsModel[name]) {
            this.layoutDetailsModel[name].setData(value);
        }
        this.panelLogic(name);
    }

    /**
     * 回车事件
     *
     * @param {string} tag
     * @param {*} event
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public async onEnter(tag: string, enterEvent: any) {
        const { name, event, value } = enterEvent;
        const result = await this.handlePanelItemEvent(tag, name, 'onenter', { event, value });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
    }

    /**
     * 失去焦点事件
     *
     * @param {string} tag
     * @param {*} event
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public async onLeave(tag: string, leaveEvent: any) {
        const { name, event, value } = leaveEvent;
        const result = await this.handlePanelItemEvent(tag, name, 'onleave', { event, value });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
    }

    /**
     * 处理错误信息事件
     *
     * @param {*} $event
     * @memberof AppDefaultViewLayout
     */
    public onError(errorMsg: string) {
        let errorMsgItemName = '';
        Object.keys(this.layoutDetailsModel).forEach((key: string) => {
            if (this.layoutDetailsModel[key]?.itemType === 'FIELD' && this.layoutDetailsModel[key]?.isErrorMsgItem) {
                errorMsgItemName = this.layoutDetailsModel[key].name;
            }
        })
        if (errorMsgItemName) {
            this.onValueChange(errorMsgItemName, { name: errorMsgItemName, value: errorMsg });
            return;
        }
        this.$throw(errorMsg)
    }

    /**
     * 绘制面板Rawitem
     *
     * @memberof AppDefaultViewLayout
     */
    public renderRawItem(modelJson: IPSPanelRawItem, index?: number) {
        const { contentType,rawContent } = modelJson;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const rawItemDetail = modelJson.M.getPSRawItem;
        if (rawItemDetail.predefinedType) {
            return this.renderPredefinedRawItem(name, modelJson, index);
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name]?.getBoxStyle();
        const sysImage = modelJson.getPSSysImage()?.cssClass;
        let sysImgurl = modelJson.getPSSysImage()?.imagePath;
        if (modelJson.getPSSysImage()?.rawContent) {
            sysImgurl = modelJson.getPSSysImage()?.rawContent;
        }
        let content:any;
        content = this.layoutData[name];
        if (['VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)) {
            if(rawContent){
                try{
                    if(typeof rawContent === 'string'){
                        let func = new Function('return (' + rawContent + ');');
                        content  = func();
                    }
                }catch{
                    console.error(`${contentType}类型自定义参数配置错误`);
                    content = null;
                }
            }else{
                content = null;
            }
        }
        return (
            <app-rawitem
                style={detailStyle}
                class={detailClass}
                rawItemDetail={rawItemDetail}
                viewparams={this.viewparams}
                context={this.context}
                contentType={contentType}
                imageClass={sysImage}
                imgUrl={sysImgurl}
                content={content}
                videoParams={content}
                dividerParams={content}
                alertParams={content}
                modelService={this.modelService}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            >
            </app-rawitem>
        );
    }

    /**
     *  渲染预定义直接内容
     *
     * @param {string} name
     * @param {IPSPanelRawItem} modelJson
     * @param {number} [index]
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderPredefinedRawItem(name: string, modelJson: IPSPanelRawItem, index?: number) {
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name]?.getBoxStyle();
        return (
            <app-preset-rawitem
                key={name}
                class={detailClass}
                style={detailStyle}
                detailModel={this.layoutDetailsModel[name]}
                context={this.context}
                viewparams={this.viewparams}
                rawItemDetail={modelJson.M.getPSRawItem}
                navData={this.layoutDetailsModel[name]?.getNavData()}
                type={modelJson.M.getPSRawItem.predefinedType}
                value={this.layoutData[name]}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            ></app-preset-rawitem>
        )
    }

    /**
     * 渲染容器默认工具栏(重写)
     *
     * @memberof AppDefaultViewLayout
     */
    public renderToolBar() {
        if (!(this.toolbarModels && this.toolbarModels.length > 0)) {
            return null;
        }
        return (
            <view-toolbar
                mode={this.viewInstance?.viewStyle || 'DEFAULT'}
                counterServiceArray={this.counterServiceArray}
                isViewLoading={this.layoutLoadingService?.isLoading}
                toolbarModels={this.toolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, [data, $event], this);
                }}
            ></view-toolbar>
        );
    }

    /**
     * 绘制按钮
     *
     * @param {IPSPanelButton} modelJson
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
     public renderButton(modelJson: IPSPanelButton, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        let predefinedType = modelJson.getPSUIAction()?.predefinedType;
        if (predefinedType && predefinedType == 'APP_LOGIN') {
            return (
                <i-button type="primary" class="login_btn login_predefined" on-Click={(event: any) => {
                    debounce(this.handleButtonClick, [{ modelJson, name, predefinedType, event }], 300);
                }}>
                    {this.$tl('components.login.name')}
                </i-button>
            )
        } else if (predefinedType && predefinedType == 'DATA_CANCELCHANGES') {
            return (

                <i-button type="success" class="login_reset login_predefined" on-Click={(event: any) => {
                    debounce(this.handleButtonClick, [{ modelJson, name, predefinedType, event }], 300);
                }}>
                    {this.$tl('components.login.reset')}
                </i-button >
            )
        } else {
            return (
                <app-model-button
                    id={name}
                    data={this.layoutData}
                    modelJson={modelJson}
                    dynaStyle={detailStyle}
                    dynaClass={detailClass}
                    disabled={this.layoutDetailsModel[name]?.disabled}
                    loading={this.layoutLoadingService.getIsLoading(this.layoutDetailsModel[name].parentDataContainerName)}
                    on-onClick={(event: any) => {
                        debounce(this.handleButtonClick, [{ modelJson, name, predefinedType: null, event }], 300);
                    }}
                >
                </app-model-button>
            );
        }
    }

    /**
     * 处理按钮点击
     *
     * @memberof AppDefaultViewLayout
     */
    public async handleButtonClick(inputParam: any) {
        const { modelJson, name, predefinedType, event } = inputParam;
        const data = this.layoutDetailsModel[name].getData() ? this.layoutDetailsModel[name].getData() : {};
        const result = await this.handlePanelItemEvent(modelJson.name, name, 'onclick', { value: data, event });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
        if (predefinedType) {
            if (predefinedType == 'APP_LOGIN') {
                AppPredefinedService.getInstance().login(this, data);
            } else if (predefinedType == 'DATA_CANCELCHANGES') {
                AppPredefinedService.getInstance().reset(this, data);
            }
        } else {
            if (AppServiceBase.getInstance().getEnableUIModelEx()) {
                AppGlobalService.getInstance().executeGlobalUIAction(modelJson.getPSUIAction(), event, this, undefined, data);
            } else {
                AppViewLogicService.getInstance().executeViewLogic(`layoutpanel_${modelJson.name}_click`, event, this, data, (this.viewLayoutPanel as any)?.getPSAppViewLogics());
            }
        }
    }

    /**
     * 绘制控件占位
     *
     * @memberof AppDefaultViewLayout
     */
    public renderCtrlPos(modelJson: any, parent?: any, index?: any) {
        const tag = modelJson.name;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name] || (this.layoutDetailsModel[name]?.isEnableMount === false)) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        if (this.viewProxyMode) {
            const appControls = this.viewLayoutPanel?.getPSControls() as (IPSControl[] | null);
            const targetControl = ModelTool.findPSControlByName(tag, appControls);
            const args = { staticProps: { localSourceTag: this.layoutDetailsModel[name].dataSourceTag }, dynamicProps: { context: this.layoutDetailsModel[name].context } };
            if (targetControl) {
                return <div class={detailClass} style={detailStyle}>
                    {this.renderTargetControl(targetControl, false, args)}
                </div>
            }
        } else {
            return <div class={detailClass} style={detailStyle}>
                {this.$slots[`layout-${tag}`]}
            </div>
        }
    }

    /**
    * 绘制用户部件
    *
    * @param {*} modelJson 模型
    * @memberof AppDefaultViewLayout
    */
    public renderUserControl(modelJson: any, parent?: any, index?: any) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        return <app-user-control style={detailStyle} class={detailClass} modelJson={modelJson} parent={parent} index={index} on-valueChange={(event: any) => {
            this.onValueChange(modelJson.name, event);
        }} />
    }

    /**
     * 处理面板项事件
     *
     * @param {string} tag 标识
     * @param {string} name 项名称
     * @param {string} eventName 事件名称
     * @param {*} args 附加参数
     * @memberof AppDefaultViewLayout
     */
    public async handlePanelItemEvent(tag: string, name: string, eventName: string, args?: any) {
        const tempTag: string = `${tag.toLowerCase()}-${eventName.toLowerCase()}`;
        if (this.containerTriggerLogicMap.get(tempTag)) {
            if (args?.event) {
                args.event.stopPropagation();
            }
            const data = { value: this.layoutDetailsModel[name].getData(), data: this.layoutData };
            if (args && (Object.keys(args).length > 0)) {
                Object.assign(data, args);
            }
            const result = await this.containerTriggerLogicMap.get(tempTag).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, args: args }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
            return result;
        }
    }

    /**
     * 工具栏点击（重写）
     *
     * @param {*} data
     * @param {*} $event
     * @return {*} 
     * @memberof AppDefaultViewLayout
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
            const actionParam = { xDataControlName: this.viewInstance.xDataControlName, entityName: this.appDeCodeName.toLowerCase() };
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
     * 强制刷新
     * 
     * @memberof AppDefaultViewLayout
     */
    public async forceRefresh() {
        await this.initDetailsModel(null, this.viewLayoutPanel?.getRootPSPanelItems());
        this.$forceUpdate();
    }
}