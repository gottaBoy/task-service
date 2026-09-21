import { AppServiceBase, KanbanControlInterface, Util } from 'ibiz-core';
import { MDControlBase } from './md-control-base';
import { AppGlobalService, AppViewLogicService } from '../app-service';
import { AppKanbanService } from '../ctrl-service';
import { IPSAppDEKanbanView, IPSAppView, IPSAppViewRef, IPSCodeList, IPSDEKanban } from '@ibiz/dynamic-model-api';
import { Subject, Subscription } from 'rxjs';
/**
 * 看板视图部件基类
 * 
 * @export
 * @class KanbanControlBase
 * @extends {MDControlBase}
 */
export class KanbanControlBase extends MDControlBase implements KanbanControlInterface {

    /**
     * 看板数据
     * 
     * @type {Array<any>}
     * @memberof KanbanControlBase
     */
    public items: Array<any> = [];

    /**
     * 看板部件模型实例
     * 
     * @type {IPSDEKanban}
     * @memberof KanbanControlBase
     */
    public declare controlInstance: IPSDEKanban;

    /**
     * 加载的数据是否附加在items之后
     *
     * @type {boolean}
     * @memberof KanbanControlBase
     */
    public isAddBehind: boolean = false;

    /**
     * 代码表数据
     *
     * @type {Array<any>}
     * @memberof KanbanControlBase
     */
    public allCodeList: Array<any> = [];

    /**
     * 是否分组
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public isGroup: boolean = true;

    /**
     * 分组集合
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public groups: any[] = [];

    /**
     * 分组属性名称
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public groupField: string = '';

    /**
     * 分组模式
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public groupMode: string = '';

    /**
     * 分组代码表
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public declare groupCodeList: any;

    /**
     * 部件行为--updateGroupAction
     *
     * @type {string}
     * @memberof KanbanControlBase
     */
    public updateGroupAction?: string;

    /**
     * this引用
     *
     * @type {number}
     * @memberof KanbanControlBase
     */
    public thisRef: any = this;

    /**
     * 状态事件
     * 
     * @memberof KanbanControlBase
     */
    public kanbanStateEvent: Subscription | undefined;

     /**
      * @description 看板部件事件
      * @type {(Subscription | undefined)}
      * @memberof KanbanControlBase
      */
    public kanbanControlEvent: Subscription | undefined;

