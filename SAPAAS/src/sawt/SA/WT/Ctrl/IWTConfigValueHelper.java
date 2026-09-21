/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Data.WTConfigValue;

public interface IWTConfigValueHelper
extends IWTObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IWTConfigTypeHelper var2, WTConfigValue var3) throws Exception;

    public String getConfigValue();
}

