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
package net.ibizsys.pscore.srv.config.demodel.psdepsystype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="035FE1A6-0EC7-460C-92A2-6B65F530479F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSYSTYPEID`, t1.`PSDEPSYSTYPENAME`, t1.`SYSAPPOBJ`, t1.`SYSVEROBJ`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEPSYSTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSYSTYPEID", expression="t1.`PSDEPSYSTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSYSTYPENAME", expression="t1.`PSDEPSYSTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="SYSAPPOBJ", expression="t1.`SYSAPPOBJ`", showorder=5), @DEDataQueryCodeExp(name="SYSVEROBJ", expression="t1.`SYSVEROBJ`", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSYSTYPEID, t1.PSDEPSYSTYPENAME, t1.SYSAPPOBJ, t1.SYSVEROBJ, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEPSYSTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSYSTYPEID", expression="t1.PSDEPSYSTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSYSTYPENAME", expression="t1.PSDEPSYSTYPENAME", showorder=4), @DEDataQueryCodeExp(name="SYSAPPOBJ", expression="t1.SYSAPPOBJ", showorder=5), @DEDataQueryCodeExp(name="SYSVEROBJ", expression="t1.SYSVEROBJ", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSDepSysTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSysTypeDefaultDQModel() {
        this.initAnnotation(PSDepSysTypeDefaultDQModel.class);
    }
}

