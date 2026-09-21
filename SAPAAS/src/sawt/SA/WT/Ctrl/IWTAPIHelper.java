/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.WTCallResult;
import SA.WT.Data.WTUser;
import SA.WT.Data.WTUserGroup;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public interface IWTAPIHelper {
    public void Init(ISRFDAGlobalHelper var1, IWTAccountHelper var2) throws Exception;

    public WTCallResult getAccessToken();

    public WTCallResult PublishMenu(JSONObject var1);

    public WTCallResult ListUserGroup(Vector<WTUserGroup> var1);

    public WTCallResult CreateUserGroup(WTUserGroup var1);

    public WTCallResult UpdateUserGroup(WTUserGroup var1);

    public WTCallResult ListUser(ArrayList<String> var1);

    public WTCallResult GetUser(WTUser var1);
}

