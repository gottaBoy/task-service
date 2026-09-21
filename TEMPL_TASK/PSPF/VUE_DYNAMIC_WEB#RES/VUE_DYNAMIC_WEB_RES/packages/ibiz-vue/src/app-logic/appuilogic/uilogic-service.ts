import { LogUtil } from "ibiz-core";
import { UIActionContext } from "./uiaction-context";
import { AppUILogicAppendParamNode } from "./uilogic-node/appendparam-node";
import { AppUILogicBeginNode } from "./uilogic-node/begin-node";
import { AppUILogicBindParamNode } from "./uilogic-node/bindparam-node";
import { AppUILogicCopyParamNode } from "./uilogic-node/copyparam-node";
import { AppUILogicDeactionNode } from "./uilogic-node/deaction-node";
import { AppUILogicDebugParamNode } from "./uilogic-node/debugparam-node";
import { AppDeUIDataSetNode } from "./uilogic-node/dedataset-node";
import { AppUILogicDeLogicNode } from "./uilogic-node/delogic-node";
import { AppUILogicDeUIActionNode } from "./uilogic-node/deuiaction-node";
import { AppUILogicEndNode } from "./uilogic-node/end-node";
import { AppUILogicMsgboxNode } from "./uilogic-node/msgbox-node";
import { AppUILogicPluginNode } from "./uilogic-node/plugin-node";
import { AppUILogicPrepareParamNode } from "./uilogic-node/prepareparam-node";
import { AppUILogicRawCodeNode } from "./uilogic-node/rawcode-node";
import { AppUILogicReNewParamNode } from "./uilogic-node/renewparam-node";
import { AppUILogicResetParamNode } from "./uilogic-node/resetparam-node";
import { AppUILogicSortParamNode } from "./uilogic-node/sortparam-node";
import { AppUILogicThrowExceptionNode } from "./uilogic-node/throw-exception-node";
import { AppUILogicViewctrlFireEventNode } from "./uilogic-node/viewctrl-fire-event";
import { AppUILogicViewctrlInvokeNode } from "./uilogic-node/viewctrl-invoke-node";

/**
 * 界面逻辑执行对象
 *
 * @export
 * @class AppUILogicService
 */
export class AppUILogicService {

     /**
      * 唯一实例
      * 
      * @private
      * @static
      * @memberof AppUILogicService
      */
     private static readonly instance = new AppUILogicService();

     /**
      * 获取唯一实例
      *
      * @static
      * @return {*}  {AppUILogicService}
      * @memberof AppUILogicService
      */
     public static getInstance(): AppUILogicService {
          return AppUILogicService.instance;
     }

     /**
      * 执行之前的初始化操作
      * 
      * @param {IPSAppDELogic} logic 处理逻辑模型对象
      * @param {*} args 数据对象
      * @param {*} context 应用上下文
      * @param {*} params 视图参数
      * @param {*} $event 事件源对象
      * @param {*} xData 部件对象
      * @param {*} actioncontext 界面容器对象
      * @param {*} srfParentDeName 关联父应用实体代码名称
      * @memberof AppUILogicService
      */
     public async beforeExecute(logic: any, args: any, context: any = {}, params: any = {},
          $event?: any, xData?: any, actioncontext?: any, srfParentDeName?: string) {
          await logic.fill(true);
          return new UIActionContext(logic, args, context, params, $event, xData, actioncontext, srfParentDeName)
     }

