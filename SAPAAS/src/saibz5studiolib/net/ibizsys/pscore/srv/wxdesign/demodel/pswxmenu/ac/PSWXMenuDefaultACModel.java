/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxmenu.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6524c6fc10a1cc6757b7253063448057", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWXMENUID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWXMENUNAME", format="")})})
public class PSWXMenuDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWXMenuDefaultACModel() {
        this.initAnnotation(PSWXMenuDefaultACModel.class);
    }
}