    /**
     * 部件模型数据初始化
     *
     * @param {*} [args]
     * @memberof KanbanControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.service = new AppKanbanService(this.controlInstance, this.context, { localSourceTag: this.localSourceTag });
        }
        this.limit = this.controlInstance?.pagingSize ? this.controlInstance.pagingSize : 20;
        this.minorSortPSDEF = this.controlInstance.getMinorSortPSAppDEField()?.codeName?.toLowerCase() || '';
        this.minorSortDir = this.controlInstance.minorSortDir;
        this.groupField = this.controlInstance.getGroupPSAppDEField()?.codeName?.toLowerCase() || "";
        this.isGroup = this.controlInstance?.enableGroup;
        this.groupMode = this.controlInstance?.groupMode;
        this.updateGroupAction = this.controlInstance.getUpdateGroupPSControlAction()?.actionName;
        const codeList: IPSCodeList | null = this.controlInstance.getGroupPSCodeList();
        await codeList?.fill();
        this.groupCodeList = codeList ? { type: codeList.codeListType, tag: codeList.codeName, data: codeList } : {};
    }

    /**
     * 部件事件
     * 
     * @param {string} controlname
     * @param {string} action
     * @param {*} data
     * @memberof KanbanControlBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (action == 'panelDataChange') {
            this.onPanelDataChange(data.item, data.data);
        } else {
            super.onCtrlEvent(controlname, action, data);
        }
    }

    /**
     * 计算项布局面板部件所需参数
     *
     * @param {*} controlInstance
     * @param {*} item
     * @returns
     * @memberof KanbanControlBase
     */
    public computeTargetCtrlData(controlInstance: any, item?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            navdatas: [item],
            actionModel: this.actionModel,
        })
        Object.assign(targetCtrlParam.staticProps, {
            transformData: this.transformData,
            opendata: this.opendata,
            newdata: this.newdata,
            remove: this.remove,
            refresh: this.refresh,
        })
        targetCtrlEvent['ctrl-event'] = ({ controlname, action, data }: { controlname: string, action: string, data: any }) => {
            this.onCtrlEvent(controlname, action, { item: item, data: data });
        };
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 执行mounted后的逻辑
     *
     *  @memberof KanbanControlBase
     */
    public ctrlMounted() {
        super.ctrlMounted();
        if (!this.isEnablePagingBar) {
            this.$el.addEventListener('scroll', () => {
                if (this.$el.scrollTop + this.$el.clientHeight >= this.$el.scrollHeight) {
                    this.loadMore();
                }
            })
        }
    }

    /**
     * 初始化看板部件
     *
     * @memberof KanbanControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        // 绑定this
        this.transformData = this.transformData.bind(this);
        this.remove = this.remove.bind(this);
        this.refresh = this.refresh.bind(this);

        if (this.viewState) {
            this.kanbanControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(this.name, tag)) {
                    return;
                }
                if (Object.is(action, 'load')) {
                    this.refresh(data)
                }
                if (Object.is(action, 'filter')) {
                    this.refresh(data)
                }
            });
        }
    }

    /**
     * 看板数据加载
     *
     * @param {*} [opt={}] 额外参数
     * @param {boolean} [isReset=false] 是否重置items
     * @return {*} 
     * @memberof KanbanControlBase
     */
    public async load(opt: any = {}, isReset: boolean = false) {
        if (!this.fetchAction) {
            this.$throw(this.$t('app.kanban.notconfig.fetchaction'), 'load');
            return;
        }
        const arg: any = { ...opt };
        const page: any = {};
        if (this.isEnablePagingBar) {
            Object.assign(page, { page: this.curPage - 1, size: this.limit });
        }
        // 设置排序
        if (!Object.is(this.minorSortDir, '') && !Object.is(this.minorSortPSDEF, '')) {
            const sort: string = this.minorSortPSDEF + "," + this.minorSortDir;
            Object.assign(page, { sort: sort });
        }
        Object.assign(arg, page);
        const parentdata: any = {};
        this.$emit("ctrl-event", { controlname: "kanban", action: "beforeload", data: parentdata });
        Object.assign(arg, parentdata);
        let tempViewParams: any = parentdata.viewparams ? parentdata.viewparams : {};
        Object.assign(tempViewParams, Util.deepCopy(this.viewparams));
        Object.assign(arg, { viewparams: tempViewParams });
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
            this.setGroups();
            this.$emit("ctrl-event", { controlname: "kanban", action: "load", data: this.items });
            if (this.isSelectFirstDefault) {
                this.handleClick(this.items[0]);
            }
        } catch (error: any) {
            this.onControlResponse('load', error);
            if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, navParam: arg, data: error?.data }))) {
                return;
            }
            this.$throw(error, 'load');
        }
    }

    /**
     * 加载更多
     *
     * @memberof KanbanControlBase
     */
    public loadMore() {
        if (this.totalRecord > this.items.length) {
            this.curPage = ++this.curPage;
            this.isAddBehind = true;
            this.load({});
        }
    }

    /**
     * 刷新
     *
     * @param {*} [opt={}] 额外参数
     * @memberof KanbanControlBase
     */
    public refresh(args: any = {}) {
        this.curPage = 1;
        this.load(args, true);
    }

    /**
     * 删除
     *
     * @param {any[]} datas 删除数据
     * @returns {Promise<any>}
     * @memberof KanbanControlBase
     */
    public async remove(datas: any[]): Promise<any> {
        if (!this.removeAction) {
            this.$throw(`${this.controlInstance.codeName}` + (this.$t('app.kanban.notconfig.removeaction') as string), 'remove');
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
            dataInfo = dataInfo + this.$t('app.dataview.sum') + _datas.length + this.$t('app.dataview.data');
        } else {
            dataInfo = dataInfo + '...' + this.$t('app.dataview.sum') + _datas.length + this.$t('app.dataview.data');
        }

        const removeData = async () => {
            let keys: any[] = [];
            _datas.forEach((data: any) => {
                keys.push(data.srfkey);
            });
            let _removeAction = this.removeAction;

            let tempContext: any = Util.deepCopy(this.context);
            let _keys = keys.length > 1 ? keys : keys[0];
            let arg: any = { [(this.controlInstance.getPSAppDataEntity as any).codeName?.toLowerCase()]: _keys };
            Object.assign(arg, { viewparams: this.viewparams });
            if (!(await this.handleCtrlEvents('onbeforeremove', { action: this.removeAction, navParam: arg, data: keys }))) {
                return;
            }
            this.onControlRequset('remove', tempContext, arg);            
            let promises: any;
            //逻辑更改
            if (keys && keys.length > 1) {
                let promiseArr: any = [];
                _keys.forEach((ele: any) => {
                    Object.assign(tempContext, { [this.appDeCodeName?.toLowerCase()]: ele });
                    promiseArr.push(this.service.delete(_removeAction, tempContext, arg, this.showBusyIndicator));
                })
                promises = Promise.all(promiseArr);
            } else {
                Object.assign(tempContext, { [this.appDeCodeName?.toLowerCase()]: _keys });
                promises = this.service.delete(_removeAction, tempContext, arg, this.showBusyIndicator);
            }
            return new Promise((resolve: any, reject: any) => {
                promises.then(async (response: any) => {
                    this.onControlResponse('remove', response);
                    if (!response || response.status !== 200 && !Array.isArray(response)) {
                        if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, navParam: arg, data: response?.data }))) {
                            return;
                        }
                        this.$throw((this.$t('app.commonwords.deldatafail') as string) + ',' + response.info, 'remove');
                        return;
                    } else {
                        if (!(await this.handleCtrlEvents('onremovesuccess', { action: this.removeAction, navParam: arg, data: response?.data }))) {
                            return;
                        }
                        this.$success((this.$t('app.commonwords.deletesuccess') as string), 'remove');
                    }
                    //删除items中已删除的项
                    _datas.forEach((data: any) => {
                        this.items.some((item: any, index: number) => {
                            if (Object.is(item.srfkey, data.srfkey)) {
                                this.items.splice(index, 1);
                                return true;
                            }
                        });
                    });
                    this.$emit("ctrl-event", { controlname: "kanban", action: "remove", data: null });
                    this.selections = [];
                    this.refresh();
                }).catch(async (error: any) => {
                    this.onControlResponse('remove', error);
                    if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, navParam: arg, data: error?.data }))) {
                        return;
                    }
                    this.$throw(error, 'remove');
                })
            }) 
        }

        dataInfo = dataInfo.replace(/[null]/g, '').replace(/[undefined]/g, '').replace(/[ ]/g, '');
        this.$Modal.confirm({
            title: (this.$t('app.commonwords.warning') as string),
            content: (this.$t('app.kanban.delete1') as string) + dataInfo + '，' + (this.$t('app.kanban.delete2') as string),
            onOk: () => {
                removeData();
            },
            onCancel: () => { }
        });
        return removeData;
    }

    /**
     * 界面行为
     *
     * @param {*} detail 界面行为
     * @param {*} $event 事件源
     * @param {*} group 看板分组
     * @memberof KanbanControlBase
     */
    public uiActionClick(detail: any, $event: any, group: any) {
        let row = this.selections.length > 0 && group.items.includes(this.selections[0]) ? this.selections[0] : {};
        if (!row.hasOwnProperty('srfgroup')) {
            Object.assign(row, { srfgroup: group.value });
        }
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            AppGlobalService.getInstance().executeGlobalUIAction(detail.getPSUIAction(), $event, this, undefined, row);
        } else {
            AppViewLogicService.getInstance().executeViewLogic(this.getViewLogicTag(this.controlInstance.name, 'group', detail.name), $event, this, row, this.controlInstance?.getPSAppViewLogics() as any);
        }
    }

    /**
     * 面板数据变化处理事件
     * @param {any} item 当前列数据
     * @param {any} $event 面板事件数据
     *
     * @memberof KanbanControlBase
     */
    public onPanelDataChange(item: any, $event: any) {
        Object.assign(item, $event, { rowDataState: 'update' });
    }

    /**
     * 拖拽结束
     * 
     */
    public onDragEnd() {
        this.$forceUpdate();
    }

    /**
     * 拖拽变化
     *
     * @param {*} evt 拖住对象
     * @param {*} name 分组名
     * @memberof KanbanControlBase
     */
    public async onDragChange(evt: any, name: string) {
        if (evt?.added?.element) {
            let item: any = Util.deepCopy(evt.added.element)
            let updateView: IPSAppView | null = await this.getUpdateView(name);
            if (updateView) {
                let view: any = {
                    viewname: 'app-view-shell',
                    height: updateView.height,
                    width: updateView.width,
                    title: this.$tl(updateView.getTitlePSLanguageRes()?.lanResTag, updateView.title),
                };
                const _context: any = Util.deepCopy(this.context);
                const _param: any = Util.deepCopy(this.viewparams);
                Object.assign(_context, { [this.appDeCodeName.toLowerCase()]: item.srfkey });
                if (updateView && updateView.modelPath) {
                    Object.assign(_context, { viewpath: updateView.modelPath });
                }
                let container: Subject<any>;
                if (updateView.openMode && !Object.is(updateView.openMode, '') && updateView.openMode.indexOf('DRAWER') !== -1) {
                    if (Object.is(updateView.openMode, 'DRAWER_TOP')) {
                        Object.assign(view, { isfullscreen: true });
                        container = this.$appdrawer.openTopDrawer(
                            view,
                            Util.getViewProps(_context, _param),
                        );
                    } else {
                        Object.assign(view, { placement: updateView.openMode });
                        container = this.$appdrawer.openDrawer(view, Util.getViewProps(_context, _param));
                    }
                } else {
                    container = this.$appmodal.openModal(view, _context, _param);
                }
                this.kanbanStateEvent = container.subscribe((result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        this.setGroups();
                        return;
                    }
                    this.refresh();
                });
            } else {
                await this.updateData(item, name)
            }
        }
    }

    /**
     * 修改分组集合
     *
     * @param {*} opt 数据
     * @param {*} newVal 新分组值
     * @memberof KanbanControlBase
     */
    public async updateData(opt: any, newVal: any) {
        const oldVal = opt[this.groupField];
        if (newVal) {
            opt[this.groupField] = newVal;
        }
        const arg: any = { ...opt };
        Object.assign(arg, { viewparams: this.viewparams });
        let tempContext: any = Util.deepCopy(this.context);
        if (this.controlInstance.getPSAppDataEntity()?.codeName) {
            Object.assign(tempContext, { [(this.controlInstance.getPSAppDataEntity()?.codeName?.toLowerCase() as string)]: opt.srfkey });
        }
        if (!(await this.handleCtrlEvents('onbeforedragchange', { action: this.updateGroupAction, navContext: tempContext, navParam: arg }))) {
            return;
        }
        this.onControlRequset('updateData', tempContext, arg);
        try {
            const response: any = await this.service.update(this.updateGroupAction, tempContext, arg, this.showBusyIndicator);
            this.onControlResponse('updateData', response);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('ondragchangeerror', { action: this.updateGroupAction, navParam: arg, data: response?.data }))) {
                    return;
                }
                this.$throw(response, 'updateData');
                opt[this.groupField] = oldVal;
                this.setGroups();
                return;
            }
            let item = this.items.find((item: any) => Object.is(item.srfkey, response.data.srfkey));
            Object.assign(item, response.data);
            if (!(await this.handleCtrlEvents('ondragchangesuccess', { action: this.updateGroupAction, navParam: arg, data: response.data }))) {
                return;
            }
            this.setGroups();
            this.$emit("ctrl-event", { controlname: "kanban", action: "update", data: this.items });
        } catch (error: any) {
            this.onControlResponse('updateData', error);
            if (!(await this.handleCtrlEvents('ondragchangeerror', { action: this.updateGroupAction, navParam: arg, data: error?.data }))) {
                return;
            }
            opt[this.groupField] = oldVal;
            this.setGroups();
            this.$throw(error, 'updateData');
        }
    }

    /**
     * 单击事件
     * 
     * @param {*} args 数据
     * @memberof KanbanControlBase
     */
    public handleClick(args: any) {
        this.handleCtrlEvents('onrowclick', { action: 'RowClick', data: args }).then((res: boolean) => {
            if (res) {
                if (this.mDCtrlActiveMode === 1) {
                    this.ctrlEvent({ controlname: this.name, action: 'rowclick', data: args });
                    return;
                }
                args.srfchecked = Number(!args.srfchecked);
                this.items.forEach((item: any) => {
                    if (item.srfkey !== args.srfkey) {
                        item.srfchecked = 0;
                    }
                })
                this.selectchange();
            }
        });
    }

    /**
     * 双击事件
     *
     * @param {*} args 数据
     * @memberof KanbanControlBase
     */
    public handleDblClick(args: any) {
        this.handleCtrlEvents('onrowdblclick', { action: 'RowDBLClick', data: args }).then((res: boolean) => {
            if (res) {
                if (this.mDCtrlActiveMode !== 0) {
                    args.srfchecked = 1;
                    this.items.forEach((item: any) => {
                        if (item.srfkey !== args.srfkey) {
                            item.srfchecked = 0;
                        }
                    })
                    this.$emit("ctrl-event", { controlname: "kanban", action: "rowdblclick", data: args });
                }
            }
        });
    }

    /**
     * 触发事件
     * @memberof KanbanControlBase
     *
     */
    public selectchange() {
        this.selections = [];
        this.items.map((item: any) => {
            if (item.srfchecked === 1) {
                this.selections.push(item);
            }
        });
        this.$emit("ctrl-event", { controlname: "kanban", action: "selectionchange", data: this.selections });
    }

    /**
     * 点击时触发看板的展开和收起
     * 
     * @param group 分组看板
     * @param index 分组看板编号
     * @memberof KanbanControlBase
     */
    public onClick(group: any, index: number) {
        group.folding = !group.folding;
        this.$forceUpdate();
    }

    /**
     * 设置分组集合
     *
     * @memberof KanbanControlBase
     */
    public async setGroups() {
        let tempGroups: Array<any> = this.groups;
        if (!this.isGroup || !this.groupField || Object.is(this.groupMode, 'NONE')) {
            return;
        }
        if (Object.is(this.groupMode, 'AUTO')) {
            this.groups = [];
            this.items.forEach(item => {
                let group: any = this.groups.find((group: any) => Object.is(group.name, item[this.groupField]));
                let state: any = tempGroups.filter((temp: any) => Object.is(item[this.groupField], temp.value))[0];
                if (!group) {
                    this.groups.push({
                        name: item[this.groupField],
                        value: item[this.groupField],
                        folding: (state && !state.folding) ? state.folding : true,
                        items: this.getGroupItems(item[this.groupField])
                    })
                }
            });
        }
        if (Object.is(this.groupMode, 'CODELIST') && this.groupCodeList) {
            this.groups = [];
            let codelistItems: any = await this.codeListService.getDataItems({ ...this.groupCodeList, context: this.context });
            this.allCodeList = Util.deepCopy(codelistItems);
            if (codelistItems && codelistItems.length > 0) {
                codelistItems.forEach((item: any) => {
                    let state: any = tempGroups.filter((temp: any) => Object.is(item.value, temp.value))[0];
                    this.groups.push({
                        name: item.value,
                        value: item.value,
                        color: item.color,
                        folding: (state && !state.folding) ? state.folding : true,
                        items: this.getGroupItems(item.value)
                    })
                })
            }
        }
    }

    /**
     * 拖拽更新页面
     *
     * @param {string} group 分组名称
     * @memberof KanbanControlBase
     */
    public async getUpdateView(group: string) {
        if (!group) return null;
        let parentModel: IPSAppDEKanbanView = (this.controlInstance as any).parentModel;
        if (parentModel.getPSAppViewRefs() && (parentModel.getPSAppViewRefs() as IPSAppViewRef[]).length > 0) {
            let activeAppViewRef: any = parentModel.getPSAppViewRefs()?.find((item: IPSAppViewRef) => {
                return item.name === `EDITDATA:${group.toUpperCase()}`;
            })
            if (!activeAppViewRef || !activeAppViewRef.getRefPSAppView()) return null;
            const openView: IPSAppView = activeAppViewRef.getRefPSAppView();
            await openView.fill();
            return openView;
        } else {
            return null;
        }
    }

    /**
     * 获取对应分组的数据集合
     *
     * @param {string} name 分组值
     * @memberof KanbanControlBase
     */
    public getGroupItems(name: string) {
        let datas: any = [];
        this.items.forEach(item => {
            if (Object.is(item[this.groupField], name)) {
                datas.push(item);
            }
        })
        return datas;
    }

    /**
     * 获取分组的text
     *
     * @param {string} name 分组值
     * @memberof KanbanControlBase
     */
    public getGroupText(name: string) {
        if (Object.is(this.groupMode, 'CODELIST') && this.groupCodeList) {
            if (this.allCodeList && this.allCodeList.length > 0) {
                if (!name) {
                    return this.$t('app.chart.undefined');
                }
                let item = this.allCodeList.find((item: any) => Object.is(item.value, name));
                if (item) {
                    return item.text;
                }
            }
        } else {
            return name;
        }
    }

    /**
     * @description:部件订阅
     * 
     * @return {*}
     */ 
    public ctrlDestroyed(){
        super.ctrlDestroyed()
        if(this.kanbanStateEvent){
            this.kanbanStateEvent.unsubscribe();
        }
        if (this.kanbanControlEvent) {
            this.kanbanControlEvent.unsubscribe();
        }
    }
}