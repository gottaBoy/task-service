import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { HttpResponse, LogUtil } from "../../utils";
import { DataBaseService } from "./data-service-base";
/**
 * @description 数据实体服务
 * @export
 * @class DataEntityService
 */
export class DataEntityService extends DataBaseService<any>{

    /**
     * Creates an instance of DataEntityService.
     * @param {IPSAppDataEntity} appDataEntity
     * @param {*} runTimeData
     * @memberof DataEntityService
     */
    public constructor(appDataEntity: IPSAppDataEntity | null = null, runTimeData: IRunTimeData = {}) {
        super(appDataEntity, runTimeData);
    }

    /**
     * 执行实体方法
     *
     * @param {string} methodName
     * @param {IContext} context
     * @param {IParams} data
     * @return {*} 
     * @memberof DataEntityService
     */
    public async execute(methodName: string, ...args: any[]) {
        const appDEDynaMethod = this.appDEDynaMethodMap.get(methodName.toLowerCase());
        if (appDEDynaMethod) {
            return await appDEDynaMethod.execute(...args);
        } else {
            const service: any = this;
            if (service[methodName] && service[methodName] instanceof Function) {
                LogUtil.log(`执行实体预置方法，[方法名称]：${methodName}`);
                return service[methodName](...args);
            } else {
                return new HttpResponse({ message: `${this.appDataEntity.codeName}实体中不存在${methodName}方法` }, {
                    ok: false,
                    status: 500
                });
            }
        }
    }

}