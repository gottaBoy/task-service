import { AppServiceBase, IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 界面顶级视图会话共享参数绑定参数
 *
 * @export
 * @class UILogicRouteViewSessionParam
 */
export class UILogicRouteViewSessionParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicRouteViewSessionParam.
     * @param {*} opts
     * @memberof UILogicRouteViewSessionParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicRouteViewSessionParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.routeViewSessionParam;
        this.realValue = this.setReal(this.getRouteViewSessionParam(params));
    }

    /**
     * 设置实际参数值
     *
     * @param {*} opts
     * @memberof UILogicRouteViewSessionParam
     */
    public setReal(opts: any) {
        this.realValue = opts;
        const actionContainer = this.actionSession.actionContainer;
        AppServiceBase.getInstance().getAppStore().commit('addRouteViewGlobal', { tag: actionContainer?.context.srfsessionid, param: { [this.logicParamModel.paramFieldName]: opts } });
    }

    /**
     * 获取界面顶级视图会话共享参数绑定参数
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicRouteViewSessionParam
     */
    private getRouteViewSessionParam(params: IParams) {
        const { actioncontext } = params;
        const { viewCtx, context } = actioncontext;
        if (viewCtx && viewCtx['routeViewGlobal']) {
            let result = actioncontext.viewCtx['routeViewGlobal'][this.logicParamModel.paramFieldName];
            if (!result) {
                result = {};
            }
            return result;
        }
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof UILogicRouteViewSessionParam
     */
    public set(strName: string, value: any) {
        this.realValue[strName] = value;
        const actionContainer = this.actionSession.actionContainer;
        AppServiceBase.getInstance().getAppStore().commit('addRouteViewGlobal', { tag: actionContainer?.context.srfsessionid, param: { [this.logicParamModel.paramFieldName]: this.realValue } });
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicRouteViewSessionParam
     */
    public reset(strName: string) {
        this.realValue[strName] = null;
        const actionContainer = this.actionSession.actionContainer;
        AppServiceBase.getInstance().getAppStore().commit('addRouteViewGlobal', { tag: actionContainer?.context.srfsessionid, param: { [this.logicParamModel.paramFieldName]: this.realValue } });
    }
}