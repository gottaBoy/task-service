/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemap.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e5a4241800f0ec73578c2835fdc0d800", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMAPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMAPNAME", format="")})})
public class PSDEMapDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMapDefaultACModel() {
        this.initAnnotation(PSDEMapDefaultACModel.class);
    }
}

