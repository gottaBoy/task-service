import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { AuthService } from "./auth-service";

/**
 * 权限服务管理类
 *
 * @export
 * @class AuthServiceHelp
 */
export class AuthServiceHelp {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AuthServiceHelp}
     * @memberof AuthServiceHelp
     */
    private static AuthServiceHelp: AuthServiceHelp;

    /**
     * 服务缓存
     *
     * @private
     * @type {Map<string, any>}
     * @memberof AuthServiceHelp
     */
    private serviceCache: Map<string, any> = new Map();

    /**
     * 获取 AuthServiceHelp 单例对象
     *
     * @static
     * @returns {AuthServiceHelp}
     * @memberof AuthServiceHelp
     */
    public static getInstance(): AuthServiceHelp {
        if (!AuthServiceHelp.AuthServiceHelp) {
            AuthServiceHelp.AuthServiceHelp = new AuthServiceHelp();
        }
        return this.AuthServiceHelp;
    }

    /**
     * Creates an instance of AuthServiceHelp.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof AuthServiceHelp
     */
    private constructor() { }

    /**
     * 获取UI服务实例
     *
     * @private
     * @param {string} tag 应用实体标识
     * @param {*} context 应用上下文
     * @param {*} [args] 额外参数
     * @memberof AuthServiceHelp
     */
    private async getServiceInstance(appDataEntity: IPSAppDataEntity, runTimeData: IRunTimeData = {}) {
        const authEntityService = new AuthService(appDataEntity, runTimeData);
        await authEntityService.loaded();
        return authEntityService;
    }

    /**
     * 获取服务
     *
     * @param {(IPSAppDataEntity | null)} appDataEntity
     * @param {IRunTimeData} [runTimeData={}]
     * @return {*} 
     * @memberof AuthServiceHelp
     */
    public async getService(appDataEntity: IPSAppDataEntity | null, runTimeData: IRunTimeData = {}) {
        if (!appDataEntity) {
            if (this.serviceCache.has('APP')) {
                return this.serviceCache.get('APP');
            } else {
                const authServiceBase = new AuthService(appDataEntity, runTimeData);
                this.serviceCache.set('APP', authServiceBase);
                return authServiceBase;
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
                const authEntityService = await this.getServiceInstance(appDataEntity, runTimeData);
                this.serviceCache.set(cacheKey, authEntityService);
                return authEntityService;
            }
        }

    }

}