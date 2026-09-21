import { IPSDEUIActionLogic, getDstPSAppDEUIAction, IPSDEUILogicParam } from '@ibiz/dynamic-model-api';
import { AppServiceBase, UIServiceHelp } from 'ibiz-core';
import { UILogicParamType } from '../const/ui-logic-param-type';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 实体界面行为调用节点
 *
 * @export
 * @class AppUILogicDeUIActionNode
 */
export class AppUILogicDeUIActionNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIActionLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDeUIActionNode
     */
    public async executeNode(logicNode: IPSDEUIActionLogic, actionContext: UIActionContext) {
        try {
            await this.handleDEUIAction(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext)
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理界面行为 
     *
     * @private
     * @param {IPSDEUIActionLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicDeUIActionNode
     */
    private async handleDEUIAction(logicNode: IPSDEUIActionLogic, actionContext: UIActionContext) {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (Environment.enableUILogicIssue) {
            return this.executeUIAction(logicNode, actionContext);
        } else {
            return this.executeDefaultUIAction(logicNode, actionContext);
        }
    }

    /**
     * 执行默认界面行为（适配之前的逻辑）
     *
     * @private
     * @param {IPSDEUIActionLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicDeUIActionNode
     */
    private async executeDefaultUIAction(logicNode: IPSDEUIActionLogic, actionContext: UIActionContext) {
        const data = actionContext.defaultParam.getReal();
        const { context, viewparams } = actionContext;
        const additionalParam = actionContext.additionalParam;
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const dstUIAction = await getDstPSAppDEUIAction(logicNode);
        if (dstEntity && dstUIAction) {
            try {
                const targetUIService = await UIServiceHelp.getInstance().getService(dstEntity,{context});
                await targetUIService.loaded();
                const result = await targetUIService.excuteAction(
                    dstUIAction.uIActionTag,
                    [data],
                    context,
                    viewparams,
                    additionalParam?.$event,
                    actionContext.getParam(actionContext.activeCtrlParamName)?.getReal(),
                    actionContext.getParam(actionContext.activeContainerParamName)?.getReal(),
                    additionalParam?.parentDeName,
                );
                const dstParam = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
                if (result && result.ok && result.result) {
                    dstParam.bind(Array.isArray(result?.result) ? result.result[0] : result.result);
                    actionContext.bindLastReturnParam(Array.isArray(result?.result) ? result.result[0] : result.result);
                }
                return dstParam;
            } catch (error: any) {
                throw new Error(`调用实体行为异常${error?.message ? error.message : ''}`);
            }
        } else {
            throw new Error(`调用界面行为参数不足`);
        }
    }

    /**
     * 执行界面行为
     *
     * @private
     * @param {IPSDEUIActionLogic} logicNode
     * @param {UIActionContext} actionContext
     * @return {*} 
     * @memberof AppUILogicDeUIActionNode
     */
    private async executeUIAction(logicNode: IPSDEUIActionLogic, actionContext: UIActionContext) {
        const dstParam = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        let data: any[] = [];
        if (Object.is(dstParam.logicParamType, UILogicParamType.entityListParam)) {
            data = dstParam.getReal();
        } else if (Object.is(dstParam.logicParamType, UILogicParamType.entityParam)) {
            data = [dstParam.getReal()];
        } else {
            throw new Error(`界面行为操作参数只能为数据对象变量类型或者数据对象列表类型`);
        }
        const retParam = actionContext.getParam(logicNode.M.getRetPSDEUILogicParam?.id);
        const { context, viewparams } = actionContext;
        const additionalParam = actionContext.additionalParam;
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const dstUIAction = await getDstPSAppDEUIAction(logicNode);
        if (dstEntity && dstUIAction && dstParam) {
            try {
                const targetUIService = await UIServiceHelp.getInstance().getService(dstEntity,{context});
                await targetUIService.loaded();
                const result = await targetUIService.excuteAction(
                    dstUIAction.uIActionTag,
                    [data],
                    context,
                    viewparams,
                    additionalParam?.$event,
                    actionContext.getParam(actionContext.activeCtrlParamName)?.getReal(),
                    actionContext.getParam(actionContext.activeContainerParamName)?.getReal(),
                    additionalParam?.parentDeName,
                );
                if (result && result.ok && result.result) {
                    if (retParam) {
                        retParam.bind(result.result);
                    }
                    actionContext.bindLastReturnParam(result.result);
                }
                return dstParam;
            } catch (error: any) {
                throw new Error(`调用实体行为异常${error?.message ? error.message : ''}`);
            }
        } else {
            throw new Error(`调用界面行为参数不足`);
        }
    }
}