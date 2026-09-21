import { Component } from 'vue-property-decorator';
import { AppDefaultFormPage } from './app-default-form-page/app-default-form-page';
import { AppDefaultGroupPanel } from './app-default-group-panel/app-default-group-panel';
import { AppDefaultFormItem } from './app-default-form-item/app-default-form-item';
import { AppDefaultFormTabPage } from './app-default-form-tab-page/app-default-form-tab-page';
import { AppDefaultFormTabPanel } from './app-default-form-tab-panel/app-default-form-tab-panel';
import { AppDefaultFormMdCtrl } from './app-default-form-mdctrl/app-default-form-mdctrl';
import { AppFormBase } from '../app-common-control/app-form-base';
import { VueLifeCycleProcessing } from '../../../decorators';

/**
 * 编辑表单部件
 *
 * @export
 * @class AppFormBase
 * @extends {AppFormBase}
 */
@Component({
    components: {
        AppDefaultFormPage,
        AppDefaultGroupPanel,
        AppDefaultFormItem,
        AppDefaultFormTabPage,
        AppDefaultFormTabPanel,
        AppDefaultFormMdCtrl
    },
})
@VueLifeCycleProcessing()
export class AppDefaultForm extends AppFormBase {}
