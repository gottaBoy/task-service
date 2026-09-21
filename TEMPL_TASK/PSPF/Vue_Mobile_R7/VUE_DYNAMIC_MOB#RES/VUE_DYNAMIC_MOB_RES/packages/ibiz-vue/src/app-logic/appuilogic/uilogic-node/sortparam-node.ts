import { IPSDEUILogicParam, IPSDEUISortParamLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 排序数组参数节点
 *
 * @export
 * @class AppUILogicSortParamNode
 */
export class AppUILogicSortParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUISortParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicSortParamNode
     */
    public async executeNode(logicNode: IPSDEUISortParamLogic, actionContext: UIActionContext) {
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
     * @param {IPSDEUISortParamLogic} logicNodeParam
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
     public onSortParam(logicNodeParam: IPSDEUISortParamLogic, actionContext: UIActionContext) {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 目标属性
        const dstFieldName: string = logicNodeParam.dstFieldName?.toLowerCase?.();
        if (!dstFieldName) {
            throw new Error(`逻辑参数${logicNodeParam.name}未指定设置排序属性`);
        }
        dstParam.sort(dstFieldName, logicNodeParam.dstSortDir);
        actionContext.bindLastReturnParam(null);
    }
}