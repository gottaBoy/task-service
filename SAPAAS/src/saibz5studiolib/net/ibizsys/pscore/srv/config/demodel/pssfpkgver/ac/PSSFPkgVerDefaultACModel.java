/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpkgver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8eb565e75a09e3ccca3b2daa013d189a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPKGVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPKGVERNAME", format="")})})
public class PSSFPkgVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPkgVerDefaultACModel() {
        this.initAnnotation(PSSFPkgVerDefaultACModel.class);
    }
}

