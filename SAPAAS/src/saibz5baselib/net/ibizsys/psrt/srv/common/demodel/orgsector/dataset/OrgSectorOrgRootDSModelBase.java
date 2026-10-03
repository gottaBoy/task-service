/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsector.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="ED36937A-7FC9-469A-AF20-FF9478EEBD04",name="OrgRoot",queries= {
    @DEDataSetQuery(queryid="6ACE493E-3CE2-4285-AC2D-D94775248FF4",queryname="OrgRoot")
})

/**
 *  实体数据集合[组织根部门]模型基类
 */
public abstract class OrgSectorOrgRootDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorOrgRootDSModelBase() {
        super();

        this.initAnnotation(OrgSectorOrgRootDSModelBase.class);
    }




}