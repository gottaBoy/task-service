/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbtable.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="97796e30e76b14fdddc24b5ebc0cb80e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDBTABLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDBTABLENAME", format="")})})
public class PSDCDBTableDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDBTableDefaultACModel() {
        this.initAnnotation(PSDCDBTableDefaultACModel.class);
    }
}

