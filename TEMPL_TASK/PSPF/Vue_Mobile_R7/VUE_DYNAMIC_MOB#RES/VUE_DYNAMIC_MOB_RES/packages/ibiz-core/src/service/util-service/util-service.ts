import { IPSAppDynaUtilBase } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { UtilServiceBase } from "./util-base.service";


/**
 * Util服务对象类
 *
 * @export
 * @class UtilService
 */
export class UtilService extends UtilServiceBase {

    /**
     * Creates an instance of UtilService.
     * @param {IPSAppDynaUtilBase} appDynaUtil
     * @param {IRunTimeData} [runTimeData={}]
     * @memberof UtilService
     */
    constructor(appDynaUtil: IPSAppDynaUtilBase | null, runTimeData: IRunTimeData = {}) {
        super(appDynaUtil, runTimeData);
    }

    /**
     * 获取模型数据
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilService
     */
    public loadModelData(context: any = {}, data: any = {}): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            //从接口加载
            if (data && data.utilServiceName && this.stoageDataService) {
                const requestParam: any = { configType: data.utilServiceName, targetType: data.modelid };
                this.stoageDataService.getDynaModel(context, requestParam).then((res: any) => {
                    if (res && res.status === 200) {
                        const data: any = res.data;
                        resolve({ status: 200, data: (data && data.model) ? data.model : [] });
                    }
                }).catch((error: any) => {
                    reject(error);
                })
            } else {
                let dataStr = window.localStorage.getItem(data.modelid);
                if (dataStr) {
                    const data: any = JSON.parse(dataStr);
                    resolve({ status: 200, data: data.model });
                } else {
                    resolve({ status: 200, data: [] });
                }
            }
        });
    }

    /**
     * 保存模型数据
     * 
     * @param context 应用上下文 
     * @param action 操作行为 Update|Create
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilService
     */
    public saveModelData(context: any = {}, data: any = {}): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            // 存储到数据库
            if (data && data.utilServiceName && this.stoageDataService) {
                const requestParam: any = { configType: data.utilServiceName, targetType: data.modelid, model: data.model };
                this.stoageDataService.setDynaModel(context, requestParam).then((res: any) => {
                    if (res && res.status === 200) {
                        resolve({ status: 200, data: data.model });
                    }
                }).catch((error: any) => {
                    reject(error);
                })
            } else {
                window.localStorage.setItem(data.modelid, JSON.stringify(data));
                resolve({ status: 200, data: data.model });
            }
        });
    }

}