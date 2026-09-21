import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 指定部件对象参数
 *
 * @export
 * @class UILogicCtrlParam
 */
export class UILogicCtrlParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicCtrlParam.
     * @param {*} opts
     * @memberof UILogicCtrlParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicCtrlParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.ctrlParam;
        this.setReal({});
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicCtrlParam
     */
    public reset(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为指定部件类型，无法重置指定属性`);
    }

    /**
     * 重置全部
     *
     * @memberof UILogicCtrlParam
     */
    public resetAll() {
        throw new Error(`逻辑参数${this.strCodeName}为指定部件类型，无法重置全部`);
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof UILogicCtrlParam
     */
    public copyTo(dstParam: any) {
        throw new Error(`逻辑参数${this.strCodeName}为指定部件类型，无法拷贝当前变量到指定变量`);
    }
    
}