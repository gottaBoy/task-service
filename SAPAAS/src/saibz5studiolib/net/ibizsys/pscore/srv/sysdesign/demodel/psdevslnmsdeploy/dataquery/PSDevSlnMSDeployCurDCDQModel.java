/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdeploy.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8605CC46-8F12-47B8-AC74-810736189902", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEPLOYMDURL`, t1.`DEPLOYTAG`, t1.`DEPLOYTAG2`, t1.`MEMO`, t1.`PSDCMSPLATFORMID`, t11.`PSDCMSPLATFORMNAME`, t1.`PSDEVSLNID`, t1.`PSDEVSLNMSDEPAPISCNT`, t1.`PSDEVSLNMSDEPAPPSCNT`, t1.`PSDEVSLNMSDEPLOYID`, t1.`PSDEVSLNMSDEPLOYNAME`, t21.`PSDEVSLNNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS`, t1.`VALIDFLAG` FROM `T_SRFPSDEVSLNMSDEPLOY` t1  LEFT JOIN `T_SRFPSDCMSPLATFORM` t11 ON t1.`PSDCMSPLATFORMID` = t11.`PSDCMSPLATFORMID`  LEFT JOIN `T_SRFPSDEVSLN` t21 ON t1.`PSDEVSLNID` = t21.`PSDEVSLNID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEPLOYMDURL", expression="t1.`DEPLOYMDURL`", showorder=2), @DEDataQueryCodeExp(name="DEPLOYTAG", expression="t1.`DEPLOYTAG`", showorder=3), @DEDataQueryCodeExp(name="DEPLOYTAG2", expression="t1.`DEPLOYTAG2`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDCMSPLATFORMID", expression="t1.`PSDCMSPLATFORMID`", showorder=6), @DEDataQueryCodeExp(name="PSDCMSPLATFORMNAME", expression="t11.`PSDCMSPLATFORMNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPAPISCNT", expression="t1.`PSDEVSLNMSDEPAPISCNT`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPAPPSCNT", expression="t1.`PSDEVSLNMSDEPAPPSCNT`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPLOYID", expression="t1.`PSDEVSLNMSDEPLOYID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPLOYNAME", expression="t1.`PSDEVSLNMSDEPLOYNAME`", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t21.`PSDEVSLNNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t11.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCMSPLATFORM\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPLOYMDURL, t1.DEPLOYTAG, t1.DEPLOYTAG2, t1.MEMO, t1.PSDCMSPLATFORMID, t11.PSDCMSPLATFORMNAME, t1.PSDEVSLNID, t1.PSDEVSLNMSDEPAPISCNT, t1.PSDEVSLNMSDEPAPPSCNT, t1.PSDEVSLNMSDEPLOYID, t1.PSDEVSLNMSDEPLOYNAME, t21.PSDEVSLNNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS, t1.VALIDFLAG FROM T_SRFPSDEVSLNMSDEPLOY t1  LEFT JOIN T_SRFPSDCMSPLATFORM t11 ON t1.PSDCMSPLATFORMID = t11.PSDCMSPLATFORMID  LEFT JOIN T_SRFPSDEVSLN t21 ON t1.PSDEVSLNID = t21.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEPLOYMDURL", expression="t1.DEPLOYMDURL", showorder=2), @DEDataQueryCodeExp(name="DEPLOYTAG", expression="t1.DEPLOYTAG", showorder=3), @DEDataQueryCodeExp(name="DEPLOYTAG2", expression="t1.DEPLOYTAG2", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDCMSPLATFORMID", expression="t1.PSDCMSPLATFORMID", showorder=6), @DEDataQueryCodeExp(name="PSDCMSPLATFORMNAME", expression="t11.PSDCMSPLATFORMNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPAPISCNT", expression="t1.PSDEVSLNMSDEPAPISCNT", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPAPPSCNT", expression="t1.PSDEVSLNMSDEPAPPSCNT", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPLOYID", expression="t1.PSDEVSLNMSDEPLOYID", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNMSDEPLOYNAME", expression="t1.PSDEVSLNMSDEPLOYNAME", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t21.PSDEVSLNNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t11.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCMSPLATFORM\"}')} )")})})
public class PSDevSlnMSDeployCurDCDQModel
extends DEDataQueryModelBase {
    public PSDevSlnMSDeployCurDCDQModel() {
        this.initAnnotation(PSDevSlnMSDeployCurDCDQModel.class);
    }
}

