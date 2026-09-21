import { Util, ModelTool, MobTabExpViewInterface } from "ibiz-core";
import { CounterService } from "ibiz-core";
import { MainViewBase } from "./main-view-base";
import { IPSAppDETabExplorerView, IPSTabExpPanel } from '@ibiz/dynamic-model-api';

/**
 * 分页导航视图基类
 *
 * @export
 * @class MobTabExpViewBase
 * @extends {MainViewBase}
 */
export class MobTabExpViewBase extends MainViewBase implements MobTabExpViewInterface {


    /**
     * 视图实例
     * 
     * @memberof MobTabExpViewBase
     */
    public declare viewInstance: IPSAppDETabExplorerView;

    /**
     * 导航栏实例
     *
     * @public
     * @type {IBizMobTabExpPanelModel}
     * @memberof MobTabExpViewBase
     */
    public tabExpPanelInstance!: IPSTabExpPanel;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof MobTabExpViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.tabExpPanelInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            }, opts)
            this.engine.init(engineOpts);
        }
    }


    /**
     * 初始化编辑视图实例
     * 
     * @memberof MobTabExpViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDETabExplorerView;
        this.tabExpPanelInstance = ModelTool.findPSControlByName('tabexppanel', this.viewInstance.getPSControls()) as IPSTabExpPanel;
        await super.viewModelInit();
    }

    /**
     * 渲染内容区
     * 
     * @memberof ViewBase
     */
    public renderContent() {
        const id = this.viewInstance.codeName;
        return <ion-content ref="ionScroll" id={id} slot="content" scroll-y={'false'}>
            {this.renderBodyMessage()}
            {this.renderMainContent()}
        </ion-content>
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobTabExpViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.tabExpPanelInstance);
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.tabExpPanelInstance.name, on: targetCtrlEvent });
    }


    /**
     * 初始化计数器服务
     * 
     * @memberof MobTabExpViewBase
     */
    public async initCounterService(param: any) {
        const appCounterRef = this.tabExpPanelInstance.getPSAppCounterRefs();
        if (appCounterRef && appCounterRef.length > 0) {
            for (const counterRef of appCounterRef) {
                const counter = counterRef.getPSAppCounter?.();
                if (counter) {
                    await counter.fill(true);
                    const counterService: any = new CounterService();
                    await counterService.loaded(counter, { context: this.context, viewparams: this.viewparams });
                    const tempData: any = { id: counterRef.id, path: counter.modelPath, service: counterService };
                    this.counterServiceArray.push(tempData);
                }
            }
        }
    }
}
