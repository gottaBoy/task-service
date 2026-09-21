
import { MDViewEngineBase } from './md-view-engine-base';

/**
 * 实体移动端多表单编辑视图（部件视图）界面引擎
 *
 * @export
 * @class MobMEditView9Engine
 * @extends {ViewEngine}
 */
export class MobMEditView9Engine extends MDViewEngineBase {

    /**
     * 多编辑表单面板
     *
     * @protected
     * @type {*}
     * @memberof MobMEditView9Engine
     */
    protected meditviewpanel: any;

    /**
     * Creates an instance of MobMEditView9Engine.
     * @memberof MobMEditView9Engine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof MobMEditView9Engine
     */
    public init(options: any = {}): void {
        this.meditviewpanel = options.meditviewpanel;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MobMEditView9Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'meditviewpanel')) {
            this.MDCtrlEvent(eventName, args);
        }
    }

    /**
     * 多编辑表单面板事件分发
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof MobMEditView9Engine
     */
    public MDCtrlEvent(eventName: string, args: any) {
        if (Object.is(eventName, 'drdatasaved')) {
            this.emitViewEvent('drdatasaved', args);
        }
        if (Object.is(eventName, 'drdatachange')) {
            this.emitViewEvent('drdatachange', args);
        }
        if (Object.is(eventName, 'remove')) {
            this.emitViewEvent('drdatachange', args);
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 多编辑表单面板部件
     *
     * @returns {*}
     * @memberof MDViewEngine
     */
    public getMDCtrl(): any {
        return this.meditviewpanel;
    }

}