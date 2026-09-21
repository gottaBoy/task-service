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
package net.ibizsys.pscore.srv.config.demodel.pssysdevbttype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="40B1E140-221A-46FD-B903-3564C996DE64", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSDEVBTTYPEID`, t1.`PSSYSDEVBTTYPENAME`, t1.`TASKOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USEROBOTFLAG` FROM `T_SRFPSSYSDEVBTTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEVBTTYPEID", expression="t1.`PSSYSDEVBTTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEVBTTYPENAME", expression="t1.`PSSYSDEVBTTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="TASKOBJ", expression="t1.`TASKOBJ`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="USEROBOTFLAG", expression="t1.`USEROBOTFLAG`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSDEVBTTYPEID, t1.PSSYSDEVBTTYPENAME, t1.TASKOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.USEROBOTFLAG FROM T_SRFPSSYSDEVBTTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSDEVBTTYPEID", expression="t1.PSSYSDEVBTTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSSYSDEVBTTYPENAME", expression="t1.PSSYSDEVBTTYPENAME", showorder=4), @DEDataQueryCodeExp(name="TASKOBJ", expression="t1.TASKOBJ", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="USEROBOTFLAG", expression="t1.USEROBOTFLAG", showorder=8)}, conds={})})
public class PSSysDevBTTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDevBTTypeDefaultDQModel() {
        this.initAnnotation(PSSysDevBTTypeDefaultDQModel.class);
    }
}

