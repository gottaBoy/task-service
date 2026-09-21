/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="8743cd34477107bce90c0419095bc890", name="DEFAULT", queries={@DEDataSetQuery(queryid="AF397004-EFF9-46B2-B25F-BE8CC36FD4F8", queryname="DEFAULT")})
public abstract class PSSFPFDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFPFDefaultDSModelBase() {
        this.initAnnotation(PSSFPFDefaultDSModelBase.class);
    }
}

