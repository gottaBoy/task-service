/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepDM;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BIRepDMHelper
extends BaseBIObject
implements IBIRepDMHelper {
    protected IBIReportExHelper iBIReportExHelper = null;
    protected BIRepDM biRepDM = null;
    protected IBIDimensionHelper iBIDimensionHelper = null;
    protected IBIHierarchyHelper iBIHierarchyHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIReportExHelper iBIReportExHelper, BIRepDM biRepDM) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBIReportExHelper = iBIReportExHelper;
        this.biRepDM = biRepDM;
        this.iBIDimensionHelper = iBIReportExHelper.getBICube().FindBIDimension(this.biRepDM.getBICUBEDIMENSIONID());
        this.iBIHierarchyHelper = this.iBIDimensionHelper.FindBIHierarchy(this.biRepDM.getBIHIERARCHYID());
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIDimensionHelper getBIDimension() {
        return this.iBIDimensionHelper;
    }

    @Override
    public IBIHierarchyHelper getBIHierarchy() {
        return this.iBIHierarchyHelper;
    }

    @Override
    public boolean isEnableFilter() {
        if (this.biRepDM.isENABLEFILTERNull()) {
            return true;
        }
        return this.biRepDM.getENABLEFILTER();
    }

    @Override
    public int getFilterPos() {
        if (!this.biRepDM.isFILTERPOSNull()) {
            if (this.biRepDM.isPLACEPOSNull()) {
                return 999999;
            }
            return this.biRepDM.getPLACEPOS();
        }
        return this.biRepDM.getFILTERPOS();
    }

    @Override
    public String getPlacement() {
        return this.biRepDM.getPLACEMENT();
    }

    @Override
    public int getColumnWidth() {
        return this.getBIHierarchy().getColumnWidth();
    }

    @Override
    public String getPlaceType() {
        if (StringHelper.Compare((String)this.getPlacement(), (String)"COLHEADER", (boolean)true) == 0) {
            return "FROZEN";
        }
        if (StringHelper.Compare((String)this.getPlacement(), (String)"ROWHEADER", (boolean)true) == 0) {
            return this.biRepDM.getPLACETYPE();
        }
        return "";
    }

    @Override
    public boolean isOutputAll() {
        return this.biRepDM.getALLDATAFLAG();
    }
}

