/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemsrc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8023de00db1a2757e8455c2325f74b0a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMSRCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMSRCNAME", format="")})})
public class PSSystemSrcDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemSrcDefaultACModel() {
        this.initAnnotation(PSSystemSrcDefaultACModel.class);
    }
}

