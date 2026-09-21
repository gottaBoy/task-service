import { MDControlBase } from "./md-control-base";
import { AppViewLogicService } from '../app-service/logic-service/app-viewlogic-service';
import { ViewTool, Verify, PanelControlInterface, PanelButtonModel, PanelTabPanelModel, PanelTabPageModel, PanelContainerModel, PanelFieldModel, PanelRawitemModel, PanelControlModel, PanelUserControlModel, LogUtil, Util, PanelCtrlPosModel, DataServiceHelp, dynamicMatch, AppServiceBase } from 'ibiz-core';
import { IPSDEUIAction, IPSPanel, IPSPanelItem, IPSPanelItemGroupLogic, IPSPanelItemSingleLogic, IPSPanelTabPage, IPSPanelTabPanel, IPSSysPanelButton, IPSSysPanelContainer, IPSSysPanelField, IPSSysPanelTabPanel } from '@ibiz/dynamic-model-api';
import { Subscription } from "rxjs";
import { AppGlobalService } from "../app-service";
/**
 * 面板部件基类
 *
 * @export
 * @class PanelControlBase
 * @extends {MDControlBase}
 */
export class PanelControlBase extends MDControlBase implements PanelControlInterface {

    /**
     * 值规则对象
     *
     * @type {*}
     * @memberof PanelControlBase
     */
    public rules: any = {};

    /**
     * 面板的模型对象
     *
     * @type {*}
     * @memberof PanelControlBase
     */
    public declare controlInstance: IPSPanel;

    /**
     * 数据
     *
     * @type {*}
     * @memberof PanelControlBase
     */
    public data: any = {};

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof PanelControlBase
     */
    public layoutDetailsModel: any = {};

    /**
     * 面板数据
     *
     * @type {*}
     * @memberof PanelControlBase
     */
    public layoutData: any = {};

    /**
     * 面板类型
     *
     * @type {('ITEMLAYOUTPANEL' | 'VIEWPANEL')}
     * @memberof PanelControlBase
     */
    public panelType: 'ITEMLAYOUTPANEL' | 'VIEWPANEL' = 'VIEWPANEL';

    /**
     * 面板成员动态逻辑集合
     * 
     * @memberof PanelControlBase
     */
    public allPanelItemGroupLogic: any[] = [];

    /**
     * 是否需要查找属性
     * 
     * @type {boolean}
     * @memberof PanelControlBase
     */
    public needFindDEField: boolean = false;

    /**
     * 父容器数据项
     * 
     * @type {any[]}
     * @memberof PanelControlBase
     */
    public parentDataItems: any[] = [];

    /**
    * 默认加载
    *
    * @type {boolean}
    * @memberof PanelControlBase
    */
    public isLoadDefault!: boolean;

