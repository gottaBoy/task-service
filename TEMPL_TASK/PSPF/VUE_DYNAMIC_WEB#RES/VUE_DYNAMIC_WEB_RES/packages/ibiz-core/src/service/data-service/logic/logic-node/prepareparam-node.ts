import { IPSDELogicNode, IPSDELogicNodeParam, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { LogUtil } from '../../../../utils';
import { AppServiceBase } from '../../../app-service/app-base.service';
import { ActionContext } from '../action-context';
import { LogicParamValueType } from '../const/logic-param-value-type';
import { AppDeLogicNodeBase } from './logic-node-base';

/**
 * 准备参数节点
 *
 * @export
 * @class AppDeLogicPrepareParamNode
 */
export class AppDeLogicPrepareParamNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDELogicNode} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicPrepareParamNode
     */
    public async executeNode(logicNode: IPSDELogicNode, actionContext: ActionContext) {
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
     * @memberof AppDeLogicPrepareParamNode
     */
    public handleParam(logicNode: IPSDELogicNode, actionContext: ActionContext) {
        if (!logicNode || !logicNode.getPSDELogicNodeParams()) {
            return;
        }
        try {
          for (let logicNodeParam of (logicNode.getPSDELogicNodeParams() as IPSDELogicNodeParam[])) {
            // 设置变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.SETPARAMVALUE)) {
                this.onSetParamValue(logicNodeParam, actionContext);
            }
            // 重置变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.RESETPARAM)) {
                this.onResetParam(logicNodeParam, actionContext);
            }
            // 拷贝变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.COPYPARAM)) {
                this.onCopyParam(logicNodeParam, actionContext);
            }
            // 绑定参数
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.BINDPARAM)) {
                this.onBindParam(logicNodeParam, actionContext);
            }
            // 重新建立变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.RENEWPARAM)) {
                this.onRenewParam(logicNodeParam, actionContext);
            }
            // 附加到数组变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.APPENDPARAM)) {
                this.onAppendParam(logicNodeParam, actionContext);
            }
            // 排序数组变量
            if (Object.is(logicNodeParam.paramAction, LogicParamValueType.SORTPARAM)) {
                this.onSortParam(logicNodeParam, actionContext);
            }
          }
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 设置变量
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onSetParamValue(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 源类型参数/目标逻辑参数/目标属性缺一跳过不做处理
        if (!logicNodeParam.getDstPSDELogicParam() || !logicNodeParam.dstFieldName || !logicNodeParam.srcValueType) {
            throw new Error(`逻辑参数${logicNodeParam.name}源类型参数、目标属性或者目标逻辑参数缺失`);
        }
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 无值类型
        if (Object.is(logicNodeParam.srcValueType, 'NONEVALUE')) {
            dstParam.reset(logicNodeParam.dstFieldName.toLowerCase());
        } else {
            const result = this.computeTargetParam(logicNodeParam, actionContext);
            dstParam.set(logicNodeParam.dstFieldName.toLowerCase(), result);
        }
      } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
      } 
    }

    /**
     * 重置变量
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onResetParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        dstParam.resetAll();
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 绑定参数
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onBindParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
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
     * 拷贝变量
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onCopyParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        srcParam.copyTo(dstParam);
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 重新建立变量
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onRenewParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 目标参数
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        dstParam.renew();
      } catch (error: any) {
        throw new Error(`逻辑参数${logicNodeParam.name}${error?.message ? error?.message : '发生未知错误！'}`);
      }
    }

    /**
     * 附加到数组变量
     *
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onAppendParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
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
     * @param {logicNodeParam} IPSDELogicNodeParam
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicPrepareParamNode
     */
    public onSortParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
      try {
        // 目标数据
        const dstParam: any = actionContext.getParam((logicNodeParam.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
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
     * @param {IPSDELogicNodeParam} logicNodeParam 节点参数
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppDeLogicPrepareParamNode
     */
    private computeTargetParam(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
        let targetValue: any;
        // 源数据
        const srcParam: any = actionContext.getParam((logicNodeParam.getSrcPSDELogicParam() as IPSDELogicParam)?.codeName);
        // 源属性
        const srcFieldName: string = logicNodeParam?.srcFieldName?.toLowerCase();
        try {
          switch (logicNodeParam.srcValueType) {
            case "SRCDLPARAM":       // 源逻辑参数
                targetValue = srcParam.get(srcFieldName) ? srcParam.get(srcFieldName) : null;
                break;
            case 'APPLICATION':      // 系统全局对象          
            case 'SESSION':          // 用户全局对象 
            case "APPDATA":          // 应用上下文
            case "DATACONTEXT":      // 数据上下文
                const { context } = actionContext;
                targetValue = context[srcFieldName];
                break;
            case 'WEBCONTEXT':       // 网页请求上下文
            case 'VIEWPARAM':        // 当前视图参数
                targetValue = actionContext.defaultParam.get(srcFieldName);
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
                throw new Error(`逻辑参数${logicNodeParam.name}源值类型${logicNodeParam.srcValueType}暂未支持`);
          }
          return targetValue;
        } catch (error: any) {
          throw new Error(`${error?.message ? error?.message : '发生未知错误！'}`);
        } 
    }

    /**
     * 计算表达式值
     *
     * @param {IPSDELogicNodeParam} logicNodeParam 节点参数
     * @param {ActionContext} actionContext  逻辑上下文
     * @memberof AppDeLogicPrepareParamNode
     */
    private computeExpRessionValue(logicNodeParam: IPSDELogicNodeParam, actionContext: ActionContext) {
        let expression: string = logicNodeParam.expression;
        let data: any = actionContext.defaultParam.getReal();
        let { context } = actionContext;
        if (!expression) {
            throw new Error(`逻辑参数${logicNodeParam.name}表达式不能为空`);
        }
        try {
            expression = this.translateExpression(expression);
            return eval(expression);
        } catch (error) {
            throw new Error(`逻辑参数${logicNodeParam.name}表达式计算异常`);
        }
    }

    /**
     * 解析表达式
     *
     * @param {string} expression 表达式
     * @memberof AppDeLogicPrepareParamNode
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