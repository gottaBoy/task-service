import { IPSPanelItem } from "@ibiz/dynamic-model-api";
import { IContext, IParams } from "ibiz-core";

/**
 * 面板成员模型
 *
 * @export
 * @class PanelDetailModel
 */
export class PanelDetailModel {

    /**
     * 原始面板项模型
     *
     * @type {IParams}
     * @memberof PanelDetailModel
     */
    public panelItemModel: IPSPanelItem | undefined = undefined;

    /**
     * 数据域标识
     *
     * @type {(string)}
     * @memberof PanelDetailModel
     */
    public dataSourceTag: string = '';

    /**
     * 面板项下标(上层容器存在多数据容器时启用)
     *
     * @type {number}
     * @memberof PanelDetailModel
     */
    public $index: number = 0;

    /**
     * 是否有多数据域父
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public hasMulParent: boolean = false;

    /**
     * 当前项数据
     *
     * @type {*}
     * @memberof PanelDetailModel
     */
    protected data: any;

    /**
     * 是否有权限
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public isPower: boolean = true;

    /**
     * 成员标题
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public caption: string = '';

    /**
     * 成员类型
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public itemType: string = '';

    /**
     * 面板对象
     *
     * @type {*}
     * @memberof PanelDetailModel
     */
    public panel: any = null;

    /**
     * 成员名称
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public name: string = '';

    /**
     * 成员是否显示
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public $visible: boolean = true;

    /**
     * 父项
     *
     * @type {(any | null)}
     * @memberof PanelDetailModel
     */
    public parentItem: any | null = null;

    /**
     * 应用上下文
     *
     * @type {IContext}
     * @memberof PanelDetailModel
     */
    public context: IContext = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof PanelDetailModel
     */
    public viewparams: any = {};

    /**
     * 面板类型
     *
     * @type {('VIEWLAYOUTPANEL' | 'VIEWPANEL' | 'ITEMLAYOUTPANEL')}
     * @memberof PanelDetailModel
     */
    public panelType: 'VIEWLAYOUTPANEL' | 'VIEWPANEL' | 'ITEMLAYOUTPANEL' = 'VIEWLAYOUTPANEL';

    /**
     * Creates an instance of PanelDetailModel.
     * PanelDetailModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof PanelDetailModel
     */
    constructor(opts: any = {}) {
        this.context = opts.context || {};
        this.viewparams = opts.viewparams || {};
        this.caption = !Object.is(opts.caption, '') ? opts.caption : '';
        this.itemType = !Object.is(opts.itemType, '') ? opts.itemType : '';
        this.panel = opts.panel ? opts.panel : {};
        this.name = !Object.is(opts.name, '') ? opts.name : '';
        this.$visible = opts.visible ? true : false;
        this.panelItemModel = opts.model ? opts.model : {};
        this.parentItem = opts.parentItem ? opts.parentItem : null;
        this.$index = opts.$index;
        this.hasMulParent = opts.hasMulParent;
        this.panelType = opts.panelType ? opts.panelType : 'VIEWLAYOUTPANEL';
    }

    /**
     * 获取值
     *
     * @param {*} val
     * @memberof PanelDetailModel
     */
    public get value() {
        return this.data;
    }

    /**
     * 设置值
     *
     * @param {*} val
     * @memberof PanelDetailModel
     */
    public set value(val: any) {
        this.setData(val);
        const name = this.hasMulParent ? `${this.name}_${this.$index}` : this.name;
        this.panel.layoutData[name] = this.data;
    }

    /**
     * 刷新
     *
     * @memberof PanelDetailModel
     */
    public async refresh() {
        await this.loaded();
        const name = this.hasMulParent ? `${this.name}_${this.$index}` : this.name;
        this.panel.layoutData[name] = this.data;
    }

    /**
     * 刷新当前数据域
     *
     * @memberof PanelDetailModel
     */
    public async refreshDataArea() {
        if (this.parentItem && this.parentItem.refreshDataArea && (this.parentItem.refreshDataArea instanceof Function)) {
            this.parentItem.refreshDataArea();
        }
    }

