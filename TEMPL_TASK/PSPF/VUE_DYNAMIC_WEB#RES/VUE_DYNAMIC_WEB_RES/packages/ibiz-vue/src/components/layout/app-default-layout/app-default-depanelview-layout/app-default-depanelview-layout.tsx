import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDEPanelView } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export class AppDefaultDePanelViewLayout extends AppDefaultViewLayout {

  /**
   * 实体面板视图模型对象
   *
   * @type {IPSAppDEPanelView}
   * @memberof AppDefaultDePanelViewLayout
   */
  @Prop() public declare viewInstance: IPSAppDEPanelView;

  /**
   * 引擎初始化
   *
   * @param {*} [opts={}]
   * @memberof AppDefaultDePanelViewLayout
   */
  public engineInit(opts: any = {}) {
    const controls: any[] = this.containerModel.getPSControls() || [];
    const panel = ModelTool.findPSControlByType('PANEL', controls);
    const engineOpts: any = {
      view: this,
      p2k: '0',
      isLoadDefault: true,
      keyPSDEField: this.appDeCodeName.toLowerCase(),
      majorPSDEField: this.appDeMajorFieldName.toLowerCase()
    }
    if (panel) {
      Object.assign(engineOpts,{
        panel: (this.$refs[panel.name] as any).ctrl
      })
    }
    this.engine.init(engineOpts);
  }

}