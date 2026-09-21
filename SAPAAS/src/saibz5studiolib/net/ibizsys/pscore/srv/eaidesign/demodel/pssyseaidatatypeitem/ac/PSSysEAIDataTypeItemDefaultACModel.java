/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.eaidesign.demodel.pssyseaidatatypeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="967b78f1b501fbaa202bf40aa70fdf67", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEAIDATATYPEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEAIDATATYPEITEMNAME", format="")})})
public class PSSysEAIDataTypeItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEAIDataTypeItemDefaultACModel() {
        this.initAnnotation(PSSysEAIDataTypeItemDefaultACModel.class);
    }
}

