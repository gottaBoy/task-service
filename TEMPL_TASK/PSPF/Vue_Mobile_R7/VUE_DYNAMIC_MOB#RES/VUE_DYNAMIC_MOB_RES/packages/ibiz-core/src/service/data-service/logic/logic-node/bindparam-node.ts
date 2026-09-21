import { IPSDEBindParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 绑定参数节点
 *
 * @export
 * @class AppDeLogicBindParamNode
 */
export class AppDeLogicBindParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEBindParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicBindParamNode
     */
    public async executeNode(logicNode: IPSDEBindParamLogic, actionContext: ActionContext) {
        try {
            this.onBindParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 绑定参数
     *
     * @param {IPSDEBindParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicBindParamNode
     */
    public onBindParam(logicNode: IPSDEBindParamLogic, actionContext: ActionContext) {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNode.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 源属性
        const srcFieldName: string = logicNode.srcFieldName?.toLowerCase?.();
        if (srcFieldName) {
            dstParam.bind(srcParam.get(srcFieldName));
        } else {
            dstParam.bind(srcParam.getReal());
        }
        actionContext.bindLastReturnParam(null);
    }

}