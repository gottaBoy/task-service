/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscalendarlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2ad63b4d51cf886ec497d46c562375cc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCALENDARLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCALENDARLOGICNAME", format="")})})
public class PSSysCalendarLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCalendarLogicDefaultACModel() {
        this.initAnnotation(PSSysCalendarLogicDefaultACModel.class);
    }
}

