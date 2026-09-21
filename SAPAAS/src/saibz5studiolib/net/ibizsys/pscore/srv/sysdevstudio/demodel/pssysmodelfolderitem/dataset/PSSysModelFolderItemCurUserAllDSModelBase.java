/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="65256519-3859-44D7-9676-1431749A8906", name="CurUserAll", queries={@DEDataSetQuery(queryid="17ADD44D-0458-47D2-AD82-DEEDBACD7CBB", queryname="CurUser"), @DEDataSetQuery(queryid="1432EAA7-D0A5-4756-8182-34EC461417CC", queryname="CurUser2")})
public abstract class PSSysModelFolderItemCurUserAllDSModelBase
extends DEDataSetModelBase {
    public PSSysModelFolderItemCurUserAllDSModelBase() {
        this.initAnnotation(PSSysModelFolderItemCurUserAllDSModelBase.class);
    }
}

