/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2c2e8be45e9e1014248a788c59353520", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODEITEMNAME", format="")})})
public class PSCodeItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodeItemDefaultACModel() {
        this.initAnnotation(PSCodeItemDefaultACModel.class);
    }
}

