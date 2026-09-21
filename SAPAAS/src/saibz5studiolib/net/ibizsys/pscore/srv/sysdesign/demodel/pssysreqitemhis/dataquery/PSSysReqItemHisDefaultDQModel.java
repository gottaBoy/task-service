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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqitemhis.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="08ADEF16-20FA-4F02-88F9-1F9AB1BDB3CB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMTAG`, t1.`ITEMTAG2`, t1.`PSSYSREQITEMHISID`, t1.`PSSYSREQITEMHISNAME`, t1.`PSSYSREQITEMID`, t11.`PSSYSREQITEMNAME`, t1.`TAGS`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VER` FROM `T_SRFPSSYSREQITEMHIS` t1  LEFT JOIN `T_SRFPSSYSREQITEM` t11 ON t1.`PSSYSREQITEMID` = t11.`PSSYSREQITEMID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="REQCONTENT", expression="t1.`REQCONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ITEMTAG", expression="t1.`ITEMTAG`", showorder=2), @DEDataQueryCodeExp(name="ITEMTAG2", expression="t1.`ITEMTAG2`", showorder=3), @DEDataQueryCodeExp(name="PSSYSREQITEMHISID", expression="t1.`PSSYSREQITEMHISID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSREQITEMHISNAME", expression="t1.`PSSYSREQITEMHISNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.`PSSYSREQITEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t11.`PSSYSREQITEMNAME`", showorder=7), @DEDataQueryCodeExp(name="TAGS", expression="t1.`TAGS`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VER", expression="t1.`VER`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ITEMTAG, t1.ITEMTAG2, t1.PSSYSREQITEMHISID, t1.PSSYSREQITEMHISNAME, t1.PSSYSREQITEMID, t11.PSSYSREQITEMNAME, t1.TAGS, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VER FROM T_SRFPSSYSREQITEMHIS t1  LEFT JOIN T_SRFPSSYSREQITEM t11 ON t1.PSSYSREQITEMID = t11.PSSYSREQITEMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="REQCONTENT", expression="t1.REQCONTENT", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ITEMTAG", expression="t1.ITEMTAG", showorder=2), @DEDataQueryCodeExp(name="ITEMTAG2", expression="t1.ITEMTAG2", showorder=3), @DEDataQueryCodeExp(name="PSSYSREQITEMHISID", expression="t1.PSSYSREQITEMHISID", showorder=4), @DEDataQueryCodeExp(name="PSSYSREQITEMHISNAME", expression="t1.PSSYSREQITEMHISNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.PSSYSREQITEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t11.PSSYSREQITEMNAME", showorder=7), @DEDataQueryCodeExp(name="TAGS", expression="t1.TAGS", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VER", expression="t1.VER", showorder=16)}, conds={})})
public class PSSysReqItemHisDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysReqItemHisDefaultDQModel() {
        this.initAnnotation(PSSysReqItemHisDefaultDQModel.class);
    }
}

