/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IWFEngineContext {
    public void Log(int var1, String var2);

    public String getExecuteMode();

    public void setActiveDataEntity(BaseDataEntity var1);

    public BaseDataEntity getActiveDataEntity();

    public void setGlobalDataEntity(BaseDataEntity var1);

    public BaseDataEntity getGlobalDataEntity();

    public BaseDBCallerHelperEx getDBCallerHelper();

    public String getNext();

    public void setNext(String var1);

    public void setUserParam(String var1, Object var2);

    public Object getUserParam(String var1);

    public void RemoveUserParam(String var1);

    public String getOpPersonId();
}

