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
     * 父数据容器名称
     *
     * @private
     * @type {string}
     * @memberof PanelButtonModel
     */
    private $parentDataContainerName: string = '';

    /**
     * 父数据容器标识
     *
     * @readonly
     * @type {string}
     * @memberof PanelButtonModel
     */
    get parentDataContainerName(): string {
        if (!this.$parentDataContainerName) {
            const get = (item: any): string => {
                if (item.parentItem && item.parentItem.itemType === 'CONTAINER' && (item.parentItem.dataRegionType === 'SINGLEDATA' || item.parentItem.dataRegionType === 'MULTIDATA')) {
                    return item.parentItem.name;
                }
                return '';
            }
            this.$parentDataContainerName = get(this);
        }
        return this.$parentDataContainerName;
    }

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof PanelButtonModel
     */
    get disabled(): boolean {
        return this.$disabled;
    }

    /**
     * 设置是否启用
     *
     * @memberof PanelButtonModel
     */
    set disabled(val: boolean) {
        if (this.isPower) {
            this.$disabled = val;
        }
    }

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
     * 获取数据
     *
     * @return {*} 
     * @memberof PanelButtonModel
     */
    public getData() {
        if (this.parentItem) {
            return this.parentItem.getData();
        } else {
            return {};
        }
    }

}