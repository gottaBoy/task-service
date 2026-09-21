/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psgituser.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="40DB58E9-2DA2-4EFC-B46D-474F32AB50DB", name="CurDCValid2", queries={@DEDataSetQuery(queryid="0EC3BCB9-92A3-4B8A-87D7-A891704FD6FD", queryname="AllDCValid"), @DEDataSetQuery(queryid="E2B53AC4-590C-453C-A272-76EE79ADF776", queryname="CurDCValid")})
public abstract class PSGitUserCurDCValid2DSModelBase
extends DEDataSetModelBase {
    public PSGitUserCurDCValid2DSModelBase() {
        this.initAnnotation(PSGitUserCurDCValid2DSModelBase.class);
    }
}

