import { Component } from "vue-property-decorator";
import { VueLifeCycleProcessing } from "../../../decorators";
import { AppGridExpBarBase } from "../app-common-control/app-grid-exp-bar-base";

/**
 * 表格导航栏
 *
 * @export
 * @class AppDefaultGridExpBar
 * @extends {AppGridExpBarBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultGridExpBar extends AppGridExpBarBase {}