    /**
     * 设置成员是否隐藏
     *
     * @memberof PanelDetailModel
     */
    public set visible(val: boolean) {
        if (this.isPower) {
            this.$visible = val;
        }
    }

    /**
     * 获取成员是否隐藏
     *
     * @memberof PanelDetailModel
     */
    public get visible() {
        return this.$visible;
    }


    /**
     * 设置显示与隐藏
     *
     * @param {boolean} state
     * @memberof PanelDetailModel
     */
    public setVisible(state: boolean): void {
        if (this.isPower) {
            this.visible = state;
        }
    }

    /**
     * 执行异步逻辑
     *
     * @memberof PanelDetailModel
     */
    public async loaded() { }

    /**
     * 获取数据
     *
     * @return {*} 
     * @memberof PanelDetailModel
     */
    public getData() {
        return this.data;
    }

    /**
     * 设置数据
     *
     * @param {*} val
     * @memberof PanelDetailModel
     */
    public setData(val: any) { }

    /**
     * 重置当前项数据
     * 
     * @memberof PanelDetailModel
     */
    public reSetData() { }

    /**
     * 获取面板项样式类
     *
     * @memberof PanelDetailModel
     */
    public getDetailClass() {
        let detailClass = [];
        detailClass.push({
            [`app-${this.panelType.toLowerCase()}-${this.panelItemModel?.itemType.toLowerCase()}`]: true,
            [`${this.panelType.toLowerCase()}-${this.panelItemModel?.itemType.toLowerCase()}-${this.panelItemModel?.name.toLowerCase()}`]: true,
            [`${this.panelItemModel?.name.toLowerCase()}`]: true
        });
        if (this.panelType !== 'VIEWLAYOUTPANEL') {
            detailClass.push({ [`panel-${this.panelItemModel?.itemType.toLowerCase()}`]: true });
        }
        if (this.panelItemModel?.getPSSysCss?.()) {
            detailClass.push({ [`${this.panelItemModel?.getPSSysCss?.()?.cssName}`]: true });
        }
        // 容器类型面板
        if (this.panelItemModel?.showCaption) {
            detailClass.push({ 'show-caption': true });
        }
        return detailClass;
    }

    /**
     * 获取盒子样式
     *
     * @return {*} 
     * @memberof PanelDetailModel
     */
    public getBoxStyle() {
        const boxStyle: any = {};
        const layout = this.panelItemModel?.getPSLayout()?.layout;
        const layoutPos = this.panelItemModel?.getPSLayoutPos() as any;
        // 宽度模式
        if(layoutPos.widthMode){
            Object.assign(boxStyle, this.getBoxSize("WIDTH",layoutPos.widthMode,layoutPos.width));
        }
        // 高度模式
        if(layoutPos.heightMode){
            Object.assign(boxStyle, this.getBoxSize("HEIGHT",layoutPos.heightMode,layoutPos.height));
        }
        // 上方间隔模式
        if (layoutPos && layoutPos.spacingTop) {
            Object.assign(boxStyle, this.getBoxSpacingStyle(layoutPos.spacingTop, 'top'));
        }
        // 下方间隔模式
        if (layoutPos && layoutPos.spacingBottom) {
            Object.assign(boxStyle, this.getBoxSpacingStyle(layoutPos.spacingBottom, 'bottom'));
        }
        // 左侧间隔模式
        if (layoutPos && layoutPos.spacingLeft) {
            Object.assign(boxStyle, this.getBoxSpacingStyle(layoutPos.spacingLeft, 'left'));
        }
        // 右侧间隔模式
        if (layoutPos && layoutPos.spacingRight) {
            Object.assign(boxStyle, this.getBoxSpacingStyle(layoutPos.spacingRight, 'right'));
        }
        // 图片背景容器（STYLE2特殊处理）
        if (this.panelItemModel && Object.is(this.panelItemModel.itemType, 'CONTAINER') && Object.is(this.panelItemModel.itemStyle, 'STYLE2')) {
            const sysImage = this.panelItemModel.getPSSysImage();
            if (sysImage && (sysImage.imagePath || sysImage.rawContent)) {
                Object.assign(boxStyle, { background: `url('${sysImage.imagePath || sysImage.rawContent}') no-repeat 0px 0px`, 'background-size': '100% 100%' });
                if (!boxStyle.width) {
                    Object.assign(boxStyle, { width: '100%' });
                }
                if (!boxStyle.height) {
                    Object.assign(boxStyle, { height: '100%' });
                }
            }
        }
        // 除去边缘布局其余类型容器超出均不收缩
        if ((layout && layout !== 'BORDER') || Object.is(this.itemType, 'TABPANEL') || Object.is(this.itemType, 'CTRLPOS')) {
            Object.assign(boxStyle, { 'flex-shrink': 0 });
        }
        if ((layout && layout === 'BORDER')) {
            if (!boxStyle.width) {
                Object.assign(boxStyle, { 'width': '100%' });
            }
            if (!boxStyle.height) {
                Object.assign(boxStyle, { 'height': '100%' });
            }
            Object.assign(boxStyle, { 'min-height': '1px' });
        }
        // 动态显示
        if (!this.$visible) {
            Object.assign(boxStyle, { 'display': 'none' });
        }
        return boxStyle;
    }

