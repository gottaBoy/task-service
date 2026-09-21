/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpengineinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="41cfeba443fe7bfcf0def6ba17733e2f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPENGINEINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPENGINEINSTNAME", format="")})})
public class PSWPEngineInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPEngineInstDefaultACModel() {
        this.initAnnotation(PSWPEngineInstDefaultACModel.class);
    }
}

