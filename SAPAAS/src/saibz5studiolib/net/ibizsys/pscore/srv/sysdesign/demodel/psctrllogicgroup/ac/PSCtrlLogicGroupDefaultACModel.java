/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psctrllogicgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="59a1d1c9be4a8ace25163d1a626637bb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLLOGICGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLLOGICGROUPNAME", format="")})})
public class PSCtrlLogicGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlLogicGroupDefaultACModel() {
        this.initAnnotation(PSCtrlLogicGroupDefaultACModel.class);
    }
}

