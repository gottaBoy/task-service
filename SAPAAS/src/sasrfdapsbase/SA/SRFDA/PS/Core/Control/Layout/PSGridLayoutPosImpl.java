/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSGridLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSGridLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutPosImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSLayoutPos", typevalues={"TABLE_12COL", "TABLE_24COL"})
public class PSGridLayoutPosImpl
extends PSLayoutPosImplBase
implements IPSGridLayoutPos {
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    private int nColWidth = -1;

    @Override
    protected void onInit() throws Exception {
        IPSGridLayout iPSGridLayout = null;
        if (!(this.getParentPSLayout() instanceof IPSGridLayout)) {
            throw new Exception("\u90e8\u4ef6\u5bb9\u5668\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        iPSGridLayout = (IPSGridLayout)this.getParentPSLayout();
        int nColumnCount = iPSGridLayout.getColumnCount();
        boolean bEnableCol12ToCol24 = iPSGridLayout.isEnableCol12ToCol24();
        if (!this.getPSLayoutData().isCOL_XSNull()) {
            this.nColXS = this.getPSLayoutData().getCOL_XS();
            if (bEnableCol12ToCol24) {
                this.nColXS *= 2;
            }
            if (this.nColXS <= 0 || this.nColXS > nColumnCount) {
                this.nColXS = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_SMNull()) {
            this.nColSM = this.getPSLayoutData().getCOL_SM();
            if (bEnableCol12ToCol24) {
                this.nColSM *= 2;
            }
            if (this.nColSM <= 0 || this.nColSM > nColumnCount) {
                this.nColSM = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_MDNull()) {
            this.nColMD = this.getPSLayoutData().getCOL_MD();
            if (bEnableCol12ToCol24) {
                this.nColMD *= 2;
            }
            if (this.nColMD <= 0 || this.nColMD > nColumnCount) {
                this.nColMD = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_LGNull()) {
            this.nColLG = this.getPSLayoutData().getCOL_LG();
            if (bEnableCol12ToCol24) {
                this.nColLG *= 2;
            }
            if (this.nColLG <= 0 || this.nColLG > nColumnCount) {
                this.nColLG = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_XS_OSNull()) {
            this.nColXSOffset = this.getPSLayoutData().getCOL_XS_OS();
            if (bEnableCol12ToCol24) {
                this.nColXSOffset *= 2;
            }
            if (this.nColXSOffset <= 0 || this.nColXSOffset > nColumnCount - 1) {
                this.nColXSOffset = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_SM_OSNull()) {
            this.nColSMOffset = this.getPSLayoutData().getCOL_SM_OS();
            if (bEnableCol12ToCol24) {
                this.nColSMOffset *= 2;
            }
            if (this.nColSMOffset <= 0 || this.nColSMOffset > nColumnCount - 1) {
                this.nColSMOffset = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_MD_OSNull()) {
            this.nColMDOffset = this.getPSLayoutData().getCOL_MD_OS();
            if (bEnableCol12ToCol24) {
                this.nColMDOffset *= 2;
            }
            if (this.nColMDOffset <= 0 || this.nColMDOffset > nColumnCount - 1) {
                this.nColMDOffset = -1;
            }
        }
        if (!this.getPSLayoutData().isCOL_LG_OSNull()) {
            this.nColLGOffset = this.getPSLayoutData().getCOL_LG_OS();
            if (bEnableCol12ToCol24) {
                this.nColLGOffset *= 2;
            }
            if (this.nColLGOffset <= 0 || this.nColLGOffset > nColumnCount - 1) {
                this.nColLGOffset = -1;
            }
        }
        if (this.nColXS == -1) {
            this.nColXS = iPSGridLayout.getChildColXS();
        }
        if (this.nColSM == -1) {
            this.nColSM = iPSGridLayout.getChildColSM();
        }
        if (this.nColMD == -1) {
            this.nColMD = iPSGridLayout.getChildColMD();
        }
        if (this.nColLG == -1) {
            this.nColLG = iPSGridLayout.getChildColLG();
        }
        if (!this.getPSLayoutData().isCOL_WIDTHNull()) {
            this.nColWidth = this.getPSLayoutData().getCOL_WIDTH();
            if (this.nColWidth <= 0) {
                this.nColWidth = -1;
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8d85\u5c0f\u5217\u5bbd", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_XS"}, ignoresetvalues="-1")
    public int getColXS() {
        return this.nColXS;
    }

    @Override
    @PSModelRTMeta(description="\u5c0f\u578b\u5217\u5bbd", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_SM"}, ignoresetvalues="-1")
    public int getColSM() {
        return this.nColSM;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u578b\u5217\u5bbd", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_MD"}, ignoresetvalues="-1")
    public int getColMD() {
        return this.nColMD;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u578b\u5217\u5bbd", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_LG"}, ignoresetvalues="-1")
    public int getColLG() {
        return this.nColLG;
    }

    @Override
    @PSModelRTMeta(description="\u8d85\u5c0f\u504f\u79fb", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_XS_OS"}, ignoresetvalues="-1")
    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    @Override
    @PSModelRTMeta(description="\u5c0f\u578b\u504f\u79fb", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_SM_OS"}, ignoresetvalues="-1")
    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u578b\u504f\u79fb", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_MD_OS"}, ignoresetvalues="-1")
    public int getColMDOffset() {
        return this.nColMDOffset;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u578b\u504f\u79fb", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_LG_OS"}, ignoresetvalues="-1")
    public int getColLGOffset() {
        return this.nColLGOffset;
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u5217\u5bbd", ignoredumpvalues="-1", group="\u4f4d\u7f6e", fields={"COL_WIDTH"}, ignoresetvalues="-1")
    public int getColWidth() {
        return this.nColWidth;
    }
}

