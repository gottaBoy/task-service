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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbobjsql.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A0E6C6BF-28C1-4BBC-B04E-03E34966A053", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEDBOBJSQLID`, t1.`PSDEDBOBJSQLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDBOBJSQL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEDBOBJSQLID", expression="t1.`PSDEDBOBJSQLID`", showorder=2), @DEDataQueryCodeExp(name="PSDEDBOBJSQLNAME", expression="t1.`PSDEDBOBJSQLNAME`", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=5)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEDBOBJSQLID, t1.PSDEDBOBJSQLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDBOBJSQL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEDBOBJSQLID", expression="t1.PSDEDBOBJSQLID", showorder=2), @DEDataQueryCodeExp(name="PSDEDBOBJSQLNAME", expression="t1.PSDEDBOBJSQLNAME", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=5)}, conds={})})
public class PSDEDBObjSqlDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDBObjSqlDefaultDQModel() {
        this.initAnnotation(PSDEDBObjSqlDefaultDQModel.class);
    }
}

