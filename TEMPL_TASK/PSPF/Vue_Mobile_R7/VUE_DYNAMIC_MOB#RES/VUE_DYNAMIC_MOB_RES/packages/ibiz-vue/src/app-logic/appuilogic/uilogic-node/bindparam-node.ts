import { IPSDEUILogicParam, IPSDEUIBindParamLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 绑定参数节点
 *
 * @export
 * @class AppUILogicBindParamNode
 */
export class AppUILogicBindParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIBindParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicBindParamNode
     */
    public async executeNode(logicNode: IPSDEUIBindParamLogic, actionContext: UIActionContext) {
        try {
            this.onBindParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理参数
     *
     * @param {IPSDEUIBindParamLogic} logicNode 节点模型数据
     * @param {UIActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicBindParamNode
     */
    public onBindParam(logicNode: IPSDEUIBindParamLogic, actionContext: UIActionContext) {
        if (!logicNode || !logicNode.getDstPSDEUILogicParam() || !logicNode.getSrcPSDEUILogicParam()) {
            throw new Error(`操作参数或者源参数缺失！`);
        }
        try {
            // 源数据
            const srcParam: any = actionContext.getParam((logicNode.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 源属性
            const srcFieldName: string = logicNode.srcFieldName?.toLowerCase?.();
            if (srcFieldName) {
                dstParam.bind(srcParam.get(srcFieldName));
            } else {
                dstParam.bind(srcParam.getReal());
            }
            actionContext.bindLastReturnParam(null);
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNode.getDstPSDEUILogicParam()?.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }
}