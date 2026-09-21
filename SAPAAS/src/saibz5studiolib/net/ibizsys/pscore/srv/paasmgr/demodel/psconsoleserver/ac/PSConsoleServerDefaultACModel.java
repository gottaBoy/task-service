/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psconsoleserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d1a309c48812c5aa0d06c9721ee479a6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCONSOLESERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCONSOLESERVERNAME", format="")})})
public class PSConsoleServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSConsoleServerDefaultACModel() {
        this.initAnnotation(PSConsoleServerDefaultACModel.class);
    }
}

