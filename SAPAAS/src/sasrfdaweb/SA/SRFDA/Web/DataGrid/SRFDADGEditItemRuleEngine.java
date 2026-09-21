/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ValueRule
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DataGrid.GrooveDGEditItemRuleEngine
 *  SA.SRFramework.WebEx.UI.DataGridEditItemConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.DataGrid;

import SA.SRFDA.Ctrl.Data.ValueRule;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DataGrid.GrooveDGEditItemRuleEngine;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDADGEditItemRuleEngine
extends GrooveDGEditItemRuleEngine {
    public static final String SRFDAVALUERULE = "SRFDAVALUERULE";
    private static final Log log = LogFactory.getLog(SRFDADGEditItemRuleEngine.class);

    public boolean TestValueRule(DataGridEditItemConfig dgEditItemConfig, Object objValue, String strValue) {
        String strValueCode = dgEditItemConfig.getValueRuleCode();
        if (strValueCode.indexOf(SRFDAVALUERULE) == 0) {
            String strValueRuleId = strValueCode.substring(15);
            String strFormItemId = "";
            int nPos = strValueRuleId.indexOf("|");
            if (nPos != -1) {
                strFormItemId = strValueRuleId.substring(0, nPos);
                strValueRuleId = strValueRuleId.substring(nPos + 1);
            }
            if (StringHelper.IsNullOrEmpty((String)strFormItemId)) {
                return true;
            }
            SRFDAPage daPage = (SRFDAPage)this.dataGrid.getPage();
            ValueRule valueRule = daPage.getDAModelStorage().FindValueRule(strValueRuleId);
            if (valueRule == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u503c\u89c4\u5219[%1$s]\u914d\u7f6e", (Object)strValueRuleId));
                return false;
            }
            if (StringHelper.Compare((String)valueRule.getRULETYPE(), (String)"SCRIPT", (boolean)true) == 0) {
                return this.InternalTest(valueRule.getSCRIPT(), false);
            }
            if (StringHelper.Compare((String)valueRule.getRULETYPE(), (String)"REG", (boolean)true) == 0) {
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    return this.RegEx(strFormItemId, valueRule.getREGEXP());
                }
                return SRFDADGEditItemRuleEngine.TestRegEx((String)valueRule.getREGEXP(), (String)strValue);
            }
        }
        return super.TestValueRule(dgEditItemConfig, objValue, strValue);
    }
}

