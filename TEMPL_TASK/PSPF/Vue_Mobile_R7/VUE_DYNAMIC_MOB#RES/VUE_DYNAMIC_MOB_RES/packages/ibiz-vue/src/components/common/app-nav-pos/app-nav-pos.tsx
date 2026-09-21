import { LogUtil, Util } from 'ibiz-core';
import { Vue, Prop, Component } from 'vue-property-decorator';
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
    @Prop({ default: 'DYNAMICCOMP' }) public dynaNavMode?: 'DYNAMICCOMP' | 'ROUTEVIEW';

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
     * 路由键值
     * 
     * @memberof AppNavPos 
     */
    get routerViewKey() {
        let _this: any = this;
        return _this.$route.fullPath;
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
                        <router-view key={this.routerViewKey}></router-view>:
                        // 动态组件
                        this.navData ? this.$createElement('app-view-shell', {
                            key: Util.createUUID(),
                            props: {
                                staticProps: {
                                    viewDefaultUsage: 'INCLUDEDVIEW'
                                },
                                dynamicProps: {
                                    _context: JSON.stringify(this.navData.context),
                                    _viewparams: JSON.stringify(this.navData.viewparams)
                                }
                            },
                            on: {
                                viewdataschange: this.handleViewEvent.bind(this),
                                viewstatechange: this.handleViewEvent.bind(this)
                            }
                        }) : null
                }
            </div>
        )
    }
}