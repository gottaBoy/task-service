/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolder.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B28ED12F-92D9-480B-B332-5810067C8E2B", name="CurUserAll", queries={@DEDataSetQuery(queryid="7B7DB480-7EEC-4603-A064-B9AACAFFC1C7", queryname="CurUser"), @DEDataSetQuery(queryid="2705F337-3AB6-48C7-B60F-7CF9EC1B727A", queryname="CurUser2")})
public abstract class PSSysModelFolderCurUserAllDSModelBase
extends DEDataSetModelBase {
    public PSSysModelFolderCurUserAllDSModelBase() {
        this.initAnnotation(PSSysModelFolderCurUserAllDSModelBase.class);
    }
}

