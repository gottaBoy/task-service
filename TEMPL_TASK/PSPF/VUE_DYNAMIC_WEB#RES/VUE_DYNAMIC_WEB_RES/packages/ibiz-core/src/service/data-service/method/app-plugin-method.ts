
import { IContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil } from "../../../utils";
import { PluginService } from "../../common-service";
import { AppMethod } from "./app-method";

/**
 * 应用实体插件方法
 *
 * @export
 * @class AppPluginMethod
 * @extends {AppMethod}
 */
export class AppPluginMethod extends AppMethod {

    /**
     * 执行方法
     * @param context 
     * @param data
     * @memberof AppPluginMethod
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        LogUtil.log(`执行实体插件方法，[方法名称]：${this.codeName}`);
        try {
            const plugin = this.appDEMethod.getPSSysPFPlugin();
            if (plugin) {
                const importPlugin: any = PluginService.getInstance().getPluginInstance('DEMETHOD', plugin.pluginCode);
                if (importPlugin) {
                    const importModule = await importPlugin();
                    const targetPlugin = new importModule.default(this.entityEnvContext, this.appDEMethod);
                    return await targetPlugin.execute(context, data);
                }else{
                    return new HttpResponse({ message: `执行${this.appDEMethod.codeName}方法异常，[应用方法插件${plugin.pluginCode}未找到]` }, {
                        ok: false,
                        status: 500
                    });
                }
            }else{
                return new HttpResponse({ message: `执行${this.appDEMethod.codeName}方法异常，[应用方法插件未找到]` }, {
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