    /**
     * 获取盒子间隔样式
     *
     * @private
     * @param {string} spacingType
     * @memberof PanelDetailModel
     */
    private getBoxSpacingStyle(spacingType: string, direction: string) {
        switch (spacingType) {
            case 'OUTERNONE':
                return { [`margin-${direction}`]: '0px' };
            case 'OUTERSMALL':
                return { [`margin-${direction}`]: '8px' };
            case 'OUTERMEDIUM':
                return { [`margin-${direction}`]: '16px' };
            case 'OUTERLARGE':
                return { [`margin-${direction}`]: '24px' };
            case 'INNERNONE':
                return { [`padding-${direction}`]: '0px' };
            case 'INNERSMALL':
                return { [`padding-${direction}`]: '8px' };
            case 'INNERMEDIUM':
                return { [`padding-${direction}`]: '16px' };
            case 'INNERLARGE':
                return { [`padding-${direction}`]: '24px' };
            default:
                return {};
        }
    }

    /**
     * 获取盒子大小（宽高模式针对面板项，按钮等项模型是控制的布局内容的宽高）
     * @param mode 模式 "WIDTH" | "HEIGHT"
     * @param style 样式 "FULL"(全部宽度) | "PX"（像素） | "PERCENTAGE"（百分比）
     * @param value 
     * @returns 
     */
    private getBoxSize(mode: "WIDTH" | "HEIGHT", style: string, value: number) {
        if (!mode || !style) {
            return {};
        }
        if (style === "FULL") {
            return { [mode.toLowerCase()]: "100%" };
        } else {
            if (!value) {
                return {};
            }
            else if (style === "PERCENTAGE") {
                return { [mode.toLowerCase()]: `${value}%` };
            } else {
                return { [mode.toLowerCase()]: `${value}px` };
            }
        }
    }

    /**
     * 获取布局设置(约束子)
     *
     * @memberof PanelDetailModel
     */
    public getBoxLayoutStyle() {
        const boxLayoutStyle = {};
        let layout = this.panelItemModel?.getPSLayout() as any;
        const layoutPos = this.panelItemModel?.getPSLayoutPos() as any;
        if (layout && layout.layout == 'FLEX') {
            const { dir, align, vAlign } = layout;
            Object.assign(boxLayoutStyle, { 'display': 'flex' });
            if (dir) {
                Object.assign(boxLayoutStyle, { 'flex-direction': dir });
            }
            if (align) {
                Object.assign(boxLayoutStyle, { 'justify-content': align });
            }
            if (vAlign) {
                Object.assign(boxLayoutStyle, { 'align-items': vAlign });
            }
        }
        // 边缘布局占满剩余空间
        if (layout && layout.layout == 'BORDER') {
            Object.assign(boxLayoutStyle, { 'flex-grow': 1, height: '100%' });
        }
        if (layout && layout.layout == 'SIMPLEFLEX') {
            Object.assign(boxLayoutStyle, { display: 'flex', 'flex-wrap': 'wrap' });
        }
        return boxLayoutStyle;
    }

