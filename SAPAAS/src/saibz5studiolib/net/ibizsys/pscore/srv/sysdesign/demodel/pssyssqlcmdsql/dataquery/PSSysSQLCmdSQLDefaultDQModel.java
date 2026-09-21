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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssqlcmdsql.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="325B84B2-CD18-42D7-9209-47410EB65D8E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSSQLCMDID`, t11.`LOGICNAME` AS `PSSYSSQLCMDNAME`, t1.`PSSYSSQLCMDSQLID`, t1.`PSSYSSQLCMDSQLNAME`, t1.`SQLCODE`, t1.`SQLPARAMS`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSSQLCMDSQL` t1  LEFT JOIN `T_SRFPSSYSSQLCMD` t11 ON t1.`PSSYSSQLCMDID` = t11.`PSSYSSQLCMDID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="SQLCODE2", expression="t1.`SQLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSSQLCMDID", expression="t1.`PSSYSSQLCMDID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSSQLCMDNAME", expression="t11.`LOGICNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSSQLCMDSQLID", expression="t1.`PSSYSSQLCMDSQLID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSSQLCMDSQLNAME", expression="t1.`PSSYSSQLCMDSQLNAME`", showorder=6), @DEDataQueryCodeExp(name="SQLCODE", expression="t1.`SQLCODE`", showorder=7), @DEDataQueryCodeExp(name="SQLPARAMS", expression="t1.`SQLPARAMS`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSSQLCMDID, t11.LOGICNAME AS PSSYSSQLCMDNAME, t1.PSSYSSQLCMDSQLID, t1.PSSYSSQLCMDSQLNAME, t1.SQLCODE, t1.SQLPARAMS, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSSQLCMDSQL t1  LEFT JOIN T_SRFPSSYSSQLCMD t11 ON t1.PSSYSSQLCMDID = t11.PSSYSSQLCMDID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="SQLCODE2", expression="t1.SQLCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSSQLCMDID", expression="t1.PSSYSSQLCMDID", showorder=3), @DEDataQueryCodeExp(name="PSSYSSQLCMDNAME", expression="t11.LOGICNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSSQLCMDSQLID", expression="t1.PSSYSSQLCMDSQLID", showorder=5), @DEDataQueryCodeExp(name="PSSYSSQLCMDSQLNAME", expression="t1.PSSYSSQLCMDSQLNAME", showorder=6), @DEDataQueryCodeExp(name="SQLCODE", expression="t1.SQLCODE", showorder=7), @DEDataQueryCodeExp(name="SQLPARAMS", expression="t1.SQLPARAMS", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15)}, conds={})})
public class PSSysSQLCmdSQLDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysSQLCmdSQLDefaultDQModel() {
        this.initAnnotation(PSSysSQLCmdSQLDefaultDQModel.class);
    }
}

