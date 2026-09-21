import { IPSAppDEMEditView, IPSDEMultiEditViewPanel } from '@ibiz/dynamic-model-api';
import { MobMEditViewInterface, ModelTool } from 'ibiz-core'
import { MDViewBase } from "./md-view-base";

/**
 * 多编辑表单视图基类
 *
 * @export
 * @class MobMeditViewBase
 * @extends {MDViewBase}
 */
export class MobMeditViewBase extends MDViewBase implements MobMEditViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobMeditViewBase
     */
    public declare viewInstance: IPSAppDEMEditView;

    /**
     * 编辑面板实例
     * 
     * @memberof MobMeditViewBase
     */
    public meditViewPanelInstance!: IPSDEMultiEditViewPanel;

    /**
     * 初始化列表视图实例
     * 
     * @memberof MobMeditViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        if (this.viewProxyMode) {
            const controls: any = this.viewInstance.getPSViewLayoutPanel()?.getPSControls();
            this.meditViewPanelInstance = ModelTool.findPSControlByName('meditviewpanel', controls) as IPSDEMultiEditViewPanel;
        } else {
            this.meditViewPanelInstance = ModelTool.findPSControlByName('meditviewpanel', this.viewInstance.getPSControls()) as IPSDEMultiEditViewPanel;
        }
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobMeditViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.meditViewPanelInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.meditViewPanelInstance.name, on: targetCtrlEvent });
    }

    /**
      * 多表单编辑视图挂载
      *
      * @memberof MobMeditViewBase
      */
    public containerMounted() {
        super.containerMounted();
        if (this.inputState) {
            this.$emit('view-event', { viewName: this.viewCodeName, action: 'viewLoaded', data: null });
        }
    }

    /**
     * 事件订阅
     *
     * @memberof MobMeditViewBase
     */
    public subscribeEvent() {
        if (this.inputState) {
            this.inputStateEvent = this.inputState.subscribe(({ tag, action }: any) => {
                if (!Object.is(tag, this.viewInstance.name)) {
                    return;
                }
                if (Object.is(action, 'save')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance.name, action: 'save', data: this.viewparams });
                }
                if (Object.is(action, 'remove')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance.name, action: 'remove', data: this.viewparams });
                }
                if (Object.is(action, 'load')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance.name, action: 'load', data: this.viewparams });
                }
            });
        }
    }
}
