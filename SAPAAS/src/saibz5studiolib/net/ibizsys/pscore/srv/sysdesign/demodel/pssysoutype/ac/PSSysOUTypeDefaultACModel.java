/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysoutype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="469b14d058525bc7d2804314ae193c61", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSOUTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSOUTYPENAME", format="")})})
public class PSSysOUTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysOUTypeDefaultACModel() {
        this.initAnnotation(PSSysOUTypeDefaultACModel.class);
    }
}

