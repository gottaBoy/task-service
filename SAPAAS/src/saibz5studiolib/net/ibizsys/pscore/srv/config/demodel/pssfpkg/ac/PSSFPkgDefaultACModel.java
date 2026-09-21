/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpkg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c229f5a2d4f9883870965468e72288cd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPKGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPKGNAME", format="")})})
public class PSSFPkgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPkgDefaultACModel() {
        this.initAnnotation(PSSFPkgDefaultACModel.class);
    }
}

