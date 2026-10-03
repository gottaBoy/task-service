package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

public class DefaultConfigWriterContext {
    public void setEAIDataCtrl(ISRFEAIDataCtrl ctrl) {}
    public void setGlobalHelper(ISRFDAGlobalHelper helper) {}
    public void setServiceId(String id) {}
    public void setEAIConfig(EAIConfig config) {}
    public void setServiceParams(Properties properties) {}
}
