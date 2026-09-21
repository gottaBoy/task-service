/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyleprj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8597cfab988e7f2b3aeae9b8aae062e3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLEPRJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLEPRJNAME", format="")})})
public class PSSFStylePrjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStylePrjDefaultACModel() {
        this.initAnnotation(PSSFStylePrjDefaultACModel.class);
    }
}

