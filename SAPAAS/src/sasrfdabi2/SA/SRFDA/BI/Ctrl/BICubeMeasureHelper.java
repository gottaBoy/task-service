/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.BaseBIObject
 *  SA.SRFDA.BI.Ctrl.Data.BICubeMeasure
 *  SA.SRFDA.BI.Ctrl.IBICubeHelper
 *  SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public abstract class BICubeMeasureHelper
extends BaseBIObject
implements IBICubeMeasureHelper {
    private String strShortId = "";
    protected IBICubeHelper iBICubeHelper = null;
    protected BICubeMeasure biCubeMeasure = null;
    private String strUniqueName = "";
    private int nColumnWidth = 100;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBICubeHelper iBICubeHelper, BICubeMeasure biCubeMeasure) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBICubeHelper = iBICubeHelper;
        this.biCubeMeasure = biCubeMeasure;
        this.strUniqueName = StringHelper.Format((String)"[Measures].[%1$s]", (Object)biCubeMeasure.getBICUBEMEASURENAME());
        if (!biCubeMeasure.isCOLUMNWIDTHNull()) {
            this.nColumnWidth = biCubeMeasure.getCOLUMNWIDTH();
            if (this.nColumnWidth <= 0 || this.nColumnWidth >= 1000) {
                this.nColumnWidth = 100;
            }
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public String getShortId() {
        return this.strShortId;
    }

    public void setShortId(String strShortId) {
        this.strShortId = strShortId;
    }

    public String getId() {
        return this.biCubeMeasure.getBICUBEMEASUREID();
    }

    public String getUniqueName() {
        return this.strUniqueName;
    }

    public IBICubeHelper getBICube() {
        return this.iBICubeHelper;
    }

    public int getColumnWidth() {
        return this.nColumnWidth;
    }

    public String getMeasureGroup() {
        return this.biCubeMeasure.getMEASUREGROUP();
    }

    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.biCubeMeasure.getCAPTION())) {
            return this.biCubeMeasure.getBICUBEMEASURENAME();
        }
        return this.biCubeMeasure.getCAPTION();
    }

    public String getFormat() {
        if (StringHelper.Compare((String)this.biCubeMeasure.getFMTTYPE(), (String)"CUSTOM", (boolean)true) == 0) {
            return this.biCubeMeasure.getCUSTOMFMT();
        }
        return this.biCubeMeasure.getFMTTYPE();
    }
}

