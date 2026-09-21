import {
    getPSUIActionByModelObject,
    IPSAppDataEntity,
    IPSAppDEField,
    IPSAppDEMethod,
    IPSAppView
} from '@ibiz/dynamic-model-api';
import { DataServiceHelp, ModelTool, UIActionTool, Util } from 'ibiz-core';
import { AppCenterService, AppGlobalService } from '../app-service';
import { NoticeHandler } from '../utils';
import { AppDEUIAction } from './app-ui-action';
import { UIActionResult } from './appuilogic';

export class AppBackEndAction extends AppDEUIAction {

    /**
     * 是否合并参数
     *
     * @memberof AppBackEndAction
     */
    public isMergeParam: boolean = false;

    /**
     * 初始化AppBackEndAction
     *
     * @memberof AppBackEndAction
     */
    constructor(opts: any, context?: any) {
        super(opts, context);
        const method: IPSAppDEMethod = this.actionModel.getPSAppDEMethod() as IPSAppDEMethod;
        if (method?.M && (method.M.customCode || !method.M.getPSDEServiceAPIMethod)) {
            this.isMergeParam = true;
        }
    }

    /**
     * 执行界面行为
     *
     * @param args
     * @param context
     * @param params
     * @param $event
     * @param xData
     * @param actionContext
     * @param srfParentDeName
     *
     * @memberof AppBackEndAction
     */
    public async execute(
        args: any[],
        context: any = {},
        params: any = {},
        $event?: any,
        xData?: any,
        actionContext?: any,
        srfParentDeName?: string,
        deUIService?: any,
    ) {
        if (Object.is(this.actionModel?.uILogicAttachMode, 'REPLACE')) {
            return this.executeDEUILogic(args, context, params, $event, xData, actionContext, srfParentDeName);
        }
        const actionTarget: string | null = this.actionModel.actionTarget;
        if (this.actionModel.enableConfirm && this.actionModel.confirmMsg) {
            let confirmResult: boolean = await new Promise((resolve: any, reject: any) => {
                actionContext.$Modal.confirm({
                    title: actionContext.$t('app.commonwords.warning'),
                    content: `${this.actionModel.confirmMsg}`,
                    onOk: () => {
                        resolve(true);
                    },
                    onCancel: () => {
                        resolve(false);
                    },
                });
            });
            if (!confirmResult) {
                return;
            }
        }
        if (Object.is(actionTarget, 'MULTIDATA')) {
            actionContext.$throw(actionContext.$t('app.commonwords.nosupportmultiple'), 'AppBackEndAction');
        } else {
            let data: any = {};
            let tempData: any = {};
            let tempContext: any = {};
            let tempViewParam: any = {};
            const _this: any = actionContext;
            if (this.actionModel.saveTargetFirst && xData) {
                const result: any = await xData.save(args, false);
                if (Object.is(actionTarget, 'SINGLEDATA')) {
                    Object.assign(args[0], result.data);
                } else {
                    args = [result.data];
                }
            }
            const entityName: string = (this.actionModel.getPSAppDataEntity() as IPSAppDataEntity).codeName.toLowerCase();
            const key = (ModelTool.getAppEntityKeyField(
                this.actionModel.getPSAppDataEntity(),
            ) as IPSAppDEField)?.name.toLowerCase();
            const majorKey = (ModelTool.getAppEntityMajorField(
                this.actionModel.getPSAppDataEntity(),
            ) as IPSAppDEField)?.name.toLowerCase();
            if (Object.is(actionTarget, 'SINGLEKEY') || Object.is(actionTarget, 'MULTIKEY')) {
                // todo 后台调用获取主键及主信息属性的name
                if (args[0]?.[key]) {
                    Object.assign(tempContext, { [entityName!]: `%${key}%` });
                } else {
                    Object.assign(tempContext, { [entityName!]: `%${entityName}%` });
                }
                Object.assign(tempViewParam, { [key!]: `%${key}%` });
                Object.assign(tempViewParam, { [majorKey]: `%${majorKey}%` });
            } else if (Object.is(actionTarget, 'SINGLEDATA')) {
                data = args[0] ? args[0] : {};
            }
            // 自定义导航参数优先级大于预置导航参数
            const navigateContexts = this.actionModel.getPSNavigateContexts();
            if (navigateContexts && navigateContexts.length > 0) {
                const localContext = Util.formatNavParam(navigateContexts);
                Object.assign(tempContext, localContext);
            }
            const navigateParams = this.actionModel.getPSNavigateParams();
            if (navigateParams && navigateParams.length > 0) {
                const localParam = Util.formatNavParam(navigateParams);
                Object.assign(tempViewParam, localParam);
            }
            tempContext = UIActionTool.handleContextParam(actionTarget, args, context, params, tempContext);
            if (Object.is(actionTarget, 'SINGLEDATA')) {
                tempData = UIActionTool.handleActionParam(actionTarget, args, context, params, tempViewParam);
                Object.assign(data, tempData);
            } else {
                data = UIActionTool.handleActionParam(actionTarget, args, context, params, tempViewParam);
            }
            // 多项数据主键转换数据
            if (Object.is(actionTarget, 'MULTIKEY')) {
                let tempDataArray: Array<any> = [];
                if (args.length > 1 && Object.keys(data).length > 0) {
                    for (let i = 0; i < args.length; i++) {
                        let tempObject: any = {};
                        Object.keys(data).forEach((key: string) => {
                            Object.assign(tempObject, { [key]: data[key].split(',')[i] });
                        });
                        tempDataArray.push(tempObject);
                    }
                } else {
                    tempDataArray.push(data);
                }
                data = tempDataArray;
            }
            Object.assign(context, tempContext);
            // 构建srfparentdename和srfparentkey
            let parentObj: any = {
                srfparentdename: srfParentDeName ? srfParentDeName : null,
                srfparentkey: srfParentDeName ? context[srfParentDeName.toLowerCase()] : null,
            };
            if (!Object.is(actionTarget, 'MULTIKEY')) {
                Object.assign(data, parentObj);
            }
            Object.assign(context, parentObj);
            if (context && context.srfsessionid) {
                context.srfsessionkey = context.srfsessionid;
                delete context.srfsessionid;
            }
            const backend = () => {
                if (xData && xData.formValidateStatus instanceof Function) {
                    if (!xData.formValidateStatus()) {
                        actionContext.$throw(actionContext.$t('app.searchform.globalerrortip') as string, 'save', { dangerouslyUseHTMLString: true });
                        return;
                    }
                }
                if (this.actionModel.getPSAppDataEntity() && this.actionModel.getPSAppDEMethod()) {
                    DataServiceHelp.getInstance().getService((this.actionModel.getPSAppDataEntity() as IPSAppDataEntity))
                        .then(async (curService: any) => {
                            const method: IPSAppDEMethod = this.actionModel.getPSAppDEMethod() as IPSAppDEMethod;
                            let methodCodeName = method?.codeName;
                            let viewLoadingService = actionContext.viewLoadingService ? actionContext.viewLoadingService : {};
                            viewLoadingService.isLoading = true;
                            let promises: any;
                            if (Object.is(actionTarget, 'MULTIKEY')) {
                                let promiseArr: any = [];
                                if (data && data.length > 0) {
                                    const key = this.actionModel.getPSAppDataEntity?.()?.codeName?.toLowerCase() as string;
                                    const srfkeys = context[key]?.split(',');
                                    data.forEach((ele: any, index: number) => {
                                        const tempContext = Util.deepCopy(context);
                                        Object.assign(tempContext, { [key]: srfkeys[index] });
                                        promiseArr.push(curService.execute(methodCodeName, tempContext, ele));
                                    })
                                }
                                promises = Promise.all(promiseArr);
                            } else {
                                promises = curService.execute(
                                    methodCodeName,
                                    context,
                                    data,
                                )
                            }
                            promises.then(async (response: any) => {
                                if (Object.is(actionTarget, 'SINGLEDATA')) {
                                    Util.clearAdditionalData(tempData, args[0]);
                                }
                                if ((!response || response.status !== 200) && !Array.isArray(response)) {
                                    actionContext.$throw(response, 'AppBackEndAction');
                                    return;
                                }
                                let { data } = response;
                                if (response && Array.isArray(response) && response.length > 0) {
                                    data = [];
                                    response.forEach((item: any) => {
                                        data.push(item?.data);
                                    })
                                }
                                if (this.isMergeParam && args && args.length > 0 && Object.prototype.toString.call(data) === '[Object Object]') {
                                    Object.assign(args[0], data);
                                    actionContext.$forceUpdate();
                                }
                                viewLoadingService.isLoading = false;
                                if (this.actionModel.showBusyIndicator) {
                                    if (this.actionModel.successMsg) {
                                        NoticeHandler.message(response,() =>{
                                            actionContext.$success(this.actionModel.successMsg, 'AppBackEndAction');
                                        })
                                    }
                                }
                                // 界面行为重新加载数据模式(0：无、 1：引用视图或树节点、 2：引用树节点父节点、 3：引用树节点根节点 )
                                if (
                                  this.actionModel.reloadData
                                ) {
                                    if(xData && xData.refresh && xData.refresh instanceof Function){
                                        xData.refresh();
                                    }
                                    // 当刷新模式为刷新引用视图时，表单执行后台行为后全局通知该实体刷新
                                    if (this.actionModel.refreshMode === 1 && xData && xData.controlInstance && Object.is('FORM', xData.controlInstance.controlType)) {
                                        let refreshData = args;
                                        if (Object.is(actionTarget, 'SINGLEDATA')) {
                                            const data = args[0];
                                            refreshData =[{
                                                [key]: data[key],
                                                [majorKey]: data[majorKey],
                                                [entityName]: data[key] || data[entityName],
                                            }]
                                        }
                                        AppCenterService.notifyMessage({ name: (this.actionModel.getPSAppDataEntity() as IPSAppDataEntity)?.codeName, action: 'appRefresh', data: refreshData });
                                    }
                                    if (this.actionModel.refreshMode === 2 && actionContext.viewCtx){
                                        const parentView =  actionContext.viewCtx.parentview;
                                        if(parentView && parentView.refresh && parentView.refresh instanceof Function){
                                            parentView.refresh();
                                        }
                                    }
                                    if (this.actionModel.refreshMode === 3 && actionContext.viewCtx){
                                        const topView =  actionContext.viewCtx.topview;
                                        if(topView && topView.refresh && topView.refresh instanceof Function){
                                            topView.refresh();
                                        }
                                    }
                                }
                                if (this.actionModel.closeEditView) {
                                    actionContext.$store.commit('viewAction/setViewDataChange', { viewTag: actionContext.viewtag, viewDataChange: false });
                                    actionContext.closeView(null);
                                }
                                // 后续界面行为
                                if (this.actionModel.M?.getNextPSUIAction) {
                                    let { data: result } = response;
                                    if (response && Array.isArray(response) && response.length > 0) {
                                        result = [];
                                        response.forEach((item: any) => {
                                            result.push(item?.data);
                                        })
                                    }
                                    let _args: any[] = [];
                                    if (Object.is(actionContext.$util.typeOf(result), 'array')) {
                                        _args = [...result];
                                    } else if (Object.is(actionContext.$util.typeOf(result), 'object')) {
                                        _args = result && Object.keys(result).length > 0 ? [{ ...result }] : Util.deepCopy(args);
                                    } else {
                                        _args = Util.deepCopy(args);
                                    }
                                    getPSUIActionByModelObject(this.actionModel).then((nextUIaction: any) => {
                                        if (nextUIaction.getPSAppDataEntity()) {
                                            let [tag, appDeName] = nextUIaction.id.split('@');
                                            if (deUIService) {
                                                return deUIService.excuteAction(
                                                    tag,
                                                    _args,
                                                    context,
                                                    params,
                                                    $event,
                                                    xData,
                                                    actionContext,
                                                    undefined,
                                                    deUIService,
                                                );
                                            }
                                        } else {
                                            return (AppGlobalService.getInstance() as any).executeGlobalAction(
                                                nextUIaction.id,
                                                _args,
                                                context,
                                                params,
                                                $event,
                                                xData,
                                                actionContext,
                                                undefined,
                                            );
                                        }
                                    });
                                } else {
                                    if (Object.is(this.actionModel?.uILogicAttachMode, 'AFTER')) {
                                        if (actionContext.context) {
                                            Object.assign(context, actionContext.context);
                                        }
                                        return this.executeDEUILogic(args, context, params, $event, xData, actionContext, context?.srfparentdename);
                                    } else {
                                        return new UIActionResult({ ok: true, result: args });
                                    }
                                }
                            })
                                .catch((response: any) => {
                                    viewLoadingService.isLoading = false;
                                    if (response) {
                                        actionContext.$throw(response, 'AppBackEndAction');
                                    }
                                });
                        });
                }
            };
            if (this.actionModel.getFrontPSAppView()) {
                const frontPSAppView: IPSAppView | null = this.actionModel.getFrontPSAppView();
                await frontPSAppView?.fill(true);
                if (!frontPSAppView) {
                    return;
                }
                if (frontPSAppView.openMode?.indexOf('DRAWER') !== -1) {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                        placement: frontPSAppView.openMode,
                    };
                    if (frontPSAppView && frontPSAppView.modelPath) {
                        Object.assign(context, { viewpath: frontPSAppView.modelPath });
                    }
                    const appdrawer = actionContext.$appdrawer.openDrawer(view, Util.getViewProps(context, data, args));
                    appdrawer.subscribe((result: any) => {
                        if (result && Object.is(result.ret, 'OK')) {
                            if(data && data instanceof Array && data.length >0){
                                data.forEach((item:any) =>{
                                    Object.assign(item,{ srfactionparam: result.datas });
                                })
                            }else{
                                Object.assign(data, { srfactionparam: result.datas });
                            }
                            backend();
                        }
                    });
                } else {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                    };
                    if (frontPSAppView && frontPSAppView.modelPath) {
                        Object.assign(context, { viewpath: frontPSAppView.modelPath });
                    }
                    const appmodal = actionContext.$appmodal.openModal(view, context, data, args);
                    appmodal.subscribe((result: any) => {
                        if (result && Object.is(result.ret, 'OK')) {
                            if(data && data instanceof Array && data.length >0){
                                data.forEach((item:any) =>{
                                    Object.assign(item,{ srfactionparam: result.datas });
                                })
                            }else{
                                Object.assign(data, { srfactionparam: result.datas });
                            }
                            backend();
                        }
                    });
                }
            } else {
                backend();
            }
        }
    }

}