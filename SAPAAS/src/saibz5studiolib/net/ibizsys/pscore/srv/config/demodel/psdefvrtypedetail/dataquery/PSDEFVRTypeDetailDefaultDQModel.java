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
package net.ibizsys.pscore.srv.config.demodel.psdefvrtypedetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D77FD035-678B-4894-829F-A24A79905405", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PROCESSOBJ`, t1.`PSDEFVRTYPEDETAILID`, t1.`PSDEFVRTYPEDETAILNAME`, t1.`PSDEFVRTYPEID`, t11.`PSDEFVRTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEFVRTYPEDETAIL` t1  LEFT JOIN T_SRFPSDEFVRTYPE t11 ON t1.PSDEFVRTYPEID = t11.PSDEFVRTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PROCESSOBJ", expression="t1.`PROCESSOBJ`", showorder=3), @DEDataQueryCodeExp(name="PSDEFVRTYPEDETAILID", expression="t1.`PSDEFVRTYPEDETAILID`", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRTYPEDETAILNAME", expression="t1.`PSDEFVRTYPEDETAILNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRTYPEID", expression="t1.`PSDEFVRTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSDEFVRTYPENAME", expression="t11.`PSDEFVRTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSOBJ, t1.PSDEFVRTYPEDETAILID, t1.PSDEFVRTYPEDETAILNAME, t1.PSDEFVRTYPEID, t11.PSDEFVRTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEFVRTYPEDETAIL t1  LEFT JOIN T_SRFPSDEFVRTYPE t11 ON t1.PSDEFVRTYPEID = t11.PSDEFVRTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PROCESSOBJ", expression="t1.PROCESSOBJ", showorder=3), @DEDataQueryCodeExp(name="PSDEFVRTYPEDETAILID", expression="t1.PSDEFVRTYPEDETAILID", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRTYPEDETAILNAME", expression="t1.PSDEFVRTYPEDETAILNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRTYPEID", expression="t1.PSDEFVRTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSDEFVRTYPENAME", expression="t11.PSDEFVRTYPENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDEFVRTypeDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFVRTypeDetailDefaultDQModel() {
        this.initAnnotation(PSDEFVRTypeDetailDefaultDQModel.class);
    }
}

