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
package net.ibizsys.pscore.srv.config.demodel.pspredefinedtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8C24B430-AA49-4EA5-81DF-D3C19F089040", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PREDEFINEDTYPE`, t1.`PSPFPLUGINID`, t1.`PSPFPLUGINNAME`, t1.`PSPREDEFINEDTYPEID`, t1.`PSPREDEFINEDTYPENAME`, t1.`PSSFPLUGINID`, t1.`PSSFPLUGINNAME`, t1.`TYPETAG`, t1.`TYPETAG2`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USAGEMODE`, t1.`VALIDFLAG` FROM `T_SRFPSPREDEFINEDTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.`PREDEFINEDTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.`PSPFPLUGINID`", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t1.`PSPFPLUGINNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPREDEFINEDTYPEID", expression="t1.`PSPREDEFINEDTYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSPREDEFINEDTYPENAME", expression="t1.`PSPREDEFINEDTYPENAME`", showorder=8), @DEDataQueryCodeExp(name="PSSFPLUGINID", expression="t1.`PSSFPLUGINID`", showorder=9), @DEDataQueryCodeExp(name="PSSFPLUGINNAME", expression="t1.`PSSFPLUGINNAME`", showorder=10), @DEDataQueryCodeExp(name="TYPETAG", expression="t1.`TYPETAG`", showorder=11), @DEDataQueryCodeExp(name="TYPETAG2", expression="t1.`TYPETAG2`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USAGEMODE", expression="t1.`USAGEMODE`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PREDEFINEDTYPE, t1.PSPFPLUGINID, t1.PSPFPLUGINNAME, t1.PSPREDEFINEDTYPEID, t1.PSPREDEFINEDTYPENAME, t1.PSSFPLUGINID, t1.PSSFPLUGINNAME, t1.TYPETAG, t1.TYPETAG2, t1.UPDATEDATE, t1.UPDATEMAN, t1.USAGEMODE, t1.VALIDFLAG FROM T_SRFPSPREDEFINEDTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PREDEFINEDTYPE", expression="t1.PREDEFINEDTYPE", showorder=4), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.PSPFPLUGINID", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t1.PSPFPLUGINNAME", showorder=6), @DEDataQueryCodeExp(name="PSPREDEFINEDTYPEID", expression="t1.PSPREDEFINEDTYPEID", showorder=7), @DEDataQueryCodeExp(name="PSPREDEFINEDTYPENAME", expression="t1.PSPREDEFINEDTYPENAME", showorder=8), @DEDataQueryCodeExp(name="PSSFPLUGINID", expression="t1.PSSFPLUGINID", showorder=9), @DEDataQueryCodeExp(name="PSSFPLUGINNAME", expression="t1.PSSFPLUGINNAME", showorder=10), @DEDataQueryCodeExp(name="TYPETAG", expression="t1.TYPETAG", showorder=11), @DEDataQueryCodeExp(name="TYPETAG2", expression="t1.TYPETAG2", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USAGEMODE", expression="t1.USAGEMODE", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSPredefinedTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPredefinedTypeDefaultDQModel() {
        this.initAnnotation(PSPredefinedTypeDefaultDQModel.class);
    }
}

