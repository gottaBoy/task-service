/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTConfigValueHelper;
import SA.WT.Ctrl.WTBaseObject;
import SA.WT.Data.WTConfigValue;

public class WTConfigValueHelper
extends WTBaseObject
implements IWTConfigValueHelper {
    private IWTConfigTypeHelper iWTConfigTypeHelper = null;
    private WTConfigValue imConfigValue = null;
    private String strConfigValue = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWTConfigTypeHelper iWTConfigTypeHelper, WTConfigValue imConfigValue) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(imConfigValue.getWTCONFIGVALUEID());
        this.setName(imConfigValue.getWTCONFIGVALUENAME());
        this.iWTConfigTypeHelper = iWTConfigTypeHelper;
        this.imConfigValue = imConfigValue;
        this.strConfigValue = imConfigValue.getCONFIGVALUE();
        this.OnInit();
    }

    @Override
    public String getConfigValue() {
        return this.strConfigValue;
    }
}

