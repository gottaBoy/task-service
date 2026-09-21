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
package net.ibizsys.pscore.srv.def.demodel.psformdetailtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="892DB2A7-8B80-4DE3-BE6F-F812AA37F898", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DETAILOBJ`, t1.`MEMO`, t1.`PFDTYPE`, t1.`PSFORMDETAILTYPEID`, t1.`PSFORMDETAILTYPENAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSFORMDETAILTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DETAILOBJ", expression="t1.`DETAILOBJ`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PFDTYPE", expression="t1.`PFDTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSFORMDETAILTYPEID", expression="t1.`PSFORMDETAILTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSFORMDETAILTYPENAME", expression="t1.`PSFORMDETAILTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DETAILOBJ, t1.MEMO, t1.PFDTYPE, t1.PSFORMDETAILTYPEID, t1.PSFORMDETAILTYPENAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSFORMDETAILTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DETAILOBJ", expression="t1.DETAILOBJ", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PFDTYPE", expression="t1.PFDTYPE", showorder=4), @DEDataQueryCodeExp(name="PSFORMDETAILTYPEID", expression="t1.PSFORMDETAILTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSFORMDETAILTYPENAME", expression="t1.PSFORMDETAILTYPENAME", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSFormDetailTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSFormDetailTypeDefaultDQModel() {
        this.initAnnotation(PSFormDetailTypeDefaultDQModel.class);
    }
}

