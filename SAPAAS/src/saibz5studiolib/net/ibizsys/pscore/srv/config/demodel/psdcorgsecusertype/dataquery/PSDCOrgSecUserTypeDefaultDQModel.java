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
package net.ibizsys.pscore.srv.config.demodel.psdcorgsecusertype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C46E0B41-B7EB-4FDC-9EF1-B1BAE70982CE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCORGSECUSERTYPEID`, t1.`PSDCORGSECUSERTYPENAME`, t1.`REALID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERDATA`, t1.`USERDATA2`, t1.`VALIDFLAG` FROM `T_SRFPSDCORGSECUSERTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCORGSECUSERTYPEID", expression="t1.`PSDCORGSECUSERTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSDCORGSECUSERTYPENAME", expression="t1.`PSDCORGSECUSERTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="REALID", expression="t1.`REALID`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="USERDATA", expression="t1.`USERDATA`", showorder=8), @DEDataQueryCodeExp(name="USERDATA2", expression="t1.`USERDATA2`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCORGSECUSERTYPEID, t1.PSDCORGSECUSERTYPENAME, t1.REALID, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.VALIDFLAG FROM T_SRFPSDCORGSECUSERTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCORGSECUSERTYPEID", expression="t1.PSDCORGSECUSERTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSDCORGSECUSERTYPENAME", expression="t1.PSDCORGSECUSERTYPENAME", showorder=4), @DEDataQueryCodeExp(name="REALID", expression="t1.REALID", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="USERDATA", expression="t1.USERDATA", showorder=8), @DEDataQueryCodeExp(name="USERDATA2", expression="t1.USERDATA2", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSDCOrgSecUserTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCOrgSecUserTypeDefaultDQModel() {
        this.initAnnotation(PSDCOrgSecUserTypeDefaultDQModel.class);
    }
}

