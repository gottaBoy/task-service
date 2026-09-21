/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappportlet.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B4AE9E30-40D5-4BB2-B872-D84F72A264B8", name="CurApp", queries={@DEDataSetQuery(queryid="B4AE9E30-40D5-4BB2-B872-D84F72A264B8", queryname="CurApp")})
public abstract class PSAppPortletCurAppDSModelBase
extends DEDataSetModelBase {
    public PSAppPortletCurAppDSModelBase() {
        this.initAnnotation(PSAppPortletCurAppDSModelBase.class);
    }
}

