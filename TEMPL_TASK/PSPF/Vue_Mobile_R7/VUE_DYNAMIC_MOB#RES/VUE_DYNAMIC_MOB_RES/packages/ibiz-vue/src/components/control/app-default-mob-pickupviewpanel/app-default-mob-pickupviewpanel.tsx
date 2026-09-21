import { Component } from "vue-property-decorator";
import { AppMobPickUpViewPanelBase } from '../app-common-control/app-mob-pickupviewpanel-base';
import { VueLifeCycleProcessing } from '../../../decorators/vue-lifecycleprocessing';
/**
 * 选择视图面板部件基类
 *
 * @export
 * @class AppDefaultMobPickUpViewPanel
 * @extends {MobPickUpViewPanelControlBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobPickUpViewPanel extends AppMobPickUpViewPanelBase { }