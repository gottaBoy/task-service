/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysoppriv.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1a0a2d7c4dcf853634fcee56e22a3236", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSOPPRIVID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSOPPRIVNAME", format="")})})
public class PSSysOPPrivDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysOPPrivDefaultACModel() {
        this.initAnnotation(PSSysOPPrivDefaultACModel.class);
    }
}

