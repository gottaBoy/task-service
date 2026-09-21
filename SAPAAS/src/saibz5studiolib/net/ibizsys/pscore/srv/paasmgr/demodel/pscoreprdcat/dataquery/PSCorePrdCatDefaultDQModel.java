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
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdcat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="08579762-34DB-4893-B902-BF55B9E8B4A4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`AVATARURL`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FULLNAME`, t1.`FULLPATH`, t1.`MEMO`, t1.`PATH`, t1.`PPSCOREPRDCATID`, t11.`PSCOREPRDCATNAME` AS `PPSCOREPRDCATNAME`, t1.`PSCOREPRDCATID`, t1.`PSCOREPRDCATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCOREPRDCAT` t1  LEFT JOIN `T_SRFPSCOREPRDCAT` t11 ON t1.`PPSCOREPRDCATID` = t11.`PSCOREPRDCATID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="AVATARURL", expression="t1.`AVATARURL`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="FULLNAME", expression="t1.`FULLNAME`", showorder=3), @DEDataQueryCodeExp(name="FULLPATH", expression="t1.`FULLPATH`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PATH", expression="t1.`PATH`", showorder=6), @DEDataQueryCodeExp(name="PPSCOREPRDCATID", expression="t1.`PPSCOREPRDCATID`", showorder=7), @DEDataQueryCodeExp(name="PPSCOREPRDCATNAME", expression="t11.`PSCOREPRDCATNAME`", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDCATID", expression="t1.`PSCOREPRDCATID`", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDCATNAME", expression="t1.`PSCOREPRDCATNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.AVATARURL, t1.CREATEDATE, t1.CREATEMAN, t1.FULLNAME, t1.FULLPATH, t1.MEMO, t1.PATH, t1.PPSCOREPRDCATID, t11.PSCOREPRDCATNAME AS PPSCOREPRDCATNAME, t1.PSCOREPRDCATID, t1.PSCOREPRDCATNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCOREPRDCAT t1  LEFT JOIN T_SRFPSCOREPRDCAT t11 ON t1.PPSCOREPRDCATID = t11.PSCOREPRDCATID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="AVATARURL", expression="t1.AVATARURL", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="FULLNAME", expression="t1.FULLNAME", showorder=3), @DEDataQueryCodeExp(name="FULLPATH", expression="t1.FULLPATH", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PATH", expression="t1.PATH", showorder=6), @DEDataQueryCodeExp(name="PPSCOREPRDCATID", expression="t1.PPSCOREPRDCATID", showorder=7), @DEDataQueryCodeExp(name="PPSCOREPRDCATNAME", expression="t11.PSCOREPRDCATNAME", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDCATID", expression="t1.PSCOREPRDCATID", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDCATNAME", expression="t1.PSCOREPRDCATNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSCorePrdCatDefaultDQModel
extends DEDataQueryModelBase {
    public PSCorePrdCatDefaultDQModel() {
        this.initAnnotation(PSCorePrdCatDefaultDQModel.class);
    }
}

