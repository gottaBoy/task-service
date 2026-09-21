import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 导航上下文绑定参数
 *
 * @export
 * @class UILogicNavContextParam
 */
export class UILogicNavContextParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicNavContextParam.
     * @param {*} opts
     * @memberof UILogicNavContextParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicNavContextParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.navContextParam;
        this.setReal(this.getNavContextParam(params));
    }

    /**
     * 获取导航上下文绑定参数
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicNavContextParam
     */
    private getNavContextParam(params: IParams) {
        const { context } = params;
        return context;
    }
}