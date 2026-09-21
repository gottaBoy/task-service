import { IPSDEUIDebugParamLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 调试逻辑参数节点
 *
 * @export
 * @class AppUILogicDebugParamNode
 */
export class AppUILogicDebugParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIDebugParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDebugParamNode
     */
    public async executeNode(logicNode: IPSDEUIDebugParamLogic, actionContext: UIActionContext) {
        try {
            this.handleDebugParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理调试逻辑参数
     *
     * @private
     * @param {IPSDEUIDebugParamLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicDebugParamNode
     */
    private handleDebugParam(logicNode: IPSDEUIDebugParamLogic, actionContext: UIActionContext) {
        if (logicNode.getDstPSDEUILogicParam()) {
            const dstParamValue = actionContext.getParam(logicNode.getDstPSDEUILogicParam()?.codeName as string).getReal();
            actionContext.bindLastReturnParam(null);
            LogUtil.log(`逻辑节点${logicNode.name}操作参数值:`, dstParamValue);
        }
    }
}