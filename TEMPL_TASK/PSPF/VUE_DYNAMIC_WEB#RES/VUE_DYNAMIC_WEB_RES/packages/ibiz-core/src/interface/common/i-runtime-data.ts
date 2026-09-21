import { IContext, IParams } from "ibiz-core";

export interface IRunTimeData {

    /**
     * 应用上下文
     *
     * @type {IContext}
     * @memberof IRunTimeData
     */
    context?: IContext;

    /**
     * 视图参数
     *
     * @type {IParams}
     * @memberof IRunTimeData
     */
    viewParam?: IParams;

    /**
     * 额外参数
     *
     * @type {IParams}
     * @memberof IRunTimeData
     */
    args?: IParams;

}