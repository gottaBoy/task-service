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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuilogic.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0d06df16d7870fd67a0945bdf4f39b52", name="VIEW", viewlevel=0)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICTYPE`, t1.`MEMO`, t1.`PSDEID`, t1.`PSDELOGICID`, t1.`PSDELOGICNAME`, t1.`PSDENAME`, t1.`PSSYSDYNAMODELID`, t11.`PSSYSDYNAMODELNAME`, t1.`PSSYSREQITEMID`, t21.`PSSYSREQITEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSDELOGIC` t1  LEFT JOIN T_SRFPSSYSDYNAMODEL t11 ON t1.PSSYSDYNAMODELID = t11.PSSYSDYNAMODELID  LEFT JOIN T_SRFPSSYSREQITEM t21 ON t1.PSSYSREQITEMID = t21.PSSYSREQITEMID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LOGICTYPE", expression="t1.`LOGICTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDELOGICID", expression="t1.`PSDELOGICID`", showorder=6), @DEDataQueryCodeExp(name="PSDELOGICNAME", expression="t1.`PSDELOGICNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSDYNAMODELID", expression="t1.`PSSYSDYNAMODELID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSDYNAMODELNAME", expression="t11.`PSSYSDYNAMODELNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.`PSSYSREQITEMID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t21.`PSSYSREQITEMNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=19)}, conds={@DEDataQueryCodeCond(condition="( t1.`LOGICTYPE` = 'VIEWLOGIC' )")}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.LOGICTYPE, t1.MEMO, t1.PSDEID, t1.PSDELOGICID, t1.PSDELOGICNAME, t1.PSDENAME, t1.PSSYSDYNAMODELID, t11.PSSYSDYNAMODELNAME, t1.PSSYSREQITEMID, t21.PSSYSREQITEMNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSDELOGIC t1  LEFT JOIN T_SRFPSSYSDYNAMODEL t11 ON t1.PSSYSDYNAMODELID = t11.PSSYSDYNAMODELID  LEFT JOIN T_SRFPSSYSREQITEM t21 ON t1.PSSYSREQITEMID = t21.PSSYSREQITEMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LOGICTYPE", expression="t1.LOGICTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDELOGICID", expression="t1.PSDELOGICID", showorder=6), @DEDataQueryCodeExp(name="PSDELOGICNAME", expression="t1.PSDELOGICNAME", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSDYNAMODELID", expression="t1.PSSYSDYNAMODELID", showorder=9), @DEDataQueryCodeExp(name="PSSYSDYNAMODELNAME", expression="t11.PSSYSDYNAMODELNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.PSSYSREQITEMID", showorder=11), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t21.PSSYSREQITEMNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=19)}, conds={@DEDataQueryCodeCond(condition="( t1.LOGICTYPE = 'VIEWLOGIC' )")})})
public class PSDEUILogicViewDQModel
extends DEDataQueryModelBase {
    public PSDEUILogicViewDQModel() {
        this.initAnnotation(PSDEUILogicViewDQModel.class);
    }
}

