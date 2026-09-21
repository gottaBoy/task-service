import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobTreeBase } from '../app-common-control/app-mob-tree-base';
/**
 * 树视图部件基类
 *
 * @export
 * @class AppDefaultMobTree
 * @extends {MobTreeControlBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobTree extends AppMobTreeBase { }