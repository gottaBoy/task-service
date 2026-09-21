import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDEKanbanView } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { AppDefaultMDViewLayout } from "../app-default-mdview-layout/app-default-mdview-layout";

@Component({})
export class AppDefaultKanbanViewLayout extends AppDefaultMDViewLayout {

	/**
	 * 表格视图模型对象
	 *
	 * @type {IPSAppDEKanbanView}
	 * @memberof AppDefaultKanbanViewLayout
	 */
	@Prop() public declare viewInstance: IPSAppDEKanbanView;

	/**
	 * 引擎初始化
	 *
	 * @param {*} [opts={}]
	 * @memberof AppDefaultKanbanViewLayout
	 */
	public engineInit(opts: any = {}) {
		const controls: any[] = this.containerModel.getPSControls() || [];
		const kanban = ModelTool.findPSControlByType('KANBAN', controls);
		if (kanban) {
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
				kanban: (this.$refs[kanban.name] as any).ctrl,
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