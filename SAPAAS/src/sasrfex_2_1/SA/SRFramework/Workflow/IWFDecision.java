/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Workflow.IWFEngineContext;
import SA.SRFramework.Workflow.WFDecisionConfig;

public interface IWFDecision {
    public boolean Init(WFDecisionConfig var1);

    public boolean Execute(IWFEngineContext var1);

    public void Quit();
}

