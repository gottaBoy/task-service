/**
 * 
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
     * 是否使用默认加载模型
     *
     * @type {boolean}
     * @memberof ViewEngine
     */
    public isUseDefaultLoad: boolean = true;

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
        this.isLoadDefault = options.isLoadDefault;
        this.keyPSDEField = options.keyPSDEField;
        this.majorPSDEField = options.majorPSDEField;
        options.hasOwnProperty('isUseDefaultLoad') && (this.isUseDefaultLoad = options.isUseDefaultLoad);
        this.load();
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ViewEngine
     */
    public load(opts: any = {}): void {

    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof ViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {

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
            this.view.$emit('view-event', { viewName: this.view.viewName, action: eventName, data: args });
        }
    }

    /**
     * 处理界面行为
     *
     * @param {string} tag
     * @param {string} [actionmode]
     * @memberof ViewEngine
     */
    public doSysUIAction(tag: string, actionmode?: string): void {
        if (Object.is(actionmode, 'FRONT')) {
            if (this.methods.front) {
                this.methods.front(tag);
            }
        }
    }

    /**
     * 处理工作流界面行为
     *
     * @param {string} tag
     * @param {string} [actionmode]
     * @memberof ViewEngine
     */
    public doSysWFUIAction(tag: string, actionmode?: string): void {
        if (Object.is(actionmode, 'WFFRONT')) {
            if (this.methods.wfFront) {
                this.methods.wfFront(tag);
            }
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
        const computeItemState = (models: any) => {
            if (!models || models.length === 0) {
                return;
            }
            for (const _key in models) {
                if (!models.hasOwnProperty(_key)) {
                    return;
                }
                const _item = models[_key];
                Object.keys(_item).forEach((key: string) => {      
                    const item = _item[key];
                    const uiaction= item.oneself?.getPSUIAction?.();
                    if (uiaction && (Object.is(uiaction.actionTarget, 'SINGLEKEY') || Object.is(uiaction.actionTarget, 'MULTIKEY'))) {
                        item.disabled = state;
                    }
                    item.visible = true;
                    if (uiaction?.noPrivDisplayMode && uiaction?.noPrivDisplayMode === 6) {
                        item.visible = false;
                    }
                })
            }
        } 
        computeItemState(_this.view.toolBarAuth);        
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
        if (!_this.view.appUIService)
            return;
        const computeAuthState = (models: any) => {
            for (const _key in models) {
                if (Object.prototype.hasOwnProperty.call(models, _key)) {
                  const _item = models[_key];
                    Object.keys(_item).forEach((key: string) => {
                        const item = _item[key];
                        const uiaction= item.oneself?.getPSUIAction?.();                        
                        if (uiaction && uiaction['dataAccessAction']) {
                            let dataActionResult: any;
                            // 不需要数据的界面行为
                            if (uiaction && (Object.is(uiaction.actionTarget, "NONE") || Object.is(uiaction.actionTarget, ""))) {
                                if (Object.is(uiaction.actionTarget, "") && Object.is(uiaction.tag, "Save") && _this.view.appUIService.isEnableDEMainState) {
                                    if (data && Object.keys(data).length > 0) {
                                        dataActionResult = _this.view.appUIService.getAllOPPrivs(data, uiaction['dataAccessAction']);
                                    }
                                } else {
                                    dataActionResult = _this.view.appUIService.getAllOPPrivs(undefined, uiaction['dataAccessAction']);
                                }
                            } else {
                                if (data && Object.keys(data).length > 0 && _this.view.appUIService.isEnableDEMainState) {
                                    dataActionResult = _this.view.appUIService.getAllOPPrivs(data, uiaction['dataAccessAction']);
                                } else {
                                    dataActionResult = _this.view.appUIService.getAllOPPrivs(undefined, uiaction['dataAccessAction']);
                                }
                            }
                            // 无权限:0;有权限:1
                            if (dataActionResult === 0) {
                                // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                                if (uiaction?.noPrivDisplayMode === 1) {
                                    item.disabled = true;
                                }
                                if ((uiaction?.noPrivDisplayMode === 2) || (uiaction?.noPrivDisplayMode === 6)) {
                                    item.visible = false;
                                } else {
                                    item.visible = item.visible && true;
                                }
                            }
                            if (dataActionResult === 1) {
                                item.visible = item.visible && true;
                                item.disabled = item.disabled || false;
                            }
                        }
                    })
                }
            }          
        }        
        computeAuthState(_this.view.toolBarAuth);        
    }

}