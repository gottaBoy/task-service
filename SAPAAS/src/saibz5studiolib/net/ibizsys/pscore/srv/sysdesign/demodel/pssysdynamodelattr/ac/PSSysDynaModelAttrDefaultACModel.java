/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdynamodelattr.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="399cfef9d8a2abb2e2bfb4e9d16cc226", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELATTRID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDYNAMODELATTRNAME", format="")})})
public class PSSysDynaModelAttrDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDynaModelAttrDefaultACModel() {
        this.initAnnotation(PSSysDynaModelAttrDefaultACModel.class);
    }
}

