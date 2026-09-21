import { isArray, isObject } from "qx-util";
import { ViewTool } from "../utils";

/**
 * 视图引擎基类
 *
 * @export
 * @class ViewEngine
 */
export class ViewEngine {
    /**
     * 视图部件对象
     *
     * @protected
     * @type {*}
     * @memberof ViewEngine
     */
    protected view: any = null;
    /**
     * 引擎参数
     *
     * @type {*}
     * @memberof ViewEngine
     */
    protected opt: any = {};
    /**
     *
     *
     * @type {*}
     * @memberof ViewEngine
     */
    protected methods: any = {};

    /**
     * 是否默认记载
     *
     * @type {boolean}
     * @memberof ViewEngine
     */
    public isLoadDefault: boolean = true;

    /**
     * 实体主键属性
     *
     * @type {(string | undefined)}
     * @memberof ViewEngine
     */
    public keyPSDEField: string | undefined;

    /**
     * 实体主信息属性
     *
     * @type {(string | undefined)}
     * @memberof ViewEngine
     */
    public majorPSDEField: string | undefined;

    /**
     * Creates an instance of ViewEngine.
     * @memberof ViewEngine
     */
    constructor() { }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof ViewEngine
     */
    public init(options: any = {}): void {
        this.opt = options;
        this.methods = options.methods;
        this.view = options.view;
        this.isLoadDefault = options.isLoadDefault && options.view.isLoadDefault;
        this.keyPSDEField = options.keyPSDEField;
        this.majorPSDEField = options.majorPSDEField;
        this.load();
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ViewEngine
     */
    public load(opts: any = {}): void {
        Object.assign(this.view.viewparams, opts);
        if(!this.isLoadDefault && this.view && this.view.isNavView){
            this.view.renderNoDataShade();
        }else{
            this.view.removeNoDataShade();
        }
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof ViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {}

    /**
     * 执行工具栏项逻辑
     *
     * @param {any[]} data
     * @memberof ViewEngine
     */
    public executeToolBarItemLogic(data: any[]) {
        if (this.view) {
            this.view.handleToolBarLogic(data)
        }
    }

    /**
     * 视图事件处理
     *
     * @param {string} eventName 事件tag
     * @param {*} args 事件参数
     * @memberof ViewEngine
     */
    public emitViewEvent(eventName: string, args: any): void {
        if (this.view) {
            if (!isArray(args) && isObject(args)) {
                args = [args];
            }
            this.view.$emit('view-event', { viewName: this.view.viewCodeName, action: eventName, data: args });
        }
    }

    /**
     * 是否为方法
     *
     * @protected
     * @param {*} func
     * @returns {boolean}
     * @memberof ViewEngine
     */
    protected isFunc(func: any): boolean {
        return func instanceof Function;
    }

    /**
     * 父数据参数模式
     *
     * @param {{ tag: string, action: string, viewdata: any }} { tag, action, viewdata }
     * @memberof ViewEngine
     */
    public setViewState2({ tag, action, viewdata }: { tag: string, action: string, viewdata: any }): void {
        this.view.viewState.next({ tag: tag, action: action, data: viewdata });
    }

    /**
     * 计算工具栏状态
     *
     * @param {boolean} state
     * @param {*} [dataaccaction]
     * @memberof ViewEngine
     */
    public calcToolbarItemState(state: boolean, dataaccaction?: any) {
        const _this: any = this;
        if(!_this.view){
            return;
        }
        ViewTool.calcToolbarItemState(state, _this.view.toolbarModels);
    }

    /**
     * 计算工具栏权限状态
     *
     * @param {boolean} state
     * @param {*} [dataaccaction]
     * @memberof ViewEngine
     */
    public calcToolbarItemAuthState(data: any) {
        const _this: any = this;
        if (!_this.view || !_this.view.appUIService)
        return;
        //  计算权限状态
        ViewTool.calcToolbarItemAuthState(data, _this.view.toolbarModels, _this.view.appUIService);
    }

    /**
     * 设置数据部件应用数据
     *
     * @param {*} [arg={}]
     * @memberof ViewEngine
     */
    public setDataCtrlData(arg: any = {}, isSingleMode: boolean = false): void {
        if (this.view && this.view.navDataService && this.view.viewInstance) {
            this.view.navDataService.setNavDataByTag(this.view.viewInstance.codeName, isSingleMode, arg);
        }
    }

    /**
     * @description 视图销毁
     * @memberof ViewEngine
     */
    public destroyed() {
        this.view = null;
    }
}