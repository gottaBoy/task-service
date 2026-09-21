/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmodeltempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eaabf906f356838e6aa5df17e7f46e10", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMODELTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMODELTEMPLNAME", format="")})})
public class PSDCModelTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCModelTemplDefaultACModel() {
        this.initAnnotation(PSDCModelTemplDefaultACModel.class);
    }
}

