import { IPSAppDELogic, IPSDELogicNode } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "../../../interface";
import { LogUtil } from "../../../utils";
import { ActionContext } from "./action-context";
import { AppDeDataSetNode, AppDeEndNode, AppDeLogicAppendParamNode, AppDeLogicBeginNode, AppDeLogicBindParamNode, AppDeLogicCopyParamNode, AppDeLogicDeActionNode, AppDeLogicPrepareParamNode, AppDeLogicReNewParamNode, AppDeLogicResetParamNode, AppDeLogicSortParamNode, AppThrowExceptionNode } from "./logic-node";

/**
 * 实体处理逻辑执行对象
 *
 * @export
 * @class AppDeLogicService
 */
export class AppDeLogicService {

    /**
     * 唯一实例
     * 
     * @private
     * @static
     * @memberof AppDeLogicService
     */
    private static readonly instance = new AppDeLogicService();

    /**
     * 获取唯一实例
     *
     * @static
     * @return {*}  {AppDeLogicService}
     * @memberof AppDeLogicService
     */
    public static getInstance(): AppDeLogicService {
        return AppDeLogicService.instance;
    }

    /**
     * 执行之前的初始化操作
     *
     * @param {IPSAppDELogic} logic 处理逻辑模型对象
     * @param {IParams} params
     * @memberof AppDeLogicService
     */
    public async beforeExecute(logic: IPSAppDELogic, context: IContext, params: IParams) {
        await logic.fill(true);
        return new ActionContext(logic, context, params)
    }

    /**
     * 执行处理逻辑
     *
     * @param {IPSAppDELogic} logic 处理逻辑模型对象
     * @param {IContext} context 应用上下文参数
     * @param {IParams} data 数据参数
     * @return {*} 
     * @memberof AppDeLogicService
     */
    public async onExecute(logic: IPSAppDELogic, context: IContext, data: IParams) {
      try {
        let actionContext = await this.beforeExecute(logic, context, data);
        // 自定义脚本代码
        if (logic && logic.customCode) {
            if (logic.scriptCode) {
                if (logic && (logic as any)?.logicSubType && Object.is((logic as any).logicSubType, 'DEFIELD')) {
                    // 适配计算值和默认值类型直接输入值
                    if ((logic as any)?.dEFLogicMode && (Object.is((logic as any).dEFLogicMode, 'COMPUTE') || Object.is((logic as any).dEFLogicMode, 'DEFAULT'))) {
                        const result: any = eval(logic.scriptCode);
                        if ((result !== null) && (result !== undefined)) {
                            if (logic.M?.getPSAppDEField?.codeName) {
                                data[logic.M.getPSAppDEField.codeName.toLowerCase()] = result;
                            }
                        }
                    } else {
                        eval(logic.scriptCode);
                    }
                } else {
                    eval(logic.scriptCode);
                }
                return data;
            } else {
                throw new Error('自定义代码不能为空');
            }
        } else {
            let startNode: IPSDELogicNode | null = logic.getStartPSDELogicNode();
            if (!startNode) {
                throw new Error('没有开始节点');
            }
            await this.executeNode(startNode, actionContext);
            return actionContext.getResult();
        }
      } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 执行处理逻辑节点
     *
     * @param {*} logicNode 处理逻辑节点
     * @param {IContext} context
     * @memberof AppDeLogicService
     */
    public async executeNode(logicNode: any, actionContext: ActionContext) {
        let result: any = { actionContext };
        try {
          switch (logicNode.logicNodeType) {
            // 开始节点
            case 'BEGIN':
                result = await new AppDeLogicBeginNode().executeNode(logicNode, actionContext);
                break;
            // 准备参数节点
            case 'PREPAREPARAM':
                result = await new AppDeLogicPrepareParamNode().executeNode(logicNode, actionContext);
                break;
            // 重置参数节点
            case 'RESETPARAM':
                result = await new AppDeLogicResetParamNode().executeNode(logicNode, actionContext);
                break;
            // 拷贝参数节点
            case 'COPYPARAM':
                result = await new AppDeLogicCopyParamNode().executeNode(logicNode, actionContext);
                break;
            // 绑定参数
            case 'BINDPARAM':
                result = await new AppDeLogicBindParamNode().executeNode(logicNode, actionContext);
                break;
            // 重新建立参数
            case 'RENEWPARAM':
                result = await new AppDeLogicReNewParamNode().executeNode(logicNode, actionContext);
                break;
            // 排序数组参数
            case 'SORTPARAM':
                result = await new AppDeLogicSortParamNode().executeNode(logicNode, actionContext);
                break;
            // 附加到数组参数
            case 'APPENDPARAM':
                result = await new AppDeLogicAppendParamNode().executeNode(logicNode, actionContext);
                break;
            // 行为处理节点
            case 'DEACTION':
                result = await new AppDeLogicDeActionNode().executeNode(logicNode, actionContext);
                break;
            // 实体数据集
            case 'DEDATASET':
                result = await new AppDeDataSetNode().executeNode(logicNode, actionContext);
                break;
            // 抛出异常
            case 'THROWEXCEPTION':
                result = await new AppThrowExceptionNode().executeNode(logicNode, actionContext);
                break;
            // 结束
            case 'END':
                result = await new AppDeEndNode().executeNode(logicNode, actionContext);
                break;
            default:
                console.log(`${logicNode.logicNodeType}暂未支持`);
          }
          // 有后续节点时继续递归，反之返回值。
          if (result && (result.nextNodes?.length > 0)) {
              await this.executeNextNodes(result.nextNodes, actionContext);
          }
        } catch (error: any) {
            throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 执行后续节点集合
     *
     * @param {IPSDELogicNode[]} nextNodes
     * @param {ActionContext} ActionContext
     * @memberof AppDeLogicService
     */
    public async executeNextNodes(nextNodes: IPSDELogicNode[], actionContext: ActionContext) {
        if (nextNodes && (nextNodes.length > 0)) {
            for (let nextNode of nextNodes) {
                await this.executeNode(nextNode, actionContext);
            }
        }
    }

}