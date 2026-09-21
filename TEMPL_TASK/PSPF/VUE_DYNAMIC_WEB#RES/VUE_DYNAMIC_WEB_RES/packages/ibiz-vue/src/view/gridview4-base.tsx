import { IPSDEDRTab } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
import { GridViewBase } from "./gridview-base";

/**
 * 实体表格视图（上下关系）
 *
 * @export
 * @class GridView4Base
 * @extends {GridViewBase}
 */
export class GridView4Base extends GridViewBase {
    
    /**
     * 数据分页栏模型实例对象
     *
     * @type {IPSDEDRTab}
     * @memberof GridView4Base
     */
    public drTabInstance!: IPSDEDRTab;

    /**
     * 关系项
     *
     * @type {*}
     * @memberof GridView4Base
     */
    public drItem: any;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EditView4Base
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.gridInstance) {
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
                grid: (this.$refs[this.gridInstance?.name] as any).ctrl,
                drtab: (this.$refs[this.drTabInstance?.name] as any).ctrl
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
     * 视图模型初始化
     *
     * @memberof GridView4Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.drTabInstance = ModelTool.findPSControlByType("DRTAB", this.viewInstance.getPSControls()) as IPSDEDRTab;
    }


}