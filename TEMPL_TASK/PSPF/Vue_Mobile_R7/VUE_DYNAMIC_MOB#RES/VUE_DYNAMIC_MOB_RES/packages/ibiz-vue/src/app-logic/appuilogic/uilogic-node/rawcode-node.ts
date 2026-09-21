import { IPSDEUIRawCodeLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 直接前台代码节点
 *
 * @export
 * @class AppUILogicRawCodeNode
 */
export class AppUILogicRawCodeNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIRawCodeLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicRawCodeNode
     */
    public async executeNode(logicNode: IPSDEUIRawCodeLogic, actionContext: UIActionContext) {
        try {
            this.handleRawCode(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处置直接执行代码
     *
     * @private
     * @param {IPSDEUIRawCodeLogic} logicNode
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicRawCodeNode
     */
    private handleRawCode(logicNode: IPSDEUIRawCodeLogic, actionContext: UIActionContext) {
        let data: any = actionContext.defaultParam.getReal();
        let { context } = actionContext;
        if (logicNode && logicNode.code) {
            eval(logicNode?.code);
        } else {
            throw new Error('无代码片段');
        }
        actionContext.bindLastReturnParam(null);
    }
}