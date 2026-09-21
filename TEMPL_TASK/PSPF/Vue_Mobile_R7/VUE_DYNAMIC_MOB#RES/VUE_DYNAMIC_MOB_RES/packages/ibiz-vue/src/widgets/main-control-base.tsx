import { Subscription } from 'rxjs';
import { UIServiceHelp } from 'ibiz-core';
import { AppCenterService, AppLoadingService } from '../app-service';
import { AppControlBase } from './app-control-base';
import { MobMainControlInterface, ModelTool, Util } from 'ibiz-core';
import { IPSAppDataEntity, IPSAppDEField, IPSAppDEUIAction, IPSDEFormButton, IPSDEFormDetail, IPSDEFormGroupPanel, IPSUIActionGroupDetail } from '@ibiz/dynamic-model-api';

/**
 * 部件基础公共基类
 *
 * @export
 * @class MainControlBase
 * @extends {AppControlBase}
 */
export class MainControlBase extends AppControlBase implements MobMainControlInterface {

    /**
     * 编辑视图
     *
     * @type {*}
     * @memberof MainControlBase
     */
    public opendata?: any;

    /**
     * 新建视图
     *
     * @type {*}
     * @memberof MainControlBase
     */
    public newdata?: any;


    /**
     * 应用实体codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeCodeName() {
        return this.controlInstance?.getPSAppDataEntity?.()?.codeName || '';
    }

    /**
     * 应用实体主键属性codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeKeyFieldName() {
        return (ModelTool.getAppEntityKeyField(this.controlInstance?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName || '';
    }

    /**
     * 应用实体主信息属性codeName
     *
     * @readonly
     * @memberof MainViewBase
     */
    get appDeMajorFieldName() {
        return (ModelTool.getAppEntityMajorField(this.controlInstance?.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName || '';
    }

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ListControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            this.newdata = newVal.newdata;
            this.opendata = newVal.opendata;
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 加载服务
     *
     * @type {AppLoading}
     * @memberof MainControlBase
     */
    public ctrlLoadingService: AppLoadingService = new AppLoadingService();

    /**
     * 开始加载
     */
    public ctrlBeginLoading() {
    }

    /**
     * 结束加载
     */
    public endLoading() {
    }

    /**
     * 应用状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainControlBase
     */
    public appStateEvent: Subscription | undefined;

    /**
     * 界面UI服务对象
     *
     * @type {*}
     * @memberof MainControlBase
     */
    public appUIService: any;

    /**
     * 界面行为模型
     *
     * @type {*}
     * @memberof MainControlBase
     */
    public actionModel: any = {};

    /**
     * 部件模型数据初始化
     *
     * @memberof MainControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        this.initCtrlActionModel();
        if (!(this.Environment?.isPreviewMode)) {
            this.appUIService = await UIServiceHelp.getInstance().getService(this.controlInstance.getPSAppDataEntity(),this.context);
        }
    }

    /**
     * 初始化界面行为模型
     *
     * @type {*}
     * @memberof MainControlBase
     */
    public initCtrlActionModel() { 
        let allFormDetails: IPSDEFormDetail[] = ModelTool.getAllFormDetails(this.controlInstance);
        if (allFormDetails?.length > 0) {
            allFormDetails.forEach((detail: IPSDEFormDetail) => {
                if (detail?.detailType == 'BUTTON' && (detail as IPSDEFormButton).getPSUIAction()) {
                    // 添加表单按钮的actionModel
                    const appUIAction: IPSAppDEUIAction = ((detail as IPSDEFormButton).getPSUIAction() as IPSAppDEUIAction);
                    const appUIAction_M = Util.deepCopy(appUIAction.M);
                    this.actionModel[appUIAction.uIActionTag] = Object.assign(appUIAction_M, { disabled: false, visabled: true, getNoPrivDisplayMode: appUIAction.noPrivDisplayMode ? appUIAction.noPrivDisplayMode : 6 });
                } else if (detail?.detailType == 'GROUPPANEL' && (detail as IPSDEFormGroupPanel).getPSUIActionGroup()?.getPSUIActionGroupDetails()?.length) {
                    // 添加表单分组界面行为组的actionModel
                    (detail as IPSDEFormGroupPanel).getPSUIActionGroup()?.getPSUIActionGroupDetails()?.forEach((actionDetail: IPSUIActionGroupDetail) => {
                        if (actionDetail?.getPSUIAction()) {
                            const appUIAction: IPSAppDEUIAction = (actionDetail.getPSUIAction() as IPSAppDEUIAction);
                            const appUIAction_M = Util.deepCopy(appUIAction.M);
                            this.actionModel[appUIAction.uIActionTag] = Object.assign(appUIAction_M, { disabled: false, visabled: true, getNoPrivDisplayMode: appUIAction.noPrivDisplayMode ? appUIAction.noPrivDisplayMode : 6 });
                        }
                    })
                }
            })
        }
    }

    /**
     * 转化数据
     *
     * @param {*} args
     * @memberof  MainControlBase
     */
    public transformData(args: any) {
        if (!this.appDeCodeName) {
            return;
        }
        let _this: any = this;
        if (_this.service && _this.service.handleRequestData instanceof Function && _this.service.handleRequestData('transform', _this.context, args)) {
            return _this.service.handleRequestData('transform', _this.context, args)['data'];
        }
    }

    /**
     * 部件初始化
     *
     * @param {*} [args]
     * @memberof MainControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        // 全局刷新通知
        if (AppCenterService?.getMessageCenter()) {
            this.appStateEvent = AppCenterService.getMessageCenter().subscribe(({ name, action, data }) => {
                const appDataEntity = this.controlInstance?.getPSAppDataEntity?.();
                if (!appDataEntity || !Object.is(name, appDataEntity?.codeName)) {
                    return;
                }
                if (Object.is(action, 'appRefresh')) {
                    this.refresh(data);
                }
            })
        }
    }

    /**
     * 部件销毁
     *
     * @memberof MainControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.appStateEvent) {
            this.appStateEvent.unsubscribe();
        }
    }


    /**
     * 部件刷新数据
     *
     * @param {*} args
     * @memberof  MainControlBase
     */
    public refresh(args?: any): void { }

    /**
     * 获取视图逻辑标识（拼合逻辑：部件标识_列标识_成员标识_click）
     *
     * @param {*} args
     * @memberof  MainControlBase
     */
    public getViewLogicTag(ctrlTag: string, columnTag: any, detailTag: string) {
        return `${ctrlTag}_${columnTag}_${detailTag}_click`;
    }

    /**
     * 处理部件UI请求
     *
     * @memberof MainControlBase
     */
    public onControlRequset(action: string, context: any, viewparam: any) {
        this.ctrlBeginLoading();
    }

    /**
     * 处理部件UI响应
     *
     * @memberof MainControlBase
     */
    public onControlResponse(action: string, response: any) {
        this.endLoading();
        if (Object.is(action, 'load')) {
            this.controlIsLoaded = true;
        }
        if (response?.status == 403) {
            this.enableControlUIAuth = false;
            this.ctrlEvent({
                controlname: this.controlInstance.name,
                action: 'authlimit',
                data: response,
            });
        }
    }
}
