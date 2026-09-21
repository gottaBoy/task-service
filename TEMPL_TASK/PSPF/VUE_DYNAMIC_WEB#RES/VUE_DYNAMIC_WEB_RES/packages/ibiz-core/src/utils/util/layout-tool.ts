import { AppServiceBase } from "../../service";
import { LogUtil } from "../log-util/log-util";
import { Util } from "./util";

/**
 * 布局工具类
 *
 * @export
 * @class LayoutTool
 */
export class LayoutTool {
    /**
     * 获取flex布局样式（容器）
     *
     * @static
     * @param {*} layout 布局设置
     * @returns {string}
     * @memberof LayoutTool
     */
    public static getFlexStyle(layout: any): string {
        const { dir, align, vAlign } = layout;
        let cssStyle: string = 'width: 100%; height: 100%; overflow: auto; display: flex;';
        cssStyle += dir ? `flex-direction: ${dir};` : '';
        cssStyle += align ? `justify-content: ${align};` : '';
        cssStyle += vAlign ? `align-items: ${vAlign};` : '';
        return cssStyle;
    }

    public static clacStyleSize(size: number) {
        if (Util.isNumber(size)) {
            if (size > 0 && size <= 1) {
                return `${size * 100}%`
            } else if (size > 1) {
                return `${size}px`
            }
        }
    }

    /**
     * 获取flex布局样式2(子)
     *
     * @static
     * @param {*} layoutPos 布局位置
     * @returns {string}
     * @memberof LayoutTool
     */
    public static getFlexStyle2(layoutPos: any): string {
        if (layoutPos?.layout == 'FLEX') {
            let grow = !layoutPos?.grow || layoutPos.grow < 0 ? 0 : layoutPos.grow;
            let width = this.clacStyleSize(layoutPos.width);
            let height = this.clacStyleSize(layoutPos.height);
            return `flex-grow: ${grow}; ${width ? `width: ${width};` : grow > 0 ? 'min-width: 0;': ''} ${height ? `height: ${height}` : grow > 0 ? 'min-height: 0;' : ''}`;
        }
        return ''
    }

    /**
     * 获取栅格布局参数
     *
     * @static
     * @param {*} layoutPos
     * @memberof LayoutTool
     */
    public static getGridOptions(layoutPos: any, isTurn24: boolean = true) {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        // 启用修复（无值不输出）
        if (Environment.enableIssue) {
            if (layoutPos) {
                const computeLayout = {};
                let multiplier = 1;
                if (isTurn24) {
                    multiplier = layoutPos.layout == 'TABLE_24COL' ? 1 : 2;
                }
                if (layoutPos.colLG !== -1) {
                    const colLG = this.formatColSpan(layoutPos.colLG, layoutPos.layout);
                    const colLGOffset = Util.isNumber(layoutPos.colLGOffset) ? layoutPos.colLGOffset : 0;
                    Object.assign(computeLayout, { lg: { span: colLG * multiplier, offset: colLGOffset * multiplier } });
                }
                if (layoutPos.colMD !== -1) {
                    const colMD = this.formatColSpan(layoutPos.colMD, layoutPos.layout);
                    const colMDOffset = Util.isNumber(layoutPos.colMDOffset) ? layoutPos.colMDOffset : 0;
                    Object.assign(computeLayout, { md: { span: colMD * multiplier, offset: colMDOffset * multiplier } });
                }
                if (layoutPos.colSM !== -1) {
                    const colSM = this.formatColSpan(layoutPos.colSM, layoutPos.layout);
                    const colSMOffset = Util.isNumber(layoutPos.colSMOffset) ? layoutPos.colSMOffset : 0;
                    Object.assign(computeLayout, { sm: { span: colSM * multiplier, offset: colSMOffset * multiplier } });
                }
                if (layoutPos.colXS !== -1) {
                    const colXS = this.formatColSpan(layoutPos.colXS, layoutPos.layout);
                    const colXSOffset = Util.isNumber(layoutPos.colXSOffset) ? layoutPos.colXSOffset : 0;
                    Object.assign(computeLayout, { xs: { span: colXS * multiplier, offset: colXSOffset * multiplier } });
                }
                return computeLayout;
            } else {
                LogUtil.error('布局信息未配置');
            }
        } else {
            if (layoutPos) {
                let colLG = this.formatColSpan(layoutPos.colLG, layoutPos.layout);
                let colMD = this.formatColSpan(layoutPos.colMD, layoutPos.layout);
                let colSM = this.formatColSpan(layoutPos.colSM, layoutPos.layout);
                let colXS = this.formatColSpan(layoutPos.colXS, layoutPos.layout);
                let colLGOffset = Util.isNumber(layoutPos.colLGOffset) ? layoutPos.colLGOffset : 0;
                let colMDOffset = Util.isNumber(layoutPos.colMDOffset) ? layoutPos.colMDOffset : 0;
                let colSMOffset = Util.isNumber(layoutPos.colSMOffset) ? layoutPos.colSMOffset : 0;
                let colXSOffset = Util.isNumber(layoutPos.colXSOffset) ? layoutPos.colXSOffset : 0;
                let multiplier = 1;
                if (isTurn24) {
                    multiplier = layoutPos.layout == 'TABLE_24COL' ? 1 : 2;
                }
                return {
                    xs: { span: colXS * multiplier, offset: colXSOffset * multiplier },
                    sm: { span: colSM * multiplier, offset: colSMOffset * multiplier },
                    md: { span: colMD * multiplier, offset: colMDOffset * multiplier },
                    lg: { span: colLG * multiplier, offset: colLGOffset * multiplier },
                }
            }
        }
    }

    /**
     * 格式化栅格的列宽,对超出范围值的作出修改或设置默认值
     *
     * @static
     * @param {*} span 栅格列宽
     * @param {string} layoutType 栅格类型(TABLE_24COL,TABLE_12COL)
     * @returns
     * @memberof LayoutTool
     */
    public static formatColSpan(span: any, layoutType: string) {
        let colDefault = layoutType == 'TABLE_24COL' ? 24 : 12;
        // 空值传默认值
        if (!Util.isNumber(span)) {
            return colDefault;
        }
        // 小于0传默认值，大于默认值传默认值，其他传原值
        if (span < 0 || span > colDefault) {
            return colDefault;
        } else {
            return span
        }
    }

    /**
     * 计算栅格占位
     *
     * @static
     * @param {*} span
     * @param {string} layoutType
     * @return {*} 
     * @memberof LayoutTool
     */
    public static calcColSpan(span: any, layoutType: string = 'TABLE_24COL') {
        const colDefault = layoutType == 'TABLE_24COL' ? 24 : 12;
        const multiplier = layoutType == 'TABLE_24COL' ? 1 : 2;
        // 空值传默认值
        if (!Util.isNumber(span)) {
            return colDefault;
        }
        // 小于0传默认值，大于默认值传默认值，其他传原值
        if (span < 0 || span > colDefault) {
            return colDefault;
        } else {
            return span * multiplier
        }
    }

    /**
     * 计算栅格偏移
     *
     * @static
     * @param {*} offset
     * @param {string} layoutType
     * @memberof LayoutTool
     */
    public static calcOffsetSpan(offset: any, layoutType: string = 'TABLE_24COL') {
        const colDefault = layoutType == 'TABLE_24COL' ? 24 : 12;
        const multiplier = layoutType == 'TABLE_24COL' ? 1 : 2;
        if (!Util.isNumber(offset) || offset < 0 || offset > colDefault) {
            return 0;
        }
        return offset * multiplier;
    }
}