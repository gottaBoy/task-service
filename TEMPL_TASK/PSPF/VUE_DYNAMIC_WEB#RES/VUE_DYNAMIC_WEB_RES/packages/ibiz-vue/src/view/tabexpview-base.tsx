import { IPSAppDETabExplorerView, IPSTabExpPanel, IPSDEEditForm } from '@ibiz/dynamic-model-api';
import { ModelTool, TabExpViewEngine, TabExpViewInterface, Util } from 'ibiz-core';
import { MainViewBase } from './mainview-base';

/**
 * 分页导航视图基类
 *
 * @export
 * @class TabExpViewBase
 * @extends {MainViewBase}
 * @implements {TabExpViewInterface}
 */
export class TabExpViewBase extends MainViewBase implements TabExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof TabExpviewBase
     */
    public declare viewInstance: IPSAppDETabExplorerView;

    /**
     * 分页导航面板实例
     * 
     * @memberof TabExpviewBase
     */
    public tabExpPanelInstance!: IPSTabExpPanel;

     /**
     * 数据面板表单实例
     * 
     * @memberof TabExpviewBase
     */
    public dataPanelInstance?: IPSDEEditForm;

    /**
     * 视图引擎
     *
     * @public
     * @type {TabExpViewEngine}
     * @memberof TabExpviewBase
     */
    public declare engine: TabExpViewEngine;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof TabExpviewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let viewEngineOpts = ({
            view: this,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance?.loadDefault,
            tabexppanel:(this.$refs[this.tabExpPanelInstance?.name] as any).ctrl 
        });
        this.engine.init(viewEngineOpts);
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof TabExpviewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDETabExplorerView;
        await super.viewModelInit();
        this.tabExpPanelInstance = ModelTool.findPSControlByType("TABEXPPANEL",this.viewInstance.getPSControls()) as IPSTabExpPanel;
        this.dataPanelInstance = ModelTool.findPSControlByName("datapanel",this.viewInstance.getPSControls()) as IPSDEEditForm;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof TabExpviewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.tabExpPanelInstance);
        Object.assign(targetCtrlParam.staticProps, { noPadding: true });
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.tabExpPanelInstance?.name, on: targetCtrlEvent });
    }

}