/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="REALCODEITEM", id="3769F5FE-CB3E-4CF0-8802-C7A8421D6FBF", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="CODEITEMVALUE", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODEITEMNAME", format="")})})
public class PSCodeItemRealCodeItemACModel
extends DEACModelBase {
    public static final String NAME = "REALCODEITEM";

    public PSCodeItemRealCodeItemACModel() {
        this.initAnnotation(PSCodeItemRealCodeItemACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

