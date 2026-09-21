/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSGridLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSGridLayoutPosImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSLayout", typevalues={"TABLE_12COL"})
public class PSGrid12LayoutImpl
extends PSLayoutImplBase
implements IPSGridLayout {
    private int nChildColXS = -1;
    private int nChildColSM = -1;
    private int nChildColMD = 12;
    private int nChildColLG = -1;

    @Override
    protected void onInit() throws Exception {
        int nColumnCount;
        boolean bEnableCol12ToCol24 = this.isEnableCol12ToCol24();
        this.nChildColMD = nColumnCount = this.getColumnCount();
        if (!this.getPSLayoutData().isCHILD_COL_XSNull()) {
            this.nChildColXS = this.getPSLayoutData().getCHILD_COL_XS();
            if (bEnableCol12ToCol24) {
                this.nChildColXS *= 2;
            }
            if (this.nChildColXS <= 0 || this.nChildColXS > nColumnCount) {
                this.nChildColXS = -1;
            }
        }
        if (!this.getPSLayoutData().isCHILD_COL_SMNull()) {
            this.nChildColSM = this.getPSLayoutData().getCHILD_COL_SM();
            if (bEnableCol12ToCol24) {
                this.nChildColSM *= 2;
            }
            if (this.nChildColSM <= 0 || this.nChildColSM > nColumnCount) {
                this.nChildColSM = -1;
            }
        }
        if (!this.getPSLayoutData().isCHILD_COL_MDNull()) {
            this.nChildColMD = this.getPSLayoutData().getCHILD_COL_MD();
            if (bEnableCol12ToCol24) {
                this.nChildColMD *= 2;
            }
            if (this.nChildColMD <= 0 || this.nChildColMD > nColumnCount) {
                this.nChildColMD = nColumnCount;
            }
        }
        if (!this.getPSLayoutData().isCHILD_COL_LGNull()) {
            this.nChildColLG = this.getPSLayoutData().getCHILD_COL_LG();
            if (bEnableCol12ToCol24) {
                this.nChildColLG *= 2;
            }
            if (this.nChildColLG <= 0 || this.nChildColLG > nColumnCount) {
                this.nChildColLG = -1;
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", group="\u4f4d\u7f6e")
    public String getLayout() {
        return "TABLE_12COL";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u91cf", group="\u4f4d\u7f6e", staticcode="12")
    public int getColumnCount() {
        return 12;
    }

    @Override
    public boolean isEnableCol12ToCol24() {
        return false;
    }

    @Override
    protected IPSLayoutPos createPSLayoutPos() throws Exception {
        return new PSGridLayoutPosImpl();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6210\u5458\u9ed8\u8ba4\u5217\u6570\u91cf\uff08\u6781\u5c0f\uff09", group="\u4f4d\u7f6e", ignorepf=true, ignoredumpvalues="-1", ignorert=3)
    public int getChildColXS() {
        return this.nChildColXS;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6210\u5458\u9ed8\u8ba4\u5217\u6570\u91cf\uff08\u5c0f\u578b\uff09", group="\u4f4d\u7f6e", ignorepf=true, ignoredumpvalues="-1", ignorert=3)
    public int getChildColSM() {
        return this.nChildColSM;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6210\u5458\u9ed8\u8ba4\u5217\u6570\u91cf\uff08\u4e2d\u578b\uff09", group="\u4f4d\u7f6e", ignorepf=true, ignoredumpvalues="-1", ignorert=3)
    public int getChildColMD() {
        return this.nChildColMD;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6210\u5458\u9ed8\u8ba4\u5217\u6570\u91cf\uff08\u5927\u578b\uff09", group="\u4f4d\u7f6e", ignorepf=true, ignoredumpvalues="-1", ignorert=3)
    public int getChildColLG() {
        return this.nChildColLG;
    }
}

