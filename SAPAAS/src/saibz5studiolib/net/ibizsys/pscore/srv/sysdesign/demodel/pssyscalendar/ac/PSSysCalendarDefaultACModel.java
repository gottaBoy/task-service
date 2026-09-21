/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscalendar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="475347f364c43e03cc78f9742a6cab9c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCALENDARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCALENDARNAME", format="")})})
public class PSSysCalendarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCalendarDefaultACModel() {
        this.initAnnotation(PSSysCalendarDefaultACModel.class);
    }
}

