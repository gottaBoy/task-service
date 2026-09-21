import { AppModelService, GetModelService, LogUtil, MobWFDynaEditViewEngine, MobWFDynaEditViewInterface, ModelTool, Util, } from 'ibiz-core';
import { MainViewBase } from './main-view-base';
import { IPSAppDEMobWFDynaEditView, IPSAppView, IPSDEForm } from '@ibiz/dynamic-model-api';
import { AppCenterService } from '../app-service';

/**
 * 工作流动态编辑视图基类
 *
 * @export
 * @class MobWFDynaEditViewBase
 * @extends {MainViewBase}
 */
export class MobWFDynaEditViewBase extends MainViewBase implements MobWFDynaEditViewInterface {

    /**
     * 视图实例
     *
     * @memberof MobWFDynaEditViewBase
     */
    public declare viewInstance: IPSAppDEMobWFDynaEditView;

    /**
     * 编辑表单实例
     *
     * @public
     * @type {IBizFormModel}
     * @memberof MobWFDynaEditViewBase
     */
    public editFormInstance!: IPSDEForm;

    /**
     * 工具栏模型数据
     *
     * @memberof MobWFDynaEditViewBase
     */
    public linkModel: Array<any> = [];

    /**
     * 视图引用数据
     *
     * @memberof MobWFDynaEditViewBase
     */
    public viewRefData: any = {};

    /**
     * 工作流按钮显示状态
     *
     * @memberof MobWFDynaEditViewBase
     */
    public toolBarVisible = false;

    /**
     * 工作流附加功能类型映射关系对象
     *
     * @memberof MobWFDynaEditViewBase
     */
    public wfAddiFeatureRef: any = {
        reassign: { featureTag: 'REASSIGN', action: 'TransFerTask' },
        addstepbefore: { featureTag: 'ADDSTEPBEFORE', action: 'BeforeSign' },
        sendback: { featureTag: 'SENDBACK', action: 'SendBack' },
        sendcopy: { featureTag: 'SENDCOPY', action: 'sendCopy' },
    };


    /**
     * 初始化挂载状态集合
     *
     * @memberof MobWFDynaEditViewBase
     */
    public initUIContainerMountedMap() {
        this.mountedMap.set('self', false);
    }

    /**
     * 设置已经绘制完成状态
     *
     * @memberof MobWFDynaEditViewBase
     */
    public setContainerIsMounted(name: string = 'self') {
        super.setContainerIsMounted(name);
        if (this.editFormInstance?.name == name) {
            this.viewState.next({
                tag: this.editFormInstance.name,
                action: 'autoload',
                data: {
                    srfkey: this.context[this.appDeCodeName.toLowerCase()],
                },
            });
        }
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobWFDynaEditViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

    /**
     * 初始化编辑视图实例
     *
     * @memberof MobWFDynaEditViewBase
     */
    public async viewModelInit() {
        this.viewRefData = await ModelTool.loadedAppViewRef(this.viewInstance);
        await super.viewModelInit();
    }

    /**
     * 视图事件
     *
     * @param {*} $event
     * @return {*} 
     * @memberof MobWFDynaEditViewBase
     */
    public WFViewEvent($event: any) {
        const { tag, value } = $event;
        if (!tag) {
            console.log('视图事件tag 异常');
            return;
        }
        this.engine.onViewEvent(tag, value);
    }
}
