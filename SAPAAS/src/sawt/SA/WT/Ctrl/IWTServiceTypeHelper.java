/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Data.WTServiceType;

public interface IWTServiceTypeHelper
extends IWTObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, WTServiceType var2) throws Exception;

    public IWTServiceHelper CreateWTServiceHelper() throws Exception;
}

