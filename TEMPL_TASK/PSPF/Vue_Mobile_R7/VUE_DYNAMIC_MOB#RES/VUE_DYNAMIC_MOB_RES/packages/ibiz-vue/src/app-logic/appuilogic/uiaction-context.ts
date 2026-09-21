import { IPSDEUILogicParam } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "ibiz-core";
import { AppDeUILogicParamService } from "./uilogic-param/ui-logic-param-service";

/**
 * 界面处理逻辑上下文参数对象
 *
 * @export
 * @class UIActionContext
 */
export class UIActionContext {

    /**
     * 应用上下文
     *
     * @type {IContext}
     * @memberof UIActionContext
     */
    private appContext: IContext;

    /**
     * 视图参数
     *
     * @type {IParams}
     * @memberof UIActionContext
     */
    private viewParam: IParams;

    /**
     * 默认逻辑处理参数名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public defaultParamName: string = '';

    /**
     * 应用上下文参数名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public navContextParamName: string = '';

    /**
     * 视图参数名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public navViewParamParamName: string = '';

    /**
     * 当前容器对象名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public activeContainerParamName: string = '';

    /**
     * 当前激活部件对象名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public activeCtrlParamName: string = '';

    /**
     * 当前激活视图对象名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    public activeViewParamName: string = '';

    /**
     * 容器对象
     *
     * @type {*}
     * @memberof UIActionContext
     */
    public actionContainer: any;

    /**
     * 附加参数
     *
     * @type {*}
     * @memberof UIActionContext
     */
    public additionalParam: any;

    /**
     * 逻辑处理参数集合
     *
     * @type {Map<string, any>}
     * @memberof UIActionContext
     */
    public paramsMap: Map<string, any> = new Map();

    /**
     * 默认逻辑处理参数
     *
     * @readonly
     * @memberof UIActionContext
     */
    get defaultParam() {
        return this.paramsMap.get(this.defaultParamName);
    }

    /**
     * 上下文数据（包括应用上下文和逻辑局部上下文参数）
     *
     * @readonly
     * @memberof UIActionContext
     */
    get context() {
        const navContextParam = this.paramsMap.get(this.navContextParamName);
        if (navContextParam) {
            return navContextParam.getReal();
        } else {
            return this.appContext;
        }
    }

    /**
     * 视图参数数据（包括外部传入视图参数和逻辑局部视图参数）
     *
     * @readonly
     * @memberof UIActionContext
     */
    get viewparams() {
        const navViewParamParam = this.paramsMap.get(this.navViewParamParamName);
        if (navViewParamParam) {
            return navViewParamParam.getReal();
        } else {
            return this.viewParam;
        }
    }

    /**
     * 获取逻辑处理参数
     *
     * @param {string} key 逻辑处理参数的codeName
     * @memberof UIActionContext
     */
    public getParam(key: string) {
        return this.paramsMap.get(key);
    }

    /**
     * 返回结果
     *
     * @type {*}
     * @memberof UIActionContext
     */
    private result: any;

    /**
     * 设置返回结果
     *
     * @param {*} opts
     * @memberof UIActionContext
     */
    public setResult(opts: any) {
        this.result = opts;
    }

    /**
     * 获取返回结果
     *
     * @return {*} 
     * @memberof UIActionContext
     */
    public getResult() {
        return this.result;
    }

    /**
     * 上一次调用返回参数名称
     *
     * @type {string}
     * @memberof UIActionContext
     */
    private lastReturnParamName: string = '';

    /**
     * 绑定上一次调用返回参数
     *
     * @readonly
     * @memberof UIActionContext
     */
    public bindLastReturnParam(value: any) {
        const lastReturnParam = this.paramsMap.get(this.lastReturnParamName);
        if (lastReturnParam) {
            lastReturnParam.bind(value);
        }
    }

    /**
     * 构造函数
     * 
     * @param {*} logic 处理逻辑模型对象
     * @param {any[]} args 数据对象
     * @param {*} context 应用上下文
     * @param {*} params 视图参数
     * @param {*} $event 事件源对象
     * @param {*} xData 部件对象
     * @param {*} actioncontext 界面容器对象
     * @param {*} srfParentDeName 关联父应用实体代码名称
     * @memberof UIActionContext
     */
    constructor(logic: any, args: any[], context: any = {}, params: any = {},
        $event?: any, xData?: any, actioncontext?: any, srfParentDeName?: string) {
        this.appContext = context;
        this.viewParam = params;
        this.actionContainer = actioncontext;
        this.additionalParam = { args, $event, xData, actioncontext, srfParentDeName };
        // 初始化界面逻辑处理参数
        if (logic.getPSDEUILogicParams() && (logic.getPSDEUILogicParams() as IPSDEUILogicParam[]).length > 0) {
            for (let logicParam of (logic.getPSDEUILogicParams() as IPSDEUILogicParam[])) {
                const uiLogicParamInstance = AppDeUILogicParamService.getLogicParamInstance(this, logicParam, { args, context, params, $event, xData, actioncontext, srfParentDeName });
                this.paramsMap.set(logicParam.codeName, uiLogicParamInstance);
                if (logicParam.default) this.defaultParamName = logicParam.codeName;
                if (logicParam.navContextParam) this.navContextParamName = logicParam.codeName;
                if (logicParam.navViewParamParam) this.navViewParamParamName = logicParam.codeName;
                if (logicParam.activeContainerParam) this.activeContainerParamName = logicParam.codeName;
                if (logicParam.activeCtrlParam) this.activeCtrlParamName = logicParam.codeName;
                if (logicParam.activeViewParam) this.activeViewParamName = logicParam.codeName;
                if (logicParam.lastReturnParam) this.lastReturnParamName = logicParam.codeName;
            }
        }
    }
}
