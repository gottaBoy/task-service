import { ControlServiceBase } from 'ibiz-core';
import { DataServiceHelp } from 'ibiz-core';
import { AppMobListModel, Errorlog } from 'ibiz-vue';
import { IPSDEList, IPSDEMobMDCtrl } from '@ibiz/dynamic-model-api';

/**
 * Main 部件服务对象
 *
 * @export
 * @class AppListService
 */
export class AppMobMDCtrlService extends ControlServiceBase {

    /**
    * 表单实例对象
    *
    * @memberof AppListService
    */
    public declare controlInstance: IPSDEMobMDCtrl | IPSDEList;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppListService
     */
    public appEntityService!: any;


    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppListService
     */
    public async initServiceParam(opts: any): Promise<any> {
        this.controlInstance = opts;
        if (this.controlInstance?.getPSAppDataEntity() && !(this.controlInstance?.getPSAppDataEntity()?.isFill)) {
            await this.controlInstance?.getPSAppDataEntity()?.fill();
        }
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        this.model = new AppMobListModel(opts);
    }

    /**
     * Creates an instance of AppListService.
     * 
     * @param {*} [opts={}]
     * @memberof AppListService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
    }

    /**
     * async loaded
     */
    public async loaded(opts: any): Promise<any> {
        await this.initServiceParam(opts);
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppListService
     */
    @Errorlog
    public search(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.localSourceTag) {
                result = this.getLocalDataSource();
            } else {
                if (this.appEntityService && action) {
                    result = this.appEntityService.execute(action, Context, Data);
                } else {
                    result = this.appEntityService.execute('FetchDefault', Context, Data);
                }
            }
            result.then(async (response) => {
                await this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 删除数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppListService
     */
    @Errorlog
    public delete(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Remove', Context, Data);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 添加数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppListService
     */
    @Errorlog
    public add(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Create', Context, Data);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 修改数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppListService
     */
    @Errorlog
    public update(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Update', Context, Data);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }


}