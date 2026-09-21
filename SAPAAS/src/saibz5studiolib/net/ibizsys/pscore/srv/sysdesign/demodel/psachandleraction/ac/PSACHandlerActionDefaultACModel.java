/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psachandleraction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d5d650846fa1b34b6725b817426bdbb7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSACHANDLERACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSACHANDLERACTIONNAME", format="")})})
public class PSACHandlerActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSACHandlerActionDefaultACModel() {
        this.initAnnotation(PSACHandlerActionDefaultACModel.class);
    }
}

