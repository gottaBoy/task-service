import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobWizardPanelBase } from '../app-common-control/app-mob-wizard-panel-base';

@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobWizardPanel extends AppMobWizardPanelBase { }