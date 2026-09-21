import { IPSAppDEWFDynaActionView, IPSDEForm } from '@ibiz/dynamic-model-api';
import { ModelTool, WFDynaActionViewInterface } from 'ibiz-core';
import { MainViewBase } from './mainview-base';


/**
 * 工作流动态操作视图基类
 *
 * @export
 * @class WFDynaActionViewBase
 * @extends {MainViewBase}
 * @implements {WFDynaActionViewInterface}
 */
export class WFDynaActionViewBase extends MainViewBase implements WFDynaActionViewInterface {

    /**
     * 视图实例
     * 
     * @memberof WFDynaActionViewBase
     */
    public declare viewInstance: IPSAppDEWFDynaActionView;

    /**
     * 表单实例
     * 
     * @memberof WFDynaActionViewBase
     */
    protected editFormInstance!: IPSDEForm;

    /**
     * 初始化挂载状态集合
     *
     * @memberof WFDynaActionViewBase
     */
     public initUIContainerMountedMap(){
        this.mountedMap.set('self', false);
    }

    /**
     * 设置已经绘制完成状态
     *
     * @memberof WFDynaActionViewBase
     */
    public setContainerIsMounted(name: string = 'self') {
        super.setContainerIsMounted(name);
        if(this.editFormInstance?.name == name){
           this.viewState.next({ tag: this.editFormInstance.name, action: 'autoload', data: {srfkey:this.context[this.appDeCodeName.toLowerCase()]} });
        }
    }

    /**
     *  视图挂载
     *
     * @memberof WFDynaActionViewBase
     */
    public containerMounted() {
        super.containerMounted();
        if(this.viewparams && this.viewparams.actionForm) {
            this.computeActivedForm(this.viewparams.actionForm);
        } else {
            this.computeActivedForm(null);
        }
    }

    /**
     * 计算激活表单
     * 
     * @memberof WFDynaActionViewBase
     */
    public computeActivedForm(inputForm: any) {
        if (!inputForm) {
            this.editFormInstance = ModelTool.findPSControlByName('form', this.viewInstance.getPSControls()) as IPSDEForm;
        } else {
            this.editFormInstance = ModelTool.findPSControlByName(`wfform_${inputForm.toLowerCase()}`, this.viewInstance.getPSControls()) as IPSDEForm;
        }
        this.mountedMap.set(this.editFormInstance.name, false);
        this.$forceUpdate();
    }

    /**
     * 确认
     * 
     * @memberof WFDynaActionViewBase
     */
    public onClickOk() {
        let form: any = (this.$refs.form as any).ctrl;
        if (!form) {
            return;
        }
        if (this.viewInstance && this.viewInstance.tempMode && Object.is(this.viewInstance.tempMode, 2)) {
            if (form.save && form.save instanceof Function) {
                form.save().then((data: any) => {
                    let preFormData: any = data;
                    let nextFormData: any = form.transformData(preFormData);
                    Object.assign(preFormData, nextFormData);
                    this.$emit("view-event", { action: "viewdataschange", data: [preFormData] });
                    this.$emit("view-event", { action: "close", data: null });
                })
            }
        } else {
            if (form && form.formValidateStatus()) {
                let preFormData: any = form.getData();
                let nextFormData: any = form.transformData(preFormData);
                Object.assign(preFormData, nextFormData);
                this.$store.commit('viewAction/setViewDataChange', { viewTag: this.viewtag, viewDataChange: false });
                this.$emit("view-event", { action: "viewdataschange", data: [preFormData] });
                this.$emit("view-event", { action: "close", data: null });
            }
        }
    }

    /**
     * 取消
     * 
     * @memberof WFDynaActionViewBase
     */
    public onClickCancel() {
        this.$store.commit('viewAction/setViewDataChange', { viewTag: this.viewtag, viewDataChange: false });
        this.$emit("view-event", { action: "close", data: null });
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof WFDynaActionViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof WFDynaActionViewBase
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        if (this.viewInstance && this.viewInstance.tempMode && Object.is(this.viewInstance.tempMode, 2)) {
            Object.assign(targetCtrlParam.staticProps, { tempmode: true });
        }
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: "form", on: targetCtrlEvent });
    }

}