    /**
     * 获取自身位置（约束自身）
     *
     * @memberof PanelDetailModel
     */
    public getBoxLayoutPosStyle() {
        const boxLayoutPosStyle: any = {};
        const layoutPos = this.panelItemModel?.getPSLayoutPos() as any;
        // 识别flex占位属性
        if (layoutPos && layoutPos.layout == 'FLEX') {
            Object.assign(boxLayoutPosStyle, { 'flex-grow': layoutPos?.grow && layoutPos?.grow != -1 ? layoutPos?.grow : 0 });
        }
        // 自身对齐方式
        if (layoutPos && (layoutPos.vAlignSelf || layoutPos.hAlignSelf)) {
            Object.assign(boxLayoutPosStyle, { 'display': 'flex' });
            // 自身垂直对齐模式
            switch (layoutPos.vAlignSelf) {
                case 'TOP':
                    Object.assign(boxLayoutPosStyle, { 'align-items': 'flex-start' });
                    break;
                case 'MIDDLE':
                    Object.assign(boxLayoutPosStyle, { 'align-items': 'center' });
                    break;
                case 'BOTTOM':
                    Object.assign(boxLayoutPosStyle, { 'align-items': 'flex-end' });
                    break;
                default:
                    break;
            }
            // 自身水平对齐模式
            switch (layoutPos.hAlignSelf) {
                case 'LEFT':
                    Object.assign(boxLayoutPosStyle, { 'justify-content': 'flex-start' });
                    break;
                case 'CENTER':
                    Object.assign(boxLayoutPosStyle, { 'justify-content': 'center' });
                    break;
                case 'RIGHT':
                    Object.assign(boxLayoutPosStyle, { 'justify-content': 'flex-end' });
                    break;
                case 'JUSTIFY':
                    Object.assign(boxLayoutPosStyle, { 'justify-content': 'space-between' });
                    break;
                default:
                    break;
            }
            // 自身垂直对齐模式/自身水平对齐模式生效，没有flex-grow属性时默认占满剩余空间
            if (!boxLayoutPosStyle.hasOwnProperty('flex-grow')) {
                Object.assign(boxLayoutPosStyle, { 'flex-grow': 1 });
            }
        }
        if (layoutPos && layoutPos.layout == 'SIMPLEFLEX') {
            if (layoutPos?.grow && (layoutPos?.grow !== -1)) {
                Object.assign(boxLayoutPosStyle, { width: `${(100 / 12) * layoutPos?.grow}%`, height: 'auto' });
            } else {
                // 简单FLEX布局自适应
                Object.assign(boxLayoutPosStyle, { 'flex-grow': 1, 'min-width': `${(100 / 12)}%`, height: 'auto' });
            }
        }
        // 边缘布局
        if (layoutPos && layoutPos.layout == 'BORDER') {
            Object.assign(boxLayoutPosStyle, { display: 'flex' });
        }
        this.getCssStyle(boxLayoutPosStyle);
        return boxLayoutPosStyle;
    }

