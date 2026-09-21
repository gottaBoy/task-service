import { IPSAppDataEntity, IPSAppDEField, IPSAppDEListView, IPSDEList } from '@ibiz/dynamic-model-api';
import { ModelTool, ListViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 列表视图基类
 *
 * @export
 * @class ListViewBase
 * @extends {MDViewBase}
 * @implements {ListViewInterface}
 */
export class ListViewBase extends MDViewBase implements ListViewInterface {

    /**
     * 视图实例
     * 
     * @memberof ListViewBase
     */
    public declare viewInstance: IPSAppDEListView;

    /**
     * 列表实例
     * 
     * @memberof ListViewBase
     */
    public listInstance!: IPSDEList;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof ListViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.listInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: (this.viewInstance as IPSAppDEListView)?.loadDefault,
                keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
                majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                list: (this.$refs[this.listInstance.name] as any).ctrl,
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
     * 初始化列表视图实例
     * 
     * @memberof ListViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDEListView;
        await super.viewModelInit();
        this.listInstance = ModelTool.findPSControlByName('list', this.viewInstance.getPSControls()) as IPSDEList;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof ListViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.listInstance);
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.listInstance?.name, on: targetCtrlEvent });
    }
}
