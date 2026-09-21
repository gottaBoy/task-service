/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pswflinkcondtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d5ddc2d2f3a216df97583a905cffc776", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFLINKCONDTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFLINKCONDTYPENAME", format="")})})
public class PSWFLinkCondTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFLinkCondTypeDefaultACModel() {
        this.initAnnotation(PSWFLinkCondTypeDefaultACModel.class);
    }
}

