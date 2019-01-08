package model;

import dao.ProductDAO;
import dao.StaffDAO;

public class GenerateDataBase {
	public void execute() {
		StaffDAO sDao = new StaffDAO();
		ProductDAO pDao = new ProductDAO();

		//テストデータの生成
		System.out.println("m_staffを生成");
		sDao.createTable();
		System.out.println("staffテストデータを生成");
		if(!sDao.insertTest()){
			System.out.println("既存データを使用");
		}

		System.out.println("m_productを生成");
		pDao.createTable();
		System.out.println("productテストデータを生成");
		if(!pDao.insertTest()) {
			System.out.println("既存データを使用");
		}
	}
}
