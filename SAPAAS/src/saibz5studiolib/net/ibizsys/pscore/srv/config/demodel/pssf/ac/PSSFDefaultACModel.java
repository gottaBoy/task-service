/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d1df3dd0e8f63c93511d575892fea5cb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFNAME", format="")})})
public class PSSFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFDefaultACModel() {
        this.initAnnotation(PSSFDefaultACModel.class);
    }
}

