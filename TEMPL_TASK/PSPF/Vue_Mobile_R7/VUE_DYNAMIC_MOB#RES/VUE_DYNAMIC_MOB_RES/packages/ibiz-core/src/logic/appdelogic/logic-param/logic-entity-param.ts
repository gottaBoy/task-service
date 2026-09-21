import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑数据对象参数
 *
 * @export
 * @class AppDeLogicEntityParam
 */
export class AppDeLogicEntityParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicEntityParam.
     * @param {*} opts
     * @memberof AppDeLogicEntityParam
     */
    public constructor(opts: any) {
        super(opts);
        this.logicParamType = LogicParamType.entityParam;
    }
}