/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFInteractiveProcessConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import SRFWF.Model.WFProcessesConfig;
import SRFWF.Model.WFStartProcessConfig;
import java.util.Iterator;
import org.w3c.dom.Node;

public class WFConfig
extends WFBaseProcessConfig {
    public static String TAG_WFWORKFLOW = "SRFEXWFWORKFLOW";
    protected WFProcessesConfig wfProcessesConfig = new WFProcessesConfig(this);

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)WFProcessesConfig.TAG_WFPROCESSES, (boolean)true) == 0) {
            this.wfProcessesConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFProcessesConfig getProcessesConfig() {
        return this.wfProcessesConfig;
    }

    public WFBaseProcessConfig GetStartProcessConfig() {
        Iterator iterator = this.wfProcessesConfig.iterator();
        while (iterator.hasNext()) {
            WFBaseProcessConfig processConfig = (WFBaseProcessConfig)((Object)iterator.next());
            if (!(processConfig instanceof WFStartProcessConfig)) continue;
            return processConfig;
        }
        return null;
    }

    public WFBaseProcessConfig FindProcessConfigByName(String strWFPName) {
        Iterator iterator = this.wfProcessesConfig.iterator();
        while (iterator.hasNext()) {
            WFBaseProcessConfig processConfig = (WFBaseProcessConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)strWFPName, (String)processConfig.getName(), (boolean)true) != 0) continue;
            return processConfig;
        }
        return null;
    }

    public WFBaseProcessConfig FindProcessConfigByCodeListItemValue(String strCodeListItemValue) {
        Iterator iterator = this.wfProcessesConfig.iterator();
        while (iterator.hasNext()) {
            WFBaseProcessConfig processConfig = (WFBaseProcessConfig)((Object)iterator.next());
            if (!(processConfig instanceof WFParallelSubWFConfig) && !(processConfig instanceof WFInteractiveProcessConfig) || StringHelper.Compare((String)strCodeListItemValue, (String)processConfig.getCodeListItemValue(), (boolean)true) != 0) continue;
            return processConfig;
        }
        return null;
    }
}

