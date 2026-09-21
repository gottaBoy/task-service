import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 导航数据参数绑定参数
 *
 * @export
 * @class UILogicViewNavDataParam
 */
export class UILogicViewNavDataParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicViewNavDataParam.
     * @param {*} opts
     * @memberof UILogicViewNavDataParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicViewNavDataParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.viewNavDataParam;
        this.realValue = this.getViewNavDataParam(params);
    }

    /**
     * 获取导航数据参数绑定参数
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicViewNavDataParam
     */
    private getViewNavDataParam(params: IParams) {
        const { actioncontext } = params;
        const { viewCtx } = actioncontext;
        if (viewCtx && viewCtx['viewNavData']) {
            return viewCtx['viewNavData'];
        }
    }
}