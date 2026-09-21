import { IPSAppDEPanelView, IPSPanel } from '@ibiz/dynamic-model-api';
import { DePanelViewInterface, LogUtil, ModelTool, PanelViewEngine } from 'ibiz-core';
import { Subscription } from 'rxjs';
import { MainViewBase } from './mainview-base';

/**
 * 实体面板视图基类
 *
 * @export
 * @class DePanelViewBase
 * @extends {MainViewBase}
 * @implements {DePanelViewInterface}
 */
export class DePanelViewBase extends MainViewBase implements DePanelViewInterface {

    /**
     * 实体面板视图实例对象
     * 
     * @memberof DePanelViewBase
     */
    public declare viewInstance: IPSAppDEPanelView;

    /**
     * 面板部件实例对象
     * 
     * @memberof DePanelViewBase
     */
    public panelInstance?: IPSPanel;

    /**
     * 视图引擎
     *
     * @type {PanelViewEngine}
     * @memberof DePanelViewBase
     */
    public declare engine: PanelViewEngine;

    /**
     * 门户视图状态事件
     * 
     * @memberof DePanelViewBase
     */
    public depanelViewEvent: Subscription | undefined;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @memberof DePanelViewBase
     */
    public engineInit(opts: any = {}) {
        if (this.engine && this.panelInstance) {
            const engineOpts: any = {
                view: this,
                p2k: '0',
                isLoadDefault: true,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                panel: (this.$refs[this.panelInstance.name] as any).ctrl
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     *  视图初始化
     *
     * @memberof DePanelViewBase
     */
    public viewInit() {
        super.viewInit();
        if (this.inputState) {
            this.depanelViewEvent = this.inputState.subscribe((res: any) => {
                if (!Object.is(res.tag, this.viewInstance.name)) {
                    return;
                }
                if (Object.is(res.action, 'load')) {
                    this.engine.load(res.data);
                }
            })
        }
    }

    /**
     * @description 视图销毁
     * @memberof DePanelViewBase
     */
    public viewDestroyed(){
        super.viewDestroyed()
        if(this.depanelViewEvent){
            this.depanelViewEvent.unsubscribe();
        }
    }

    /**
     * 视图模型初始化
     * 
     * @memberof DePanelViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDEPanelView;
        await super.viewModelInit();
        this.panelInstance = ModelTool.findPSControlByType('PANEL', this.viewInstance?.getPSControls() || []);
    }

    /**
     * 视图刷新
     *
     * @param {*} args
     * @memberof DePanelViewBase
     */
    public refresh(args?: any): void {
        if (this.engine) {
            this.engine.refresh(args);
        }
    }

}