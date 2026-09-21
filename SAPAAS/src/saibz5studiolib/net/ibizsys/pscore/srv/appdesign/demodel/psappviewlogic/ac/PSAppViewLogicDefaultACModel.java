/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="11a65e19a476bcc904acb46433cffdda", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPVIEWLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPVIEWLOGICNAME", format="")})})
public class PSAppViewLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppViewLogicDefaultACModel() {
        this.initAnnotation(PSAppViewLogicDefaultACModel.class);
    }
}

