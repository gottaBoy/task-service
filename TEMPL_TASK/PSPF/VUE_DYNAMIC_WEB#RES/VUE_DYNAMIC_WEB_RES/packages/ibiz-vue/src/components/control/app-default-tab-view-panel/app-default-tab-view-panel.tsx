import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppTabViewPanelBase } from '../app-common-control/app-tab-view-panel-base';

/**
 * 分页视图面板部件
 *
 * @export
 * @class AppDefaultTabViewPanel
 * @extends {AppTabViewPanelBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultTabViewPanel extends AppTabViewPanelBase {}