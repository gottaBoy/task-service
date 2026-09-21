/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyspdtview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b0db879c269f2a31b6c21f36a1ecf8b8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPDTVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPDTVIEWNAME", format="")})})
public class PSSysPDTViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysPDTViewDefaultACModel() {
        this.initAnnotation(PSSysPDTViewDefaultACModel.class);
    }
}

