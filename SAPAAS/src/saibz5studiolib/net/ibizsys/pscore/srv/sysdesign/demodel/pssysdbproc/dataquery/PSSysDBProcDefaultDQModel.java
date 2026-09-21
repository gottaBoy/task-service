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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbproc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FFB82D84-19BE-4783-B093-4FE48ACCB2B4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CODENAME2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PROCDESC`, t1.`PSSYSDBPROCID`, t1.`PSSYSDBPROCNAME`, t1.`PSSYSDBSCHEMEID`, t11.`PSSYSDBSCHEMENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSDBPROC` t1  LEFT JOIN `T_SRFPSSYSDBSCHEME` t11 ON t1.`PSSYSDBSCHEMEID` = t11.`PSSYSDBSCHEMEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CODENAME2", expression="t1.`CODENAME2`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PROCDESC", expression="t1.`PROCDESC`", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBPROCID", expression="t1.`PSSYSDBPROCID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBPROCNAME", expression="t1.`PSSYSDBPROCNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSDBSCHEMEID", expression="t1.`PSSYSDBSCHEMEID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBSCHEMENAME", expression="t11.`PSSYSDBSCHEMENAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CODENAME2, t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PROCDESC, t1.PSSYSDBPROCID, t1.PSSYSDBPROCNAME, t1.PSSYSDBSCHEMEID, t11.PSSYSDBSCHEMENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSDBPROC t1  LEFT JOIN T_SRFPSSYSDBSCHEME t11 ON t1.PSSYSDBSCHEMEID = t11.PSSYSDBSCHEMEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CODENAME2", expression="t1.CODENAME2", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PROCDESC", expression="t1.PROCDESC", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBPROCID", expression="t1.PSSYSDBPROCID", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBPROCNAME", expression="t1.PSSYSDBPROCNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSDBSCHEMEID", expression="t1.PSSYSDBSCHEMEID", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBSCHEMENAME", expression="t11.PSSYSDBSCHEMENAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17)}, conds={})})
public class PSSysDBProcDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDBProcDefaultDQModel() {
        this.initAnnotation(PSSysDBProcDefaultDQModel.class);
    }
}

