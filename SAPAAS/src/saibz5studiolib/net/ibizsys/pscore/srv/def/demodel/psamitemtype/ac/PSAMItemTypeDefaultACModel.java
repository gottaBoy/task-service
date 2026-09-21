/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psamitemtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c92e9d156df97f0c21b97e4630e09032", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAMITEMTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAMITEMTYPENAME", format="")})})
public class PSAMItemTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAMItemTypeDefaultACModel() {
        this.initAnnotation(PSAMItemTypeDefaultACModel.class);
    }
}

