/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfctrltempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="03a65023aff7ecf4e8592087910e3e62", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFCTRLTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFCTRLTEMPLNAME", format="")})})
public class PSPFCtrlTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFCtrlTemplDefaultACModel() {
        this.initAnnotation(PSPFCtrlTemplDefaultACModel.class);
    }
}

