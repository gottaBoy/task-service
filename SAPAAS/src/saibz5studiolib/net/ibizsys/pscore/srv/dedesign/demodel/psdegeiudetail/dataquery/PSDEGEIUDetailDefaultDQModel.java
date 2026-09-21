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
package net.ibizsys.pscore.srv.dedesign.demodel.psdegeiudetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2202CEBE-C10A-4E97-8F55-D8CE6853EE01", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEGEIUDETAILID`, t1.`PSDEGEIUDETAILNAME`, t1.`PSDEGEIUPDATEID`, t11.`PSDEGEIUPDATENAME`, t1.`PSDEGRIDCOLID`, t21.`PSDEGRIDCOLNAME`, t1.`PSDEGRIDID`, t31.`PSDEGRIDNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEGEIUDETAIL` t1  LEFT JOIN T_SRFPSDEGEIUPDATE t11 ON t1.PSDEGEIUPDATEID = t11.PSDEGEIUPDATEID  LEFT JOIN T_SRFPSDEGRIDCOL t21 ON t1.PSDEGRIDCOLID = t21.PSDEGRIDCOLID  LEFT JOIN T_SRFPSDEGRID t31 ON t1.PSDEGRIDID = t31.PSDEGRIDID  ", querycodetemp="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEGEIUDETAILID`, t1.`PSDEGEIUDETAILNAME`, t1.`PSDEGEIUPDATEID`, t11.`PSDEGEIUPDATENAME`, t1.`PSDEGRIDCOLID`, t21.`PSDEGRIDCOLNAME`, t1.`PSDEGRIDID`, t31.`PSDEGRIDNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEGEIUDETAIL_TMP` t1  LEFT JOIN T_SRFPSDEGEIUPDATE_TMP t11 ON t1.PSDEGEIUPDATEID = t11.PSDEGEIUPDATEID  LEFT JOIN T_SRFPSDEGRIDCOL_TMP t21 ON t1.PSDEGRIDCOLID = t21.PSDEGRIDCOLID  LEFT JOIN T_SRFPSDEGRID_TMP t31 ON t1.PSDEGRIDID = t31.PSDEGRIDID  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEGEIUDETAILID", expression="t1.`PSDEGEIUDETAILID`", showorder=2), @DEDataQueryCodeExp(name="PSDEGEIUDETAILNAME", expression="t1.`PSDEGEIUDETAILNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEGEIUPDATEID", expression="t1.`PSDEGEIUPDATEID`", showorder=4), @DEDataQueryCodeExp(name="PSDEGEIUPDATENAME", expression="t11.`PSDEGEIUPDATENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEGRIDCOLID", expression="t1.`PSDEGRIDCOLID`", showorder=6), @DEDataQueryCodeExp(name="PSDEGRIDCOLNAME", expression="t21.`PSDEGRIDCOLNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEGRIDID", expression="t1.`PSDEGRIDID`", showorder=8), @DEDataQueryCodeExp(name="PSDEGRIDNAME", expression="t31.`PSDEGRIDNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEGEIUDETAILID, t1.PSDEGEIUDETAILNAME, t1.PSDEGEIUPDATEID, t11.PSDEGEIUPDATENAME, t1.PSDEGRIDCOLID, t21.PSDEGRIDCOLNAME, t1.PSDEGRIDID, t31.PSDEGRIDNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEGEIUDETAIL t1  LEFT JOIN T_SRFPSDEGEIUPDATE t11 ON t1.PSDEGEIUPDATEID = t11.PSDEGEIUPDATEID  LEFT JOIN T_SRFPSDEGRIDCOL t21 ON t1.PSDEGRIDCOLID = t21.PSDEGRIDCOLID  LEFT JOIN T_SRFPSDEGRID t31 ON t1.PSDEGRIDID = t31.PSDEGRIDID  ", querycodetemp="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEGEIUDETAILID, t1.PSDEGEIUDETAILNAME, t1.PSDEGEIUPDATEID, t11.PSDEGEIUPDATENAME, t1.PSDEGRIDCOLID, t21.PSDEGRIDCOLNAME, t1.PSDEGRIDID, t31.PSDEGRIDNAME, t1.UPDATEDATE, t1.UPDATEMAN,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEGEIUDETAIL_TMP t1  LEFT JOIN T_SRFPSDEGEIUPDATE_TMP t11 ON t1.PSDEGEIUPDATEID = t11.PSDEGEIUPDATEID  LEFT JOIN T_SRFPSDEGRIDCOL_TMP t21 ON t1.PSDEGRIDCOLID = t21.PSDEGRIDCOLID  LEFT JOIN T_SRFPSDEGRID_TMP t31 ON t1.PSDEGRIDID = t31.PSDEGRIDID  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEGEIUDETAILID", expression="t1.PSDEGEIUDETAILID", showorder=2), @DEDataQueryCodeExp(name="PSDEGEIUDETAILNAME", expression="t1.PSDEGEIUDETAILNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEGEIUPDATEID", expression="t1.PSDEGEIUPDATEID", showorder=4), @DEDataQueryCodeExp(name="PSDEGEIUPDATENAME", expression="t11.PSDEGEIUPDATENAME", showorder=5), @DEDataQueryCodeExp(name="PSDEGRIDCOLID", expression="t1.PSDEGRIDCOLID", showorder=6), @DEDataQueryCodeExp(name="PSDEGRIDCOLNAME", expression="t21.PSDEGRIDCOLNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEGRIDID", expression="t1.PSDEGRIDID", showorder=8), @DEDataQueryCodeExp(name="PSDEGRIDNAME", expression="t31.PSDEGRIDNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDEGEIUDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEGEIUDetailDefaultDQModel() {
        this.initAnnotation(PSDEGEIUDetailDefaultDQModel.class);
    }
}

