import { IPSDESortParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { LogUtil } from '../../../utils';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 排序数组参数节点
 *
 * @export
 * @class AppDeLogicSortParamNode
 */
export class AppDeLogicSortParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDESortParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicSortParamNode
     */
    public async executeNode(logicNode: IPSDESortParamLogic, actionContext: ActionContext) {
        try {
            this.onSortParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 排序数组变量
     *
     * @param {IPSDESortParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicSortParamNode
     */
    public onSortParam(logicNode: IPSDESortParamLogic, actionContext: ActionContext) {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标属性
        const dstFieldName: string = logicNode.dstFieldName?.toLowerCase?.();
        if (!dstFieldName) {
            throw new Error(`逻辑参数${logicNode.name}未指定设置排序属性`);
        }
        dstParam.sort(dstFieldName, logicNode.dstSortDir);
        actionContext.bindLastReturnParam(null);
    }

}