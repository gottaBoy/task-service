import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { UIService } from "./ui-service";

/**
 * UI服务管理类
 *
 * @export
 * @class UIServiceHelp
 */
export class UIServiceHelp {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {UIServiceHelp}
     * @memberof UIServiceHelp
     */
    private static UIServiceHelp: UIServiceHelp;

    /**
     * 服务缓存
     *
     * @private
     * @type {Map<string, any>}
     * @memberof UIServiceHelp
     */
    private serviceCache: Map<string, any> = new Map();

    /**
     * 获取 UIServiceHelp 单例对象
     *
     * @static
     * @returns {UIServiceHelp}
     * @memberof UIServiceHelp
     */
    public static getInstance(): UIServiceHelp {
        if (!UIServiceHelp.UIServiceHelp) {
            UIServiceHelp.UIServiceHelp = new UIServiceHelp();
        }
        return this.UIServiceHelp;
    }

    /**
     * Creates an instance of UIServiceHelp.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof UIServiceHelp
     */
    private constructor() { }

    /**
     * 获取UI服务实例
     *
     * @private
     * @param {string} tag 应用实体标识
     * @param {*} context 应用上下文
     * @param {*} [args] 额外参数
     * @memberof UIServiceHelp
     */
    private async getServiceInstance(appDataEntity: IPSAppDataEntity, runTimeData: IRunTimeData = {}) {
        const uiEntityService = new UIService(appDataEntity, runTimeData);
        await uiEntityService.loaded();
        return uiEntityService;
    }

    /**
     * 获取服务
     *
     * @param {(IPSAppDataEntity | null)} appDataEntity
     * @param {IRunTimeData} [runTimeData={}]
     * @return {*} 
     * @memberof UIServiceHelp
     */
    public async getService(appDataEntity: IPSAppDataEntity | null, runTimeData: IRunTimeData = {}) {
        if (!appDataEntity) {
            if (this.serviceCache.has('APP')) {
                return this.serviceCache.get('APP');
            } else {
                const uiServiceBase = new UIService(appDataEntity, runTimeData);
                this.serviceCache.set('APP', uiServiceBase);
                return uiServiceBase;
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
                const uiEntityService = await this.getServiceInstance(appDataEntity, runTimeData);
                this.serviceCache.set(cacheKey, uiEntityService);
                return uiEntityService;
            }
        }

    }

}