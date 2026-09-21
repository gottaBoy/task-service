import { Component } from 'vue-property-decorator';
import FullCalendar from '@fullcalendar/vue';
import { AppCalendarBase } from '../app-common-control/app-calendar-base';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppDefaultContextMenu } from '../app-default-contextmenu/app-default-contextmenu';

/**
 * 日历部件
 *
 * @export
 * @class AppDefaultCalendar
 * @extends {AppCalendarBase}
 */
@Component({
    components: {
        FullCalendar,
        "app-default-contextmenu": AppDefaultContextMenu
    }
})
@VueLifeCycleProcessing()
export class AppDefaultCalendar extends AppCalendarBase {}