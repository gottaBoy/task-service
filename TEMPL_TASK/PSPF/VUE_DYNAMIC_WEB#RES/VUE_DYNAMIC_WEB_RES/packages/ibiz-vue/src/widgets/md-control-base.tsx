import { Subscription } from 'rxjs';
import { CodeListService, throttle, MDControlInterface, ModelTool, DataServiceHelp, AppServiceBase, AppItemEngine } from 'ibiz-core'
import { MainControlBase } from './main-control-base';
import { AppCenterService, AppGlobalService, AppViewLogicService } from '../app-service';
import { IPSAppCodeList, IPSAppDataEntity, IPSControlLogic, IPSDEContextMenu, IPSDETBUIActionItem, IPSDEToolbar, IPSDEToolbarItem, IPSDEUIAction } from '@ibiz/dynamic-model-api';


/**
 * 多数据部件基类
 *
 * @export
 * @class MDControlBase
 * @extends {MainControlBase}
 */
export class MDControlBase extends MainControlBase implements MDControlInterface {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof MDControlBase
     */
    public codeListService!: CodeListService;

    /**
     * 应用状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MDControlBase
     */
    public declare appStateEvent: Subscription | undefined;

    /**
     * 多数据部件实例
     *
     * @public
     * @type {(IPSMDControl)}
     * @memberof MDControlBase
     */
    public declare controlInstance: any;

    /**
     * 快速工具栏实例
     *
     * @type {IPSDEToolbar}
     * @memberof MDControlBase
     */
    public quickToolbarInstance!: IPSDEToolbar;

    /**
     * 批处理工具栏实例
     *
     * @type {IPSDEToolbar}
     * @memberof MDControlBase
     */
    public batchToolbarInstance!: IPSDEToolbar;

    /**
     * 快速行为模型数据
     *
     * @protected
     * @type {[]}
     * @memberof MDControlBase
     */
    public quickToolbarModels: Array<any> = [];

    /**
     * 批操作行为模型数据
     *
     * @protected
     * @type {[]}
     * @memberof MDControlBase
     */
    public batchToolbarModels: Array<any> = [];

    /**
     * 选中行数据
     *
     * @type {any[]}
     * @memberof MDControlBase
     */
    public selections: any[] = [];

    /**
     * 当前页
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public curPage: number = 1;

    /**
     * 多数据部件数据激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof GridControlBase
     */
    public mDCtrlActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof MDControlBase
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isNoSort: boolean = false;

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public limit: number = 20;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public totalRecord: number = 0;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isSingleSelect?: boolean;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isSelectFirstDefault: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public minorSortDir: string = "";

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public minorSortPSDEF: string = "";

    /**
     * 建立数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public createAction: string = "";
    /**
     * 查询数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public fetchAction: string = "";

    /** 
     * 更新数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public updateAction: string = "";

    /**
     * 删除数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public removeAction: string = "";

    /**
     * 查询数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public loadAction: string = "";

    /**
     * 获取草稿数据行为
     *
     * @readonly
     * @memberof MDControlBase
     */
    public loaddraftAction: string = "";

    /**
     * 数据映射（数据项名称和UI名称的映射）
     * 
     * @memberof MDControlBase
     */
    public dataMap: Map<string, any> = new Map();

    /**
     * 分组模式
     * 
     * @type {string}
     * @memberof MDControlBase
     */
    public groupMode: string = '';

    /**
     * 是否开启分组
     * 
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isEnableGroup: boolean = false;

    /**
     * 分组属性
     * 
     * @type {string}
     * @memberof MDControlBase
     */
    public groupField: string = '';

    /**
     * 分组代码表
     * 
     * @type {IPSAppCodeList}
     * @memberof MDControlBase
     */
    public groupCodeList?: IPSAppCodeList;

    /**
     * 上下文菜单逻辑map
     *
     * @type {Map<string, AppItemEngine[]>}
     * @memberof MDControlBase
     */
    public contextMenuLogicMap: Map<string, AppItemEngine[]> = new Map();

