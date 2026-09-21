import { IPSDEUILogicParam, IPSDEUIResetParamLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 重置参数节点
 *
 * @export
 * @class AppUILogicResetParamNode
 */
export class AppUILogicResetParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIResetParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicResetParamNode
     */
    public async executeNode(logicNode: IPSDEUIResetParamLogic, actionContext: UIActionContext) {
        try {
            this.onResetParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理参数
     *
     * @param {IPSDELogicNode} logicNode 节点模型数据
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicResetParamNode
     */
    public onResetParam(logicNode: IPSDEUIResetParamLogic, actionContext: UIActionContext) {
        if (!logicNode || !logicNode.getDstPSDEUILogicParam()) {
            throw new Error(`操作参数缺失！`);
        }
        try {
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            dstParam.resetAll();
            actionContext.bindLastReturnParam(null);
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNode.getDstPSDEUILogicParam()?.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }
}