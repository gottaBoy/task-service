import { IPSDEEndLogic } from "@ibiz/dynamic-model-api";
import { LogUtil } from "../../../utils";
import { ActionContext } from "../action-context";
import { LogicReturnType } from "../const/logic-return-type";
import { AppDeLogicNodeBase } from "./logic-node-base";

/**
 * 结束类型节点
 *
 * @export
 * @class AppDeEndNode
 */
export class AppDeEndNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEEndLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeEndNode
     */
    public async executeNode(logicNode: IPSDEEndLogic, actionContext: ActionContext) {
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
     * @param {IPSDEEndLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeEndNode
     */
    private handleEndNode(logicNode: IPSDEEndLogic, actionContext: ActionContext) {
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