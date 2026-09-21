import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobSearchBarBase } from '../app-common-control/app-mob-searchbar-base';

/**
 * 搜索栏部件基类
 *
 * @export
 * @class AppDefaultSearchBar
 * @extends {AppSearchBarBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobSearchBar extends AppMobSearchBarBase {

}
