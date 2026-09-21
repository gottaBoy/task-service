/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pstscmd.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="96cccddc08267491477e15ab1b2b7d1f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTSCMDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTSCMDNAME", format="")})})
public class PSTSCmdDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSTSCmdDefaultACModel() {
        this.initAnnotation(PSTSCmdDefaultACModel.class);
    }
}

