/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewpanelmodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="36f37d84a345d06f2465dc2798ec2bbb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSVIEWPANELMODELNAME", format="")})})
public class PSSysViewPanelModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysViewPanelModelDefaultACModel() {
        this.initAnnotation(PSSysViewPanelModelDefaultACModel.class);
    }
}

