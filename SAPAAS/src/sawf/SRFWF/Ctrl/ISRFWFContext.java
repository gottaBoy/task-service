/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Model.WFBaseProcessConfig;

public interface ISRFWFContext {
    public BaseDBCallerHelperEx getDBCallerHelperEx();

    public String getCurUserId();

    public void setNext(String var1);

    public void Log(int var1, Object var2, String var3);

    public BaseDataEntity getActiveObject();

    public WFBaseProcessConfig getCurProcessConfig();

    public String getInteractiveConnection();

    public void setFinishInteractiveProcess(boolean var1);

    public ContextHelper getContextHelper();

    public String GetWorkflowId();

    public void AppendReturnInfo(String var1);

    public WFInstance getInstance();

    public String GetUserTag();

    public String GetUserTag2();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);
}

