package controller;

import java.util.ArrayList;

import dao.ProductDao;
import model.Product;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<Product> produtos = new ProductDao().SearchProductForDescription("a");
		System.out.println("-----> " + produtos.size());
	}
	
}
