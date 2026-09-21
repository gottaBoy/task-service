import { IPSPanelContainer } from '@ibiz/dynamic-model-api';
import { AppServiceBase } from '../../service';
import { LogUtil, ModelTool } from '../../utils';
import { PanelDetailModel } from './panel-detail';

/**
 * 面板容器模型
 *
 * @export
 * @class PanelContainerModel
 * @extends {PanelDetailModel}
 */
export class PanelContainerModel extends PanelDetailModel {

    /**
     * 数据区域类型
     * @description 值模式 [数据面板模式] {NONE：无、 LOGINFORM：登录表单、 SINGLEDATA：单项数据、 MULTIDATA：多项数据、 INHERIT：继承、 USER：用户自定义 }
     * @type {( string | 'NONE' | 'LOGINFORM' | 'SINGLEDATA' | 'MULTIDATA' | 'INHERIT' | 'USER')} 
     * @default INHERIT
     */
    public dataRegionType: string | 'NONE' | 'LOGINFORM' | 'SINGLEDATA' | 'MULTIDATA' | 'INHERIT' | 'USER' = 'NONE';

    /**
     * 数据源类型
     * @description 值模式 [数据面板源（全部）] {DEACTION：实体行为、 DEDATASET：实体集合、 DELOGIC：实体逻辑 }
     * @type {( string | 'DEACTION' | 'DEDATASET' | 'DELOGIC')} 
     */
    public dataSourceType: string | 'DEACTION' | 'DEDATASET' | 'DELOGIC' = '';

    /**
     * 数据刷新模式
     * @type {number}
     * @default -1
     */
    public reloadTimer: number = -1;

    /**
     * Creates an instance of PanelContainerModel.
     * @param {*} [opts={}]
     * @memberof PanelContainerModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.dataRegionType = (this.panelItemModel as IPSPanelContainer)?.dataRegionType;
        this.dataSourceType = (this.panelItemModel as IPSPanelContainer)?.dataSourceType;
        this.dataSourceTag = this.getDataSourceTag();
        this.setItemContext();
    }

    /**
     * 获取数据域标识
     *
     * @memberof PanelContainerModel
     */
    public getDataSourceTag() {
        switch (this.dataRegionType) {
            case 'LOGINFORM':
                return 'LOGINFORM';
            case 'SINGLEDATA':
            case 'MULTIDATA':
                return `${this.context?.srfsessionid}:${this.dataRegionType}:${this.name}`;
            case 'INHERIT':
                if (this.parentItem) {
                    if (Object.is(this.parentItem?.dataRegionType, 'SINGLEDATA')) {
                        return this.parentItem.dataSourceTag;
                    } else if (Object.is(this.parentItem?.dataRegionType, 'MULTIDATA')) {
                        return `${this.parentItem.dataSourceTag}:${this.$index}`;
                    } else if (Object.is(this.parentItem?.dataRegionType, 'INHERIT')) {
                        return this.parentItem.getDataSourceTag();
                    }
                }
            default:
                return;
        }
    }

    /**
     * 设置项上下文
     *
     * @memberof PanelContainerModel
     */
    public setItemContext() {
        if (this.dataRegionType && Object.is(this.dataRegionType, 'INHERIT')) {
            if (this.parentItem && this.parentItem.dataRegionType === 'MULTIDATA' && this.parentItem['data']?.length > 0) {
                const data = this.parentItem['data'][this.$index];
                if (this.context && Object.keys(this.context).length > 0 && data && Object.keys(data).length > 0) {
                    const parentAppDataEntity = (this.parentItem.panelItemModel as IPSPanelContainer)?.getPSAppDataEntity?.();
                    const key = (parentAppDataEntity?.codeName as string)?.toLowerCase();
                    const value = data[(ModelTool.getAppEntityKeyField(parentAppDataEntity)?.codeName as string)?.toLowerCase()];
                    Object.assign(this.context, { [key]: value });
                }
            }
        }
    }

