import { IPSDEUIDELogicLogic, IPSDEUILogicParam } from '@ibiz/dynamic-model-api';
import { DataServiceHelp } from 'ibiz-core';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 实体处理逻辑节点
 *
 * @export
 * @class AppUILogicDeLogicNode
 */
export class AppUILogicDeLogicNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIDELogicLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDeLogicNode
     */
    public async executeNode(logicNode: IPSDEUIDELogicLogic, actionContext: UIActionContext) {
        try {
            await this.handleDELogic(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理实体处理逻辑
     *
     * @private
     * @param {IPSDEUIDELogicLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDeLogicNode
     */
    private async handleDELogic(logicNode: IPSDEUIDELogicLogic, actionContext: UIActionContext) {
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const deLogicCodeName = logicNode.getDstPSAppDELogic()?.codeName;
        const dstParam = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        const retParam = actionContext.getParam((logicNode.getRetPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        if (dstEntity && dstParam && deLogicCodeName) {
            try {
                const service = await DataServiceHelp.getInstance().getService(dstEntity);
                const result = await service['executeAppDELogic'](deLogicCodeName, actionContext.context, dstParam.getReal() ? dstParam.getReal() : {});
                if (result) {
                    if(retParam){
                        retParam.bind(result);
                    }
                    actionContext.bindLastReturnParam(result);
                    return retParam;
                } else {
                    throw new Error(`调用实体处理逻辑异常`);
                }
            } catch (error: any) {
                throw new Error(`调用实体处理逻辑异常${error?.message ? error.message : ''}`);
            }
        } else {
            throw new Error(`调用实体处理逻辑参数不足`);
        }
    }
}