/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelseq.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4c006173b3d878851bcb1c92cab52ea8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELSEQID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELSEQNAME", format="")})})
public class PSModelSeqDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelSeqDefaultACModel() {
        this.initAnnotation(PSModelSeqDefaultACModel.class);
    }
}

