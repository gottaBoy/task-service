/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpappinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7e563a26f889675aa76ebaadbe12ab4c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPAPPINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPAPPINSTNAME", format="")})})
public class PSWPAppInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPAppInstDefaultACModel() {
        this.initAnnotation(PSWPAppInstDefaultACModel.class);
    }
}

