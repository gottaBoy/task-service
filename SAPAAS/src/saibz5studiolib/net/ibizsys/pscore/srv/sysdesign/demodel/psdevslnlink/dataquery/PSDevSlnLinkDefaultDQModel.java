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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnlink.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CDB8ABCD-9B1F-47B5-9614-BD316F170B57", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LINK`, t1.`LINKMDURL`, t1.`LINKTYPE`, t1.`MEMO`, t1.`PSDEVSLNID`, t1.`PSDEVSLNLINKID`, t1.`PSDEVSLNLINKNAME`, t11.`PSDEVSLNNAME`, t1.`PSDEVSLNSYSID`, t21.`PSDEVSLNSYSNAME`, t1.`PSDEVSLNTEMPLID`, t31.`PSDEVSLNTEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERDATA`, t1.`USERDATA2` FROM `T_SRFPSDEVSLNLINK` t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  LEFT JOIN T_SRFPSDEVSLNTEMPL t31 ON t1.PSDEVSLNTEMPLID = t31.PSDEVSLNTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LINK", expression="t1.`LINK`", showorder=2), @DEDataQueryCodeExp(name="LINKMDURL", expression="t1.`LINKMDURL`", showorder=3), @DEDataQueryCodeExp(name="LINKTYPE", expression="t1.`LINKTYPE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNLINKID", expression="t1.`PSDEVSLNLINKID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNLINKNAME", expression="t1.`PSDEVSLNLINKNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.`PSDEVSLNSYSNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNTEMPLID", expression="t1.`PSDEVSLNTEMPLID`", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNTEMPLNAME", expression="t31.`PSDEVSLNTEMPLNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="USERDATA", expression="t1.`USERDATA`", showorder=16), @DEDataQueryCodeExp(name="USERDATA2", expression="t1.`USERDATA2`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LINK, t1.LINKMDURL, t1.LINKTYPE, t1.MEMO, t1.PSDEVSLNID, t1.PSDEVSLNLINKID, t1.PSDEVSLNLINKNAME, t11.PSDEVSLNNAME, t1.PSDEVSLNSYSID, t21.PSDEVSLNSYSNAME, t1.PSDEVSLNTEMPLID, t31.PSDEVSLNTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2 FROM T_SRFPSDEVSLNLINK t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  LEFT JOIN T_SRFPSDEVSLNTEMPL t31 ON t1.PSDEVSLNTEMPLID = t31.PSDEVSLNTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LINK", expression="t1.LINK", showorder=2), @DEDataQueryCodeExp(name="LINKMDURL", expression="t1.LINKMDURL", showorder=3), @DEDataQueryCodeExp(name="LINKTYPE", expression="t1.LINKTYPE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNLINKID", expression="t1.PSDEVSLNLINKID", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNLINKNAME", expression="t1.PSDEVSLNLINKNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.PSDEVSLNSYSNAME", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNTEMPLID", expression="t1.PSDEVSLNTEMPLID", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNTEMPLNAME", expression="t31.PSDEVSLNTEMPLNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="USERDATA", expression="t1.USERDATA", showorder=16), @DEDataQueryCodeExp(name="USERDATA2", expression="t1.USERDATA2", showorder=17)}, conds={})})
public class PSDevSlnLinkDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnLinkDefaultDQModel() {
        this.initAnnotation(PSDevSlnLinkDefaultDQModel.class);
    }
}

