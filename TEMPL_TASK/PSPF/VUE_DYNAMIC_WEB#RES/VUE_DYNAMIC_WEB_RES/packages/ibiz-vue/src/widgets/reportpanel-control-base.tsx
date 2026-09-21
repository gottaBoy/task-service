import { IPSDEReportPanel } from '@ibiz/dynamic-model-api';
import { Subscription } from 'rxjs';
import { AppReportPanelService } from '../ctrl-service/app-reportpanel-service';
import { MDControlBase } from './md-control-base';

export class ReportPanelControlBase extends MDControlBase {

    /**
     * 报表面板实例
     * 
     * @type {IPSDEReportPanel}
     * @memberof ReportPanelControlBase
     */
    public declare controlInstance: IPSDEReportPanel;

    /**
     * @description 报表部件事件
     * @type {(Subscription | undefined)}
     * @memberof ReportPanelControlBase
     */
    public reportControlEvent: Subscription | undefined;

    /**
     * 初始化报表面板模型
     *
     * @type {*}
     * @memberof ReportPanelControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        if (!(this.Environment && this.Environment.isPreviewMode)) {
            this.service = new AppReportPanelService(this.controlInstance, this.context);
        }
    }

    /**
     * 报表面板部件初始化
     *
     * @memberof ReportPanelControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        if (this.viewState) {
            this.reportControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (action == 'load') {
                    this.load(data);
                }
            })
        }
    }

    public load(data?: any) {
        console.log("报表部件加载数据");
    }

    /**
     * @description 部件销毁
     * @memberof ReportPanelControlBase
     */
    public ctrlDestroyed(){
        super.ctrlDestroyed()
        if(this.reportControlEvent){
            this.reportControlEvent.unsubscribe();
        }
    }
}