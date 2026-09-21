/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDConfigValueHelper;
import SA.SRFDA.ND.Ctrl.NDBaseObject;
import SA.SRFDA.ND.Data.NDConfigValue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class NDConfigValueHelper
extends NDBaseObject
implements INDConfigValueHelper {
    private INDConfigTypeHelper iNDConfigTypeHelper = null;
    private NDConfigValue ndConfigValue = null;
    private String strConfigValue = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, INDConfigTypeHelper iNDConfigTypeHelper, NDConfigValue ndConfigValue) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(ndConfigValue.getNDCONFIGVALUEID());
        this.setName(ndConfigValue.getNDCONFIGVALUENAME().toUpperCase());
        this.iNDConfigTypeHelper = iNDConfigTypeHelper;
        this.ndConfigValue = ndConfigValue;
        this.strConfigValue = ndConfigValue.getCONFIGVALUE();
        this.OnInit();
    }

    @Override
    public String getConfigValue() {
        return this.strConfigValue;
    }
}

