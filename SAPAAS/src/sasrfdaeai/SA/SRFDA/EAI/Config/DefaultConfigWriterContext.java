/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Map;
import java.util.Properties;

public class DefaultConfigWriterContext
implements ISRFEAIConfigWriterContext {
    protected ISRFDAGlobalHelper globalHelper;
    protected ISRFEAIDataCtrl eaiDataCtrl;
    protected EAIConfig eaiConfig;
    protected String strServiceId = "";
    private Map<String, String> config;
    protected Properties serviceParams = null;

    @Override
    public ISRFEAIDataCtrl getEAIDataCtrl() {
        return this.eaiDataCtrl;
    }

    @Override
    public ISRFDAGlobalHelper getGlobalHelper() {
        return this.globalHelper;
    }

    public void setGlobalHelper(ISRFDAGlobalHelper globalHelper) {
        this.globalHelper = globalHelper;
    }

    public void setEAIDataCtrl(ISRFEAIDataCtrl eaiDataCtrl) {
        this.eaiDataCtrl = eaiDataCtrl;
    }

    @Override
    public EAIConfig getEAIConfig() {
        return this.eaiConfig;
    }

    public void setEAIConfig(EAIConfig eaiConfig) {
        this.eaiConfig = eaiConfig;
    }

    @Override
    public String getServiceId() {
        return this.strServiceId;
    }

    public void setServiceId(String strServiceId) {
        this.strServiceId = strServiceId;
    }

    @Override
    public String getConfig(String strConfigName, String strDefault) {
        return PropertiesHelper.GetProperty((Properties)this.serviceParams, (String)strConfigName, (String)strDefault);
    }

    public void setServiceParams(Properties serviceParams) {
        this.serviceParams = serviceParams;
    }
}

