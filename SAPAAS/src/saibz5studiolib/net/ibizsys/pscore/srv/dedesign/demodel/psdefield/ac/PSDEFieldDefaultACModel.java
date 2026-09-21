/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="42d91505b9bb15b9900b4298fcca9915", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFIELDNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSDEFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFieldDefaultACModel() {
        this.initAnnotation(PSDEFieldDefaultACModel.class);
    }
}

