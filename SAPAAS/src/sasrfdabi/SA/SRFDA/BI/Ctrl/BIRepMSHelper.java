/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepMS;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BIRepMSHelper
extends BaseBIObject
implements IBIRepMSHelper {
    protected IBIReportExHelper iBIReportExHelper = null;
    protected BIRepMS biRepMS = null;
    protected IBICubeMeasureHelper iBICubeMeasureHelper = null;
    private int nColumnWidth = 100;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIReportExHelper iBIReportExHelper, BIRepMS biRepMS) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBIReportExHelper = iBIReportExHelper;
        this.biRepMS = biRepMS;
        this.iBICubeMeasureHelper = iBIReportExHelper.getBICube().FindBICubeMeasure(this.biRepMS.getBICUBEMEASUREID());
        if (!biRepMS.isCOLUMNWIDTHNull()) {
            this.nColumnWidth = biRepMS.getCOLUMNWIDTH();
        }
        if (this.nColumnWidth <= 0 || this.nColumnWidth >= 1000) {
            this.nColumnWidth = this.iBICubeMeasureHelper.getColumnWidth();
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBICubeMeasureHelper getBICubeMeasure() {
        return this.iBICubeMeasureHelper;
    }

    @Override
    public int getPlacePos() {
        return this.biRepMS.getPLACEPOS();
    }

    @Override
    public int getColumnWidth() {
        return this.nColumnWidth;
    }

    @Override
    public String getGroupName() {
        return this.iBICubeMeasureHelper.getMeasureGroup();
    }

    @Override
    public String getLogicName() {
        return this.iBICubeMeasureHelper.getLogicName();
    }
}

