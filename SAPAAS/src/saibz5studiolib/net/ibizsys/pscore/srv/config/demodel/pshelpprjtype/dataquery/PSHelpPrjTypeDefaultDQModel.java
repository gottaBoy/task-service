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
package net.ibizsys.pscore.srv.config.demodel.pshelpprjtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5C9477A4-FFD7-42C5-8834-413E4202FF12", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PRJOBJ`, t1.`PSHELPPRJTEMPLID`, t11.`PSHELPPRJTEMPLNAME`, t1.`PSHELPPRJTYPEID`, t1.`PSHELPPRJTYPENAME`, t1.`PUBOBJ`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPPRJTYPE` t1  LEFT JOIN T_SRFPSHELPPRJTEMPL t11 ON t1.PSHELPPRJTEMPLID = t11.PSHELPPRJTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRJOBJ", expression="t1.`PRJOBJ`", showorder=3), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLID", expression="t1.`PSHELPPRJTEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLNAME", expression="t11.`PSHELPPRJTEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPPRJTYPEID", expression="t1.`PSHELPPRJTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPPRJTYPENAME", expression="t1.`PSHELPPRJTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=8), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PRJOBJ, t1.PSHELPPRJTEMPLID, t11.PSHELPPRJTEMPLNAME, t1.PSHELPPRJTYPEID, t1.PSHELPPRJTYPENAME, t1.PUBOBJ, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPPRJTYPE t1  LEFT JOIN T_SRFPSHELPPRJTEMPL t11 ON t1.PSHELPPRJTEMPLID = t11.PSHELPPRJTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRJOBJ", expression="t1.PRJOBJ", showorder=3), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLID", expression="t1.PSHELPPRJTEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSHELPPRJTEMPLNAME", expression="t11.PSHELPPRJTEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPPRJTYPEID", expression="t1.PSHELPPRJTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSHELPPRJTYPENAME", expression="t1.PSHELPPRJTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=8), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSHelpPrjTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSHelpPrjTypeDefaultDQModel() {
        this.initAnnotation(PSHelpPrjTypeDefaultDQModel.class);
    }
}

