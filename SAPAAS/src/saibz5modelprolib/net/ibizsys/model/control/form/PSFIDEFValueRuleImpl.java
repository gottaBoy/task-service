/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSFIDEFValueRule
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

public class PSFIDEFValueRuleImpl
extends PSObjectImpl
implements IPSFIDEFValueRule {
    protected IDEFValueRule iDEFValueRule = null;

    public String getDEFVRName() {
        return this.getDEFValueRule().getName();
    }

    public String getDEFVRId() {
        return this.getDEFValueRule().getId();
    }

    public IDEFValueRule getDEFValueRule() {
        return this.iDEFValueRule;
    }

    protected void setDEFValueRule(IDEFValueRule iDEFValueRule) {
        this.iDEFValueRule = iDEFValueRule;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

