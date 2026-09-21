/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeteiupdate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0ebc12cbac705963c07727c8f0b7082f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETEIUPDATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETEIUPDATENAME", format="")})})
public class PSDETEIUpdateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETEIUpdateDefaultACModel() {
        this.initAnnotation(PSDETEIUpdateDefaultACModel.class);
    }
}

