import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppWizardPanelBase } from '../app-common-control/app-wizardpanel-base';

@Component({})
@VueLifeCycleProcessing()
export class AppDefaultWizardPanel extends AppWizardPanelBase { }