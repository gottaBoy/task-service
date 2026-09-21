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
package net.ibizsys.pscore.srv.config.demodel.pspfplugintype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="1E76FC51-35E1-40EE-8DB1-4276099E00A5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEMOURL`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PLUGINOBJ`, t1.`PSPFPLUGINTYPEID`, t1.`PSPFPLUGINTYPENAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFPLUGINTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEMOURL", expression="t1.`DEMOURL`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PLUGINOBJ", expression="t1.`PLUGINOBJ`", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINTYPEID", expression="t1.`PSPFPLUGINTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINTYPENAME", expression="t1.`PSPFPLUGINTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEMOURL, t1.MEMO, t1.ORDERVALUE, t1.PLUGINOBJ, t1.PSPFPLUGINTYPEID, t1.PSPFPLUGINTYPENAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFPLUGINTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEMOURL", expression="t1.DEMOURL", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PLUGINOBJ", expression="t1.PLUGINOBJ", showorder=5), @DEDataQueryCodeExp(name="PSPFPLUGINTYPEID", expression="t1.PSPFPLUGINTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSPFPLUGINTYPENAME", expression="t1.PSPFPLUGINTYPENAME", showorder=7), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSPFPluginTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPluginTypeDefaultDQModel() {
        this.initAnnotation(PSPFPluginTypeDefaultDQModel.class);
    }
}

