/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsln.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="07271DC5-EF18-4DB3-AF7B-71ED9CD7129F", name="AllDCSLNUser", queries={@DEDataSetQuery(queryid="3FA1F8E2-F3FC-4040-89B7-54FCEDE8CCBE", queryname="CurDCAdmin"), @DEDataSetQuery(queryid="85F2089B-E3F5-452E-B634-96E5E9DB48D0", queryname="CurDCSLNAdmin"), @DEDataSetQuery(queryid="F535BF05-AE1E-46AE-A7FB-A325CD47961E", queryname="CurDCSLNUser"), @DEDataSetQuery(queryid="3FE255E0-D537-46F3-9728-83B73144E6D3", queryname="FromDCSLNUser")})
public abstract class PSDevSlnAllDCSLNUserDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnAllDCSLNUserDSModelBase() {
        this.initAnnotation(PSDevSlnAllDCSLNUserDSModelBase.class);
    }
}

