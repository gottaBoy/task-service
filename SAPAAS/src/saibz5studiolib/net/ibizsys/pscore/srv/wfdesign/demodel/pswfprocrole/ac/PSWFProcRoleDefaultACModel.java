/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfprocrole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6a5dc30fae78a2b090c10bb42e9da864", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFPROCROLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFPROCROLENAME", format="")})})
public class PSWFProcRoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFProcRoleDefaultACModel() {
        this.initAnnotation(PSWFProcRoleDefaultACModel.class);
    }
}

