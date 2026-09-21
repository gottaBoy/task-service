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
package net.ibizsys.pscore.srv.dedesign.demodel.psdefieldimp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7B4C85F6-A9CE-4E86-83EE-1901F2723BF7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLOWEMPTY`, t1.`IMPORTKEY`, t1.`IMPORTORDER`, t1.`IMPORTTAG`, t1.`LOGICNAME`, t1.`PHYSICALFIELD`, t1.`PSDATATYPEID`, t1.`PSDATATYPENAME`, t1.`PSDEFIELDID`, t1.`PSDEFIELDNAME`, t1.`PSDEID` FROM `T_SRFPSDEFIELD` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.`ALLOWEMPTY`", showorder=0), @DEDataQueryCodeExp(name="IMPORTKEY", expression="t1.`IMPORTKEY`", showorder=1), @DEDataQueryCodeExp(name="IMPORTORDER", expression="t1.`IMPORTORDER`", showorder=2), @DEDataQueryCodeExp(name="IMPORTTAG", expression="t1.`IMPORTTAG`", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=4), @DEDataQueryCodeExp(name="PHYSICALFIELD", expression="t1.`PHYSICALFIELD`", showorder=5), @DEDataQueryCodeExp(name="PSDATATYPEID", expression="t1.`PSDATATYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSDATATYPENAME", expression="t1.`PSDATATYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEFIELDID", expression="t1.`PSDEFIELDID`", showorder=8), @DEDataQueryCodeExp(name="PSDEFIELDNAME", expression="t1.`PSDEFIELDNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLOWEMPTY, t1.IMPORTKEY, t1.IMPORTORDER, t1.IMPORTTAG, t1.LOGICNAME, t1.PHYSICALFIELD, t1.PSDATATYPEID, t1.PSDATATYPENAME, t1.PSDEFIELDID, t1.PSDEFIELDNAME, t1.PSDEID FROM T_SRFPSDEFIELD t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLOWEMPTY", expression="t1.ALLOWEMPTY", showorder=0), @DEDataQueryCodeExp(name="IMPORTKEY", expression="t1.IMPORTKEY", showorder=1), @DEDataQueryCodeExp(name="IMPORTORDER", expression="t1.IMPORTORDER", showorder=2), @DEDataQueryCodeExp(name="IMPORTTAG", expression="t1.IMPORTTAG", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=4), @DEDataQueryCodeExp(name="PHYSICALFIELD", expression="t1.PHYSICALFIELD", showorder=5), @DEDataQueryCodeExp(name="PSDATATYPEID", expression="t1.PSDATATYPEID", showorder=6), @DEDataQueryCodeExp(name="PSDATATYPENAME", expression="t1.PSDATATYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSDEFIELDID", expression="t1.PSDEFIELDID", showorder=8), @DEDataQueryCodeExp(name="PSDEFIELDNAME", expression="t1.PSDEFIELDNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=10)}, conds={})})
public class PSDEFieldImpDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFieldImpDefaultDQModel() {
        this.initAnnotation(PSDEFieldImpDefaultDQModel.class);
    }
}

