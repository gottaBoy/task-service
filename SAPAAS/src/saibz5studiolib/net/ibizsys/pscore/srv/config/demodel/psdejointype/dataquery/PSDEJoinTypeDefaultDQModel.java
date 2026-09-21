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
package net.ibizsys.pscore.srv.config.demodel.psdejointype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="53CB6031-7C17-4CC5-8441-C06EBEE6EB51", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`MAINFLAG`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEJOINTYPEID`, t1.`PSDEJOINTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEJOINTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="MAINFLAG", expression="t1.`MAINFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PSDEJOINTYPEID", expression="t1.`PSDEJOINTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSDEJOINTYPENAME", expression="t1.`PSDEJOINTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.MAINFLAG, t1.MEMO, t1.ORDERVALUE, t1.PSDEJOINTYPEID, t1.PSDEJOINTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEJOINTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="MAINFLAG", expression="t1.MAINFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PSDEJOINTYPEID", expression="t1.PSDEJOINTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSDEJOINTYPENAME", expression="t1.PSDEJOINTYPENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSDEJoinTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEJoinTypeDefaultDQModel() {
        this.initAnnotation(PSDEJoinTypeDefaultDQModel.class);
    }
}

