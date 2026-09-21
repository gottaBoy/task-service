import { AppControlBase } from "./app-control-base";
import { AppFuncService } from '../app-service';
import { IPSAppMenu, IPSAppMenuItem } from '@ibiz/dynamic-model-api';
import { AuthService, MobMenuControlInterface, Util } from "ibiz-core";
import { AppMobMenuService } from "../ctrl-service";
/**
 * 菜单部件基类
 *
 * @export
 * @class AppControlBase
 * @extends {MobAppMenuControlBase}
 */
export class MobAppMenuControlBase extends AppControlBase implements MobMenuControlInterface {

    /**
     * 菜单部件实例
     * 
     * @memberof MobAppMenuControlBase
     */
    public declare controlInstance: IPSAppMenu;

    /**
     * 部件服务对象
     *
     * @type {*}
     * @memberof AppControlBase
     */
    public declare service: AppMobMenuService;

    /**
     * 部件样式
     *
     * @protected
     * @type {(string | 'ICONVIEW' | 'LISTVIEW' | 'SWIPERVIEW' | 'LISTVIEW2' | 'LISTVIEW3' | 'LISTVIEW4')}   默认空字符串 | 图标视图 | 列表视图 | 图片滑动视图 | 列表视图（无刷新） | 列表视图（无滑动） | 列表视图（无背景）
     * @memberof MobAppMenuControlBase
     */
    public controlStyle!: string | 'ICONVIEW' | 'LISTVIEW' | 'SWIPERVIEW' | 'LISTVIEW2' | 'LISTVIEW3' | 'LISTVIEW4';

    /**
     * 菜单数据
     *
     * @private
     * @type {any[]}
     * @memberof MobAppMenuControlBase
     */
    public menus: any[] = [];

    /**
     * 当前菜单是否在默认视图上
     *
     * @type {*}
     * @memberof MobAppMenuControlBase
     */
    public isDefaultPage?: boolean;

    /**
     * 菜单选中项
     *
     * @type {*}
     * @memberof MobAppMenuControlBase
     */
    public selectValue: any = null;


    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof MobAppMenuControlBase
     */
    protected counterdata: any = {};

    /**
     * 
     *
     * @type {AuthService}
     * @memberof MobAppMenuControlBase
     */
    public authService!: AuthService;

    /**
     * 菜单项选中处理
     *
     * @param {*} index
     * @param {any[]} indexs
     * @returns
     * @memberof MobAppMenuControlBase
     */
    public select(menuName: any) {
        if (!menuName) {
            return;
        }
        let item = this.compute(this.menus, menuName);
        if (Object.keys(item).length === 0) {
            return;
        }
        this.click(item, menuName);
    }

    /**
     * 默认选中
     *
     * @param {*} menuName
     * @memberof MobAppMenuControlBase
     */
    public defaultSelect(menuName: any) {
        this.selectValue = menuName;
        this.select(this.selectValue)
    }

    /**
     * 获取菜单项数据
     *
     * @private
     * @param {any[]} items
     * @param {string} name
     * @returns
     * @memberof MobAppMenuControlBase
     */
    public compute(items: any[], name: string) {
        return items.find((_item: IPSAppMenuItem) => {
            return _item.name == name;
        })
    }

    /**
     * 菜单点击
     *  
     * @param menuItem
     * @memberof MobAppMenuControlBase
     */
    public async click(item: any, menuName: string) {
        if (!(await this.handleCtrlEvents('onclick', { action: 'onclick', data: item }))) {
            return;
        }
        let tempContext: any = Util.deepCopy(this.context);
        if (item.getPSNavigateContexts) {
            const localContext = Util.formatNavParam(item.getPSNavigateContexts);
            Object.assign(tempContext, localContext);
        }
        if (item.getPSAppFunc) {
            const appFuncs = this.service.getAllFuncs();
            const appFunc = appFuncs?.find((element: any) => {
                return element.appfunctag === item.getPSAppFunc?.codeName;
            });
            if (appFunc) {
                if (appFunc.appFuncType === 'APPVIEW' && this.isDefaultPage) {
                    const tempContext = { viewpath: appFunc.getPSAppView.modelPath };
                    Object.assign(tempContext, this.context);
                    const args = {
                        srfnavdata: {
                            context: tempContext,
                            viewparams: this.viewparams
                        }
                    };
                    Object.assign(args, appFunc);
                    this.selectValue = menuName;
                    this.ctrlEvent({ controlname: this.controlInstance.name, action: 'selectionchange', data: args });
                } else {
                    AppFuncService.getInstance().executeApplication(appFunc, tempContext);
                }
            }
        } else {
            console.warn(this.$t('app.commonWords.noAssign'));
        }
    }

    /**
     * 计算有效菜单项
     *
     * @param {*} data
     * @memberof MobAppMenuControlBase
     */
    public computedEffectiveMenus(inputMenus: Array<any>) {
        inputMenus.forEach((_item: any) => {
            if (!this.authService.getMenusPermission(_item)) {
                _item.hidden = true;
                if (_item.items && _item.items.length > 0) {
                    this.computedEffectiveMenus(_item.items);
                }
            }
            if (Object.is(_item.id, 'setting')) {
                _item.hidden = false;
            }
        })
    }

    /**
     * 数据处理
     *
     * @private
     * @param {any[]} items
     * @memberof MobAppMenuControlBase
     */
    private dataProcess(items: any[]): void {
        items.forEach((_item: any) => {
            if (_item.items && _item.items.length > 0) {
                this.dataProcess(_item.items)
            }
        });
    }


    /**
     * 部件挂载
     *
     * @memberof AppControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit();
        this.controlStyle = this.staticProps.controlStyle ? this.staticProps.controlStyle : "";
        this.isDefaultPage = this.staticProps.isDefaultPage;
        this.authService = new AuthService();
        this.handleMenusResource(this.service.getAllMenuItems());
        this.calcMenuName();
        this.viewState.subscribe(({ tag, action }: { tag: string; action: string }) => {
            if (!Object.is(this.controlInstance.name, tag)) {
                return;
            }
            if (Object.is(action, 'init')) {
                this.select(this.selectValue);
            }
        })

    }

    /**
     * 计算菜单名称
     *
     * @memberof MobAppMenuControlBase
     */
    public calcMenuName() {
        this.menus.forEach((item: any) => {
            item.caption = this.$tl(item.captionTag, item.caption);
        });
    }

    /**
     * 部件模型数据初始化实例
     *
     * @memberof AppDefaultMobForm
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit(args)
        this.service = new AppMobMenuService(this.controlInstance);
        await this.service.loaded(this.context, this.controlInstance)
    }


    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof AppMenuControlBase
     */
    public handleMenusResource(inputMenus: Array<any> | undefined) {
        if (!inputMenus) {
            return;
        }
        const Environment = (window as any).Environment;
        if (Environment.enablePermissionValid) {
            this.computedEffectiveMenus(inputMenus);
        }
        this.dataProcess(inputMenus);
        this.menus = inputMenus;
    }
}