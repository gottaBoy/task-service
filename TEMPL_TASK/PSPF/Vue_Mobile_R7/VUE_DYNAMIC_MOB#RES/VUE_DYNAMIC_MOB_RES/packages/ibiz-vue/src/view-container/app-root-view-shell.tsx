import { Component, Vue } from 'vue-property-decorator';
import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { AppServiceBase, EntityPathService, LogUtil, Util } from "ibiz-core";
import { AppViewShell } from "ibiz-vue";

/**
 * 视图壳
 *
 * @export
 * @class AppViewShell
 * @extends {Vue}
 */
@Component({})
export class AppRootViewShell extends Vue {



    created() {
        this.mountedDynaRoute(this.$router);
        if (AppServiceBase.getInstance().getRedirectedFromRoute()) {
            this.$router.push(AppServiceBase.getInstance().getRedirectedFromRoute());
        }
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
                return route.meta && route.meta.viewType && route.meta.viewType === 'ROOT';
            })
            if (indexView) {
                const indexPath: string = indexView.name;
                this.mountedAllEntityRoute(indexPath, router);
                this.mountedAllAppViewRoute(indexPath, router)
                LogUtil.log('挂载应用动态路由完成', router.getRoutes());
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
                        path: 'viewshell/' + currentPath,
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
            path: `viewshell/${Util.srfpluralize(codeName).toLowerCase()}/:${codeName.toLowerCase()}?/views/:view?`,
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

    mountedAllAppViewRoute(indexPath: string, router: any) {
        // 挂载应用视图路由
        const appRoute = {
            path: 'viewshell/views/:view?',
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
    }

    render(h: any) {
        return <router-view key={this.$route.fullPath}></router-view>
    }

}
