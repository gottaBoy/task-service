import { IPSDEDEDataSetLogic } from "@ibiz/dynamic-model-api";
import { DataServiceHelp } from "../../data-service-help";
import { ActionContext } from "../action-context";
import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicNodeBase } from "./logic-node-base";

/**
 * 实体数据集节点
 *
 * @export
 * @class AppDeDataSetNode
 * @extends {AppDeLogicNodeBase}
 */
export class AppDeDataSetNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEDEDataSetLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeDataSetNode
     */
    public async executeNode(logicNode: IPSDEDEDataSetLogic, actionContext: ActionContext) {
        try {
            await this.handleDataSet(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理实体数据集
     *
     * @private
     * @param {IPSDEDEDataSetLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeDataSetNode
     */
    private async handleDataSet(logicNode: IPSDEDEDataSetLogic, actionContext: ActionContext) {
        const dstEntity = logicNode.getDstPSAppDataEntity();
        await dstEntity?.fill();
        const dstDataSet = logicNode.getDstPSAppDEDataSet();
        // 过滤器
        const dstParamModel = logicNode.getDstPSDELogicParam();
        const dstParam = actionContext.getParam(dstParamModel?.codeName as string);
        if (!dstParamModel || !Object.is(dstParam.logicParamType, LogicParamType.filterParam)) {
            throw new Error(`传入参数${dstParamModel?.codeName}类型不正确，必须为过滤器对象`);
        }
        if (dstEntity && dstDataSet) {
            try {
                const service = await DataServiceHelp.getInstance().getService(dstEntity);
                const res = await service.execute(dstDataSet.codeName, actionContext.context, dstParam.getReal() ? dstParam.getReal() : {});
                if (res && res.ok && res.data) {
                    // 返回值绑定逻辑参数对象
                    if (logicNode.getRetPSDELogicParam()) {
                        const retParam = actionContext.getParam(logicNode.getRetPSDELogicParam()?.codeName as string);
                        retParam.bind(res.data);
                    }
                    actionContext.bindLastReturnParam(res.data);
                } else {
                    throw new Error(`查询实体数据集失败`);
                }
            } catch (error: any) {
                throw new Error(`${error.message ? error.message : error.data?.message ? error.data.message : '查询实体数据集失败'}`);
            }
        } else {
            throw new Error(`查询实体数据集参数不足`);
        }
    }
}