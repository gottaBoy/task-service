import { ControlServiceBase } from 'ibiz-core';
import { IPSDEChart } from '@ibiz/dynamic-model-api';
import { Errorlog } from '../decorators';
import { AppMobChartModel } from '../ctrl-model/app-mob-chart-model';
import { DataServiceHelp } from 'ibiz-core';


/**
 * 图表部件服务对象
 *
 * @export
 * @class AppMobChartService
 */
export class AppMobChartService extends ControlServiceBase {


    /**
    * 图表实例对象
    *
    * @memberof AppMobChartService
    */
    public declare controlInstance: IPSDEChart;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppMobChartService
     */
    public appEntityService!: any;

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppMobChartService
     */
    public async initServiceParam(opts: any) {
        this.controlInstance = opts;
        this.model = new AppMobChartModel(opts);
        if (this.controlInstance?.getPSAppDataEntity() && !(this.controlInstance?.getPSAppDataEntity()?.isFill)) {
            await this.controlInstance?.getPSAppDataEntity()?.fill();
        }
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
    }

    /**
     * Creates an instance of AppMobChartService.
     * 
     * @param {*} [opts={}]
     * @memberof AppMobChartService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
    }

    /**
     * 加载服务参数
     *
     * @type {boolean}
     * @memberof AppMobChartService
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
     * @memberof AppMobChartService
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
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }
}