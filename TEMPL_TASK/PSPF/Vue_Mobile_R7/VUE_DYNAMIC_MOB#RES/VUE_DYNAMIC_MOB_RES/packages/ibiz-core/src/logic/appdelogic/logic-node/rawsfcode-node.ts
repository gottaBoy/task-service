import { IPSDERawCodeLogic } from '@ibiz/dynamic-model-api';
import { LogUtil } from '../../../utils';
import { ActionContext } from '../action-context';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 直接代码节点
 *
 * @export
 * @class AppRawsfcodeNode
 */
export class AppRawsfcodeNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDELogicNode} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppRawsfcodeNode
     */
    public async executeNode(logicNode: IPSDERawCodeLogic, actionContext: ActionContext) {
        try {
            this.handleRawCode(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理直接代码
     *
     * @private
     * @param {IPSDERawCodeLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppRawsfcodeNode
     */
    private handleRawCode(logicNode: IPSDERawCodeLogic, actionContext: ActionContext) {
        let { context: context, defaultParam: data } = actionContext;
        if (logicNode && logicNode.code) {
            eval(logicNode.code);
            actionContext.bindLastReturnParam(null);
        } else {
            throw new Error('无代码片段');
        }
    }
}