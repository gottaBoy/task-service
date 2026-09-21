import { IPSDEUIEndLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { LogicReturnType } from '../const/logic-return-type';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 结束节点
 *
 * @export
 * @class AppUILogicEndNode
 */
export class AppUILogicEndNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIEndLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicEndNode
     */
    public async executeNode(logicNode: IPSDEUIEndLogic, actionContext: UIActionContext) {
        try {
            this.handleEndNode(logicNode, actionContext);
            LogUtil.log(`已完成执行${logicNode?.name}节点，操作参数数据如下:`);
            if (actionContext.paramsMap && (actionContext.paramsMap.size > 0)) {
                for (let [key, value] of actionContext.paramsMap) {
                    LogUtil.log(`${key}:`, value.getReal());
                }
            }
            return { nextNodes: [], actionContext };
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理结束节点
     *
     * @private
     * @param {IPSDEUIEndLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppUILogicEndNode
     */
    private handleEndNode(logicNode: IPSDEUIEndLogic, actionContext: UIActionContext) {
        const strReturnType: string = logicNode.returnType;
        if (Object.is(strReturnType, LogicReturnType.NONEVALUE) || Object.is(strReturnType, LogicReturnType.NULLVALUE)) {
            actionContext.setResult(null);
        } else if (Object.is(strReturnType, LogicReturnType.SRCVALUE)) {
            actionContext.setResult(logicNode.rawValue);
        } else if (Object.is(strReturnType, LogicReturnType.BREAK)) {
            actionContext.setResult(LogicReturnType.BREAK);
        } else if (Object.is(strReturnType, LogicReturnType.LOGICPARAM) || Object.is(strReturnType, LogicReturnType.LOGICPARAMFIELD)) {
            const returnParam = actionContext.getParam(logicNode.getReturnParam()?.codeName as string);
            if (Object.is(strReturnType, LogicReturnType.LOGICPARAM)) {
                actionContext.setResult(returnParam.getReal());
            } else {
                actionContext.setResult(returnParam.get(logicNode.dstFieldName));
            }
        } else {
            throw new Error(`无法识别的返回值类型${strReturnType}`);
        }
    }
}