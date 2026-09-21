import { PanelDetailModel } from './panel-detail';
import { IPSSysPanelField } from '@ibiz/dynamic-model-api';

/**
 * 面板属性项模型
 *
 * @export
 * @class PanelFieldModel
 * @extends {PanelDetailModel}
 */
export class PanelFieldModel extends PanelDetailModel {
    /**
     * 面板项模型
     *
     * @type {(IPSSysPanelField | undefined)}
     * @memberof PanelFieldModel
     */
    public declare panelItemModel: IPSSysPanelField | undefined;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof PanelFieldModel
     */
    public disabled: boolean = false;

    /**
     * 面板属性项默认状态
     *
     * @type {(string | undefined)}
     * @memberof PanelFieldModel
     */
    public panelFieldState: string | undefined = undefined;

    /**
     * 错误信息
     *
     * @type {string}
     * @memberof PanelFieldModel
     */
    public error: string = '';

    /**
     * 属性项名称
     *
     * @readonly
     * @type {string}
     * @memberof PanelFieldModel
     */
    get viewFieldName(): string {
        if (this.panelItemModel && (this.panelItemModel as any).viewFieldName) {
            return (this.panelItemModel as any).viewFieldName.toLowerCase();
        }
        return this.name.toLowerCase();
    }

    /**
     * @description 判断是否是AUTH_LOGINMSG预置类型
     * @readonly
     * @type {boolean}
     * @memberof PanelFieldModel
     */
    get isErrorMsgItem(): boolean {
        if (this.panelItemModel && this.panelItemModel.getPSEditor()?.predefinedType === 'AUTH_LOGINMSG') {
            return true;
        }
        return false;
    }

    /**
     * 表单项启用条件
     * 
     * 0 不启用
     * 1 新建
     * 2 更新
     * 3 全部启用
     *
     * @type {(number | 0 | 1 | 2 | 3)}
     * @memberof PanelFieldModel
     */
    public enableCond: number | 0 | 1 | 2 | 3 = 3;

    /**
     * Creates an instance of PanelFieldModel.
     * PanelFieldModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof PanelFieldModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.disabled = opts.disabled ? true : false;
        this.enableCond = opts.enableCond;
    }

    /**
     * 设置是否启用
     *
     * @param {boolean} state
     * @memberof PanelFieldModel
     */
    public setDisabled(state: boolean): void {
        this.disabled = state;
    }

    /**
     * 设置信息内容
     *
     * @param {string} error
     * @memberof PanelFieldModel
     */
    public setError(error: string): void {
        this.error = error;
    }

    /**
     * 设置是否启用
     *
     * @param {string} srfuf
     * @memberof PanelFieldModel
     */
    public setEnableCond(srfuf: string): void {
        // 是否有权限
        const isReadOk: boolean = true;
        const _srfuf: number = parseInt(srfuf, 10);
        let state: boolean = true;

        if (isReadOk) {
            if (_srfuf === 1) {
                if ((this.enableCond & 2) === 2) {
                    state = false;
                }
            } else {
                if ((this.enableCond & 1) === 1) {
                    state = false;
                }
            }
        }
        this.setDisabled(state);
    }


    /**
     * 执行异步逻辑
     *
     * @memberof PanelFieldModel
     */
    public async loaded() {
        if (this.parentItem && this.parentItem['data']) {
            this.data = this.parentItem['data'][this.viewFieldName];
        }
    }

    /**
     * 设置数据
     *
     * @param {*} val (值非对象)
     * @memberof PanelFieldModel
     */
    public setData(val: any) {
        this.data = val;
        if (!this.parentItem) {
            return;
        } else {
            this.parentItem.setData({ name: this.viewFieldName, value: val });
        }
    }

    /**
     * 重置当前项数据
     * 
     * @memberof PanelFieldModel
     */
    public reSetData() {
        this.data = null;
    }

} 