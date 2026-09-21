/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.Workflow.DefaultWFEngine;
import SA.SRFramework.Workflow.IWFEngine;

public class WFEngineHelper {
    public static final String TAG_WEBCONTEXT = "WEBCONTEXT";

    public static IWFEngine CreateEngine(SRFExWebContext webContext) {
        return new DefaultWFEngine();
    }

    public static IWFEngine CreateEngine() {
        return new DefaultWFEngine();
    }
}

