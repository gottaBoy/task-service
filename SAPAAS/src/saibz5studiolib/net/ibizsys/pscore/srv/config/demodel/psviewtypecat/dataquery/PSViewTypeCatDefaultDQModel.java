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
package net.ibizsys.pscore.srv.config.demodel.psviewtypecat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A7857261-6408-432C-B983-C0B2FEB25464", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CATCODE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PPSVIEWTYPECATID`, t11.`PSVIEWTYPECATNAME` AS `PPSVIEWTYPECATNAME`, t1.`PSVIEWTYPECATID`, t1.`PSVIEWTYPECATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSVIEWTYPECAT` t1  LEFT JOIN `T_SRFPSVIEWTYPECAT` t11 ON t1.`PPSVIEWTYPECATID` = t11.`PSVIEWTYPECATID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CATCODE", expression="t1.`CATCODE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PPSVIEWTYPECATID", expression="t1.`PPSVIEWTYPECATID`", showorder=6), @DEDataQueryCodeExp(name="PPSVIEWTYPECATNAME", expression="t11.`PSVIEWTYPECATNAME`", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPECATID", expression="t1.`PSVIEWTYPECATID`", showorder=8), @DEDataQueryCodeExp(name="PSVIEWTYPECATNAME", expression="t1.`PSVIEWTYPECATNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CATCODE, t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.MEMO, t1.ORDERVALUE, t1.PPSVIEWTYPECATID, t11.PSVIEWTYPECATNAME AS PPSVIEWTYPECATNAME, t1.PSVIEWTYPECATID, t1.PSVIEWTYPECATNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSVIEWTYPECAT t1  LEFT JOIN T_SRFPSVIEWTYPECAT t11 ON t1.PPSVIEWTYPECATID = t11.PSVIEWTYPECATID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CATCODE", expression="t1.CATCODE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PPSVIEWTYPECATID", expression="t1.PPSVIEWTYPECATID", showorder=6), @DEDataQueryCodeExp(name="PPSVIEWTYPECATNAME", expression="t11.PSVIEWTYPECATNAME", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPECATID", expression="t1.PSVIEWTYPECATID", showorder=8), @DEDataQueryCodeExp(name="PSVIEWTYPECATNAME", expression="t1.PSVIEWTYPECATNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={})})
public class PSViewTypeCatDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewTypeCatDefaultDQModel() {
        this.initAnnotation(PSViewTypeCatDefaultDQModel.class);
    }
}

