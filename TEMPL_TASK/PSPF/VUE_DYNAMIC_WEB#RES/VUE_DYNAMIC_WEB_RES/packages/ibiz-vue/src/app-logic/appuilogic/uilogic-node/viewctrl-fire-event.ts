import { IPSDEUICtrlFireEventLogic } from '@ibiz/dynamic-model-api';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 视图部件事件触发节点
 *
 * @export
 * @class AppUILogicViewctrlFireEventNode
 */
export class AppUILogicViewctrlFireEventNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUICtrlFireEventLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicViewctrlFireEventNode
     */
    public async executeNode(logicNode: IPSDEUICtrlFireEventLogic, actionContext: UIActionContext) {
        try {
            await this.handleViewCtrFireEvent(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理视图部件触发事件
     *
     * @private
     * @param {IPSDEUICtrlFireEventLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicViewctrlFireEventNode
     */
    private async handleViewCtrFireEvent(logicNode: IPSDEUICtrlFireEventLogic, actionContext: UIActionContext) {
        // 事件名称
        const eventName = logicNode.eventName;
        // 事件参数
        const eventParam = logicNode.getEventParam();
        // 触发对象
        const fireCtrl = logicNode.getFireCtrl();
        if (!eventName || !eventParam || !fireCtrl) {
            throw new Error(`触发对象、事件名称或者事件参数缺失`);
        }
        // 触发UI对象
        const fireUICtrl = actionContext.getParam(fireCtrl.codeName).getReal();
        // 事件参数
        const eventArgs = actionContext.getParam(eventParam.codeName).getReal();
        if (!fireUICtrl) {
            throw new Error(`获取触发对象异常`);
        }
        try {
            // 自身触发
            fireUICtrl.$emit(eventName, eventArgs);
            // 如果是部件，需向视图抛出
            if (fireUICtrl.controlInstance) {
                fireUICtrl.ctrlEvent({
                    controlname: fireUICtrl.controlInstance.name,
                    action: eventName,
                    data: eventArgs
                })
            }
            // 如果是视图，需向外抛出
            if (fireUICtrl.viewInstance) {
                fireUICtrl.$emit('view-event', { viewName: fireUICtrl.viewCodeName, action: eventName, data: eventArgs });
            }
            actionContext.bindLastReturnParam(null);
        } catch (error:any) {
            throw new Error(`视图部件事件触发未执行成功！`);
        }
    }
}