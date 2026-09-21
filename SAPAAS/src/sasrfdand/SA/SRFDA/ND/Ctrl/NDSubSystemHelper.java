/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DASubSystemHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.DASubSystemHelper;
import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDConfigValueHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.Web.ISRFDAWebContext;

public class NDSubSystemHelper
extends DASubSystemHelper {
    public void InitUserSession(ISRFDAWebContext iSRFDAWebContext) throws Exception {
        super.InitUserSession(iSRFDAWebContext);
        INDModelStorage iNDModelStorage = NDModelStorageFactory.Create(this.getDAGlobalHelper());
        INDConfigTypeHelper iNDConfigTypeHelper = iNDModelStorage.FindNDConfigType("NDORGTREE");
        INDConfigValueHelper iNDConfigValue = iNDConfigTypeHelper.FindNDConfigValue("PICKUPORGTREE");
        iSRFDAWebContext.SetSessionValue("NDPICKUPORGTREEID", (Object)iNDConfigValue.getConfigValue());
    }

    public void InitGlobalSession() throws Exception {
        super.InitGlobalSession();
    }
}

