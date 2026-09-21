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
package net.ibizsys.pscore.srv.config.demodel.pspfpubobjparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8DD1281B-5AFB-4E32-A751-48902FD4E5AE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`OBJNAME`, t1.`PARAMTYPE`, t1.`PSPFPUBOBJID`, t1.`PSPFPUBOBJNAME`, t1.`PSPFPUBOBJPARAMID`, t1.`PSPFPUBOBJPARAMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFPUBOBJPARAM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.`OBJNAME`", showorder=4), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.`PARAMTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSPFPUBOBJID", expression="t1.`PSPFPUBOBJID`", showorder=6), @DEDataQueryCodeExp(name="PSPFPUBOBJNAME", expression="t1.`PSPFPUBOBJNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBOBJPARAMID", expression="t1.`PSPFPUBOBJPARAMID`", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBOBJPARAMNAME", expression="t1.`PSPFPUBOBJPARAMNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.OBJNAME, t1.PARAMTYPE, t1.PSPFPUBOBJID, t1.PSPFPUBOBJNAME, t1.PSPFPUBOBJPARAMID, t1.PSPFPUBOBJPARAMNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFPUBOBJPARAM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="OBJNAME", expression="t1.OBJNAME", showorder=4), @DEDataQueryCodeExp(name="PARAMTYPE", expression="t1.PARAMTYPE", showorder=5), @DEDataQueryCodeExp(name="PSPFPUBOBJID", expression="t1.PSPFPUBOBJID", showorder=6), @DEDataQueryCodeExp(name="PSPFPUBOBJNAME", expression="t1.PSPFPUBOBJNAME", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBOBJPARAMID", expression="t1.PSPFPUBOBJPARAMID", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBOBJPARAMNAME", expression="t1.PSPFPUBOBJPARAMNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSPFPubObjParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPubObjParamDefaultDQModel() {
        this.initAnnotation(PSPFPubObjParamDefaultDQModel.class);
    }
}