    /**
     * 获取视图样式
     *
     * @readonly
     * @memberof MDControlBase
     */
    get viewStyle() {
        const parentModel: any = this.controlInstance?.getParentPSModelObject?.();
        if (parentModel && parentModel.viewStyle) {
            return parentModel.viewStyle;
        } else {
            if (parentModel && parentModel.controlType) {
                return parentModel.getParentPSModelObject?.()?.viewStyle || 'DEFAULT';
            }
            return 'DEFAULT';
        }
    }

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MDControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect !== false;
        this.isSelectFirstDefault = newVal.isSelectFirstDefault === true;
        this.mDCtrlActiveMode = newVal.mDCtrlActiveMode;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 部件模型数据初始化
     *
     * @memberof MDControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        const { name } = this.controlInstance;
        if (this.controlInstance?.getPSAppDataEntity?.() && !(this.Environment && this.Environment.isPreviewMode)) {
            if (!this.controlInstance?.getPSAppDataEntity()?.isFill) {
                await this.controlInstance?.getPSAppDataEntity().fill();
            }
            this.appEntityService = await DataServiceHelp.getInstance().getService((this.controlInstance.getPSAppDataEntity() as IPSAppDataEntity), { context: this.context });
        }
        this.loaddraftAction = this.controlInstance?.getGetDraftPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "GetDraft";
        this.loadAction = this.controlInstance?.getGetPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Get";
        this.removeAction = this.controlInstance?.getRemovePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Remove";
        this.updateAction = this.controlInstance?.getUpdatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Update";
        this.fetchAction = this.controlInstance?.getFetchPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "FetchDefault";
        this.createAction = this.controlInstance?.getCreatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Create";
        if (this.controlInstance?.getPSControls?.()) {
            this.quickToolbarInstance = ModelTool.findPSControlByName(`${name}_quicktoolbar`, this.controlInstance.getPSControls())
            this.batchToolbarInstance = ModelTool.findPSControlByName(`${name}_batchtoolbar`, this.controlInstance.getPSControls())
        }
        this.initToolBarModels();
        this.initDataMap();
        this.initGroupOptions();
    }

    /**
     * 初始化工具栏模型
     *
     * @memberof MDControlBase
     */
    public initToolBarModels() {
        const getModelData = (_item: IPSDEToolbarItem) => {
            const item: IPSDETBUIActionItem = _item as IPSDETBUIActionItem;
            const uiAction: IPSDEUIAction | null = item.getPSUIAction ? (item?.getPSUIAction() as IPSDEUIAction) : null;
            return {
                name: item.name,
                showCaption: item.showCaption,
                showIcon: item.showIcon,
                tooltip: this.$tl(item.getTooltipPSLanguageRes()?.lanResTag, item.tooltip),
                iconcls: item.getPSSysImage()?.cssClass,
                icon: item.getPSSysImage()?.imagePath,
                actiontarget: item.uIActionTarget,
                caption: this.$tl(item.getCapPSLanguageRes()?.lanResTag, item.caption),
                disabled: false,
                itemType: item.itemType,
                visabled: true,
                noprivdisplaymode: uiAction?.noPrivDisplayMode,
                actionLevel: (_item as any).actionLevel,
                dataaccaction: '',
                uiaction: {
                    tag: uiAction?.uIActionTag ? uiAction.uIActionTag : uiAction?.id ? uiAction.id : '',
                    target: uiAction?.actionTarget,
                },
            };
        };
        if (this.quickToolbarInstance) {
            let targetViewToolbarItems: any[] = [];
            this.quickToolbarInstance.getPSDEToolbarItems()?.forEach((item: IPSDEToolbarItem) => {
                targetViewToolbarItems.push(getModelData(item));
            });
            this.quickToolbarModels = targetViewToolbarItems;
        }
        if (this.batchToolbarInstance) {
            let targetViewToolbarItems: any[] = [];
            this.batchToolbarInstance.getPSDEToolbarItems()?.forEach((item: IPSDEToolbarItem) => {
                targetViewToolbarItems.push(getModelData(item));
            });
            this.batchToolbarModels = targetViewToolbarItems;
        }
    }

    /**
     * 初始化上下文菜单逻辑
     *
     * @param {IPSDEContextMenu} contextMenu
     * @memberof MDControlBase
     */
    public initContextMenuUILogic(contextMenu: IPSDEContextMenu) {
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const ToolbarItems = contextMenu.getPSDEToolbarItems();
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
                                const logics = this.contextMenuLogicMap.get(`${contextMenu.name}`);
                                if (logics && logics.length > 0) {
                                    logics.push(new AppItemEngine(logic));
                                    this.contextMenuLogicMap.set(`${contextMenu.name}`, logics);
                                } else {
                                    this.contextMenuLogicMap.set(`${contextMenu.name}`, [new AppItemEngine(logic)]);
                                }
                            }
                        })
                    }
                })
            }
        } else {
            const contextMenuLogics = contextMenu.getPSControlLogics();
            if (contextMenuLogics && contextMenuLogics?.length > 0) {
                contextMenuLogics.forEach((logic: IPSControlLogic) => {
                    if (
                        logic.triggerType === 'ITEMVISIBLE' ||
                        logic.triggerType === 'ITEMENABLE' ||
                        logic.triggerType === 'ITEMBLANK'
                    ) {
                        const logics = this.contextMenuLogicMap.get(`${contextMenu.name}`);
                        if (logics && logics.length > 0) {
                            logics.push(new AppItemEngine(logic));
                            this.contextMenuLogicMap.set(`${contextMenu.name}`, logics);
                        } else {
                            this.contextMenuLogicMap.set(`${contextMenu.name}`, [new AppItemEngine(logic)]);
                        }
                    }
                })
            }
        }
    }
    
    /**
     * 多数据部件初始化
     *
     * @memberof MDControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        let _this: any = this;
        // 全局刷新通知
        if (AppCenterService.getMessageCenter()) {
            _this.appStateEvent = AppCenterService.getMessageCenter().subscribe(({ name, action, data }: { name: string, action: string, data: any }) => {
                if (!_this.appDeCodeName || !Object.is(name, _this.appDeCodeName)) {
                    return;
                }
                if (Object.is(action, 'appRefresh')) {
                    _this.refresh(data);
                }
            })
        }
        _this.codeListService = new CodeListService({ $store: _this.$store });
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MDControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.appStateEvent) {
            this.appStateEvent.unsubscribe();
        }
    }

    /**
     * 部件工具栏点击
     *
     * @param ctrl 部件
     * @param data 工具栏回传数据
     * @param $event 事件源对象
     * @memberof MDControlBase
     */
    public handleItemClick(ctrl: string, data: any, $event: any) {
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const uiAction = ModelTool.getToolBarUIActionByItemName(ctrl == 'quicktoolbar' ? this.quickToolbarInstance : this.batchToolbarInstance, data.tag);
            AppGlobalService.getInstance().executeGlobalUIAction(uiAction, $event, this, undefined, undefined);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(
                this.getViewLogicTag(this.controlInstance.name, ctrl, data.tag),
                $event,
                this,
                undefined,
                this.controlInstance.getPSAppViewLogics() as Array<any>,
            );
        }
    }

    /**
     * 处理上下文菜单逻辑
     *
     * @param {any[]} data
     * @param {*} actionModel
     * @memberof MDControlBase
     */
    public handleContextMenuLogic(data: any[], actionModel: any) {
        if (this.contextMenuLogicMap.size > 0 && Object.keys(actionModel).length > 0) {
            let contextMenuName: string = '';
            Object.values(actionModel).forEach((action: any) => {
                contextMenuName = action.ctrlname;
            })
            const logics = this.contextMenuLogicMap.get(contextMenuName);
            if (logics && logics.length > 0) {
                logics.forEach((logic: AppItemEngine) => {
                    logic.executeUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, itemModels: actionModel }, utils: this.viewCtx, app: this.viewCtx.app, view: this.viewCtx.view, ctrl: this });
                })
            }
        }
    }

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MDControlBase
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项数据
     *
     * @returns {*}
     * @memberof MDControlBase
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
      * 绘制加载数据提示信息
      *
      * @return {*} 
      * @memberof MDControlBase
      */
    public renderLoadDataTip() {
        return <div class="control__loading">
            <img class="loading__img" src={__webpack_public_path__ + "./assets/img/load-data.gif"} />
            <span class="loading__text">{this.$t('app.warn.load')}</span>
        </div>
    }

    /**
     * 绘制无数据提示信息
     *
     * @return {*} 
     * @memberof MDControlBase
     */
    public renderEmptyDataTip() {
        return <div class="control__empty">
            <img class="empty__img" src={__webpack_public_path__ + "./assets/img/empty-data.svg"} />
            <span class="empty__text">{this.$t('app.warn.nofind')}</span>
            {this.renderQuickToolbar()}
        </div>
    }

    /**
     * 绘制快速工具栏
     *
     * @return {*} 
     * @memberof MDControlBase
     */
    public renderQuickToolbar(): any {
        return <view-toolbar
                class="app-quick-toolbar"
                toolbarModels={this.quickToolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, ['quicktoolbar', data, $event], this);
                }}
            ></view-toolbar>
    }

    /**
     * 绘制批处理工具栏
     *
     * @return {*} 
     * @memberof MDControlBase
     */
    public renderBatchToolbar(): any {
        for (let index = 0; index < this.batchToolbarModels.length; index++) {
            this.batchToolbarModels[index].disabled = this.selections.length <= 0;
        }
        return <template v-show={this.selections.length > 0 || this.viewStyle == 'DEFAULT'}>
            <view-toolbar
                class="app-batch-toolbar"
                toolbarModels={this.batchToolbarModels}
                on-item-click={(data: any, $event: any) => {
                    throttle(this.handleItemClick, ['batchtoolbar', data, $event], this);
                }}
            ></view-toolbar>
        </template>
    }

    /**
     * 初始化数据映射
     * 
     * @memberof MDControlBase
     */
    public initDataMap() { }

    /**
     * 初始化分组配置
     * 
     * @memberof MDControlBase
     */
    public initGroupOptions() {
        this.isEnableGroup = (this.controlInstance.enableGroup && this.controlInstance.getGroupPSAppDEField?.()) ? true : false;
        if (this.isEnableGroup) {
            this.groupMode = this.controlInstance.groupMode;
            this.groupField = this.controlInstance.getGroupPSAppDEField().codeName?.toLowerCase();
            this.groupCodeList = this.controlInstance.getGroupPSCodeList?.() as IPSAppCodeList;
        }
    }

    /**
     * 分组
     * 
     * @memberof MDControlBase
     */
    public group() {
        if (Object.is(this.groupMode, "AUTO")) {
            this.drawGroup();
        } else if (Object.is(this.groupMode, "CODELIST")) {
            this.drawCodelistGroup();
        }
    }

    /**
     * 自动分组
     * 
     * @memberof MDControlBase
     */
    public drawGroup() { }

    /**
     * 代码表分组
     * 
     * @memberof MDControlBase
     */
    public drawCodelistGroup() { }
}
