/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuiaction.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="0CC5CCBF-0EA2-451A-A95F-08D270E53A5F", name="SysAndDERange", queries={@DEDataSetQuery(queryid="CE147C43-509A-45E1-9929-9C7E48431C00", queryname="DERange"), @DEDataSetQuery(queryid="08E3A09A-FC5B-4AB7-A930-75FCE0349D68", queryname="SysRange"), @DEDataSetQuery(queryid="150A794F-FF36-49C1-9AEC-831DF1DE5730", queryname="SysRange2")})
public abstract class PSDEUIActionSysAndDERangeDSModelBase
extends DEDataSetModelBase {
    public PSDEUIActionSysAndDERangeDSModelBase() {
        this.initAnnotation(PSDEUIActionSysAndDERangeDSModelBase.class);
    }
}