    /**
     * 执行异步逻辑
     *
     * @memberof PanelContainerModel
     */
    public async loaded() {
        this.handleLoadedBefore();
        let nullData = {};
        switch (this.dataRegionType) {
            case 'LOGINFORM':
                this.data = nullData;
                AppServiceBase.getInstance().setDataAreaState(this.dataSourceTag, nullData);
                break;
            case 'INHERIT':
                if (!this.parentItem) {
                    if (this.panelType === 'VIEWLAYOUTPANEL') {
                        this.data = nullData;
                    } else {
                        this.data = this.panel?.data || nullData;
                    }
                } else {
                    if (this.parentItem.dataRegionType === 'MULTIDATA' && this.parentItem['data']?.length > 0) {
                        this.data = this.parentItem['data'][this.$index];
                    } else {
                        this.data = this.parentItem.data;
                    }
                }
                break;
            case 'SINGLEDATA':
            case 'MULTIDATA':
                this.data = await this.loadData();
                AppServiceBase.getInstance().setDataAreaState(this.dataSourceTag, this.data);
                break;
            default:
                LogUtil.log(`${this.dataRegionType}数据域未实现`);
                break;
        }
        this.handleLoadedAfter();
    }

    /**
     * 加载数据
     *
     * @memberof PanelContainerModel
     */
    public async loadData(): Promise<any> {
        const deCodeName = (this.panelItemModel as IPSPanelContainer)?.getPSAppDataEntity?.()?.codeName;
        try {
            if (this.dataSourceType === 'DEACTION' || this.dataSourceType === 'DEDATASET') {
                const method = (this.panelItemModel as IPSPanelContainer)?.getPSAppDEMethod?.()?.codeName;
                if (deCodeName && method) {
                    const service = await (window as any).___ibz___.gs.getService(deCodeName);
                    if (service && service[method] instanceof Function) {
                        const response = await service[method](this.context, this.viewparams);
                        if (response && response.status === 200) {
                            return response.data;
                        }
                    }
                }
            } else if (this.dataSourceType === 'DELOGIC') {
                const deLogicTag = (this.panelItemModel as IPSPanelContainer).getPSAppDELogic?.()?.codeName;
                if (deCodeName && deLogicTag) {
                    const service = await (window as any).___ibz___.gs.getService(deCodeName);
                    if (service && service.executeAppDELogic instanceof Function) {
                        const data = await service.executeAppDELogic(deLogicTag, this.context, this.viewparams);
                        return data;
                    }
                }
            }
        } catch (error) {
            LogUtil.error(`面板--- ${this.caption} ---加载数据失败`);
        }
        return {};
    }

    /**
     * 设置数据
     *
     * @param {*} val
     * @memberof PanelContainerModel
     */
    public setData(val: any) {
        const { name, value } = val;
        Object.assign(this.data, { [name]: value });
        if (Object.is(this.dataRegionType, 'LOGINFORM') || Object.is(this.dataRegionType, 'SINGLEDATA') || Object.is(this.dataRegionType, 'MULTIDATA')) {
            AppServiceBase.getInstance().setDataAreaState(this.dataSourceTag, this.data);
        } else if (Object.is(this.dataRegionType, 'INHERIT')) {
            if (!this.parentItem) {
                return;
            } else {
                this.parentItem.setData(val);
            }
        }
    }

    /**
     * 获取数据
     *
     * @return {*} 
     * @memberof PanelContainerModel
     */
    public getData() {
        if (Object.is(this.dataRegionType, 'INHERIT')) {
            if (!this.parentItem) {
                return this.data;
            } else {
                return this.parentItem.getData();
            }
        } else {
            return this.data;
        }
    }

    /**
     * 重置当前项数据
     * 
     * @memberof PanelContainerModel
     */
    public reSetData() {
        switch (this.dataRegionType) {
            case 'LOGINFORM':
            case 'SINGLEDATA':
                this.data = {};
                AppServiceBase.getInstance().setDataAreaState(this.dataSourceTag, this.data);
                break;
            case 'INHERIT':
            case 'USER':
                this.data = {};
                break;
            case 'MULTIDATA':
                this.data = [];
                AppServiceBase.getInstance().setDataAreaState(this.dataSourceTag, this.data);
                break;
            default:
                this.data = {};
                break;
        }
    }

    /**
     * 刷新当前数据域
     *
     * @memberof PanelContainerModel
     */
    public async refreshDataArea() {
        if (this.dataRegionType && (Object.is(this.dataRegionType, 'LOGINFORM') || Object.is(this.dataRegionType, 'SINGLEDATA') || Object.is(this.dataRegionType, 'MULTIDATA'))) {
            this.refresh();
        } else {
            if (this.parentItem && this.parentItem.refreshDataArea && (this.parentItem.refreshDataArea instanceof Function)) {
                this.parentItem.refreshDataArea();
            }
        }
    }

