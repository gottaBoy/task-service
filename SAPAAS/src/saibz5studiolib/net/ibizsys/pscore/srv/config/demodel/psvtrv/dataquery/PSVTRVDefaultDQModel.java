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
package net.ibizsys.pscore.srv.config.demodel.psvtrv.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E804D95E-7CE4-48D2-9606-FDB46FA0FE81", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`DEFVIEWTYPE`, t1.`DYNADEFVIEWTYPE`, t1.`ENABLEDYNATOOL`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSVIEWTYPEID`, t11.`PSVIEWTYPENAME`, t1.`PSVTRVID`, t1.`PSVTRVNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSVTRV` t1  LEFT JOIN `T_SRFPSVIEWTYPE` t11 ON t1.`PSVIEWTYPEID` = t11.`PSVIEWTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="DEFVIEWTYPE", expression="t1.`DEFVIEWTYPE`", showorder=3), @DEDataQueryCodeExp(name="DYNADEFVIEWTYPE", expression="t1.`DYNADEFVIEWTYPE`", showorder=4), @DEDataQueryCodeExp(name="ENABLEDYNATOOL", expression="t1.`ENABLEDYNATOOL`", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.`PSVIEWTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t11.`PSVIEWTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="PSVTRVID", expression="t1.`PSVTRVID`", showorder=10), @DEDataQueryCodeExp(name="PSVTRVNAME", expression="t1.`PSVTRVNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=16), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=17), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.DEFVIEWTYPE, t1.DYNADEFVIEWTYPE, t1.ENABLEDYNATOOL, t1.LOGICNAME, t1.MEMO, t1.PSVIEWTYPEID, t11.PSVIEWTYPENAME, t1.PSVTRVID, t1.PSVTRVNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSVTRV t1  LEFT JOIN T_SRFPSVIEWTYPE t11 ON t1.PSVIEWTYPEID = t11.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="DEFVIEWTYPE", expression="t1.DEFVIEWTYPE", showorder=3), @DEDataQueryCodeExp(name="DYNADEFVIEWTYPE", expression="t1.DYNADEFVIEWTYPE", showorder=4), @DEDataQueryCodeExp(name="ENABLEDYNATOOL", expression="t1.ENABLEDYNATOOL", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.PSVIEWTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t11.PSVIEWTYPENAME", showorder=9), @DEDataQueryCodeExp(name="PSVTRVID", expression="t1.PSVTRVID", showorder=10), @DEDataQueryCodeExp(name="PSVTRVNAME", expression="t1.PSVTRVNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=16), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=17), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSVTRVDefaultDQModel
extends DEDataQueryModelBase {
    public PSVTRVDefaultDQModel() {
        this.initAnnotation(PSVTRVDefaultDQModel.class);
    }
}

