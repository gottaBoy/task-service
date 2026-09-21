/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.valuerule.IPSSysValueRuleRuntime;

public class PSSysValueRuleImpl
extends PSSystemObjectImpl
implements IPSSysValueRuleRuntime {
    protected PSSysValueRule psSysValueRule = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysValueRule psSysValueRule) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSSystem(iPSSystem);
        this.psSysValueRule = psSysValueRule;
        this.setId(this.psSysValueRule.getPSSYSVALUERULEID());
        this.setName(this.psSysValueRule.getPSSYSVALUERULENAME());
        this.setPSObjectData(this.psSysValueRule);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getRuleType() {
        return this.psSysValueRule.getRULETYPE();
    }

    public String getRuleInfo() {
        return this.psSysValueRule.getRULEINFO();
    }

    public String getRegExCode() {
        return this.psSysValueRule.getREGEXPCODE();
    }

    public String getScriptCode() {
        return this.psSysValueRule.getSCRIPT();
    }

    public String getCustomObject() {
        return this.psSysValueRule.getCUSTOMOBJ();
    }

    public String getCustomParams() {
        return this.psSysValueRule.getCUSTOMPARAMS();
    }
}

