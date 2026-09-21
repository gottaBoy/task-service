import { ModelTool, MEditViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';
import { IPSAppDEMEditView, IPSDEMultiEditViewPanel } from "@ibiz/dynamic-model-api";
import { Subscription } from 'rxjs';

/**
 * 多表单编辑视图基类
 *
 * @export
 * @class MEditViewBase
 * @extends {MDViewBase}
 * @implements {MEditViewInterface}
 */
export class MEditViewBase extends MDViewBase implements MEditViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MEditViewBase
     */
    public declare viewInstance: IPSAppDEMEditView;

    /**
     * 多编辑视图实例
     * 
     * @memberof MEditViewBase
     */
    public meditViewPanelInstance!: IPSDEMultiEditViewPanel;

    /**
     * 门户视图状态事件
     * 
     * @memberof DePanelViewBase
     */
    public meditViewEvent: Subscription | undefined;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @return {*}  {void}
     * @memberof MEditViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.meditViewPanelInstance) {
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
                meditviewpanel: (this.$refs[this.meditViewPanelInstance?.name] as any).ctrl,
            }, opts)
            //  多编辑视图不支持配置搜索表单等过滤部件
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化多表单编辑视图实例
     * 
     * @param opts 
     * @memberof MEditViewBase
     */
    public async viewModelInit(arg?: any) {
        await super.viewModelInit();
        this.meditViewPanelInstance = ModelTool.findPSControlByName('meditviewpanel', this.viewInstance.getPSControls()) as IPSDEMultiEditViewPanel;
    }

    /**
     * 绘制视图主体内容区
     * 
     * @memberof MEditViewBase
     */
    public renderMainContent() {
        if (this.meditViewPanelInstance) {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.meditViewPanelInstance);
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.meditViewPanelInstance.name, on: targetCtrlEvent });
        }
    }

    /**
     * 多表单编辑视图初始化
     *
     * @memberof MEditViewBase
     */
    public async viewInit() {
        super.viewInit()
        if (this.inputState) {
            this.meditViewEvent = this.inputState.subscribe(({ action }: any) => {
                if (Object.is(action, 'save')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance?.name, action: 'save', data: this.viewparams });
                }
                if (Object.is(action, 'remove')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance?.name, action: 'remove', data: this.viewparams });
                }
                if (Object.is(action, 'load')) {
                    this.viewState.next({ tag: this.meditViewPanelInstance?.name, action: 'load', data: this.viewparams });
                }
            });
        }
    }

    /**
     * @description 视图销毁
     * @memberof MEditViewBase
     */
    public viewDestroyed() {
        super.viewDestroyed();
        if (this.meditViewEvent) {
            this.meditViewEvent.unsubscribe();
        }
    }


    /**
     * 多表单编辑视图挂载
     *
     * @memberof MEditViewBase
     */
    public containerMounted() {
        if (!this.inputState) {
            this.viewState.next({ tag: this.meditViewPanelInstance.name, action: 'load', data: this.viewparams });
        }
        super.containerMounted();
    }

}