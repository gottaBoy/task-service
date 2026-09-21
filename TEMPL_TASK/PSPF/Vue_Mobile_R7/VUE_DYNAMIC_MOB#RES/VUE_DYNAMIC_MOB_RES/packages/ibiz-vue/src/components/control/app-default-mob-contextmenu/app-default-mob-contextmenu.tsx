import { Component } from 'vue-property-decorator';
import { AppMobContextMenuBase } from '../app-common-control/app-mob-contextmenu-base';
import { VueLifeCycleProcessing } from '../../../decorators';

/**
 * 上下文菜单部件
 *
 * @export
 * @class AppDefaultMobContextMenu
 * @extends {MobTreeControlBase}
 */
 @Component({})
 @VueLifeCycleProcessing()
 export default class AppDefaultMobContextMenu extends AppMobContextMenuBase {}