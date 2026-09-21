/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscountertypesf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9a996ffb66d85e8d980d8fc8c61303b9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOUNTERTYPESFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOUNTERTYPESFNAME", format="")})})
public class PSCounterTypeSFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCounterTypeSFDefaultACModel() {
        this.initAnnotation(PSCounterTypeSFDefaultACModel.class);
    }
}