    /**
     * @description 面板部件事件
     * @type {(Subscription | undefined)}
     * @memberof PanelControlBase
     */
    public panelControlEvent: Subscription | undefined;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PanelControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (this.controlIsLoaded && newVal?.navdatas?.[0] != oldVal?.navdatas?.[0]) {
            this.computedUIData();
        }
    }

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PanelControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        super.onStaticPropsChange(newVal, oldVal);
        this.transformData = newVal?.transformData || this.transformData;
        this.opendata = newVal?.opendata || this.opendata;
        this.newdata = newVal?.newdata || this.newdata;
        this.remove = newVal?.remove || this.remove;
        this.refresh = newVal?.refresh || this.refresh;
        this.dataMap = newVal?.dataMap;
        this.isLoadDefault = newVal?.isLoadDefault;
        this.panelType = newVal.panelType === 'ITEMLAYOUTPANEL' ? 'ITEMLAYOUTPANEL' : 'VIEWPANEL';
        // 初始化面板详情模型集合
        this.layoutDetailsModel = {};
        this.allPanelItemGroupLogic = [];
    }

    /**
     * 部件模型初始化
     *
     * @param {*} [args]
     * @memberof PanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit(args);
        await this.initDetailsModel(null, this.controlInstance.getRootPSPanelItems());
        if ((this.controlInstance.getRootPSPanelItems() as any)?.length > 0) {
            this.initRules(this.controlInstance.getRootPSPanelItems());
        }
        this.computedUIData();
        this.computeButtonState(this.data);
        this.panelLogic({ name: '', newVal: null, oldVal: null });
        this.computeParentDataItems();
    }

    /**
     * 初始化值规则
     *
     * @param {(IPSPanelItem[] | null)} panelItems 面板项
     * @memberof PanelControlBase
     */
    public initRules(panelItems: IPSPanelItem[] | null) {
        // 初始化非空值规则和数据类型值规则
        panelItems?.forEach((item: IPSPanelItem) => {
            const panelItem = item as IPSSysPanelContainer;
            if ((panelItem?.getPSPanelItems?.() as any)?.length > 0) {
                this.initRules(panelItem.getPSPanelItems());
            } else {
                const panelItem = item as IPSSysPanelField
                if (panelItem?.getPSEditor?.()) {
                    let editorRules: any = Verify.buildVerConditions(panelItem.getPSEditor());
                    this.rules[panelItem.name] = [
                        // 非空值规则
                        { validator: (rule: any, value: any, callback: any) => { return !(this.layoutDetailsModel[panelItem.name].required && !value) }, message: `${panelItem.caption} 必须填写` },
                        // 编辑器基础值规则
                        ...editorRules
                    ]
                }
            }
        })
    }

    /**
     * 面板部件初始化
     *
     * @memberof MDControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        if (this.viewState) {
            this.panelControlEvent = this.viewState.subscribe(async ({ tag, action, data }: { tag: string, action: string, data: any }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('load', action)) {
                    const dataMode = this.controlInstance.dataMode;
                    if ((dataMode !== 3) && (dataMode !== 4) && (dataMode !== 5)) {
                        await this.computeLoadState(dataMode, data);
                    }
                }
                if (Object.is('refresh', action)) {
                    this.refresh(data);
                }
            });
        }
        // 面板不需要应用全局刷新
        if (this.appStateEvent) {
            this.appStateEvent.unsubscribe();
        }
    }

    /**
     * 初始化表单成员模型
     *
     * @param {(IPSPanelItem[] | null)} panelItems 面板项
     * @memberof PanelControlBase
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
                hasMulParent: hasMulParent,
                panelType: this.panelType
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
                            noprivdisplaymode: (panelButtomItem.getPSUIAction() as IPSDEUIAction)?.noPrivDisplayMode,
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
                await this.initDetailsModel(panelItemModel, (panelItem as any).getPSPanelTabPages?.(), index, hasMulParent);
            }
        }
    }

    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {any[]} [fullargs]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PanelControlBase
     */
    public opendata = (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
        this.$throw(this.$t('app.warn.unopendata'), 'opendata');
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {any[]} [fullargs]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PanelControlBase
     */
    public newdata = (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
        this.$throw(this.$t('app.warn.unnewdata'), 'newdata');
    }

    /**
     * 删除
     *
     * @param {any[]} datas
     * @returns {Promise<any>}
     * @memberof PanelControlBase
     */
    public async remove(datas: any[]): Promise<any> {
        this.$throw(this.$t('app.warn.unremove'), 'remove');
    }

    /**
     * 刷新
     *
     * @param {*} [args]
     * @memberof PanelControlBase
     */
    public async refresh(args?: any) {
        const dataMode = this.controlInstance.dataMode;
        if ((dataMode !== 3) && (dataMode !== 4) && (dataMode !== 5)) {
            await this.computeLoadState(dataMode, args);
        }
    }

    /**
     * 设置面板编辑项值变更
     *
     * @param data 面板数据
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof PanelControlBase
     */
    public onPanelItemValueChange(event: { name: string; value: any }): void {
        if (!event) {
            return;
        }
        const { name, value } = event;
        if (!name || Object.is(name, '')) {
            return;
        }
        this.handleCtrlEvents('onvaluechange', { data: { data: this.data, value: value } }).then((result: boolean) => {
            if (result) {
                this.data[name] = value;
                this.layoutData[name] = value;
                if (this.layoutDetailsModel && this.layoutDetailsModel[name]) {
                    this.layoutDetailsModel[name].setData(value);
                }
                this.panelEditItemChange(name, value);
            }
        });
    }

    /**
     * 面板编辑项值变化
     *
     * @public
     * @param data 面板数据
     * @param property 编辑项名
     * @param value 编辑项值
     * @returns {void}
     * @memberof PanelControlBase
     */
    public panelEditItemChange(property: string, value: any) {
        // 面板数据变化事件
        if (this.getDataItems().length > 0) {
            let modelitem = this.getDataItems().find((item: any) => {
                return item.name === property;
            });
            if (modelitem) {
                this.ctrlEvent({
                    controlname: this.controlInstance.controlType,
                    action: 'panelDataChange',
                    data: { [modelitem.prop]: value },
                });
            }
        }
    }

    /**
     * 分页切换事件
     *
     * @param {string} name 分页名
     * @param {*} $event 回调对象
     * @memberof PanelControlBase
     */
    public handleTabPanelClick(name: string, $event: any) {
        this.layoutDetailsModel[name]?.clickPage($event.name);
    }

    /**
     * 按钮点击事件
     *
     * @param {{ modelJson: any, name: string, event: any }} { modelJson, name, event }
     * @return {*} 
     * @memberof PanelControlBase
     */
    public async buttonClick({ modelJson, name, event }: { modelJson: any, name: string, event: any }) {
        const data = this.layoutData[name];
        const result = await this.handlePanelItemEvent(modelJson.name, name, 'onclick', { value: data, event });
        if (result && result?.hasOwnProperty('srfret') && !result.srfret) {
            return;
        }
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            AppGlobalService.getInstance().executeGlobalUIAction(modelJson.getPSUIAction(), event, this, undefined, undefined);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(`${this.controlInstance.name.toLowerCase()}_${modelJson.name}_click`, event, this, null, this.controlInstance.getPSAppViewLogics());
        }
    }

    /**
     * 处理面板项事件
     *
     * @param {string} tag
     * @param {string} name
     * @param {string} eventName
     * @param {*} [args]
     * @return {*} 
     * @memberof PanelControlBase
     */
    public async handlePanelItemEvent(tag: string, name: string, eventName: string, args?: any) {
        const tempTag: string = `${tag.toLowerCase()}-${eventName.toLowerCase()}`;
        if (this.ctrlTriggerLogicMap.get(tempTag)) {
            if(args?.event){
                args.event.stopPropagation();
            }
            const data = { value: this.layoutDetailsModel[name].getData(), data: this.layoutData };
            if (args && (Object.keys(args).length > 0)) {
                Object.assign(data, args);
            }
            const result = await this.ctrlTriggerLogicMap.get(tempTag).executeAsyncUILogic({ arg: { sender: this, navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: data, args: args }, utils: this.viewCtx, app: this.viewCtx.app, view: this });
            return result;
        }
    }


    /**
     * 面板逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof PanelControlBase
     */
    public panelLogic({ name, newVal, oldVal }: { name: string; newVal: any; oldVal: any }): void {
        const allPanelItemGroupLogic = this.allPanelItemGroupLogic;
        if (allPanelItemGroupLogic.length > 0) {
            allPanelItemGroupLogic.forEach((panelItemGroupLogics: any) => {
                panelItemGroupLogics.forEach((logic: any) => {
                    let relatedNames = logic.getRelatedItemNames() || [];
                    if (Object.is(name, '') || relatedNames.indexOf(name) != -1) {
                        let ret = this.verifyGroupLogic(this.data, logic);
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
     * 计算UI展示数据
     *
     * @param {*} newVal
     * @memberof PanelControlBase
     */
    public async computedUIData(newVal?: any) {
        if (this.controlInstance?.getAllPSPanelFields() && this.getDataItems().length > 0) {
            this.getDataItems().forEach((item: any) => {
                this.$set(this.data, item.name, null);
            });
        }
        const dataMode = this.controlInstance.dataMode;
        if (dataMode === 3) {
            this.viewCtx.appGlobal[this.controlInstance.M.dataName] = this.data;
        } else if (dataMode === 4) {
            this.viewCtx.routeViewGlobal[this.controlInstance.M.dataName] = this.data;
        } else if (dataMode === 5) {
            this.viewCtx.viewGlobal[this.controlInstance.M.dataName] = this.data;
        } else {
            if (this.isLoadDefault) {
                await this.computeLoadState(dataMode);
            }
        }
    }

    /**
     * 计算数据加载模式
     *
     * @memberof PanelControlBase
     */
    public async computeLoadState(dataMode: number, args?: any) {
        if (dataMode === 0) {
            //  0：不获取，使用传入数据
            if (this.navdatas && (this.navdatas.length > 0)) {
                const newItem: any = this.getPanelItems(this.navdatas[0]);
                Util.deepObjectMerge(this.data, newItem);
            }
        } else if (dataMode === 1) {
            //  1：存在传入数据时，不获取
            if (this.navdatas && this.navdatas.length > 0) {
                if (this.navdatas && (this.navdatas.length > 0)) {
                    this.data = this.navdatas[0];
                }
            } else {
                await this.loadPanelData(args);
            }
        } else if (dataMode === 2) {
            //  2：始终获取
            await this.loadPanelData(args);
        }
    }

    /**
     * @description 转换数据项key
     * @param {*} navdatas 要转换的数据项
     * @return {*} 
     * @memberof PanelControlBase
     */
    public getPanelItems(navdatas: any) {
        const newItems: any = {};
        Object.keys(navdatas).forEach((key: string) => {
            const item = this.getDataItems().find((i: any) => i.prop === key);
            if (item) {
                newItems[item.name] = navdatas[key];
            } else {
                newItems[key] = navdatas[key];
            }
        })
        return newItems;
    }

    /**
     * 加载数据
     *
     * @memberof PanelControlBase
     */
    public async loadPanelData(args?: any) {
        const action = this.controlInstance.getGetPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || '';
        if (!action) {
            LogUtil.warn(this.$t('app.viewpanel.nofconfig.getaction'));
        }
        const service = await DataServiceHelp.getInstance().getService(this.controlInstance.getPSAppDataEntity(), { context: this.context }).catch((error: any) => {
            LogUtil.warn(this.$t('app.viewpanel.error.notgetservice'));
        });
        if (!(await this.handleCtrlEvents('onbeforeload', { action: action }))) {
            return;
        }
        if (args && Object.keys(args).length > 0) {
            Object.assign(this.data, args);
        }
        if (service && action) {
            try {
                const response: any = await service.execute(action, Util.deepCopy(this.context), this.data);
                if (response && response.status == 200 && response.data) {
                    if (!(await this.handleCtrlEvents('onloadsuccess', { action: action, data: response.data }))) {
                        return;
                    }
                    this.fillPanelData(response.data);
                } else {
                    if (!(await this.handleCtrlEvents('onloadsuccess', { action: action, data: response.data }))) {
                        return;
                    }
                }
            } catch (response: any) {
                if (!(await this.handleCtrlEvents('onloadsuccess', { action: action, data: response.data }))) {
                    return;
                }
                this.$throw(response, 'load');
            }
        }
    }

    /**
      * 获取数据项集合
      *
      * @returns {any[]}
      * @memberof AppPanelModel
      */
    public getDataItems(): any[] {
        let arr: any = [];
        this.controlInstance.M?.getAllPSPanelFields?.forEach((datafield: any) => {
            let obj: any = {};
            obj.name = datafield?.id?.toLowerCase();
            obj.prop = datafield?.viewFieldName?.toLowerCase();
            arr.push(obj);
        });
        return arr;
    }

    /**
     * 填充面板数据
     *
     * @param {*} data
     * @memberof PanelControlBase
     */
    public fillPanelData(data: any) {
        this.getDataItems().forEach((item: any) => {
            if (item?.prop) {
                this.data[item.name] = data?.[item.prop];
            } else {
                this.data[item.name] = data?.[item.name];
            }
        });
    }

    /**
     * 获取所有代码表
     *
     * @param {Array<any>} codelistArray 代码表模型数组
     * @param {boolean} [reverse=false]
     * @returns {Promise<any>}
     * @memberof PanelControlBase
     */
    public getAllCodeList(codelistArray: Array<any>, reverse: boolean = false): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            let codeListMap: Map<string, any> = new Map();
            let promiseArray: Array<any> = [];
            codelistArray.forEach((item: any) => {
                if (!codeListMap.get(item.tag)) {
                    promiseArray.push(this.getCodeList(item));
                    Promise.all(promiseArray).then((result: any) => {
                        if (result && result.length > 0) {
                            result.forEach((codeList: any) => {
                                let tempCodeListMap: Map<number, any> = new Map();
                                if (codeList.length > 0) {
                                    codeList.forEach((codeListItem: any) => {
                                        if (reverse) {
                                            tempCodeListMap.set(codeListItem.text, codeListItem.value);
                                        } else {
                                            tempCodeListMap.set(codeListItem.value, codeListItem.text);
                                        }
                                    });
                                }
                                codeListMap.set(item.tag, tempCodeListMap);
                            });
                            resolve(codeListMap);
                        }
                    });
                }
            });
        });
    }

    /**
     * 获取代码表
     *
     * @param codeListObject 传入代码表对象
     * @memberof PanelControlBase
     */
    public getCodeList(codeListObject: any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if (codeListObject.tag && Object.is(codeListObject.codelistType, 'STATIC')) {
                const codelist = this.$store.getters.getCodeList(codeListObject.tag);
                if (codelist) {
                    resolve([...JSON.parse(JSON.stringify(codelist.items))]);
                } else {
                    resolve([]);
                }
            } else if (codeListObject.tag && Object.is(codeListObject.codelistType, 'DYNAMIC')) {
                this.codeListService
                    .getItems(codeListObject.tag)
                    .then((res: any) => {
                        resolve(res);
                    })
                    .catch((error: any) => {
                        resolve([]);
                    });
            }
        });
    }

    /**
     * 计算面板按钮权限状态
     *
     * @param {*} data
     * @memberof PanelControlBase
     */
    public computeButtonState(data: any) {
        const targetData: any = this.transformData(data);
        ViewTool.calcActionItemAuthState(targetData, this.actionModel, this.appUIService);
        // 更新detailsModel里的按钮的权限状态值
        if (this.layoutDetailsModel && Object.keys(this.layoutDetailsModel).length > 0) {
            Object.keys(this.layoutDetailsModel).forEach((name: any) => {
                const model = this.layoutDetailsModel[name];
                if (model?.itemType == 'BUTTON' && model.uiaction?.tag) {
                    model.visible = this.actionModel[model.uiaction.tag].visabled;
                    model.disabled = this.actionModel[model.uiaction.tag].disabled;
                    model.isPower = this.actionModel[model.uiaction.tag].dataActionResult === 1 ? true : false;
                }
            });
        }
    }

    /**
     * 初始化界面行为模型
     *
     * @type {*}
     * @memberof GridControlBase
     */
    public initCtrlActionModel() {
        if ((this.controlInstance.getRootPSPanelItems() as any)?.length > 0) {
            this.initItemsActionModel(this.controlInstance.getRootPSPanelItems());
        }
    }

    /**
     * 初始化面板项的界面行为模型
     *
     * @param {any[]} panelItems
     * @memberof PanelControlBase
     */
    public initItemsActionModel(panelItems: IPSPanelItem[] | null) {
        panelItems?.forEach((item: IPSPanelItem) => {
            const panelItem = item as IPSSysPanelContainer;
            const panelButtomItem = item as IPSSysPanelButton;
            if ((panelItem?.getPSPanelItems?.() as any)?.length > 0) {
                this.initItemsActionModel(panelItem.getPSPanelItems());
            } else if (panelItem?.itemType == 'BUTTON' && panelButtomItem.getPSUIAction()) {
                const appUIAction: any = panelButtomItem.getPSUIAction();
                const appUIAction_M = Util.deepCopy(appUIAction.M);
                this.actionModel[appUIAction.uIActionTag] = Object.assign(appUIAction_M, { disabled: false, visabled: true, getNoPrivDisplayMode: appUIAction.noPrivDisplayMode ? appUIAction.noPrivDisplayMode : 6 });
            } else if (item.itemType == 'TABPANEL') {
                const tabPages: IPSPanelTabPage[] = (item as IPSSysPanelTabPanel).getPSPanelTabPages() || [];
                tabPages.forEach((page: IPSPanelTabPage) => {
                    this.initItemsActionModel(page.getPSPanelItems());
                })
            }
        })
    }

    /**
     * 监控数据对象
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PanelControlBase
     */
    public onInputDataChange(newVal: any, oldVal: any) { }

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof PanelControlBase
     */
    public getDatas(): any[] {
        if (!this.data) {
            return [];
        }
        return [this.data];
    }

    /**
     * 获取单项数据
     *
     * @returns
     * @memberof PanelControlBase
     */
    public getData() {
        return this.data;
    }

    /**
     * 计算父容器数据项
     *
     * @param {*} [args]
     * @memberof PanelControlBase
     */
    public computeParentDataItems() {
        const parent: any = this.controlInstance.getParentPSModelObject?.();
        if (
            parent.controlType &&
            (parent.controlType == 'DATAVIEW' || parent.controlType == 'LIST' || parent.controlType == 'KANBAN')
        ) {
            this.needFindDEField = true;
        }
        if (!this.needFindDEField) {
            return;
        }
        switch (parent.controlType) {
            case 'DATAVIEW':
                this.parentDataItems = parent.getPSDEDataViewDataItems?.();
                break;
            case 'LIST':
                this.parentDataItems = parent.getPSDEListDataItems?.();
                break;
            case 'KANBAN':
                this.parentDataItems = parent.getPSDEDataViewDataItems?.();
                break;
        }
    }

    /**
     * 面板属性项查找对应父容器实体实体属性项
     *
     * @returns
     * @memberof PanelControlBase
     */
    public findDEFieldForPanelField(target: any) {
        const parent: any = this.controlInstance.getParentPSModelObject();
        const entity = parent.getPSAppDataEntity?.();
        if (entity && this.parentDataItems.length > 0) {
            const valueItemName = (this.controlInstance.getAllPSPanelFields()?.find((item: any) => Object.is(item.id.toLowerCase(), target.name.toLowerCase())) as any)?.viewFieldName;
            const dataItem = this.parentDataItems.find((item: any) => Object.is(valueItemName?.toLowerCase(), item.name?.toLowerCase()));
            if (dataItem) {
                Object.assign(target, {
                    getPSAppDEField: () => {
                        return dataItem.getPSAppDEField?.();
                    }
                })
            }

        }
    }

    public ctrlDestroyed(){
        super.ctrlDestroyed()
        if(this.panelControlEvent){
            this.panelControlEvent.unsubscribe();
        }
    }
}