/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscodelisttempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4156d6703c78bcdbbb8671f11d68187c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODELISTTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODELISTTEMPLNAME", format="")})})
public class PSCodeListTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodeListTemplDefaultACModel() {
        this.initAnnotation(PSCodeListTemplDefaultACModel.class);
    }
}

