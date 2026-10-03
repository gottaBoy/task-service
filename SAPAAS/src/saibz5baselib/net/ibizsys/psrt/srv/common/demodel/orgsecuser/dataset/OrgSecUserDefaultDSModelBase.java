/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecuser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="a29184750c477cf3910fc2179179dccc",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="CC3A8987-87A1-4A7E-AAEA-285BB224ADDA",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgSecUserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSecUserDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgSecUserDefaultDSModelBase.class);
    }




}