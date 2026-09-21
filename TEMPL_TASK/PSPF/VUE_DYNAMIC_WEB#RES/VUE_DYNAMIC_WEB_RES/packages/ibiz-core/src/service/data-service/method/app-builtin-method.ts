import { IContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil } from "../../../utils";
import { AppMethod } from "./app-method";

/**
 *  内置方法
 *
 * @export
 * @class AppBuiltInMethod
 * @extends {AppMethod}
 */
export class AppBuiltInMethod extends AppMethod {

    /**
     * 执行方法
     * @param args
     * @memberof AppBuiltInMethod
     */
    public async execute(...args: any[]): Promise<HttpResponse> {
        LogUtil.log(`执行实体内置方法，[方法名称]：${this.codeName}`);
        try {
            if (this.dataService[this.appDEMethod.codeName] && this.dataService[this.appDEMethod.codeName] instanceof Function) {
                return this.dataService[this.appDEMethod.codeName](...args);
            } else {
                return new HttpResponse({ message: `执行${this.appDEMethod.codeName}方法异常，[未找到${this.appDEMethod.codeName}方法]` }, {
                    ok: false,
                    status: 500
                });
            }
        } catch (error: any) {
            return new HttpResponse({ message: error.message }, {
                ok: false,
                status: 500
            });
        }
    }

}