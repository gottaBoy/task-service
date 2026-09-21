import { IPSAppIndexView, IPSAppView, IPSSysImage, IPSLanguageRes} from '@ibiz/dynamic-model-api';
import { AppServiceBase } from 'ibiz-core';
import { Component, Emit, Prop, Watch, Inject } from 'vue-property-decorator';
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
    public viewDatasChange(val: any): any {
        return val;
    }

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppIndexViewShell
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppIndexViewShell
     */
    @Prop() public declare dynamicProps: any;

    /**
     * Vue声明周期
     *
     * @memberof AppIndexViewShell
     */
    public created() {
        let targetIndexView: IPSAppView | undefined = undefined;
        const APP = AppServiceBase.getInstance().getAppModelDataObject();
        if (APP && APP.getAllPSAppViews()) {
            // 正常启动应用首页视图 eg：http://localhost:9090
            if (!targetIndexView) {
                targetIndexView = (APP.getAllPSAppViews() as IPSAppView[]).find((view) => {
                    return view.viewType === 'APPINDEXVIEW' && (view as IPSAppIndexView).defaultPage;
                })
            }
        }
        if (!targetIndexView) {
            this.$Notice.error('未找到应用首页视图且为应用起始视图');
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
     * 视图绘制
     *
     * @memberof AppIndexViewShell
     */
    public render(h: any) {
        if (!this.viewContainerName) {
            return;
        }
        return h(this.viewContainerName, {
            props: { dynamicProps: this.dynamicProps, staticProps: this.viewContext },
            on: {
                'view-event': this.handleViewEvent.bind(this)
            }
        })
    }

}
