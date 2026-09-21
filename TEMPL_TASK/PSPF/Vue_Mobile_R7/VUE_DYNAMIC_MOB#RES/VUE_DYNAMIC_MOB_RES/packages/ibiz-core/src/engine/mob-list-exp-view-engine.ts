import { ViewEngine } from './view-engine';
/**
 * 实体移动端多数据界面引擎
 *
 * @export
 * @class MDViewEngine
 * @extends {ViewEngine}
 */
export class MobListExpViewEngine extends ViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof MobListExpViewEngine
     */
    protected listexpbar: any;


    /**
     * Creates an instance of MobListExpViewEngine.
     * @memberof MobListExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof MobListExpViewEngine
     */
    public init(options: any = {}): void {
        this.listexpbar = options.listexpbar;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MobListExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(eventName, 'selectionchange')) {
            this.listExpBarSelectionChange(args);
        }
    }



    /**
     * 数据关系栏选中
     *
     * @param {any[]} args
     * @memberof MobListExpViewEngine
     */
    public listExpBarSelectionChange(data: any): void {
        if (data) {
            this.view.selection = data;
        }
        this.emitViewEvent('selectionchange', data);
    }

    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MobListExpViewEngine
     */
    public getListExpBar(): any {
        return this.listexpbar;
    }

    /**
     * 引擎加载
     *
     * @param {*} opts
     * @return {*}  {*}
     * @memberof MobListExpViewEngine
     */
    public load(opts: any): any {
        super.load(opts);
        if (this.getListExpBar()) {
            const tag = this.getListExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { ...this.view.viewparams } });
        } else {
            this.isLoadDefault = true;
        }
    }
}