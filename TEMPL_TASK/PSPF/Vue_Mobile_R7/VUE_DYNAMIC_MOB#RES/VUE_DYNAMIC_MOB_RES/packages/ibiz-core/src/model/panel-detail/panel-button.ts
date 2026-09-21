import { PanelDetailModel } from './panel-detail';

/**
 * 按钮模型
 *
 * @export
 * @class PanelButtonModel
 * @extends {PanelDetailModel}
 */
export class PanelButtonModel extends PanelDetailModel {

    /**
     * 按钮图标方向
     *
     * @type {('LEFT' | 'TOP' | 'RIGHT' | 'BOTTOM' | undefined)}
     * @memberof PanelButtonModel
     */
    public buttonIconAlign: 'LEFT' | 'TOP' | 'RIGHT' | 'BOTTOM' | undefined = undefined;

    /**
     * 按钮行为类型
     *
     * @type {('UIACTION' | 'FIUPDATE' | undefined)}
     * @memberof PanelButtonModel
     */
    public buttonActionType: 'UIACTION' | 'FIUPDATE' | undefined = undefined;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof PanelButtonModel
     */
    private $disabled: boolean = false;

    /**
     * 按钮对应的界面行为
     *
     * @type {*}
     * @memberof PanelButtonModel
     */
    public uiaction: any;

    /**
     * Creates an instance of PanelButtonModel.
     * @param {*} [opts={}]
     * @memberof PanelButtonModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.$disabled = opts.disabled;
        this.uiaction = opts.uiaction;
    }

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof PanelButtonModel
     */
    public get disabled(): boolean {
        return this.$disabled;
    }

    /**
     * 设置是否启用
     *
     * @memberof PanelButtonModel
     */
    public set disabled(val: boolean) {
        if (this.isPower) {
            this.$disabled = val;
        }
    }

    /**
     * 获取数据
     *
     * @return {*} 
     * @memberof PanelButtonModel
     */
    public getData() {
        if(this.parentItem){
            return this.parentItem.getData();
        }else{
            return {};
        }
    }

}