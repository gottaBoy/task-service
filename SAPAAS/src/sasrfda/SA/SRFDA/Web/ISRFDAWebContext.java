/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.ISRFExWebContext
 */
package SA.SRFDA.Web;

import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFDA.Web.SRFDAConfigCache;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.util.Map;

public interface ISRFDAWebContext
extends ISRFExWebContext {
    public ISRFDAGlobalHelper getGlobalHelper();

    public IUserRoleHelper GetUserRoleHelper();

    public UserQueryModelStorage GetUserQueryModelStorage();

    public SRFDAConfigCache GetConfigCache();

    public String GetQueryStringWithoutDAParam(Map<String, String> var1);

    public String getSRFWFMode();

    public String GetPostValue(String var1, String var2);

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);
}

