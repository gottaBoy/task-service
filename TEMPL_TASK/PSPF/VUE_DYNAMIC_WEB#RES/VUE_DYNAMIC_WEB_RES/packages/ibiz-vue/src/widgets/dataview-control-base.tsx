import { notNilEmpty } from 'qx-util';
import { ViewTool, Util, LogUtil, throttle, DataViewControlInterface, AppServiceBase } from 'ibiz-core';
import {
    IPSDEDataView,
    IPSDEDataViewItem,
    IPSDEDataViewDataItem
} from '@ibiz/dynamic-model-api';
import { MDControlBase } from './md-control-base';
import { AppDataViewService } from '../ctrl-service';
import { AppGlobalService, AppViewLogicService } from '../app-service';
import { Subscription } from 'rxjs';

/**
 * 数据视图部件基类
 *
 * @export
 * @class DataViewControlBase
 * @extends {MDControlBase}
 */
export class DataViewControlBase extends MDControlBase implements DataViewControlInterface {
    /**
     * 部件行为--submit
     *
     * @type {*}
     * @memberof DataViewControlBase
     */
    public WFSubmitAction?: any;

    /**
     * 部件行为--start
     *
     * @type {*}
     * @memberof DataViewControlBase
     */
    public WFStartAction?: any;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public declare isSingleSelect: boolean;

    /**
     * 数据视图模型实例
     *
     * @type {*}
     * @memberof DataViewControlBase
     */
    public declare controlInstance: IPSDEDataView;

    /**
     * 分组属性
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public groupAppField: string = '';

    /**
     * 分组属性代码表标识
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public groupAppFieldCodelistTag: string = '';

    /**
     * 分组属性是否配置代码表
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public groupFieldCodelist: boolean = false;

    /**
     * 分组属性代码表类型
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public groupAppFieldCodelistType: string = '';

    /**
     * 分组代码表标识
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public codelistTag: string = '';

    /**
     * 分组代码表类型
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public codelistType: string = '';

    /**
     * 分组数据
     *
     * @type {*}
     * @memberof DataViewControlBase
     */
    public groupData: Array<any> = [];

    /**
     * 分组模式
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public groupMode: string = '';

    /**
     * 分组代码表
     *
     * @type {string}
     * @memberof DataViewControlBase
     */

    public groupCodeListParams?: any;

    /**
     * 加载的数据是否附加在items之后
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public isAddBehind: boolean = false;

    /**
     * 是否启用分组
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public isEnableGroup: boolean = false;

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof DataViewControlBase
     */

    public sortField: string = '';

    /**
     * 排序模型数据集
     *
     * @type {string}
     * @memberof DataViewControlBase
     */

    public sortModel: any[] = [];

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof DataViewControlBase
     */
    public sortDir: string = '';

    /**
     * 默认隐藏批量操作工具栏
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public flag: boolean = false;

    /**
     * 是否显示排序栏
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public hasSortBar: boolean = false;

    /**
     * this引用
     *
     * @type {number}
     * @memberof DataViewControlBase
     */
    public thisRef: any = this;

    /**
     * 拖拽元素对象
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public dragEle: any;

    /**
     * 拖拽后位置left
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public leftP: any;

    /**
     * 拖拽后位置top
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public topP: any;

    /**
     * 拖拽标识
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public dragflag: boolean = false;

    /**
     * 为拖拽不是点击
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public moveflag: boolean = false;

    /**
     * 分组展开项
     *
     * @type {string[]}
     * @memberof DataViewControlBase
     */
    public activeName: string[] = [];

    /**
     * 允许分页栏
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public enablePagingBar: boolean = false;

    /**
     * 允许排序
     *
     * @type {boolean}
     * @memberof DataViewControlBase
     */
    public enableSort: boolean = false;

