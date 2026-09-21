
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobPortletBase } from '../app-common-control/app-mob-portlet-base';

/**
 * 门户部件部件
 *
 * @export
 * @class AppDefaultMobPortlet
 * @extends {AppDefaultMobPortletBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobPortlet extends AppMobPortletBase { }
