/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfcodetype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="BA613274-BC62-462F-A680-78CD417E3A9C", name="CurSF2", queries={@DEDataSetQuery(queryid="F2149DC0-749A-4BC4-B09A-D9BAA187C9ED", queryname="CurSF2"), @DEDataSetQuery(queryid="E92B22A0-FDFB-40E5-ADD6-E33A66DCB0A9", queryname="CurSF3"), @DEDataSetQuery(queryid="E6F60F8E-848D-4D66-8296-5950406411E3", queryname="CurSF4")})
public abstract class PSSFCodeTypeCurSF2DSModelBase
extends DEDataSetModelBase {
    public PSSFCodeTypeCurSF2DSModelBase() {
        this.initAnnotation(PSSFCodeTypeCurSF2DSModelBase.class);
    }
}

