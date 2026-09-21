import { IPSDEChart } from '@ibiz/dynamic-model-api';
import { ControlServiceBase, DataServiceHelp } from 'ibiz-core';
import { AppChartModel } from 'ibiz-vue';


/**
 * 图表部件服务对象
 *
 * @export
 * @class AppChartService
 */
export class AppChartService extends ControlServiceBase {

    /**
    * 图表实例对象
    *
    * @memberof AppChartService
    */
    public declare controlInstance: IPSDEChart;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppChartService
     */
    public appEntityService!: any;

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppChartService
     */
    public async initServiceParam(opts: any) {
        this.controlInstance = opts;
        if (this.appDeCodeName) {
            this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        }
        this.model = new AppChartModel(opts);
    }

    /**
     * 加载服务参数
     *
     * @type {boolean}
     * @memberof AppChartService
     */
    public async loaded(opt: any) {
        await this.initServiceParam(opt);
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppChartService
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
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }
}