import { IPSDERenewParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 绑定参数节点
 *
 * @export
 * @class AppDeLogicReNewParamNode
 */
export class AppDeLogicReNewParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDERenewParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicReNewParamNode
     */
    public async executeNode(logicNode: IPSDERenewParamLogic, actionContext: ActionContext) {
        try {
            this.onRenewParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 重新建立变量
     *
     * @param {IPSDERenewParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicReNewParamNode
     */
    public onRenewParam(logicNode: IPSDERenewParamLogic, actionContext: ActionContext) {
        // 目标参数
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        dstParam.renew();
        actionContext.bindLastReturnParam(null);
    }

}