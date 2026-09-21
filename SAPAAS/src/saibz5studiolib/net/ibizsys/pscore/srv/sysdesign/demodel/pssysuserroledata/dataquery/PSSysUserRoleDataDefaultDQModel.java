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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysuserroledata.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8F5A3CAF-8965-4BB1-B93D-A360BC222EAB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSDEUSERROLEID`, t11.`PSDEUSERROLENAME`, t1.`PSSYSOPPRIVID`, t21.`PSSYSOPPRIVNAME`, t1.`PSSYSUSERROLEDATAID`, t1.`PSSYSUSERROLEDATANAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSUSERROLEDATA` t1  LEFT JOIN `T_SRFPSDEUSERROLE` t11 ON t1.`PSDEUSERROLEID` = t11.`PSDEUSERROLEID`  LEFT JOIN `T_SRFPSSYSOPPRIV` t21 ON t1.`PSSYSOPPRIVID` = t21.`PSSYSOPPRIVID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=3), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEUSERROLEID", expression="t1.`PSDEUSERROLEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEUSERROLENAME", expression="t11.`PSDEUSERROLENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSOPPRIVID", expression="t1.`PSSYSOPPRIVID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSOPPRIVNAME", expression="t21.`PSSYSOPPRIVNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSUSERROLEDATAID", expression="t1.`PSSYSUSERROLEDATAID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSUSERROLEDATANAME", expression="t1.`PSSYSUSERROLEDATANAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEID, t1.PSDENAME, t1.PSDEUSERROLEID, t11.PSDEUSERROLENAME, t1.PSSYSOPPRIVID, t21.PSSYSOPPRIVNAME, t1.PSSYSUSERROLEDATAID, t1.PSSYSUSERROLEDATANAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSUSERROLEDATA t1  LEFT JOIN T_SRFPSDEUSERROLE t11 ON t1.PSDEUSERROLEID = t11.PSDEUSERROLEID  LEFT JOIN T_SRFPSSYSOPPRIV t21 ON t1.PSSYSOPPRIVID = t21.PSSYSOPPRIVID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=3), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=4), @DEDataQueryCodeExp(name="PSDEUSERROLEID", expression="t1.PSDEUSERROLEID", showorder=5), @DEDataQueryCodeExp(name="PSDEUSERROLENAME", expression="t11.PSDEUSERROLENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSOPPRIVID", expression="t1.PSSYSOPPRIVID", showorder=7), @DEDataQueryCodeExp(name="PSSYSOPPRIVNAME", expression="t21.PSSYSOPPRIVNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSUSERROLEDATAID", expression="t1.PSSYSUSERROLEDATAID", showorder=9), @DEDataQueryCodeExp(name="PSSYSUSERROLEDATANAME", expression="t1.PSSYSUSERROLEDATANAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSSysUserRoleDataDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysUserRoleDataDefaultDQModel() {
        this.initAnnotation(PSSysUserRoleDataDefaultDQModel.class);
    }
}

