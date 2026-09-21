import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobPanelBase } from '../app-common-control/app-mob-panel-base';

/**
 * 面板部件
 *
 * @export
 * @class AppDefaultMobPanel
 * @extends {AppDefaultMobPanelBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobPanel extends AppMobPanelBase { }