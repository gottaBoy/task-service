import { IPSAppDataEntity, IPSAppIndexView, IPSAppView, IPSLanguageRes, IPSSysImage } from '@ibiz/dynamic-model-api';
import { AppServiceBase, EntityPathService, LogUtil, ModelTool, Util } from 'ibiz-core';
import qs from 'qs';
import { isNilOrEmpty } from 'qx-util';
import { Component, Emit, Prop } from 'vue-property-decorator';
import { AppViewShell } from './app-view-shell';
import { ViewContainerBase } from './view-container-base';

/**
 * 视图壳
 *
 * @export
 * @class AppIndexViewShell
 * @extends {ViewContainerBase}
 */
@Component({})
export class AppIndexViewShell extends ViewContainerBase {
  /**
   * 数据变化
   *
   * @param {*} val
   * @returns {*}
   * @memberof AppIndexViewShell
   */
  @Emit()
  viewDatasChange(val: any): any {
    return val;
  }

  /**
   * 视图静态参数
   *
   * @type {string}
   * @memberof AppIndexViewShell
   */
  @Prop() declare staticProps: any;

  /**
   * 视图动态参数
   *
   * @type {string}
   * @memberof AppIndexViewShell
   */
  @Prop() declare dynamicProps: any;

  /**
   * 组件初始化
   *
   * @memberof AppIndexViewShell
   */
  created() {
    // 挂载动态路由
    this.mountedDynaRoute(this.$router);
    // 跳转重定向来源路由
    let redirectUrl = AppServiceBase.getInstance().getRedirectedFromRoute();
    if (redirectUrl) {
      // 全局重定向跳转(对路径做处理)
      const tempViewParam = this.parseViewParam(redirectUrl);
      if(tempViewParam.redirectType && Object.is(tempViewParam.redirectType,'APPREDIRECT') && tempViewParam.redirectDEName){
        const redirectCodeName = ModelTool.getAppEntityCodeNameByName(tempViewParam.redirectDEName);
        if(redirectCodeName !== tempViewParam.redirectDEName){
          redirectUrl = redirectUrl.replace(Util.srfpluralize(tempViewParam.redirectDEName),Util.srfpluralize(redirectCodeName));
        }
      }
      this.$router.push(redirectUrl);
    }
    const currentParams = this.$route.params;
    let targetIndexView: IPSAppView | undefined = undefined;
    const APP = AppServiceBase.getInstance().getAppModelDataObject();
    if (APP && APP.getAllPSAppViews()) {
      // 多首页 eg：http://localhost:9090/#/index/initiateindexview
      if (currentParams && currentParams.index) {
        targetIndexView = (APP.getAllPSAppViews() as IPSAppView[]).find((view: IPSAppView) => {
          if (view.refM && view.refM.viewType && view.refM.path) {
            return view.refM.viewType === 'APPINDEXVIEW' && view.refM.path.toLowerCase().endsWith(`${currentParams.index}.json`);
          } else {
            return view.viewType === 'APPINDEXVIEW' && view.codeName.toLowerCase() === currentParams.index;
          }
        });
      }
      // 正常启动应用首页视图 eg：http://localhost:9090
      if (!targetIndexView) {
        targetIndexView = (APP.getAllPSAppViews() as IPSAppView[]).find((view) => {
          return view.viewType === 'APPINDEXVIEW' && (view as IPSAppIndexView).defaultPage;
        })
      }
    }
    if (!targetIndexView) {
      this.$throw('未找到应用首页视图且为应用起始视图');
    } else {
      // 计算首页动态模型地址及加载模型数据
      targetIndexView.fill().then((indexView: any) => {
        const indexRoute = this.$router.getRoutes().find((route: any) => {
          return route.name === 'index';
        })
        if (indexRoute && indexRoute.meta) {
          if (indexView.caption) {
            indexRoute.meta.caption = indexView.caption;
          }
          if (indexView.getCapPSLanguageRes()) {
            indexRoute.meta.captionTag = (indexView.getCapPSLanguageRes() as IPSLanguageRes).lanResTag;
          }
          if (indexView.getPSSysImage()) {
            indexRoute.meta.imgPath = (indexView.getPSSysImage() as IPSSysImage).imagePath;
            indexRoute.meta.iconCls = (indexView.getPSSysImage() as IPSSysImage).cssClass;
          }
        }
        this.dynaModelFilePath = indexView.modelPath as string;
        this.loadDynamicModelData();
      })
    }
  }

  /**
   * @description 视图销毁
   * @memberof AppIndexViewShell
   */
  destroyed() {
    super.destroyed();
  }

  /**
   * 处理路径数据
   *
   * @param {*} [urlStr] 路径
   *
   * @memberof AppIndexViewShell
   */
  public parseViewParam(urlStr: string): any {
    let tempViewParam: any = {};
    const tempViewparam: any = urlStr.slice(urlStr.lastIndexOf('?') + 1);
    const viewparamArray: Array<string> = decodeURIComponent(tempViewparam).split(';');
    if (viewparamArray.length > 0) {
      viewparamArray.forEach((item: any) => {
        Object.assign(tempViewParam, qs.parse(item));
      });
    }
    return tempViewParam;
  }

