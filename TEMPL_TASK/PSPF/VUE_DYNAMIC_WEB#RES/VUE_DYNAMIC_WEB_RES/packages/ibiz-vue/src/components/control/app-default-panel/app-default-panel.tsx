import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppPanelBase } from '../app-common-control/app-panel-base';

/**
 * 面板部件
 *
 * @export
 * @class AppDefaultPanel
 * @extends {AppPanelBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultPanel extends AppPanelBase {}