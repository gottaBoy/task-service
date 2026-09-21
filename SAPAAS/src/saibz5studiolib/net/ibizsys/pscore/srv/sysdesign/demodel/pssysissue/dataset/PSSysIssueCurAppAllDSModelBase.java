/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysissue.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="6764CF3B-C5E2-437E-962C-F21A9D2CF54A", name="CurAppAll", queries={@DEDataSetQuery(queryid="A057B4A6-C9CE-4E93-8B2A-533AF2F1CF4F", queryname="CurApp"), @DEDataSetQuery(queryid="825DDA53-4704-4492-9B0A-C29A93F9935A", queryname="CurSys2")})
public abstract class PSSysIssueCurAppAllDSModelBase
extends DEDataSetModelBase {
    public PSSysIssueCurAppAllDSModelBase() {
        this.initAnnotation(PSSysIssueCurAppAllDSModelBase.class);
    }
}

