/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslndepsession.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5a0516db1b44737e95b02409643f6c6a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNDEPSESSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNDEPSESSIONNAME", format="")})})
public class PSdepSlnDepSessionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSdepSlnDepSessionDefaultACModel() {
        this.initAnnotation(PSdepSlnDepSessionDefaultACModel.class);
    }
}

