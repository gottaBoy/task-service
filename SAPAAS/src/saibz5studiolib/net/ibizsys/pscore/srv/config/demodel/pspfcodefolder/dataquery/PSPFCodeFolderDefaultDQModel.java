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
package net.ibizsys.pscore.srv.config.demodel.pspfcodefolder.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="55654B25-CC43-4D41-ACFA-DD034EA5622B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FOLDERNAME`, t1.`MEMO`, t1.`PRJFOLDER`, t1.`PRJTYPE`, t1.`PSPFCODEFOLDERID`, t1.`PSPFCODEFOLDERNAME`, t1.`PSPFID`, t11.`PSPFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFCODEFOLDER` t1  LEFT JOIN `T_SRFPSPF` t11 ON t1.`PSPFID` = t11.`PSPFID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.`FOLDERNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PRJFOLDER", expression="t1.`PRJFOLDER`", showorder=4), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.`PRJTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSPFCODEFOLDERID", expression="t1.`PSPFCODEFOLDERID`", showorder=6), @DEDataQueryCodeExp(name="PSPFCODEFOLDERNAME", expression="t1.`PSPFCODEFOLDERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.`PSPFNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FOLDERNAME, t1.MEMO, t1.PRJFOLDER, t1.PRJTYPE, t1.PSPFCODEFOLDERID, t1.PSPFCODEFOLDERNAME, t1.PSPFID, t11.PSPFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFCODEFOLDER t1  LEFT JOIN T_SRFPSPF t11 ON t1.PSPFID = t11.PSPFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.FOLDERNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PRJFOLDER", expression="t1.PRJFOLDER", showorder=4), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.PRJTYPE", showorder=5), @DEDataQueryCodeExp(name="PSPFCODEFOLDERID", expression="t1.PSPFCODEFOLDERID", showorder=6), @DEDataQueryCodeExp(name="PSPFCODEFOLDERNAME", expression="t1.PSPFCODEFOLDERNAME", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.PSPFNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSPFCodeFolderDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFCodeFolderDefaultDQModel() {
        this.initAnnotation(PSPFCodeFolderDefaultDQModel.class);
    }
}

