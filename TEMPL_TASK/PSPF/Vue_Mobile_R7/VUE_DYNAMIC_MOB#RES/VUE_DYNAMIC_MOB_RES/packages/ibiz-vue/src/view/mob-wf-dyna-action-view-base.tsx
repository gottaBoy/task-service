import {
    MobWFActionViewEngine,
    MobWFDynaActionViewInterface,
    ModelTool,
} from 'ibiz-core';
import { MainViewBase } from './main-view-base';
import {
    IPSAppDEMobWFDynaActionView,
    IPSDEForm,
} from '@ibiz/dynamic-model-api';

/**
 * 工作流动态操作视图基类
 *
 * @export
 * @class MobWFDynaActionViewBase
 * @extends {MainViewBase}
 */
export class MobWFDynaActionViewBase extends MainViewBase
    implements MobWFDynaActionViewInterface {
    /**
     * 视图实例
     *
     * @memberof MobWFDynaActionViewBase
     */
    public declare viewInstance: IPSAppDEMobWFDynaActionView;

    /**
     * 表单实例
     *
     * @memberof MobWFDynaActionViewBase
     */
    protected editFormInstance!: IPSDEForm;

    /**
     * 初始化挂载状态集合
     *
     * @memberof WFDynaActionViewBase
     */
    public initUIContainerMountedMap() {
        this.mountedMap.set('self', false);
    }

    /**
     * 设置已经绘制完成状态
     *
     * @memberof WFDynaActionViewBase
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
     *  视图挂载
     *
     * @memberof MobWFDynaActionViewBase
     */
    public containerMounted() {
        super.containerMounted();
        if (this.viewparams && this.viewparams.actionForm) {
            this.computeActivedForm(this.viewparams.actionForm);
        } else {
            this.computeActivedForm(null);
        }
        setTimeout(() => {
            if (this.Environment?.isPreviewMode) {
                return;
            }
            this.viewState.next({
                tag: this.editFormInstance.name,
                action: 'autoload',
                data: {
                    srfkey: this.context[this.appDeCodeName?.toLowerCase()],
                },
            });
        }, 0);
    }

    /**
     * 计算激活表单
     *
     * @memberof MobWFDynaActionViewBase
     */
    public computeActivedForm(inputForm: any) {
        if (!inputForm) {
            this.editFormInstance = ModelTool.findPSControlByName(
                'form',
                this.viewInstance.getPSControls()
            );
        } else {
            this.editFormInstance = ModelTool.findPSControlByName(
                `wfform_${inputForm.toLowerCase()}`,
                this.viewInstance.getPSControls()
            );
        }
        this.$forceUpdate();
    }

    /**
     * 确认
     *
     * @memberof MobWFDynaActionViewBase
     */
    public onClickOk() {
        let xData: any = (this.$refs.form as any).ctrl;
        if (xData) {
            let preFormData: any = xData.getData();
            let nextFormData: any = xData.transformData(preFormData);
            Object.assign(preFormData, nextFormData);
            this.$emit('view-event', {
                action: 'viewdataschange',
                data: [preFormData],
            });
            this.$emit('view-event', { action: 'close', data: null });
        }
    }

    /**
     * 取消
     *
     * @memberof MobWFDynaActionViewBase
     */
    public onClickCancel() {
        this.$emit('view-event', { action: 'close', data: null });
    }
}
