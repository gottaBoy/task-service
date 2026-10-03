/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="443ECF59-C902-4714-9FF5-5AB4055C691B",name="CurOrg",queries= {
    @DEDataSetQuery(queryid="04008F5E-55CA-4B7D-84AF-FA4CC7357A05",queryname="CurOrg")
})

/**
 *  实体数据集合[当前组织]模型基类
 */
public abstract class OrgUserCurOrgDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserCurOrgDSModelBase() {
        super();

        this.initAnnotation(OrgUserCurOrgDSModelBase.class);
    }




}