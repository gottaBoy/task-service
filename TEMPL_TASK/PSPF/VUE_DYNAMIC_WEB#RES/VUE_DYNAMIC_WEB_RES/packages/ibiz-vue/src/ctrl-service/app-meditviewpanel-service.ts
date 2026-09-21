import { IPSDEMultiEditViewPanel } from '@ibiz/dynamic-model-api';
import { ControlServiceBase, DataServiceHelp } from 'ibiz-core';
import { AppMEditviewPanelModel } from 'ibiz-vue';


/**
 * Main 部件服务对象
 *
 * @export
 * @class AppmultieditviewpanelService
 */
export class AppMEditViewPanelService extends ControlServiceBase {

    /**
    * 多编辑视图实例对象
    *
    * @memberof AppMEditViewPanelService
    */
    public declare controlInstance: IPSDEMultiEditViewPanel;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppMEditViewPanelService
     */
    public appEntityService!: any;

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppMEditViewPanelService
     */
    public async initServiceParam(opts: any) {
        this.controlInstance = opts;
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        this.model = new AppMEditviewPanelModel(opts);
    }

    /**
     * Creates an instance of AppMEditViewPanelService
     * 
     * @param {*} [opts={}]
     * @memberof AppMEditViewPanelService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.initServiceParam(opts);
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppMEditViewPanelService
     */
    public get(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.localSourceTag) {
                result = this.getLocalDataSource();
            } else {
                if (this.appEntityService && action) {
                    result = this.appEntityService.execute(action, Context, Data);
                } else {
                    result = this.appEntityService.execute('Get', Context, Data);
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
     * @memberof AppMEditViewPanelService
     */
    public delete(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Remove', Context, Data);
            }
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 加载草稿
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppMEditViewPanelService
     */
    public loadDraft(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('GetDraft', Context, Data);
            }
            result.then((response) => {
                //处理返回数据，补充判断标识
                if (response.data) {
                    Object.assign(response.data, { srfuf: '0' });
                }
                this.handleResponse(action, response, true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }
}