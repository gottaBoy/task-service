import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDEDataView } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { AppDefaultMDViewLayout } from "../app-default-mdview-layout/app-default-mdview-layout";

@Component({})
export class AppDefaultDataViewLayout extends AppDefaultMDViewLayout {
	/**
	 * 数据视图模型对象
	 *
	 * @type {IPSAppDEDataView}
	 * @memberof AppDefaultDataViewLayout
	 */
	@Prop() public declare viewInstance: IPSAppDEDataView;

	/**
	 * 引擎初始化
	 *
	 * @param {*} [opts={}]
	 * @memberof AppDefaultDataViewLayout
	 */
	public engineInit(opts: any = {}) {
		const controls: any[] = this.containerModel.getPSControls() || [];
		const dataView = ModelTool.findPSControlByType('DATAVIEW', controls);
		if (dataView) {
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
				dataview: (this.$refs[dataView.name] as any).ctrl,
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

	/**
	 * 计算目标部件所需参数
	 *
	 * @param {any} [controlInstance] 部件模型实例
	 * @returns
	 * @memberof AppDefaultDataViewLayout
	 */
	public computeTargetCtrlData(controlInstance: any, args?: any) {
		const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
		// 合并视图级参数
		Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
		Object.assign(targetCtrlEvent, {
			closeView: ($event: any) => {
				this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
			}
		})
		// 合并多数据视图级参数
		if (Object.is(controlInstance.controlType, 'SEARCHFORM') || Object.is(controlInstance.controlType, 'SEARCHBAR')) {
			Object.assign(targetCtrlParam.dynamicProps, {
				isExpandSearchForm: this.isExpandSearchForm
			});
		} else {
			Object.assign(targetCtrlParam.staticProps, {
				mDCtrlActiveMode: (this.viewInstance as any).mDCtrlActiveMode,
			});
		}
		return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
	}

}