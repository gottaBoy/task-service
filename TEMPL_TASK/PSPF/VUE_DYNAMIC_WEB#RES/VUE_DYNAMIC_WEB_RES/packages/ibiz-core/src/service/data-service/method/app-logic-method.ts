import { IPSAppDEAction, IPSAppDELogic } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil } from "../../../utils";
import { AppDeLogicService } from "../logic";
import { AppMethod } from "./app-method";

/**
 * 实体处理逻辑方法
 *
 * @export
 * @class AppLogicMethod
 * @extends {AppMethod}
 */
export class AppLogicMethod extends AppMethod {

    /**
     * 实体处理逻辑服务类
     *
     * @protected
     * @type {AppDeLogicService}
     * @memberof AppLogicMethod
     */
    protected appDeLogicService: AppDeLogicService = AppDeLogicService.getInstance();

    /**
     * 执行方法
     * @param context 
     * @param data
     * @memberof AppLogicMethod
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        LogUtil.log(`执行实体处理逻辑方法，[方法名称]：${this.codeName}`);
        try {
            const result = await this.executeAppDELogic(context, data);
            return new HttpResponse(result, {
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

    /**
     * 执行实体处理逻辑
     *
     * @protected
     * @param {*} context 应用上下文
     * @param {*} data 当前数据
     * @memberof AppLogicMethod
     */
    private async executeAppDELogic(context: any, data: any) {
        try {
            await this.appDEMethod.fill();
            if ((this.appDEMethod as IPSAppDEAction).getPSAppDELogic()) {
                return await this.appDeLogicService.onExecute((this.appDEMethod as IPSAppDEAction).getPSAppDELogic() as IPSAppDELogic, context, data);
            }
        } catch (error: any) {
            throw new Error(`执行实体处理逻辑异常，[逻辑错误]${error.message}`);
        }
    }

}