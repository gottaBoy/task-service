import {
    getPSUIActionByModelObject,
    IPSAppDEUIAction,
    IPSAppViewLogic,
    IPSAppViewUIAction
} from '@ibiz/dynamic-model-api';
import { LogUtil, UIServiceHelp, Util } from 'ibiz-core';
import { AppGlobalService } from './app-global-action-service';

/**
 * 视图逻辑服务
 *
 * @export
 * @class AppViewLogicService
 */
export class AppViewLogicService {
    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppViewLogicService}
     * @memberof AppViewLogicService
     */
    private static appViewLogicService: AppViewLogicService;

    /**
     * 获取 AppViewLogicService 单例对象
     *
     * @static
     * @returns {AppViewLogicService}
     * @memberof AppViewLogicService
     */
    public static getInstance(): AppViewLogicService {
        if (!AppViewLogicService.appViewLogicService) {
            AppViewLogicService.appViewLogicService = new AppViewLogicService();
        }
        return this.appViewLogicService;
    }

    /**
     * 构造AppViewLogicService对象
     *
     * @memberof AppViewLogicService
     */
    constructor(opts?: any) { }

    /**
     * 执行视图逻辑
     *
     * @param itemTag 触发标识
     * @param $event 触发事件源
     * @param actionContext 操作上下文环境
     * @param params 附加参数
     * @param viewlogicData 当前容器视图逻辑集合
     * @memberof AppViewLogicService
     */
    public async executeViewLogic(
        itemTag: string,
        $event: any,
        actionContext: any,
        params: any = {},
        viewlogicData: Array<IPSAppViewLogic> | null,
    ) {
        if (!viewlogicData) {
            return;
        }
        let targetViewLogic: any = viewlogicData.find((item: any) => {
            return item.name === itemTag;
        });
        await this.prepareActionParams(targetViewLogic, $event, actionContext, params);
    }

    /**
     * 执行逻辑
     *
     * @param {IPSAppViewLogic} logic
     * @param {*} $event
     * @param {*} actionContext
     * @param {*} [params]
     */
    public async executeLogic(logic: IPSAppViewLogic, $event: any, actionContext: any, params?: any) {
        await this.prepareActionParams(logic, $event, actionContext, params);
    }

    /**
     * 准备界面行为参数
     *
     * @param viewLogic  视图逻辑
     * @param $event 触发事件源
     * @param actionContext 操作上下文环境
     * @param params 附加参数
     *
     * @memberof AppViewLogicService
     */
    private async prepareActionParams(viewLogic: IPSAppViewLogic, $event: any, actionContext: any, params: any = {}) {
        if (!viewLogic) {
            LogUtil.warn('无事件参数未支持');
            return;
        }
        if (!Object.is(viewLogic.logicType, 'APPVIEWUIACTION') || !viewLogic.getPSAppViewUIAction) {
            return;
        }
        const targetViewAction: IPSAppViewUIAction | null = viewLogic.getPSAppViewUIAction();
        if (!targetViewAction) {
            LogUtil.warn('视图界面行为不存在');
            return;
        }
        await (targetViewAction as IPSAppViewUIAction).fill();
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        if (actionContext) {
            if (!targetViewAction.xDataControlName) {
                if (actionContext.getDatas && actionContext.getDatas instanceof Function) {
                    datas = [...actionContext.getDatas()];
                }
            } else {
                //  逻辑事件源为自定义视图布局面板
                if (Object.is(actionContext.type, 'VIEWLAYOUT')) {
                    if ($event && $event.srfid) {
                        xData = actionContext.layoutDetailsModel[$event.srfid];
                    } else {
                        xData = this.getXDataForCustomViewLayoutPanel(actionContext);
                    }
                } else if (!Object.is(viewLogic.getParentPSModelObject().name.toLocaleLowerCase(), targetViewAction.xDataControlName.toLocaleLowerCase()) && actionContext.$refs[targetViewAction.xDataControlName.toLowerCase()]) {
                    // 界面行为数据部件与控件容器不同时，即逻辑事件在视图里时
                    xData = actionContext.$refs[targetViewAction.xDataControlName.toLowerCase()].ctrl;
                } else {
                    xData = actionContext;
                }
                if (xData && xData.getDatas && xData.getDatas instanceof Function) {
                    datas = [...xData.getDatas()];
                }
            }
            if (params && Object.keys(params).length > 0) {
                datas = [params];
            }
        } else {
            if (params && Object.keys(params).length > 0) {
                datas = [params];
            }
        }
        // 执行行为
        await this.executeAction(viewLogic, targetViewAction, datas, xData, $event, actionContext);
    }

    /**
     * 获取数据部件（数据源为自定义视图布局面板时）
     *
     * @private
     * @param {*} actionContext
     * @return {*} 
     * @memberof AppViewLogicService
     */
    private getXDataForCustomViewLayoutPanel(actionContext: any) {
        const xDataMap: string[] = ['GRID', 'LIST', 'FORM', 'TREEVIEW', 'DATAVIEW', 'CALENDAR' ];
        try {
            const controlRefs: any = actionContext.viewProxyMode ? actionContext.$refs : actionContext.$slots;
            const allControls: any[] = actionContext.viewProxyMode ? actionContext.viewLayoutPanel.getPSControls() : actionContext.viewInstance.getPSControls();
            if (controlRefs && allControls && (allControls.length > 0)) {
                const xDataControl = allControls.find((control: any) => xDataMap.indexOf(control.controlType) !== -1);
                // 非视图代理模式
                if (!actionContext.viewProxyMode) {
                    return (controlRefs && xDataControl) ? controlRefs[`layout-${xDataControl.name.toLowerCase()}`]?.[0]?.child?.ctrl : null;
                } else {
                    return (controlRefs && xDataControl) ? controlRefs[`${xDataControl.name.toLowerCase()}`]?.ctrl : null;
                }
            } else {
                return null;
            }
        } catch (error: any) {
            return null;
        }
    }

    /**
     * 执行行为
     *
     * @param viewLogic  视图逻辑
     * @param targetViewAction  视图界面行为
     * @param datas 参数
     * @param xData 数据部件
     * @param $event 触发事件源
     * @param actionContext 操作上下文环境
     *
     * @memberof AppViewLogicService
     */
    private async executeAction(viewLogic: IPSAppViewLogic, targetViewAction: IPSAppViewUIAction, datas: any, xData: any, $event: any, actionContext: any) {
        const contextJO: any = Util.deepCopy(actionContext.context ? actionContext.context : {});
        const paramJO: any = Util.deepCopy(actionContext.viewparams ? actionContext.viewparams : {});
        const targetParentObject: any = viewLogic.getParentPSModelObject();
        const targetUIAction = (await getPSUIActionByModelObject(targetViewAction)) as IPSAppDEUIAction;
        if (targetUIAction.predefinedType) {
            if (targetParentObject && targetParentObject?.getPSAppDataEntity()) {
                Object.assign(contextJO, { srfparentdemapname: targetParentObject?.getPSAppDataEntity()?.getPSDEName() });
                (AppGlobalService.getInstance() as any).executeGlobalAction(
                    targetUIAction.predefinedType,
                    datas,
                    contextJO,
                    paramJO,
                    $event,
                    xData,
                    actionContext,
                    targetParentObject?.getPSAppDataEntity()?.codeName.toLowerCase(),
                    targetUIAction
                );
            } else {
                (AppGlobalService.getInstance() as any).executeGlobalAction(
                    targetUIAction.predefinedType,
                    datas,
                    contextJO,
                    paramJO,
                    $event,
                    xData,
                    actionContext,
                    undefined,
                    targetUIAction
                );
            }
        } else {
            if (targetUIAction && targetUIAction.getPSAppDataEntity()) {
                Object.assign(contextJO, { srfparentdemapname: targetParentObject?.getPSAppDataEntity()?.getPSDEName() });
                const targetUIService: any = await UIServiceHelp.getInstance().getService(
                    targetUIAction.getPSAppDataEntity(),
                    {context:contextJO}
                );
                await targetUIService.loaded();
                targetUIService.excuteAction(
                    targetUIAction.uIActionTag,
                    datas,
                    contextJO,
                    paramJO,
                    $event,
                    xData,
                    actionContext,
                    targetParentObject?.getPSAppDataEntity()?.codeName.toLowerCase(),
                );
            }else{
                 // 全局界面行为插件
                (AppGlobalService.getInstance() as any).executeGlobalAction(
                    targetUIAction.codeName,
                    datas,
                    contextJO,
                    paramJO,
                    $event,
                    xData,
                    actionContext,
                    undefined,
                    targetUIAction
                );
            }
        }
    }

}