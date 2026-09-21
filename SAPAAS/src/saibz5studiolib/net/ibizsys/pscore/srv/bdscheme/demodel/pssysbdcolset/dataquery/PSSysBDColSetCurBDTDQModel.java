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
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdcolset.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D78053B6-DA10-4188-9FF6-40F45803008B", name="CurBDT")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSSYSBDCOLSETID`, t1.`PSSYSBDCOLSETNAME`, t1.`PSSYSBDTABLEID`, t11.`PSSYSBDTABLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSBDCOLSET` t1  LEFT JOIN T_SRFPSSYSBDTABLE t11 ON t1.PSSYSBDTABLEID = t11.PSSYSBDTABLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDCOLSETID", expression="t1.`PSSYSBDCOLSETID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDCOLSETNAME", expression="t1.`PSSYSBDCOLSETNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDTABLEID", expression="t1.`PSSYSBDTABLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDTABLENAME", expression="t11.`PSSYSBDTABLENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSBDTABLEID` =  ${srfdatacontext('pssysbdtableid','{\"defname\":\"PSSYSBDTABLEID\",\"dename\":\"PSSYSBDCOLSET\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.LOGICNAME, t1.MEMO, t1.PSSYSBDCOLSETID, t1.PSSYSBDCOLSETNAME, t1.PSSYSBDTABLEID, t11.PSSYSBDTABLENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSBDCOLSET t1  LEFT JOIN T_SRFPSSYSBDTABLE t11 ON t1.PSSYSBDTABLEID = t11.PSSYSBDTABLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDCOLSETID", expression="t1.PSSYSBDCOLSETID", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDCOLSETNAME", expression="t1.PSSYSBDCOLSETNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDTABLEID", expression="t1.PSSYSBDTABLEID", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDTABLENAME", expression="t11.PSSYSBDTABLENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSBDTABLEID =  ${srfdatacontext('pssysbdtableid','{\"defname\":\"PSSYSBDTABLEID\",\"dename\":\"PSSYSBDCOLSET\"}')} )")})})
public class PSSysBDColSetCurBDTDQModel
extends DEDataQueryModelBase {
    public PSSysBDColSetCurBDTDQModel() {
        this.initAnnotation(PSSysBDColSetCurBDTDQModel.class);
    }
}

