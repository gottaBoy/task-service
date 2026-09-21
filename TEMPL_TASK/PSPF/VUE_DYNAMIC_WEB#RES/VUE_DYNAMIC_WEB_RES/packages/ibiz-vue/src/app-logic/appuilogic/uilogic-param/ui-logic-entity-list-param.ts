import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑数据对象列表参数
 *
 * @export
 * @class AppDeUILogicEntityListParam
 */
export class AppDeUILogicEntityListParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicEntityListParam.
     * @param {*} opts
     * @memberof AppDeUILogicEntityListParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicEntityListParam
     */
    protected init(params: IParams) {
        this.setReal(this.getDefaultValue(params, []));
        this.logicParamType = UILogicParamType.entityListParam;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicEntityListParam
     */
    public resetAll() {
        this.realValue = [];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicEntityListParam
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
     * @memberof AppDeUILogicEntityListParam
     */
    public renew() {
        this.realValue = [];
    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeUILogicEntityListParam
     */
    public get(strName: string) {
        if (Object.prototype.toString.call(this.realValue) !== '[object Array]') {
            throw new Error(`逻辑参数${this.strCodeName}非对象类型参数无法执行获取指定属性值`);
        }
        if (!isNaN(Number(strName))) {
            return this.realValue[Number(strName)];
        }
        throw new Error(`逻辑参数${this.strCodeName}对象列表类型参数无法获取非数值下标属性`);
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof AppDeUILogicEntityListParam
     */
    public set(strName: string, value: any) {
        if (Object.prototype.toString.call(this.realValue) !== '[object Array]') {
            throw new Error(`逻辑参数${this.strCodeName}无法执行绑定非对象列表类型参数`);
        }
        if (isNaN(Number(strName))) {
            throw new Error(`逻辑参数${this.strCodeName}对象列表类型参数无法执行绑定到非数值下标`);
        }
        this.realValue[Number(strName)] = value;
    }

}