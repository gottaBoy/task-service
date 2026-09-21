import { LogicParamType } from "../const/logic-param-type";
import { AppDeLogicParamBase } from "./logic-param-base";

/**
 * 逻辑简单数据参数
 *
 * @export
 * @class AppDeLogicSampleParam
 */
export class AppDeLogicSampleParam extends AppDeLogicParamBase {

    /**
     * Creates an instance of AppDeLogicSampleParam.
     * @param {*} opts
     * @memberof AppDeLogicSampleParam
     */
    public constructor(opts: any) {
        super(opts);
        const { value } = opts;
        this.realValue = value ? value : null;
        this.logicParamType = LogicParamType.simpleParam;
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeLogicSampleParam
     */
    public bind(opts: any) {
        const typeResult = Object.prototype.toString.call(opts);
        if ((typeResult !== '[object String]') && (typeResult !== '[object Boolean]') && (typeResult !== '[object Number]') && (typeResult !== '[object Null]') && (typeResult !== '[object Undefined]')) {
            throw new Error(`逻辑参数${this.strCodeName}无法绑定非基本类型参数`);
        }
        this.setReal(opts);
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof AppDeLogicSampleParam
     */
    public set(strName: string, value: any) {
        this.setReal(value);

    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeLogicSampleParam
     */
    public get(strName: string) {
        return this.realValue;
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof AppDeLogicSampleParam
     */
    public reset(strName: string) {
        this.setReal(null);
    }

    /**
     * 重置全部
     *
     * @memberof AppDeLogicSampleParam
     */
    public resetAll() {
        this.setReal(null);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeLogicSampleParam
     */
    public renew() {
        this.setReal(null);
    }

}