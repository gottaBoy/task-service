import { IPSDEUIThrowExceptionLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 抛出异常节点
 *
 * @export
 * @class AppUILogicThrowExceptionNode
 */
export class AppUILogicThrowExceptionNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIThrowExceptionLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicThrowExceptionNode
     */
    public async executeNode(logicNode: IPSDEUIThrowExceptionLogic, actionContext: UIActionContext) {
        actionContext.actionContainer.$Notice(logicNode.errorInfo);
        actionContext.bindLastReturnParam(null);
        LogUtil.log(`已完成执行${logicNode?.name}节点，操作参数数据如下:`);
        if (actionContext.paramsMap && (actionContext.paramsMap.size > 0)) {
            for (let [key, value] of actionContext.paramsMap) {
                LogUtil.log(`${key}:`, value.getReal());
            }
        }
    }
}