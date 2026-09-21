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
package net.ibizsys.pscore.srv.config.demodel.pssysmodelver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3AE93D4E-C345-4179-872B-A2C15D3AFB7F", name="View", viewlevel=0)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACTIVEFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DATASQL`, t1.`DBTYPE`, t1.`MEMO`, t1.`MODELSQL`, t1.`MODELSQL2`, t1.`MODELSQL3`, t1.`MODELSQL4`, t1.`MODELVER`, t1.`PSSYSMODELVERID`, t1.`PSSYSMODELVERNAME`, t1.`SYSTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSMODELVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIVEFLAG", expression="t1.`ACTIVEFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DATASQL", expression="t1.`DATASQL`", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="MODELSQL", expression="t1.`MODELSQL`", showorder=6), @DEDataQueryCodeExp(name="MODELSQL2", expression="t1.`MODELSQL2`", showorder=7), @DEDataQueryCodeExp(name="MODELSQL3", expression="t1.`MODELSQL3`", showorder=8), @DEDataQueryCodeExp(name="MODELSQL4", expression="t1.`MODELSQL4`", showorder=9), @DEDataQueryCodeExp(name="MODELVER", expression="t1.`MODELVER`", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELVERID", expression="t1.`PSSYSMODELVERID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELVERNAME", expression="t1.`PSSYSMODELVERNAME`", showorder=12), @DEDataQueryCodeExp(name="SYSTYPE", expression="t1.`SYSTYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACTIVEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.DATASQL, t1.DBTYPE, t1.MEMO, t1.MODELSQL, t1.MODELSQL2, t1.MODELSQL3, t1.MODELSQL4, t1.MODELVER, t1.PSSYSMODELVERID, t1.PSSYSMODELVERNAME, t1.SYSTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSMODELVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIVEFLAG", expression="t1.ACTIVEFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DATASQL", expression="t1.DATASQL", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="MODELSQL", expression="t1.MODELSQL", showorder=6), @DEDataQueryCodeExp(name="MODELSQL2", expression="t1.MODELSQL2", showorder=7), @DEDataQueryCodeExp(name="MODELSQL3", expression="t1.MODELSQL3", showorder=8), @DEDataQueryCodeExp(name="MODELSQL4", expression="t1.MODELSQL4", showorder=9), @DEDataQueryCodeExp(name="MODELVER", expression="t1.MODELVER", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELVERID", expression="t1.PSSYSMODELVERID", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELVERNAME", expression="t1.PSSYSMODELVERNAME", showorder=12), @DEDataQueryCodeExp(name="SYSTYPE", expression="t1.SYSTYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSSysModelVerViewDQModel
extends DEDataQueryModelBase {
    public PSSysModelVerViewDQModel() {
        this.initAnnotation(PSSysModelVerViewDQModel.class);
    }
}

