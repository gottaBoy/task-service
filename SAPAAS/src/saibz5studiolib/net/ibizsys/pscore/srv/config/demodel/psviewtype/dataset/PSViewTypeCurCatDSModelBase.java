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

@DEDataSet(id="15CC857B-8F36-439C-B6B8-B7F3EA056E91", name="CurCat", queries={@DEDataSetQuery(queryid="FB1C5C88-A8CF-4D72-AACF-FDF4C4849BBE", queryname="CurCat")})
public abstract class PSViewTypeCurCatDSModelBase
extends DEDataSetModelBase {
    public PSViewTypeCurCatDSModelBase() {
        this.initAnnotation(PSViewTypeCurCatDSModelBase.class);
    }
}

