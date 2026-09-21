/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pswflinktype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b71d5ee6152b41791893fb58ee3e57ef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFLINKTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFLINKTYPENAME", format="")})})
public class PSWFLinkTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFLinkTypeDefaultACModel() {
        this.initAnnotation(PSWFLinkTypeDefaultACModel.class);
    }
}

