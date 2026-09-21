import { IPSDECopyParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 拷贝参数节点
 *
 * @export
 * @class AppDeLogicCopyParamNode
 */
export class AppDeLogicCopyParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDECopyParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicCopyParamNode
     */
    public async executeNode(logicNode: IPSDECopyParamLogic, actionContext: ActionContext) {
        try {
            this.onCopyParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 拷贝变量
     *
     * @param {IPSDECopyParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicCopyParamNode
     */
    public onCopyParam(logicNode: IPSDECopyParamLogic, actionContext: ActionContext) {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNode.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        srcParam.copyTo(dstParam);
        actionContext.bindLastReturnParam(null);
    }

}