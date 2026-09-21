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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="40A76441-7D77-43FD-B2BA-4C06D21515AF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`LEAFFLAG`, t1.`MEMO`, t1.`METHODNAME`, t1.`ORDERVALUE`, t1.`PPSMODELRTID`, t1.`PPSMODELRTNAME`, t1.`PSMODELRTID`, t1.`PSMODELRTNAME`, t1.`RTDATA`, t1.`RTDATA2`, t1.`RTTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELRT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="LEAFFLAG", expression="t1.`LEAFFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="METHODNAME", expression="t1.`METHODNAME`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PPSMODELRTID", expression="t1.`PPSMODELRTID`", showorder=7), @DEDataQueryCodeExp(name="PPSMODELRTNAME", expression="t1.`PPSMODELRTNAME`", showorder=8), @DEDataQueryCodeExp(name="PSMODELRTID", expression="t1.`PSMODELRTID`", showorder=9), @DEDataQueryCodeExp(name="PSMODELRTNAME", expression="t1.`PSMODELRTNAME`", showorder=10), @DEDataQueryCodeExp(name="RTDATA", expression="t1.`RTDATA`", showorder=11), @DEDataQueryCodeExp(name="RTDATA2", expression="t1.`RTDATA2`", showorder=12), @DEDataQueryCodeExp(name="RTTYPE", expression="t1.`RTTYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.LEAFFLAG, t1.MEMO, t1.METHODNAME, t1.ORDERVALUE, t1.PPSMODELRTID, t1.PPSMODELRTNAME, t1.PSMODELRTID, t1.PSMODELRTNAME, t1.RTDATA, t1.RTDATA2, t1.RTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELRT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="LEAFFLAG", expression="t1.LEAFFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="METHODNAME", expression="t1.METHODNAME", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PPSMODELRTID", expression="t1.PPSMODELRTID", showorder=7), @DEDataQueryCodeExp(name="PPSMODELRTNAME", expression="t1.PPSMODELRTNAME", showorder=8), @DEDataQueryCodeExp(name="PSMODELRTID", expression="t1.PSMODELRTID", showorder=9), @DEDataQueryCodeExp(name="PSMODELRTNAME", expression="t1.PSMODELRTNAME", showorder=10), @DEDataQueryCodeExp(name="RTDATA", expression="t1.RTDATA", showorder=11), @DEDataQueryCodeExp(name="RTDATA2", expression="t1.RTDATA2", showorder=12), @DEDataQueryCodeExp(name="RTTYPE", expression="t1.RTTYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSModelRTDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelRTDefaultDQModel() {
        this.initAnnotation(PSModelRTDefaultDQModel.class);
    }
}

