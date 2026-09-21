/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Workflow.IWFEngineContext;
import SA.SRFramework.Workflow.WFProcessConfig;

public interface IWFProcess {
    public boolean Init(WFProcessConfig var1);

    public boolean Execute(IWFEngineContext var1);

    public void Rollback();

    public void Quit();
}

