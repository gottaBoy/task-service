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
package net.ibizsys.pscore.srv.config.demodel.psdeactiontype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="99D561FC-8EDF-460D-A716-1C99D0041846", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`MEMO`, t1.`PROCESSOBJ`, t1.`PSDEACTIONTYPEID`, t1.`PSDEACTIONTYPENAME`, t1.`TYPEPARAM`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEACTIONTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PROCESSOBJ", expression="t1.`PROCESSOBJ`", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONTYPEID", expression="t1.`PSDEACTIONTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEACTIONTYPENAME", expression="t1.`PSDEACTIONTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.`TYPEPARAM`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.MEMO, t1.PROCESSOBJ, t1.PSDEACTIONTYPEID, t1.PSDEACTIONTYPENAME, t1.TYPEPARAM, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEACTIONTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PROCESSOBJ", expression="t1.PROCESSOBJ", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONTYPEID", expression="t1.PSDEACTIONTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSDEACTIONTYPENAME", expression="t1.PSDEACTIONTYPENAME", showorder=6), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.TYPEPARAM", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDEActionTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEActionTypeDefaultDQModel() {
        this.initAnnotation(PSDEActionTypeDefaultDQModel.class);
    }
}

