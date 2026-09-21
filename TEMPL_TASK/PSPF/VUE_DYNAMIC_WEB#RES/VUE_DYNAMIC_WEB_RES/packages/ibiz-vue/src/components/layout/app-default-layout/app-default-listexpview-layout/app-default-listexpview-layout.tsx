import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDEListExplorerView } from "@ibiz/dynamic-model-api";
import { ModelTool, Util } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export class AppDefaultListExpViewLayout extends AppDefaultViewLayout {

	/**
	 * 列表导航视图模型对象
	 *
	 * @type {IPSAppDEListExplorerView}
	 * @memberof AppDefaultListExpViewLayout
	 */
	@Prop() public declare viewInstance: IPSAppDEListExplorerView;

	/**
	 * 引擎初始化
	 *
	 * @param {*} [opts={}]
	 * @memberof AppDefaultListExpViewLayout
	 */
	public engineInit(opts: any = {}) {
		const controls: any[] = this.containerModel.getPSControls() || [];
		const listExpBar = ModelTool.findPSControlByType('LISTEXPBAR', controls);
		if (listExpBar) {
			let engineOpts = Object.assign({
				view: this,
				p2k: '0',
				isLoadDefault: this.viewInstance?.loadDefault,
				keyPSDEField: this.appDeCodeName.toLowerCase(),
				majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
				listexpbar: (this.$refs[listExpBar.name] as any).ctrl,
			}, opts);
			this.engine.init(engineOpts);
		}
	}

	/**
	 * 计算目标部件数据
	 *
	 * @param {*} controlInstance
	 * @return {*} 
	 * @memberof AppDefaultListExpViewLayout
	 */
	public computeTargetCtrlData(controlInstance: any, args?: any) {
		const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
		//	视图级参数
		Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
		Object.assign(targetCtrlEvent, {
			closeView: ($event: any) => {
				this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
			}
		});
		return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
	}

    /**
     * 初始化视图的绘制参数
     *
     * @memberof AppDefaultListExpViewLayout
     */
     public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'view-container': true,
            'deexpview':true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`view-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`view-style-default`]: true });
        }
        if (codeName) {
            Object.assign(viewClassNames, { [Util.srfFilePath2(codeName)]: true });
        }
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [(this.viewInstance as any).getPSSysCss()?.cssName]: true });
        }
        if (this.viewProxyMode) {
            Object.assign(viewClassNames, { 'isproxy': true });
        }
        if (!this.showCaption) {
            Object.assign(viewClassNames, { 'nocaption': true });
        }
        if (!this.viewIsshowToolbar) {
            Object.assign(viewClassNames, { 'notoolbar': true });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }
}