/**
 * 根据viewTag获取指定视图的视图数据变化状态
 * 
 * @param state 
 */
export const getStateByViewTag = (state: any) => (viewTag: string) => {
  const appView = state.appViews.find((appView: any) => Object.is(appView.viewTag, viewTag));
  if (appView) {
    return appView.viewDataChange;
  } else {
    return false;
  }
}

/**
* 根据路由路径path获取指定视图的视图数据变化状态
* 
* @param state 
*/
export const getStateByPath = (state: any) => (path: string) => {
  const appView = state.appViews.find((appView: any) => Object.is(appView.path, path));
  if (appView) {
    return appView.viewDataChange;
  } else {
    return false;
  }
}