import { Subject, Subscription } from 'rxjs';
import { ViewState, ViewTool, Util, ModelTool, LogUtil, MEditViewPanelControlInterface } from 'ibiz-core';
import { MDControlBase } from './md-control-base';
import { AppMEditViewPanelService } from '../ctrl-service';
import { IPSAppDEField, IPSAppView, IPSDEMultiEditViewPanel, IPSAppDEView } from '@ibiz/dynamic-model-api';
/**
 * 多编辑视图面板部件
 * 
 */
export class MEditViewPanelControlBase extends MDControlBase implements MEditViewPanelControlInterface {

    /**
     * 多编辑视图面板部件实例
     * 
     * @memberof MEditViewPanelControlBase
     */
    public declare controlInstance: IPSDEMultiEditViewPanel;

    /**
     * 多编辑表单面板样式(默认行记录)
     * 
     * @memberof MEditViewPanelControlBase
     */
    public panelStyle: string = 'ROW';

    /**
     * 面板状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof MEditViewPanelControlBase
     */
    public panelState: Subject<ViewState> = new Subject();

    /**
     * 视图参数对象集合
     *
     * @type {any[]}
     * @memberof MEditViewPanelControlBase
     */
    public items: any[] = [];

    /**
     * 计数器
     *
     * @type number
     * @memberof MEditViewPanelControlBase
     */
    public count: number = 0;

    /**
    * 关系实体参数对象
    *
    * @public
    * @type {any[]}
    * @memberof MEditViewPanelControlBase
    */
    public deResParameters: any[] = [];

    /**
     * 当前应用视图参数对象
     *
     * @public
     * @type {any[]}
     * @memberof MEditViewPanelControlBase
     */
    public parameters: any[] = [];

    /**
     * 是否显示底部按钮
     *
     * @public
     * @type {any[]}
     * @memberof MEditViewPanelControlBase
     */
    public showButton: boolean = true;

    /**
     * 当前激活分页（上分页时启用）
     *
     * @type {string}
     * @memberof MEditViewPanelControlBase
     */
    public activeTab: string = '';

    /**
      * @description 多编辑部件事件
      * @type {(Subscription | undefined)}
      * @memberof MEditViewPanelControlBase
      */
    public meditControlEvent: Subscription | undefined;

    /**
     * 部件模型数据初始化
     *
     * @memberof MEditViewPanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.service = new AppMEditViewPanelService(this.controlInstance, this.context, { localSourceTag: this.localSourceTag });
        }
        // 加载嵌入视图的数据
        await this.controlInstance.getEmbeddedPSAppView()?.fill();
        if (this.viewCtx.view?.viewInstance?.tempMode == 2) {
            this.loaddraftAction = this.controlInstance?.getGetDraftPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "GetDraftTemp";
            this.loadAction = this.controlInstance?.getGetPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "GetTemp";
            this.removeAction = this.controlInstance?.getRemovePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "RemoveTemp";
            this.updateAction = this.controlInstance?.getUpdatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "UpdateTemp";
            this.fetchAction = this.controlInstance?.getFetchPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "FetchTempDefault";
            this.createAction = this.controlInstance?.getCreatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "CreateTemp";
        }
        this.initParameters();
    }

    /**
     * 多编辑视图面板初始化
     *
     * @memberof MEditViewPanelControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        if (this.viewState) {
            this.meditControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is(action, 'load')) {
                    this.load(data);
                }
                if (Object.is(action, 'save')) {
                    this.saveData(data);
                }
            });
        }
    }

    /**
     * 初始化嵌入应用视图及实体参数对象
     *
     * @memberof MEditViewPanelControlBase
     */
    public initParameters() {
        const emView = this.controlInstance.getEmbeddedPSAppView() as IPSAppView;
        const emViewEntity = emView?.getPSAppDataEntity();
        const ctrlParams = this.controlInstance.getPSControlParam()?.ctrlParams;
        if (ctrlParams && ctrlParams.SHOWBUTTON) {
            this.showButton = Object.is(ctrlParams.SHOWBUTTON, "false") ? false : true;
        }
        if (emView && emViewEntity) {
            this.deResParameters = Util.formatAppDERSPath(this.context, (emView as IPSAppDEView).getPSAppDERSPaths());
            this.parameters = [{
                pathName: Util.srfpluralize(emViewEntity.codeName).toLowerCase(),
                parameterName: emViewEntity.codeName?.toLowerCase(),
                srfmajortext: (ModelTool.getAppEntityMajorField(emViewEntity) as IPSAppDEField).codeName?.toLowerCase(),
            }];
        } else {
            this.deResParameters = [];
            this.parameters = [];
        }
    }