    /**
     * 刷新
     *
     * @memberof PanelContainerModel
     */
    public async refresh() {
        try {
            const oldData = this.getData();
            const panelModelDetails = this.panel.layoutDetailsModel;
            const panelData = this.panel.layoutData;
            await this.setNewUIData(this.name, panelModelDetails, panelData, oldData);
        } catch (error) {
            LogUtil.error(error);
        }
    }

    /**
     * 设置UI绑定新数据
     */
    public async setNewUIData(name: string, modelDetails: any, UIData: any, oldData: any, index: number = 0) {
        // 设置自身数据
        await modelDetails[name].loaded();
        UIData[name] = modelDetails[name].getData();
        LogUtil.log(`设置面板${name}数据项`);
        // 处理多数据域
        if (this.dataRegionType && Object.is(this.dataRegionType, 'MULTIDATA')) {
            const newData = modelDetails[name].getData();
            // 新老数据都不存在,不做处理
            if (((Array.isArray(oldData) && oldData.length === 0) || !oldData || (oldData && Object.keys(oldData).length === 0)) &&
                ((Array.isArray(newData) && newData.length === 0) || !newData || (newData && Object.keys(newData).length === 0))
            ) {
                return;
            }
            // 老数据不存在，新数据存在,初始化新增数据
            if (((Array.isArray(oldData) && oldData.length === 0) || !oldData || (oldData && Object.keys(oldData).length === 0)) &&
                ((Array.isArray(newData) && newData.length > 0) || (newData && Object.keys(newData).length > 0))
            ) {
                for (let index = 0; index <= newData.length - 1; index++) {
                    await this.panel.initDetailsModelItem(this, (this.panelItemModel as any)?.getPSPanelItems?.(), index, true);
                }
            }
            // 老数据存在，新数据不存在
            if (((Array.isArray(oldData) && oldData.length > 0) || (oldData && Object.keys(oldData).length > 0)) &&
                ((Array.isArray(newData) && newData.length === 0) || !newData || (newData && Object.keys(newData).length === 0))
            ) {
                for (let index = 0; index <= oldData.length - 1; index++) {
                    const childPanelItems = (modelDetails[name].panelItemModel as any).getPSPanelItems?.();
                    if (childPanelItems && childPanelItems.length > 0) {
                        for (let i = 0; i < childPanelItems.length; i++) {
                            const item = childPanelItems[i];
                            await this.removeUIData(`${item.name}`, modelDetails, UIData, index);
                        }
                    }
                    const panelTabPages = (modelDetails[name].panelItemModel as any).getPSPanelTabPages?.();
                    if (panelTabPages && panelTabPages.length > 0) {
                        for (let i = 0; i < panelTabPages.length; i++) {
                            const item = panelTabPages[i];
                            await this.removeUIData(`${item.name}`, modelDetails, UIData, index);
                        }
                    }
                }
            }
            // 新老数据都存在
            if (((Array.isArray(oldData) && oldData.length > 0) || (oldData && Object.keys(oldData).length > 0)) &&
                ((Array.isArray(newData) && newData.length > 0) || (newData && Object.keys(newData).length > 0))
            ) {
                for (let index = 0; index <= newData.length - 1; index++) {
                    const childPanelItems = (modelDetails[name].panelItemModel as any).getPSPanelItems?.();
                    if (childPanelItems && childPanelItems.length > 0) {
                        for (let i = 0; i < childPanelItems.length; i++) {
                            const item = childPanelItems[i];
                            await this.updateUIData(item.name, modelDetails, UIData, modelDetails[name], index);
                        }
                    }
                    const panelTabPages = (modelDetails[name].panelItemModel as any).getPSPanelTabPages?.();
                    if (panelTabPages && panelTabPages.length > 0) {
                        for (let i = 0; i < panelTabPages.length; i++) {
                            const item = panelTabPages[i];
                            await this.updateUIData(item.name, modelDetails, UIData, modelDetails[name], index);
                        }
                    }
                }
            }
        } else {
            // 设置子数据
            const childPanelItems = (modelDetails[name].panelItemModel as any).getPSPanelItems?.();
            if (childPanelItems && childPanelItems.length > 0) {
                for (let i = 0; i < childPanelItems.length; i++) {
                    const item = childPanelItems[i];
                    this.setNewUIData(item.name, modelDetails, UIData, oldData);
                }
            }
            const panelTabPages = (modelDetails[name].panelItemModel as any).getPSPanelTabPages?.();
            if (panelTabPages && panelTabPages.length > 0) {
                for (let i = 0; i < panelTabPages.length; i++) {
                    const item = panelTabPages[i];
                    this.setNewUIData(item.name, modelDetails, UIData, oldData);
                }
            }
        }
    }

