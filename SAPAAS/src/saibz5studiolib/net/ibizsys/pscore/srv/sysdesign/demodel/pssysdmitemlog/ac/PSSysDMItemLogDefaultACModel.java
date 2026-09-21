/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdmitemlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e7ae2e4229c151d4cbe34ffe2e3406f7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDMITEMLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDMITEMLOGNAME", format="")})})
public class PSSysDMItemLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDMItemLogDefaultACModel() {
        this.initAnnotation(PSSysDMItemLogDefaultACModel.class);
    }
}