    /**
     * 保存数据
     *
     * @param {*} [data] 数据
     * @memberof MEditViewPanelControlBase
     */
    public saveData(data?: any) {
        this.count = 0;
        if (this.items.length > 0) {
            Object.assign(data, { showResultInfo: false });
            this.panelState.next({ tag: this.controlInstance.getEmbeddedPSAppView()?.name || '', action: 'save', data: data });
        } else {
            this.ctrlEvent({ controlname: this.controlInstance.name, action: "drdatasaved", data: { action: 'drdatasaved' } });
        }
    }

    /**
     * 数据加载
     *
     * @public
     * @param {*} data 额外参数
     * @memberof MEditViewPanelControlBase
     */
    public load(data: any = {}, isReplace: boolean = false): void {
        if (!this.fetchAction) {
            this.$throw(this.$t('app.multieditview.notconfig.fetchaction'), 'load');
            return;
        }
        let arg: any = {};
        Object.assign(arg, data, { viewparams: this.viewparams });
        if (this.service) {
            let tempContext: any = JSON.parse(JSON.stringify(this.context));
            this.handleCtrlEvents('onbeforeload', { action: this.fetchAction, navParam: arg }).then((beforeLoadRes: boolean) => {
                if (!beforeLoadRes) {
                    return;
                }
                this.onControlRequset('load', tempContext, arg);
                const promice: Promise<any> = this.service.get(this.fetchAction, tempContext, arg, this.showBusyIndicator);
                promice.then((response: any) => {
                    this.onControlResponse('load', response);
                    if (!response.status || response.status !== 200) {
                        this.handleCtrlEvents('onloaderror', { action: this.fetchAction, navParam: arg, data: response?.data }).then((loadErrorRes: boolean) => {});
                        this.$throw(response, 'load');
                        return;
                    }
                    this.handleCtrlEvents('onloadsuccess', { action: this.fetchAction, navParam: arg, data: response.data }).then((loadSuccessRes: boolean) => {
                        if (loadSuccessRes) {
                            if (isReplace) {
                                // 清空数据
                                this.items = [];
                            }
                            if (response?.data?.length > 0) {
                                this.items = [];
                                const items = Util.deepCopy(response.data);
                                this.doItems(items);
                            }
                            this.ctrlEvent({ controlname: this.controlInstance.name, action: "load", data: this.items });
                        }
                    });
                }).catch((response: any) => {
                    this.onControlResponse('load', response);
                    this.handleCtrlEvents('onloaderror', { action: this.fetchAction, navParam: arg, data: response?.data }).then((loadErrorRes: boolean) => {});
                    this.$throw(response, 'load');
                });
            })
        }
    }

