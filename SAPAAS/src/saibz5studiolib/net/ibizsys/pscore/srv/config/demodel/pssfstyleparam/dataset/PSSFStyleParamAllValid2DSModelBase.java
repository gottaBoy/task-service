/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyleparam.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="EAD8CCE2-B361-4325-8440-033A1DB86BE7", name="AllValid2", queries={@DEDataSetQuery(queryid="930305FA-E285-470A-A3FB-EFB2A4B74363", queryname="AllDCValid2"), @DEDataSetQuery(queryid="4830B7CB-8FCC-47CE-BFDC-1684C01F0C80", queryname="CurDCValid2")})
public abstract class PSSFStyleParamAllValid2DSModelBase
extends DEDataSetModelBase {
    public PSSFStyleParamAllValid2DSModelBase() {
        this.initAnnotation(PSSFStyleParamAllValid2DSModelBase.class);
    }
}

