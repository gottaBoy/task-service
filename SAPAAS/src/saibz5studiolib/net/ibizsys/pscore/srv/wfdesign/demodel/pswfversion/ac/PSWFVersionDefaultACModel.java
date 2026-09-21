/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfversion.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4f5d9765c11352f80ec1c8965eb0dc5d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFVERSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFVERSIONNAME", format="")})})
public class PSWFVersionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFVersionDefaultACModel() {
        this.initAnnotation(PSWFVersionDefaultACModel.class);
    }
}

