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
package net.ibizsys.pscore.srv.config.demodel.pssubsysdm.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="1B18CDD3-D672-4761-A45D-089A6010B6B6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSUBSYSDMID`, t1.`PSSUBSYSDMNAME`, t1.`PSSUBSYSID`, t1.`PSSUBSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBSYSDM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DATASQL", expression="t1.`DATASQL`", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL", expression="t1.`MODELSQL`", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL2", expression="t1.`MODELSQL2`", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL3", expression="t1.`MODELSQL3`", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL4", expression="t1.`MODELSQL4`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSUBSYSDMID", expression="t1.`PSSUBSYSDMID`", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSDMNAME", expression="t1.`PSSUBSYSDMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.`PSSUBSYSNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSUBSYSDMID, t1.PSSUBSYSDMNAME, t1.PSSUBSYSID, t1.PSSUBSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBSYSDM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DATASQL", expression="t1.DATASQL", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL", expression="t1.MODELSQL", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL2", expression="t1.MODELSQL2", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL3", expression="t1.MODELSQL3", showorder=-1), @DEDataQueryCodeExp(name="MODELSQL4", expression="t1.MODELSQL4", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSUBSYSDMID", expression="t1.PSSUBSYSDMID", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSDMNAME", expression="t1.PSSUBSYSDMNAME", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.PSSUBSYSNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSSubSysDMDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubSysDMDefaultDQModel() {
        this.initAnnotation(PSSubSysDMDefaultDQModel.class);
    }
}

