/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdewizardlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="99f2006ca4ef210a559503a282003751", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEWIZARDLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEWIZARDLOGICNAME", format="")})})
public class PSDEWizardLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEWizardLogicDefaultACModel() {
        this.initAnnotation(PSDEWizardLogicDefaultACModel.class);
    }
}

