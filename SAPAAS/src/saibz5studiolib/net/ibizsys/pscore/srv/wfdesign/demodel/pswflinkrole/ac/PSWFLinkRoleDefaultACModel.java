/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswflinkrole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0ea0dfa6075cb861b83b6a6b77ada57d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFLINKROLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFLINKROLENAME", format="")})})
public class PSWFLinkRoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFLinkRoleDefaultACModel() {
        this.initAnnotation(PSWFLinkRoleDefaultACModel.class);
    }
}

