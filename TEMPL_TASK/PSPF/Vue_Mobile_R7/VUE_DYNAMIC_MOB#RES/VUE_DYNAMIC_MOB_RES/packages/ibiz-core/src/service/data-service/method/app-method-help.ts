import { IPSAppDEAction, IPSAppDEMethod } from "@ibiz/dynamic-model-api";
import { IEntityEnvContext } from "../../../interface";
import { AppBuiltInMethod } from "./app-builtin-method";
import { AppLocalMethod } from "./app-local-method";
import { AppLogicMethod } from "./app-logic-method";
import { AppPluginMethod } from "./app-plugin-method";
import { AppRemoteMethod } from "./app-remote-method";
import { AppScriptMethod } from "./app-script-method";
import { AppCodeListMethod } from "./app-codelist-method";
export class AppMethodHelp {

    /**
     * 获取应用方法对象
     *
     * @public
     * @static
     * @memberof AppMethodHelp
     */
    public static async getInstance(entityEnvContext: IEntityEnvContext, appDEMethod: IPSAppDEMethod) {
        // 非内置方法
        if(!appDEMethod.builtinMethod){
            // 插件方法
            if(appDEMethod.getPSSysPFPlugin()){
                return new AppPluginMethod(entityEnvContext, appDEMethod);
            }else{
                const { dataEntity } = entityEnvContext;
                // 实体处理逻辑方法
                if((appDEMethod as IPSAppDEAction).getPSAppDELogic() && (appDEMethod as IPSAppDEAction).getPSAppDELogic()?.enableFront){
                    return new AppLogicMethod(entityEnvContext, appDEMethod);
                }
                // 脚本执行方法 todo 需判断前台是否开启
                if((appDEMethod as IPSAppDEAction).customCode){
                    return new AppScriptMethod(entityEnvContext, appDEMethod);
                }
                // 预置集合为代码表类型
                if ((appDEMethod as any).dataSetType == 'CODELIST') {
                    return new AppCodeListMethod(entityEnvContext, appDEMethod);
                }
                // 当前应用实体本地存储模式为仅本地存储和DTO成员（无存储）【临时模式】
                if(dataEntity.storageMode === 1 || dataEntity.storageMode === 4){
                    return new AppLocalMethod(entityEnvContext, appDEMethod);
                }else{
                    // 方法名不为Save和CheckKey
                    if(appDEMethod.codeName !== 'Save' && appDEMethod.codeName !== 'CheckKey'){
                        // 远端方法
                        if(appDEMethod.requestMethod){
                            return new AppRemoteMethod(entityEnvContext, appDEMethod);
                        }
                    }
                }
            }
        }else{
            // 内置方法
            return new AppBuiltInMethod(entityEnvContext, appDEMethod);
        }
    }
}