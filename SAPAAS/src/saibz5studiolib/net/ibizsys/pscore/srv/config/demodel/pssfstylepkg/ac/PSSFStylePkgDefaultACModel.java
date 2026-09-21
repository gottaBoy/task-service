/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylepkg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a0b2907976875e79ab717a8904b6974d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLEPKGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLEPKGNAME", format="")})})
public class PSSFStylePkgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStylePkgDefaultACModel() {
        this.initAnnotation(PSSFStylePkgDefaultACModel.class);
    }
}