    /**
     * 获取边缘容器布局样式
     *
     * @return {*} 
     * @memberof PanelDetailModel
     */
     public getBorderLayoutStyle() {
        const borderLayoutStyle: any = { width: '100%', height: '100%' };
        const layoutPos = this.panelItemModel?.getPSLayoutPos() as any;
        if (layoutPos) {
            if (layoutPos.width) {
                Object.assign(borderLayoutStyle, { width: this.getBoxSize("WIDTH", layoutPos.widthMode, layoutPos.width) });
            }
            if (layoutPos.height) {
                Object.assign(borderLayoutStyle, { height: this.getBoxSize("HEIGHT", layoutPos.heightMode, layoutPos.height) });
            }
        }
        // 自身对齐方式
        if (layoutPos && (layoutPos.vAlignSelf || layoutPos.hAlignSelf)) {
            Object.assign(borderLayoutStyle, { 'display': 'flex' });
            // 自身垂直对齐模式
            switch (layoutPos.vAlignSelf) {
                case 'TOP':
                    Object.assign(borderLayoutStyle, { 'align-items': 'flex-start' });
                    break;
                case 'MIDDLE':
                    Object.assign(borderLayoutStyle, { 'align-items': 'center' });
                    break;
                case 'BOTTOM':
                    Object.assign(borderLayoutStyle, { 'align-items': 'flex-end' });
                    break;
                default:
                    break;
            }
            // 自身水平对齐模式
            switch (layoutPos.hAlignSelf) {
                case 'LEFT':
                    Object.assign(borderLayoutStyle, { 'justify-content': 'flex-start' });
                    break;
                case 'CENTER':
                    Object.assign(borderLayoutStyle, { 'justify-content': 'center' });
                    break;
                case 'RIGHT':
                    Object.assign(borderLayoutStyle, { 'justify-content': 'flex-end' });
                    break;
                case 'JUSTIFY':
                    Object.assign(borderLayoutStyle, { 'justify-content': 'space-between' });
                    break;
                default:
                    break;
            }
            // 自身垂直对齐模式/自身水平对齐模式生效，占满剩余空间
            if (!borderLayoutStyle['flex-grow']) {
                Object.assign(borderLayoutStyle, { 'flex-grow': 1 });
            }
        }
        this.getCssStyle(borderLayoutStyle);
        return borderLayoutStyle;
    }

    /**
     * @description 获取样式代码
     * @param {IParams} LayoutStyle
     * @memberof PanelDetailModel
     */
    public getCssStyle(LayoutStyle: IParams) {
        let cssStyle = this.panelItemModel?.M.cssStyle;
        if (cssStyle) {
            cssStyle = (cssStyle as string).replaceAll("\n", "");
            const cssItems = (cssStyle as string).split(';');
            cssItems.forEach((item: string) => {
                const values = item.split(':');
                if (values.length == 2) {
                    LayoutStyle[values[0]] = values[1];
                }
            })
        }
    }

    /**
     * 获取栅格布局的props
     *
     * @param {*} item 传入项 
     * @param {*} layMode 栅格模式布局 12列/24列
     * @returns {*}
     * @memberof AppDefaultViewLayout
     */
    public getGridLayoutProps(item: any, layMode: string = 'TABLE_24COL'): any {
        let { colXS, colSM, colMD, colLG, colXSOffset, colSMOffset, colMDOffset, colLGOffset } = item.getPSLayoutPos();
        // 设置初始值
        colXS = !colXS || colXS == -1 ? 24 : colXS;
        colSM = !colSM || colSM == -1 ? 24 : colSM;
        colMD = !colMD || colMD == -1 ? 24 : colMD;
        colLG = !colLG || colLG == -1 ? 24 : colLG;
        colXSOffset = !colXSOffset || colXSOffset == -1 ? 0 : colXSOffset;
        colSMOffset = !colSMOffset || colSMOffset == -1 ? 0 : colSMOffset;
        colMDOffset = !colMDOffset || colMDOffset == -1 ? 0 : colMDOffset;
        colLGOffset = !colLGOffset || colLGOffset == -1 ? 0 : colLGOffset;
        if (layMode == 'TABLE_12COL') {
            // 重新计算12列的栅格数值
            colXS = Math.min(colXS * 2, 24);
            colSM = Math.min(colSM * 2, 24);
            colMD = Math.min(colMD * 2, 24);
            colLG = Math.min(colXS * 2, 24);
            // 重新计算12列的栅格偏移
            let sign = (num: number) => (num == 0 ? 0 : num / Math.abs(num));
            colXSOffset = sign(colXSOffset) * Math.min(colXSOffset * 2, 24);
            colSMOffset = sign(colSMOffset) * Math.min(colSMOffset * 2, 24);
            colMDOffset = sign(colMDOffset) * Math.min(colMDOffset * 2, 24);
            colLGOffset = sign(colLGOffset) * Math.min(colLGOffset * 2, 24);
        }
        return {
            xs: { span: colXS, offset: colXSOffset },
            sm: { span: colSM, offset: colSMOffset },
            md: { span: colMD, offset: colMDOffset },
            lg: { span: colLG, offset: colLGOffset },
        };
    }
}