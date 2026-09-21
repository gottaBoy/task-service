import { IPSDEUILogicParam, IPSDEUIAppendParamLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 附加到数组参数节点
 *
 * @export
 * @class AppUILogicAppendParamNode
 */
export class AppUILogicAppendParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIAppendParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicAppendParamNode
     */
    public async executeNode(logicNode: IPSDEUIAppendParamLogic, actionContext: UIActionContext) {
        try {
            this.onAppendParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 附加到数组变量
     *
     * @param {IPSDEUIAppendParamLogic} logicNodeParam
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onAppendParam(logicNodeParam: IPSDEUIAppendParamLogic, actionContext: UIActionContext) {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 源属性
        const srcFieldName: string = logicNodeParam.srcFieldName?.toLowerCase?.();
        let objParam: any;
        if (srcFieldName) {
            objParam = srcParam.get(srcFieldName);
        } else {
            objParam = srcParam.getReal();
        }
        dstParam.append(logicNodeParam.dstIndex, objParam, logicNodeParam.srcIndex, logicNodeParam.srcSize);
        actionContext.bindLastReturnParam(null);
    }
}