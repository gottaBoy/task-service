import { IPSDEUILogicParam, IPSDEUICopyParamLogic } from '@ibiz/dynamic-model-api';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 拷贝参数节点
 *
 * @export
 * @class AppUILogicCopyParamNode
 */
export class AppUILogicCopyParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUICopyParamLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicCopyParamNode
     */
    public async executeNode(logicNode: IPSDEUICopyParamLogic, actionContext: UIActionContext) {
        try {
            this.onCopyParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理参数
     *
     * @param {IPSDEUICopyParamLogic} logicNode 节点模型数据
     * @param {UIActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicCopyParamNode
     */
    public onCopyParam(logicNode: IPSDEUICopyParamLogic, actionContext: UIActionContext) {
        if (!logicNode || !logicNode.getDstPSDEUILogicParam() || !logicNode.getSrcPSDEUILogicParam()) {
            throw new Error(`操作参数或者源参数缺失！`);
        }
        try {
            // 源数据
            const srcParam:any = actionContext.getParam((logicNode.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            srcParam.copyTo(dstParam);
            actionContext.bindLastReturnParam(null);
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNode.getDstPSDEUILogicParam()?.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }
}