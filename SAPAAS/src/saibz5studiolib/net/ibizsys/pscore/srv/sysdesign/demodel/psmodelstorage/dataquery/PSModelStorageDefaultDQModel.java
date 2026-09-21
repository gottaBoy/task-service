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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelstorage.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EDA4226D-7127-4154-B5C3-F766185701A3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSMODELID`, t1.`PSMODELNAME`, t1.`PSMODELSTORAGEID`, t1.`PSMODELSTORAGENAME`, t1.`PSMODELTYPE`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`STORAGETYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELSTORAGE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=2), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=3), @DEDataQueryCodeExp(name="PSMODELSTORAGEID", expression="t1.`PSMODELSTORAGEID`", showorder=4), @DEDataQueryCodeExp(name="PSMODELSTORAGENAME", expression="t1.`PSMODELSTORAGENAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.`PSMODELTYPE`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=8), @DEDataQueryCodeExp(name="STORAGETYPE", expression="t1.`STORAGETYPE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSMODELID, t1.PSMODELNAME, t1.PSMODELSTORAGEID, t1.PSMODELSTORAGENAME, t1.PSMODELTYPE, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.STORAGETYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELSTORAGE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=2), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=3), @DEDataQueryCodeExp(name="PSMODELSTORAGEID", expression="t1.PSMODELSTORAGEID", showorder=4), @DEDataQueryCodeExp(name="PSMODELSTORAGENAME", expression="t1.PSMODELSTORAGENAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.PSMODELTYPE", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=8), @DEDataQueryCodeExp(name="STORAGETYPE", expression="t1.STORAGETYPE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSModelStorageDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelStorageDefaultDQModel() {
        this.initAnnotation(PSModelStorageDefaultDQModel.class);
    }
}

