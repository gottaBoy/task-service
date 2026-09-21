import { MobPickupMDViewEngine, MobPickupMDViewInterface, ModelTool } from 'ibiz-core'
import { MDViewBase } from './md-view-base';
import { IPSAppDEPickupView, IPSDEMobMDCtrl } from '@ibiz/dynamic-model-api';

/**
 * 选择多数据视图基类
 *
 * @export
 * @class MobPickUpMDViewBase
 * @extends {MDViewBase}
 */
export class MobPickUpMDViewBase extends MDViewBase implements MobPickupMDViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobPickUpMDViewBase
     */
    public declare viewInstance: IPSAppDEPickupView;

    /**
     * 多数据实例
     * 
     * @memberof MobPickUpMDViewBase
     */
    public mdCtrlInstance!: IPSDEMobMDCtrl;

    /**
     * 初始化选择多数据视图实例
     * 
     * @memberof MobPickUpMDViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.mdCtrlInstance = ModelTool.findPSControlByName("mdctrl", this.viewInstance.getPSControls());
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobPickUpMDViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.mdCtrlInstance);
        Object.assign(targetCtrlParam.staticProps, { listMode: 'SELECT', isSingleSelect: this.staticProps.isSingleSelect });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.mdCtrlInstance.name, on: targetCtrlEvent });
    }

}
