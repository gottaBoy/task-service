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
package net.ibizsys.pscore.srv.config.demodel.psdcbktype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="93995F56-3545-4803-90F7-FD78891B82A9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLE`, t1.`MEMO`, t1.`PSDCBKTYPEID`, t1.`PSDCBKTYPENAME`, t1.`TASKOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USEROBOTFLAG` FROM `T_SRFPSDCBKTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDCBKTYPEID", expression="t1.`PSDCBKTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSDCBKTYPENAME", expression="t1.`PSDCBKTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="TASKOBJ", expression="t1.`TASKOBJ`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="USEROBOTFLAG", expression="t1.`USEROBOTFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.PSDCBKTYPEID, t1.PSDCBKTYPENAME, t1.TASKOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.USEROBOTFLAG FROM T_SRFPSDCBKTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDCBKTYPEID", expression="t1.PSDCBKTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSDCBKTYPENAME", expression="t1.PSDCBKTYPENAME", showorder=5), @DEDataQueryCodeExp(name="TASKOBJ", expression="t1.TASKOBJ", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="USEROBOTFLAG", expression="t1.USEROBOTFLAG", showorder=9)}, conds={})})
public class PSDCBKTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCBKTypeDefaultDQModel() {
        this.initAnnotation(PSDCBKTypeDefaultDQModel.class);
    }
}

