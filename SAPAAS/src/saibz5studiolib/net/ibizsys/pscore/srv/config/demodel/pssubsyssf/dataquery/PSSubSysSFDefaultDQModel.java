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
package net.ibizsys.pscore.srv.config.demodel.pssubsyssf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="966E7427-81C6-4370-B044-A72EEA5D76B6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BASECLSPKGCODENAME`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PKGCODENAME`, t1.`PSSFID`, t11.`PSSFNAME`, t1.`PSSFSTYLEID`, t1.`PSSFSTYLENAME`, t1.`PSSUBSYSID`, t21.`PSSUBSYSNAME`, t1.`PSSUBSYSSFID`, t1.`PSSUBSYSSFNAME`, t1.`PSSYSSFPUBID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBSYSSF` t1  LEFT JOIN `T_SRFPSSF` t11 ON t1.`PSSFID` = t11.`PSSFID`  LEFT JOIN `T_SRFPSSUBSYS` t21 ON t1.`PSSUBSYSID` = t21.`PSSUBSYSID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPKGCODENAME", expression="t1.`BASECLSPKGCODENAME`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PKGCODENAME", expression="t1.`PKGCODENAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.`PSSFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.`PSSFSTYLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=10), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.`PSSUBSYSNAME`", showorder=11), @DEDataQueryCodeExp(name="PSSUBSYSSFID", expression="t1.`PSSUBSYSSFID`", showorder=12), @DEDataQueryCodeExp(name="PSSUBSYSSFNAME", expression="t1.`PSSUBSYSSFNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.`PSSYSSFPUBID`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BASECLSPKGCODENAME, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PKGCODENAME, t1.PSSFID, t11.PSSFNAME, t1.PSSFSTYLEID, t1.PSSFSTYLENAME, t1.PSSUBSYSID, t21.PSSUBSYSNAME, t1.PSSUBSYSSFID, t1.PSSUBSYSSFNAME, t1.PSSYSSFPUBID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBSYSSF t1  LEFT JOIN T_SRFPSSF t11 ON t1.PSSFID = t11.PSSFID  LEFT JOIN T_SRFPSSUBSYS t21 ON t1.PSSUBSYSID = t21.PSSUBSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPKGCODENAME", expression="t1.BASECLSPKGCODENAME", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PKGCODENAME", expression="t1.PKGCODENAME", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.PSSFNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.PSSFSTYLENAME", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=10), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.PSSUBSYSNAME", showorder=11), @DEDataQueryCodeExp(name="PSSUBSYSSFID", expression="t1.PSSUBSYSSFID", showorder=12), @DEDataQueryCodeExp(name="PSSUBSYSSFNAME", expression="t1.PSSUBSYSSFNAME", showorder=13), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.PSSYSSFPUBID", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={})})
public class PSSubSysSFDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubSysSFDefaultDQModel() {
        this.initAnnotation(PSSubSysSFDefaultDQModel.class);
    }
}

