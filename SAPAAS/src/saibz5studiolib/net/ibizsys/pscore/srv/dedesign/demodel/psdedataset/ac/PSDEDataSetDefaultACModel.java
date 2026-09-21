/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataset.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="db65e3fa62805714c7453d8ab5ed1f74", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDATASETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDATASETNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSDEDataSetDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDataSetDefaultACModel() {
        this.initAnnotation(PSDEDataSetDefaultACModel.class);
    }
}

