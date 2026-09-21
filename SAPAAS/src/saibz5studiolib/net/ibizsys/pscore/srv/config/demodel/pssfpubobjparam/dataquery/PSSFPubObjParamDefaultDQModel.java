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
package net.ibizsys.pscore.srv.config.demodel.pssfpubobjparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E5E097CA-35B1-4B03-9570-01FA1C8C7771", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`OBJNAME`, t1.`PARAMTYPE`, t1.`PSSFPUBOBJID`, t1.`PSSFPUBOBJNAME`, t1.`PSSFPUBOBJPARAMID`, t1.`PSSFPUBOBJPARAMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFPUBOBJPARAM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.`OBJNAME`", showorder=4), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.`PARAMTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSSFPUBOBJID", expression="t1.`PSSFPUBOBJID`", showorder=6), @DEDataQueryCodeExp(name="PSSFPUBOBJNAME", expression="t1.`PSSFPUBOBJNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFPUBOBJPARAMID", expression="t1.`PSSFPUBOBJPARAMID`", showorder=8), @DEDataQueryCodeExp(name="PSSFPUBOBJPARAMNAME", expression="t1.`PSSFPUBOBJPARAMNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.OBJNAME, t1.PARAMTYPE, t1.PSSFPUBOBJID, t1.PSSFPUBOBJNAME, t1.PSSFPUBOBJPARAMID, t1.PSSFPUBOBJPARAMNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFPUBOBJPARAM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.OBJNAME", showorder=4), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.PARAMTYPE", showorder=5), @DEDataQueryCodeExp(name="PSSFPUBOBJID", expression="t1.PSSFPUBOBJID", showorder=6), @DEDataQueryCodeExp(name="PSSFPUBOBJNAME", expression="t1.PSSFPUBOBJNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFPUBOBJPARAMID", expression="t1.PSSFPUBOBJPARAMID", showorder=8), @DEDataQueryCodeExp(name="PSSFPUBOBJPARAMNAME", expression="t1.PSSFPUBOBJPARAMNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSSFPubObjParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFPubObjParamDefaultDQModel() {
        this.initAnnotation(PSSFPubObjParamDefaultDQModel.class);
    }
}

