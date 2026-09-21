import { IPSAppDEField, IPSAppDEView, IPSAppView, IPSDEMultiEditViewPanel } from '@ibiz/dynamic-model-api';
import { Util, ViewTool, ViewState, ModelTool, MobMEditViewPanelControlInterface } from 'ibiz-core';
import { Subject } from 'rxjs';
import { AppMobMEditViewPanelService } from '../ctrl-service';
import { MDControlBase } from './md-control-base';

/**
 * 多编辑面板部件基类
 *
 * @export
 * @class GridControlBase
 * @extends {MDControlBase}
 */
export class MobMeditViewPanelControlBase extends MDControlBase implements MobMEditViewPanelControlInterface {


    /**
     * 多编辑视图面板部件实例
     * 
     * @memberof MobMeditViewPanelControlBase
     */
    public declare controlInstance: IPSDEMultiEditViewPanel;

    /**
     * 面板状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof MobMeditViewPanelControlBase
     */
    public panelState: Subject<ViewState> = new Subject();


    /**
     * 视图参数对象集合
     *
     * @type {any[]}
     * @memberof MobMeditViewPanelControlBase
     */
    public items: any[] = [];

    /**
     * 计数器
     *
     * @type number
     * @memberof MobMeditViewPanelControlBase
     */
    public count: number = 0;

    /**
    * 关系实体参数对象
    *
    * @public
    * @type {any[]}
    * @memberof MobMeditViewPanelControlBase
    */
    public deResParameters: any[] = [];

    /**
     * 当前应用视图参数对象
     *
     * @public
     * @type {any[]}
     * @memberof MobMeditViewPanelControlBase
     */
    public parameters: any[] = [];

    /**
     * 多编辑视图面板初始化
     *
     * @memberof MobMeditViewPanelControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.controlInstance.name)) {
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
     * 部件模型数据初始化
     *
     * @memberof MobMeditViewPanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit(args);
        if (!(this.Environment?.isPreviewMode)) {
            this.service = new AppMobMEditViewPanelService(this.controlInstance, this.context, { localSourceTag: this.localSourceTag });
            await this.service.initServiceParam(this.controlInstance)
        }
        if (this.controlInstance.getEmbeddedPSAppView() && !this.controlInstance.getEmbeddedPSAppView()?.isFill) {
            await this.controlInstance.getEmbeddedPSAppView()?.fill();
        }
        await this.initParameters();
    }

    /**
     * 初始化嵌入应用视图及实体参数对象
     *
     * @memberof MobMeditViewPanelControlBase
     */
    public async initParameters() {
        const emView = this.controlInstance.getEmbeddedPSAppView() as IPSAppView;
        const emViewEntity = emView?.getPSAppDataEntity();
        if (emView && emViewEntity) {
            if (!emViewEntity.isFill) {
                await emViewEntity.fill();
            }
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
     * @memberof MobMeditViewPanelControlBase
     */
    public saveData(data?: any) {
        this.count = 0;
        const emView = this.controlInstance.getEmbeddedPSAppView() as IPSAppView;
        if (this.items.length > 0) {
            Object.assign(data, { showResultInfo: false });
            this.panelState.next({ tag: emView.name, action: 'save', data: data });
        }
        this.ctrlEvent({ controlname: this.controlInstance.name, action: "drdatasaved", data: { action: 'drdatasaved' } });
    }

    /**
     * 处理数据
     *
     * @public
     * @param {any[]} datas
     * @memberof MobMeditViewPanelControlBase
     */
    public doItems(datas: any[], isReplace: boolean = true): void {
        if (isReplace) {
            this.items = [];
        }
        const [{ parameterName }] = this.parameters;
        const emView = this.controlInstance.getEmbeddedPSAppView() as IPSAppView;
        datas.forEach((arg: any) => {
            let id: string = arg[parameterName] ? arg[parameterName] : this.$util.createUUID();
            let item: any = { id: id, _context: {}, viewparam: {}, data: arg };
            Object.assign(item._context, ViewTool.getIndexViewParam());
            Object.assign(item._context, this.context);

            // 关系应用实体参数
            this.deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
                if (this.context[parameterName] && !Object.is(this.context[parameterName], '')) {
                    Object.assign(item._context, { [parameterName]: this.context[parameterName] });
                } else if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                    Object.assign(item._context, { [parameterName]: arg[parameterName] });
                }
            });

            // 当前视图参数（应用实体视图）
            this.parameters.forEach(({ pathName, parameterName, srfmajortext }: { pathName: string, parameterName: string, srfmajortext: string }) => {
                if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                    Object.assign(item._context, { [parameterName]: arg[parameterName] });
                }
                // 当前页面实体主信息
                if (arg[srfmajortext] && !Object.is(arg[srfmajortext], '')) {
                    Object.assign(item, { srfmajortext: arg[srfmajortext] });
                }
            });

            //合并视图参数
            Object.assign(item.viewparam, this.viewparams);
            this.items.push(item);
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
            // todo R7模板都错的，遇到场景在修改吧
            if ($event.data) {
                let resultIndex = this.items.findIndex((value: any, index: any, arr: any) => {
                    return value['viewdata']['srfkey'] === $event.data['srfkey'];
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
     * 数据加载
     *
     * @public
     * @param {*} data
     * @memberof MobMeditViewPanelControlBase
     */
    public async load(data: any): Promise<any> {
        if (!this.fetchAction) {
            this.$Notice.error(`${this.$t('app.viewName.meditView')}fetchAction${this.$t('app.commonWords.noAction')}`);
            return;
        }
        let arg: any = {};
        if (!(await this.handleCtrlEvents('onbeforeload', { action: this.fetchAction, data: data }))) {
            return;
        }
        Object.assign(arg, data, { viewparams: this.viewparams });
        try {
            const response: any = await this.service.get(this.fetchAction, JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, data: response.data }))) {
                    return response;
                }
                if (response.errorMessage) {
                    this.$Notice.error(response.errorMessage);
                }
                return response;
            }
            if (!(await this.handleCtrlEvents('onloadsuccess', { action: this.fetchAction, data: response.data }))) {
                return response;
            }
            if (response?.data?.length > 0) {
                const items = Util.deepCopy(response.data);
                this.doItems(items);
            }
        } catch (response: any) {
            if (!(await this.handleCtrlEvents('onloaderror', { action: this.fetchAction, data: response.data }))) {
                return response;
            }
            if (response && response.status === 401) {
                return response;
            }
            this.$Notice.error(response.errorMessage);
        }
    }

