import { EleSelector, LogUtil } from 'ibiz-core';
import { AppDEUIAction } from './app-ui-action';

export class AppCustomAction extends AppDEUIAction {

  /**
   * 初始化AppCustomAction
   *
   * @memberof AppCustomAction
   */
  constructor(opts: any, context?: any) {
    super(opts, context);
  }

  /**
   * 执行界面行为
   *
   * @param args
   * @param context
   * @param params
   * @param $event
   * @param xData
   * @param actionContext
   * @param srfParentDeName
   *
   * @memberof AppCustomAction
   */
  public async execute(
    args: any[],
    context: any = {},
    params: any = {},
    $event?: any,
    xData?: any,
    actionContext?: any,
    srfParentDeName?: string,
    deUIService?: any,
  ) {
    // 自定义脚本
    if (this.actionModel && this.actionModel.scriptCode) {
      // 准备自定义脚本数据(context:应用上下文，params：视图参数，data：业务数据)
      const data = args;
      const eleSelector = new EleSelector(actionContext);
      const selector = eleSelector.selector.bind(eleSelector);
      const viewselector = eleSelector.viewSelector.bind(eleSelector);
      const appselector = eleSelector.appSelector.bind(eleSelector);
      eval(this.actionModel.scriptCode);
    } else {
      LogUtil.warn(`自定义界面行为暂未实现`);
    }
  }

}
