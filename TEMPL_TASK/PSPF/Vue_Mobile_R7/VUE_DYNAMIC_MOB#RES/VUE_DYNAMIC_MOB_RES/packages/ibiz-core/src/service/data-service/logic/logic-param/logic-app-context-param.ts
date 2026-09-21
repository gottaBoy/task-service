import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑应用上下文变量
 *
 * @export
 * @class AppDeLogicAppContextParam
 */
export class AppDeLogicAppContextParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicAppContextParam.
     * @param {*} opts
     * @memberof AppDeLogicAppContextParam
     */
    public constructor(opts: any) {
        super(opts);
        const { actionSession } = opts;
        this.realValue = actionSession.context ? actionSession.context : {};
        this.logicParamType = LogicParamType.appContextParam;
    }

}