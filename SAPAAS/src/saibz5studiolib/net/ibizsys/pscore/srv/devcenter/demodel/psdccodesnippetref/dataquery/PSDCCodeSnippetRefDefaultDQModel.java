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
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippetref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="82F1386F-F5FB-4140-A7AC-CEC81125F399", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCCODESNIPPETID`, t11.`PSDCCODESNIPPETNAME`, t1.`PSDCCODESNIPPETREFID`, t1.`PSDCCODESNIPPETREFNAME`, t1.`REFPSDCCODESNIPPETID`, t21.`PSDCCODESNIPPETNAME` AS `REFPSDCCODESNIPPETNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCCODESNIPPETREF` t1  LEFT JOIN T_SRFPSDCCODESNIPPET t11 ON t1.PSDCCODESNIPPETID = t11.PSDCCODESNIPPETID  LEFT JOIN T_SRFPSDCCODESNIPPET t21 ON t1.REFPSDCCODESNIPPETID = t21.PSDCCODESNIPPETID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCCODESNIPPETID", expression="t1.`PSDCCODESNIPPETID`", showorder=3), @DEDataQueryCodeExp(name="PSDCCODESNIPPETNAME", expression="t11.`PSDCCODESNIPPETNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCCODESNIPPETREFID", expression="t1.`PSDCCODESNIPPETREFID`", showorder=5), @DEDataQueryCodeExp(name="PSDCCODESNIPPETREFNAME", expression="t1.`PSDCCODESNIPPETREFNAME`", showorder=6), @DEDataQueryCodeExp(name="REFPSDCCODESNIPPETID", expression="t1.`REFPSDCCODESNIPPETID`", showorder=7), @DEDataQueryCodeExp(name="REFPSDCCODESNIPPETNAME", expression="t21.`PSDCCODESNIPPETNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCCODESNIPPETID, t11.PSDCCODESNIPPETNAME, t1.PSDCCODESNIPPETREFID, t1.PSDCCODESNIPPETREFNAME, t1.REFPSDCCODESNIPPETID, t21.PSDCCODESNIPPETNAME AS REFPSDCCODESNIPPETNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCCODESNIPPETREF t1  LEFT JOIN T_SRFPSDCCODESNIPPET t11 ON t1.PSDCCODESNIPPETID = t11.PSDCCODESNIPPETID  LEFT JOIN T_SRFPSDCCODESNIPPET t21 ON t1.REFPSDCCODESNIPPETID = t21.PSDCCODESNIPPETID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCCODESNIPPETID", expression="t1.PSDCCODESNIPPETID", showorder=3), @DEDataQueryCodeExp(name="PSDCCODESNIPPETNAME", expression="t11.PSDCCODESNIPPETNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCCODESNIPPETREFID", expression="t1.PSDCCODESNIPPETREFID", showorder=5), @DEDataQueryCodeExp(name="PSDCCODESNIPPETREFNAME", expression="t1.PSDCCODESNIPPETREFNAME", showorder=6), @DEDataQueryCodeExp(name="REFPSDCCODESNIPPETID", expression="t1.REFPSDCCODESNIPPETID", showorder=7), @DEDataQueryCodeExp(name="REFPSDCCODESNIPPETNAME", expression="t21.PSDCCODESNIPPETNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDCCodeSnippetRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCCodeSnippetRefDefaultDQModel() {
        this.initAnnotation(PSDCCodeSnippetRefDefaultDQModel.class);
    }
}

