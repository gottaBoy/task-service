import { MDViewBase } from "./mdview-base";
import { TreeGridExViewEngine, ModelTool, TreeGridExViewInterface } from 'ibiz-core';
import { IPSAppDETreeGridExView, IPSDETreeGridEx } from '@ibiz/dynamic-model-api';

/**
 * 实体树表格视图基类
 *
 * @export
 * @class TreeGridExView
 * @extends {MDViewBase}
 * @implements {TreeGridExViewInterface}
 */
export class TreeGridExView extends MDViewBase implements TreeGridExViewInterface {

    /**
     * 视图实例
     *
     * @memberof TreeViewBase
     */
    public declare viewInstance: IPSAppDETreeGridExView;

    /**
     * 树表格实例
     * 
     * @memberof TreeGridExView
     */
    public treeGridExInstance!: IPSDETreeGridEx;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof TreeGridExView
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.treeGridExInstance) {
            let engineOpts = Object.assign({
                view: this,
                treegridex: (this.$refs[this.treeGridExInstance.name] as any).ctrl,
                p2k: '0',
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                isLoadDefault: this.viewInstance.loadDefault
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
      * 初始化树表格视图实例
      * 
      * @memberof TreeGridExView
      */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDETreeGridExView;
        await super.viewModelInit();
        this.treeGridExInstance = ModelTool.findPSControlByName('treegridex', this.viewInstance.getPSControls()) as IPSDETreeGridEx;
    }


    /**
     * 渲染视图主体内容区
     * 
     * @memberof TreeGridExView
     */
    public renderMainContent() {
        if (!this.treeGridExInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.treeGridExInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.treeGridExInstance.name, on: targetCtrlEvent },);
    }

    /**
     * 快速搜索
     *
     * @returns {void}
     * @memberof TreeViewBase
     */
    public onSearch(): void {
        this.engine.search({ srfnodefilter: this.queryParams.quickSearchValue });
    }
}