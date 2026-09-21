/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTAPIHelper;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Data.WTAccount;

public interface IWTAccountHelper
extends IWTObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, WTAccount var2) throws Exception;

    public String getAPIAppId();

    public String getAPIAppSecret();

    public String getAPIAccessToken();

    public IWTAPIHelper getWTAPI();

    public void PublishWTMenu() throws Exception;

    public void SyncWTUserGroup(boolean var1) throws Exception;

    public void SyncWTUser(boolean var1) throws Exception;

    public String ProcessIncomeMessage(String var1) throws Exception;
}

