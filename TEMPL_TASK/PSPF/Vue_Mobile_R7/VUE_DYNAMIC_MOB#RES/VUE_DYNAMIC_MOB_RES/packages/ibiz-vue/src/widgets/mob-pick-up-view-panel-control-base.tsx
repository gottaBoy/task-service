import { IPSDEPickupViewPanel } from "@ibiz/dynamic-model-api";
import { MobPickUpViewPanelControlInterface } from "ibiz-core";
import { MainControlBase } from "./main-control-base";

/**
 * 选择视图面板基类
 *
 * @export
 * @class MobPickUpViewPanelControlBase
 * @extends {MainControlBase}
 */
export class MobPickUpViewPanelControlBase extends MainControlBase implements MobPickUpViewPanelControlInterface {

    /**
     * 部件模型实例对象
     *
     * @type {IPSDEPickupViewPanel}
     * @memberof MobPickUpViewPanelControlBase
     */
    public declare controlInstance: IPSDEPickupViewPanel;

    /**
      * 是否单选
      *
      * @type {boolean}
      * @memberof MobPickUpViewPanelControlBase
      */
    protected isSingleSelect?: boolean;

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof MobPickUpViewPanelControlBase
     */
    public async viewDatasChange($event: any): Promise<void> {
        if (!(await this.handleCtrlEvents('onSelectionChange', { action: 'onSelectionChange', data: $event }))) {
            return;
        }
        if ($event.length > 0) {
            $event.forEach((item: any, index: any) => {
                let srfmajortext = item[this.appDeMajorFieldName.toLowerCase()];
                if (srfmajortext) {
                    Object.assign($event[index], { srfmajortext: srfmajortext });
                }
            });
        }
        this.ctrlEvent({ controlname: this.controlInstance.name, action: 'selectionchange', data: $event });
    }

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        super.onStaticPropsChange(newVal, oldVal);
        this.isSingleSelect = newVal.isSingleSelect;
    }
}