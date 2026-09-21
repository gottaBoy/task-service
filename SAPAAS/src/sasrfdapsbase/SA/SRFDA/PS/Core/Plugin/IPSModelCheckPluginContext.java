/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;

public interface IPSModelCheckPluginContext {
    public IPSSystem getPSSystem();

    public IPSDataEntity getPSDataEntity();

    public IPSApplication getPSApplication();

    public int getIssueCount();

    public IPSModelObject getPSModelObject();

    public void logIssue(String var1, String var2) throws Exception;
}

