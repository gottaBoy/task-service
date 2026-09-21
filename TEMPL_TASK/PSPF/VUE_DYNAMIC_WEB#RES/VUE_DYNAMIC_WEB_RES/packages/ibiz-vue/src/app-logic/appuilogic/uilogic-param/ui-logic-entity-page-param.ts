import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑数据对象列表参数
 *
 * @export
 * @class AppDeUILogicEntityPageParam
 */
export class AppDeUILogicEntityPageParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicEntityPageParam.
     * @param {*} opts
     * @memberof AppDeUILogicEntityPageParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicEntityPageParam
     */
    protected init(params: IParams) {
        this.setReal(this.getDefaultValue(params, []));
        this.logicParamType = UILogicParamType.entityListParam;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicEntityPageParam
     */
    public resetAll() {
        this.realValue = [];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicEntityPageParam
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
     * @memberof AppDeUILogicEntityPageParam
     */
    public renew() {
        this.realValue = [];
    }
}