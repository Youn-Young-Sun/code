package Product;

public interface IProductMgr {
	void add(Product product);
	Product[] getProductList();
	Product getProductByNum(String num);
	Product[] getProductByName(String keyword);
	Product[] getTVList();
	Product[] getRefrigeatorList();
	void removeProductByNo(String num);
	int getTotalPrice();

}