    /**
     * @description 数据视图部件事件
     * @type {(Subscription | undefined)}
     * @memberof DataViewControlBase
     */
    public dataviewControlEvent: Subscription | undefined;

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DataViewControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect !== false;
        this.isSelectFirstDefault = newVal.isSelectFirstDefault;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 部件模型初始化
     *
     * @memberof DataViewControlBase
     */
    public async ctrlModelInit() {
        super.ctrlModelInit();
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.service = new AppDataViewService(this.controlInstance, this.context, { localSourceTag: this.localSourceTag });
            await this.service.loaded();
        }
        this.initSortModel();
        const m = this.controlInstance;
        this.sortField = m.getMinorSortPSAppDEField()?.codeName?.toLowerCase() as string;
        this.sortDir = m.minorSortDir?.toLowerCase();
        this.isEnableGroup = m.enableGroup ? true : false;
        this.groupMode = m.groupMode;
        this.groupAppField = m.getGroupPSAppDEField()?.codeName.toLowerCase() || '';
        // 代码表参数
        const codeList = m.getGroupPSCodeList();
        if (codeList) {
            this.groupCodeListParams = {
                type: codeList.codeListType,
                tag: codeList.codeName,
                context: this.context,
                viewparam: this.viewparams,
            };
        }
        // 部件控件模型配置是否展示分页栏与排序栏
        const ctrlParams = this.controlInstance?.getPSControlParam()?.ctrlParams || {};
        this.enableSort = Object.is(ctrlParams.ENABLESORT, 'true');
        this.enablePagingBar = Object.is(ctrlParams.ENABLEPAGINGBAR, 'true');
        // 计算是否显示排序栏
        const dataViewItems = this.controlInstance.getPSDEDataViewDataItems() || [];
        if (this.enableSort && dataViewItems.length > 0) {
            this.hasSortBar = dataViewItems.some((dataItem: IPSDEDataViewDataItem) => {
                return dataItem.getPSAppDEField() && !dataItem.getPSAppDEField()?.keyField;
            });
        }
        this.limit = this.controlInstance?.pagingSize || this.limit;
    }

    /**
     * 初始化排序模型数据
     *
     * @memberof DataViewControlBase
     */
    public initSortModel() {
        this.sortModel = [];
        this.controlInstance.getPSDEDataViewItems()?.forEach((cardViewItem: IPSDEDataViewItem) => {
            if (cardViewItem.enableSort) {
                this.sortModel.push({
                    caption: this.$tl(cardViewItem.getCapPSLanguageRes()?.lanResTag, cardViewItem.caption),
                    codeName: cardViewItem.dataItemName
                });
            }
        });
    }

    /**
     * 页面变化
     *
     * @param {*} $event 事件源
     * @memberof DataViewControlBase
     */
    public pageOnChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.curPage) {
            return;
        }
        this.curPage = $event;
        this.load({});
    }

    /**
     * 分页条数变化
     *
     * @param {*} $event 事件源
     * @memberof DataViewControlBase
     */
    public onPageSizeChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.limit) {
            return;
        }
        this.limit = $event;
        if (this.curPage === 1) {
            this.load({});
        }
    }

    /**
     * 分页刷新
     *
     * @memberof DataViewControlBase
     */
    public pageRefresh(): void {
        this.load({}, true);
    }

    /**
     * 初始化数据映射
     *
     * @memberof ListControlBase
     */
    public initDataMap() {
        const dataItems: IPSDEDataViewDataItem[] | null = this.controlInstance.getPSDEDataViewDataItems();
        if (dataItems && dataItems.length > 0) {
            dataItems.forEach((dataItem: IPSDEDataViewDataItem) => {
                this.dataMap.set(dataItem.name, { customCode: dataItem.customCode ? true : false });
            });
        }
    }

    /**
     * 数据视图部件初始化
     *
     * @memberof DataViewControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        // 绑定this
        this.transformData = this.transformData.bind(this);
        this.remove = this.remove.bind(this);
        this.refresh = this.refresh.bind(this);
        if (this.viewState) {
            this.dataviewControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(this.name, tag)) {
                    return;
                }
                if (Object.is(action, 'load')) {
                    this.refresh(data);
                }
                if (Object.is(action, 'filter')) {
                    this.refresh(data);
                }
                if (Object.is(action, 'save')) {
                    this.save(data);
                }
            });
        }
    }

    /**
     * 初始化界面行为模型
     *
     * @type {*}
     * @memberof DataViewControlBase
     */
    public initCtrlActionModel() {
        let cardViewItems = this.controlInstance.getPSDEDataViewItems() || [];
        if (cardViewItems?.length > 0) {
            for (let cardItem of cardViewItems) {
                let groupDetails = cardItem.getPSDEUIActionGroup()?.getPSUIActionGroupDetails() || [];
                if (groupDetails?.length > 0) {
                    for (let uiActionDetail of groupDetails) {
                        const appUIAction = uiActionDetail.getPSUIAction();
                        if (appUIAction) {
                            const model: any = {
                                name: uiActionDetail.name,
                                caption: appUIAction.caption,
                                cssClass: appUIAction?.getPSSysImage?.()?.cssClass,
                                codeName: appUIAction.codeName,
                                lanResTag: appUIAction.getCapPSLanguageRes?.()?.lanResTag,
                                dataItemName: cardItem.dataItemName,
                                actionTarget: appUIAction.actionTarget,
                                uIActionMode: appUIAction.uIActionMode,
                                uIActionTag: appUIAction.uIActionTag,
                                uIActionType: appUIAction.uIActionType,
                                showCaption: uiActionDetail.showCaption,
                                showIcon: uiActionDetail.showIcon,
                                dataAccessAction: appUIAction.dataAccessAction,
                                disabled: false,
                                visabled: true,
                                getNoPrivDisplayMode: (appUIAction as any).noPrivDisplayMode
                                    ? (appUIAction as any).noPrivDisplayMode
                                    : 6,
                            }
                            this.actionModel[appUIAction.uIActionTag] = model;
                        }
                    }
                }
            }
        }
    }

    /**
     * 数据加载
     *
     * @param {*} [opt={}] 额外参数
     * @param {boolean} [isReset=false] 是否重置数据，默认加载到的数据附加在已有的之后
     * @return {*}
     * @memberof DataViewControlBase
     */
     public async load(opt: any = {}, isReset: boolean = false) {
        if (!this.fetchAction) {
            this.$throw(
                `${this.controlInstance.codeName}` + (this.$t('app.list.notconfig.fetchaction') as string),
                'load',
            );
            return;
        }
        const arg: any = {};
        const page: any = {};
        if (this.isEnablePagingBar) {
            Object.assign(page, { page: this.curPage - 1, size: this.limit });
        }
        // 设置排序
        if (!this.isNoSort && Util.isExistAndNotEmpty(this.sortField) && Util.isExistAndNotEmpty(this.sortDir)) {
            const sort: string = this.sortField + ',' + this.sortDir;
            Object.assign(page, { sort: sort });
        }
        Object.assign(arg, page);
        const parentdata: any = {};
        this.$emit('ctrl-event', { controlname: this.controlInstance.name, action: 'beforeload', data: parentdata });
        Object.assign(arg, parentdata);
        let tempViewParams: any = parentdata.viewparams ? parentdata.viewparams : opt ? opt : {};
        Object.assign(tempViewParams, Util.deepCopy(this.viewparams));
        Object.assign(arg, { viewparams: tempViewParams }, opt);
        if (this.service) {
            let tempContext: any = Util.deepCopy(this.context);
            if (!(await this.handleCtrlEvents('onbeforeload', { action: this.fetchAction, navContext: tempContext, navParam: arg }))) {
                return;
            }
            this.onControlRequset('load', tempContext, arg);
            try {
                const response: any = await this.service.search(this.fetchAction, tempContext, arg, this.showBusyIndicator);
                this.onControlResponse('load', response);
                if (!response || response.status !== 200) {
                    if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, navParam: arg, data: response?.data }))) {
                        return;
                    }
                    this.$throw(response, 'load');
                    return;
                }
                const data: any = response.data;
                if (!(await this.handleCtrlEvents('onloadsuccess', { action: this.fetchAction, navParam: arg, data: data }))) {
                    return;
                }
                if (!this.isAddBehind) {
                    this.items = [];
                }
                if (Object.keys(data).length > 0) {
                    let datas = Util.deepCopy(data);
                    datas.map((item: any) => {
                        if (!item.srfchecked) {
                            Object.assign(item, { srfchecked: 0 });
                        }
                    });
                    this.totalRecord = response.total;
                    if (isReset) {
                        this.items = datas;
                    } else {
                        this.items.push(...datas);
                    }
                }
                this.isAddBehind = false;
                this.items.forEach((item: any) => {
                    Object.assign(item, this.getActionState(item));
                });
                this.$emit('ctrl-event', {
                    controlname: this.controlInstance.name,
                    action: 'load',
                    data: this.items,
                });
                //在导航视图中，如已有选中数据，则右侧展开已选中数据的视图，如无选中数据则默认选中第一条
                if (this.isSelectFirstDefault && this.items.length > 0) {
                        //  新数据集是否包含选中数据
                        let flag: boolean = false;
                        let index: number = 0;
                        //  有选中数据时获取选中下标
                        if (this.selections && this.selections.length > 0) {
                            for (let i = 0; i < this.selections.length; i++) {
                                const _index = this.items.findIndex((item: any) => {
                                    return Object.is(item.srfkey, this.selections[i].srfkey)
                                });
                                if (_index != -1) {
                                    index = _index;
                                    flag = true;
                                    return;
                                }
                            }
                        }
                        if (!flag) {
                            this.selections = [];
                        }
                        this.handleClick(this.items[index]);
                }
                if (this.isEnableGroup) {
                    this.group();
                }
            } catch(error: any) {
                this.onControlResponse('load', error);
                if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, navParam: arg, data: error?.data }))) {
                    return;
                }
                this.$throw(error, 'load');
            }
        }
    }

    /**
     * 删除
     *
     * @param {any[]} datas 删除数据
     * @returns {Promise<any>}
     * @memberof DataViewControlBase
     */
    public async remove(datas: any[]): Promise<any> {
        if (!this.removeAction) {
            this.$throw(
                `${this.controlInstance.codeName}` + (this.$t('app.grid.notconfig.removeaction') as string),
                'remove',
            );
            return;
        }
        let _datas: any[] = [];
        datas.forEach((record: any, index: number) => {
            if (Object.is(record.srfuf, '0')) {
                this.items.some((val: any, num: number) => {
                    if (JSON.stringify(val) == JSON.stringify(record)) {
                        this.items.splice(num, 1);
                        return true;
                    }
                });
            } else {
                _datas.push(datas[index]);
            }
        });
        if (_datas.length === 0) {
            return;
        }
        let dataInfo = '';
        _datas.forEach((record: any, index: number) => {
            let srfmajortext = record.srfmajortext;
            if (index < 5) {
                if (!Object.is(dataInfo, '')) {
                    dataInfo += '、';
                }
                dataInfo += srfmajortext;
            } else {
                return false;
            }
        });

        if (_datas.length < 5) {
            dataInfo =
                dataInfo +
                ' ' +
                (this.$t('app.dataview.sum') as string) +
                _datas.length +
                (this.$t('app.dataview.data') as string);
        } else {
            dataInfo =
                dataInfo +
                '...' +
                ' ' +
                (this.$t('app.dataview.sum') as string) +
                _datas.length +
                (this.$t('app.dataview.data') as string);
        }

        const removeData = async () => {
            let keys: any[] = [];
            _datas.forEach((data: any) => {
                keys.push(data.srfkey);
            });
            let _removeAction =this.removeAction;
            let _keys = keys.length > 1 ? keys : keys[0];
            const tempContext: any = Util.deepCopy(this.context);
            const appDeCodeName = this.appDeCodeName?.toLowerCase();
            const arg = { [appDeCodeName]: _keys};
            let promises:any;
            Object.assign(arg, { viewparams: this.viewparams });
            if (!(await this.handleCtrlEvents('onbeforeremove', { action: this.removeAction, navParam: arg, data: keys }))) {
                return;
            }
            this.onControlRequset('remove', tempContext, arg);
            if(keys && keys.length > 1){
                let promiseArr: any = [];
                _keys.forEach((ele:any) =>{
                    Object.assign(tempContext,{[this.appDeCodeName?.toLowerCase()]:ele});
                    promiseArr.push(this.service.delete(_removeAction, tempContext, arg, this.showBusyIndicator));
                })
                promises = Promise.all(promiseArr);
            }else{
                Object.assign(tempContext,{[this.appDeCodeName?.toLowerCase()]:_keys});
                promises = this.service.delete(_removeAction, tempContext, arg, this.showBusyIndicator);
            }
            return new Promise((resolve:any,reject:any)=>{
                promises.then( async (response:any)=>{
                    this.onControlResponse('remove', response);
                    if (!response || response.status !== 200 && !Array.isArray(response)) {
                        if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, navParam: arg, data: response?.data }))) {
                            return;
                        }
                        this.$throw(response, 'remove');
                        return;
                    } else {
                        if (!(await this.handleCtrlEvents('onremovesuccess', { action: this.removeAction, navParam: arg, data: response?.data }))) {
                            return;
                        }
                        this.$success(this.$t('app.commonwords.deletesuccess') as string, 'remove');
                    }
                    this.refresh();
                    this.$emit('ctrl-event', { controlname: this.controlInstance.name, action: 'remove', data: {} });
                    this.selections = [];
                }).catch(async (error: any) =>{
                    this.onControlResponse('remove', error);
                    if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, navParam: arg, data: error?.data }))) {
                        return;
                    }
                    this.$throw(error, 'remove');
                })
            })
        };

        dataInfo = dataInfo
            .replace(/[null]/g, '')
            .replace(/[undefined]/g, '')
            .replace(/[ ]/g, '');
        this.$Modal.confirm({
            title: this.$t('app.commonwords.warning') as string,
            content:
                (this.$t('app.grid.confirmdel') as string) +
                ' ' +
                dataInfo +
                '，' +
                (this.$t('app.grid.norecoverable') as string),
            onOk: () => {
                removeData();
            },
            onCancel: () => { },
        });
        return removeData;
    }

    /**
     * 保存
     *
     * @param {any[]} args 额外参数
     * @return {*}
     * @memberof DataViewControlBase
     */
    public async save(args: any = {}) {
        let _this = this;
        let successItems: any = [];
        let errorItems: any = [];
        let errorMessage: any = [];
        if (!(await this.handleCtrlEvents('onbeforesave', { data: _this.items }))) {
            return;
        }
        for (const item of _this.items) {
            try {
                if (Object.is(item.rowDataState, 'create')) {
                    if (!this.createAction) {
                        this.$throw(
                            `${this.controlInstance.codeName}` + (this.$t('app.list.notconfig.createaction') as string),
                            'save',
                        );
                    } else {
                        Object.assign(item, { viewparams: this.viewparams });
                        let tempContext: any = Util.deepCopy(this.context);
                        this.onControlRequset('create', tempContext, item);
                        let response = await this.service.add(
                            this.createAction,
                            tempContext,
                            item,
                            this.showBusyIndicator,
                        );
                        this.onControlResponse('create', response);
                        successItems.push(Util.deepCopy(response.data));
                    }
                } else if (Object.is(item.rowDataState, 'update')) {
                    if (!this.updateAction) {
                        this.$throw(
                            `${this.controlInstance.codeName}` + (this.$t('app.list.notconfig.updateaction') as string),
                            'save',
                        );
                    } else {
                        Object.assign(item, { viewparams: this.viewparams });
                        if (item[this.appDeCodeName?.toLowerCase()]) {
                            Object.assign(this.context, { [this.appDeCodeName?.toLowerCase()]: item[this.appDeCodeName?.toLowerCase()] });
                        }
                        let tempContext: any = Util.deepCopy(this.context);
                        this.onControlRequset('update', tempContext, item);
                        let response = await this.service.add(
                            this.updateAction,
                            tempContext,
                            item,
                            this.showBusyIndicator,
                        );
                        this.onControlResponse('update', response);
                        successItems.push(Util.deepCopy(response.data));
                    }
                }
            } catch (error) {
                this.onControlResponse('save', error);
                errorItems.push(Util.deepCopy(item));
                errorMessage.push(error);
            }
        }
        this.$emit('ctrl-event', { controlname: this.controlInstance.name, action: 'save', data: successItems });
        this.refresh();
        if (errorItems.length === 0) {
            if (!(await this.handleCtrlEvents('onsavesuccess', { data: successItems }))) {
                return;
            }
            if (args?.showResultInfo || (args && !args.hasOwnProperty('showResultInfo'))) {
                this.$success(this.$t('app.commonwords.savesuccess') as string, 'save');
            }
        } else {
            if (!(await this.handleCtrlEvents('onsaveerror', { data: errorItems }))) {
                return;
            }
            errorItems.forEach((item: any, index: number) => {
                this.$throw(item.majorentityname + (this.$t('app.commonwords.savefailed') as string) + '!', 'save');
            });
        }
        return successItems;
    }

    /**
     * 刷新
     *
     * @param {*} [args={}] 额外参数
     * @memberof DataViewControlBase
     */
    public refresh(args: any = {}) {
        this.curPage = 1;
        this.load(args, true);
    }

    /**
     * 加载更多
     *
     * @memberof DataViewControlBase
     */
    public loadMore(e: MouseEvent) {
        e.stopPropagation();
        if (this.totalRecord > this.items.length) {
            this.curPage = ++this.curPage;
            this.isAddBehind = true;
            this.load({});
        }
    }

    /**
     * 单击事件
     *
     * @param {*} args 数据
     * @memberof DataViewControlBase
     */
    public handleClick(args: any) {
        this.handleCtrlEvents('onrowclick', { action: 'RowClick', data: args }).then((res: boolean) => {
            if (res) {
                if (this.mDCtrlActiveMode === 1) {
                    this.ctrlEvent({ controlname: this.controlInstance.name, action: 'rowclick', data: args });
                    return;
                }
                args.srfchecked = Number(!args.srfchecked);
                if (this.isSingleSelect) {
                    this.items.forEach((item: any) => {
                        if (item.srfkey !== args.srfkey) {
                            item.srfchecked = 0;
                        }
                    });
                }
                this.selectchange();
            }
        });
    }

    /**
     * 触发事件
     *
     * @memberof DataViewControlBase
     */
    public selectchange() {
        const selections: any[] = [];
        this.items.map((item: any) => {
            if (item.srfchecked === 1) {
              const data = Util.deepCopy(item);
              delete data.srfchecked;
              selections.push(data);
            }
        });
        this.handleCtrlEvents('onselectionchange', { action: 'SelectionChange', data: selections }).then((res: boolean) => {
            if (res) {
                this.selections = [...selections];
                this.ctrlEvent({
                    controlname: this.name,
                    action: 'selectionchange',
                    data: this.selections,
                });
            }
        });
    }

    /**
     * 面板数据变化处理事件
     * @param {any} item 当前卡片数据
     * @param {any} $event 面板事件数据
     *
     * @memberof DataViewControlBase
     */
    public onPanelDataChange(item: any, $event: any) {
        Object.assign(item, $event, { rowDataState: 'update' });
    }

    /**
     * 双击事件
     *
     * @param {*} args 数据
     * @memberof DataViewControlBase
     */
    public handleDblClick(args: any) {
        this.handleCtrlEvents('onrowdblclick', { action: 'RowDBLClick', data: args }).then((res: boolean) => {
            if (res) {
                if (this.mDCtrlActiveMode !== 0) {
                    this.$emit('ctrl-event', { controlname: this.controlInstance.name, action: 'rowdblclick', data: args });
                }
            }
        });
    }

    /**
     * 处理操作列点击
     *
     * @param {*} data 数据
     * @param {*} event 事件源
     * @param {*} item 数据视图项模型
     * @param {*} detail 操作列模型
     * @memberof DataViewControlBase
     */
    public handleActionClick(data: any, event: any, item: any, detail: any) {
        event.stopPropagation();
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            const cardItems = this.controlInstance.getPSDEDataViewItems()
            let uiAction: any = null;
            if (cardItems && cardItems.length > 0) {
                cardItems.forEach(cardItem => {
                    cardItem.getPSDEUIActionGroup()?.getPSUIActionGroupDetails()?.forEach(groupDetail => {
                        if (groupDetail.name == detail.name) {
                            uiAction = groupDetail.getPSUIAction()
                        }
                    });
                })
            }
            AppGlobalService.getInstance().executeGlobalUIAction(uiAction, event, this, undefined, data);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(
                this.getViewLogicTag(this.name, item.dataItemName, detail.name),
                event,
                this,
                data,
                this.controlInstance.getPSAppViewLogics() as Array<any>,
            );
        }
    }

    /**
     * 排序点击事件
     * @param {string} codeName 属性标识
     *
     * @memberof DataViewControlBase
     */
    public sortClick(codeName: string) {
        if (this.sortField !== codeName) {
            this.sortField = codeName;
            this.sortDir = 'asc';
        } else if (this.sortDir === 'asc') {
            this.sortDir = 'desc';
        } else if (this.sortDir === 'desc') {
            this.sortDir = '';
        } else {
            this.sortDir = 'asc';
        }
        this.refresh();
    }

    /**
     * 分组方法
     *
     * @memberof DataViewControlBase
     */
    public group() {
        if (Object.is(this.groupMode, 'AUTO')) {
            this.drawGroup();
        } else if (Object.is(this.groupMode, 'CODELIST')) {
            this.drawCodeListGroup();
        }
        this.activeName = this.groupData.map((group: any) => group.group)
    }

    /**
     * 部件事件
     *
     * @param {string} controlname 部件名
     * @param {string} action 事件名
     * @param {*} data 数据
     * @memberof DataViewControlBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        super.onCtrlEvent(controlname, action, data);
        if (action == 'panelDataChange') {
            this.onPanelDataChange(data.item, data.data);
        }
    }

    /**
     * 计算卡片视图部件所需参数
     *
     * @param {*} controlInstance 部件模型对象
     * @param {*} item 单条卡片数据
     * @returns
     * @memberof DataViewControlBase
     */
    public computeTargetCtrlData(controlInstance: any, item?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            navdatas: [item],
        });
        Object.assign(targetCtrlParam.staticProps, {
            transformData: this.transformData,
            isLoadDefault: true,
            opendata: this.opendata,
            newdata: this.newdata,
            remove: this.remove,
            refresh: this.refresh,
            dataMap: this.dataMap,
        });
        targetCtrlEvent['ctrl-event'] = ({
            controlname,
            action,
            data,
        }: {
            controlname: string;
            action: string;
            data: any;
        }) => {
            this.onCtrlEvent(controlname, action, { item: item, data: data });
        };
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 更改批量操作工具栏显示状态
     *
     * @param $event 时间源
     * @memberof DataViewControlBase
     */
    public onClick($event: any) {
        if (!this.moveflag) {
            this.flag = !this.flag;
        }
        this.moveflag = false;
    }
    /**
     * 绘制加载数据提示信息
     *
     * @memberof DataViewControlBase
     */
    public renderLoadDataTip() {
        return (
            <div
                v-show={this.items.length == 0}
                class='app-data-empty'
                style={{ height: this.hasSortBar ? 'calc(100% - 42px)' : '100%' }}
            >
                {super.renderLoadDataTip()}
            </div>
        );
    }

    /**
     * 绘制无数据提示信息
     *
     * @memberof DataViewControlBase
     */
    public renderEmptyDataTip() {
        return (
            <div
                v-show={this.items.length == 0}
                class='app-data-empty'
                style={{ height: this.hasSortBar ? 'calc(100% - 42px)' : '100%' }}
            >
                {super.renderEmptyDataTip()}
            </div>
        );
    }

    /**
     * 绘制卡片视图项布局面板部件
     *
     * @returns {*}
     * @memberof DataViewControlBase
     */
    public renderItemPSLayoutPanel(item: any) {
        let {
            targetCtrlName,
            targetCtrlParam,
            targetCtrlEvent,
        }: { targetCtrlName: string; targetCtrlParam: any; targetCtrlEvent: any } = this.computeTargetCtrlData(
            this.controlInstance.getItemPSLayoutPanel(),
            item,
        );
        Object.assign(targetCtrlParam.staticProps, { panelType: 'ITEMLAYOUTPANEL', noPadding: true });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.controlInstance.getItemPSLayoutPanel()?.name,
            on: targetCtrlEvent,
        });
    }

    /**
     * 根据分组代码表绘制分组列表
     *
     * @memberof DataViewControlBase
     */
    public async drawCodeListGroup() {
        let groups: Array<any> = [];
        const groupTree: Array<any> = [];
        const data: Array<any> = [...this.items];
        if (this.groupCodeListParams) {
            let groupCodelist: any = await this.codeListService.getDataItems(this.groupCodeListParams);
            groups = Util.deepCopy(groupCodelist);
        }
        if (groups.length == 0) {
            LogUtil.warn(this.$t('app.dataview.useless'));
        }
        const map: Map<string, any> = new Map();
        data.forEach(item => {
            const tag = item[this.groupAppField];
            if (notNilEmpty(tag)) {
                if (!map.has(tag)) {
                    map.set(tag, []);
                }
                const arr: any[] = map.get(tag);
                arr.push(item);
            }
        });
        groups.forEach((group: any) => {
            const children: any[] = [];
            if (this.groupFieldCodelist && map.has(group.label)) {
                children.push(...map.get(group.label));
            } else if (map.has(group.value)) {
                children.push(...map.get(group.value));
            }
            const item: any = {
                label: group.label,
                group: group.label,
                data: group,
                children,
            };
            groupTree.push(item);
        });
        const child: any[] = [];
        data.forEach((item: any) => {
            let i: number = 0;
            if (this.groupFieldCodelist) {
                i = groups.findIndex((group: any) => Object.is(group.label, item[this.groupAppField]));
            } else {
                i = groups.findIndex((group: any) => Object.is(group.value, item[this.groupAppField]));
            }
            if (i < 0) {
                child.push(item);
            }
        });
        const Tree: any = {
            label: this.$t('app.commonwords.other'),
            group: this.$t('app.commonwords.other'),
            children: child,
        };
        if (child && child.length > 0) {
            groupTree.push(Tree);
        }
        this.groupData = groupTree;
    }

    /**
     * 绘制分组列表
     *
     * @memberof DataViewControlBase
     */
    public async drawGroup() {
        const data: Array<any> = [...this.items];
        let groups: Array<any> = [];
        data.forEach((item: any) => {
            if (item.hasOwnProperty(this.groupAppField)) {
                groups.push(item[this.groupAppField]);
            }
        });
        groups = [...new Set(groups)];
        if (groups.length == 0) {
            LogUtil.warn(this.$t('app.dataview.useless'));
        }
        const groupTree: Array<any> = [];
        groups.forEach((group: any, i: number) => {
            const children: Array<any> = [];
            data.forEach((item: any, j: number) => {
                if (Object.is(group, item[this.groupAppField])) {
                    children.push(item);
                }
            });
            group = group ? group : this.$t('app.commonwords.other');
            const tree: any = {
                label: group,
                group: group,
                children: children,
            };
            groupTree.push(tree);
        });
        this.groupData = groupTree;
    }

    /**
     * 排序class变更
     * @param {string} field 属性名
     *
     * @memberof DataViewControlBase
     */
    public getsortClass(field: string) {
        if (this.sortField !== field || this.sortDir === '') {
            return '';
        } else if (this.sortDir === 'asc') {
            return 'sort-ascending';
        } else if (this.sortDir === 'desc') {
            return 'sort-descending';
        }
    }

    /**
     * 获取界面行为权限状态
     *
     * @param {*} data 当前列表行数据
     * @memberof DataViewControlBase
     */
    public getActionState(data: any) {
        let tempActionModel: any = Util.deepCopy(this.actionModel);
        let targetData: any = this.transformData(data);
        ViewTool.calcActionItemAuthState(targetData, tempActionModel, this.appUIService);
        return tempActionModel;
    }

    /**
     * @description 部件销毁
     * @memberof DataViewControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.dataviewControlEvent) {
            this.dataviewControlEvent.unsubscribe();
        }
    }
}