import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { DataEntityService } from "./data-entity-service";

/**
 * 实体服务管理类
 *
 * @export
 * @class DataServiceHelp
 */
export class DataServiceHelp {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {DataServiceHelp}
     * @memberof DataServiceHelp
     */
    private static DataServiceHelp: DataServiceHelp;

    /**
     * 服务缓存
     *
     * @private
     * @type {Map<string, any>}
     * @memberof DataServiceHelp
     */
    private serviceCache: Map<string, any> = new Map();

    /**
     * 获取 DataServiceHelp 单例对象
     *
     * @static
     * @returns {DataServiceHelp}
     * @memberof DataServiceHelp
     */
    public static getInstance(): DataServiceHelp {
        if (!DataServiceHelp.DataServiceHelp) {
            DataServiceHelp.DataServiceHelp = new DataServiceHelp();
        }
        return this.DataServiceHelp;
    }

    /**
     * Creates an instance of DataServiceHelp.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof DataServiceHelp
     */
    private constructor() { }

    /**
     * 获取数据服务实例
     *
     * @private
     * @param {string} tag 应用实体标识
     * @param {*} context 应用上下文
     * @param {*} [args] 额外参数
     * @memberof DataServiceHelp
     */
    private async getServiceInstance(appDataEntity: IPSAppDataEntity, runTimeData: IRunTimeData) {
        const dataEntityService = new DataEntityService(appDataEntity, runTimeData);
        await dataEntityService.loaded();
        return dataEntityService;
    }

    /**
     * 获取服务
     * @returns 
     */
    public async getService(appDataEntity: IPSAppDataEntity | null, runTimeData: IRunTimeData = {}) {
        if (!appDataEntity) {
            if (this.serviceCache.has('APP')) {
                return this.serviceCache.get('APP');
            } else {
                const entityServiceBase = new DataEntityService(appDataEntity, runTimeData);
                this.serviceCache.set('APP', entityServiceBase);
                return entityServiceBase;
            }
        } else {
            await appDataEntity.fill();
            const { codeName } = appDataEntity;
            let cacheKey: string = codeName;
            if (runTimeData && runTimeData.context && runTimeData.context.srfdynainstid) {
                cacheKey = runTimeData.context.srfdynainstid;
            }
            if (this.serviceCache.has(cacheKey)) {
                return this.serviceCache.get(cacheKey);
            } else {
                const dataEntityService = await this.getServiceInstance(appDataEntity, runTimeData);
                this.serviceCache.set(cacheKey, dataEntityService);
                return dataEntityService;
            }
        }

    }

}