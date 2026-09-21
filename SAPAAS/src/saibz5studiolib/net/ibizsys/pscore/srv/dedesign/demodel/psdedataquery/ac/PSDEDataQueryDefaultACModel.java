/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataquery.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f9ff5b78af5df74be89ca3430006a1da", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDATAQUERYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDATAQUERYNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSDEDataQueryDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDataQueryDefaultACModel() {
        this.initAnnotation(PSDEDataQueryDefaultACModel.class);
    }
}

