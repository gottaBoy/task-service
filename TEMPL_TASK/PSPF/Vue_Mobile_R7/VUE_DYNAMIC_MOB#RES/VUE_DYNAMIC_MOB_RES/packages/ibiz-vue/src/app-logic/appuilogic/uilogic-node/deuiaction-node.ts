import { IPSDEUIActionLogic, getDstPSAppDEUIAction, IPSDEUILogicParam } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIServiceHelp } from 'ibiz-core';
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
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
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
        const data = actionContext.defaultParam.getReal();
        const { context, viewparams } = actionContext;
        const additionalParam = actionContext.additionalParam;
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const dstUIAction = await getDstPSAppDEUIAction(logicNode);
        if (dstEntity && dstUIAction) {
            try {
                const targetUIService = await UIServiceHelp.getInstance().getService(dstEntity,context);
                const result = await targetUIService.excuteAction(
                    dstUIAction.uIActionTag,
                    [data],
                    context,
                    viewparams,
                    additionalParam?.$event,
                    actionContext.getParam(actionContext.activeCtrlParamName).getReal(),
                    actionContext.getParam(actionContext.activeContainerParamName).getReal(),
                    additionalParam?.parentDeName,
                );
                const dstParam = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
                if (result) {
                    if (result.ok) {
                        if (result.result) {
                            dstParam.bind(Array.isArray(result?.result) ? result.result[0] : result.result);
                            actionContext.bindLastReturnParam(Array.isArray(result?.result) ? result.result[0] : result.result);
                        }
                    }
                    return dstParam;
                } else {
                    throw new Error(`调用界面行为异常`);
                }
            } catch (error: any) {
                throw new Error(`调用实体行为异常${error?.message ? error.message : ''}`);
            }
        } else {
            throw new Error(`调用界面行为参数不足`);
        }
    }
}