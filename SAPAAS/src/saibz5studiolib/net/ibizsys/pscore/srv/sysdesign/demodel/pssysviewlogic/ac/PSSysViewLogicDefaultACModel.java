/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f6ba6c9dac8ad5a486a2df26b28b52fa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVIEWLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVIEWLOGICNAME", format="")})})
public class PSSysViewLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysViewLogicDefaultACModel() {
        this.initAnnotation(PSSysViewLogicDefaultACModel.class);
    }
}

