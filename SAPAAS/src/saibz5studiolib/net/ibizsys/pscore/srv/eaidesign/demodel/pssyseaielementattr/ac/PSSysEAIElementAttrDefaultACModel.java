/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.eaidesign.demodel.pssyseaielementattr.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1da955b585085f272acf6e84fbeb7a4c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSEAIELEMENTATTRID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSEAIELEMENTATTRNAME", format="")})})
public class PSSysEAIElementAttrDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysEAIElementAttrDefaultACModel() {
        this.initAnnotation(PSSysEAIElementAttrDefaultACModel.class);
    }
}

