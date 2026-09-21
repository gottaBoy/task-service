/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdespcodepart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="44309f1b06edc7021af02b194d53262a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESPCODEPARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESPCODEPARTNAME", format="")})})
public class PSDESPCodePartDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESPCodePartDefaultACModel() {
        this.initAnnotation(PSDESPCodePartDefaultACModel.class);
    }
}

