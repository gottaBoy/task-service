import { Util, LogUtil, throttle  } from 'ibiz-core';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { AppMenuControlBase } from '../../../widgets';

/**
 * 应用菜单部件基类
 *
 * @export
 * @class AppmenuBase
 * @extends {AppMenuControlBase}
 */
export class AppmenuBase extends AppMenuControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppmenuBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppmenuBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppmenuBase
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppmenuBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * @description 监听路由变化
     * @date 2023/08/03 16:08:40
     * @param {*} newVal
     * @memberof AppmenuBase
     */
    @Watch('$route')
    public onRouteChange(newVal: any) {
        const {fullPath} = newVal;
        if(fullPath){
        const menuname = this.menuActiveMap[fullPath]
        if(menuname){
            this.defaultActive = menuname;
        }else{
            this.menuActiveMap[fullPath] = this.defaultActive;
        }
        }
    }

    /**
     * @description 菜单激活Map
     * @date 2023/08/03 14:08:16
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public menuActiveMap: any = {};

    /**
     * 销毁视图回调
     *
     * @memberof AppmenuBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 左侧应用菜单的右侧视图组件
     *
     * @type {*} 
     * @memberof AppmenuBase
     */
    public renderRightView: any;

    /**
     * 左侧应用菜单分割面板比例
     *
     * @type {number}
     * @memberof AppmenuBase
     */
    public split: number = 0.15;

    /**
     * 配置左侧分页菜单默认选项
     *
     * @return {*}
     * @memberof AppmenuBase
     */
     public defaultMuneOption(menus: any[]): any {
        return menus[0]?.getPSAppMenuItems?.[0];
    }
    /**
     * 顶部菜单项选中
     *
     * @param {string} item
     * @memberof AppmenuBase
     */
     public topMenuSelected(name: string) {
        this.menus.forEach(menu1 => {
            if (menu1.name == name) {
                return this.menuTreeClick(menu1);
            } else {
                const children = menu1.getPSAppMenuItems || [];
                if (children.length > 0) {
                    children.forEach((menu2: any) => {
                        if (menu2?.name == name) {
                            return this.menuTreeClick(menu2);
                        }
                    });
                }
            }
        });
    }

    /**
     * 初始化部件的绘制参数
     *
     * @type {Array<*>}
     * @memberof ViewBase
     */
    public initRenderOptions(opts?: any) {
        this.renderOptions = {};
        const { controlType, codeName } = this.controlInstance;
        const sysCss = this.controlInstance.getPSSysCss();
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        Object.assign(controlClassNames, opts);
        if (sysCss) {
            Object.assign(controlClassNames, { [sysCss.cssName]: true });
        }
        // 应用首页菜单方向
        if (this.staticProps.mode) {
            Object.assign(controlClassNames, { [`app-control-menu--${this.staticProps.mode.toLowerCase()}`]: true });
        } else {
            Object.assign(controlClassNames, { [`app-control-menu--left`]: true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }

    /**
     * 加载菜单的默认点击
     *
     * @memberof AppmenuBase
     */
     public async defaultMenuSelect(): Promise<void> {
         //分页导航菜单的默认点击
        if(Object.is(this.staticProps.mode, ("TABEXP_LEFT"||'TABEXP_TOP'||'TABEXP_RIGHT'||'TABEXP_BOTTOM'))){
            return this.menuTreeClick(this.defaultMuneOption(this.menus))
        }
        if (!this.isDefaultPage || this.isBlankMode) {
            return;
        }
        const appFuncs: Array<any> = this.service.getAllFuncs();
        if (this.$route && this.$route.matched && this.$route.matched.length == 2) { // 存在二级路由
            const [{ }, matched] = this.$route.matched;
            const appfunc: any = appFuncs.find((_appfunc: any) => Object.is(_appfunc.routepath, matched.path) && Object.is(_appfunc.appfunctype, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            }
            return;
        } else if (this.defPSAppView && Object.keys(this.defPSAppView).length > 0) { // 存在默认视图
            const appfunc: any = appFuncs.find((_appfunc: any) => Object.is(_appfunc.getPSAppView?.codeName, this.defPSAppView?.codeName) && Object.is(_appfunc.appFuncType, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            } 
            if (!this.defaultActive && Object.is(this.staticProps.mode, "NONE")) {
              const deResParameters: any[] = [];
              const parameters: any[] = [];
              await this.processingParameter(this.context, this.defPSAppView, deResParameters, parameters);
              const path: string = this.$viewTool.buildUpRoutePath(this.$route, this.context, deResParameters, parameters, [], this.viewparams);
              this.$router.push(path);
              return;
            } 
        } else {
            this.computeMenuSelect(this.menus, '');
        }
        let item = this.compute(this.menus, this.defaultActive);
        if (Object.keys(item).length === 0) {
            return;
        }
        if(!item.hidden){
            this.click(item);
        }
    }
    
    /**
     * @description 整合参数
     * @param {*} context
     * @param {*} appView
     * @param {any[]} deResParameters
     * @param {any[]} parameters
     * @return {*} 
     * @memberof AppmenuBase
     */
    public async processingParameter(context: any, appView: any, deResParameters: any[], parameters: any[]) {
      let params = [];
      await appView.fill?.();
      if (appView.getPSAppDataEntity()) {
          await appView.getPSAppDataEntity().fill?.();
          params = [
            {
                pathName: Util.srfpluralize(appView.getPSAppDataEntity().codeName)?.toLowerCase(),
                parameterName: appView.getPSAppDataEntity().codeName?.toLowerCase(),
            },
            { pathName: 'views', parameterName: appView.getPSDEViewCodeName().toLowerCase() },
          ];
      } else {
          params = [{ pathName: 'views', parameterName: appView.name.toLowerCase() }];
      }
      Object.assign(parameters, params);
    }

    /**
     * 左侧菜单点击
     *
     * @param {*} item ***对象
     * @memberof AppmenuBase
     */
    public menuTreeClick(item: any) {
        let tempContext: any = Util.deepCopy(this.context);
        if (item.getPSNavigateContexts) {
            const localContext = Util.formatNavParam(item.getPSNavigateContexts);
            Object.assign(tempContext, localContext);
        } else {
            if (tempContext.hasOwnProperty("srfdynainstid")) {
                delete tempContext.srfdynainstid;
            }
        }
        this.handleCtrlEvents('onclick', { action: 'MenuTreeClick', navContext: tempContext, data: item }).then((res: boolean) => {
            if (res) {
                if (item.getPSAppFunc) {
                    const appFuncs: Array<any> = this.service.getAllFuncs();
                    const appFunc = appFuncs.find((element:any) =>{
                        return element.appfunctag === item.getPSAppFunc.codeName;
                    });
                    if (appFunc && appFunc.getPSAppView) {
                        Object.assign(tempContext,{ viewpath: appFunc.getPSAppView._modelFilePath });
                        let targetCtrlParam: any = {
                            staticProps: {
                                viewDefaultUsage: false,
                            },
                            dynamicProps: {
                                viewparam: {},
                                viewdata: JSON.stringify(tempContext),
                            }
                        };
                        this.renderRightView = this.$createElement('app-view-shell', {
                            key: Util.createUUID(),
                            class: "view-container2",
                            props: targetCtrlParam,
                        });
                        this.$forceUpdate();
                    }
                } else {
                    LogUtil.warn(this.$t('app.commonwords.noassign'));
                }
            }
        });
    }

    /**
     * 左侧应用菜单树绘制事件
     *
     * @param {*} h
     * @param {*} { node, data }
     * @return {*} **node
     * @memberof AppmenuBase
     */
    public menuTreeload(h: any, { node, data }: any) {
        if (data.hidden) {
          return null
        }
        if (data.getPSAppMenuItems && data.getPSAppMenuItems.length > 0) {
            return (
                <div class="app-control-menu-tree-item__parent">
                    <span class='parent__icon'><i class="el-icon-s-claim" size="14"/></span>
                    <span class='parent__text' title={node.data.caption}>{node.data.caption}</span>
                    <i class={{ 'el-icon-arrow-right': true, 'expanded': node.expanded }} size="14"/>
                </div>
            )
        } else {
            return (
                <div class="app-control-menu-tree-item__leaf">
                    <span title={node.data.caption}>{node.data.caption}</span>
                    <badge count={this.counterdata ? this.counterdata[data.counterid] : null} overflow-count={9999}></badge>
                </div>
            )
        }

    }
    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppmenuBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制菜单项
     * 
     * @param   menu 同一级菜单
     * @param   isFirst 是否为一级菜单
     * @memberof AppmenuBase
     */
    public renderMenuItem(menu: any, isFirst: boolean) {
        let hasIcon: boolean = menu.getPSSysImage?.imagePath || menu.getPSSysImage?.cssClass || (!menu.getPSSysImage && isFirst) ? true : false;
        return (
            (Object.is(menu.itemType, 'MENUITEM') && !menu.hidden) ?
                <el-menu-item
                    key={Util.createUUID()}
                    index={menu.name}
                    disabled={!menu.getPSAppFunc}
                    class={[{ 'is-first': isFirst }, menu.getPSSysCss?.cssName, 'app-control-menu__item']}>
                    {menu.getPSSysImage?.imagePath ? <img class='app-control-menu__item__icon' src={menu.getPSSysImage.imagePath} /> : null}
                    {menu.getPSSysImage?.cssClass ? <i class={[menu.getPSSysImage.cssClass, 'app-control-menu__item__icon']}></i> : null}
                    {(!menu.getPSSysImage && isFirst) ? <i class='fa fa-cogs app-control-menu__item__icon'></i> : null}
                    {
                        isFirst && this.collapseChange ?
                            <span ref="circleText" class={{'app-control-menu__item__caption': true, 'app-control-menu__item--circle': this.collapseChange && isFirst, 'no-icon': !hasIcon }} title={this.$tl(menu.tooltipTag,menu.tooltip)}>
                                {this.$tl(menu.captionTag,menu.caption).slice(0, 1)}
                            </span> : null
                    }
                    <template slot="title">
                        <span class={{'app-control-menu__item__caption': true, 'app-control-menu__item--circle': this.collapseChange && isFirst, 'no-icon': !hasIcon }} title={this.$tl(menu.tooltipTag,menu.tooltip)}>
                            {this.$tl(menu.captionTag,menu.caption)}
                        </span>
                        {
                            this.counterdata ?
                                <span v-badge={{count: this.counterdata[menu.counterid], offset: [4,24]}}>
                                </span> : null
                        }
                    </template>
                </el-menu-item> : (Object.is(menu.itemType, 'SEPERATOR') && !menu.hidden) ? <divider /> : null
        );
    }

    /**
     * 绘制子菜单
     * 
     * @param   menus 同一级菜单
     * @param   isFirst 是否为一级菜单
     * @memberof AppmenuBase
     */
    public renderSubmenu(menus: any, isFirst: boolean) {
        let hasIcon: boolean = menus.getPSSysImage?.imagePath || menus.getPSSysImage?.cssClass || (!menus.getPSSysImage && isFirst) ? true : false;
        return (
            !menus.hidden ?
                <el-submenu
                    key={Util.createUUID()}
                    index={menus.name}
                    class={[menus.getPSSysCss?.cssName, 'app-control-menu__item', { 'isCollpase': this.collapseChange && isFirst }, { 'isFirst': isFirst }]}
                    popper-class={this.popperClass()}>
                    <template slot='title'>
                        {menus.getPSSysImage?.imagePath ? <img class='app-control-menu__item__icon' src={menus.getPSSysImage.imagePath} /> : null}
                        {menus.getPSSysImage?.cssClass ? <i class={[menus.getPSSysImage.cssClass, 'app-control-menu__item__icon']}></i> : null}
                        {(!menus.getPSSysImage && isFirst) ? <i class='fa fa-cogs app-control-menu__item__icon'></i> : null}
                        <span ref="circleText" class={{ 'app-control-menu__item__caption': true, 'app-control-menu__item--circle': this.collapseChange && isFirst, 'no-icon': !hasIcon }} title={this.$tl(menus.tooltipTag,menus.tooltip)}>
                            {this.collapseChange && isFirst ? menus.caption.slice(0, 1) : this.$tl(menus.captionTag,menus.caption)}
                        </span>
                    </template>
                    {menus.getPSAppMenuItems.map((menu: any) => {
                        return this.renderAppMenuContent(menu, false);
                    })}
                </el-submenu> : null
        );
    }

    /**
     * 绘制菜单内容
     * 
     * @param   menu 菜单项
     * @param   isFirst 是否为一级菜单
     * @memberof AppmenuBase
     */
    public renderAppMenuContent(menu: any, isFirst: boolean) {
        if (menu?.getPSAppMenuItems?.length > 0) {
            return this.renderSubmenu(menu, isFirst);
        } else {
            return this.renderMenuItem(menu, isFirst);
        }
    }
      
    /**
     * 绘制应用菜单
     * 
     * @memberof AppmenuBase
     */
    public renderAppMenu() {
        if(!this.isDefaultOpenedsReady){
          return;
        }
        return (
            <el-menu
                ref={this.controlInstance?.codeName}
                default-openeds={Object.is(this.mode, 'LEFT') ? this.defaultOpeneds : []}
                mode={(Object.is(this.mode, 'LEFT') || !this.mode) ? 'vertical' : 'horizontal'}
                menu-trigger={this.trigger}
                collapse={this.collapseChange}
                on-select={(menuName: string) => this.select(menuName)}
                on-close={(key: any, keyPath: any) => this.handleCloseMenu(key, keyPath)}
                default-active={this.defaultActive}>
                <div class="control-content app-control-menu__content">
                    {this.menus.map((menu: any) => {
                        return this.renderAppMenuContent(menu, true);
                    })}
                </div>
            </el-menu>
        );
    }

    /**
     * @description 绘制顶部菜单
     * @return {*}
     * @memberof AppmenuBase
     */
     public renderTopMenu() {
        return (
            <el-menu
                mode='horizontal'
                class="control-content app-control-menu__content no-padding"
                default-active={this.defaultActive}
                on-select={(menuName: any) => this.select(menuName)}
            >
                {this.menus.map((item, index) =>
                    item.getPSAppMenuItems && item.getPSAppMenuItems.length > 0 ? (
                        item.getPSAppMenuItems.getPSAppMenuItems &&
                        item.getPSAppMenuItems.getPSAppMenuItems.length > 0 ? (
                            <el-submenu v-show={!item.hidden} index={item.getPSAppMenuItems?.name}>
                                <template slot='title'>
                                    {this.$tl(item.getPSAppMenuItems.captionTag, item.getPSAppMenuItems.caption)}
                                </template>
                                {item.getPSAppMenuItems.getPSAppMenuItems.map((item2: any) => (
                                    <el-menu-item v-show={!item2.hidden} index={item2?.name}>
                                        {this.$tl(item2.captionTag, item2.caption)}
                                        <badge
                                            count={this.counterdata ? this.counterdata[item2.counterid] : null}
                                            overflow-count={9999}
                                        ></badge>
                                    </el-menu-item>
                                ))}
                            </el-submenu>
                        ) : (
                            <el-submenu popper-class="app-control-menu__popper" v-show={!item.hidden} index={item?.name}>
                                <template slot='title'>{item.caption}</template>
                                {item.getPSAppMenuItems.map((item1: any) => (
                                    <el-menu-item v-show={!item1.hidden} index={item1?.name}>
                                        {this.$tl(item1.captionTag, item1.caption)}
                                        <badge
                                            count={this.counterdata ? this.counterdata[item1.counterid] : null}
                                            overflow-count={9999}
                                        ></badge>
                                    </el-menu-item>
                                ))}
                            </el-submenu>
                        )
                    ) : (
                        <el-menu-item v-show={!item.hidden} index={item?.name}>
                            {this.$tl(item.captionTag, item.caption)}
                            <badge
                                count={this.counterdata ? this.counterdata[item.counterid] : null}
                                overflow-count={9999}
                            ></badge>
                        </el-menu-item>
                    ),
                )}
            </el-menu>
        );
    }

    /**
     * 绘制中间应用菜单
     * 
     * @memberof AppmenuBase
     */
    public renderMiddleMenu() {
        return <div class="control-content app-control-menu__content">
            {
                this.menus.map((menu: any) => {
                    return <card bordered={false} v-show={!menu.hidden} class={{ 'app-control-menu__group': true }}>
                        <p slot="title" class={{ 'app-control-menu__group__caption': true }}>
                            {this.$tl(menu.captionTag,menu.caption)}
                        </p>
                        <div class={{ 'app-control-menu__group__content': true }}>
                            {
                                (menu.getPSAppMenuItems && menu.getPSAppMenuItems.length > 0) ? menu.getPSAppMenuItems.map((item: any) => {
                                    return !item.hidden?this.$createElement('card', {
                                        class: 'app-control-menu__item',
                                        nativeOn: {
                                            click: () => { throttle(this.click,[item],this) }
                                        },
                                        scopedSlots: {
                                            default: () => {
                                                return (
                                                <div>
                                                    <menu-icon item={item} class="app-control-menu__item__icon"/>
                                                    <span class="app-control-menu__item__caption">{ this.$tl(item.captionTag,item.caption) }</span>
                                                    <span v-badge={{count: this.counterdata ? this.counterdata[item.counterid] : null, offset: [4,28]}} />
                                                </div>
                                                )
                                            },
                                        }
                                    }):null
                                }) : null
                            }
                        </div>
                    </card >
                })
            }
        </div>
            
        
    }


    /**
     * 左侧应用菜单的左侧树绘制
     *
     * @return {*} 
     * @memberof AppmenuBase
     */
    public renderMenuTree() {
        if (this.menus && this.menus.length > 0) {
            const defaultMuneOption:any = this.defaultMuneOption(this.menus)?.name;
            return this.$createElement('el-tree', {
                props: {
                    'current-node-key': defaultMuneOption,
                    data: this.menus,
                    props: {
                        children: 'getPSAppMenuItems',
                        label: 'caption'
                    },
                    'default-expand-all': true,
                    'highlight-current': true,
                    'render-content': this.menuTreeload.bind(this),
                    'node-key': 'name',
                    'filter-node-method': ((filter: any, data: any) => {
                        if (!filter) return true;
                        return this.$tl(data.captionTag,data.caption).indexOf(filter) !== -1;
                    })
                },
                class:'control-content app-control-menu__content',
                ref: 'eltree',
                on: {
                    'node-click': ((e: any) => throttle(this.menuTreeClick,[e],this))
                },
                scopedSlots:{
                    default : ({node, data}:any)=>{
                        return this.$tl(data.captionTag,data.caption);
                    }
                }
            })
        }
    }

    /**
     * 搜索菜单节点
     *
     * @memberof AppmenuBase
     */
    public onSearch(filter: any) {
        const tree: any = this.$refs.eltree;
        if (tree && tree.filter && tree.filter instanceof Function) {
            tree.filter(filter);
        }
    }

    /**
     * 左侧应用菜单内容
     *
     * @memberof AppmenuBase
     */
    public renderContent() {
        if(this.split == 0.85){
            return [
                <div slot="right" class='control-right app-control-menu__right'>
                    <i-input
                        search={true}
                        class="app-control-menu__right__header"
                        placeholder={this.$t('components.search.holder')}
                        on-on-search={(value: any) => { this.onSearch(value); }}>
                    </i-input>
                    {this.renderMenuTree()}
                </div>,
                <div slot="left" class='control-left app-control-menu__left'>
                    {this.renderRightView ? this.renderRightView : null}
                </div>
            ];
        }else {
            return [
                <div slot="left" class='control-left app-control-menu__left'>
                    <i-input
                        search={true}
                        class="app-control-menu__left__header"
                        placeholder={this.$t('components.search.holder')}
                        on-on-search={(value: any) => { this.onSearch(value); }}>
                    </i-input>
                    {this.renderMenuTree()}
                </div>,
                <div slot="right" class='control-right app-control-menu__right'>
                    {this.renderRightView ? this.renderRightView : null}
                </div>
            ];
        }
        
    }

    /**
     * 绘制左侧应用菜单
     *
     * @return {*} 
     * @memberof AppmenuBase
     */
    public renderTableLeftMenu() {
        return (
            <split v-model={this.split}>
                {this.renderContent()}
            </split>
        )
    }
       /**
     * 绘制右侧分页菜单
     *
     * @return {*}
     * @memberof AppmenuBase
     */
        public renderTableRightMenu() {
            this.split = 0.85;
            return (
                <split v-model={this.split}>
                    {this.renderContent()}
                </split>
            );
        }
    
        /**
         * 绘制顶部分页菜单
         *
         * @return {*}
         * @memberof AppmenuBase
         */
        public renderTableTopMenu() {
            const defaultMuneOption:any = this.defaultMuneOption(this.menus)?.name;
            return (
                <div>
                    <el-menu
                        mode='horizontal'
                        class="control-header app-control-menu__header"
                        default-active={defaultMuneOption}
                        on-select={(e: any) => this.topMenuSelected(e)}
                    >
                        {this.menus.map((item, index) =>
                            item.getPSAppMenuItems && item.getPSAppMenuItems.length > 0 ? (
                                item.getPSAppMenuItems.getPSAppMenuItems &&
                                item.getPSAppMenuItems.getPSAppMenuItems.length > 0 ? (
                                    <el-submenu v-show={!item.hidden} index={item.getPSAppMenuItems?.name}>
                                        <template slot='title'>{this.$tl(item.getPSAppMenuItems.captionTag,item.getPSAppMenuItems.caption)}</template>
                                        {item.getPSAppMenuItems.getPSAppMenuItems.map((item2: any) => (
                                            <el-menu-item v-show={!item2.hidden} index={item2?.name}>
                                                {this.$tl(item2.captionTag,item2.caption)}
                                                <badge count={this.counterdata ? this.counterdata[item2.counterid] : null} overflow-count={9999}></badge>
                                            </el-menu-item>
                                        ))}
                                    </el-submenu>
                                ) : (
                                    <el-submenu v-show={!item.hidden} index={item?.name}>
                                        <template slot='title'>{item.caption}</template>
                                        {item.getPSAppMenuItems.map((item1: any) => (
                                            <el-menu-item v-show={!item1.hidden} index={item1?.name}>
                                                {this.$tl(item1.captionTag,item1.caption)}
                                                <badge count={this.counterdata ? this.counterdata[item1.counterid] : null} overflow-count={9999}></badge>
                                            </el-menu-item>
                                        ))}
                                    </el-submenu>
                                )
                            ) : (
                                <el-menu-item v-show={!item.hidden} index={item?.name}>
                                    {this.$tl(item.captionTag,item.caption)}
                                    <badge count={this.counterdata ? this.counterdata[item.counterid] : null} overflow-count={9999}></badge>
                                </el-menu-item>
                            ),
                        )}
                    </el-menu>
                    <div class="control-content app-control-menu__content">{this.renderRightView ? this.renderRightView : null}</div>
                </div>
            );
        }
        /**
         * 绘制底部分页菜单
         *
         * @return {*}
         * @memberof AppmenuBase
         */
        public renderTableBottomMenu() {
            const defaultMuneOption:any = this.defaultMuneOption(this.menus)?.name
            return [
                    <div class="control-content app-control-menu__content">{this.renderRightView ? this.renderRightView : null}</div>,
                    <div class="control-footer app-control-menu__footer no-padding">
                        <el-menu
                            mode='horizontal'
                            default-active={defaultMuneOption}
                            on-select={(e: any) => this.topMenuSelected(e)}
                        >
                            {this.menus.map((item, index) =>
                                item.getPSAppMenuItems && item.getPSAppMenuItems.length > 0 ? (
                                    item.getPSAppMenuItems.getPSAppMenuItems &&
                                    item.getPSAppMenuItems.getPSAppMenuItems.length > 0 ? (
                                        <el-submenu v-show={!item.hidden} index={item.getPSAppMenuItems?.name}>
                                            <template slot='title'>{this.$tl(item.getPSAppMenuItems.captionTag,item.getPSAppMenuItems.caption)}</template>
                                            {item.getPSAppMenuItems.getPSAppMenuItems.map((item2: any) => (
                                                <el-menu-item v-show={!item2.hidden} index={item2?.name}>
                                                    {this.$tl(item2.captionTag,item2.caption)}
                                                    <badge count={this.counterdata ? this.counterdata[item2.counterid] : null} overflow-count={9999}></badge>
                                                </el-menu-item>
                                            ))}
                                        </el-submenu>
                                    ) : (
                                        <el-submenu v-show={!item.hidden} index={item?.name}>
                                            <template slot='title'>{item.caption}</template>
                                            {item.getPSAppMenuItems.map((item1: any) => (
                                                <el-menu-item v-show={!item1.hidden} index={item1?.name}>
                                                    {this.$tl(item1.captionTag,item1.caption)}
                                                    <badge count={this.counterdata ? this.counterdata[item1.counterid] : null} overflow-count={9999}></badge>
                                                </el-menu-item>
                                            ))}
                                        </el-submenu>
                                    )
                                ) : (
                                    <el-menu-item v-show={!item.hidden} index={item?.name}>
                                        {this.$tl(item.captionTag,item.caption)}
                                        <badge count={this.counterdata ? this.counterdata[item.counterid] : null} overflow-count={9999}></badge>
                                    </el-menu-item>
                                ),
                            )}
                        </el-menu>
                    </div>
            ];
        }
    /**
     * 绘制应用菜单
     *
     * @returns {*}
     * @memberof AppmenuBase
     */
    public render() {
        if(!this.controlIsLoaded){
          return;
        }
        const { controlClassNames } = this.renderOptions;
        if (this.staticProps && this.staticProps.mode && Object.is(this.staticProps.mode, "CENTER")) {
            return (<div class={controlClassNames}>{this.renderMiddleMenu()}</div>)
        } else if (this.staticProps && this.staticProps.mode && (Object.is(this.staticProps.mode, 'TOP'))) {
            return <div class={controlClassNames}>{this.renderTopMenu()}</div>;
        } else  if (this.staticProps && this.staticProps.mode && (Object.is(this.staticProps.mode, 'TABEXP_LEFT') || Object.is(this.staticProps.mode, 'TREEEXP'))) {
            return <div class={controlClassNames}>{this.renderTableLeftMenu()}</div>;
        } else if (this.staticProps && this.staticProps.mode && Object.is(this.staticProps.mode, 'TABEXP_TOP')) {
            return <div class={controlClassNames}>{this.renderTableTopMenu()}</div>;
        } else if (this.staticProps && this.staticProps.mode && Object.is(this.staticProps.mode, 'TABEXP_RIGHT')) {
            return <div class={controlClassNames}>{this.renderTableRightMenu()}</div>;
        } else if (this.staticProps && this.staticProps.mode && Object.is(this.staticProps.mode, 'TABEXP_BOTTOM')) {
            return <div class={controlClassNames}>{this.renderTableBottomMenu()}</div>;
        } else {
            return <div class={controlClassNames}>{this.renderAppMenu()}</div>;
        }
    }
}
