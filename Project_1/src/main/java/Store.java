public class Store {

    private String productName;
    private float volume;
    private float weight;
    private String expirationDate;

    public Store(String productName, float volume, float weight, String expirationDate) {
        this.productName = productName;
        this.volume = volume;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public String getProductName() {
        return productName;
    }

    public float getVolume() {
        return volume;
    }

    public float getWeight() {
        return weight;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return productName + " " + volume + " " + weight + " " + expirationDate;
    }
}

