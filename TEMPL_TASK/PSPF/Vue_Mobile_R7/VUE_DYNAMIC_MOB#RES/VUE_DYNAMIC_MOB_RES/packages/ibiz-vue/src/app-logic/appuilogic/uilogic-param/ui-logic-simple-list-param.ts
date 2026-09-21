import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑简单数据列表参数
 *
 * @export
 * @class AppDeUILogicSimpleListParam
 */
export class AppDeUILogicSimpleListParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicSimpleListParam.
     * @param {*} opts
     * @memberof AppDeUILogicSimpleListParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicSimpleListParam
     */
    protected init(params: IParams) {
        this.setReal(this.getDefaultValue(params, []));
        this.logicParamType = UILogicParamType.simpleListParam;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicSimpleListParam
     */
    public resetAll() {
        this.realValue = [];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicSimpleListParam
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
     * @memberof AppDeUILogicSimpleListParam
     */
    public renew() {
        this.realValue = [];
    }

}