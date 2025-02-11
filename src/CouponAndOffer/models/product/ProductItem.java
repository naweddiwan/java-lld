package CouponAndOffer.models.product;

public class ProductItem extends Product{

    public ProductItem(Double price, ProductType productType, String name) {
        super(price, productType, name);
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
