import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { AuthServiceBase } from "./auth-base.service";

/**
 * 实体权限服务
 *
 * @export
 * @class AuthService
 */
export class AuthService extends AuthServiceBase {

    /**
     * Creates an instance of AuthService.
     * @param {(IPSAppDataEntity | null)} [appDataEntity=null]
     * @param {IRunTimeData} [runTimeData={}]
     * @memberof AuthService
     */
    constructor(appDataEntity: IPSAppDataEntity | null = null, runTimeData: IRunTimeData = {}) {
        super(appDataEntity, runTimeData);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} activeKey 实体权限数据缓存标识
     * @param {*} dataaccaction 操作标识
     * @param {*} mainSateOPPrivs 传入数据主状态操作标识集合
     * @returns {any}
     * @memberof AuthService
     */
    public getOPPrivs(activeKey: string, dataaccaction: string, mainSateOPPrivs: any): any {
        let result: any = { [dataaccaction]: 1 };
        const curDefaultOPPrivs: any = this.getSysOPPrivs();
        // 统一资源权限
        if (curDefaultOPPrivs && (Object.keys(curDefaultOPPrivs).length > 0) && (curDefaultOPPrivs[dataaccaction] === 0)) {
            result[dataaccaction] = 0;
        }
        // 主状态权限
        if (mainSateOPPrivs && (Object.keys(mainSateOPPrivs).length > 0) && mainSateOPPrivs.hasOwnProperty(dataaccaction)) {
            result[dataaccaction] = result[dataaccaction] && mainSateOPPrivs[dataaccaction];
        }
        // 实体级权限
        // if (!this.getActivedDeOPPrivs(activeKey, dataaccaction)) {
        //     result[dataaccaction] = 0;
        // }
        return result;
    }


}