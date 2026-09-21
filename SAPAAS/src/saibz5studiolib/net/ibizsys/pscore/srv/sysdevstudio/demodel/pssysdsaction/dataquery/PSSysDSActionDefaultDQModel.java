/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdsaction.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="1E9CC697-E78B-4FF8-A547-3302F4629D33", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSYSDEVSTUDIOID`, t11.`PSSYSDEVSTUDIONAME`, t1.`PSSYSDSACTIONID`, t1.`PSSYSDSACTIONNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDSACTION` t1  LEFT JOIN T_SRFPSSYSDEVSTUDIO t11 ON t1.PSSYSDEVSTUDIOID = t11.PSSYSDEVSTUDIOID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIOID", expression="t1.`PSSYSDEVSTUDIOID`", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIONAME", expression="t11.`PSSYSDEVSTUDIONAME`", showorder=3), @DEDataQueryCodeExp(name="PSSYSDSACTIONID", expression="t1.`PSSYSDSACTIONID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDSACTIONNAME", expression="t1.`PSSYSDSACTIONNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSSYSDEVSTUDIOID, t11.PSSYSDEVSTUDIONAME, t1.PSSYSDSACTIONID, t1.PSSYSDSACTIONNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDSACTION t1  LEFT JOIN T_SRFPSSYSDEVSTUDIO t11 ON t1.PSSYSDEVSTUDIOID = t11.PSSYSDEVSTUDIOID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIOID", expression="t1.PSSYSDEVSTUDIOID", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIONAME", expression="t11.PSSYSDEVSTUDIONAME", showorder=3), @DEDataQueryCodeExp(name="PSSYSDSACTIONID", expression="t1.PSSYSDSACTIONID", showorder=4), @DEDataQueryCodeExp(name="PSSYSDSACTIONNAME", expression="t1.PSSYSDSACTIONNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSSysDSActionDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDSActionDefaultDQModel() {
        this.initAnnotation(PSSysDSActionDefaultDQModel.class);
    }
}

