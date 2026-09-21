import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";

export interface IEntityEnvContext {

    /**
     * 应用实体模型
     *
     * @type {IContext}
     * @memberof IRunTimeData
     */
    dataEntity: IPSAppDataEntity;

    /**
     * 数据服务
     *
     * @type {any}
     * @memberof IEntityEnvContext
     */
    dataService: any;
}