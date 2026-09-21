/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="FE586DDB-4B0D-4A16-A523-95BE456FB63B", name="CurDCAll", queries={@DEDataSetQuery(queryid="D799DD03-4DEA-45D8-81F2-D8E247D6084D", queryname="CurDC"), @DEDataSetQuery(queryid="EB973C64-9A28-4721-86AB-46C0FF6F0000", queryname="CurDC2")})
public abstract class PSSFStyleCurDCAllDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCAllDSModelBase() {
        this.initAnnotation(PSSFStyleCurDCAllDSModelBase.class);
    }
}

