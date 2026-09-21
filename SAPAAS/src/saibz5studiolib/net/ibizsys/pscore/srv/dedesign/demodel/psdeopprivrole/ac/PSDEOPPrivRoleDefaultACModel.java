/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeopprivrole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="68a9a3f91a26fee4a67f3f032c9cc62e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEOPPRIVROLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEOPPRIVROLENAME", format="")})})
public class PSDEOPPrivRoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEOPPrivRoleDefaultACModel() {
        this.initAnnotation(PSDEOPPrivRoleDefaultACModel.class);
    }
}

