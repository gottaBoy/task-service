import { IPSAppDataEntity, IPSAppDynaUtilBase, IPSApplication, IPSAppUtil } from "@ibiz/dynamic-model-api";
import { IContext, IRunTimeData } from "../../interface";
import { AppServiceBase } from "../app-service/app-base.service";
import { AppBuiltInMethod } from "../data-service";
import { UtilService } from "./util-service";

/**
 * UTIL服务管理类
 *
 * @export
 * @class UtilServiceHelp
 */
export class UtilServiceHelp {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {UtilServiceHelp}
     * @memberof UtilServiceHelp
     */
    private static UtilServiceHelp: UtilServiceHelp;

    /**
     * 服务缓存
     *
     * @private
     * @type {Map<string, any>}
     * @memberof UtilServiceHelp
     */
    private serviceCache: Map<string, any> = new Map();

    /**
     * 获取 UtilServiceHelp 单例对象
     *
     * @static
     * @returns {UtilServiceHelp}
     * @memberof UtilServiceHelp
     */
    public static getInstance(): UtilServiceHelp {
        if (!UtilServiceHelp.UtilServiceHelp) {
            UtilServiceHelp.UtilServiceHelp = new UtilServiceHelp();
        }
        return this.UtilServiceHelp;
    }

    /**
     * Creates an instance of UtilServiceHelp.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof UtilServiceHelp
     */
    private constructor() { }

    /**
     * 获取UI服务实例
     *
     * @private
     * @param {string} tag 应用实体标识
     * @param {*} context 应用上下文
     * @param {*} [args] 额外参数
     * @memberof UtilServiceHelp
     */
    private async getServiceInstance(context: IContext, tag: string) {
        const APP: IPSApplication = AppServiceBase.getInstance().getAppModelDataObject();
        if (APP.getAllPSAppUtils()) {
            const targetUtil = (APP.getAllPSAppUtils() as IPSAppUtil[]).find((item: IPSAppUtil) => {
                return item.codeName === tag;
            })
            if (targetUtil) {
                await targetUtil.fill();
                const utilService = new UtilService(targetUtil as IPSAppDynaUtilBase, { context });
                await utilService.loaded();
                return utilService;
            }
        }
        return new UtilService(null, { context });
    }

    /**
     * 获取服务
     *
     * @param {IContext} context
     * @param {string} tag
     * @return {*} 
     * @memberof UtilServiceHelp
     */
    public async getService(context: IContext, tag: string) {
        if (!tag) {
            throw new Error("应用功能服务实体标识不能为空");
        } else {
            if (this.serviceCache.has(tag)) {
                return this.serviceCache.get(tag);
            } else {
                const utilService = await this.getServiceInstance(context, tag);
                this.serviceCache.set(tag, utilService);
                return utilService;
            }
        }

    }

}