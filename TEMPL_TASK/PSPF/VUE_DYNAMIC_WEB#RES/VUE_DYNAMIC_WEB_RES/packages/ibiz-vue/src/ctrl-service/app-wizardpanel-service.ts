import { IPSDEWizardPanel } from '@ibiz/dynamic-model-api';
import { ControlServiceBase, DataServiceHelp } from 'ibiz-core';
import { AppWizardPanelModel } from '../ctrl-model';

export class AppWizardPanelService extends ControlServiceBase {

    /**
    * 表格实例对象
    *
    * @memberof AppGridService
    */
    public declare controlInstance: IPSDEWizardPanel;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppGridService
     */
    public appEntityService!: any;

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppGridService
     */
    public async initServiceParam() {
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        this.model = new AppWizardPanelModel(this.controlInstance);
    }

    /**
     * Creates an instance of AppGridService.
     * 
     * @param {*} [opts={}]
     * @memberof AppGridService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.controlInstance = opts;
    }

    public async loaded() {
        await this.initServiceParam()
    }

    /**
     * 初始化向导
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ${srfclassname('${ctrl.codeName}')}Service
     */
    public init(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
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
     * 向导结束
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ${srfclassname('${ctrl.codeName}')}Service
     */
    public finish(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            // 忽略版本检查
            Object.assign(Data, { ignoreversioncheck: 1 });
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