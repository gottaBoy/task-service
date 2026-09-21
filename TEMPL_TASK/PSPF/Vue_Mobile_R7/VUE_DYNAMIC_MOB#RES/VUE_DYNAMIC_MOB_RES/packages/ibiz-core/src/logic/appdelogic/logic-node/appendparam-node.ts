import { IPSDEAppendParamLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { LogUtil } from '../../../utils';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 附加到数组参数节点
 *
 * @export
 * @class AppDeLogicAppendParamNode
 */
export class AppDeLogicAppendParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDEAppendParamLogic} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicAppendParamNode
     */
    public async executeNode(logicNode: IPSDEAppendParamLogic, actionContext: ActionContext) {
        try {
            this.onAppendParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 附加到数组
     *
     * @param {IPSDEAppendParamLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicAppendParamNode
     */
    public onAppendParam(logicNode: IPSDEAppendParamLogic, actionContext: ActionContext) {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNode.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 源属性
        const srcFieldName: string = logicNode.srcFieldName?.toLowerCase?.();
        let objParam: any;
        if (srcFieldName) {
            // objParam = srcParam.get(srcFieldName);
            objParam = srcParam.getReal();
        } else {
            objParam = srcParam.getReal();
        }
        dstParam.append(logicNode.dstIndex, objParam, logicNode.srcIndex, logicNode.srcSize);
        actionContext.bindLastReturnParam(null);
    }

}