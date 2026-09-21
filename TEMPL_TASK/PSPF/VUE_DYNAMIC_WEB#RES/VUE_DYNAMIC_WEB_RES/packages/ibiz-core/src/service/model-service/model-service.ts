import { GlobalHelp, PSModelServiceImpl } from '@ibiz/dynamic-model-api';
import { SandboxService } from './sandbox/sandbox-service';

/**
 * 模型服务
 *
 * @export
 * @class AppModelService
 * @extends {PSModelServiceImpl}
 */
export class AppModelService extends PSModelServiceImpl { }

/**
 * 获取模型服务
 *
 */
 export const GetModelService: Function = function(param: any):Promise<any>{
    if(param && param.srfsandboxtag){
        return SandboxService.getInstance().getSandBoxInstance(param.srfsandboxtag).getModelService(param);
    }else{
        return Promise.resolve(GlobalHelp.getModelService());
    }
}