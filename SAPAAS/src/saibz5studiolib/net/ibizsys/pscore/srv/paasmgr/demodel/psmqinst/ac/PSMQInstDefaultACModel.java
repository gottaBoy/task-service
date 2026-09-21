/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmqinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="18ba66246314b2db6ed91185aa9e52a3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMQINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMQINSTNAME", format="")})})
public class PSMQInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMQInstDefaultACModel() {
        this.initAnnotation(PSMQInstDefaultACModel.class);
    }
}

