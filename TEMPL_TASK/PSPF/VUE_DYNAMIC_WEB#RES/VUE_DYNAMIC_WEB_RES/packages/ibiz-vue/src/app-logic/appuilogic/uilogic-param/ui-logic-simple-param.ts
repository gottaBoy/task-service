import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑简单数据参数
 *
 * @export
 * @class AppDeUILogicSampleParam
 */
export class AppDeUILogicSampleParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicSampleParam.
     * @param {*} opts
     * @memberof AppDeUILogicSampleParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicParamBase
     */
    protected init(opts: IParams) {
        this.logicParamType = UILogicParamType.simpleParam;
        this.setReal(null);
    }
    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicSampleParam
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
     * @memberof AppDeUILogicSampleParam
     */
    public set(strName: string, value: any) {
        this.setReal(value);
    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeUILogicSampleParam
     */
    public get(strName: string) {
        return this.realValue;
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof AppDeUILogicSampleParam
     */
    public reset(strName: string) {
        this.realValue = null;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicSampleParam
     */
    public resetAll() {
        this.realValue = null;
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeUILogicSampleParam
     */
    public renew() {
        this.realValue = null;
    }

}