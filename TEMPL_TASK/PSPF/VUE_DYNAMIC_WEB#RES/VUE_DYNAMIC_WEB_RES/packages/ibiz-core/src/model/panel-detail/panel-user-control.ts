import { PanelDetailModel } from './panel-detail';

/**
 * 用户控件模型
 *
 * @export
 * @class PanelUserControlModel
 * @extends {PanelDetailModel}
 */
export class PanelUserControlModel extends PanelDetailModel {


    constructor(otps:any = {}) {
        super(otps);
    }

    /**
     * 设置数据
     *
     * @param {*} val (值非对象)
     * @memberof PanelFieldModel
     */
     public setData(val: any) {
        this.data = val;
        if (!this.parentItem) {
            return;
        } else {
            this.parentItem.setData({ name: this.name, value: val });
        }
    }
}