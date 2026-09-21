import { IPSAppIndexView, IPSAppMenu } from '@ibiz/dynamic-model-api';
import { MobIndexViewInterface, ModelTool, ViewTool } from 'ibiz-core';
import { AppFuncService } from '../app-service';
import { ViewBase } from "./view-base";

/**
 * 首页视图基类
 *
 * @export
 * @class IndexViewBase
 * @extends {ViewBase}
 */
export class IndexViewBase extends ViewBase implements MobIndexViewInterface {

    /**
     * 菜单实例
     *
     * @type {*}
     * @memberof IndexViewBase
     */
    public menuInstance!: IPSAppMenu;

    /**
     * 视图实例
     * 
     * @memberof ViewBase
     */
    public declare viewInstance: IPSAppIndexView;

    /**
     * 导航视图参数
     *
     * @memberof IndexViewBase
     */
    public embedViewProps: any = {};

    /**
     * 视图显示状态
     *
     * @memberof IndexViewBase
     */
    public init = false;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobEditView3Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            menu: (this.$refs[this.menuInstance.name] as any).ctrl,
        });
        this.engine.load();
    }

    /**
     * 初始化应用首页视图实例
     * 
     * @memberof IndexViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.menuInstance = (this.viewInstance.findPSControl(ModelTool.findPSControlByType("APPMENU", this.viewInstance.getPSControls()))) as IPSAppMenu;
    }

    /**
     * 视图初始化
     *
     * @memberof IndexViewBase
     */
    public viewInit() {
        super.viewInit();
        AppFuncService.getInstance().init(this);
    }

    /**
     *  视图挂载
     *
     * @memberof IndexViewBase
     */
    public containerMounted() {
        super.containerMounted();
        ViewTool.setIndexParameters([{ pathName: this.viewInstance.codeName, parameterName: this.viewInstance.codeName }]);
        ViewTool.setIndexViewParam(this.context);
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof IndexViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        const { codeName, defaultPage, name } = this.viewInstance;
        Object.assign(targetCtrlParam.staticProps, {
            viewName: codeName,
            mode: this.model,
            isDefaultPage: defaultPage,
            name: name,

        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent }
    }

    /**
     * 绘制菜单导航内容区
     *
     * @memberof IndexViewBase
     */
    renderEmbedViewContent() {      
        return (
                this.init ? this.$createElement('app-view-shell', { props: this.embedViewProps, class:'app-view-container',slot:'embedview' }) : null
        )
    }

    /**
     * 渲染视图主题内容
     * 
     * @memberof IndexViewBase
     */
    public renderMainContent() {
        if (!this.menuInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.menuInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.menuInstance.name, on: targetCtrlEvent });
    }
}
