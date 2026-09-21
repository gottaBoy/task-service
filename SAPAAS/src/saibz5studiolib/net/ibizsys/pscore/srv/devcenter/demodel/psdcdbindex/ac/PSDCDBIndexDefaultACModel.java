/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbindex.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cd2891724b3e4dd323748310e3cd89f9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCDBINDEXID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCDBINDEXNAME", format="")})})
public class PSDCDBIndexDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCDBIndexDefaultACModel() {
        this.initAnnotation(PSDCDBIndexDefaultACModel.class);
    }
}

