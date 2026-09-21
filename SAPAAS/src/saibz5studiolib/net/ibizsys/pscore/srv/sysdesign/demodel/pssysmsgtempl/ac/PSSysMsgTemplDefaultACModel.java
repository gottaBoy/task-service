/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmsgtempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2a7c1d49d4a96c4b9d39a1c37c02a656", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMSGTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMSGTEMPLNAME", format="")})})
public class PSSysMsgTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysMsgTemplDefaultACModel() {
        this.initAnnotation(PSSysMsgTemplDefaultACModel.class);
    }
}

