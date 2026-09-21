/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ISRFEAIConfigWriterContext {
    public ISRFDAGlobalHelper getGlobalHelper();

    public ISRFEAIDataCtrl getEAIDataCtrl();

    public EAIConfig getEAIConfig();

    public String getServiceId();

    public String getConfig(String var1, String var2);
}

