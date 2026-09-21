import { MobFormControlInterface } from 'ibiz-core';
import { IPSDEEditForm } from '@ibiz/dynamic-model-api';
import { MobFormControlBase } from './mob-form-control-base';

/**
 * 表单部件基类
 *
 * @export
 * @class FromControlBase
 * @extends {MainControlBase}
 */
export class MobEditFormControlBase extends MobFormControlBase implements MobFormControlInterface {
    /**
     * 部件模型实例对象
     *
     * @type {*}
     * @memberof MobFormControlBase
     */
    public declare controlInstance: IPSDEEditForm;

    /**
     * 部件模型数据初始化实例
     *
     * @memberof MobFormControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        this.isAutoSave = this.controlInstance.enableAutoSave;
        this.loadDraftAction = this.controlInstance.getGetDraftPSControlAction?.()?.actionName;
        this.updateAction = this.controlInstance.getUpdatePSControlAction?.()?.actionName;
        this.removeAction = this.controlInstance.getRemovePSControlAction?.()?.actionName;
        this.loadAction = this.controlInstance.getGetPSControlAction?.()?.actionName;
        this.createAction = this.controlInstance.getCreatePSControlAction?.()?.actionName;
        this.WFSubmitAction = (this.controlInstance as any).getWFSubmitPSControlAction?.()?.actionName;
        this.WFStartAction = (this.controlInstance as any).getWFStartPSControlAction?.()?.actionName;
    }
}
