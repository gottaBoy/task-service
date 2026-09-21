/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcfile.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="04d3f45b40e772fd7360382eafca075d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCFILEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCFILENAME", format="")})})
public class PSDCFileDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCFileDefaultACModel() {
        this.initAnnotation(PSDCFileDefaultACModel.class);
    }
}

