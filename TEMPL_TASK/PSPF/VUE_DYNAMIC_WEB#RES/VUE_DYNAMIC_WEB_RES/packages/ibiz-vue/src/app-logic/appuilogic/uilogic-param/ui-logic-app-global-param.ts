import { AppServiceBase, IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 应用全局变量
 *
 * @export
 * @class UILogicAppGlobalParam
 */
export class UILogicAppGlobalParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicAppGlobalParam.
     * @param {*} opts
     * @memberof UILogicAppGlobalParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicAppGlobalParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.appGlobalParam;
        this.setReal(this.getAppGlobalParam(params));
    }

    /**
     * 设置实际参数值
     *
     * @param {*} opts
     * @memberof AppDeUILogicParamBase
     */
    public setReal(opts: any) {
        this.realValue = opts;
        AppServiceBase.getInstance().getAppStore().commit('addAppGlobal', { tag: this.logicParamModel.paramFieldName, param: opts });
    }

    /**
     * 获取应用全局变量
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicAppGlobalParam
     */
    private getAppGlobalParam(params: IParams) {
        const { actioncontext } = params;
        const { viewCtx } = actioncontext;
        if (viewCtx && viewCtx['appGlobal']) {
            let result = actioncontext.viewCtx['appGlobal'][this.logicParamModel.paramFieldName];
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
     * @memberof UILogicAppGlobalParam
     */
    public set(strName: string, value: any) {
        this.realValue[strName] = value;
        AppServiceBase.getInstance().getAppStore().commit('addAppGlobal', { tag: this.logicParamModel.paramFieldName, param: this.realValue });
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicAppGlobalParam
     */
    public reset(strName: string) {
        this.realValue[strName] = null;
        AppServiceBase.getInstance().getAppStore().commit('addAppGlobal', { tag: this.logicParamModel.paramFieldName, param: this.realValue });
    }

}