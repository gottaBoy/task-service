/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="61be71763d040c25e32f30e4df8bafea", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELFOLDERITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELFOLDERITEMNAME", format="")})})
public class PSSysModelFolderItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelFolderItemDefaultACModel() {
        this.initAnnotation(PSSysModelFolderItemDefaultACModel.class);
    }
}

