/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdespfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="54e7040d8572179b0d8959667b5717e3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESPFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESPFIELDNAME", format="")})})
public class PSDESPFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESPFieldDefaultACModel() {
        this.initAnnotation(PSDESPFieldDefaultACModel.class);
    }
}

