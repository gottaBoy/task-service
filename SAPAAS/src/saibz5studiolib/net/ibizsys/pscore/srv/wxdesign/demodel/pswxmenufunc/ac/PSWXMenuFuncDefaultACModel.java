/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxmenufunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="df68d3555f984eed61492d6017b6cd06", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWXMENUFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWXMENUFUNCNAME", format="")})})
public class PSWXMenuFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWXMenuFuncDefaultACModel() {
        this.initAnnotation(PSWXMenuFuncDefaultACModel.class);
    }
}

