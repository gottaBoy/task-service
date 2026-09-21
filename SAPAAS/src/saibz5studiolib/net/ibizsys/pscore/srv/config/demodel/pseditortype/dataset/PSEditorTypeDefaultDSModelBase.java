/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pseditortype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="50eb16ea68b6397ef54d667a3c2d1125", name="DEFAULT", queries={@DEDataSetQuery(queryid="DA507A10-7ABA-4E83-998F-6162C07F2130", queryname="DEFAULT")})
public abstract class PSEditorTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSEditorTypeDefaultDSModelBase() {
        this.initAnnotation(PSEditorTypeDefaultDSModelBase.class);
    }
}

