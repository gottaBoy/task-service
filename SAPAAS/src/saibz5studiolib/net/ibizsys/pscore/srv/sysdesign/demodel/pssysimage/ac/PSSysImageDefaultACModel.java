/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysimage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6f1e56eee00fe98cad04e29faa9b89d1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSIMAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSIMAGENAME", format="")})})
public class PSSysImageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysImageDefaultACModel() {
        this.initAnnotation(PSSysImageDefaultACModel.class);
    }
}

