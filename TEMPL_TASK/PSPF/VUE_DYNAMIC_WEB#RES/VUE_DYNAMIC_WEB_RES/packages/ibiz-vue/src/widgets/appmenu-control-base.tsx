import { IPSAppMenu } from '@ibiz/dynamic-model-api';
import { AppServiceBase, AuthService, LogUtil, MenuControlInterface, Util } from 'ibiz-core';
import { ControlBase } from "./control-base";
import { AppFuncService, NavDataService } from '../app-service';
import { AppMenuService } from "../ctrl-service";
import { Subscription } from 'rxjs';

/**
 * 菜单部件基类
 *
 * @export
 * @class AppMenuControlBase
 * @extends {ControlBase}
 */
export class AppMenuControlBase extends ControlBase implements MenuControlInterface {

    /**
     * 菜单部件实例
     * 
     * @memberof AppMenuControlBase
     */
    public declare controlInstance: IPSAppMenu;

    /**
     * 显示处理提示
     * 
     * @memberof AppMenuControlBase
     */
    public showBusyIndicator: boolean = true;

    /**
     * 菜单收缩改变
     *
     * @type {boolean}
     * @memberof AppMenuControlBase
     */
    public collapseChange!: boolean;

    /**
     * 当前模式，菜单在顶部还是在底部
     *
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public mode!: string;

    /**
     * 当前选中主题
     *
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public selectTheme!: string;

    /**
     * 默认激活的index
     *
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public defaultActive: any = null;

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof AppMenuControlBase
     */
    public trigger: string = 'click';

    /**
     * 默认打开的index数组
     *
     * @type {any[]}
     * @memberof AppMenuControlBase
     */
    public defaultOpeneds: any[] = [];

    /**
     * 是否计算好默认打开项
     */
    public isDefaultOpenedsReady: boolean = false;

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof AppMenuControlBase
     */
    public isDefaultPage: boolean = false;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof AppMenuControlBase
     */
    public isBlankMode: boolean = false;

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public navDataService: NavDataService = NavDataService.getInstance(this.$store);

    /**
     * 默认打开视图
     *
     * @type {boolean}
     * @memberof AppMenuControlBase
     */
    public defPSAppView: any;

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof AppMenuControlBase
     */
    public counterdata: any;

    /**
     * 菜单模型
     *
     * @public
     * @type 
     * @memberof AppMenuControlBase
     */
    public menuMode: any;

    /**
     * 菜单数据
     *
     * @public
     * @type {any[]}
     * @memberof AppMenuControlBase
     */
    public menus: any[] = [];

    /**
     * 建构权限服务对象
     *
     * @type {AuthService}
     * @memberof AppMenuControlBase
     */
    public authService!: AuthService;

    /**
     * 是否需要使用计数器
     *
     * @private
     * @type {boolean}
     * @memberof AppMenuControlBase
     */
    private needUseCounter: boolean = false;

    /**
     * 微应用状态订阅对象
     *
     * @private
     * @type {*}
     * @memberof AppMenuControlBase
     */
    private MicroAppStateEvent: Subscription | undefined;

    /**
     * @description 菜单部件事件
     * @public
     * @type {(Subscription | undefined)}
     * @memberof AppMenuControlBase
     */
    public menuControlEvent: Subscription | undefined;

    /**
     * 当前应用是否为微应用
     *
     * @memberof AppMenuControlBase
     */
    public isMicroApp: boolean = false;

