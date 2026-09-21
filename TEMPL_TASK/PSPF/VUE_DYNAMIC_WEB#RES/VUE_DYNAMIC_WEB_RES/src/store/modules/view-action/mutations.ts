/**
 * 根据viewTag删除视图
 * 
 * @param state 
 * @param viewTag  视图viewTag
 */
export const removeViewByViewTag = (state: any, viewTag: string) => {
    const index = state.appViews.findIndex((appView: any) => Object.is(appView.viewTag, viewTag));
    if (index !== -1) {
      state.appViews.splice(index, 1);
    }
}

/**
 * 根据路由path删除视图
 * 
 * @param state 
 * @param path  视图路由
 */
export const removeViewByPath = (state: any, path: string) => {
  const index = state.appViews.findIndex((appView: any) => Object.is(appView.path, path));
  if (index !== -1) {
    state.appViews.splice(index, 1);
  }
}

/**
 * 设置视图数据变化状态
 * 
 * @param state 
 * @param param { viewTag, viewDataChange } (视图viewTag， 视图数据改变)
 */
export const setViewDataChange = (state: any, { viewTag, viewDataChange }: { viewTag: string, viewDataChange: boolean }) => {
    const appView = state.appViews.find((appView: any) => Object.is(appView.viewTag, viewTag));
    if (appView) {
      appView.viewDataChange = viewDataChange;
    } else {
      state.appViews.push({ viewTag, viewDataChange })
    }
}

/**
 * 初始化appViews集合
 * 
 * @param state 
 * @param param { viewTag, path } (视图viewTag, 路由路径)
 */
export const initAppViews = (state: any, { viewTag, path }: { viewTag: string, path: string }) => {
    const appView = state.appViews.find((appView: any) => Object.is(appView.viewTag, viewTag)); 
    if (appView) {
      appView.path = path;
    } else {
      state.appViews.push({ viewTag, path })
    }
}
