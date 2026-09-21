/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyslanitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4b572a37e8b8c0d0e224eb85758e5acc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSLANITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSLANITEMNAME", format="")})})
public class PSSysLanItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysLanItemDefaultACModel() {
        this.initAnnotation(PSSysLanItemDefaultACModel.class);
    }
}

