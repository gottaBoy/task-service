/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsysapi.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="084122B5-5B97-47DF-B7C9-F6C95C5BC086", name="CurVer", queries={@DEDataSetQuery(queryid="084122B5-5B97-47DF-B7C9-F6C95C5BC086", queryname="CurVer")})
public abstract class PSDepSysAPICurVerDSModelBase
extends DEDataSetModelBase {
    public PSDepSysAPICurVerDSModelBase() {
        this.initAnnotation(PSDepSysAPICurVerDSModelBase.class);
    }
}

