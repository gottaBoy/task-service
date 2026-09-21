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
package net.ibizsys.pscore.srv.config.demodel.pssfcodefolder.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D7A5A477-7880-429A-8120-2777A0609531", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FOLDERNAME`, t1.`MEMO`, t1.`MODELLEVEL`, t1.`PRJFOLDER`, t1.`PSSFCODEFOLDERID`, t1.`PSSFCODEFOLDERNAME`, t1.`PSSFSTYLEID`, t11.`PSSFSTYLENAME`, t1.`PSSFSTYLEPRJID`, t21.`PSSFSTYLEPRJNAME`, t1.`PUBFLAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFCODEFOLDER` t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  LEFT JOIN T_SRFPSSFSTYLEPRJ t21 ON t1.PSSFSTYLEPRJID = t21.PSSFSTYLEPRJID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BOTTOMCODE", expression="t1.`BOTTOMCODE`", showorder=-1), @DEDataQueryCodeExp(name="HEADERCODE", expression="t1.`HEADERCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.`FOLDERNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="MODELLEVEL", expression="t1.`MODELLEVEL`", showorder=4), @DEDataQueryCodeExp(name="PRJFOLDER", expression="t1.`PRJFOLDER`", showorder=5), @DEDataQueryCodeExp(name="PSSFCODEFOLDERID", expression="t1.`PSSFCODEFOLDERID`", showorder=6), @DEDataQueryCodeExp(name="PSSFCODEFOLDERNAME", expression="t1.`PSSFCODEFOLDERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.`PSSFSTYLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPRJID", expression="t1.`PSSFSTYLEPRJID`", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPRJNAME", expression="t21.`PSSFSTYLEPRJNAME`", showorder=11), @DEDataQueryCodeExp(name="PUBFLAG", expression="t1.`PUBFLAG`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FOLDERNAME, t1.MEMO, t1.MODELLEVEL, t1.PRJFOLDER, t1.PSSFCODEFOLDERID, t1.PSSFCODEFOLDERNAME, t1.PSSFSTYLEID, t11.PSSFSTYLENAME, t1.PSSFSTYLEPRJID, t21.PSSFSTYLEPRJNAME, t1.PUBFLAG, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFCODEFOLDER t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  LEFT JOIN T_SRFPSSFSTYLEPRJ t21 ON t1.PSSFSTYLEPRJID = t21.PSSFSTYLEPRJID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BOTTOMCODE", expression="t1.BOTTOMCODE", showorder=-1), @DEDataQueryCodeExp(name="HEADERCODE", expression="t1.HEADERCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.FOLDERNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="MODELLEVEL", expression="t1.MODELLEVEL", showorder=4), @DEDataQueryCodeExp(name="PRJFOLDER", expression="t1.PRJFOLDER", showorder=5), @DEDataQueryCodeExp(name="PSSFCODEFOLDERID", expression="t1.PSSFCODEFOLDERID", showorder=6), @DEDataQueryCodeExp(name="PSSFCODEFOLDERNAME", expression="t1.PSSFCODEFOLDERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.PSSFSTYLENAME", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPRJID", expression="t1.PSSFSTYLEPRJID", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPRJNAME", expression="t21.PSSFSTYLEPRJNAME", showorder=11), @DEDataQueryCodeExp(name="PUBFLAG", expression="t1.PUBFLAG", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSSFCodeFolderDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFCodeFolderDefaultDQModel() {
        this.initAnnotation(PSSFCodeFolderDefaultDQModel.class);
    }
}

