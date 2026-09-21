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
package net.ibizsys.pscore.srv.config.demodel.psvtcatdetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="97611B7C-B721-48B5-AE90-4D3D60029246", name="Valid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSVIEWTYPECATID`, t11.`PSVIEWTYPECATNAME`, t1.`PSVIEWTYPEID`, t21.`PSVIEWTYPENAME`, t1.`PSVTCATDETAILID`, t1.`PSVTCATDETAILNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSVTCATDETAIL` t1  LEFT JOIN `T_SRFPSVIEWTYPECAT` t11 ON t1.`PSVIEWTYPECATID` = t11.`PSVIEWTYPECATID`  LEFT JOIN `T_SRFPSVIEWTYPE` t21 ON t1.`PSVIEWTYPEID` = t21.`PSVIEWTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSVIEWTYPECATID", expression="t1.`PSVIEWTYPECATID`", showorder=2), @DEDataQueryCodeExp(name="PSVIEWTYPECATNAME", expression="t11.`PSVIEWTYPECATNAME`", showorder=3), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.`PSVIEWTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t21.`PSVIEWTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSVTCATDETAILID", expression="t1.`PSVTCATDETAILID`", showorder=6), @DEDataQueryCodeExp(name="PSVTCATDETAILNAME", expression="t1.`PSVTCATDETAILNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={@DEDataQueryCodeCond(condition="( ( t1.`VALIDFLAG` IS NULL  OR  t1.`VALIDFLAG` = 1 ) )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSVIEWTYPECATID, t11.PSVIEWTYPECATNAME, t1.PSVIEWTYPEID, t21.PSVIEWTYPENAME, t1.PSVTCATDETAILID, t1.PSVTCATDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSVTCATDETAIL t1  LEFT JOIN T_SRFPSVIEWTYPECAT t11 ON t1.PSVIEWTYPECATID = t11.PSVIEWTYPECATID  LEFT JOIN T_SRFPSVIEWTYPE t21 ON t1.PSVIEWTYPEID = t21.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSVIEWTYPECATID", expression="t1.PSVIEWTYPECATID", showorder=2), @DEDataQueryCodeExp(name="PSVIEWTYPECATNAME", expression="t11.PSVIEWTYPECATNAME", showorder=3), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.PSVIEWTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t21.PSVIEWTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSVTCATDETAILID", expression="t1.PSVTCATDETAILID", showorder=6), @DEDataQueryCodeExp(name="PSVTCATDETAILNAME", expression="t1.PSVTCATDETAILNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={@DEDataQueryCodeCond(condition="( ( t1.VALIDFLAG IS NULL  OR  t1.VALIDFLAG = 1 ) )")})})
public class PSVTCatDetailValidDQModel
extends DEDataQueryModelBase {
    public PSVTCatDetailValidDQModel() {
        this.initAnnotation(PSVTCatDetailValidDQModel.class);
    }
}

