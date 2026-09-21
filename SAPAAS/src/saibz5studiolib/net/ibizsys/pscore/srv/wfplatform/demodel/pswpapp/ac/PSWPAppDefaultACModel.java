/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f51812dea4ff5e4ed07a18df9a5666fb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPAPPNAME", format="")})})
public class PSWPAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPAppDefaultACModel() {
        this.initAnnotation(PSWPAppDefaultACModel.class);
    }
}

