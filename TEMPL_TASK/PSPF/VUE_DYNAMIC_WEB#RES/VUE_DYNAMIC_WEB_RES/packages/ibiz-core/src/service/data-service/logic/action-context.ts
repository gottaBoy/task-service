import { IPSAppDELogic, IPSDELogicParam } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "../../../interface";
import { AppDeLogicParamService } from "./logic-param/logic-param-service";

/**
 * 实体处理逻辑上下文参数对象
 *
 * @export
 * @class ActionContext
 */
export class ActionContext {

    /**
     * 实体行为服务context
     *
     * @type {IContext}
     * @memberof ActionContext
     */
    public appContext: IContext;

    /**
     * 逻辑处理参数集合
     *
     * @type {Map<string, any>}
     * @memberof ActionContext
     */
    public paramsMap: Map<string, any> = new Map();

    /**
     * 默认逻辑处理参数名称
     *
     * @type {string}
     * @memberof ActionContext
     */
    private defaultParamName: string = '';

    /**
     * 默认逻辑处理参数
     *
     * @readonly
     * @memberof ActionContext
     */
    get defaultParam() {
        return this.paramsMap.get(this.defaultParamName);
    }

    /**
     * 上一次调用返回参数名称
     *
     * @type {string}
     * @memberof ActionContext
     */
    private lastReturnParamName: string = '';

    /**
     * 绑定上一次调用返回参数
     *
     * @readonly
     * @memberof ActionContext
     */
    public bindLastReturnParam(value: any) {
        const lastReturnParam = this.paramsMap.get(this.lastReturnParamName);
        if (lastReturnParam) {
            lastReturnParam.bind(value);
        }
    }

    /**
     * 应用上下文参数名称
     *
     * @type {string}
     * @memberof ActionContext
     */
    public appContextParamName: string = '';

    /**
     * 上下文数据（包括应用上下文和逻辑局部上下文参数）
     *
     * @readonly
     * @memberof UIActionContext
     */
    get context() {
        const navContextParam = this.paramsMap.get(this.appContextParamName);
        if (navContextParam) {
            return navContextParam.getReal();
        } else {
            return this.appContext;
        }
    }

    /**
     * 获取逻辑处理参数
     *
     * @param {string} key 逻辑处理参数的codeName
     * @memberof ActionContext
     */
    public getParam(key: string) {
        return this.paramsMap.get(key);
    }

    /**
     * 返回结果
     *
     * @type {*}
     * @memberof ActionContext
     */
    private result: any;

    /**
     * 设置返回结果
     *
     * @param {*} opts
     * @memberof ActionContext
     */
    public setResult(opts: any) {
        this.result = opts;
    }

    /**
     * 获取返回结果
     *
     * @return {*} 
     * @memberof ActionContext
     */
    public getResult() {
        return this.result;
    }

    /**
     * 构造函数
     * 
     * @param {IPSAppDELogic} logic 处理逻辑模型对象
     * @param {IContext} context 实体行为服务context
     * @param {IParams} params 实体行为服务data
     * @memberof ActionContext
     */
    constructor(logic: IPSAppDELogic, context: IContext, params: IParams) {
        this.appContext = context;
        // 初始化逻辑处理参数
        if (logic.getPSDELogicParams() && (logic.getPSDELogicParams() as IPSDELogicParam[]).length > 0) {
            for (let logicParam of (logic.getPSDELogicParams() as IPSDELogicParam[])) {
                const initValue = logicParam.default ? params : undefined;
                const logicParamInstance = AppDeLogicParamService.getLogicParamInstance(this, logicParam, initValue);
                this.paramsMap.set(logicParam.codeName, logicParamInstance);
                if (logicParam.default) this.defaultParamName = logicParam.codeName;
                if (logicParam.lastReturnParam) this.lastReturnParamName = logicParam.codeName;
                if(logicParam.appContextParam) this.appContextParamName = logicParam.codeName;
            }
        }
    }
}
