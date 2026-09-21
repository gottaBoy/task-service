/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewtempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="004747076edffa2f2fea46d1df8b46a2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPVIEWTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPVIEWTEMPLNAME", format="")})})
public class PSAppViewTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppViewTemplDefaultACModel() {
        this.initAnnotation(PSAppViewTemplDefaultACModel.class);
    }
}

