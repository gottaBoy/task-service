import { IPSDEFormDetail, IPSDEFormMDCtrl } from '@ibiz/dynamic-model-api';
import { FormDetailModel } from './form-detail';
import { ModelTool } from '../../utils';

/**
 * 表单分页模型
 *
 * @export
 * @class FormPageModel
 * @extends {FormDetailModel}
 */
export class FormPageModel extends FormDetailModel {

    
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 设置显示与隐藏
     *
     * @param {boolean} state
     * @memberof FormPageModel
     */
    public setVisible(state: boolean): void {
        if (this.isPower) {
            this.oldVisible = this.$visible;
            this.visible = state;
        }
        this.setFormLogicParam(state);
    }

    /**
     * 设置表单逻辑参数(主表单的关系界面数量and多数据部件数量)
     *
     * @memberof FormPageModel
     */
    public setFormLogicParam(state: boolean) {
        if(state || !this.model){
            return;
        }
        let DRDetails:IPSDEFormDetail[] = [];
        let MDDetails:IPSDEFormDetail[] = [];
        const allFormDetails: IPSDEFormDetail[] = ModelTool.getChildDetails(this.model);
        if (allFormDetails && allFormDetails.length > 0) {
            DRDetails = allFormDetails.filter((item: any) => {
                return item.detailType === 'DRUIPART';
            });
            MDDetails = allFormDetails.filter((item: any) => {
                return item.detailType === 'MDCTRL' && (item as IPSDEFormMDCtrl).contentType !== 'REPEATER';
            });
        }
        if(DRDetails && DRDetails.length >0){
            this.form.drCount -= DRDetails.length;
        }
        if(MDDetails && MDDetails.length >0){
            this.form.mdCtrlCount -= MDDetails.length;
        }
    }
}