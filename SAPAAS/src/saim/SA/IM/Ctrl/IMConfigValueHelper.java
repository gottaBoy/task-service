/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMConfigValue;
import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.IM.Ctrl.IIMConfigValueHelper;
import SA.IM.Ctrl.IMBaseObject;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class IMConfigValueHelper
extends IMBaseObject
implements IIMConfigValueHelper {
    private IIMConfigTypeHelper iIMConfigTypeHelper = null;
    private IMConfigValue imConfigValue = null;
    private String strConfigValue = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IIMConfigTypeHelper iIMConfigTypeHelper, IMConfigValue imConfigValue) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(imConfigValue.getIMCONFIGVALUEID());
        this.setName(imConfigValue.getIMCONFIGVALUENAME());
        this.iIMConfigTypeHelper = iIMConfigTypeHelper;
        this.imConfigValue = imConfigValue;
        this.strConfigValue = imConfigValue.getCONFIGVALUE();
        this.OnInit();
    }

    @Override
    public String getConfigValue() {
        return this.strConfigValue;
    }
}

