import { IPSAppDEAction } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil } from "../../../utils";
import { AppMethod } from "./app-method";

/**
 * 应用实体脚本方法
 *
 * @export
 * @class AppScriptMethod
 * @extends {AppMethod}
 */
export class AppScriptMethod extends AppMethod {

    /**
     * 执行方法
     * @param context 
     * @param data
     * @memberof AppScriptMethod
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        LogUtil.log(`执行实体脚本方法，[方法名称]：${this.codeName}`);
        try {
            eval((this.appDEMethod as IPSAppDEAction).scriptCode);
            return new HttpResponse(data, {
                ok: true,
                status: 200
            });
        } catch (error: any) {
            return new HttpResponse({ message: error.message }, {
                ok: false,
                status: 500
            });
        }
    }

}