import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑数据对象列表参数
 *
 * @export
 * @class AppDeLogicEntityListParam
 */
export class AppDeLogicEntityListParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicEntityListParam.
     * @param {*} opts
     * @memberof AppDeLogicEntityListParam
     */
    public constructor(opts: any) {
        super(opts);
        const { value } = opts;
        this.realValue = value ? value : [];
        this.logicParamType = LogicParamType.entityListParam;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeLogicEntityListParam
     */
    public resetAll() {
        this.realValue = [];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeLogicEntityListParam
     */
    public bind(opts: any) {
        if (Object.prototype.toString.call(opts) !== '[object Array]') {
            throw new Error(`逻辑参数${this.strCodeName}无法绑定非数组类型参数`);
        }
        this.setReal(opts);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeLogicEntityListParam
     */
    public renew() {
        this.realValue = [];
    }
}