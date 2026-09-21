/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmosfile.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5e76edfd0dbe2a204bf95059181f4728", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMOSFILEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMOSFILENAME", format="")})})
public class PSMOSFileDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMOSFileDefaultACModel() {
        this.initAnnotation(PSMOSFileDefaultACModel.class);
    }
}

