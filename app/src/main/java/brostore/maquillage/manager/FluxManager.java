package brostore.maquillage.manager;

public class FluxManager {

	public static String DIR_DATA = "/Android/data/brostore.maquillage";

	public static final String API_KEY = "P863RUC17RUS3S9T7NZM9UP2DBIDHV6S";
	//TODO connect user
	public static final String COOKIE_KEY = "aotzJECbeSfvXZmTJhOi2oKLJ1KKkCX3PVNDqOFNOcLR4HUhKKgB19Lw";

	public static final String URL_MENU             = "http://www.maquillage.fr/maquillage-marque/api/categories/2?output_format=JSON";
	public static final String URL_CATEGORIES       = "http://www.maquillage.fr/maquillage-marque/api/categories/__ID__?output_format=JSON";
	public static final String URL_PRODUCT          = "http://www.maquillage.fr/maquillage-marque/api/products/__ID__?output_format=JSON";
    public static final String URL_IMAGES           = "http://www.maquillage.fr/maquillage-marque/api/images/products/__ID_PRODUCT__/__ID_IMAGE__";
    public static final String URL_SPECIFIC_PRICE   = "http://www.maquillage.fr/maquillage-marque/api/specific_prices/?filter[id_product]=__ID_PRODUCT__&display=full&output_format=JSON";
	public static final String URL_STOCK			= "http://www.maquillage.fr/maquillage-marque/api/stock_availables/__ID_QUANTITY__?output_format=JSON";

	public static final String URL_CONNECT = "http://maquillage.fr/maquillage-marque/api/customers/?filter[passwd]=__ENCRYPTED_MDP__";
	public static final String URL_GET_USER = "http://www.maquillage.fr/maquillage-marque/api/customers/__ID__?output_format=JSON";

}