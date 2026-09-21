/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="FFA10E17-9B0C-4EF8-8378-1350A6BF7ED1", name="CurDCPFAll2", queries={@DEDataSetQuery(queryid="A71EFDE0-3731-4A2C-A807-65B5FFECEB4C", queryname="CurDCPF"), @DEDataSetQuery(queryid="0949057A-BBA0-4E13-9665-6E6864F861E7", queryname="CurDCPF3")})
public abstract class PSPFStyleCurDCPFAll2DSModelBase
extends DEDataSetModelBase {
    public PSPFStyleCurDCPFAll2DSModelBase() {
        this.initAnnotation(PSPFStyleCurDCPFAll2DSModelBase.class);
    }
}

