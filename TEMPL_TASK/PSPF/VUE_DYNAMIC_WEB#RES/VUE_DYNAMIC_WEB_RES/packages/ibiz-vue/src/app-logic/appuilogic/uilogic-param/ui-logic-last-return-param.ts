import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑上一次调用返回参数
 *
 * @export
 * @class AppDeUILogicLastReturnParam
 */
export class AppDeUILogicLastReturnParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicLastReturnParam.
     * @param {*} opts
     * @memberof AppDeUILogicLastReturnParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicLastReturnParam
     */
    protected init(params: IParams) {
        super.init(params);
        this.logicParamType = UILogicParamType.lastReturnParam;
    }
}