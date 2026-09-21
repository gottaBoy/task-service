import {  Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators/vue-lifecycleprocessing';
import { AppMobMeditViewPanelBase } from '../app-common-control/app-mob-meditviewpanel-base';

/**
 * 多编辑面板部件基类
 *
 * @export
 * @class AppDefaultMobMeditViewPanel
 * @extends {AppMobMeditViewPanelBase}
 */
 @Component({})
 @VueLifeCycleProcessing()
 export default class AppDefaultMobMeditViewPanel extends AppMobMeditViewPanelBase { }