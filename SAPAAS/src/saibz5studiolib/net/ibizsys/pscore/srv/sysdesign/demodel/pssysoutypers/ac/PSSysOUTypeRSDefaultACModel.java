/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysoutypers.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d4e32f8fb87b3ae7b35e6f4edf422ae3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSOUTYPERSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSOUTYPERSNAME", format="")})})
public class PSSysOUTypeRSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysOUTypeRSDefaultACModel() {
        this.initAnnotation(PSSysOUTypeRSDefaultACModel.class);
    }
}

