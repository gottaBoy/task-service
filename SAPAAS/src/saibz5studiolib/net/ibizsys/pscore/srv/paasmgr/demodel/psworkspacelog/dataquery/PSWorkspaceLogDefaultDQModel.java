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
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkspacelog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9797609D-9A84-4C6D-8CDD-419C3A36F7CF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGINFO`, t1.`LOGLEVEL`, t1.`LOGLEVEL2`, t1.`LOGTYPE`, t1.`PSSVRDOMAINID`, t1.`PSSVRDOMAINNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`PSWORKSPACEID`, t1.`PSWORKSPACELOGID`, t1.`PSWORKSPACELOGNAME`, t1.`PSWORKSPACENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSWORKSPACELOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.`LOGLEVEL2`", showorder=4), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.`LOGTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=6), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t1.`PSSVRDOMAINNAME`", showorder=7), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSWORKSPACEID", expression="t1.`PSWORKSPACEID`", showorder=10), @DEDataQueryCodeExp(name="PSWORKSPACELOGID", expression="t1.`PSWORKSPACELOGID`", showorder=11), @DEDataQueryCodeExp(name="PSWORKSPACELOGNAME", expression="t1.`PSWORKSPACELOGNAME`", showorder=12), @DEDataQueryCodeExp(name="PSWORKSPACENAME", expression="t1.`PSWORKSPACENAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGINFO, t1.LOGLEVEL, t1.LOGLEVEL2, t1.LOGTYPE, t1.PSSVRDOMAINID, t1.PSSVRDOMAINNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.PSWORKSPACEID, t1.PSWORKSPACELOGID, t1.PSWORKSPACELOGNAME, t1.PSWORKSPACENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSWORKSPACELOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.LOGLEVEL2", showorder=4), @DEDataQueryCodeExp(name="LOGTYPE", expression="t1.LOGTYPE", showorder=5), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=6), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t1.PSSVRDOMAINNAME", showorder=7), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=9), @DEDataQueryCodeExp(name="PSWORKSPACEID", expression="t1.PSWORKSPACEID", showorder=10), @DEDataQueryCodeExp(name="PSWORKSPACELOGID", expression="t1.PSWORKSPACELOGID", showorder=11), @DEDataQueryCodeExp(name="PSWORKSPACELOGNAME", expression="t1.PSWORKSPACELOGNAME", showorder=12), @DEDataQueryCodeExp(name="PSWORKSPACENAME", expression="t1.PSWORKSPACENAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=19)}, conds={})})
public class PSWorkspaceLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSWorkspaceLogDefaultDQModel() {
        this.initAnnotation(PSWorkspaceLogDefaultDQModel.class);
    }
}

