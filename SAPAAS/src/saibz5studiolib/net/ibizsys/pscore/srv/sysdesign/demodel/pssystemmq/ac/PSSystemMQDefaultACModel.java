/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemmq.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="add4983ecd43452e0aff3d55309c6066", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMMQID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMMQNAME", format="")})})
public class PSSystemMQDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemMQDefaultACModel() {
        this.initAnnotation(PSSystemMQDefaultACModel.class);
    }
}

