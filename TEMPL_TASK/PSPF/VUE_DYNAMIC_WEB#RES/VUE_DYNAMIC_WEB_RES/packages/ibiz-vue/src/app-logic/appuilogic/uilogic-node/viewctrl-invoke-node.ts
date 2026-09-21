import { IPSDEUICtrlInvokeLogic } from '@ibiz/dynamic-model-api';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 视图部件调用节点
 *
 * @export
 * @class AppUILogicViewctrlInvokeNode
 */
export class AppUILogicViewctrlInvokeNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUICtrlInvokeLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicViewctrlInvokeNode
     */
    public async executeNode(logicNode: IPSDEUICtrlInvokeLogic, actionContext: UIActionContext) {
        try {
            await this.handleViewCtrlInvoke(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理视图部件调用
     *
     * @private
     * @param {IPSDEUICtrlInvokeLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicViewctrlInvokeNode
     */
    private async handleViewCtrlInvoke(logicNode: IPSDEUICtrlInvokeLogic, actionContext: UIActionContext) {
        const invokeCtrl = logicNode.getInvokeCtrl()?.codeName;
        const invokeMethod = logicNode.invokeMethod;
        const invokeParam = logicNode.getInvokeParam()?.codeName;
        if (!invokeCtrl || !invokeMethod) {
            throw new Error(`界面对象或者调用方法缺失`);
        }
        const invokeUICtrl = actionContext.getParam(invokeCtrl).getReal();
        if (invokeUICtrl[invokeMethod] && invokeUICtrl[invokeMethod] instanceof Function) {
            try {
                const result = await invokeUICtrl[invokeMethod]();
                if (invokeParam) {
                    actionContext.getParam(invokeParam).bind(result);
                }
                actionContext.bindLastReturnParam(result);
            } catch (error:any) {
                throw new Error(`${invokeCtrl}界面对象调用${invokeMethod}方法发生异常`);
            }
        } else {
            throw new Error(`${invokeCtrl}界面对象不存在${invokeMethod}方法`);
        }
    }
}