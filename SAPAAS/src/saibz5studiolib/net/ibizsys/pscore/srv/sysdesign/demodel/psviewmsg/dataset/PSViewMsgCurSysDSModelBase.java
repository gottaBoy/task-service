/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psviewmsg.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="154FB220-EA94-448D-80B1-2165245610BB", name="CurSys", queries={@DEDataSetQuery(queryid="C05FF66D-37CE-45D5-9D29-C0F4A2C86B6A", queryname="CurSys")})
public abstract class PSViewMsgCurSysDSModelBase
extends DEDataSetModelBase {
    public PSViewMsgCurSysDSModelBase() {
        this.initAnnotation(PSViewMsgCurSysDSModelBase.class);
    }
}

