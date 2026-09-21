import { ViewEngine } from './view-engine';

/**
 * 首页界面引擎
 *
 * @export
 * @class MobIndexViewEngine
 * @extends {ViewEngine}
 */
export class MobIndexViewEngine extends ViewEngine {


    /**
     * 菜单部件
     *
     * @type {*}
     * @memberof MobIndexViewEngine
     */
    menu: any;

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof ViewEngine
     */
    public init(options: any = {}): void {
        this.menu = options.menu;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ViewEngine
     */
    public load(opts: any = {}): void {
        this.setViewState2({ tag: this.menu.name, action: 'init', viewdata: {} })
    }


    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MobEditViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(eventName, 'selectionchange')) {
            this.setEmbedViewProps(args);
        }
    }

    /**
     * 设置首页嵌入视图参数
     *
     * @memberof IndexViewBase
     */
    public setEmbedViewProps(appFunc: any) {
        if (!this.view || !this.view.hasOwnProperty('init') || !this.view.hasOwnProperty('embedViewProps')) return;
        this.view.init = false;
        const { getPSAppView: appView } = appFunc;
        if (!appView) {
            return;
        }
        const staticProps = {
            viewDefaultUsage: 'INDEXVIEW'
        }
        Object.assign(staticProps, { viewModelData: appView });
        Object.assign(this.view.embedViewProps, { staticProps: staticProps });
        this.view.$nextTick(() => {
            this.view.init = true;
        })
    }

}
