import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 应用程序变量
 *
 * @export
 * @class AppDeUILogicAppParam
 */
export class AppDeUILogicAppParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicAppParam.
     * @param {*} opts
     * @memberof AppDeUILogicAppParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicAppParam
     */
    protected init(params: IParams) {
        this.setReal(this.getActiveApp(params));
        this.logicParamType = UILogicParamType.applicationParam;
    }

    /**
     * 获取激活视图
     *
     * @private
     * @param {IParams} params
     * @memberof AppDeUILogicAppParam
     */
     private getActiveApp(params: IParams) {
        const { actioncontext } = params;
        if (actioncontext && actioncontext.viewCtx && actioncontext.viewCtx.app) {
            return actioncontext.viewCtx.app;
        } else {
            return null;
        }
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof AppDeUILogicAppParam
     */
    public set(strName: string, value: any) {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法设置指定属性值`);
    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeUILogicAppParam
     */
    public get(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法获取指定属性值`);
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof AppDeUILogicAppParam
     */
    public reset(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法重置指定属性`);
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicParamBase
     */
    public resetAll() {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法重置全部`);
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof AppDeUILogicParamBase
     */
    public copyTo(dstParam: any) {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法拷贝当前变量到指定变量`);
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicParamBase
     */
    public bind(opts: any) {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法绑定指定参数对象`);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeUILogicParamBase
     */
    public renew() {
        throw new Error(`逻辑参数${this.strCodeName}为应用程序变量类型，无法重新建立参数对象`);
    }
}