/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyslanres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a9e4838ad69a654e899252ec4a050f97", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSLANRESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSLANRESNAME", format="")})})
public class PSSysLanResDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysLanResDefaultACModel() {
        this.initAnnotation(PSSysLanResDefaultACModel.class);
    }
}

