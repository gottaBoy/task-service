/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDObjectHelper;
import SA.SRFDA.ND.Data.NDConfigValue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface INDConfigValueHelper
extends INDObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, INDConfigTypeHelper var2, NDConfigValue var3) throws Exception;

    public String getConfigValue();
}

