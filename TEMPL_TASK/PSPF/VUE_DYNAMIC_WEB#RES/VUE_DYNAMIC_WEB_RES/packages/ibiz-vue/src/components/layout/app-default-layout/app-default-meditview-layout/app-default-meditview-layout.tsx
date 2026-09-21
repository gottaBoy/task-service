import { Prop,Component } from 'vue-property-decorator';
import { IPSAppDEMEditView } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export class AppDefaultMEditViewLayout extends AppDefaultViewLayout{

	/**
	 * 多编辑视图模型对象
	 *
	 * @type {IPSAppDEMEditView}
	 * @memberof AppDefaultMEditViewLayout
	 */
	@Prop() public declare viewInstance: IPSAppDEMEditView;

	/**
	 * 引擎初始化
	 *
	 * @param {*} [opts={}]
	 * @memberof AppDefaultMEditViewLayout
	 */
	public engineInit(opts: any = {}) {
		const controls: any[] = this.containerModel.getPSControls() || [];
        const mEditViewPanel = ModelTool.findPSControlByType('MULTIEDITVIEWPANEL', controls);
        if (mEditViewPanel) {
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
                meditviewpanel: (this.$refs[mEditViewPanel.name] as any).ctrl,
            }, opts);
            this.engine.init(engineOpts);
        }
	}
}