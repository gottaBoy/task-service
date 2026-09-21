/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxmenuitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5f4c31ff09200a8649602acc504fd1a1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWXMENUITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWXMENUITEMNAME", format="")})})
public class PSWXMenuItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWXMenuItemDefaultACModel() {
        this.initAnnotation(PSWXMenuItemDefaultACModel.class);
    }
}

