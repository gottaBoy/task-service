/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysfile.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2749e05c95dd9a2925d1cf3d85f4f7de", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSFILEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSFILENAME", format="")})})
public class PSSysFileDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysFileDefaultACModel() {
        this.initAnnotation(PSSysFileDefaultACModel.class);
    }
}

