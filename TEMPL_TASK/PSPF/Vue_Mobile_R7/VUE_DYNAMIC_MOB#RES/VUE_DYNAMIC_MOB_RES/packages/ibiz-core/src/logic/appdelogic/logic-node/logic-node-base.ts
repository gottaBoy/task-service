import { IPSDELogicLink, IPSDELogicLinkCond, IPSDELogicLinkGroupCond, IPSDELogicLinkSingleCond, IPSDELogicNode } from "@ibiz/dynamic-model-api";
import { LogUtil, Util, Verify } from "ibiz-core";
import { ActionContext } from "../action-context";

/**
 * 处理逻辑节点基类
 *
 * @export
 * @class AppDeLogicNodeBase
 */
export class AppDeLogicNodeBase {

    constructor() { }

    /**
     * 根据处理连接计算后续逻辑节点
     *
     * @param {IPSDELogicNode} logicNode 处理逻辑节点
     * @param {IContext} context
     * @memberof AppDeLogicNodeBase
     */
    public computeNextNodes(logicNode: IPSDELogicNode, actionContext: ActionContext) {
        LogUtil.log(`已完成执行${logicNode?.name}节点，操作参数数据如下:`);
        if (actionContext.paramsMap && (actionContext.paramsMap.size > 0)) {
            for (let [key, value] of actionContext.paramsMap) {
                LogUtil.log(`${key}:`, value.getReal());
            }
        }
        let result: any = { nextNodes: [], actionContext };
        if (logicNode && logicNode.getPSDELogicLinks() && ((logicNode.getPSDELogicLinks() as IPSDELogicLink[]).length > 0)) {
            for (let logicLink of (logicNode.getPSDELogicLinks() as IPSDELogicLink[])) {
                let nextNode = logicLink.getDstPSDELogicNode();
                // 没有连接条件组或有条件组且满足条件组时执行下一个节点
                if (!logicLink?.getPSDELogicLinkGroupCond?.() || this.computeCond((logicLink.getPSDELogicLinkGroupCond() as IPSDELogicLinkGroupCond), actionContext)) {
                    LogUtil.log(`即将执行${nextNode?.name}节点`);
                    result.nextNodes.push(nextNode);
                }
            }
        }
        return result;
    }

    /**
     * 计算是否通过逻辑连接
     *
     * @param {IPSDELogicLinkCond} logicLinkCond
     * @return {*} 
     * @memberof AppDeLogicNodeBase
     */
    public computeCond(logicLinkCond: IPSDELogicLinkCond, actionContext: ActionContext): any {
        if (logicLinkCond.logicType == 'GROUP') {
            const logicLinkGroupCond = logicLinkCond as IPSDELogicLinkGroupCond;
            const childConds: any = logicLinkGroupCond.getPSDELogicLinkConds();
            if (childConds?.length > 0) {
                return Verify.logicForEach(
                    childConds,
                    (item: any) => {
                        return this.computeCond(item, actionContext);
                    },
                    logicLinkGroupCond.groupOP,
                    !!logicLinkGroupCond.notMode,
                );
            }
        } else {
            if (logicLinkCond.logicType == 'SINGLE') {
                const logicLinkSingleCond = logicLinkCond as IPSDELogicLinkSingleCond
                let dstValue = actionContext.getParam(logicLinkSingleCond?.getDstLogicParam?.()?.codeName as string);
                if (logicLinkSingleCond.dstFieldName) {
                    dstValue = dstValue.get(logicLinkSingleCond.dstFieldName);
                }
                let targetValue;
                if (logicLinkSingleCond.paramType) {
                    switch (logicLinkSingleCond.paramType) {
                        case 'CURTIME':
                            targetValue = Util.dateFormat(new Date(), 'YYYY-MM-DD');
                            break;
                        default:
                            targetValue = logicLinkSingleCond.paramValue;
                    }
                } else {
                    targetValue = logicLinkSingleCond.paramValue;
                }
                return Verify.testCond(dstValue, logicLinkSingleCond.condOP, targetValue)
            }
        }
    }
}