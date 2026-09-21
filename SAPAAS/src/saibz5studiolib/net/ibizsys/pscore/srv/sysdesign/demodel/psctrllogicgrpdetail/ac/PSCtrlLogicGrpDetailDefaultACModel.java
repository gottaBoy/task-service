/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psctrllogicgrpdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5bdcf496676d888fc3166f2211438998", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLLOGICGRPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLLOGICGRPDETAILNAME", format="")})})
public class PSCtrlLogicGrpDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlLogicGrpDetailDefaultACModel() {
        this.initAnnotation(PSCtrlLogicGrpDetailDefaultACModel.class);
    }
}

