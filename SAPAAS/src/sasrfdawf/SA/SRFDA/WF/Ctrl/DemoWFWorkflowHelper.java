/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Model.WFInteractiveProcessConfig
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.WF.Ctrl.BaseDAWFWorkflowHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Model.WFInteractiveProcessConfig;
import java.util.Properties;

public class DemoWFWorkflowHelper
extends BaseDAWFWorkflowHelper {
    protected String strParam = "";

    @Override
    protected void OnInit() {
        super.OnInit();
        this.strParam = PropertiesHelper.GetProperty((Properties)this.properties, (String)"PARAM", (String)"");
    }

    public WFInteractiveProcessConfig ReCalcInteractiveProcess(ISRFWFContext iSRFWFContext, WFInteractiveProcessConfig wfInteractiveProcessConfig) throws Exception {
        if (StringHelper.Compare((String)wfInteractiveProcessConfig.getCodeListItemValue(), (String)"1", (boolean)true) != 0) {
            return wfInteractiveProcessConfig;
        }
        BaseDataEntity activeData = iSRFWFContext.getActiveObject();
        WFInteractiveProcessConfig wf2Config = (WFInteractiveProcessConfig)wfInteractiveProcessConfig.clone();
        if (wf2Config.getIAActionsConfig().size() > 0) {
            wf2Config.getIAActionsConfig().remove(wf2Config.getIAActionsConfig().size() - 1);
        }
        wf2Config.SetExtValue("VERSION", StringHelper.Format((String)"%1$s", (Object)(100000 + wfInteractiveProcessConfig.GetExtValue("VERSION", 1))));
        return wf2Config;
    }
}

