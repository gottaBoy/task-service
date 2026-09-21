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
package net.ibizsys.pscore.srv.config.demodel.pspanellltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C19027C5-79EB-42BD-9A16-87E9862D4A21", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`ITEMOBJ`, t1.`MEMO`, t1.`PSPANELLLTYPEID`, t1.`PSPANELLLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPANELLLTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.`ITEMOBJ`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSPANELLLTYPEID", expression="t1.`PSPANELLLTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSPANELLLTYPENAME", expression="t1.`PSPANELLLTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.ITEMOBJ, t1.MEMO, t1.PSPANELLLTYPEID, t1.PSPANELLLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPANELLLTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="ITEMOBJ", expression="t1.ITEMOBJ", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSPANELLLTYPEID", expression="t1.PSPANELLLTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSPANELLLTYPENAME", expression="t1.PSPANELLLTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSPanelLLTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPanelLLTypeDefaultDQModel() {
        this.initAnnotation(PSPanelLLTypeDefaultDQModel.class);
    }
}

