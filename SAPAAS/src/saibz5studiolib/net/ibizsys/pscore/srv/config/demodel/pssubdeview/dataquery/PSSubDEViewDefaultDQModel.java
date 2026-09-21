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
package net.ibizsys.pscore.srv.config.demodel.pssubdeview.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BEC0367F-C871-492F-ACBF-D39FAF2A030E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVIEWBASEID`, t1.`PSSUBDEID`, t1.`PSSUBDENAME`, t1.`PSSUBDEVIEWID`, t1.`PSSUBDEVIEWNAME`, t1.`PSSUBSYSID`, t1.`PSSUBSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VIEWTYPE` FROM `T_SRFPSSUBDEVIEW` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=4), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.`PSSUBDEID`", showorder=5), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.`PSSUBDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSUBDEVIEWID", expression="t1.`PSSUBDEVIEWID`", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEVIEWNAME", expression="t1.`PSSUBDEVIEWNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.`PSSUBSYSNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VIEWTYPE", expression="t1.`VIEWTYPE`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVIEWBASEID, t1.PSSUBDEID, t1.PSSUBDENAME, t1.PSSUBDEVIEWID, t1.PSSUBDEVIEWNAME, t1.PSSUBSYSID, t1.PSSUBSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VIEWTYPE FROM T_SRFPSSUBDEVIEW t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=4), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.PSSUBDEID", showorder=5), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.PSSUBDENAME", showorder=6), @DEDataQueryCodeExp(name="PSSUBDEVIEWID", expression="t1.PSSUBDEVIEWID", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEVIEWNAME", expression="t1.PSSUBDEVIEWNAME", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.PSSUBSYSNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VIEWTYPE", expression="t1.VIEWTYPE", showorder=13)}, conds={})})
public class PSSubDEViewDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubDEViewDefaultDQModel() {
        this.initAnnotation(PSSubDEViewDefaultDQModel.class);
    }
}