     /**
      * 执行处理逻辑
      *
      * @param {*} logic 处理逻辑模型对象
      * @param {*} args 数据对象
      * @param {*} context 应用上下文
      * @param {*} params 视图参数
      * @param {*} $event 事件源对象
      * @param {*} xData 部件对象
      * @param {*} actioncontext 界面容器对象
      * @param {*} srfParentDeName 关联父应用实体代码名称
      * @memberof AppUILogicService
      */
     public async onExecute(logic: any, args: any, context: any = {}, params: any = {},
          $event?: any, xData?: any, actioncontext?: any, srfParentDeName?: string) {
        try {
          let actionContext = await this.beforeExecute(logic, args, context, params, $event, xData, actioncontext, srfParentDeName);
          let startNode: any | null = logic.getStartPSDEUILogicNode();
          if (!startNode) {
              throw new Error('没有开始节点');
          }
          LogUtil.log(`${logic.name}逻辑开始执行`);
          await this.executeNode(startNode, actionContext);
          return actionContext.getResult();
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
     }

     /**
      * 执行界面处理逻辑节点
      *
      * @param {*} logicNode 界面处理逻辑节点
      * @param {UIActionContext} actionContext 界面逻辑执行上下文 
      * @memberof AppUILogicService
      */
     public async executeNode(logicNode: any, actionContext: UIActionContext) {
        let result: any = { actionContext };
        try {
          switch (logicNode.logicNodeType) {
                // 开始节点
                case 'BEGIN':
                    result = await new AppUILogicBeginNode().executeNode(logicNode, actionContext);
                    break;
                // 准备参数节点
                case 'PREPAREJSPARAM':
                    result = await new AppUILogicPrepareParamNode().executeNode(logicNode, actionContext);
                    break;
                // 重置参数节点
                case 'RESETPARAM':
                    result = await new AppUILogicResetParamNode().executeNode(logicNode, actionContext);
                    break;
                // 拷贝参数
                case 'COPYPARAM':
                    result = await new AppUILogicCopyParamNode().executeNode(logicNode, actionContext);
                    break;
                // 绑定参数
                case 'BINDPARAM':
                    result = await new AppUILogicBindParamNode().executeNode(logicNode, actionContext);
                    break;
                // 重新建立参数
                case 'RENEWPARAM':
                    result = await new AppUILogicReNewParamNode().executeNode(logicNode, actionContext);
                    break;
                // 调用实体界面行为
                case 'DEUIACTION':
                    result = await new AppUILogicDeUIActionNode().executeNode(logicNode, actionContext);
                    break;
                // 行为处理节点
                case 'DEACTION':
                    result = await new AppUILogicDeactionNode().executeNode(logicNode, actionContext);
                    break;
                // 实体处理逻辑
                case 'DELOGIC':
                    result = await new AppUILogicDeLogicNode().executeNode(logicNode, actionContext);
                    break;
                // 实体数据集
                case 'DEDATASET':
                    result = await new AppDeUIDataSetNode().executeNode(logicNode, actionContext);
                    break;
                // 附加到数组参数
                case 'APPENDPARAM':
                    result = await new AppUILogicAppendParamNode().executeNode(logicNode, actionContext);
                    break;
                // 排序数组参数
                case 'SORTPARAM':
                    result = await new AppUILogicSortParamNode().executeNode(logicNode, actionContext);
                    break;
                // 视图部件调用
                case 'VIEWCTRLINVOKE':
                    result = await new AppUILogicViewctrlInvokeNode().executeNode(logicNode, actionContext);
                    break;
                // 视图部件事件触发
                case 'VIEWCTRLFIREEVENT':
                    result = await new AppUILogicViewctrlFireEventNode().executeNode(logicNode, actionContext);
                    break;
                // 调试逻辑参数
                case 'DEBUGPARAM':
                    result = await new AppUILogicDebugParamNode().executeNode(logicNode, actionContext);
                    break;
                // 消息弹窗
                case 'MSGBOX':
                    result = await new AppUILogicMsgboxNode().executeNode(logicNode, actionContext);
                    break;
                // 前端代码
                case 'RAWJSCODE':
                    result = await new AppUILogicRawCodeNode().executeNode(logicNode, actionContext);
                    break;
                // 异常处理
                case 'THROWEXCEPTION':
                    result = await new AppUILogicThrowExceptionNode().executeNode(logicNode, actionContext);
                    break;
                // 结束
                case 'END':
                    result = await new AppUILogicEndNode().executeNode(logicNode, actionContext);
                    break;
                default:
                    console.log(`${logicNode.logicNodeType}暂未支持`);
          }
          // 有后续节点时继续递归，反之返回,抛异常无返回值
          if (result && result.nextNodes && (result.nextNodes?.length > 0)) {
              await this.executeNextNodes(result.nextNodes, actionContext);
          }
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
     }

     /**
      * 执行后续节点集合
       *
       * @param {*} logicNode 界面处理逻辑节点
       * @param {UIActionContext} actionContext 界面逻辑执行上下文 
       * @memberof AppUILogicService
       */
     public async executeNextNodes(nextNodes: any[], actionContext: UIActionContext) {
          if (nextNodes && (nextNodes.length > 0)) {
               for (let nextNode of nextNodes) {
                    await this.executeNode(nextNode, actionContext);
               }
          }
     }

}