/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappview.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="9DAECF28-89F8-4B00-AC96-C90337E9258F", name="CurApp", queries={@DEDataSetQuery(queryid="49A23A7F-E157-4608-99DC-DC2D140F2F9B", queryname="CurApp")})
public abstract class PSAppViewCurAppDSModelBase
extends DEDataSetModelBase {
    public PSAppViewCurAppDSModelBase() {
        this.initAnnotation(PSAppViewCurAppDSModelBase.class);
    }
}

