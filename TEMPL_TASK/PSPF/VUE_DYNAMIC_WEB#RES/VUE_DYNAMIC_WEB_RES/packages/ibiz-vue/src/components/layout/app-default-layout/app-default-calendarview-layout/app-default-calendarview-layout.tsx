import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDECalendarView } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { AppDefaultMDViewLayout } from "../app-default-mdview-layout/app-default-mdview-layout";

@Component({})
export class AppDefaultCalendarViewLayout extends AppDefaultMDViewLayout {

	/**
	 * 实体日历视图模型对象
	 *
	 * @type {IPSAppDECalendarView}
	 * @memberof AppDefaultCalendarViewLayout
	 */
	@Prop() public declare viewInstance: IPSAppDECalendarView;

	/**
	 * 引擎初始化
	 *
	 * @param {*} [opts={}]
	 * @memberof AppDefaultCalendarViewLayout
	 */
	public engineInit(opts: any = {}) {
		const controls: any[] = this.containerModel.getPSControls() || [];
		const calendar = ModelTool.findPSControlByType('CALENDAR', controls);
		if (calendar) {
			let engineOpts = Object.assign({
				view: this,
				p2k: '0',
				isLoadDefault: this.viewInstance?.loadDefault,
				keyPSDEField: this.appDeCodeName.toLowerCase(),
				majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
				opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
					this.opendata(args, fullargs, params, $event, xData);
				},
				newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
					this.newdata(args, fullargs, params, $event, xData);
				},
				calendar: (this.$refs[calendar.name] as any).ctrl,
			}, opts);
			//  搜索表单
			const searchForm = ModelTool.findPSControlByType('SEARCHFORM', controls);
			if (searchForm && searchForm.name && this.$refs[searchForm.name]) {
				engineOpts.searchform = ((this.$refs[searchForm.name] as any).ctrl);
			}
			//  快速搜索表单
			const quickSearchForm = ModelTool.findPSControlByName('quicksearchform', controls);
			if (quickSearchForm && quickSearchForm.name && this.$refs[quickSearchForm.name]) {
				engineOpts.quicksearchform = ((this.$refs[quickSearchForm.name] as any).ctrl);
			}
			//  搜索栏
			const searchBar = ModelTool.findPSControlByType('SEARCHBAR', controls);
			if (searchBar && searchBar.name && this.$refs[searchBar.name]) {
				engineOpts.searchbar = ((this.$refs[searchBar.name] as any).ctrl);
			}
			this.engine.init(engineOpts);
		}
	}

}