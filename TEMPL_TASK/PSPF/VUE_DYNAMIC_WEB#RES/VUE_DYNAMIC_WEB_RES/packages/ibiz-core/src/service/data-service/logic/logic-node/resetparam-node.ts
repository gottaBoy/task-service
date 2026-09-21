import { IPSDEResetParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 重置参数节点
 *
 * @export
 * @class AppDeLogicResetParamNode
 */
export class AppDeLogicResetParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEResetParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicResetParamNode
     */
    public async executeNode(logicNode: IPSDEResetParamLogic, actionContext: ActionContext) {
        try {
            this.onResetParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 重置变量
     *
     * @param {IPSDEResetParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicResetParamNode
     */
    public onResetParam(logicNode: IPSDEResetParamLogic, actionContext: ActionContext) {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        dstParam.resetAll();
        actionContext.bindLastReturnParam(null);
    }

}