/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmodule.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="52335D35-BD06-4A96-A573-DE27E311CF8C", name="CurApp", queries={@DEDataSetQuery(queryid="BDB1E51F-3C4A-4AC6-BC04-C633D49776B9", queryname="CurApp")})
public abstract class PSAppModuleCurAppDSModelBase
extends DEDataSetModelBase {
    public PSAppModuleCurAppDSModelBase() {
        this.initAnnotation(PSAppModuleCurAppDSModelBase.class);
    }
}

