/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdetemplfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3f95a71f86cf57fc672d853bf51205b4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDETEMPLFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDETEMPLFIELDNAME", format="")})})
public class PSDCDETemplFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDETemplFieldDefaultACModel() {
        this.initAnnotation(PSDCDETemplFieldDefaultACModel.class);
    }
}

