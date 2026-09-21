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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbfunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6F1AB5A2-34CC-4ACB-BD1C-9BF31B7497D8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCDBFUNCID`, t1.`PSDCDBFUNCNAME`, t1.`PSDCDBINSTID`, t1.`PSDCDBINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCDBFUNC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="SQL", expression="t1.`SQL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCDBFUNCID", expression="t1.`PSDCDBFUNCID`", showorder=3), @DEDataQueryCodeExp(name="PSDCDBFUNCNAME", expression="t1.`PSDCDBFUNCNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.`PSDCDBINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t1.`PSDCDBINSTNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCDBFUNCID, t1.PSDCDBFUNCNAME, t1.PSDCDBINSTID, t1.PSDCDBINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCDBFUNC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="SQL", expression="t1.SQL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCDBFUNCID", expression="t1.PSDCDBFUNCID", showorder=3), @DEDataQueryCodeExp(name="PSDCDBFUNCNAME", expression="t1.PSDCDBFUNCNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.PSDCDBINSTID", showorder=5), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t1.PSDCDBINSTNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDCDBFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCDBFuncDefaultDQModel() {
        this.initAnnotation(PSDCDBFuncDefaultDQModel.class);
    }
}

