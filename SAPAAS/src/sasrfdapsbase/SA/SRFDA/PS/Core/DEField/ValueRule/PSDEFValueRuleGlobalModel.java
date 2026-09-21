/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleImpl;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFValueRule, IPSDEFValueRule> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleGlobalModel.class);

    @Override
    protected PSDEFValueRule GetObject(String strPSDEFValueRuleId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFValueRule OnCreateModelHelper(PSDEFValueRule vt) throws Exception {
        PSDEFValueRuleImpl iPSDEFValueRule = new PSDEFValueRuleImpl();
        iPSDEFValueRule.init(this.iDAGlobalHelper, this.iPSDEField, vt);
        return iPSDEFValueRule;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFValueRule obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSDEFValueRule registerModel(PSDEFValueRule vt) throws Exception {
        IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)this.InternalGetModelHelper(vt.getPSDEFVALUERULEID());
        if (iPSDEFValueRule != null) {
            return iPSDEFValueRule;
        }
        this.setModel(vt.getPSDEFVALUERULEID(), vt, null);
        return (IPSDEFValueRule)this.FindModelHelper(vt.getPSDEFVALUERULEID());
    }

    @Override
    protected Vector<PSDEFValueRule> getAllModels() throws Exception {
        Vector<PSDEFValueRule> psDEFValueRuleList = new Vector<PSDEFValueRule>();
        ArrayList<PSDEFValueRule> psDEFValueRuleList2 = this.getPSDEField().getPSDEFieldData().getPSDEFValueRules(false);
        PSDEFValueRule defaultPSDEFValueRule = null;
        if (psDEFValueRuleList2 != null) {
            psDEFValueRuleList.addAll(psDEFValueRuleList2);
            for (PSDEFValueRule psDEFValueRule : psDEFValueRuleList) {
                if (StringHelper.Compare((String)psDEFValueRule.getCODENAME(), (String)"DEFAULT", (boolean)true) != 0) continue;
                defaultPSDEFValueRule = psDEFValueRule;
                break;
            }
        }
        if (defaultPSDEFValueRule == null) {
            defaultPSDEFValueRule = new PSDEFValueRule();
            defaultPSDEFValueRule.setPSDEFVALUERULEID(Helper.GenGuidEx());
            defaultPSDEFValueRule.setPSDEFVALUERULENAME("\u9ed8\u8ba4\u89c4\u5219");
            defaultPSDEFValueRule.setCODENAME("Default");
            defaultPSDEFValueRule.setDEFAULTMODE(true);
            defaultPSDEFValueRule.setRULEINFO("\u9ed8\u8ba4\u89c4\u5219");
            psDEFValueRuleList.add(defaultPSDEFValueRule);
        }
        return psDEFValueRuleList;
    }

    @Override
    protected String getObjectId(PSDEFValueRule vt) {
        return vt.getPSDEFVALUERULEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEFValueRule vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

