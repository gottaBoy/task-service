import { Component } from 'vue-property-decorator';
import { AppMobCalendarBase } from '../app-common-control/app-mob-calendar-base';
import { VueLifeCycleProcessing } from '../../../decorators';

/**
 * 日历部件
 *
 * @export
 * @class AppDefaultMobCalendar
 * @extends {AppDefaultMobCalendarBase}
 */
@Component({
    components: {

    }
})
@VueLifeCycleProcessing()
export default class AppDefaultMobCalendar extends AppMobCalendarBase{}