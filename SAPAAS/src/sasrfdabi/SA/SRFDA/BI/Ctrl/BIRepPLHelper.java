/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepPL;
import SA.SRFDA.BI.Ctrl.IBIRepPLHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BIRepPLHelper
extends BaseBIObject
implements IBIRepPLHelper {
    protected String strCtrlName = "";
    protected String strNamespace = "";
    protected BIRepPL biRepPL = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIRepPL biRepPL) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPL = biRepPL;
        String strFullObjectName = this.biRepPL.getOBJECTNAME();
        String[] items = strFullObjectName.split(".");
        if (items.length > 0) {
            this.strCtrlName = items[items.length - 1];
        }
        this.strNamespace = this.biRepPL.getNAMESPACE();
        if (StringHelper.IsNullOrEmpty((String)this.strNamespace)) {
            this.strNamespace = "http://schemas.softanywhere.com/2011/xaml/bi";
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIRepPL getBIRepPL() {
        return this.biRepPL;
    }

    @Override
    public String getNamespace() {
        return this.strNamespace;
    }

    @Override
    public String getCtrlName() {
        return this.strCtrlName;
    }
}

