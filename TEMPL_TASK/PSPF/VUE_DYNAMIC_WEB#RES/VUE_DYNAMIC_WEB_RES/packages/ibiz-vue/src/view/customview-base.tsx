import { IPSAppDataEntity, IPSAppDECustomView, IPSAppDEField, IPSAppViewEngine, IPSControl } from '@ibiz/dynamic-model-api';
import { CustomViewInterface, ModelTool } from 'ibiz-core';
import { MainViewBase } from "./mainview-base";

/**
 * 自定义视图基类
 *
 * @export
 * @class CustomViewBase
 * @extends {MainViewBase}
 * @implements {CustomViewInterface}
 */
export class CustomViewBase extends MainViewBase implements CustomViewInterface {

  /**
   * 视图实例
   * 
   * @memberof CustomViewBase
   */
  public declare viewInstance: IPSAppDECustomView;

  /**
   * 引擎初始化
   *
   * @param {*} [opts={}] 引擎参数
   * @memberof CustomViewBase
   */
  public engineInit(opts: any = {}): void {
    if (this.Environment && this.Environment.isPreviewMode) {
      return;
    }
    const engineOptions: any = {
      view: this,
      keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
      majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase()
    };
    if (this.viewInstance.getPSControls() && (this.viewInstance.getPSControls() as IPSControl[]).length > 0) {
      const ctrlArray: Array<any> = [];
      (this.viewInstance.getPSControls() as IPSControl[]).forEach((item: IPSControl) => {
        if (!Object.is(item.controlType, 'TOOLBAR')) {
          ctrlArray.push({ name: item.name, ctrl: (this.$refs[item.name] as any).ctrl });
        }
      })
      Object.assign(engineOptions, { ctrl: ctrlArray });
    }
    if (this.viewInstance.getPSAppViewEngines() && (this.viewInstance.getPSAppViewEngines() as IPSAppViewEngine[]).length > 0) {
      const engineArray: Array<any> = [];
      (this.viewInstance.getPSAppViewEngines() as IPSAppViewEngine[]).forEach((item: IPSAppViewEngine) => {
        if (Object.is(item.engineCat, 'CTRL')) {
          engineArray.push(item.M);
        }
      })
      Object.assign(engineOptions, { engine: engineArray });
    }
    this.engine.init(engineOptions);
  }

}
