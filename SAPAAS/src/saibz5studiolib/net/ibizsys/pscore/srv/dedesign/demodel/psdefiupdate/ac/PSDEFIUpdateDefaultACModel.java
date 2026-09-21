/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefiupdate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b382c538bee84b11c5d1067d8f3df173", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFIUPDATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFIUPDATENAME", format="")})})
public class PSDEFIUpdateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFIUpdateDefaultACModel() {
        this.initAnnotation(PSDEFIUpdateDefaultACModel.class);
    }
}

