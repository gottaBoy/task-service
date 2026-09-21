import { ModelTool, EditViewInterface } from 'ibiz-core';
import { MainViewBase } from './mainview-base';
import { IPSAppDEEditView, IPSDEForm } from '@ibiz/dynamic-model-api';


/**
 * 编辑视图基类
 *
 * @export
 * @class EditViewBase
 * @extends {MainViewBase}
 * @implements {EditViewInterface}
 */
export class EditViewBase extends MainViewBase implements EditViewInterface {

    /**
     * 视图实例
     * 
     * @memberof ViewBase
     */
    public declare viewInstance: IPSAppDEEditView;

    /**
     * 编辑表单实例
     *
     * @public
     * @type {IPSDEForm}
     * @memberof EditViewBase
     */
    public editFormInstance !: IPSDEForm;

    /**
     * 标题头信息表单部件实例
     *
     * @public
     * @type {IPSDEForm}
     * @memberof EditViewBase
     */
    public dataPanelInstance !: IPSDEForm;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EditViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof EditViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.editFormInstance = ModelTool.findPSControlByName('form', this.viewInstance.getPSControls()) as IPSDEForm;
    }

    /**
     * 渲染视图标题头信息表单部件(暂未实现)
     * 
     * @memberof EditViewBase
     */
    public renderDataPanelInfo() {
        return null;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof EditViewBase
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

}
