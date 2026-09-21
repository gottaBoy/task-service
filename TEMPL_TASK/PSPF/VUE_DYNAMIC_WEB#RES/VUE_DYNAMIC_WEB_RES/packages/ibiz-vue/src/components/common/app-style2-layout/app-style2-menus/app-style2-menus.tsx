import { Vue, Component, Prop, Emit, Watch } from 'vue-property-decorator';
import { UIStateService } from '../../../../app-service';

/**
 * 左侧导航菜单
 *
 * @export
 * @class AppStyle2Menus
 * @extends {Vue}
 */
@Component({})
export class AppStyle2Menus extends Vue {
    /**
     * UI状态服务
     *
     * @protected
     * @type {UIStateService}
     * @memberof AppStyle2Menus
     */
    protected uiState: UIStateService = new UIStateService();

    /**
     * 当前激活项
     *
     * @protected
     * @type {*}
     * @memberof AppStyle2Menus
     */
    protected activeItem: any = {};

    /**
     * 菜单Map表
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof AppStyle2Menus
     */
    protected menuMap: Map<string, any> = new Map();

    /**
     * 部件名称
     *
     * @type {string}
     * @memberof AppStyle2Menus
     */
    @Prop()
    public ctrlName!: string;

    /**
     * 菜单数据
     *
     * @type {any[]}
     * @memberof AppStyle2Menus
     */
    @Prop({ default: () => [] })
    public menus!: any[];

    /**
     * 模型服务对象
     * 
     * @memberof AppStyle2DefaultLayout
     */
     @Prop() public modelService!:any;

    /**
     * 监控菜单数据变更
     *
     * @memberof AppStyle2Menus
     */
    @Watch('menus', { immediate: true })
    public watchMenus(): void {
        this.fillMenuMap(this.menus);
    }

    /**
     * 菜单项点击
     *
     * @param {*} item
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    @Emit('menu-click')
    public menuClick(item: any): any {}

    /**
     * 底部绘制实例
     *
     * @memberof AppStyle2Menus
     */
    public footerRenderItem!: any;

    /**
     * 组件创建完毕
     *
     * @memberof AppStyle2Menus
     */
    public created(): void {
        if (this.$route && this.$route.matched.length === 1) {
            this.openDefault();
        }
        this.footerRenderItem = this.$footerRenderService.registerLeftItem((h: any) => {
            return (
                <icon
                    title={this.uiState.layoutState.leftNavMenuCollapse ? this.$t('components.content.open') : this.$t('components.content.close')}
                    type="md-menu"
                    style="font-size: 20px;vertical-align: -3px;"
                    on-click={() => this.uiState.leftNavMenuCollapseChange()}
                />
            );
        }, 0);
    }

    /**
     * 组件销毁
     *
     * @memberof AppStyle2Menus
     */
    public destroyed(): void {
        this.footerRenderItem?.remove();
    }

    /**
     * 打开默认菜单
     *
     * @protected
     * @memberof AppStyle2Menus
     */
    protected openDefault(): void {
        let menu: any;
        for (const [key, item] of this.menuMap) {
            if (item.openDefault === true) {
                menu = item;
                break;
            }
        }
        if (menu) {
            this.itemClick(menu);
        }
    }

    /**
     * 菜单项点击
     *
     * @protected
     * @param {*} item
     * @memberof AppContentLeftExp
     */
    protected itemClick(item: any): void {
        const styleMode: any = this.$uiState.layoutState.styleMode;
        if ((Object.is(styleMode,'DEFAULT') && item.name !== this.activeItem.name) || Object.is(styleMode,'STYLE2')) {
            this.changeActiveItem(item);
            this.menuClick(item);
        } 
    }

    /**
     * 改变激活项
     *
     * @protected
     * @param {*} item
     * @memberof AppContentLeftExp
     */
    protected changeActiveItem(item: any): void {
        this.activeItem = item;
        this.activeItem.isActivated = true;
    }

    /**
     * 菜单项选中
     *
     * @protected
     * @param {string} name
     * @memberof AppStyle2Menus
     */
    protected select(name: string): void {
        const item = this.menuMap.get(name);
        if (item) {
            this.itemClick(item);
        }
    }

    /**
     * 填充菜单Map表
     *
     * @protected
     * @param {any[]} menus
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    protected fillMenuMap(menus: any[]): any {
        menus.forEach((item: any) => {
            this.menuMap.set(item.name, item);
            if (item.getPSAppMenuItems) {
                this.fillMenuMap(item.getPSAppMenuItems);
            }
        });
    }

    /**
     * 展开菜单项
     *
     * @protected
     * @param {string} name
     * @memberof AppStyle2Menus
     */
    protected open(name: string): void {
        const i: number = this.uiState.layoutState.leftNavOpenedMenus.findIndex((str: any) => Object.is(str, name));
        if (i === -1) {
            this.uiState.layoutState.leftNavOpenedMenus.push(name);
        }
    }

    /**
     * 收起菜单项
     *
     * @protected
     * @param {string} name
     * @memberof AppStyle2Menus
     */
    protected close(name: string): void {
        const i: number = this.uiState.layoutState.leftNavOpenedMenus.findIndex((str: any) => Object.is(str, name));
        if (i !== -1) {
            this.uiState.layoutState.leftNavOpenedMenus.splice(i, 1);
            this.$forceUpdate();
        }
    }

    /**
     * 绘制子菜单
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    protected renderGroup(item: any): any {
        return (
            <el-submenu index={item.name}>
                <template slot="title">
                    <menu-icon item={item} />
                    <span slot="title">{this.$tl(item.captionTag,item.caption)}</span>
                </template>
                {this.renderItems(item.getPSAppMenuItems)}
            </el-submenu>
        );
    }

    /**
     * 绘制菜单项
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    protected renderItem(item: any): any {
        return (
            <el-menu-item class="app-style2-menus__item" index={item.name}>
                <menu-icon item={item} />
                <span slot="title">{this.$tl(item.captionTag,item.caption)}</span>
            </el-menu-item>
        );
    }

    /**
     * 绘制菜单
     *
     * @protected
     * @param {any[]} items
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    protected renderItems(items: any[]): any {
        return items.map((item: any) => {
            if (item.hidden) {
                return;
            }
            if (item.getPSAppMenuItems) {
                return this.renderGroup(item);
            }
            return this.renderItem(item);
        });
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppStyle2Menus
     */
    public render(): any {
        return <el-menu
                class="app-style2-menus"
                default-active={this.activeItem.name}
                default-openeds={this.uiState.layoutState.leftNavOpenedMenus}
                collapse={this.uiState.layoutState.leftNavMenuCollapse}
                on-select={(i: any) => this.select(i)}
                on-open={(i: any) => this.open(i)}
                on-close={(i: any) => this.close(i)}
            >
                {this.renderItems(this.menus)}
            </el-menu>
    }
}
