import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppGridView4Base } from '../app-common-view/app-gridview4-base';

/**
 * 应用实体表格视图（上下关系）
 *
 * @export
 * @class AppDefaultGridView4
 * @extends {AppEditViewBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultGridView4 extends AppGridView4Base {}
