import { IPSAppUILogic } from '@ibiz/dynamic-model-api';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 开始类型节点
 *
 * @export
 * @class AppUILogicBeginNode
 */
export class AppUILogicBeginNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSAppUILogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicBeginNode
     */
    public async executeNode(logicNode: IPSAppUILogic, actionContext: UIActionContext) {
        // 默认设置当前逻辑返回结果为当前默认输入参数
        actionContext.setResult(actionContext.defaultParam.getReal());
        return this.computeNextNodes(logicNode, actionContext);
    }
}