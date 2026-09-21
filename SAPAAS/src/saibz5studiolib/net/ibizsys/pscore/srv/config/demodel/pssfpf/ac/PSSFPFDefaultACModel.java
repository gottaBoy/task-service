/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8743cd34477107bce90c0419095bc890", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFPFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFPFNAME", format="")})})
public class PSSFPFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFPFDefaultACModel() {
        this.initAnnotation(PSSFPFDefaultACModel.class);
    }
}

