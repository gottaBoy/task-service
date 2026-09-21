/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdereport.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c7f4a9c6cbe0c7ebc7e90d4812adf2ca", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEREPORTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEREPORTNAME", format="")})})
public class PSDEReportDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEReportDefaultACModel() {
        this.initAnnotation(PSDEReportDefaultACModel.class);
    }
}

