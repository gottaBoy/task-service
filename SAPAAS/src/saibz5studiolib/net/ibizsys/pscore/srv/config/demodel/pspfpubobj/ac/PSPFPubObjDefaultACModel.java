/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpubobj.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cb969a706ef23ca98ed0b7337515510e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFPUBOBJID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFPUBOBJNAME", format="")})})
public class PSPFPubObjDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFPubObjDefaultACModel() {
        this.initAnnotation(PSPFPubObjDefaultACModel.class);
    }
}

