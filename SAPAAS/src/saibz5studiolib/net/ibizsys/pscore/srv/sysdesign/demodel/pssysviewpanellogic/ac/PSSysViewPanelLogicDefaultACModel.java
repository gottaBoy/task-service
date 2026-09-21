/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewpanellogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ae4b9ff411d68c05ab154550f7d2d872", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELLOGICNAME", format="")})})
public class PSSysViewPanelLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysViewPanelLogicDefaultACModel() {
        this.initAnnotation(PSSysViewPanelLogicDefaultACModel.class);
    }
}

