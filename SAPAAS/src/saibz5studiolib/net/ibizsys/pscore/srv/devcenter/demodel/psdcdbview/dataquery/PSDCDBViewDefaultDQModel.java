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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbview.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7E6B5B03-B07D-46BD-BDEE-73075B35F92B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCDBINSTID`, t1.`PSDCDBINSTNAME`, t1.`PSDCDBVIEWID`, t1.`PSDCDBVIEWNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCDBVIEW` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="SQL", expression="t1.`SQL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.`PSDCDBINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t1.`PSDCDBINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCDBVIEWID", expression="t1.`PSDCDBVIEWID`", showorder=5), @DEDataQueryCodeExp(name="PSDCDBVIEWNAME", expression="t1.`PSDCDBVIEWNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCDBINSTID, t1.PSDCDBINSTNAME, t1.PSDCDBVIEWID, t1.PSDCDBVIEWNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCDBVIEW t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="SQL", expression="t1.SQL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCDBINSTID", expression="t1.PSDCDBINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDCDBINSTNAME", expression="t1.PSDCDBINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCDBVIEWID", expression="t1.PSDCDBVIEWID", showorder=5), @DEDataQueryCodeExp(name="PSDCDBVIEWNAME", expression="t1.PSDCDBVIEWNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDCDBViewDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCDBViewDefaultDQModel() {
        this.initAnnotation(PSDCDBViewDefaultDQModel.class);
    }
}

