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
package net.ibizsys.pscore.srv.config.demodel.psbdtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="05D73C92-80FE-4EFB-B000-8D0752E1A857", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEDQENGOBJ`, t1.`DEDQPUBOBJ`, t1.`DEDSPUBOBJ`, t1.`HIBDIALECT`, t1.`ICONPATH`, t1.`INSTALLPATH`, t1.`JDBCDIALECT`, t1.`JDBCDRIVERNAME`, t1.`MEMO`, t1.`PSBDTYPEID`, t1.`PSBDTYPENAME`, t1.`SQLQUERY`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSBDTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEDQENGOBJ", expression="t1.`DEDQENGOBJ`", showorder=2), @DEDataQueryCodeExp(name="DEDQPUBOBJ", expression="t1.`DEDQPUBOBJ`", showorder=3), @DEDataQueryCodeExp(name="DEDSPUBOBJ", expression="t1.`DEDSPUBOBJ`", showorder=4), @DEDataQueryCodeExp(name="HIBDIALECT", expression="t1.`HIBDIALECT`", showorder=5), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=6), @DEDataQueryCodeExp(name="INSTALLPATH", expression="t1.`INSTALLPATH`", showorder=7), @DEDataQueryCodeExp(name="JDBCDIALECT", expression="t1.`JDBCDIALECT`", showorder=8), @DEDataQueryCodeExp(name="JDBCDRIVERNAME", expression="t1.`JDBCDRIVERNAME`", showorder=9), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=10), @DEDataQueryCodeExp(name="PSBDTYPEID", expression="t1.`PSBDTYPEID`", showorder=11), @DEDataQueryCodeExp(name="PSBDTYPENAME", expression="t1.`PSBDTYPENAME`", showorder=12), @DEDataQueryCodeExp(name="SQLQUERY", expression="t1.`SQLQUERY`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEDQENGOBJ, t1.DEDQPUBOBJ, t1.DEDSPUBOBJ, t1.HIBDIALECT, t1.ICONPATH, t1.INSTALLPATH, t1.JDBCDIALECT, t1.JDBCDRIVERNAME, t1.MEMO, t1.PSBDTYPEID, t1.PSBDTYPENAME, t1.SQLQUERY, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSBDTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEDQENGOBJ", expression="t1.DEDQENGOBJ", showorder=2), @DEDataQueryCodeExp(name="DEDQPUBOBJ", expression="t1.DEDQPUBOBJ", showorder=3), @DEDataQueryCodeExp(name="DEDSPUBOBJ", expression="t1.DEDSPUBOBJ", showorder=4), @DEDataQueryCodeExp(name="HIBDIALECT", expression="t1.HIBDIALECT", showorder=5), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=6), @DEDataQueryCodeExp(name="INSTALLPATH", expression="t1.INSTALLPATH", showorder=7), @DEDataQueryCodeExp(name="JDBCDIALECT", expression="t1.JDBCDIALECT", showorder=8), @DEDataQueryCodeExp(name="JDBCDRIVERNAME", expression="t1.JDBCDRIVERNAME", showorder=9), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=10), @DEDataQueryCodeExp(name="PSBDTYPEID", expression="t1.PSBDTYPEID", showorder=11), @DEDataQueryCodeExp(name="PSBDTYPENAME", expression="t1.PSBDTYPENAME", showorder=12), @DEDataQueryCodeExp(name="SQLQUERY", expression="t1.SQLQUERY", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSBDTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSBDTypeDefaultDQModel() {
        this.initAnnotation(PSBDTypeDefaultDQModel.class);
    }
}

