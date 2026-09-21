/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public IWSPageTypeHelper FindWSPageTypeHelper(String var1) throws Exception;

    public IWSPageTemplHelper FindWSPageTemplHelper(String var1) throws Exception;

    public IWSWBTypeHelper FindWSWBTypeHelper(String var1) throws Exception;

    public IWSWebPartHelper FindWSWebPartHelper(String var1) throws Exception;

    public IWSWebSiteHelper FindWSWebSiteHelper(String var1) throws Exception;
}

