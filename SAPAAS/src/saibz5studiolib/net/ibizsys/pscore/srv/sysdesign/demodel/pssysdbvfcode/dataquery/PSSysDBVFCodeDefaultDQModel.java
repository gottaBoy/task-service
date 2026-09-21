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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbvfcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9987B33C-3DB8-41FA-86C0-A862B6A1F970", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CALLCODE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBTYPE`, t1.`MEMO`, t1.`PSSYSDBVFCODEID`, t1.`PSSYSDBVFCODENAME`, t1.`PSSYSDBVFID`, t11.`PSSYSDBVFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDBVFCODE` t1  LEFT JOIN `T_SRFPSSYSDBVF` t11 ON t1.`PSSYSDBVFID` = t11.`PSSYSDBVFID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="FUNCCODE", expression="t1.`FUNCCODE`", showorder=-1), @DEDataQueryCodeExp(name="CALLCODE", expression="t1.`CALLCODE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSYSDBVFCODEID", expression="t1.`PSSYSDBVFCODEID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSDBVFCODENAME", expression="t1.`PSSYSDBVFCODENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBVFID", expression="t1.`PSSYSDBVFID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBVFNAME", expression="t11.`PSSYSDBVFNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CALLCODE, t1.CREATEDATE, t1.CREATEMAN, t1.DBTYPE, t1.MEMO, t1.PSSYSDBVFCODEID, t1.PSSYSDBVFCODENAME, t1.PSSYSDBVFID, t11.PSSYSDBVFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDBVFCODE t1  LEFT JOIN T_SRFPSSYSDBVF t11 ON t1.PSSYSDBVFID = t11.PSSYSDBVFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="FUNCCODE", expression="t1.FUNCCODE", showorder=-1), @DEDataQueryCodeExp(name="CALLCODE", expression="t1.CALLCODE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSYSDBVFCODEID", expression="t1.PSSYSDBVFCODEID", showorder=5), @DEDataQueryCodeExp(name="PSSYSDBVFCODENAME", expression="t1.PSSYSDBVFCODENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBVFID", expression="t1.PSSYSDBVFID", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBVFNAME", expression="t11.PSSYSDBVFNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSSysDBVFCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDBVFCodeDefaultDQModel() {
        this.initAnnotation(PSSysDBVFCodeDefaultDQModel.class);
    }
}

