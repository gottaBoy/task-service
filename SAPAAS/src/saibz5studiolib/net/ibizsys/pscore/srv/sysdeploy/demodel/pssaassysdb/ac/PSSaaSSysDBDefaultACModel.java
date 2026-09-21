/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.pssaassysdb.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0a81d3c0a40f0874391d38f990a4afc7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSAASSYSDBID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSAASSYSDBNAME", format="")})})
public class PSSaaSSysDBDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSaaSSysDBDefaultACModel() {
        this.initAnnotation(PSSaaSSysDBDefaultACModel.class);
    }
}

