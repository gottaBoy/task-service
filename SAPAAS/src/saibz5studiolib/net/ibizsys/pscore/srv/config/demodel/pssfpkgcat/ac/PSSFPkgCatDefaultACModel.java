/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpkgcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6e9abff5784460ae58f9fe64fa299aec", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPKGCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPKGCATNAME", format="")})})
public class PSSFPkgCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPkgCatDefaultACModel() {
        this.initAnnotation(PSSFPkgCatDefaultACModel.class);
    }
}

