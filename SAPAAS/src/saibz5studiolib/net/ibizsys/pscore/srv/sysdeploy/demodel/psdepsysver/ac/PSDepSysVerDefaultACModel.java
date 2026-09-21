/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsysver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a5c228dbfc96d1103b27571dcb2aaf23", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSYSVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSYSVERNAME", format="")})})
public class PSDepSysVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSysVerDefaultACModel() {
        this.initAnnotation(PSDepSysVerDefaultACModel.class);
    }
}

