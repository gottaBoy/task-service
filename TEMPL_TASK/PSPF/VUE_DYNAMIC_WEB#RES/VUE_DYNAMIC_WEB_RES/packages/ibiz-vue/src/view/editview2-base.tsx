import { ModelTool, EditView2Interface, EditView2Engine } from 'ibiz-core';
import { IPSDEDRBar } from '@ibiz/dynamic-model-api';
import { EditViewBase } from './editview-base';


/**
 * 实体编辑视图（左右关系）基类
 *
 * @export
 * @class EditView2Base
 * @extends {EditView2Base}
 * @implements {EditView2Interface}
 */
export class EditView2Base extends EditViewBase implements EditView2Interface {

    /**
     * 数据关系分页部件实例
     *
     * @public
     * @type {IBizFormModel}
     * @memberof EditView2Base
     */
    public drbarInstance!: IPSDEDRBar;

    /**
     * 视图引擎对象
     *
     * @type {EditView2Engine}
     * @memberof EditView2Base
     */
    public declare engine: EditView2Engine;

    /**
     * 关系项
     *
     * @type {*}
     * @memberof EditView2Base
     */
    public drItem: any;

    /**
     * 初始化数据关系栏
     * 
     * @memberof EditView2Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.drbarInstance = ModelTool.findPSControlByType('DRBAR', this.viewInstance.getPSControls()) as IPSDEDRBar;
    }

    /**
     * 关系项选中
     *
     * @memberof EditView2Base
     */
    public drbarChange() {
        if (this.engine) {
            this.engine.drBarSelectionChange({ id: this.editFormInstance.name });
        }
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EditView2Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            drbar: (this.$refs[this.drbarInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 渲染表单
     *
     * @memberof EditView2Base
     */
    public renderForm() {
        if (!this.editFormInstance) {
            return;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

}
