import { Component } from 'vue-property-decorator';
import { AppChartExpBarBase } from '../app-common-control/app-chart-exp-bar-base';
import { VueLifeCycleProcessing } from '../../../decorators';

/**
 * 图表部件
 *
 * @export
 * @class AppDefaultChartExpBar
 * @extends {AppChartExpBarBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppDefaultChartExpBar extends AppChartExpBarBase {}