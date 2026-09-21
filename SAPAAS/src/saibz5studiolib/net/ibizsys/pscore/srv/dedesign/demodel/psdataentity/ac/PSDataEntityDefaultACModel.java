/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdataentity.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7434ba61651065869fe25472d4c9b77b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDATAENTITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDATAENTITYNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="LOGICNAME", format="%1$s")})})
public class PSDataEntityDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDataEntityDefaultACModel() {
        this.initAnnotation(PSDataEntityDefaultACModel.class);
    }
}

