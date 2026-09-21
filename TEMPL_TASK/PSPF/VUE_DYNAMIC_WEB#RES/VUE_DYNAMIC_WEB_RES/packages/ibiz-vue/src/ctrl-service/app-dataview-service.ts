import { ControlServiceBase, DataServiceHelp, Util } from 'ibiz-core';
import { IPSDEDataView } from '@ibiz/dynamic-model-api';
import { AppDataViewModel } from 'ibiz-vue';

/**
 * 数据部件服务对象
 *
 * @export
 * @class AppDataViewService
 */

export class AppDataViewService extends ControlServiceBase {

    /**
    * 数据视图实例对象
    *
    * @memberof AppDataViewService
    */
    public declare controlInstance: IPSDEDataView;

    /**
      * 数据服务对象
      *
      * @type {any}
      * @memberof AppDataViewService
      */
    public appEntityService!: any;

    /**
     * 远端数据
     *
     * @type {*}
     * @memberof AppDataViewService
     */
    private remoteCopyData: any = {};

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppDataViewService
     */
    public async initServiceParam() {
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        this.model = new AppDataViewModel(this.controlInstance);
    }

    /**
     * Creates an instance of AppFormService.
     * 
     * @param {*} [opts={}]
     * @memberof AppDataViewService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.controlInstance = opts;
    }

    /**
     * loaded
     *
     * @memberof AppDataViewService
     */
    public async loaded() {
        await this.initServiceParam();
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppDataViewService
     */
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
            result.then((response) => {
                this.handleResponse(action, response);
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
     * @memberof AppDataViewService
     */
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
     * @memberof AppDataViewService
     */
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
     * @memberof AppDataViewService
     */
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