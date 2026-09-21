/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxentapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2c56b983f3465f6937874f0627bb9375", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWXENTAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWXENTAPPNAME", format="")})})
public class PSWXEntAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWXEntAppDefaultACModel() {
        this.initAnnotation(PSWXEntAppDefaultACModel.class);
    }
}

