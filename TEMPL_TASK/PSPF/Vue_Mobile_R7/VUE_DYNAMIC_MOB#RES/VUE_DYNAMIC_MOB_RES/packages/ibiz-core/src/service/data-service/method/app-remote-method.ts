import { IPSAppDEAction, IPSAppDEField, IPSAppDEMethod, IPSAppDEMethodDTO, IPSAppDEMethodInput, IPSAppDEMethodReturn } from "@ibiz/dynamic-model-api";
import { IContext, IEntityEnvContext } from "../../../interface";
import { Http, HttpResponse, LogUtil, Util } from "../../../utils";
import { EntityPathService } from "../../common-service";
import { MethodDto } from "../dto";
import { AppMethod } from "./app-method";

/**
 * 应用实体远程方法
 *
 * @export
 * @class AppRemoteMethod
 * @extends {AppMethod}
 */
export class AppRemoteMethod extends AppMethod {

    /**
     * http请求服务
     *
     * @private
     * @memberof AppRemoteMethod
     */
    private http: any = Http.getInstance();

    /**
     * 当前应用实体代码名称
     *
     * @private
     * @type {string}
     * @memberof AppRemoteMethod
     */
    private appEntityCodeName: string;

    /**
     * 当前应用实体代码名称复数
     *
     * @private
     * @type {string}
     * @memberof AppRemoteMethod
     */
    private appEntityCodeNames: string;

    /**
     * 请求路径
     *
     * @private
     * @type {string}
     * @memberof AppRemoteMethod
     */
    private requestPath: string;

    /**
     * 请求方式
     *
     * @private
     * @type {string}
     * @memberof AppRemoteMethod
     */
    private requestMethod: string;

    /**
     * 是否需要资源主键
     *
     * @private
     * @type {boolean}
     * @memberof AppRemoteMethod
     */
    private needResourceKey: boolean = false;

    /**
     * 请求参数类型
     *
     * @private
     * @type {string}
     * @memberof AppRemoteMethod
     */
    private requestParamType: string;

    /**
     * 应用实体所有路径
     *
     * @private
     * @type {string[]}
     * @memberof AppRemoteMethod
     */
    private appDERSPaths: string[][] = [];

    /**
     * Creates an instance of AppMethod.
     * @param {IEntityEnvContext} entityEnvContext
     * @param {IPSAppDEMethod} appDEMethod
     * @memberof AppRemoteMethod
     */
    public constructor(entityEnvContext: IEntityEnvContext, appDEMethod: IPSAppDEMethod) {
        super(entityEnvContext, appDEMethod);
        this.appEntityCodeName = this.dataEntity.codeName.toLowerCase();
        this.appEntityCodeNames = Util.srfpluralize(this.dataEntity.codeName).toLowerCase();
        this.requestPath = appDEMethod.requestPath;
        this.requestParamType = appDEMethod.requestParamType;
        this.requestMethod = appDEMethod.requestMethod.toLowerCase();
        this.needResourceKey = appDEMethod.needResourceKey ? true : false;
        this.appDERSPaths = new EntityPathService(this.dataEntity.codeName).getPSAppDERSPaths();
    }

    /**
     * 执行方法
     * @param context 
     * @param data
     * @memberof AppRemoteMethod
     */
    public async execute(context: IContext, data: any): Promise<HttpResponse> {
        LogUtil.log(`执行实体远程方法，[方法名称]：${this.codeName}`);
        try {
            // 存在关系
            if (this.appDERSPaths.length > 0) {
                const requestPath = this.getRemoteRequestPath(context, true);
                if (requestPath) {
                    return this.executeRequest(requestPath, context, data);
                }
            }
            // 为主实体
            if (this.dataEntity.major) {
                const requestPath = this.getRemoteRequestPath(context, false);
                return this.executeRequest(requestPath, context, data);
            }
            return new HttpResponse({ message: `${this.codeName}方法执行发生异常` }, {
                ok: false,
                status: 500
            });
        } catch (error) {
            return this.handleResponseError(error);
        }
    }

