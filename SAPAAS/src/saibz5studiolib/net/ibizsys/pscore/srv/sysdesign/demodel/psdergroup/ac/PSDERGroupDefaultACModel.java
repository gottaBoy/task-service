/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdergroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="55baa32114ec14d03d059b7a941524fe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDERGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDERGROUPNAME", format="")})})
public class PSDERGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERGroupDefaultACModel() {
        this.initAnnotation(PSDERGroupDefaultACModel.class);
    }
}

