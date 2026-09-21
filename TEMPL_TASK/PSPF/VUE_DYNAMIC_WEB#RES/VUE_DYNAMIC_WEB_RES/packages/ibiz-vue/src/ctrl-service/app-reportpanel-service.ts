import { IPSDEReportPanel } from '@ibiz/dynamic-model-api';
import { ControlServiceBase, DataServiceHelp } from 'ibiz-core';


/**
 * 表格部件服务对象
 *
 * @export
 * @class AppReportPanelService
 */
export class AppReportPanelService extends ControlServiceBase {


    /**
    * 表格实例对象
    *
    * @memberof AppReportPanelService
    */
    public declare controlInstance: IPSDEReportPanel;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppReportPanelService
     */
    public appEntityService!: any;

    /**
     * Creates an instance of AppReportPanelService.
     * 
     * @param {*} [opts={}]
     * @memberof AppReportPanelService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.initServiceParam(opts);
    }

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppReportPanelService
     */
    public async initServiceParam(opts: any) {
        this.controlInstance = opts;
        if (this.appDeCodeName) {
            this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        }
        // this.model = new AppReportPanelModel(opts);
    }


}