import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 当前容器对象
 *
 * @export
 * @class UILogicActiveContainerParam
 */
export class UILogicActiveContainerParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicActiveContainerParam.
     * @param {*} opts
     * @memberof UILogicActiveContainerParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicActiveContainerParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.activeContainerParam;
        this.setReal(params.actioncontext);
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicActiveContainerParam
     */
    public reset(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为当前容器类型，无法重置指定属性`);
    }

    /**
     * 重置全部
     *
     * @memberof UILogicActiveContainerParam
     */
    public resetAll() {
        throw new Error(`逻辑参数${this.strCodeName}为当前容器类型，无法重置全部`);
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof UILogicActiveContainerParam
     */
    public copyTo(dstParam: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前容器类型，无法拷贝当前变量到指定变量`);
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof UILogicActiveContainerParam
     */
    public bind(opts: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前容器类型，无法绑定指定参数对象`);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof UILogicActiveContainerParam
     */
    public renew() {
        throw new Error(`逻辑参数${this.strCodeName}为当前容器类型，无法重新建立参数对象`);
    }

}