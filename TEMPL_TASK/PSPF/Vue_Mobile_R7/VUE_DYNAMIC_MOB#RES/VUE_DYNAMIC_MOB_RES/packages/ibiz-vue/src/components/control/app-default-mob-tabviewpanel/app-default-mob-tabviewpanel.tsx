
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobTabViewPanelBase } from '../app-common-control/app-mob-tabviewpanel-base';

/**
 * 分页视图面板部件
 *
 * @export
 * @class AppDefaultTabViewPanel
 * @extends {AppTabViewPanelBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobTabViewPanel extends AppMobTabViewPanelBase {}
