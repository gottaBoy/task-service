/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegeiupdate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="72df034ccc3b5457fb30d5922f710b57", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGEIUPDATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGEIUPDATENAME", format="")})})
public class PSDEGEIUpdateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGEIUpdateDefaultACModel() {
        this.initAnnotation(PSDEGEIUpdateDefaultACModel.class);
    }
}

