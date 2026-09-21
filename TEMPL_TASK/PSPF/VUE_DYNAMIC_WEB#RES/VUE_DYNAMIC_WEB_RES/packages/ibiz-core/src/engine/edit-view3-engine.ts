import { EditViewEngine } from './edit-view-engine';

/**
 * 实体编辑视图（分页关系）界面引擎
 *
 * @export
 * @class EditView3Engine
 * @extends {EditViewEngine}
 */
export class EditView3Engine extends EditViewEngine {

    /**
     * 数据关系栏
     *
     * @protected
     * @type {*}
     * @memberof EditView3Engine
     */
    protected drTab: any;

    /**
     * Creates an instance of EditView3Engine.
     * 
     * @memberof EditView3Engine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} [options={}]
     * @memberof EditView3Engine
     */
    public init(options: any = {}): void {
        this.drTab = options.drtab;
        super.init(options);
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof EditView3Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'drtab')) {
            this.drTabEvent(eventName, args);
        }
    }

    /**
     * 数据关系栏事件
     *
     * @param {string} eventName
     * @param {any[]} args
     * @memberof EditView3Engine
     */
    public drTabEvent(eventName: string, arg: any): void {
        if (Object.is(eventName, 'selectionchange')) {
            this.drTabSelectionChange(arg);
        }
    }

    /**
     * 数据关系栏选中
     *
     * @param {any[]} args
     * @memberof EditView3Engine
     */
    public drTabSelectionChange(data: any): void {
        if (data) {
            this.view.drItem = data;
            if (this.getDrTab()) {
                this.setViewState2({ tag: this.getDrTab().name, action: 'change', viewdata: data });
            }
            this.view.$forceUpdate();
        }
        this.emitViewEvent('selectionchange', data);
    }

    /**
     * 表单加载完成
     *
     * @param {*} [arg={}]
     * @memberof EditView3Engine
     */
    public onFormLoad(arg: any = {}): void {
        super.onFormLoad(arg);
        if (this.getDrTab()) {
            const tag = this.getDrTab().name;
            Object.assign(arg, {
              srfparentdename: this.getForm().appDeCodeName,
              srfparentkey: arg.srfkey,
            });
            this.setViewState2({ tag: tag, action: 'state', viewdata: arg });
        }
    }

    /**
     * 表单保存完成
     *
     * @param {*} [arg={}]
     * @memberof EditView3Engine
     */
    public onFormSave(arg: any = {}): void {
        super.onFormSave(arg);
        if (this.getDrTab()) {
            const tag = this.getDrTab().name;
            Object.assign(arg, {
              srfparentdename: this.getForm().appDeCodeName,
              srfparentkey: arg.srfkey,
            });
            this.setViewState2({ tag: tag, action: 'state', viewdata: arg });
        }
    }

    /**
     * 获取关系
     *
     * @returns {*}
     * @memberof EditView3Engine
     */
    public getDrTab(): any {
        return this.drTab;
    }

    /**
     * @description 视图销毁
     * @memberof EditView3Engine
     */
    public destroyed() {
        super.destroyed();
        this.drTab = null;
    }
}