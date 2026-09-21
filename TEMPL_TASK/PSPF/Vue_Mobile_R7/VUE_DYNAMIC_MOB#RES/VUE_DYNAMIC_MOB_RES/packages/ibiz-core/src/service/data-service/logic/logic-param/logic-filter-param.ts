import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑过滤对象参数
 *
 * @export
 * @class AppDeLogicFilterParam
 */
export class AppDeLogicFilterParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicFilterParam.
     * @param {*} opts
     * @memberof AppDeLogicFilterParam
     */
    public constructor(opts: any) {
        super(opts);
        this.logicParamType = LogicParamType.filterParam;   
    }
}