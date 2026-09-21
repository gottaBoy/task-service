/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="10eb1eb0a5de91ef5437264b8d3397b9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSDEActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEActionDefaultACModel() {
        this.initAnnotation(PSDEActionDefaultACModel.class);
    }
}

