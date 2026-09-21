/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1dc9d1bad30c6b2393ae41a27c0c4d65", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODELISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODELISTNAME", format="")})})
public class PSCodeListDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodeListDefaultACModel() {
        this.initAnnotation(PSCodeListDefaultACModel.class);
    }
}

