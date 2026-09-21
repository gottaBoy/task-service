/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscredential.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B3690F8A-FF3E-42CF-B606-010310D2E1E6", name="CurDCValid2", queries={@DEDataSetQuery(queryid="85A06052-71FC-49E0-B664-6649F9FE7DFD", queryname="AllDCValid"), @DEDataSetQuery(queryid="8793C697-858A-44DD-93D0-7B85FBBA2A71", queryname="CurDCValid")})
public abstract class PSCredentialCurDCValid2DSModelBase
extends DEDataSetModelBase {
    public PSCredentialCurDCValid2DSModelBase() {
        this.initAnnotation(PSCredentialCurDCValid2DSModelBase.class);
    }
}

