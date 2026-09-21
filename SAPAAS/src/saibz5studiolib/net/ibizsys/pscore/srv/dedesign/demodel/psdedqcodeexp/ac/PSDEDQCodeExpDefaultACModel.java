/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcodeexp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bf89136c010eda8f9843dc97530daf67", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDQCODEEXPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDQCODEEXPNAME", format="")})})
public class PSDEDQCodeExpDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDQCodeExpDefaultACModel() {
        this.initAnnotation(PSDEDQCodeExpDefaultACModel.class);
    }
}

