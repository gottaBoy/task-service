/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E0AE6551-A1FF-45D7-9DAE-0E3DFB523BF6", name="CurDCAllValid", queries={@DEDataSetQuery(queryid="B16E47D2-97D7-49DF-ABE6-DCEDB187626A", queryname="AllValid"), @DEDataSetQuery(queryid="1DC0BD1B-96B0-42DB-8A5F-333C61A20DDB", queryname="DCValid")})
public abstract class PSSFPluginCurDCAllValidDSModelBase
extends DEDataSetModelBase {
    public PSSFPluginCurDCAllValidDSModelBase() {
        this.initAnnotation(PSSFPluginCurDCAllValidDSModelBase.class);
    }
}