  /**
   * 挂载动态路由
   *
   * @param {*} router 路由对象
   * @memberof AppIndexViewShell
   */
  public mountedDynaRoute(router: any) {
    if (router && router.getRoutes().length > 0) {
      const indexView = router.getRoutes().find((route: any) => {
        return route.meta && route.meta.viewType && route.meta.viewType === 'APPINDEX';
      })
      if (indexView) {
        const indexPath: string = indexView.name;
        this.mountedAllEntityRoute(indexPath, router);
        // 挂载应用视图路由
        const appRoute = {
          path: 'views/:view?',
          meta: {
            captionTag: '',
            caption: '',
            info: '',
            imgPath: '',
            iconCls: '',
            parameters: [
              { pathName: indexPath, parameterName: indexPath },
              { pathName: 'views', parameterName: 'view' },
            ],
            requireAuth: false,
          },
          component: AppViewShell,
        }
        router.addRoute(indexPath, appRoute);
        LogUtil.log('挂载应用动态路由完成');
      }
    }
  }

  /**
   * 挂载所有应用实体映射路由
   *
   * @param {string} indexPath 首页路径
   * @param {*} router 路径对象
   * @memberof AuthGuard
   */
  public mountedAllEntityRoute(indexPath: string, router: any) {
    const APP = AppServiceBase.getInstance().getAppModelDataObject();
    if (APP.getAllPSAppDataEntities() && (APP.getAllPSAppDataEntities() as IPSAppDataEntity[]).length > 0) {
      (APP.getAllPSAppDataEntities() as IPSAppDataEntity[]).forEach((appDataEntity: IPSAppDataEntity) => {
        let codeName: string = '';
        if (appDataEntity.refM && appDataEntity.refM.codeName) {
          codeName = appDataEntity.refM.codeName;
        } else {
          codeName = appDataEntity.codeName;
        }
        const resPaths = new EntityPathService(codeName).getPSAppDERSPaths();
        this.mountedSingleEntityRoute(indexPath, router, codeName, resPaths);
      })
    }
  }

  /**
   * 初始化单个应用实体映射路由
   *
   * @param {string} indexPath 首页路径
   * @param {*} router 路径对象
   * @param {string} codeName 当前应用实体代码名称
   * @param {string[][]} resPaths 当前应用实体关联路径
   * @memberof AuthGuard
   */
  public mountedSingleEntityRoute(indexPath: string, router: any, codeName: string, resPaths: string[][]) {
    // 挂载关系路由
    if (resPaths && resPaths.length > 0) {
      resPaths.forEach((singleResPaths: string[]) => {
        if (singleResPaths && singleResPaths.length > 0) {
          let currentPath: string = '';
          let currentParameters: any = [
            { pathName: indexPath.toLowerCase(), parameterName: indexPath.toLowerCase() }
          ];
          singleResPaths.forEach((resPath: string) => {
            currentPath += `/${Util.srfpluralize(resPath).toLowerCase()}/:${resPath.toLowerCase()}?`;
            currentParameters.push({ pathName: Util.srfpluralize(resPath).toLowerCase(), parameterName: resPath.toLowerCase() });
          })
          currentPath = `${currentPath.slice(1)}/${Util.srfpluralize(codeName).toLowerCase()}/:${codeName.toLowerCase()}?/views/:view?`;
          currentParameters.push({ pathName: Util.srfpluralize(codeName).toLowerCase(), parameterName: codeName.toLowerCase() }, { pathName: 'views', parameterName: 'view' });
          const route = {
            path: currentPath,
            meta: {
              captionTag: '',
              caption: '',
              info: '',
              imgPath: '',
              iconCls: '',
              parameters: currentParameters,
              resource: codeName.toLowerCase(),
              requireAuth: false,
            },
            component: AppViewShell
          }
          router.addRoute(indexPath, route);
        }
      })
    }
    // 挂载自身路由
    const route = {
      path: `${Util.srfpluralize(codeName).toLowerCase()}/:${codeName.toLowerCase()}?/views/:view?`,
      meta: {
        captionTag: '',
        caption: '',
        info: '',
        imgPath: '',
        iconCls: '',
        parameters: [
          { pathName: indexPath.toLowerCase(), parameterName: indexPath.toLowerCase() },
          { pathName: Util.srfpluralize(codeName).toLowerCase(), parameterName: codeName.toLowerCase() },
          { pathName: 'views', parameterName: 'view' },
        ],
        resource: codeName.toLowerCase(),
        requireAuth: false,
      },
      component: AppViewShell
    }
    router.addRoute(indexPath, route);
  }

  /**
   * 绘制
   *
   * @param {*} h
   * @return {*} 
   * @memberof AppIndexViewShell
   */
  render(h: any) {
    if (isNilOrEmpty(this.viewContainerName)) {
      return;
    }
    return h(this.viewContainerName, {
      props: { dynamicProps: this.dynamicProps, staticProps: this.viewContext },
      on: {
        'view-event': this.handleViewEvent.bind(this),
      },
    });
  }
}