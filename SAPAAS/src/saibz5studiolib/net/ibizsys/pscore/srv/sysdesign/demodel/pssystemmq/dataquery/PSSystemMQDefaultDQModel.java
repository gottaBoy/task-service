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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemmq.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0A26BE2A-B5D3-46E3-B7EF-D9DA2B6AA5E1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MQID`, t1.`PSDEVCENTERMQID`, t11.`PSDEVCENTERMQNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMMQID`, t1.`PSSYSTEMMQNAME`, t1.`PSSYSTEMNAME`, t1.`RESINFO`, t1.`RESREADYTIME`, t1.`RESSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSTEMMQ` t1  LEFT JOIN T_SRFPSDEVCENTERMQ t11 ON t1.PSDEVCENTERMQID = t11.PSDEVCENTERMQID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="MQID", expression="t1.`MQID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERMQID", expression="t1.`PSDEVCENTERMQID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERMQNAME", expression="t11.`PSDEVCENTERMQNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMMQID", expression="t1.`PSSYSTEMMQID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMMQNAME", expression="t1.`PSSYSTEMMQNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=9), @DEDataQueryCodeExp(name="RESINFO", expression="t1.`RESINFO`", showorder=10), @DEDataQueryCodeExp(name="RESREADYTIME", expression="t1.`RESREADYTIME`", showorder=11), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.`RESSTATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MQID, t1.PSDEVCENTERMQID, t11.PSDEVCENTERMQNAME, t1.PSSYSTEMID, t1.PSSYSTEMMQID, t1.PSSYSTEMMQNAME, t1.PSSYSTEMNAME, t1.RESINFO, t1.RESREADYTIME, t1.RESSTATE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSTEMMQ t1  LEFT JOIN T_SRFPSDEVCENTERMQ t11 ON t1.PSDEVCENTERMQID = t11.PSDEVCENTERMQID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="MQID", expression="t1.MQID", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERMQID", expression="t1.PSDEVCENTERMQID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERMQNAME", expression="t11.PSDEVCENTERMQNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMMQID", expression="t1.PSSYSTEMMQID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMMQNAME", expression="t1.PSSYSTEMMQNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=9), @DEDataQueryCodeExp(name="RESINFO", expression="t1.RESINFO", showorder=10), @DEDataQueryCodeExp(name="RESREADYTIME", expression="t1.RESREADYTIME", showorder=11), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.RESSTATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSSystemMQDefaultDQModel
extends DEDataQueryModelBase {
    public PSSystemMQDefaultDQModel() {
        this.initAnnotation(PSSystemMQDefaultDQModel.class);
    }
}

