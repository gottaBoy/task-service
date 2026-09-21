import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 逻辑数据对象参数
 *
 * @export
 * @class AppDeUILogicEntityParam
 */
export class AppDeUILogicEntityParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of AppDeUILogicEntityParam.
     * @param {*} opts
     * @memberof AppDeUILogicEntityParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicEntityParam
     */
    protected init(params: IParams) {
        super.init(params);
        this.logicParamType = UILogicParamType.entityParam;
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicEntityParam
     */
    public bind(opts: any) {
        let srcObj: any;
        if (opts) {
            if (Object.prototype.toString.call(opts) === '[object Object]') {
                srcObj = opts;
            }else if (Object.prototype.toString.call(opts) === '[object Array]') {
                srcObj = opts[0];
            }else{
                srcObj = opts;
            }
            this.setReal(srcObj);
        }
    }
}