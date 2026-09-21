/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.DynamicPanelMgr;
import SA.SRFramework.WebEx.UI.PanelTemplateConfig;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TemplatePanelConfig
extends BasePanelConfig {
    public static final String TAG_TEMPLATEPANEL = "SRFEXTEMPLATEPANEL";
    public static final String TAG_TP = "TP";
    private static final Log log = LogFactory.getLog(TemplatePanelConfig.class);
    protected ArrayList panels = null;
    protected ArrayList tpValues = new ArrayList();

    public ArrayList getPanels(ControlConfigContext controlConfigContext) {
        Object objMgr = controlConfigContext.getParam("DYNAMICPANELMGR");
        if (objMgr == null) {
            return null;
        }
        if (!(objMgr instanceof DynamicPanelMgr)) {
            return null;
        }
        DynamicPanelMgr dynamicPanelMgr = (DynamicPanelMgr)((Object)objMgr);
        if (this.panels == null) {
            this.panels = new ArrayList();
            int i = 0;
            while (i < this.tpValues.size()) {
                String strId = (String)this.tpValues.get(i);
                String[] strParts = StringHelper.Split((String)strId, (char)'|');
                if (strParts != null && strParts.length == 2) {
                    PanelTemplateConfig panelTemplateConfig = dynamicPanelMgr.GetPanelTemplateConfig(strParts[0]);
                    if (panelTemplateConfig == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u9762\u677f\u6a21\u677f[%1$s]", (Object)strParts[0]));
                    } else {
                        panelTemplateConfig.GetPanelConfigs(strParts[1], this.panels, controlConfigContext);
                    }
                }
                ++i;
            }
        }
        return this.panels;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.indexOf(TAG_TP) == 0) {
            this.tpValues.add(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

