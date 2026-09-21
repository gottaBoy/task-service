import { Prop, Component } from 'vue-property-decorator';
import { IPSControl, IPSPanelButton, IPSPanelContainer, IPSPanelItem, IPSPanelRawItem, IPSPanelTabPage, IPSPanelTabPanel, IPSSysPanelButton, IPSSysPanelField, IPSViewLayoutPanel } from '@ibiz/dynamic-model-api';
import { Util, ThirdPartyService, PanelButtonModel, PanelTabPanelModel, PanelTabPageModel, PanelContainerModel, PanelFieldModel, PanelRawitemModel, PanelControlModel, PanelUserControlModel, PanelCtrlPosModel, appEngineService, AppServiceBase, ModelTool } from 'ibiz-core';
import { PluginService } from '../../../../app-service/common-service/plugin-service';
import { AppViewLogicService, ContainerLoadingService, LayoutLoadingService } from '../../../../app-service';
import { ControlContainer } from '../../../../control-container/control-container';
import { Subject } from 'rxjs';

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
    @Prop() public modelService: any;

    /**
     * 使用视图头
     *
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    @Prop({ default: true }) public showCaptionBar?: boolean;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof AppDefaultViewLayout
     */
    public viewIsInit: boolean = false;

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
     * 面板数据
     *
     * @type {*}
     * @memberof AppDefaultViewLayout
     */
    public layoutData: any = {};

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
     * 面板加载服务
     *
     * @type {LayoutLoadingService}
     * @memberof AppDefaultViewLayout
     */
    public layoutLoadingService: LayoutLoadingService = new LayoutLoadingService();

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
     * Vue生命周期，实例创建完成
     *
     * @memberof AppDefaultViewLayout
     */
    created() {
        this.initViewSpecificData();
        this.initViewLayOutContainer();
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
            this.viewState = parentRef.viewState;
            this.viewtag = parentRef.viewtag;
            this.viewCodeName = parentRef.viewCodeName;
            this.engine = appEngineService.getEngine(this.viewInstance.viewType);
        }
        await this.initUIContainerBeforeCtx();
        this.initViewLayoutCtx();
        await this.initUIContainerAfterCtx();
        await this.initViewLayOut();
        // 初始化视图容器样式
        this.initRenderOptions();
        if (this.viewProxyMode) {
            setTimeout(() => {
                this.setContainerIsMounted();
            }, 0);
        }
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
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
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
        if (this.viewProxyMode) {
            // 处理ctx
            const tempViewCtx = parentRef?.viewCtx ? parentRef?.viewCtx : {};
            tempViewCtx['view'] = this;
            // 顶层路由视图
            if (!Object.is(parentRef.viewDefaultUsage, 'INCLUDEDVIEW')) {
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
        this.viewLayoutPanel = this.viewInstance?.getPSViewLayoutPanel();
        if (this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout) {
            await this.initDetailsModel(null, this.viewLayoutPanel?.getRootPSPanelItems());
            this.viewIsInit = true;
        } else {
            this.viewIsInit = true;
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
                }
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewIsInited', data: null });
            })
        }
    }

    /**
     * 计算目标部件所需参数(重写)
     *
     * @memberof AppDefaultViewLayout
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
            }
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 执行挂载部件事件拦截（重写）
     *
     * @param {string} eventName 事件名称
     * @param {*} data 数据
     * @memberof ControlContainer
     */
    public exeMountedCtrlEvent(eventName: string, data: any) {
        // 识别导航区占位
        if (eventName && Object.is(eventName, 'selectionchange') && data && data.srfnavdata) {
            const navPos: any = Object.values(this.layoutDetailsModel).find((item: any) => {
                return item.panelItemModel.M?.getPSRawItem?.predefinedType === "NAV_POS";
            })
            if (navPos && navPos.setNavData instanceof Function) {
                navPos.setNavData(data.srfnavdata);
                this.$forceUpdate();
            }
        }
    }

    /**
     * 初始化面板成员模型
     *
     * @param {*} parentItem 父面板成员
     * @param {(IPSPanelItem[] | undefined | null)} [panelItems] 成员集合
     * @param {number} [dataIndex=0] 数据下标
     * @param {boolean} [hasMulParent=false] 是否存在父多数据容器父级成员
     * @memberof AppDefaultViewLayout
     */
    public async initDetailsModel(parentItem: any, panelItems?: IPSPanelItem[] | undefined | null, dataIndex: number = 0, hasMulParent: boolean = false) {
        if (panelItems && panelItems.length > 0) {
            //  父面板成员为多项数据容器时，构建多份子面板成员
            if (parentItem && parentItem.dataRegionType === 'MULTIDATA' && parentItem.getData()?.length > 0) {
                for (let index = 0; index <= parentItem.getData().length - 1; index++) {
                    await this.initDetailsModelItem(parentItem, panelItems, index, true);
                }
            } else {
                await this.initDetailsModelItem(parentItem, panelItems, dataIndex, hasMulParent);
            }
        }
    }

    /**
     * 初始化面板模型项
     *
     * @param {*} parentItem 父面板项
     * @param {(IPSPanelItem[] | undefined | null)} [panelItems] 面板项成员
     * @param {number} [index=0] 数据下标
     * @param {boolean} [hasMulParent=false] 是否存在父多数据容器父级成员
     * @memberof AppDefaultViewLayout
     */
    public async initDetailsModelItem(parentItem: any, panelItems?: IPSPanelItem[] | undefined | null, index: number = 0, hasMulParent: boolean = false) {
        if (panelItems && panelItems.length > 0) {
            for (let i = 0; i < panelItems.length; i++) {
                const panelItem: IPSPanelItem = panelItems[i];
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
    }

    /**
     * Vue生命周期，实例销毁完成
     *
     * @memberof AppDefaultViewLayout
     */
    public destroyed() {
        if (this.viewProxyMode) {
            this.handleContainerPreEvent('onViewDestroyed').then((result: boolean) => {
                // 非嵌入模式下
                const parentRef: any = this.$parent;
                if (!Object.is(parentRef.viewDefaultUsage, 'INCLUDEDVIEW')) {
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
        this.destroyUIContainer();
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewHeader() {
        return [
            <ion-toolbar class="view-header__top">
                <div class="view-header__top__captionbar">
                    {this.$slots.captionbar}
                </div>
                {/*  不能额外加容器 否则影响布局 */}
                {this.$slots.mobnavrightmenu}
                {this.$slots.mobnavleftmenu}
            </ion-toolbar>,
            <div class="view-header__body">
                {this.$slots.quicksearch}
                {this.$slots.quickGroupSearch}
            </div>,
        ]

    }

    /**
     * 是否为嵌入视图视图
     * 
     * @memberof AppDefaultViewLayout
     */
    get isViewDefaultUsage() {
        const parentRef: any = this.$parent;
        return parentRef.viewDefaultUsage == 'INCLUDEDVIEW' ? true : false
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
     * 绘制视图标题
     * @param renderMode 文本绘制模式
     * @return {*}  {*}
     * @memberof AppDefaultViewLayout
     */
    public renderViewCaption(renderMode?: any): any {
        switch (renderMode) {
            case 'TEXT':
                return (this.viewInstance.showCaptionBar ? <span class='view-header__caption'>{this.viewInstance.caption ? this.viewInstance.caption : this.viewInstance.title}</span> : null);
            case 'HEADING1':
            case 'HEADING2':
            case 'HEADING3':
            case 'HEADING4':
            case 'HEADING5':
            case 'HEADING6':
                return this.$createElement(`h${renderMode.charAt(renderMode.length - 1)}`,
                    {},
                    this.viewInstance.caption ? this.viewInstance.caption : this.viewInstance.title
                );
            case 'PARAGRAPH':
                return this.viewInstance.showCaptionBar ? <p>{this.viewInstance.title}</p> : null
            default:
                return (this.viewInstance.showCaptionBar ? <span class='view-header__caption'>{this.viewInstance.caption ? this.viewInstance.caption : this.viewInstance.title}</span> : null);
        }
    }

    /**
     * 绘制视图内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewContent() {
        return [
            this.$slots.topMessage || (this.$slots.searchForm) ? <div class="view-content__top">
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
     * 绘制底部
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewFooter() {
        return [
            this.$slots.mobbottommenu,
            this.$slots.footer,
        ]
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderContent() {
        return [
            (this.showCaptionBar && !this.isEmbedView) ? <ion-header class='view-header'>
                {this.renderViewHeader()}
            </ion-header> : null,
            <div class='view-content'>
                {this.renderViewContent()}
            </div>,
            (this.$slots.footer || this.$slots.mobbottommenu) && (
                <ion-footer class="view-footer">
                    {this.renderViewFooter()}
                </ion-footer>
            )
        ];
    }

    /**
     * 绘制布局
     * 
     * @memberof AppDefaultViewLayout
     */
    public render(h: any): any {
        const { viewClassNames } = this.renderOptions;
        return (
            (this.isEmbedView || this.isViewDefaultUsage) ? <div class={viewClassNames}>
                {this.viewIsInit ? (this.viewLayoutPanel && this.viewLayoutPanel.useDefaultLayout) ? this.renderContent() : this.renderViewLayoutPanel() : this.renderInitLoading()}
            </div> :
                <ion-page className={viewClassNames}>
                    {this.viewIsInit ? (this.viewLayoutPanel && this.viewLayoutPanel.useDefaultLayout) ? this.renderContent() : this.renderViewLayoutPanel() : this.renderInitLoading()}
                </ion-page>
        );
    }

    /**
     * 渲染初始化loading效果
     *
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderInitLoading() {
        return <app-loading-mask maskElement={Util.srfFilePath2(this.viewInstance.codeName)}></app-loading-mask>
    }

    /**
     * 绘制视图布局面板
     *
     * @memberof AppDefaultViewLayout
     */
    public renderViewLayoutPanel() {
        if ((this.viewLayoutPanel as any)?.layoutBodyOnly) {
            return this.renderLayoutBodyOnly();
        } else {
            return this.renderRootPSPanelItems();
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
        return this.viewLayoutPanel?.getRootPSPanelItems()?.map((container: any, index: number) => {
            return this.renderByDetailType(container);
        })
    }

    /**
    * 仅布局内容区模式绘制
    *
    * @memberof AppDefaultViewLayout
    */
    public renderLayoutBodyOnly() {
        return [(this.showCaptionBar && !this.isEmbedView && !this.isViewDefaultUsage) ? <ion-header>
            {!ThirdPartyService.getInstance().platform ? this.$slots.captionbar && !this.viewInstance.isPartsView ? this.$slots['layout-captionbar'] || this.$slots.captionbar : null : null}
            {this.$slots.toolbar}
            {this.$slots.quicksearch}
            {this.$slots.quickGroupSearch}
            {this.$slots.topMessage}
        </ion-header> : null,
        this.renderLayoutContent(),
        (this.$slots.mobbottommenu || this.$slots.footer || this.$slots.bottomMessage) ? <ion-footer class="view-footer">
            {this.$slots.mobbottommenu}
            {this.$slots.footer}
            {this.$slots.bottomMessage}
        </ion-footer> : null
        ];
    }

    /**
     * 绘制布局内容区
     *
     * @memberof AppDefaultViewLayout
     */
    public renderLayoutContent() {
        const content = [this.$slots.bodyMessage, this.renderRootPSPanelItems()]
        return <div class="view-content">
            {[...content]}
        </div>
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
                return this.renderRawitem(modelJson, index);
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
        let name: string = container.name;
        //  父容器为多数据容器
        let hasMulParent: boolean = false;
        if (parent && parent.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[parent.name]?.getData()?.length > 0) {
            hasMulParent = true;
            name += `_${index}`;
        }
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const layout = container.getPSLayout()?.layout;
        // 容器样式
        const detailStyle = {};
        // 获取布局设置(约束子,如：flex布局及相关设置)
        const boxLayoutStyle = this.layoutDetailsModel[name].getBoxLayoutStyle();
        Object.assign(detailStyle, boxLayoutStyle);
        // 获取盒子宽高/间隔模式
        const boxStyle = this.layoutDetailsModel[name].getBoxStyle();
        Object.assign(detailStyle, boxStyle);
        // 获取盒子样式表
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();

        if (layout && Object.is(layout, 'BORDER')) {
            return (
                <van-col style={detailStyle} class={[detailClass,'app-view-layout__container']} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        // this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                        //     return <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container>;
                        // }) 
                        <div>多数据容器下不能嵌入边缘布局容器</div> : hasMulParent ?
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container> :
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems)}</app-scroll-container>}
                </van-col>
            );
        } else if (layout && (Object.is(layout, 'FLEX'))) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={container.showCaption ? "" : detailStyle} class={[detailClass,'app-view-layout__container']} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {container.showCaption ? <div class="app-view-layout__container__content" style={detailStyle}>
                        {
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return this.renderChildItems(container, panelItems, index);
                                }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                        }
                    </div> : container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return this.renderChildItems(container, panelItems, index);
                        }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)}
                </van-row>
            );
        } else if (layout && Object.is(layout, 'SIMPLEFLEX')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={container.showCaption ? "" : detailStyle} class={[detailClass,'app-view-layout__container']}  nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {container.showCaption ? <div class="app-view-layout__container__content" style={detailStyle}>
                        {
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>;
                                }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                        }
                    </div> : container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                        }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>}
                </van-row>
            );
        } else {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={detailStyle} class={[detailClass,'app-view-layout__container']}  nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class="app-view-layout__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return this.renderChildItems(container, panelItems, index);
                        }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)}
                </van-row>

            );
        }
    }

    /**
     * 绘制子容器
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
            if (Object.is(layout, 'BORDER')) {
                return (
                    <div style={childDetailStyle} slot={item.name} class={'app-view-layout__container__item'}>
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'FLEX')) {
                return (
                    <div style={childDetailStyle} class={'app-view-layout__container__item'} >
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'TABLE_12COL') || Object.is(layout, 'TABLE_24COL')) {
                const attrs = this.layoutDetailsModel[name]?.getGridLayoutProps(item, layout);
                return (
                    <van-col {...{ props: attrs.md }} style={childDetailStyle} class={'app-view-layout__container__item'}>
                        {this.renderByDetailType(item, parent, index)}
                    </van-col>
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
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        return (
            <van-tabs
                type="card"
                animated={true}
                swipeable={true}
                scrollspy={true}
                value={activedTabPage}
                class={detailClass}
                style={parent ? {} : detailStyle}
                on-click={(event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) }}
            >
                {tabPages.length > 0 ?
                    tabPages.map((item: IPSPanelTabPage) => {
                        return this.renderTabPage(item, index);
                    }) : null}
            </van-tabs>
        );
    }

    /**
     * 绘制面板TabPage
     *
     * @memberof AppDefaultViewLayout
     */

    public renderTabPage(modelJson: IPSPanelTabPage, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const label = this.$tl(modelJson.getCapPSLanguageRes?.()?.lanResTag, modelJson.caption);
        const panelItems: IPSPanelItem[] = modelJson.getPSPanelItems() || [];
        return (
            <van-tab title={label} name={modelJson.name} class={detailClass}>
                {this.renderChildItems(modelJson, panelItems, index)}
            </van-tab>
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
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        Object.assign(detailClass, { 'item-field': true });
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        const editor: any = modelJson.getPSEditor();
        const labelClass = {
            'item-field-label': true,
            [modelJson.getPSSysCss()?.cssName || '']: true
        }
        return (
            !hidden && (
                <div class={detailClass} style={detailStyle}>
                    {showCaption && caption ? <ion-label class={labelClass} >{caption}</ion-label> : null}
                    {editor && (
                        <app-default-editor
                            value={this.layoutData[name]}
                            editorInstance={editor}
                            containerComponent={this}
                            containerCtrl={this.viewInstance}
                            parentItem={modelJson}
                            contextData={this.layoutData}
                            context={this.context}
                            viewparams={this.viewparams}
                            disabled={false}
                            on-change={(event: any) => {
                                this.onValueChange(modelJson.name, event);
                            }}
                            on-enter={(event: any) => {
                                this.onEditorEnter(modelJson.name, event);
                            }}
                            on-leave={(event: any) => {
                                this.onEditorLeave(modelJson.name, event);
                            }}
                            on-error={(event: string) => {
                                this.onError(event);
                            }}
                        />
                    )}
                </div>
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
        console.log(tag, 'change', value);
        const result = await this.handlePanelItemEvent(tag, name, 'onchange', { oldvalue: this.layoutData[name], value });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
        this.layoutData[name] = value;
        if (this.layoutDetailsModel && this.layoutDetailsModel[name]) {
            this.layoutDetailsModel[name].setData(value);
        }
    }

    /**
     * 值获取焦点
     *
     * @param {*} $event
     * @memberof AppDefaultViewLayout
     */
    public async onEditorEnter(tag: string, event: any) {
        const { name, value } = event;
        console.log(tag, 'enter', value);
        const result = await this.handlePanelItemEvent(tag, name, 'onenter', { oldvalue: this.layoutData[name], value });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
    }

    /**
     * 值失去焦点
     *
     * @param {*} $event
     * @memberof AppDefaultViewLayout
     */
    public async onEditorLeave(tag: string, event: any) {
        const { name, value } = event;
        console.log(tag, 'leave', value);
        const result = await this.handlePanelItemEvent(tag, name, 'onleave', { oldvalue: this.layoutData[name], value });
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
        this.$Notice.error(errorMsg);
    }

    /**
     * 绘制面板Rawitem
     *
     * @memberof AppDefaultViewLayout
     */
    public renderRawitem(modelJson: IPSPanelRawItem, index?: number) {
        const { contentType } = modelJson;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const rawItemDetail = modelJson.M.getPSRawItem;
        if (rawItemDetail.predefinedType) {
            return this.renderPredefinedRawItem(name, modelJson, index);
        }
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        const imageDetail = { imageClass: modelJson.getPSSysImage()?.cssClass, imagePath: modelJson.getPSSysImage()?.imagePath };
        const content = this.layoutData[name];
        return (
            <app-rawitem
                class={detailClass}
                style={detailStyle}
                context={this.context}
                viewparams={this.viewparams}
                contentType={contentType}
                rawItemDetail={rawItemDetail}
                imageDetail={imageDetail}
                content={content}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            >
            </app-rawitem>
        );
    }

    /**
     * 绘制预定义直接内容
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
        const imageDetail = { imageClass: modelJson.getPSSysImage()?.cssClass, imagePath: modelJson.getPSSysImage()?.imagePath };
        return (
            <app-preset-rawitem
                key={name}
                class={detailClass}
                style={detailStyle}
                detailModel={this.layoutDetailsModel[name]}
                navData={this.layoutDetailsModel[name]?.getNavData()}
                context={this.context}
                viewparams={this.viewparams}
                rawItemDetail={modelJson.M.getPSRawItem}
                imageDetail={imageDetail}
                type={modelJson.M.getPSRawItem.predefinedType}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            ></app-preset-rawitem>
        )
    }


    /**
     * 绘制按钮
     *
     * @param {IPSPanelButton} modelJson
     * @return {*} 
     * @memberof AppDefaultViewLayout
     */
    public renderButton(modelJson: IPSPanelButton, index?: number) {
        const { caption, showCaption } = modelJson;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        if (modelJson?.M?.buttonCssStyle) {
            Object.assign(detailStyle, this.getContentStyle(modelJson?.M?.buttonCssStyle))
        }
        return (
            <app-mob-button
                id={name}
                modelJson={modelJson}
                style={detailStyle}
                text={showCaption ? caption : ''}
                disabled={this.layoutDetailsModel[name]?.disabled}
                class={detailClass}
                showDefaultIcon={false}
                on-click={(event: any) => {
                    this.handleButtonClick(modelJson.name, name, event);
                }}
            ></app-mob-button>
        );
    }

    /**
      * 处理按钮点击
      *
      * @memberof AppDefaultViewLayout
      */
    public async handleButtonClick(tag: string, name: string, event: any) {
        const data = this.layoutDetailsModel[name].getData() ? this.layoutDetailsModel[name].getData() : {};
        const result = await this.handlePanelItemEvent(tag, name, 'onclick', { value: data, event });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
        AppViewLogicService.getInstance().executeViewLogic(`layoutpanel_${tag}_click`, event, this, data, (this.viewLayoutPanel as any)?.getPSAppViewLogics());
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
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
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
   * @description 获取按钮内容样式
   * @param {*} data
   * @return {*}
   */
    getContentStyle(data: any) {
        if (data) {
            const res = data.split('\n');
            const target: string[] = [];
            res.forEach((item: any) => {
                target.push(...item.split(';').filter((value: any) => value));
            });
            let btnstyle = target.filter((value: string) => {
                return value.split(':').length === 2;
            })
            let detail = {}
            btnstyle.forEach(item => {
                let obj = item.split(":")
                Object.assign(detail, { [obj[0]]: obj[1] })
            })
            return detail;
        }
    }

    /**
    * 绘制用户部件
    *
    * @param {*} modelJson 模型
    * @memberof AppDefaultViewLayout
    */
    public renderUserControl(modelJson: any, parent?: any, index?: any) {
        return (<app-user-control modelJson={modelJson} layoutData={this.layoutData} on-valueChange={(data: any) => this.onValueChange(modelJson.name, data)} />)
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
            const data = { value: this.layoutDetailsModel[name].getData(), data: this.layoutData };
            if (args && (Object.keys(args).length > 0)) {
                Object.assign(data, args);
            }
            const result = await this.containerTriggerLogicMap.get(tempTag).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, args: args }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
            return result;
        }
    }
}