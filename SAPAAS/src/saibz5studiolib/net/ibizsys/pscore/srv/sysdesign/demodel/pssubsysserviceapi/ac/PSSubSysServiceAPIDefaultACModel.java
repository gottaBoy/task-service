/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssubsysserviceapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5caa24bf5994bfec6f327b03d2867cfe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSSERVICEAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSSERVICEAPINAME", format="")})})
public class PSSubSysServiceAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubSysServiceAPIDefaultACModel() {
        this.initAnnotation(PSSubSysServiceAPIDefaultACModel.class);
    }
}

