import { IPSPanelContainer } from '@ibiz/dynamic-model-api';
import { LogUtil, ModelTool } from '../../utils';
import { PanelDetailModel } from './panel-detail';

/**
 * 用户控件模型
 *
 * @export
 * @class PanelCtrlPos
 * @extends {PanelDetailModel}
 */
export class PanelCtrlPosModel extends PanelDetailModel {

    /**
     * 多数据部件集合
     *
     * @memberof PanelCtrlPosModel
     */
    public mulCtrlArray = ['mdctrl', 'list', 'meditviewpanel', 'chart'];

    /**
     * Creates an instance of PanelCtrlPosModel.
     * @param {*} [opts={}]
     * @memberof PanelCtrlPosModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.dataSourceTag = this.getDataSourceTag();
        this.setItemContext();
    }

    /**
     * 获取数据域标识
     *
     * @memberof PanelCtrlPosModel
     */
    public getDataSourceTag() {
        if (this.parentItem) {
            // 父是多数据域
            if (Object.is(this.parentItem?.dataRegionType, 'MULTIDATA')) {
                // 当前部件占位部件为多数据部件
                if (this.mulCtrlArray.indexOf(this.name) !== -1) {
                    return this.parentItem.dataSourceTag;
                } else {
                    // 当前部件占位部件为单数据部件
                    return `${this.parentItem.dataSourceTag}:${this.$index}`;
                }
                // 父是单数据域
            } else if (Object.is(this.parentItem?.dataRegionType, 'SINGLEDATA')) {
                // 当前部件占位部件为多数据部件
                if (this.mulCtrlArray.indexOf(this.name) !== -1) {
                    LogUtil.error(`单数据域暂不支持多数据部件占位`);
                    return '';
                } else {
                    // 当前部件占位部件为单数据部件
                    return this.parentItem.dataSourceTag;
                }
            } else if (Object.is(this.parentItem?.dataRegionType, 'INHERIT')) {
                return this.parentItem.dataSourceTag;
            }
        }
    }

    /**
     * 设置项上下文
     *
     * @memberof PanelCtrlPosModel
     */
     public setItemContext() {
        if (this.parentItem) {
            if (Object.is(this.parentItem?.dataRegionType, 'MULTIDATA')) {
                // 当前部件占位部件为单数据部件
                if (this.mulCtrlArray.indexOf(this.name) === -1) {
                    const data = this.parentItem['data'][this.$index];
                    if (this.context && Object.keys(this.context).length > 0 && data && Object.keys(data).length > 0) {
                        const parentAppDataEntity = (this.parentItem.panelItemModel as IPSPanelContainer)?.getPSAppDataEntity?.();
                        const key = (parentAppDataEntity?.codeName as string)?.toLowerCase();
                        const value = data[(ModelTool.getAppEntityKeyField(parentAppDataEntity)?.codeName as string)?.toLowerCase()];
                        Object.assign(this.context, { [key]: value });
                    }
                }
            } else if (Object.is(this.parentItem?.dataRegionType, 'INHERIT')) {
                Object.assign(this.context, this.parentItem.context);
            }
        }
    }
    
    /**
     * 控件占位是否可挂载（父是多数据域且当前部件占位部件为多数据部件只绘制一个多数据部件）
     *
     * @readonly
     * @memberof PanelCtrlPosModel
     */
    public get isEnableMount() {
        if (this.parentItem && Object.is(this.parentItem?.dataRegionType, 'MULTIDATA') && (this.mulCtrlArray.indexOf(this.name) !== -1) && (this.$index !== 0)) {
            return false;
        } else {
            return true;
        }
    }
}