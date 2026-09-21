/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrunsession.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="08677c9c378058c40c75f03deb84882b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSRUNSESSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSRUNSESSIONNAME", format="")})})
public class PSSysRunSessionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysRunSessionDefaultACModel() {
        this.initAnnotation(PSSysRunSessionDefaultACModel.class);
    }
}