    /**
     * 执行请求
     *
     * @private
     * @param {string} requestPath
     * @param {IContext} context
     * @param {*} data
     * @return {*}  {Promise<HttpResponse>}
     * @memberof AppRemoteMethod
     */
    private async executeRequest(requestPath: string, context: IContext, data: any): Promise<HttpResponse> {
        // 方法类型为SELECT
        if (this.methodType === 'SELECT') {
            if (this.requestMethod === 'put' || this.requestMethod === 'post') {
                data = await this.handleInputParam(context, data);
                let res = await this.http[this.requestMethod](requestPath, data);
                res = await this.handleOutputParam(context, res);
                return res;
            } else {
                let res = await this.http[this.requestMethod](requestPath);
                res = await this.handleOutputParam(context, res);
                return res;
            }
        }
        // 方法类型为FETCH
        else if (this.methodType === 'FETCH') {
            let res = await this.http[this.requestMethod](requestPath, data);
            res = await this.handleOutputParam(context, res);
            res = await this.handleAfterFetch(context, res);
            return res;
        }
        // 方法类型为FETCHTEMP
        else if (this.methodType === 'FETCHTEMP') {
            let res = await this.http[this.requestMethod](requestPath, data);
            res = await this.handleOutputParam(context, res);
            return res;
        }
        // 方法类型为DEACTION
        else {
            // 无参数情况
            if (this.requestParamType === 'NONE') {
                if (this.codeName !== 'GetDraft') {
                    let res = await this.http[this.requestMethod](requestPath);
                    res = await this.handleOutputParam(context, res);
                    return res;
                } else {
                    data[this.dataEntity.codeName.toLowerCase()] = undefined;
                    if (this.dataEntity.getKeyPSAppDEField()) {
                        data[(this.dataEntity.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase()] = undefined;
                    }
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                }
            }
            // 指定属性
            else if (this.requestParamType === 'FIELD') {
                if (this.requestMethod == 'get') {
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    res = await this.handleAfterAction(context, res);
                    return res;
                } else if (this.requestMethod == 'post') {
                    data = await this.handleInputParam(context, data);
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                } else if (this.requestMethod == 'delete') {
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                } else {
                    let res = await this.http[this.requestMethod](requestPath);
                    res = await this.handleOutputParam(context, res);
                    return res;
                }
            }
            // 数据对象
            else if (this.requestParamType === 'ENTITY') {
                if (this.codeName === 'Update') {
                    data = await this.handleBeforeAction(context, data);
                    data = await this.handleInputParam(context, data);
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                } else if (this.codeName === 'Create') {
                    data = await this.handleBeforeAction(context, data);
                    if (!data.srffrontuf || data.srffrontuf != 1) {
                        if (this.dataEntity.getKeyPSAppDEField()) {
                            data[(this.dataEntity.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase()] = null;
                        }
                    }
                    if (data.srffrontuf != null) {
                        delete data.srffrontuf;
                    }
                    data = await this.handleInputParam(context, data);
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                } else {
                    data = await this.handleInputParam(context, data);
                    let res = await this.http[this.requestMethod](requestPath, data);
                    res = await this.handleOutputParam(context, res);
                    return res;
                }
            } else {
                throw new Error('请求参数类型错误');
            }
        }
    }

    /**
     * 获取带关系的请求基础路径
     *
     * @private
     * @param {IContext} context
     * @param {boolean} isRelated
     * @return {*}  {string}
     * @memberof AppRemoteMethod
     */
    private getRelatedRequestPath(context: IContext, isRelated: boolean): string {
        let targetPath: string = '';
        if (this.appDERSPaths && this.appDERSPaths.length > 0 && isRelated) {
            for (let i = 0; i < this.appDERSPaths.length; i++) {
                targetPath = '';
                const appDERSPath = this.appDERSPaths[i];
                if (appDERSPath.length > 0) {
                    for (let j = 0; j < appDERSPath.length; j++) {
                        const appDERSPathItem = appDERSPath[j];
                        if (context[appDERSPathItem.toLowerCase()]) {
                            targetPath += `${Util.srfpluralize(appDERSPathItem)}/${encodeURIComponent(context[appDERSPathItem.toLowerCase()])}/`;
                            if (j === appDERSPath.length - 1) {
                                return targetPath;
                            }
                        } else {
                            targetPath = '';
                            break;
                        }
                    }
                }
            }
        }
        return targetPath;
    }

    /**
     * 获取请求路径
     *
     * @private
     * @return {*}  {string}
     * @memberof AppRemoteMethod
     */
    private getRemoteRequestPath(context: IContext, isRelated: boolean): string {
        let targetPath: string = '';
        if (isRelated) {
            targetPath = this.getRelatedRequestPath(context, isRelated);
            if (targetPath) {
                targetPath = `/${targetPath}${this.appEntityCodeNames}`;
                if (this.needResourceKey) {
                    targetPath += `/${encodeURIComponent(context[this.appEntityCodeName])}`;
                }
                if (this.requestPath) {
                    targetPath += `${this.requestPath}`;
                }
            }
        } else {
            targetPath = `/${this.appEntityCodeNames}`;
            if (this.needResourceKey) {
                targetPath += `/${encodeURIComponent(context[this.appEntityCodeName])}`;
            }
            if (this.requestPath) {
                targetPath += `${this.requestPath}`;
            }
        }
        return targetPath;
    }

    /**
     * 处理输入参数
     *
     * @private
     * @param {IContext} context
     * @param {*} data
     * @memberof AppRemoteMethod
     */
    private async handleInputParam(context: IContext, data: any) {
        if (this.appDEMethod.getPSAppDEMethodInput()) {
            const appDEMethodInput: IPSAppDEMethodDTO | null = (this.appDEMethod.getPSAppDEMethodInput() as IPSAppDEMethodInput).getPSAppDEMethodDTO();
            if (appDEMethodInput && appDEMethodInput.type === 'DEFAULT') {
                const inputMethodDto: MethodDto = this.dataService.methodDtoMap.get(appDEMethodInput.codeName);
                if ((this.appDEMethod as IPSAppDEAction).enableBatchAction) {
                    data = await inputMethodDto.ToDtoArray(context, data);
                } else {
                    data = await inputMethodDto.get(context, data);
                }
            }
        }
        return data;
    }

    /**
     * 处理输出参数
     *
     * @private
     * @param {IContext} context
     * @param {*} res
     * @memberof AppRemoteMethod
     */
    private async handleOutputParam(context: IContext, res: any) {
        if (this.appDEMethod.getPSAppDEMethodReturn()) {
            const appDEMethodReturn: IPSAppDEMethodDTO | null = (this.appDEMethod.getPSAppDEMethodReturn() as IPSAppDEMethodReturn).getPSAppDEMethodDTO();
            if (appDEMethodReturn && appDEMethodReturn.type === 'DEFAULT') {
                const outputMethodDto: MethodDto = this.dataService.methodDtoMap.get(appDEMethodReturn.codeName);
                if (this.methodType && this.methodType === 'FETCH') {
                    res.data = await outputMethodDto.ToDataObjArray(context, res.data);
                } else {
                    res.data = await outputMethodDto.set(context, res.data);
                }
            }
        }
        return res;
    }

    /**
     * 处理实体行为前逻辑
     *
     * @private
     * @param {IContext} context
     * @param {*} data
     * @memberof AppRemoteMethod
     */
    private async handleBeforeAction(context: IContext, data: any) {
        data = await this.dataService.beforeExecuteAction(context, data, this.codeName);
        return data;
    }

    /**
     * 处理实体行为后逻辑
     *
     * @private
     * @param {IContext} context
     * @param {*} res
     * @memberof AppRemoteMethod
     */
    private async handleAfterAction(context: IContext, res: any) {
        res.data = await this.dataService.afterExecuteAction(context, res?.data, this.codeName);
        return res;
    }

    /**
     * 处理查询数据后逻辑
     *
     * @private
     * @param {IContext} context
     * @param {*} res
     * @memberof AppRemoteMethod
     */
    private async handleAfterFetch(context: IContext, res: any) {
        res.data = await this.dataService.afterExecuteActionBatch(context, res?.data, this.codeName);
        return res;
    }

    /**
     * 处理响应错误
     *
     * @protected
     * @param {*} error 错误数据
     * @memberof AppRemoteMethod
     */
    private handleResponseError(error: any): Promise<HttpResponse> {
        LogUtil.warn(error);
        return new Promise((resolve: any, reject: any) => {
            if (error.status && error.status !== 200) {
                reject(error);
            } else {
                const errorMessage = error?.message?.indexOf('[逻辑错误]') !== -1 ? error.message : '执行行为异常';
                resolve(
                    new HttpResponse(
                        { message: errorMessage },
                        {
                            ok: false,
                            status: 500,
                        },
                    ),
                );
            }
        });
    }

}