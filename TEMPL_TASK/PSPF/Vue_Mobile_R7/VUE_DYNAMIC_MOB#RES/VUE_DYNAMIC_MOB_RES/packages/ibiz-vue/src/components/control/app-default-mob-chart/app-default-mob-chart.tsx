import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { AppMobChartBase } from '../app-common-control/app-mob-chart-base';

/**
 * 图表部件基类
 *
 * @export
 * @class AppDefaultMobChart
 * @extends {AppDefaultMobChartBase}
 */
 @Component({})
 @VueLifeCycleProcessing()
 export default class AppDefaultMobChart extends AppMobChartBase {}