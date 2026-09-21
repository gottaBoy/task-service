/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psdcserverstate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="edf7d4ef7b74e0cf4a5e7fbd6e2e030e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSERVERSTATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSERVERSTATENAME", format="")})})
public class PSDCServerStateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCServerStateDefaultACModel() {
        this.initAnnotation(PSDCServerStateDefaultACModel.class);
    }
}

