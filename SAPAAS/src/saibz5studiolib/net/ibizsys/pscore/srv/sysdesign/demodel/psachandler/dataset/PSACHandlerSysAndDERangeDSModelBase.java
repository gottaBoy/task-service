/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psachandler.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="1901A201-2449-4E00-B6DB-FFDF885EF061", name="SysAndDERange", queries={@DEDataSetQuery(queryid="29663874-3525-403F-B983-49C69188BAD3", queryname="DERange"), @DEDataSetQuery(queryid="EABA3563-78A4-4E71-9CF2-038D92C717F5", queryname="SysRange")})
public abstract class PSACHandlerSysAndDERangeDSModelBase
extends DEDataSetModelBase {
    public PSACHandlerSysAndDERangeDSModelBase() {
        this.initAnnotation(PSACHandlerSysAndDERangeDSModelBase.class);
    }
}

