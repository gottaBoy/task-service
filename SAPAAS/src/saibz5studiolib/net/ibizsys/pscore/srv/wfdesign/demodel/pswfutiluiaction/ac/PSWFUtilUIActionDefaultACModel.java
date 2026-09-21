/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfutiluiaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1f593af6394bbfc6c98f915839f206ca", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFUTILUIACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFUTILUIACTIONNAME", format="")})})
public class PSWFUtilUIActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFUtilUIActionDefaultACModel() {
        this.initAnnotation(PSWFUtilUIActionDefaultACModel.class);
    }
}

