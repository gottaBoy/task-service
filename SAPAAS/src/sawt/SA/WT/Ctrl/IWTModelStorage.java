/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.IWTServiceTypeHelper;

public interface IWTModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public IWTConfigTypeHelper FindWTConfigType(String var1) throws Exception;

    public IWTAccountHelper FindWTAccount(String var1) throws Exception;

    public void ResetWTAccount(String var1) throws Exception;

    public IWTServiceTypeHelper FindWTServiceType(String var1) throws Exception;

    public void ResetWTServiceType(String var1) throws Exception;

    public IWTServiceHelper FindWTService(String var1) throws Exception;

    public IWTServiceHelper FindWTServiceByCode(String var1) throws Exception;

    public void ResetWTService(String var1) throws Exception;
}

