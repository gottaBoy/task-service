/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappdeview.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E058DD20-703C-4EE1-93EE-8283F2C376C3", name="CurApp", queries={@DEDataSetQuery(queryid="E058DD20-703C-4EE1-93EE-8283F2C376C3", queryname="CurApp")})
public abstract class PSAppDEViewCurAppDSModelBase
extends DEDataSetModelBase {
    public PSAppDEViewCurAppDSModelBase() {
        this.initAnnotation(PSAppDEViewCurAppDSModelBase.class);
    }
}

