import { IPSAppDataEntity, IPSAppDEMethod } from "@ibiz/dynamic-model-api";
import { HttpResponse, IContext, IParams } from "ibiz-core";
import { IEntityEnvContext } from "../../../interface/entity/i-entity-env-context";

/**
 * 应用实体方法基类
 *
 * @export
 * @class AppMethod
 */
export class AppMethod {

    /**
     * 当前环境上下文
     *
     * @protected
     * @type {IEntityEnvContext}
     * @memberof AppMethod
     */
    protected entityEnvContext: IEntityEnvContext;

    /**
     * 应用实体模型
     *
     * @protected
     * @type {IPSAppDataEntity}
     * @memberof AppMethod
     */
    protected dataEntity: IPSAppDataEntity;

    /**
     * 应用方法模型
     *
     * @protected
     * @type {IPSAppDEMethod}
     * @memberof AppMethod
     */
    protected appDEMethod: IPSAppDEMethod;

    /**
     * 数据服务对象
     *
     * @protected
     * @type {any}
     * @memberof AppMethod
     */
    protected dataService: any;

    /**
     * 方法类型
     *
     * @protected
     * @type {string}
     * @memberof AppMethod
     */
    protected methodType: string;

    /**
     * 方法代码名称
     *
     * @protected
     * @type {string}
     * @memberof AppMethod
     */
    protected codeName: string;

    /**
     * Creates an instance of AppMethod.
     * @param {IEntityEnvContext} entityEnvContext
     * @param {IPSAppDEMethod} appDEMethod
     * @memberof AppMethod
     */
    public constructor(entityEnvContext: IEntityEnvContext, appDEMethod: IPSAppDEMethod) {
        const { dataEntity, dataService } = entityEnvContext;
        this.entityEnvContext = entityEnvContext;
        this.dataEntity = dataEntity;
        this.dataService = dataService;
        this.appDEMethod = appDEMethod;
        this.methodType = appDEMethod.methodType;
        this.codeName = appDEMethod.codeName;
    }

    /**
     * 执行方法
     * @param context 
     * @param data 
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        throw new Error("Method not implemented.");
    }
}