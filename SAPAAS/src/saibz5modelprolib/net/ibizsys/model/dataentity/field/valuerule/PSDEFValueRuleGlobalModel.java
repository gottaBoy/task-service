/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.PSDEFieldGlobalModelBase;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleImpl;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFValueRule, IPSDEFValueRule> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleGlobalModel.class);

    @Override
    protected PSDEFValueRule getObject(String strPSDEFValueRuleId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFValueRule onCreateModelHelper(PSDEFValueRule vt) throws Exception {
        PSDEFValueRuleImpl iPSDEFValueRule = new PSDEFValueRuleImpl();
        iPSDEFValueRule.init(this.getPSModelStorageContext(), this.iPSDEField, vt);
        return iPSDEFValueRule;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFValueRule obj) {
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
        IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)this.internalGetModelHelper(vt.getPSDEFVALUERULEID());
        if (iPSDEFValueRule != null) {
            return iPSDEFValueRule;
        }
        this.setModel(vt.getPSDEFVALUERULEID(), vt, null);
        return (IPSDEFValueRule)this.findModelHelper(vt.getPSDEFVALUERULEID());
    }

    @Override
    protected Vector<PSDEFValueRule> getAllModels() throws Exception {
        Vector<PSDEFValueRule> psDEFValueRuleList = new Vector<PSDEFValueRule>();
        ArrayList<PSDEFValueRule> psDEFValueRuleList2 = ((IPSDEFieldRuntime)this.getPSDEField()).getPSDEFieldData().getPSDEFValueRules(false);
        PSDEFValueRule defaultPSDEFValueRule = null;
        if (psDEFValueRuleList2 != null) {
            psDEFValueRuleList.addAll(psDEFValueRuleList2);
            for (PSDEFValueRule psDEFValueRule : psDEFValueRuleList) {
                if (StringHelper.compare((String)psDEFValueRule.getCODENAME(), (String)"DEFAULT", (boolean)true) != 0) continue;
                defaultPSDEFValueRule = psDEFValueRule;
                break;
            }
        }
        if (defaultPSDEFValueRule == null) {
            defaultPSDEFValueRule = new PSDEFValueRule();
            defaultPSDEFValueRule.setPSDEFVALUERULEID(KeyValueHelper.genGuidEx());
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
}

