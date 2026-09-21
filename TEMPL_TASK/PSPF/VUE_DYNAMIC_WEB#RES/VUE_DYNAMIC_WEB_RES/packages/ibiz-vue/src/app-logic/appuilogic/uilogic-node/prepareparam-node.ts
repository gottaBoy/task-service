import { IPSDEUILogicNode, IPSDEUILogicNodeParam, IPSDEUILogicParam } from '@ibiz/dynamic-model-api';
import { AppServiceBase } from 'ibiz-core';
import { UILogicParamValueType } from '../const/logic-param-value-type';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 准备处理参数节点
 *
 * @export
 * @class AppUILogicPrepareParamNode
 */
export class AppUILogicPrepareParamNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUILogicNode} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicPrepareParamNode
     */
    public async executeNode(logicNode: IPSDEUILogicNode, actionContext: UIActionContext) {
        try {
            this.handleParam(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理参数
     *
     * @param {IPSDELogicNode} logicNode 节点模型数据
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicPrepareParamNode
     */
    public handleParam(logicNode: IPSDEUILogicNode, actionContext: UIActionContext) {
        if (!logicNode || !logicNode.getPSDEUILogicNodeParams()) {
            return;
        }
        try {
          for (let logicNodeParam of (logicNode.getPSDEUILogicNodeParams() as IPSDEUILogicNodeParam[])) {
              // 设置变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.SETPARAMVALUE)) {
                  this.onSetParamValue(logicNodeParam, actionContext);
              }
              // 重置变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.RESETPARAM)) {
                  this.onResetParam(logicNodeParam, actionContext);
              }
              // 拷贝变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.COPYPARAM)) {
                  this.onCopyParam(logicNodeParam, actionContext);
              }
              // 绑定参数
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.BINDPARAM)) {
                  this.onBindParam(logicNodeParam, actionContext);
              }
              // 重新建立变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.RENEWPARAM)) {
                  this.onRenewParam(logicNodeParam, actionContext);
              }
              // 附加到数组变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.APPENDPARAM)) {
                  this.onAppendParam(logicNodeParam, actionContext);
              }
              // 排序数组变量
              if (Object.is(logicNodeParam.paramAction, UILogicParamValueType.SORTPARAM)) {
                  this.onSortParam(logicNodeParam, actionContext);
              }
          }
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 设置参数(根据配置把源逻辑参数的值赋给目标逻辑参数)
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicPrepareParamNode
     */
    public onSetParamValue(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        try {
            // 源类型参数/目标逻辑参数/目标属性缺一跳过不做处理
            if (!logicNodeParam.getDstPSDEUILogicParam() || !logicNodeParam.srcValueType) {
                throw new Error(`逻辑参数${logicNodeParam.name}源类型参数或者目标逻辑参数缺失`);
            }
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 无值类型
            if (Object.is(logicNodeParam.srcValueType, 'NONEVALUE')) {
                if(logicNodeParam.dstFieldName){
                    dstParam.reset(logicNodeParam.dstFieldName.toLowerCase());
                }else{
                    dstParam.bind(undefined);
                }
            } else {
                const result = this.computeTargetParam(logicNodeParam, actionContext);
                if(logicNodeParam.dstFieldName){
                    dstParam.set(logicNodeParam.dstFieldName.toLowerCase(), result);
                }else{
                    dstParam.bind(result);
                }
                
            }
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 重置变量
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onResetParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        try {
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            dstParam.resetAll();
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 拷贝变量
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onCopyParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        try {
            // 源数据
            const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            srcParam.copyTo(dstParam);
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 绑定参数
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onBindParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        try {
            // 源数据
            const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 目标数据
            const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
            // 源属性
            const srcFieldName: string = logicNodeParam.srcFieldName?.toLowerCase?.();
            if (srcFieldName) {
                dstParam.bind(srcParam.get(srcFieldName));
            } else {
                dstParam.bind(srcParam.getReal());
            }
        } catch (error: any) {
            throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 重新建立变量
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onRenewParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
      try {
        // 目标参数
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        dstParam.renew();
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 附加到数组变量
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onAppendParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
      try {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 源属性
        const srcFieldName: string = logicNodeParam.srcFieldName?.toLowerCase?.();
        let objParam: any;
        if (srcFieldName) {
            objParam = srcParam.get(srcFieldName);
        } else {
            objParam = srcParam.getReal();
        }
        dstParam.append(logicNodeParam.dstIndex, objParam, logicNodeParam.srcIndex, logicNodeParam.srcSize);
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 排序数组变量
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam
     * @param {UIActionContext} actionContext
     * @memberof AppUILogicPrepareParamNode
     */
    public onSortParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
      try {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 目标属性
        const dstFieldName: string = logicNodeParam.dstFieldName?.toLowerCase?.();
        if (!dstFieldName) {
            throw new Error(`逻辑参数${logicNodeParam.name}未指定设置排序属性`);
        }
        dstParam.sort(dstFieldName, logicNodeParam.dstSortDir);
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 计算目标值
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam 节点参数
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicPrepareParamNode
     */
    public computeTargetParam(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        let targetValue: any;
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        // 源属性
        try {
          const srcFieldName: string = logicNodeParam?.srcFieldName?.toLowerCase();
          switch (logicNodeParam.srcValueType) {
              case "SRCDLPARAM":       // 源逻辑参数
              case 'WEBCONTEXT':       // 网页请求上下文
              case 'VIEWPARAM':        // 当前视图参数
                  targetValue = srcParam.get(srcFieldName) ? srcParam.get(srcFieldName) : null;
                  break;
              case 'APPLICATION':      // 系统全局对象          
              case 'SESSION':          // 用户全局对象 
              case "APPDATA":          // 应用上下文
              case "DATACONTEXT":      // 数据上下文
                  const { context } = actionContext;
                  targetValue = context[srcFieldName];
                  break;
              case 'ENVPARAM':         // 当前环境参数
                  const Environment = AppServiceBase.getInstance().getAppEnvironment();
                  targetValue = Environment[srcFieldName];
                  break;
              case 'EXPRESSION':       // 计算式
                  targetValue = this.computeExpRessionValue(logicNodeParam, actionContext);
                  break;
              case "SRCVALUE":         // 直接值
                  targetValue = logicNodeParam?.srcValue;
                  break;
              case 'NULLVALUE':        // 空值（NULL）
                  targetValue = null;
                  break;
              default:
                  throw new Error(`源值类型${logicNodeParam.srcValueType}暂未支持`);
          }
          return targetValue;
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }
    /**
     * 计算表达式值
     *
     * @param {IPSDEUILogicNodeParam} logicNodeParam 节点参数
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppUILogicPrepareParamNode
     */
    private computeExpRessionValue(logicNodeParam: IPSDEUILogicNodeParam, actionContext: UIActionContext) {
        let expression: string = logicNodeParam?.expression;
        let data: any = actionContext.defaultParam.getReal();
        let { context } = actionContext;
        if (!expression) {
            throw new Error(`表达式不能为空`);
        }
        try {
            expression = this.translateExpression(expression);
            return eval(expression);
        } catch (error) {
            throw new Error(`表达式计算异常: ${error}`);
        }
    }

    /**
     * 解析表达式
     *
     * @param {string} expression 表达式
     * @memberof AppUILogicPrepareParamNode
     */
    private translateExpression(expression: string): string {
        if ((expression.indexOf('${') != -1) && (expression.indexOf('}') != -1)) {
            const start: number = expression.indexOf('${');
            const end: number = expression.indexOf('}');
            const contentStr: string = expression.slice(start + 2, end);
            expression = expression.replace(expression.slice(start, end + 1), `data.${contentStr}`);
            return this.translateExpression(expression);
        }
        return expression;
    }

}