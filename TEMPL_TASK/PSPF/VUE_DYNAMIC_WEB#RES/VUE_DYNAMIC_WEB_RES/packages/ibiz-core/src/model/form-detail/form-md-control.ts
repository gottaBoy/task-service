import { FormDetailModel } from './form-detail';

/**
 * 表单多数据控件模型
 *
 * @export
 * @class FormMDControlModel
 * @extends {FormDetailModel}
 */
export class FormMDControlModel extends FormDetailModel {


    constructor(otps:any = {}) {
        super(otps);
    }
}