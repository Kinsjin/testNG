package com.test.suit.discover;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.testdata.SummaryInfoAll;
import com.test.testdata.SummaryInfoDmaAll;
import com.test.util.OperateProperties;

import junit.framework.Assert;

public class InfoSummaryTests {
	public static SummaryInfoDmaAll dmaALL;
	@BeforeTest
	public void declare(){
		//new SummaryInfoAll();
		//SummaryInfoAll.setInfoAll();
		dmaALL=new SummaryInfoDmaAll();
		dmaALL.setInfoDmaAll();
		System.out.println("У����Ϣ����ҳ��---------------------------");
	}
	@Test(enabled = false)
  	public void rmmeterCount() {
		//�ȶԿ��˱�����
	  Assert.assertEquals(SummaryInfoAll.rm_count, SummaryInfoAll.listAll.get(0));
	}
	@Test(enabled = false)
	public void rbmeterCount() {
		//�ȶԵ�λ�û�����
	  Assert.assertEquals(SummaryInfoAll.rb_count, SummaryInfoAll.listAll.get(1));

	}
	@Test(enabled = false)
	public void noareaCount(){
		//�ȶ�δ��������
		Assert.assertEquals(SummaryInfoAll.uasso_count,SummaryInfoAll.listAll.get(2));
		
	}
	@Test(enabled = false)
	public void rmalarm_Count(){
		//�ȶԿ��˱��������
		Assert.assertEquals(SummaryInfoAll.rmalarm_count,SummaryInfoAll.listAll.get(3));
		
	}
	@Test(enabled = false)
	public void rbalarm_Count(){
		//�ȶԵ�λ�û���������
		Assert.assertEquals(SummaryInfoAll.rbalarm_count,SummaryInfoAll.listAll.get(4));
	}
	//���dmaall�ӿ�
	@Test//����ͷ
	public void dmaAllHeaders(){
		//�ȶԽӿ�dmaALL��ȡ����headers
		String dmaallheaders=OperateProperties.getValue("E:/test/workspace/testNG/config/applilcation.properties","dmaallheaders");
		Assert.assertEquals(SummaryInfoDmaAll.headers.toString(), dmaallheaders);
	}
	@Test//������
	public void dmaAllHPCheck(){
		Assert.assertEquals(dmaALL.Slist.get(0).get("name"), "����");
		Assert.assertEquals(dmaALL.Slist.get(0).get("value"),1017);
		Assert.assertEquals(dmaALL.Slist.get(1).get("name"), "���");
		Assert.assertEquals(dmaALL.Slist.get(1).get("value"),905);
	}
	@Test(enabled = false) //վ
	public static void dmaAllHP_SITE_Check(){
		Assert.assertEquals(dmaALL.ZQXmap.get("name"), "��Ϫվ");
		Assert.assertEquals(dmaALL.ZQXmap.get("value"),356);
	}
}
