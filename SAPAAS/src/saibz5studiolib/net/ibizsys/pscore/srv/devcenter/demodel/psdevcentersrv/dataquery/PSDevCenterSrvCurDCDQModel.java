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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcentersrv.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C20CFC49-C10E-449E-BACD-5F290E4F7813", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`MEMO`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSDEVCENTERSRVID`, t1.`PSDEVCENTERSRVNAME`, t1.`PSDEVSERVERID`, t21.`PSDEVSERVERNAME`, t1.`SVRSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVCENTERSRV` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSDEVSERVER t21 ON t1.PSDEVSERVERID = t21.PSDEVSERVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERSRVID", expression="t1.`PSDEVCENTERSRVID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERSRVNAME", expression="t1.`PSDEVCENTERSRVNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSERVERID", expression="t1.`PSDEVSERVERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSERVERNAME", expression="t21.`PSDEVSERVERNAME`", showorder=10), @DEDataQueryCodeExp(name="SVRSTATE", expression="t1.`SVRSTATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDEVCENTERSRV\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MEMO, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSDEVCENTERSRVID, t1.PSDEVCENTERSRVNAME, t1.PSDEVSERVERID, t21.PSDEVSERVERNAME, t1.SVRSTATE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVCENTERSRV t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSDEVSERVER t21 ON t1.PSDEVSERVERID = t21.PSDEVSERVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERSRVID", expression="t1.PSDEVCENTERSRVID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERSRVNAME", expression="t1.PSDEVCENTERSRVNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVSERVERID", expression="t1.PSDEVSERVERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVSERVERNAME", expression="t21.PSDEVSERVERNAME", showorder=10), @DEDataQueryCodeExp(name="SVRSTATE", expression="t1.SVRSTATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDEVCENTERSRV\"}')} )")})})
public class PSDevCenterSrvCurDCDQModel
extends DEDataQueryModelBase {
    public PSDevCenterSrvCurDCDQModel() {
        this.initAnnotation(PSDevCenterSrvCurDCDQModel.class);
    }
}