    /**
     * 增加数据
     * 
     * @memberof MobMeditViewPanelControlBase
     */
    public async addItem() {
        if (!this.loaddraftAction) {
            this.$Notice.error(`${this.$t('app.viewName.meditView')}loaddraftAction${this.$t('app.commonWords.noAction')}`);
            return;
        }
        if (!(await this.handleCtrlEvents('onbeforeloaddraft', { action: this.loaddraftAction, data: null }))) {
            return;
        }
        try {
            const response: any = await this.service.loadDraft(this.loaddraftAction, JSON.parse(JSON.stringify(this.context)), { viewparams: this.viewparams }, this.showBusyIndicator);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, data: response?.data }))) {
                    return response;
                }
                if (response.errorMessage) {
                    this.$Notice.error(response.errorMessage);
                }
                return response;
            }
            if (!(await this.handleCtrlEvents('onloaddraftsuccess', { action: this.loaddraftAction, data: response?.data }))) {
                return response;
            }
            const data: any = response.data;
            this.doItems([data], false);
        } catch (response: any) {
            if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, data: response?.data }))) {
                return response;
            }
            if (response && response.status === 401) {
                return response;
            }
            this.$Notice.error(response.errorMessage);
        }
    }

    /**
     * 删除数据
     * @memberof MobMeditViewPanelControlBase
     */
    public async deleteItem(item: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (!(await this.handleCtrlEvents('onbeforeremove', { action: this.removeAction, data: item }))) {
            return null;
        }
        // 新建的界面上删除即可
        if (item.data.srfuf == "0") {
            //删除items中已删除的项
            let index = this.items.findIndex((value: any, index: any, arr: any) => {
                return value === item;
            });
            this.items.splice(index, 1);
            if (!(await this.handleCtrlEvents('onremovesuccess', { action: this.removeAction, data: item }))) {
                return null;
            }
        } else {
            // 原有的走接口删除
            let tempContext: any = JSON.parse(JSON.stringify(this.context));
            Object.assign(tempContext, { [this.appDeCodeName.toLowerCase()]: item.id });
            let viewparams: any = JSON.parse(JSON.stringify(this.viewparams));
            const arg = { [this.appDeCodeName.toLowerCase()]: item.id };
            Object.assign(arg, { viewparams: this.viewparams })
            this.onControlRequset('handleDelete', tempContext, viewparams);
            try {
                const response: any = await this.service.delete(this.removeAction, tempContext, arg, this.showBusyIndicator);
                this.onControlResponse('handleDelete', response);
                if (!response.status || response.status !== 200) {
                    if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, data: item }))) {
                        return null;
                    }
                    return;
                }
                if (!(await this.handleCtrlEvents('onremovesuccess', { action: this.removeAction, data: item }))) {
                    return null;
                }
                //删除items中已删除的项
                let index = this.items.findIndex((value: any, index: any, arr: any) => {
                    return value.id === item.id;
                });
                index != -1 && (this.items.splice(index, 1));
            } catch (response) {
                if (!(await this.handleCtrlEvents('onremoveerror', { action: this.removeAction, data: item }))) {
                    return null;
                }
                this.onControlResponse('handleDelete', response);
            }


            
        }
    }
}
