/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdssysappbar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7019a6ec801416dadca7be4bda78abf6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDSSYSAPPBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDSSYSAPPBARNAME", format="")})})
public class PSDSSysAppBarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDSSysAppBarDefaultACModel() {
        this.initAnnotation(PSDSSysAppBarDefaultACModel.class);
    }
}