    /**
     * 提示框主题样式
     *
     * @type {string}
     * @memberof AppMenuControlBase
     */
    public popperClass(): string {
        return 'app-control-menu__popper ' + this.selectTheme;
    }

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMenuControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        this.collapseChange = newVal.collapseChange;
        this.$forceUpdate();
    }

    /**
     * 监听部件参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMenuControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.mode = newVal.mode ? newVal.mode : 'LEFT';
        this.selectTheme = newVal.selectTheme;
        this.isDefaultPage = newVal.isDefaultPage ? newVal.isDefaultPage : this.isDefaultPage;
        this.isBlankMode = newVal.isBlankMode ? newVal.isBlankMode : this.isBlankMode;
        this.defPSAppView = newVal.defPSAppView;
        this.counterdata = newVal.counterdata;
        super.onStaticPropsChange(newVal, oldVal)
    }

    /**
     * 部件模型数据初始化
     *
     * @memberof AppMenuControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        this.service = new AppMenuService(this.controlInstance, this.context);
        await this.service.initServiceParam(this.context, this.controlInstance);
        const microAppService = AppServiceBase.getInstance().getMicroAppService();
        if (microAppService) {
            this.isMicroApp = microAppService.getIsMicroApp();
            if (microAppService.getAppState()) {
                this.MicroAppStateEvent = microAppService.getAppState().subscribe((state: any) => {
                    const { tag, action, data } = state;
                    if (Object.is(tag, this.Environment.microAppName)) {
                        if (Object.is(action, 'MENUCLICK')) {
                            const appFuncs: Array<any> = this.service.getAllFuncs();
                            const appFunc = appFuncs.find((element: any) => {
                                return element.appfunctag === data?.funtag;
                            });
                            if (appFunc) {
                                const menuItem = this.service.getAllMenuItems().find((item:any) =>{
                                    return item.getPSAppFunc.codeName === data?.funtag;
                                })
                                Object.assign(appFunc, { menuItem });
                                AppFuncService.getInstance().executeApplication(appFunc, Util.deepCopy(this.context));
                            }
                        }
                    }
                })
            }
        }
    }

    /**
     * 应用菜单初始化
     *
     * @memberof AppMenuControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit();
        let _this: any = this;
        this.authService = new AuthService();
        if (this.viewState) {
            this.menuControlEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                this.load();
            });
        }
    }

    /**
     * 部件销毁
     *
     * @memberof AppMenuControlBase
     */
    public ctrlDestroyed(args?: any) {
        super.ctrlDestroyed(args);
        if (this.MicroAppStateEvent) {
            this.MicroAppStateEvent.unsubscribe();
        }
        if (this.menuControlEvent) {
            this.menuControlEvent.unsubscribe();
        }
    }

    /**
     * 数据加载
     *  
     * @memberof AppMenuControlBase
     */
    public load() {
        this.handleMenusResource(this.service.getAllMenuItems());
    }

    /**
     * 菜单项选中处理
     *
     * @param {menuName } 选中菜单名称
     * @returns
     * @memberof AppMenuControlBase
     */
    public select(menuName: any) {
        let item = this.compute(this.menus, menuName);
        if (Object.keys(item).length === 0) {
            return;
        }
        this.click(item);
    }

    /**
     * 处理菜单默认选中项
     *
     * @public
     * @memberof AppMenuControlBase
     */
    public defaultMenuSelect(): void {
        if (!this.isDefaultPage || this.isBlankMode) {
            return;
        }
        const appFuncs: Array<any> = this.service.getAllFuncs();
        if (this.$route && this.$route.matched && this.$route.matched.length == 2) { // 存在二级路由
            const [{ }, matched] = this.$route.matched;
            const appfunc: any = appFuncs?.find((_appfunc: any) => Object.is(_appfunc.routepath, matched.path) && Object.is(_appfunc.appfunctype, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            }
            return;
        } else if (this.defPSAppView && Object.keys(this.defPSAppView).length > 0) { // 存在默认视图
            const appfunc: any = appFuncs?.find((_appfunc: any) => Object.is(_appfunc.routepath, this.defPSAppView.routepath) && Object.is(_appfunc.appfunctype, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            }
            const viewparam: any = {};
            const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, this.defPSAppView.deResParameters, this.defPSAppView.parameters, [], viewparam);
            this.$router.push(path);
            return;
        }
        this.computeMenuSelect(this.menus, '');
        let item = this.compute(this.menus, this.defaultActive);
        if (Object.keys(item).length === 0) {
            return;
        }
        if (!item.hidden) {
            this.click(item);
        }
    }

    /**
     * 计算菜单选中项
     *
     * @public
     * @param {Array<any>} items 菜单数据
     * @param {string} appfunctag 应用功能tag
     * @return {*}  {boolean}
     * @memberof AppMenuControlBase
     */
    public computeMenuSelect(items: Array<any>, appfunctag: string): boolean {
        const appFuncs: Array<any> = this.service.getAllFuncs();
        const result = items.some((item: any) => {
            if (Object.is(appfunctag, '') && item.getPSAppFunc && item.openDefault && !item.hidden) {
                const appfunc = appFuncs?.find((_appfunc: any) => Object.is(_appfunc.appfunctag, item.getPSAppFunc.codeName));
                if (appfunc) {
                    this.defaultActive = item.name;
                    this.setHideSideBar(item);
                    return true;
                }
            }
            if (item.getPSAppFunc && Object.is(item.getPSAppFunc.codeName, appfunctag)) {
                this.setHideSideBar(item);
                this.defaultActive = item.name;
                return true;
            }
            if (item.getPSAppMenuItems && item.getPSAppMenuItems.length > 0) {
                const state = this.computeMenuSelect(item.getPSAppMenuItems, appfunctag);
                if (state) {
                    this.defaultOpeneds.push(item.name);
                    return true;
                }
            }
            return false;
        });
        this.isDefaultOpenedsReady = true;
        return result;
    }

    /**
     * 获取菜单项数据
     *
     * @public
     * @param {any[]} items
     * @param {string} name
     * @returns
     * @memberof AppMenuControlBase
     */
    public compute(items: any[], name: string) {
        const item: any = {};
        items.some((_item: any) => {
            if (name && Object.is(_item.name, name)) {
                Object.assign(item, _item);
                this.setHideSideBar(_item);
                return true;
            }
            if (_item.getPSAppMenuItems && Array.isArray(_item.getPSAppMenuItems)) {
                const subItem = this.compute(_item.getPSAppMenuItems, name);
                if (Object.keys(subItem).length > 0) {
                    Object.assign(item, subItem);
                    return true;
                }
            }
            return false;
        });
        return item;
    }

    /**
     * 设置是否隐藏菜单栏
     *
     * @public
     * @param {*} item
     * @memberof AppMenuControlBase
     */
    public setHideSideBar(item: any): void {
        if (this.isDefaultPage && item.hidesidebar) {
            this.$emit('collapsechange', true);
        }
    }

    /**
     * 菜单点击
     *  
     * @param {*} item 点击项
     * @memberof AppMenuControlBase
     */
    public click(item: any) {
        this.handleCtrlEvents('onclick', { action: 'MenuClick', data: item }).then((res: boolean) => {
            if (res) {
                this.defaultActive = item.name;
                if (Object.is((this.controlInstance as any)?.parentModel?.viewStyle, 'STYLE4') && (!this.mode || Object.is(this.mode, 'LEFT'))) {
                    this.$store.commit('removeAllPage');
                    this.navDataService.removeNavDataFrist();
                }
                let tempContext: any = Util.deepCopy(this.context);
                if (item.getPSNavigateContexts) {
                    const localContext = Util.formatNavParam(item.getPSNavigateContexts);
                    Object.assign(tempContext, localContext);
                } else {
                    if (tempContext.hasOwnProperty("srfdynainstid")) {
                        delete tempContext.srfdynainstid;
                    }
                }
                if (item.getPSAppFunc) {
                    const appFuncs: Array<any> = this.service.getAllFuncs();
                    const appFunc = appFuncs.find((element: any) => {
                        return element.appfunctag === item.getPSAppFunc.codeName;
                    });
                    if (appFunc) {
                        Object.assign(appFunc, { menuItem: item });
                        AppFuncService.getInstance().executeApplication(appFunc, tempContext);
                    }
                } else {
                    LogUtil.warn(this.$t('app.commonwords.noassign'));
                }
            }
        })
    }

    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof AppMenuControlBase
     */
    public handleMenusResource(inputMenus: Array<any>) {
        let _this: any = this;
        if (_this.$store.getters['authresource/getEnablePermissionValid']) {
            this.computedEffectiveMenus(inputMenus);
            //  不使用计数器则抛出事件让视图销毁计数器
            if (!this.needUseCounter) {
                this.ctrlEvent({ controlname: this.name, action: 'destoryCounter', data: null });
            }
            // this.computeParentMenus(inputMenus);
            //  不使用计数器则抛出事件让视图销毁计数器
            if (!this.needUseCounter) {
                this.ctrlEvent({ controlname: this.name, action: 'destoryCounter', data: null });
            }
        }
        this.dataProcess(inputMenus);
        this.isDefaultOpenedsReady = true;
        this.menus = inputMenus;
        if(!this.isMicroApp){
            this.defaultMenuSelect();
        }
    }

    /**
     * 计算有效菜单项
     *
     * @param {*} inputMenus
     * @memberof AppMenuControlBase
     */
    public computedEffectiveMenus(inputMenus: Array<any>) {
        inputMenus.forEach((_item: any) => {
            //  无权限
            if (!this.authService.getMenusPermission(_item)) {
                _item.hidden = true;
            } else {
                if (Util.isExistAndNotEmpty(_item.counterid)) {
                    this.needUseCounter = true;
                }
            }
            //  父隐藏时不计算子权限
            if (_item.getPSAppMenuItems && _item.getPSAppMenuItems.length > 0 && !_item.hidden) {
                this.computedEffectiveMenus(_item.getPSAppMenuItems);
            }
        })
    }

    // /**
    //  * 计算父项菜单项是否隐藏
    //  *
    //  * @param {*} inputMenus
    //  * @memberof AppMenuControlBase
    //  */
    // public computeParentMenus(inputMenus:Array<any>){
    //     if(inputMenus && inputMenus.length >0){
    //         inputMenus.forEach((item:any) =>{
    //             if(item.hidden && item.getPSAppMenuItems && item.getPSAppMenuItems.length >0){
    //                 item.getPSAppMenuItems.map((singleItem:any) =>{
    //                     if(!singleItem.hidden){
    //                         item.hidden = false;
    //                     }else{
    //                         if(singleItem.getPSAppMenuItems && singleItem.getPSAppMenuItems.length >0){
    //                             singleItem.getPSAppMenuItems.map((grandsonItem:any) =>{
    //                                 if(!grandsonItem.hidden){
    //                                     item.hidden = false;
    //                                 }
    //                             })
    //                         }
    //                     }
    //                     if(item.getPSAppMenuItems && item.getPSAppMenuItems.length >0){
    //                         this.computeParentMenus(item.getPSAppMenuItems);
    //                     }
    //                 })
    //             }
    //         })
    //     }
    // }

    /**
     * 数据处理
     *
     * @public
     * @param {any[]} items
     * @memberof AppMenuControlBase
     */
    public dataProcess(items: any[]): void {
        items.forEach((_item: any) => {
            if (_item.expanded) {
                this.defaultOpeneds.push(_item.name);
            }
            if (_item.getPSAppMenuItems && _item.getPSAppMenuItems.length > 0) {
                this.dataProcess(_item.getPSAppMenuItems)
            }
        });
    }

    /**
     * @description 处理关闭菜单
     * @param {*} key 菜单项标识
     * @param {*} keyPath 标识集合
     * @memberof AppMenuControlBase
     */
    public handleCloseMenu(key: any, keyPath: any) {
        const refs: any = this.$refs;
        if (refs[this.controlInstance?.codeName] && refs[this.controlInstance?.codeName].close instanceof Function) {
            refs[this.controlInstance?.codeName].close(key);
        }
    }
}