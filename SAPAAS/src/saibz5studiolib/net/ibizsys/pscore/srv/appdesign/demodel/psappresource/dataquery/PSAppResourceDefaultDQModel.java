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
package net.ibizsys.pscore.srv.appdesign.demodel.psappresource.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3258D882-5150-4636-A25C-FB75FDAF592F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENTPSLANRESID`, t1.`CONTENTPSLANRESNAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPRESOURCEID`, t1.`PSAPPRESOURCENAME`, t1.`PSSYSAPPID`, t11.`PSSYSAPPNAME`, t1.`RESOURCETYPE`, t1.`RESTAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSAPPRESOURCE` t1  LEFT JOIN `T_SRFPSSYSAPP` t11 ON t1.`PSSYSAPPID` = t11.`PSSYSAPPID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CONTENTPSLANRESID", expression="t1.`CONTENTPSLANRESID`", showorder=0), @DEDataQueryCodeExp(name="CONTENTPSLANRESNAME", expression="t1.`CONTENTPSLANRESNAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSAPPRESOURCEID", expression="t1.`PSAPPRESOURCEID`", showorder=5), @DEDataQueryCodeExp(name="PSAPPRESOURCENAME", expression="t1.`PSAPPRESOURCENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.`PSSYSAPPNAME`", showorder=8), @DEDataQueryCodeExp(name="RESOURCETYPE", expression="t1.`RESOURCETYPE`", showorder=9), @DEDataQueryCodeExp(name="RESTAG", expression="t1.`RESTAG`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENTPSLANRESID, t1.CONTENTPSLANRESNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPRESOURCEID, t1.PSAPPRESOURCENAME, t1.PSSYSAPPID, t11.PSSYSAPPNAME, t1.RESOURCETYPE, t1.RESTAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSAPPRESOURCE t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="CONTENTPSLANRESID", expression="t1.CONTENTPSLANRESID", showorder=0), @DEDataQueryCodeExp(name="CONTENTPSLANRESNAME", expression="t1.CONTENTPSLANRESNAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSAPPRESOURCEID", expression="t1.PSAPPRESOURCEID", showorder=5), @DEDataQueryCodeExp(name="PSAPPRESOURCENAME", expression="t1.PSAPPRESOURCENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.PSSYSAPPNAME", showorder=8), @DEDataQueryCodeExp(name="RESOURCETYPE", expression="t1.RESOURCETYPE", showorder=9), @DEDataQueryCodeExp(name="RESTAG", expression="t1.RESTAG", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSAppResourceDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppResourceDefaultDQModel() {
        this.initAnnotation(PSAppResourceDefaultDQModel.class);
    }
}

