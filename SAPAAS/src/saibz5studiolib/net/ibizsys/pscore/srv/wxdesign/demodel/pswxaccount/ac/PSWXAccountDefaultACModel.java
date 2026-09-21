/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="66b43b073297a3b5deaa65c3b22cfe86", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWXACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWXACCOUNTNAME", format="")})})
public class PSWXAccountDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWXAccountDefaultACModel() {
        this.initAnnotation(PSWXAccountDefaultACModel.class);
    }
}

