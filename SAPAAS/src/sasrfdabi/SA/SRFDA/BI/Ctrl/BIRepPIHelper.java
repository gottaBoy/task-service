/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepPI;
import SA.SRFDA.BI.Ctrl.IBIRepPIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BIRepPIHelper
extends BaseBIObject
implements IBIRepPIHelper {
    protected IBIRepPanelHelper biRepPanelHelper;
    protected BIRepPI biRepPI;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepPanelHelper biRepPanelHelper, BIRepPI biRepPI) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPanelHelper = biRepPanelHelper;
        this.biRepPI = biRepPI;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIRepPI getBIRepPI() {
        return this.biRepPI;
    }

    @Override
    public String getBIRepPartId() {
        return this.biRepPI.getBIREPPARTID();
    }

    @Override
    public String getBIRepPIId() {
        return this.biRepPI.getBIREPPINAME();
    }

    @Override
    public String getCustomContent() {
        return this.biRepPI.getCUSTOMCONTENT();
    }

    @Override
    public String getBIRepPDSId() {
        return this.biRepPI.getBIREPPDSID();
    }

    @Override
    public String getBIRepPQId() {
        return this.biRepPI.getBIREPPQID();
    }

    @Override
    public String getCustomCaption() {
        return this.biRepPI.getCAPTION();
    }

    @Override
    public boolean isShowCaption() {
        if (this.biRepPI.isSHOWCAPTIONNull()) {
            return true;
        }
        return this.biRepPI.getSHOWCAPTION();
    }

    @Override
    public boolean isShowBorder() {
        if (this.biRepPI.isSHOWBORDERNull()) {
            return true;
        }
        return this.biRepPI.getSHOWBORDER();
    }
}

