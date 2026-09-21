/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmodelloadlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="873F308D-11D5-4ED5-96F9-8668EAAA495B", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGLEVEL`, t1.`MEMO`, t1.`PSDYNAINSTID`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`PSOBJTYPE`, t1.`PSSYSMODELLOADLOGID`, t1.`PSSYSMODELLOADLOGNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSMODELLOADLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="EXCEPTIONINFO", expression="t1.`EXCEPTIONINFO`", showorder=-1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=5), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=6), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=7), @DEDataQueryCodeExp(name="PSSYSMODELLOADLOGID", expression="t1.`PSSYSMODELLOADLOGID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELLOADLOGNAME", expression="t1.`PSSYSMODELLOADLOGNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=11), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=12), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSMODELLOADLOG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGLEVEL, t1.MEMO, t1.PSDYNAINSTID, t1.PSOBJID, t1.PSOBJNAME, t1.PSOBJTYPE, t1.PSSYSMODELLOADLOGID, t1.PSSYSMODELLOADLOGNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSMODELLOADLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="EXCEPTIONINFO", expression="t1.EXCEPTIONINFO", showorder=-1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=4), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=5), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=6), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=7), @DEDataQueryCodeExp(name="PSSYSMODELLOADLOGID", expression="t1.PSSYSMODELLOADLOGID", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELLOADLOGNAME", expression="t1.PSSYSMODELLOADLOGNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=11), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=12), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSMODELLOADLOG\"}')} )")})})
public class PSSysModelLoadLogCurSysDQModel
extends DEDataQueryModelBase {
    public PSSysModelLoadLogCurSysDQModel() {
        this.initAnnotation(PSSysModelLoadLogCurSysDQModel.class);
    }
}

