import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑上一次调用返回参数
 *
 * @export
 * @class AppDeLogicLastReturnParam
 */
export class AppDeLogicLastReturnParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicLastReturnParam.
     * @param {*} opts
     * @memberof AppDeLogicLastReturnParam
     */
    public constructor(opts: any) {
        super(opts);
        this.logicParamType = LogicParamType.lastReturnParam;
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeLogicLastReturnParam
     */
    public bind(opts: any) {
        this.setReal(opts);
    }
}