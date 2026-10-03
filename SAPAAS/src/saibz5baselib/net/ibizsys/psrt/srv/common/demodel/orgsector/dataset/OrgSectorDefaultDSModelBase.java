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

@DEDataSet(id="63061bfdafbbd213fc0ce66d3f26419e",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="8DB0771C-B1C2-44FA-89B0-FB20C693258E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgSectorDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgSectorDefaultDSModelBase.class);
    }




}