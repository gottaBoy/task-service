import { EditView3Engine, ModelTool, EditView3Interface } from 'ibiz-core';
import { EditViewBase } from './editview-base';
import { IPSAppDEEditView, IPSDEDRTab, IPSDRTab } from '@ibiz/dynamic-model-api';

/**
 * 实体编辑视图（分页关系）基类
 *
 * @export
 * @class EditView3Base
 * @extends {EditViewBase}
 * @implements {EditView3Interface}
 */
export class EditView3Base extends EditViewBase implements EditView3Interface {

    /**
     * 视图实例
     * 
     * @memberof ViewBase
     */
    public declare viewInstance: IPSAppDEEditView;

    /**
     * 数据关系分页部件实例
     *
     * @public
     * @type {IBizFormModel}
     * @memberof EditView3Base
     */
    public drtabInstance !: IPSDEDRTab;

    /**
     * 关系项
     *
     * @type {*}
     * @memberof EditView3Base
     */
    public drItem: any;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EditView3Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            drtab: (this.$refs[this.drtabInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 数据关系栏变更
     *
     * @param {*} tab
     * @param {MouseEvent} event
     * @memberof EditView3Base
     */
    public drTabChange(tab: any, event: MouseEvent) {
        if (this.engine) {
            this.engine.drTabSelectionChange(tab);
        }
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof EditView3Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.drtabInstance = ModelTool.findPSControlByName('drtab', this.viewInstance.getPSControls()) as IPSDEDRTab;
    }

    /**
     * 绘制表单
     *
     * @return {*} 
     * @memberof EditView3Base
     */
    public renderForm() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { slot: 'mainform', props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof EditView3Base
     */
    public renderMainContent() {
        if (!this.drtabInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drtabInstance);
        return this.$createElement(targetCtrlName, {
            slot: 'default',
            props: targetCtrlParam,
            ref: this.drtabInstance?.name,
            on: targetCtrlEvent,
        }, [
            this.renderForm(),
        ]);
    }

}
