package daos;

import java.util.List;

import model.Ville;

public class Test {
	public static void main(String[] args) {
		Dao daoCity = new Dao();
		getManyCitiesByName(daoCity);
		daoCity.close();
	}

	private static void getManyCitiesByName(Dao daoCity) {
		List<Ville> cityList = daoCity.getByNom("VILLE");
		showCityList(cityList);
	}

	private static void getManyCitiesByDpt(Dao daoCity) {
		List<Ville> cityList = daoCity.getByDpt("91");
		showCityList(cityList);
	}

	private static void getManyCitiesByCp(Dao daoCity) {
		List<Ville> cityList = daoCity.getByCp("90110");
		showCityList(cityList);
	}

	private static void getOneCity(Dao daoCity) {
		Ville city = daoCity.getByCc("90078");
		System.out.println(city);
	}

	private static void showCityList(List<Ville> cityList) {
		for (Ville city : cityList)
			System.out.println(city);
	}
}
