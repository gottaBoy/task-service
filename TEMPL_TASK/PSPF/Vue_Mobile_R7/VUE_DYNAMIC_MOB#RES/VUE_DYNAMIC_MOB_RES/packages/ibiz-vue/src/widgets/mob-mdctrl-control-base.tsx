import { ViewTool, ModelTool, MobMdctrlControlInterface, AppServiceBase, Util } from 'ibiz-core';
import { AppMobMDCtrlService } from '../ctrl-service';
import { MDControlBase } from "./md-control-base";
import { AppViewLogicService } from '../app-service';
import { IPSDEMobMDCtrl, IPSAppDataEntity, IPSAppDEField, IPSDEUIAction, IPSUIAction, IPSUIActionGroupDetail, IPSCodeItem, IPSDEListDataItem } from '@ibiz/dynamic-model-api';

/**
 * 多数据部件基类
 *
 * @export
 * @class AppControlBase
 * @extends {MDCtrlControlBase}
 */
export class MobMDCtrlControlBase extends MDControlBase implements MobMdctrlControlInterface {

    /**
     * 菜单部件实例
     * 
     * @memberof MobMDCtrlControlBase
     */
    public declare controlInstance: IPSDEMobMDCtrl;

    /**
     * 初始加载
     *
     * @type {string}
     * @memberof MobMDCtrlControlBase
     */
    public isFirstLoad: boolean = true;

    /**
     * 部件样式
     *
     * @type {string}
     * @memberof MobMDCtrlControlBase
     */
    protected controlStyle!: string | 'ICONVIEW' | 'LISTVIEW' | 'SWIPERVIEW' | 'LISTVIEW2' | 'LISTVIEW3' | 'LISTVIEW4';

    /**
     * 列表模式（列表导航、列表）
     *
     * @type {string}
     * @memberof MobMDCtrlControlBase
     */
    protected listMode?: string | 'LISTEXPBAR' | 'LIST' | 'SELECT';

    /**
     * 列表选中项的索引
     *
     * @type {number}
     * @memberof MobMDCtrlControlBase
     */
    protected sidebarValue: number = 0;

    /**
    * 上级传递的选中项
    * @type {Array}
    * @memberof MobMDCtrlControlBase
    */
    public selectedData?: Array<any>;

    /**
    * 加载显示状态
    *
    * @type {boolean}
    * @memberof MobMDCtrlControlBase
    */
    public loadStatus: boolean = false;

    /**
    * 是否为分组模式
    *
    * @type {boolean}
    * @memberof MobMDCtrlControlBase
    */
    public isEnableGroup: boolean = false;

    /**
     * 分组参数
     *
     * @memberof MobMDCtrlControlBase
     */
    public groupParam: any = {
        group_detail: [],
        group_mode: '',
        group_field: '',
        group_data: '',
    };

    /**
    * 部件排序对象
    *
    * @param {object} 
    * @memberof MobMDCtrlControlBase
    */
    public sortParam: any = { sort: '' };

    /**
    * searchKey 搜索关键字
    *
    * @type {string}
    * @memberof MobMDCtrlControlBase
    */
    public searchKey: string = '';

    /**
     * vant折叠面板数据
     *
     * @memberof MobMDCtrlControlBase
     */
    public activeName: Array<any> = [];

    /**
    * 判断底部数据是否全部加载完成，若为真，则 bottomMethod 不会被再次触发
    *
    * @type {number}
    * @memberof MobMDCtrlControlBase
    */
    get allLoaded() {
        return ((this.curPage + 1) * this.limit) >= this.totalRecord ? true : false;
    }

    /**
    * 列表数组
    *
    * @param {Array<any>}
    * @memberof MobMDCtrlControlBase
    */
    public items: Array<any> = [];

    /**
    * 单选选择值
    *
    * @param {string} 
    * @memberof MobMDCtrlControlBase
    */
    public selectedValue: string = "";

