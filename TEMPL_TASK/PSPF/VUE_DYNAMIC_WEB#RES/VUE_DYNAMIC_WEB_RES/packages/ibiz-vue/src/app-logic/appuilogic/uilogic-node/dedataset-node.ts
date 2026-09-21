
import { IPSDEUIDEDataSetLogic } from "@ibiz/dynamic-model-api";
import { DataServiceHelp } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { UIActionContext } from "../uiaction-context";
import { AppUILogicNodeBase } from "./logic-node-base";

/**
 * 实体数据集节点
 *
 * @export
 * @class AppDeUIDataSetNode
 * @extends {AppUILogicNodeBase}
 */
export class AppDeUIDataSetNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEUIDEDataSetLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeUIDataSetNode
     */
    public async executeNode(logicNode: IPSDEUIDEDataSetLogic, actionContext: UIActionContext) {
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
     * @param {IPSDEUIDEDataSetLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeUIDataSetNode
     */
    private async handleDataSet(logicNode: IPSDEUIDEDataSetLogic, actionContext: UIActionContext) {
        const dstEntity = logicNode.getDstPSAppDataEntity();
        await dstEntity?.fill();
        const dstDataSet = logicNode.getDstPSAppDEDataSet();
        // 过滤器
        const dstParamModel = logicNode.getDstPSDEUILogicParam();
        const dstParam = actionContext.getParam(dstParamModel?.codeName as string);
        if (!dstParamModel || !Object.is(dstParam.logicParamType, UILogicParamType.filterParam)) {
            throw new Error(`传入参数${dstParamModel?.codeName}类型不正确，必须为过滤器对象`);
        }
        if (dstEntity && dstDataSet) {
            try {
                const service = await DataServiceHelp.getInstance().getService(dstEntity);
                const res = await service.execute(dstDataSet.codeName, actionContext.context, dstParam.getReal() ? dstParam.getReal() : {});
                if (res && res.ok && res.data) {
                    // 返回值绑定逻辑参数对象
                    if (logicNode.getRetPSDEUILogicParam()) {
                        const retParam = actionContext.getParam(logicNode.getRetPSDEUILogicParam()?.codeName as string);
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