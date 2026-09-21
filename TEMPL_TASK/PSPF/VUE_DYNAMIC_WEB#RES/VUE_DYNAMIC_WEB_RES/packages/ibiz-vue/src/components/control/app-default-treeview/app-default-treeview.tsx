import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppTreeViewBase } from '../app-common-control/app-treeview-base';

/**
 * 树视图部件
 *
 * @export
 * @class AppDefaultTree
 * @extends {AppTreeViewBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultTree extends AppTreeViewBase {}
