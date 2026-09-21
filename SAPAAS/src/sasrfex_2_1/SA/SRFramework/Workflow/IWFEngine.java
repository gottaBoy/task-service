/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Workflow.IWFEngineContext;
import SA.SRFramework.Workflow.WFConfig;

public interface IWFEngine {
    public boolean Init(WFConfig var1);

    public void Quit();

    public boolean Execute(BaseDataEntity var1, BaseDataEntity var2);

    public IWFEngineContext getContext();
}