    /**
     * 清除UI绑定数据
     * 
     * @param name 名称
     * @param modelDetails 构建的模型对象，对应layouDetailsModel
     * @param UIData UI数据，对应viewLayoutData
     * @param index 数据下标
     * 
     */
    private async removeUIData(name: string, modelDetails: any, UIData: any, index: number) {
        // 清除子数据
        const childPanelItems = (modelDetails[`${name}_${index}`].panelItemModel as any).getPSPanelItems?.();
        if (childPanelItems && childPanelItems.length > 0) {
            for (let i = 0; i < childPanelItems.length; i++) {
                const item = childPanelItems[i];
                this.removeUIData(`${item.name}`, modelDetails, UIData, index);
            }
        }
        const panelTabPages = (modelDetails[`${name}_${index}`].panelItemModel as any).getPSPanelTabPages?.();
        if (panelTabPages && panelTabPages.length > 0) {
            for (let i = 0; i < panelTabPages.length; i++) {
                const item = panelTabPages[i];
                this.removeUIData(`${item.name}`, modelDetails, UIData, index);
            }
        }
        // 清除自身数据
        delete modelDetails[`${name}_${index}`];
        delete UIData[`${name}_${index}`];
        LogUtil.log(`删除面板${name}_${index}数据项`);
    }

    /**
     * 更新UI绑定数据
     * 
     * @param name 名称
     * @param modelDetails 构建的模型对象，对应layouDetailsModel
     * @param UIData UI数据，对应viewLayoutData
     * @param index 数据下标
     * 
     */
    private async updateUIData(name: string, modelDetails: any, UIData: any, parentItem: any, index: number) {
        // 老数据存在
        if (modelDetails[`${name}_${index}`]) {
            await modelDetails[`${name}_${index}`].loaded();
            UIData[`${name}_${index}`] = modelDetails[`${name}_${index}`].getData();
            const childPanelItems = (modelDetails[`${name}_${index}`].panelItemModel as any).getPSPanelItems?.();
            if (childPanelItems && childPanelItems.length > 0) {
                for (let i = 0; i < childPanelItems.length; i++) {
                    const item = childPanelItems[i];
                    this.updateUIData(item.name, modelDetails, UIData, parentItem, index);
                }
            }
            const panelTabPages = (modelDetails[`${name}_${index}`].panelItemModel as any).getPSPanelTabPages?.();
            if (panelTabPages && panelTabPages.length > 0) {
                for (let i = 0; i < panelTabPages.length; i++) {
                    const item = panelTabPages[i];
                    this.updateUIData(item.name, modelDetails, UIData, parentItem, index);
                }
            }
            LogUtil.log(`更新面板${name}_${index}数据项`);
        } else {
            // 老数据不存在    
            await this.panel.initDetailsModelItem(parentItem, (parentItem.panelItemModel as any)?.getPSPanelItems?.(), index, true);
            LogUtil.log(`新建面板${name}_${index}数据项`);
        }
    }

    /**
     * 加载之前
     *
     * @protected
     * @memberof PanelContainerModel
     */
    protected handleLoadedBefore() {
        if (this.dataRegionType !== 'SINGLEDATA' && this.dataRegionType !== 'MULTIDATA') {
            return;
        }
        const layoutLoadingService = this.panel?.layoutLoadingService;
        if (layoutLoadingService) {
            const loadingService: any = layoutLoadingService.getCLService(this.hasMulParent ? `${this.name}_${this.$index}` : this.name);
            if (loadingService) {
                loadingService.beginLoading(`.${this.panelType.toLowerCase()}-${this.panelItemModel?.itemType.toLowerCase()}-${this.panelItemModel?.name.toLowerCase()}`);
            }
        }
    }

    /**
     * 加载之后
     *
     * @protected
     * @memberof PanelContainerModel
     */
    protected handleLoadedAfter() {
        if (this.dataRegionType !== 'SINGLEDATA' && this.dataRegionType !== 'MULTIDATA') {
            return;
        }
        const layoutLoadingService = this.panel?.layoutLoadingService;
        if (layoutLoadingService) {
            const loadingService: any = layoutLoadingService.getCLService(this.hasMulParent ? `${this.name}_${this.$index}` : this.name);
            if (loadingService) {
                loadingService.endLoading(`.${this.panelType.toLowerCase()}-${this.panelItemModel?.itemType.toLowerCase()}-${this.panelItemModel?.name.toLowerCase()}`);
            }
        }
    }

}