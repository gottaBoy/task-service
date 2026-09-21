import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑简单数据列表参数
 *
 * @export
 * @class AppDeLogicSimpleListParam
 */
export class AppDeLogicSimpleListParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicSimpleListParam.
     * @param {*} opts
     * @memberof AppDeLogicSimpleListParam
     */
    public constructor(opts: any) {
        super(opts);
        const { value } = opts;
        this.realValue = value ? value : [];
        this.logicParamType = LogicParamType.simpleListParam;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeLogicSimpleListParam
     */
    public resetAll() {
        this.realValue = [];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeLogicSimpleListParam
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
     * @memberof AppDeLogicSimpleListParam
     */
    public renew() {
        this.realValue = [];
    }

}