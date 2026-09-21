/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssearchbar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="41410b56bf1b216a6ef2d46ebe808a64", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSEARCHBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSEARCHBARNAME", format="")})})
public class PSSysSearchBarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSearchBarDefaultACModel() {
        this.initAnnotation(PSSysSearchBarDefaultACModel.class);
    }
}

