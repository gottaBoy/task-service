/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsysver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="725952e288ccfb925c1db6406a18ff29", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSVERNAME", format="")})})
public class PSSubSysVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubSysVerDefaultACModel() {
        this.initAnnotation(PSSubSysVerDefaultACModel.class);
    }
}

