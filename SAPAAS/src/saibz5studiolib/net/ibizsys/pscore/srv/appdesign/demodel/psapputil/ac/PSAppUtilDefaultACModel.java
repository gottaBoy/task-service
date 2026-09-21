/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapputil.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a76a503aec5032acf97d5aa64afb24c4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPUTILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPUTILNAME", format="")})})
public class PSAppUtilDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppUtilDefaultACModel() {
        this.initAnnotation(PSAppUtilDefaultACModel.class);
    }
}

