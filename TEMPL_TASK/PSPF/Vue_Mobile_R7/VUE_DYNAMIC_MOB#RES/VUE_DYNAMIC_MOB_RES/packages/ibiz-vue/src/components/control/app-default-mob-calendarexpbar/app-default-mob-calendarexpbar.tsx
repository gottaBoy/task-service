import { Component } from "vue-property-decorator";
import { VueLifeCycleProcessing } from "../../../decorators";
import { AppMobCalendarExpBarBase } from "../app-common-control/app-mob-calendarexpbar-base";

/**
 * 实体列表导航栏部件基类
 *
 * @export
 * @class AppDefaultMobCalendarExpBar
 * @extends {CalendarExpBarControlBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppDefaultMobCalendarExpBar extends AppMobCalendarExpBarBase { }
