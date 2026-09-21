import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑过滤对象参数
 *
 * @export
 * @class AppDeUILogicFilterParam
 */
export class AppDeUILogicFilterParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicFilterParam.
     * @param {*} opts
     * @memberof AppDeUILogicFilterParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicFilterParam
     */
    protected init(params: IParams) {
        super.init(params);
        this.logicParamType = UILogicParamType.filterParam;
    }
}