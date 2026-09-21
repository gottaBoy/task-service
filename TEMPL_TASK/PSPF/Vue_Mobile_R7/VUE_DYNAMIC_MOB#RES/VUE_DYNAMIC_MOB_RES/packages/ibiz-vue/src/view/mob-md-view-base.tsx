import { ModelTool } from 'ibiz-core';
import { IPSAppDEMobMDView, IPSDEMobMDCtrl } from '@ibiz/dynamic-model-api';
import { MDViewBase } from "./md-view-base";
import { MobMDViewInterface } from 'ibiz-core';

/**
 * 多数据视图基类
 *
 * @export
 * @class MDViewBase
 * @extends {MainViewBase}
 */
export class MobMDViewBase extends MDViewBase implements MobMDViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobMDViewBase
     */
    public declare viewInstance: IPSAppDEMobMDView;

    /**
     * 列表实例
     * 
     * @memberof MobMDViewBase
     */
    public mdCtrlInstance!: IPSDEMobMDCtrl;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof MobMDViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.mdCtrlInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                mdctrl: (this.$refs[this.mdCtrlInstance?.name] as any).ctrl,
            }, opts)
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if (this.quickSearchFormInstance?.name && this.$refs[this.quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[this.quickSearchFormInstance.name] as any).ctrl);
            }
            if (this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchBar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化多数据视图实例
     * 
     * @memberof MobMDViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.mdCtrlInstance = ModelTool.findPSControlByName('mdctrl', this.viewInstance.getPSControls()) as IPSDEMobMDCtrl;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobMDViewBase
     */
    public renderMainContent() {
        if (!this.mdCtrlInstance) {
            return;
        }
        const id = this.viewInstance.codeName;
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.mdCtrlInstance);
        Object.assign(targetCtrlParam.staticProps, { enablePullDownRefresh: this.viewInstance.enablePullDownRefresh })
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.mdCtrlInstance?.name, on: targetCtrlEvent });
    }

}
