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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdevstudio.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5AA9966B-4C62-43F8-A566-CA56A0321DBD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`PSSYSDEVSTUDIOID`, t1.`PSSYSDEVSTUDIONAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDEVSTUDIO` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIOID", expression="t1.`PSSYSDEVSTUDIOID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIONAME", expression="t1.`PSSYSDEVSTUDIONAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.PSSYSDEVSTUDIOID, t1.PSSYSDEVSTUDIONAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDEVSTUDIO t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=2), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIOID", expression="t1.PSSYSDEVSTUDIOID", showorder=4), @DEDataQueryCodeExp(name="PSSYSDEVSTUDIONAME", expression="t1.PSSYSDEVSTUDIONAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSSysDevStudioDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDevStudioDefaultDQModel() {
        this.initAnnotation(PSSysDevStudioDefaultDQModel.class);
    }
}

