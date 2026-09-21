/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnprd.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5008f59f850f50c503212607d45b4889", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNPRDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNPRDNAME", format="")})})
public class PSDepSlnPrdDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnPrdDefaultACModel() {
        this.initAnnotation(PSDepSlnPrdDefaultACModel.class);
    }
}

