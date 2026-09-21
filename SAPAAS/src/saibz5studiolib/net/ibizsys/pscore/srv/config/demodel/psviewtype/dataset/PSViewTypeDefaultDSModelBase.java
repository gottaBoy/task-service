/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="951a4159e3541b4385a93fafadfd2e40", name="DEFAULT", queries={@DEDataSetQuery(queryid="FFABE4D1-A395-4D5D-BB7D-A6FFBE025E91", queryname="DEFAULT")})
public abstract class PSViewTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSViewTypeDefaultDSModelBase() {
        this.initAnnotation(PSViewTypeDefaultDSModelBase.class);
    }
}

