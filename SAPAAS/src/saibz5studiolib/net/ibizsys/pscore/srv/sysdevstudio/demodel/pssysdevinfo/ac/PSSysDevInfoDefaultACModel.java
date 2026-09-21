/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdevinfo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="70e970caff9787a181e752018774ba13", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEVINFOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEVINFONAME", format="")})})
public class PSSysDevInfoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDevInfoDefaultACModel() {
        this.initAnnotation(PSSysDevInfoDefaultACModel.class);
    }
}

