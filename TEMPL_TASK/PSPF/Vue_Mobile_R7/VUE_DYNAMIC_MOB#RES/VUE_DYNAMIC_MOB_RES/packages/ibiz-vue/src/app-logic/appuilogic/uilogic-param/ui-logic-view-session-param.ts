import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 当前视图会话共享参数绑定参数
 *
 * @export
 * @class UILogicViewSessionParam
 */
export class UILogicViewSessionParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicViewSessionParam.
     * @param {*} opts
     * @memberof UILogicViewSessionParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicViewSessionParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.viewSessionParam;
        this.realValue = this.getViewSessionParam(params);
    }

    /**
     * 获取当前视图会话共享参数绑定参数
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicViewSessionParam
     */
    private getViewSessionParam(params: IParams) {
        const { actioncontext } = params;
        const { viewCtx } = actioncontext;
        if (viewCtx && viewCtx['viewGlobal']) {
            return viewCtx['viewGlobal'];
        }
    }
}