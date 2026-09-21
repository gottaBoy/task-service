import { MDViewEngine } from './md-view-engine';

/**
 * 实体树视图界面引擎
 *
 * @export
 * @class GanttViewEngine
 * @extends {ViewEngine}
 */
export class GanttViewEngine extends MDViewEngine {

    /**
     * 甘特图部件对象
     *
     * @type {*}
     * @memberof GanttViewEngine
     */
    public gantt: any;

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof GanttViewEngine
     */
    public init(options: any): void {
        this.gantt = options.gantt;
        super.init(options);
    }

    /**
     * 树搜索
     *
     * @param {*} [arg]
     * @memberof GanttViewEngine
     */
    public search(arg?: any) {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'filter', viewdata: arg });
        }
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GanttViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'gantt')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 多数据部件事件处理
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof GanttViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any) {
        if (Object.is(eventName, 'load')) {
            this.onLoad(args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.onSelectionChange(args);
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 搜索栏事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof GanttViewEngine
     */
    public searchBarEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'search')) {
           this.search({ srfnodefilter: args?.quickSearchValue });
        }
    }

    /**
     * 部件加载完
     *
     * @param {*} args
     * @memberof GanttViewEngine
     */
    public onLoad(args: any): void { }

    /**
     * 选中处理
     *
     * @param {any[]} args
     * @memberof GanttViewEngine
     */
    public onSelectionChange(args: any[]): void { }


    /**
     * 
     *获取树视图部件
     * @returns {*}
     * @memberof GanttViewEngine
     */
    public getMDCtrl(): any {
        return this.gantt;
    }

    /**
     * @description 视图销毁
     * @memberof GanttViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.gantt = null;
    }
}