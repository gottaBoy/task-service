import { AppServiceBase } from "../app-service/app-base.service";
import { IPSAppDEField, IPSAppDynaUtilBase } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { DataServiceHelp } from "../data-service";

/**
 * 功能服务基类
 *
 * @export
 * @class UtilServiceBase
 */
export class UtilServiceBase {

    /**
     * 应用功能模型
     *
     * @protected
     * @type {IPSAppDynaUtilBase}
     * @memberof UtilServiceBase
     */
    protected appDynaUtil!: IPSAppDynaUtilBase;

    /**
     * 存储数据服务
     * 
     * @memberof  DyncDashboardUtilServiceBase
     */
    protected stoageDataService: any;

    /**
     * 应用存储对象
     *
     * @memberof UtilServiceBase
     */
    protected $store: any;

    /**
     * 模型标识属性
     * 
     * @memberof  UtilServiceBase
     */
    protected modelIdField: string = "";

    /**
     * 模型存储属性
     * 
     * @memberof  UtilServiceBase
     */
    protected modelField: string = "";

    /**
     * 应用标识属性
     * 
     * @memberof  UtilServiceBase
     */
    protected appIdField: string = "";

    /**
     * 用户标识属性
     * 
     * @memberof  UtilServiceBase
     */
    protected userIdField: string = "";

    /**
     * 存储实体Name
     * 
     * @memberof  UtilServiceBase
     */
    protected stoageEntityName: string = "";

    /**
     * 存储实体Id
     * 
     * @memberof  UtilServiceBase
     */
    protected stoageEntityKey: string = "";

    /**
     * Creates an instance of UtilServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof UtilServiceBase
     */
    constructor(appDynaUtil: IPSAppDynaUtilBase | null, runTimeData: IRunTimeData = {}) {
        if (appDynaUtil) {
            this.appDynaUtil = appDynaUtil;
        }
        this.$store = AppServiceBase.getInstance().getAppStore();
    }

    /**
     * 获取应用存储对象
     *
     * @returns {(any | null)}
     * @memberof UtilServiceBase
     */
    public getStore() {
        return this.$store;
    }

    /**
     * UTIL服务初始化（异步）
     *
     * @memberof UtilServiceBase
     */
    public async loaded() {
        if (this.appDynaUtil) {
            if (this.appDynaUtil.getModelIdPSAppDEField()) {
                this.modelIdField = (this.appDynaUtil.getModelIdPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            if (this.appDynaUtil.getModelPSAppDEField()) {
                this.modelField = (this.appDynaUtil.getModelPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            if (this.appDynaUtil.getAppIdPSAppDEField()) {
                this.appIdField = (this.appDynaUtil.getAppIdPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            if (this.appDynaUtil.getUserIdPSAppDEField()) {
                this.userIdField = (this.appDynaUtil.getUserIdPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            const stoageDataEntity = this.appDynaUtil.getStoagePSAppDataEntity();
            if (stoageDataEntity) {
                await stoageDataEntity.fill();
                this.stoageEntityName = stoageDataEntity.codeName.toLowerCase();
                if (stoageDataEntity.getKeyPSAppDEField()) {
                    this.stoageEntityKey = (stoageDataEntity.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
                }
                this.stoageDataService = await DataServiceHelp.getInstance().getService(stoageDataEntity);
            }
        }
    }

    /**
     * 获取模型数据
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilServiceBase
     */
    public loadModelData(context: any = {}, data: any = {}): Promise<any> {
        return Promise.resolve(null);
    }

    /**
     * 保存模型数据
     * 
     * @param context 应用上下文 
     * @param data 传入模型数据
     * @param isloading 是否加载
     * @memberof  UtilServiceBase
     */
    public saveModelData(context: any = {}, data: any = {}): Promise<any> {
        return Promise.resolve(null);
    }


}