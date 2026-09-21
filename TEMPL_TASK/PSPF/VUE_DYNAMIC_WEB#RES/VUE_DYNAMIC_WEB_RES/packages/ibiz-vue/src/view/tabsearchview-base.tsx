import { IPSAppCounterRef, IPSDETabViewPanel, IPSTabExpPanel, IPSSysImage, IPSAppDETabSearchView, IPSSearchBar } from '@ibiz/dynamic-model-api';
import { ModelTool, TabSearchViewInterface, Util } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 实体分页搜索视图基类
 *
 * @export
 * @class TabSearchViewBase
 * @extends {MDViewBase}
 * @implements {TabSearchViewInterface}
 */
export class TabSearchViewBase extends MDViewBase implements TabSearchViewInterface {

    /**
     * 视图实例
     * 
     * @memberof TabSearchViewBase
     */
    public declare viewInstance: IPSAppDETabSearchView;

    /**
     * 分页导航面板实例
     * 
     * @memberof TabSearchViewBase
     */
    public tabExpPanelInstance!: IPSTabExpPanel;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof TabSearchViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.tabExpPanelInstance) {
            const engineOpts = {
                view: this,
                p2k: '0',
                tabexppanel: (this.$refs[this.tabExpPanelInstance?.name] as any)?.ctrl,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                isLoadDefault: this.viewInstance?.loadDefault,
            };
            if (this.searchBarInstance) {
                Object.assign(engineOpts, {
                    searchbar: (this.$refs[this.searchBarInstance?.name] as any)?.ctrl
                });
            }
            if (this.searchFormInstance) {
                Object.assign(engineOpts, {
                    searchform: (this.$refs[this.searchFormInstance?.name] as any)?.ctrl
                });
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof TabSearchViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDETabSearchView;
        await super.viewModelInit();
        this.tabExpPanelInstance = ModelTool.findPSControlByType("TABEXPPANEL", this.viewInstance.getPSControls()) as IPSTabExpPanel;
    }

    /**
     * 分页面板点击
     * 
     * @memberof TabSearchViewBase
     */
    public tabPanelClick(event: any) {
        if (this.engine) {
            this.engine.changeTabPanel(event);
        }
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof TabSearchViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.tabExpPanelInstance);
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.tabExpPanelInstance?.name, on: targetCtrlEvent });
    }

}