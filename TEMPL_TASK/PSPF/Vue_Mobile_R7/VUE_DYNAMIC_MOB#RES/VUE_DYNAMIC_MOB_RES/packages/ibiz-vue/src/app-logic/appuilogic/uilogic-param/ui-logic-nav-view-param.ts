import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 导航视图参数绑定参数
 *
 * @export
 * @class UILogicNavViewParam
 */
export class UILogicNavViewParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicNavViewParam.
     * @param {*} opts
     * @memberof UILogicNavViewParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicNavViewParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.navViewParamParam;
        this.realValue = this.getNavViewParam(params);
    }

    /**
     * 获取导航视图参数绑定参数
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicNavViewParam
     */
    private getNavViewParam(params: IParams) {
        return params?.params;
    }
}