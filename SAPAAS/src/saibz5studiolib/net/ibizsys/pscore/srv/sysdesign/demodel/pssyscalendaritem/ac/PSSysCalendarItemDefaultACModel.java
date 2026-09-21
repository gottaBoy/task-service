/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscalendaritem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cedfa27842a3fe6bcb749aff634741be", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCALENDARITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCALENDARITEMNAME", format="")})})
public class PSSysCalendarItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCalendarItemDefaultACModel() {
        this.initAnnotation(PSSysCalendarItemDefaultACModel.class);
    }
}