    /**
     * 拦截滚动
     *
     * @memberof MobMDCtrlControlBase
     */
    public captorScroll = false;

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MobMDCtrlControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.listMode = newVal.listMode ? newVal.listMode : "LIST";
        super.onStaticPropsChange(newVal, oldVal);
        this.isSingleSelect = newVal.isSingleSelect;
    }

    /**
     * onScroll滚动事件
     *
     * @memberof ViewBase
     */
    public async onScroll(e: any) {
        if (this.captorScroll) {
            return;
        }
        // 多数据
        let ionScroll: any = this.$refs.ionScroll;
        if (ionScroll) {
            let ele = await ionScroll.getScrollElement();
            if (ele) {
                let scrollTop = ele.scrollTop;
                let clientHeight = ele.clientHeight;
                let scrollHeight = ele.scrollHeight;
                if (scrollHeight > clientHeight && scrollHeight - scrollTop - clientHeight < 1) {
                    this.captorScroll = true;
                    this.loadStatus = true;
                    await this.loadBottom();
                    this.loadStatus = false;
                    this.captorScroll = false;
                }
            }
        }
    }

    /**
     * 上拉加载更多数据
     *
     * @memberof MobMDCtrlControlBase
     */
    public async loadBottom(): Promise<any> {
        if (this.allLoaded) {
            return;
        }
        this.curPage++;
        let params = {};
        if (this.viewparams) {
            Object.assign(params, this.viewparams);
        }
        Object.assign(params, { query: this.searchKey, page: this.curPage, size: this.limit });
        await this.load(params, 'bottom', false);
    }

    /**
     * 删除
     *
     * @param {any[]} datas
     * @returns {Promise<any>}
     * @memberof MobMDCtrlControlBase
     */
    public async remove(datas: any[]): Promise<any> {
        let arg: any = {};
        let keys: Array<string> = [];
        let infoStr: string = '';
        const appDataEntity = this.controlInstance.getPSAppDataEntity() as IPSAppDataEntity;
        datas.forEach((data: any, index: number) => {
            keys.push(data[appDataEntity.codeName.toLowerCase()]);
            if (index < 5) {
                if (!Object.is(infoStr, '')) {
                    infoStr += '、';
                }
                let majorField: any = ModelTool.getAppEntityMajorField(appDataEntity);
                infoStr += data[majorField] || '';
            }
        });
        if (datas.length <= 0) {
            this.$Notice.error(this.$t('app.commonWords.chooseOne'));
            return
        }
        if (datas.length < 5) {
            infoStr = infoStr + this.$t('app.message.totle') + datas.length + this.$t('app.message.data');
        } else {
            infoStr = infoStr + '...' + this.$t('app.message.totle') + datas.length + this.$t('app.message.data');
        }
        return new Promise((resolve, reject) => {
            const _remove = async () => {
                if (!(await this.handleCtrlEvents('onbeforeremove', { action: this.removeAction, data: datas }))) {
                    return;
                }
                let _context: any = { [appDataEntity.codeName.toLowerCase()]: keys.join(';') }
                const response: any = await this.service.delete(this.removeAction, Object.assign({}, this.context, _context), arg, this.showBusyIndicator);
                if (response && response.status === 200) {
                    if (!(await this.handleCtrlEvents('onremovesuccess', { action: this.removeAction, data: datas }))) {
                        return;
                    }
                    this.$Notice.success((this.$t('app.message.deleteSccess') as string));
                    this.load();
                    resolve(response);
                } else {
                    if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, data: datas }))) {
                        return;
                    }
                    this.$Notice.error(response.message ? response.message : (this.$t('app.message.deleteFail') as string));
                    reject(response);
                }
            }
            this.$dialog.confirm({
                title: (this.$t('app.message.warning') as string),
                message: this.$t('app.message.confirmToDelete') + infoStr + ',' + this.$t('app.message.unrecoverable') + '？',
            }).then(() => {
                _remove();
            }).catch(() => {
            });
        });
    }

    /**
     * 刷新数据
     *
     * @returns {Promise<any>}
     * @memberof MobMDCtrlControlBase
     */
    public refresh(): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            this.load().then((res: any) => {
                resolve(res);
            }).catch((error: any) => {
                reject(error);
            })
        })
    }

    /**
     * 快速搜索
     *
     * @param {string} query
     * @returns {Promise<any>}
     * @memberof MobMDCtrlControlBase
     */
    public async quickSearch(query: string): Promise<any> {
        this.searchKey = query;
        this.curPage = 0;
        const response = await this.load(Object.assign({ query: query }, { page: this.curPage, size: this.limit }), "init");
        return response;
    }

    /**
     * 数据加载
     *
     * @private
     * @param {*} [data={}]
     * @param {string} [type=""]
     * @returns {Promise<any>}
     * @memberof MobMDCtrlControlBase
     */
    public async load(data: any = {}, type: string = "", isloadding = this.showBusyIndicator): Promise<any> {
        if (!data.page) {
            Object.assign(data, { page: this.curPage });
        }
        if (!data.size) {
            Object.assign(data, { size: this.limit });
        }
        //部件排序
        if (this.sortParam) {
            Object.assign(data, this.sortParam);
        }
        //视图排序
        if (data?.data?.sort) {
            Object.assign(data, { sort: data.data.sort });
        }
        if (!(await this.handleCtrlEvents('onbeforeload', { action: this.fetchAction, data: data }))) {
            return;
        }
        const parentdata: any = {};
        this.onCtrlEvent(this.controlInstance.name, 'beforeload', parentdata);
        Object.assign(data, parentdata);
        let tempViewParams: any = parentdata.viewparams ? parentdata.viewparams : {};
        // 多实例查询数据处理
        let appEnvironment = AppServiceBase.getInstance().getAppEnvironment();
        if (appEnvironment.bDynamic) {
            if (!tempViewParams.hasOwnProperty("srfinsttag")) {
                Object.assign(tempViewParams, { srfinsttag: "__srfstdinst__" });
            }
        } else {
            if (tempViewParams.hasOwnProperty("srfwf")) {
                Object.assign(tempViewParams, { srfinsttag: "__srfstdinst__" });
            }
        }
        Object.assign(tempViewParams, JSON.parse(JSON.stringify(this.viewparams)));
        Object.assign(data, { viewparams: tempViewParams });
        this.onControlRequset('load', { ...this.context }, data);
        let response: any;
        try {
            response = await this.service.search(this.fetchAction, this.context, data, isloadding);
        } catch (error: any) {
            this.onControlResponse('load', response);
            this.$Notice.error(error?.data?.message || this.$t('app.commonWords.sysException') as string);
        }
        if (!response || response.status !== 200) {
            if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, data: response?.data }))) {
                return;
            }
            this.$Notice.error(response?.error?.message || this.$t('app.commonWords.sysException') as string);
            this.onControlResponse('load', response);
            return response;
        }
        if (!(await this.handleCtrlEvents('onloadsuccess', { action: this.fetchAction, data: response.data }))) {
            return;
        }
        this.onControlResponse('load', response);
        this.onCtrlEvent(this.controlInstance.name, 'load', response.data ? response.data : []);
        this.totalRecord = response.total;
        this.onCtrlEvent(this.controlInstance.name, 'totalRecordChange', this.totalRecord);
        if (type == 'top') {
            this.items = [];
            this.items = response.data;
        } else if (type == 'bottom') {
            for (let i = 0; i < response.data.length; i++) {
                this.items.push(response.data[i]);
            }
        } else {
            this.items = [];
            this.items = response.data;
        }
        this.items.forEach((item: any) => {
            // 计算是否选中
            let index = this.selections.findIndex((temp: any) => { return temp.srfkey == item.srfkey });
            if (index != -1 || Object.is(this.selectedValue, item.srfkey)) {
                item.checked = true;
            } else {
                item.checked = false;
            }
            Object.assign(item, this.getActionState(item));
            // 计算权限   
            this.setSlidingDisabled(item);
        });
        if (this.isEnableGroup) {
            this.group();
        }
        this.isFirstLoad = false;
        return response;
    }

    /**
     * 计算部件所需参数
     *
     * @param {*} controlInstance 部件模型对象
     * @param {*} item 列表行数据
     * @returns
     * @memberof ListControlBase
     */
    public computeTargetCtrlData(controlInstance: any, item?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            navdatas: [item],
        })
        Object.assign(targetCtrlParam.staticProps, {
            transformData: this.transformData,
            isLoadDefault: true,
            opendata: this.opendata,
            newdata: this.newdata,
            remove: this.remove,
            refresh: this.refresh,
            dataMap: this.dataMap,
        })
        targetCtrlEvent['ctrl-event'] = ({ controlname, action, data }: { controlname: string, action: string, data: any }) => {
            this.onCtrlEvent(controlname, action, { item: item, data: data });
        };
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 获取界面行为权限状态
     *
     * @param {*} data 当前列表行数据
     * @memberof MobMDCtrlControlBase
     */
    public getActionState(data: any) {
        let tempActionModel: any = JSON.parse(JSON.stringify(this.actionModel));
        let targetData: any = this.transformData(data);
        ViewTool.calcActionItemAuthState(targetData, tempActionModel, this.appUIService);
        return tempActionModel;
    }

    /**
     * 初始化界面行为模型
     *
     * @type {*}
     * @memberof MobMDCtrlControlBase
     */
    public initCtrlActionModel() {
        if (this.controlInstance.getPSDEUIActionGroup?.() && this.controlInstance.getPSDEUIActionGroup?.()?.getPSUIActionGroupDetails?.()) {
            this.controlInstance.getPSDEUIActionGroup?.()?.getPSUIActionGroupDetails()?.forEach((detail: IPSUIActionGroupDetail) => {
                this.initCtrlActionModelDetail(detail);
            });
        }
        if (this.controlInstance.getPSDEUIActionGroup2?.() && this.controlInstance.getPSDEUIActionGroup2?.()?.getPSUIActionGroupDetails?.()) {
            this.controlInstance.getPSDEUIActionGroup2?.()?.getPSUIActionGroupDetails()?.forEach((detail: IPSUIActionGroupDetail) => {
                this.initCtrlActionModelDetail(detail);
            });
        }
    }

    /**
     * 初始化数据映射
     * 
     * @memberof ListControlBase
     */
    public initDataMap() {
        const dataItems: IPSDEListDataItem[] | null = this.controlInstance.getPSDEListDataItems();
        if (dataItems && dataItems.length > 0) {
            dataItems.forEach((dataItem: IPSDEListDataItem) => {
                this.dataMap.set(dataItem.name, { customCode: dataItem.customCode ? true : false });
            });
        };
    }

    /**
     * 初始化界面行为模型2
     *
     * @type {*}
     * @memberof MobMDCtrlControlBase
     */
    public initCtrlActionModelDetail(detail: IPSUIActionGroupDetail) {
        let item = detail.getPSUIAction() as IPSUIAction;
        let tempData: any = {};
        tempData.name = item.uIActionTag;
        tempData.disabled = false;
        tempData.visabled = true;
        tempData.noprivdisplaymode = (item as IPSDEUIAction)?.noPrivDisplayMode;
        tempData.dataaccaction = item?.dataAccessAction;
        tempData.target = item?.actionTarget;
        tempData.icon = item?.getPSSysImage()?.cssClass;
        tempData.isShowCaption = true;
        tempData.isShowIcon = true;
        if (this.controlInstance.getPSDEUIActionGroup2?.() && this.controlInstance.getPSDEUIActionGroup2?.()?.getPSUIActionGroupDetails()) {
            this.controlInstance.getPSDEUIActionGroup2?.()?.getPSUIActionGroupDetails()?.forEach((action: IPSUIActionGroupDetail) => {
                if (action.getPSUIAction()?.codeName == item.codeName) {
                    tempData.isShowCaption = action.showCaption;
                    tempData.isShowIcon = action.showIcon;
                }
            });
        }
        this.actionModel[item.uIActionTag] = tempData;
    }

    /**
    * 判断列表项左滑右滑禁用状态
    *
    * @memberof MobMDCtrlControlBase
    */
    public setSlidingDisabled(item: any) {
        item.sliding_disabled = true;
        Object.keys(this.actionModel).forEach((key, index) => {
            if (item[key].visabled && item.sliding_disabled) {
                item.sliding_disabled = false;
            }
        })

    }

    /**
     * 列表项左滑右滑触发行为
     *
     * @param {*} $event 点击鼠标事件源
     * @param {*} detail 界面行为模型对象
     * @param {*} item 行数据
     * @memberof MobMDCtrlControlBase
     */
    public mdctrl_click($event: any, detail: any, item: any): void {
        $event.stopPropagation();
        this.handleActionClick(item, $event, detail);
    }

    /**
     * 处理操作列点击
     * 
     * @param {*} data 当前列数据
     * @param {*} event 事件源
     * @param {*} detail 界面行为模型对象
     * @memberof MobMobMDCtrlControlBase
     */
    public handleActionClick(data: any, $event: any, detail: any) {
        const { name } = this.controlInstance;
        const getPSAppViewLogics = this.controlInstance.getPSAppViewLogics();
        AppViewLogicService.getInstance().executeViewLogic(`${name}_${detail.name}_click`, $event, this, data, getPSAppViewLogics);
    }

    /**
     * 下拉刷新
     *
     * @returns {Promise<any>}
     * @memberof MobMDCtrlControlBase
     */
    public async pullDownToRefresh(): Promise<any> {
        this.curPage = 0;
        let params = {};
        if (this.viewparams) {
            Object.assign(params, this.viewparams);
        }
        Object.assign(params, { query: this.searchKey, curPage: this.curPage, limit: this.limit });
        let response: any;
        try {
            this.isLoadding = true;
            response = await this.load(params, 'top');
            this.isLoadding = false;
        } catch (error) {
            this.isLoadding = false;
        }
        return response;
    }

    /**
     * 点击回调事件
     *
     * @param {*} item 点击数据
     * @memberof MobMDCtrlControlBase
     */
    public item_click(item: any) {
        if (Object.is(this.listMode, 'SELECT')) {
            let count = this.selections.findIndex((i) => {
                return i.mobentityid == item.mobentityid;
            });
            if (count === -1) {
                this.selections.push(item);
            } else {
                this.selections.splice(count, 1);
            }
        } else {
            this.goPage(item);
            this.onSimpleSelChange(item);
        }
    }

    /**
     * 点击列表数据跳转
     *
     * @param {*} item 点击数据
     * @memberof MobMDCtrlControlBase
     */
    public goPage(item: any) {
        this.$emit('ctrl-event', { controlname: this.controlInstance.name, action: "rowclick", data: item });
    }

    /**
     * 多数据部件初始化
     *
     * @memberof MobMDCtrlControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(this.name, tag)) {
                    return;
                }
                if (Object.is(action, "load")) {
                    this.curPage = 0;
                    this.load(Object.assign(data, { page: this.curPage, size: this.limit }), "init");
                }
                if (Object.is(action, "search")) {
                    this.curPage = 0;
                    this.load(Object.assign(data, { page: this.curPage, size: this.limit }), "init");
                }
                if (Object.is(action, "quicksearch")) {
                    this.quickSearch(data);
                }
                if (Object.is(action, "refresh")) {
                    this.refresh();
                }
                if (Object.is(action, "save")) {
                    this.ctrlEvent({
                        controlname: this.controlInstance.name,
                        action: 'save',
                        data: this.getDatas(),
                    });
                }
            });
        }
    }

    /**
     * 单选选中变化
     * 
     * @memberof MobMDCtrlControlBase
     */
    public async onSimpleSelChange(item: any = {}) {
        if (!(await this.handleCtrlEvents('onselectionchange', { action: this.loadAction, data: [item] }))) {
            return;
        }
        this.onCtrlEvent(this.controlInstance.name, 'selectionchange', [item]);
        this.selectedValue = item.srfkey;
        this.selections = [];
    }

    /**
     * 选项框改变
     *
     * @param {*} data
     * @return {*} 
     * @memberof MobMDCtrlControlBase
     */
    public async selectionchange(data: any) {
        let { detail } = data;
        if (!detail) {
            return;
        }
        let { value } = detail;
        const selectItem = this.items.find((item: any) => { return Object.is(item.srfkey, value) });
        if (detail.checked) {
            this.selections.push(selectItem);
        } else {
            const index = this.selections.findIndex((i: any) => { return i.srfkey === selectItem.srfkey })
            if (index != -1) {
                this.selections.splice(index, 1);
            }
        }
        if (!(await this.handleCtrlEvents('onselectionchange', { action: this.loadAction, data: this.selections }))) {
            return;
        }
        this.onCtrlEvent(this.controlInstance.name, 'selectionchange', this.selections);
    }

    /**
      * 部件模型数据初始化实例
      *
      * @memberof MobMDCtrlControlBase
      */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        if (!(this.Environment?.isPreviewMode)) {
            this.service = new AppMobMDCtrlService(this.controlInstance, this.context, { localSourceTag: this.localSourceTag });
            await this.service.loaded(this.controlInstance);
        }
        this.initSort();
        // 分组一系列属性
        this.isEnableGroup = this.controlInstance?.enableGroup;
        this.groupParam.group_mode = this.controlInstance?.groupMode;
        this.initGroupField();
        this.initGroupDetail();
        this.limit = this.controlInstance.pagingSize;
    }

    /**
     * 初始化代码表分组细节
     * 
     * @memberof MobMDCtrlControlBase
     */
    public initGroupDetail() {
        if (this.controlInstance?.getGroupPSCodeList?.() && this.controlInstance?.getGroupPSCodeList?.()?.getPSCodeItems?.()) {
            const codelist = this.controlInstance?.getGroupPSCodeList?.()?.getPSCodeItems?.();
            if (codelist?.length) {
                codelist.forEach((item: IPSCodeItem) => {
                    if (item.value && item.text) {
                        this.groupParam.group_detail.push({
                            value: item.value,
                            text: item.text
                        })
                    }
                });
            }
        }
    }

    /**
     * 初始化分组标识
     * 
     * @memberof MobMDCtrlControlBase
     */
    public initGroupField() {
        if (this.controlInstance?.getGroupPSAppDEField()?.codeName) {
            this.groupParam.group_field = this.controlInstance?.getGroupPSAppDEField()?.codeName.toLowerCase() as string;
        }
    }

    /**
     * 初始化排序模型数据
     * 
     * @memberof MobMDCtrlControlBase
     */
    public initSort() {
        if (!this.controlInstance.noSort && this.controlInstance.getMinorSortPSAppDEField?.()) {
            let sortableField = this.controlInstance.getMinorSortPSAppDEField() as IPSAppDEField;
            if (sortableField.name) {
                this.sortParam.sort = sortableField.name.toLowerCase() + ',';
            }
            if (this.controlInstance.minorSortDir) {
                let sortDir = this.controlInstance.minorSortDir.toLowerCase();
                this.sortParam.sort += sortDir;
            }
        }
    }

    /**
     * 列表切换回调
     * @param {number} listIndex
     * @memberof MobMDCtrlControlBase
     */
    public switchView(listIndex: number) {
        this.items.findIndex((item, index) => {
            if (index === listIndex) {
                this.onCtrlEvent(this.controlInstance.name, "selectionchange", [item]);
            }
        })
    }

    /**
     * 分组方法
     *
     * @memberof MobMDCtrlControlBase
     */
    public group() {
        if (this.getGroupDataByCodeList && this.getGroupDataByCodeList instanceof Function && Object.is(this.groupParam.group_mode, "CODELIST")) {
            this.getGroupDataByCodeList(this.items);
        } else if (this.getGroupDataAuto && this.getGroupDataAuto instanceof Function && Object.is(this.groupParam.group_mode, "AUTO")) {
            this.getGroupDataAuto(this.items);
        }
    }

    /**
     * 代码表分组，获取分组数据
     *
     * @memberof MobMDCtrlControlBase
     */
    public getGroupDataByCodeList(items: any) {
        let group: Array<any> = [];
        this.groupParam.group_detail.forEach((obj: any, index: number) => {
            let data: any = [];
            items.forEach((item: any, i: number) => {
                if (item[this.groupParam.group_field] === obj.value) {
                    data.push(item);
                }
            })
            group.push(data);
        })
        group.forEach((arr: any, index: number) => {
            this.groupParam.group_data[index] = {};
            this.groupParam.group_data[index].text = this.groupParam.group_detail[index].text;
            this.groupParam.group_data[index].items = arr;
        })
        this.groupParam.group_data.forEach((item: any, i: number) => {
            if (item.items.length == 0) {
                this.groupParam.group_data.splice(i, 1);
            }
        })
    }

    /**
     * 
     * 自动分组，获取分组数据
     *
     * @memberof MobMDCtrlControlBase
     */
    public getGroupDataAuto(items: any) {
        let groups: Array<any> = [];
        items.forEach((item: any) => {
            if (item.hasOwnProperty(this.groupParam.group_field)) {
                groups.push(item[this.groupParam.group_field]);
            }
        })
        groups = [...new Set(groups)];
        groups.forEach((group: any, index: number) => {
            this.groupParam.group_data[index] = {};
            this.groupParam.group_data[index].items = [];
            items.forEach((item: any, i: number) => {
                if (group == item[this.groupParam.group_field]) {
                    this.groupParam.group_data[index].text = group;
                    this.groupParam.group_data[index].items.push(item);
                }
            })
        })
    }


    /**
     * 部件事件
     *
     * @param {string} controlname
     * @param {string} action
     * @param {*} data
     * @memberof MobMDCtrlControlBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (action == 'panelDataChange') {
            const { data: _data, item } = data;
            const index = this.items.findIndex((_item: any) => { return item.srfkey === _item.srfkey });
            if (index == -1) {
                return;
            }
            for (const key in _data) {
                const value: any = _data[key];
                this.items[index][key] = value;
            }
            this.items[index].rowDataState = 'update';
        } else if (action == 'controlIsMounted') {
            this.setIsMounted(controlname);
        } else {
            this.ctrlEvent({ controlname, action, data });
        }
    }


    /**
     *
     *
     * @return {*} 
     * @memberof MobMDCtrlControlBase
     */
    public async save() {
        const _this: any = this;
        const appDeCodeName: any = this.controlInstance.getPSAppDataEntity()?.codeName;
        for (const item of _this.items) {
            try {
                if (Object.is(item.rowDataState, 'update')) {
                    if (!this.updateAction) {
                        return;
                    } else {
                        const _item:any = {};
                        Object.assign(_item,item, { viewparams: this.viewparams });
                        if (_item[appDeCodeName?.toLowerCase()]) {
                            Object.assign(this.context, { [appDeCodeName?.toLowerCase()]: _item[appDeCodeName?.toLowerCase()] });
                        }
                        let tempContext: any = Util.deepCopy(this.context);
                        this.onControlRequset('update', tempContext, _item);
                        let response = await this.service.update(this.updateAction, tempContext, _item, this.showBusyIndicator);
                        this.onControlResponse('update', response);
                    }
                }
            } catch (error) {
                this.onControlResponse('save', error);
            }
        }
    }
}