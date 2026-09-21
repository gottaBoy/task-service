/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysenginecfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="257c47cbb0c7e11cdd2dbbc6266e1666", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSENGINECFGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSENGINECFGNAME", format="")})})
public class PSSysEngineCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEngineCfgDefaultACModel() {
        this.initAnnotation(PSSysEngineCfgDefaultACModel.class);
    }
}

