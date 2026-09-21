import { LogUtil, ViewTool } from 'ibiz-core';
import qs from 'qs';
import { Vue, Prop, Component, Watch } from 'vue-property-decorator';
import { ViewCacheService } from '../../../app-service';
/**
 * 导航占位
 *
 * @export
 * @class AppNavPos
 * @extends {Vue}
 */
@Component({})
export class AppNavPos extends Vue {

    /**
     * 动态导航模式（DYNAMICCOMP：动态组件 ROUTEVIEW：路由出口）
     *
     * @public
     * @type {'DYNAMICCOMP' | 'ROUTEVIEW'}
     * @memberof AppNavPos
     */
    @Prop({ default: 'ROUTEVIEW' }) public dynaNavMode?: 'DYNAMICCOMP' | 'ROUTEVIEW';

    /**
     * 是否启用动态缓存
     *
     * @type {boolean}
     * @memberof AppNavPos
     */
    @Prop({ default: false }) public enableCache?: boolean;

    /**
     * 导航数据
     *
     * @type {*}
     * @memberof AppNavPos
     */
    @Prop() public navData?: any;

    /**
     * 监听enableCache
     *
     * @memberof AppNavPos
     */
    @Watch('enableCache', { immediate: true })
    enableCacheChange() {
        ViewCacheService.enableCache = this.enableCache || false;
    }

    /**
     * 路由列表
     *
     * @memberof AppNavPos
     */
    get routerList() {
        let historyPathList: string[] = [];
        if (this.$store.state.historyPathList && this.$store.state.historyPathList.length > 0) {
            this.$store.state.historyPathList.forEach((historyPath: string) => {
                if (historyPath && historyPath.indexOf('?') > -1) {
                    const { startPath, viewParams } = ViewTool.getViewParamsByPath(historyPath);
                    delete viewParams.srfnav;
                    // 除srfnav外还有其他参数
                    if (Object.keys(viewParams).length > 0) {
                        const tempPath = `${startPath}?${encodeURIComponent(qs.stringify(viewParams, { delimiter: ';' }))}`;
                        if (!historyPathList.includes(tempPath)) {
                            historyPathList.push(tempPath);
                        }
                    } else {
                        if (!historyPathList.includes(startPath)) {
                            historyPathList.push(startPath);
                        }
                    }
                } else {
                    if(!historyPathList.includes(historyPath)){
                        historyPathList.push(historyPath);
                    }
                }
            });
        }
        return historyPathList;
    }

    /**
     * 路由键值
     *
     * @memberof AppNavPos
     */
    get routerViewKey() {
        let _this: any = this;
        let activedPath = _this.$route.fullPath;
        if (activedPath && activedPath.indexOf('?') > -1) {
            const {startPath, viewParams} = ViewTool.getViewParamsByPath(activedPath);
            if (viewParams.hasOwnProperty('srfnav')) {
                delete viewParams.srfnav;
                if (Object.keys(viewParams).length > 0) {
                    activedPath = `${startPath}?${encodeURIComponent(qs.stringify(viewParams, { delimiter: ';' }))}`;
                } else {
                    activedPath = startPath;
                }
                
            }
        }
        return activedPath;
    }

    /**
     * 执行视图事件
     *
     * @param {*} args
     * @memberof AppNavPos
     */
    public handleViewEvent(args: any) {
        LogUtil.log(args);
    }

    /**
     * 绘制内容
     *
     * @memberof AppNavPos
     */
    public render(): any {
        return (
            <div class="app-nav-pos">
                {
                    // 路由出口
                    Object.is(this.dynaNavMode, 'ROUTEVIEW') ?
                        this.enableCache ?
                            [
                                <app-keep-alive routerList={this.routerList}>
                                    <router-view key={this.routerViewKey}></router-view>
                                </app-keep-alive>,
                                <app-view-cache></app-view-cache>
                            ] :
                            <router-view key={this.routerViewKey}></router-view> :
                        // 动态组件
                        this.navData ? this.$createElement('app-view-shell', {
                            key: this.navData?.context.viewpath,
                            props: {
                                staticProps: {
                                    viewDefaultUsage: false
                                },
                                dynamicProps: {
                                    viewdata: JSON.stringify(this.navData.context),
                                    viewparam: JSON.stringify(this.navData.viewparams)
                                }
                            },
                            class: "view-container2",
                            on: {
                                viewdataschange: this.handleViewEvent.bind(this),
                                viewLoaded: this.handleViewEvent.bind(this),
                                viewstatechange: this.handleViewEvent.bind(this)
                            }
                        }) : null
                }
            </div>
        )
    }
}