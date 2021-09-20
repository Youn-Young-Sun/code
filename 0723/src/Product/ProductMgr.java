package Product;

import java.util.Arrays;
import java.util.List;


public class ProductMgr implements IProductMgr{
	private static ProductMgr instance = new ProductMgr();
	private ProductMgr() {}
	public static ProductMgr getInstance() {
		return instance;
	}
	
	private Product[] productList;
	private int idx;
	
	@Override
	public void add(Product p) {
		productList[idx++] = p;
	}
	
	@Override
	public Product[] getProductList() {
		return Arrays.copyOfRange(productList, 0, idx);
	}
	
	@Override
	public Product getProductByNum(String num) {
		for(int i=0;i<idx;i++) {
			if(productList[i].getName().equals(num)) return productList[i];
		}
		return null;
	}
	
	@Override
	public Product[] getProductByName(String keyword) {
		int cnt=0;
		for(int i=0;i<idx;i++) {
			if(productList[i].getName().contains(keyword)) {
				cnt++;
				return productList;
			}
		}
		return null;
	}
//	public Product[] getProductByName(String name) {
//		for(int i=0;i<idx;i++) {
//		  if( productList[i].getName().equals(name) ) return Products[i];
//		}
//		return null;
//	}
	@Override
	public Product[] getTVList() {
		int cnt=0;
		for(int i=0;i<idx;i++) {
			if(productList[i] instanceof TV) //TV인지 아닌지 확인	
				cnt++;
		}
		Product[] tvList = new Product[cnt];
		int idx=0;
		for(int i=0;i<idx;i++) {
			if(productList[i] instanceof TV) {
				tvList[idx++]=productList[i];
			}
		}
		return tvList;
	}

	@Override
	public Product[] getRefrigeatorList() {
		int cnt=0;
		for(int i=0;i<idx;i++) {
			if(productList[i] instanceof Refrigerator) //TV인지 아닌지 확인	
				cnt++;
		}
		Product[] refrigeratorList = new Product[cnt];
		int idx=0;
		for(int i=0;i<idx;i++) {
			if(productList[i] instanceof Refrigerator) {
				refrigeratorList[idx++]=productList[i];
			}
		}
		return refrigeratorList;
	}
	
	@Override
	public void removeProductByNo(String num) {
		for(int i = 0; i < idx; i++) {
            if(productList[i].getNum().equals(num)) {
            	productList[i] = productList[idx-1];
                idx--;
                break;
            }
		}
		
	}
	
	@Override
	public int getTotalPrice() {
		int sum=0;
		for(int i = 0; i < idx; i++) {
			sum+=productList[i].getPrice();
		}
		return sum;
	}
	
	
	
	

	
}
