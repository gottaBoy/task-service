import { IPSAppDEGanttView, IPSDEGantt } from '@ibiz/dynamic-model-api';
import { MDViewBase } from './mdview-base';
import { ModelTool, GanttViewInterface } from 'ibiz-core';

/**
 * 甘特视图基类
 *
 * @export
 * @class GanttViewBase
 * @extends {MDViewBase}
 * @implements {GanttViewInterface}
 */
export class GanttViewBase extends MDViewBase implements GanttViewInterface {

    /**
     * 甘特视图实例
     * 
     * @memberof GanttViewBase
     */
    public declare viewInstance: IPSAppDEGanttView;

    /**
     * 甘特部件实例
     * 
     * @memberof GanttViewBase
     */
    public ganttInstance!: IPSDEGantt;

    /**
    * 视图默认加载
    * 
    * @memberof GanttViewBase
    */
    public isLoadDefault: boolean = true;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof GanttViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.ganttInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                gantt: (this.$refs[this.ganttInstance.name] as any).ctrl,
            }, opts)
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if (this.quickSearchFormInstance?.name && this.$refs[this.quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[this.quickSearchFormInstance.name] as any).ctrl);
            }
            if (this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化甘特视图实例
     * 
     * @param opts 
     * @memberof GanttViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDEGanttView;
        await super.viewModelInit();
        this.isLoadDefault = this.viewInstance?.loadDefault;
        this.ganttInstance = ModelTool.findPSControlByName('gantt', this.viewInstance.getPSControls()) as IPSDEGantt;
    }

    /**
     *  多数据视图挂载
     *
     * @memberof GanttViewBase
     */
    public containerMounted() {
        super.containerMounted();
    }

    /**
     *  绘制甘特部件
     *
     * @memberof GanttViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.ganttInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.ganttInstance?.name, on: targetCtrlEvent },);
    }

}