    /**
     * 增加数据
     * 
     * @memberof MEditViewPanelControlBase
     */
    public handleAdd() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (!this.loaddraftAction) {
            this.$throw(this.$t('app.multieditview.notconfig.loaddraftaction'), 'handleAdd');
            return;
        }
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        let viewparams: any = JSON.parse(JSON.stringify(this.viewparams));
        this.handleCtrlEvents('onbeforeadd', { action: 'Add' }).then((beforeAddRes: boolean) => {
            if (!beforeAddRes) {
                return;
            }
            this.onControlRequset('handleAdd', tempContext, viewparams);
            const promice: Promise<any> = this.service.loadDraft(this.loaddraftAction, tempContext, { viewparams: viewparams }, this.showBusyIndicator);
            promice.then((response: any) => {
                this.onControlResponse('handleAdd', response);
                if (!response.status || response.status !== 200) {
                    this.handleCtrlEvents('onadderror', { action: 'Add', data: response?.data }).then((errorRes: boolean) => {});
                    this.$throw(response, 'handleAdd');
                    return;
                }
                const data: any = response.data;
                this.handleCtrlEvents('onaddsuccess', { action: 'Add', data: data }).then((successRes: boolean) => {
                    if (!successRes) {
                        return;
                    }
                    this.doItems([data]);
                    this.$forceUpdate();
                })
            }).catch((response: any) => {
                this.onControlResponse('handleAdd', response);
                this.handleCtrlEvents('onadderror', { action: 'Add', data: response?.data }).then((errorRes: boolean) => {});
                this.$throw(response, 'handleAdd');
            });
        })
    }

    /**
     * 删除分页数据
     * 
     * @memberof MEditViewPanelControlBase
     */
    handleTabDelete(item: any, index: number) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        // 如果删除的是激活项，且为最后一项，设置激活项为前一项
        if (item.id == this.activeTab && index == this.items.length - 1) {
            if (index > 0) {
                this.activeTab = this.items[index - 1].id
            }
        }
        this.handleDelete(item);
    }

    /**
     * 删除数据
     * 
     * @memberof MEditViewPanelControlBase
     */
    handleDelete(item: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.handleCtrlEvents('onbeforedelete', { action: 'Delete', data: item }).then((beforeRes: boolean) => {
            if (!beforeRes) {
                return;
            }
            // 新建的界面上删除即可
            if (item.data.srfuf == "0") {
                this.handleCtrlEvents('ondeletesuccess', { action: 'DeleteLocal', data: item }).then((successRes: boolean) => {
                    if (successRes) {
                        //删除items中已删除的项
                        let index = this.items.findIndex((value: any, index: any, arr: any) => {
                            return value === item;
                        });
                        this.items.splice(index, 1);
                    }
                })
            } else {
                // 原有的走接口删除
                let tempContext: any = JSON.parse(JSON.stringify(this.context));
                Object.assign(tempContext, { [this.appDeCodeName.toLowerCase()]: item.id });
                let viewparams: any = JSON.parse(JSON.stringify(this.viewparams));
                const arg = { [this.appDeCodeName.toLowerCase()]: item.id };
                Object.assign(arg, { viewparams: this.viewparams })
                this.onControlRequset('handleDelete', tempContext, viewparams);
                const promice: Promise<any> = this.service.delete(this.removeAction, tempContext, arg, this.showBusyIndicator);
                promice.then((response: any) => {
                    this.onControlResponse('handleDelete', response);
                    if (!response.status || response.status !== 200) {
                        this.handleCtrlEvents('ondeleteerror', { action: 'Delete', data: response?.data }).then((successRes: boolean) => {});
                        this.$throw(response, 'handleDelete');
                        return;
                    }
                    const data: any = response.data;
                    this.handleCtrlEvents('ondeletesuccess', { action: 'Delete', data: data }).then((successRes: boolean) => {
                        if (successRes) {
                            //删除items中已删除的项
                            let index = this.items.findIndex((value: any, index: any, arr: any) => {
                                return value.id === item.id;
                            });
                            this.items.splice(index, 1);
                        }
                    })
                }).catch((response: any) => {
                    this.onControlResponse('handleDelete', response);
                    this.handleCtrlEvents('ondeleteerror', { action: 'Delete', data: response?.data }).then((successRes: boolean) => {});
                    this.$throw(response, 'handleDelete');
                });
            }
        });
    }

    /**
    * 视图数据变更事件
    *
    * @param {*} $event 回调对象
    * @return {*} 
    * @memberof MEditViewPanelControlBase
    */
    public viewDataChange($event: any) {
        // todo 统一标准后修改
        if (!$event) {
            return
        }
        try {
            $event = JSON.parse($event);
        } catch (error) {
            return;
        }
        if (Object.is($event.action, 'save')) {
            this.count++;
            if (this.items.length === this.count) {
                this.ctrlEvent({ controlname: this.controlInstance.name, action: "drdatasaved", data: { action: 'save' } });
            }
        }
        if (Object.is($event.action, 'remove')) {
            if ($event.data) {
                let resultIndex = this.items.findIndex((value: any, index: any, arr: any) => {
                    return value[this.appDeCodeName.toLowerCase()] === $event.data[this.appDeCodeName.toLowerCase()];
                });
                if (resultIndex !== -1) {
                    this.items.splice(resultIndex, 1);
                }
            }
        }
    }

    /**
    * 视图数据变更事件
    *
    * @param {*} $event 回调对象
    * @return {*} 
    * @memberof MEditViewPanelControlBase
    */
    public viewStateChange($event: any) {
        if ($event[0].isSave) {
            const _this = this;
            _this.count++;
            if (_this.items.length === _this.count) {
                this.ctrlEvent({ controlname: this.controlInstance.name, action: "drdatasaved", data: { action: 'save' } });
            }
        }
    }

    /**
     * 视图加载完成
     *
     * @param {*} $event 回调对象
     * @memberof MEditViewPanelControlBase
     */
    public viewLoaded($event: any) {
        LogUtil.log(this.$t('components.appformdruipart.loadcomp'));
    }

    /**
     * 刷新
     *
     * @param {*} [args] 额外参数
     * @memberof MEditViewPanelControlBase
     */
    public refresh(args: any = {}) {
        this.load(args, true);
    }

    /**
     * 处理数据
     *
     * @public
     * @param {any[]} datas 数据集合
     * @memberof MEditViewPanelControlBase
     */
    public doItems(datas: any[]): void {
        // todo 同类数据处理可以抽个工具类
        const [{ pathName, parameterName }] = this.parameters;
        datas.forEach((arg: any) => {
            let id: string = arg[parameterName] ? arg[parameterName] : this.$util.createUUID();
            let item: any = { id: id, viewdata: {}, viewparam: {}, data: arg };
            Object.assign(item.viewdata, ViewTool.getIndexViewParam());
            Object.assign(item.viewdata, this.context);
            // 关系应用实体参数
            this.deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
                if (this.context[parameterName] && !Object.is(this.context[parameterName], '')) {
                    Object.assign(item.viewdata, { [parameterName]: this.context[parameterName] });
                } else if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                    Object.assign(item.viewdata, { [parameterName]: arg[parameterName] });
                }
            });

            // 当前视图参数（应用实体视图）
            this.parameters.forEach(({ pathName, parameterName, srfmajortext }: { pathName: string, parameterName: string, srfmajortext: string }) => {
                if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                    Object.assign(item.viewdata, { [parameterName]: arg[parameterName] });
                }
                // 当前页面实体主信息
                if (arg[srfmajortext] && !Object.is(arg[srfmajortext], '')) {
                    Object.assign(item, { srfmajortext: arg[srfmajortext] });
                } else if (arg.srfuf == "0") {
                    Object.assign(item, { srfmajortext: '草稿--新建' });
                }
            });

            //合并视图参数
            Object.assign(item.viewparam, this.viewparams);
            this.items.push(item);
        });
    }

    /**
     * @description 部件销毁
     * @memberof MEditViewPanelControlBase
     */
    public ctrlDestroyed(){
        super.ctrlDestroyed()
        if(this.meditControlEvent){
            this.meditControlEvent.unsubscribe();
        }
    }

}