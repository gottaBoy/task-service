/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolder.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e76475bcfe18b5b722a266587ca5b2d3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELFOLDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELFOLDERNAME", format="")})})
public class PSSysModelFolderDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelFolderDefaultACModel() {
        this.initAnnotation(PSSysModelFolderDefaultACModel.class);
    }
}

