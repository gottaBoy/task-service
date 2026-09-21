/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssqlcmd.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8571ad91131b3c73cc23a591c0af468c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSQLCMDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="LOGICNAME", format="")})})
public class PSSysSQLCmdDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSQLCmdDefaultACModel() {
        this.initAnnotation(PSSysSQLCmdDefaultACModel.class);
    }
}

