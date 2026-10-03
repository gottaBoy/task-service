/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.org.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="FF4BB81C-BE41-4810-8E96-E88FFDDE1F38",name="AllRoot",queries= {
    @DEDataSetQuery(queryid="2F63AE0F-9A22-46CB-A46F-6DC2BA62B9E3",queryname="AllRoot")
})

/**
 *  实体数据集合[全部根组织]模型基类
 */
public abstract class OrgAllRootDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgAllRootDSModelBase() {
        super();

        this.initAnnotation(OrgAllRootDSModelBase.class);
    }




}