/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbidxfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e769f6f657b2f4a433f3661e9092421d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDBIDXFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDBIDXFIELDNAME", format="")})})
public class PSDEDBIdxFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDBIdxFieldDefaultACModel() {
        this.initAnnotation(PSDEDBIdxFieldDefaultACModel.class);
    }
}

