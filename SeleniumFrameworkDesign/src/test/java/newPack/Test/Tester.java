package newPack.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Tester {

	public static void main(String[] args)
	{
		HashMap <Object, Object[]> map1 = new<Object, Object[]> HashMap();
		HashMap <Object,Object> map2 = new <Object,Object> HashMap();
		map1.put("email", new String[]{"tikori@gmail.com"});
		map1.put("password",new String[] {"Tikori69$"});
		map1.put("products",new String[] {"Tikori69$","ADIDAS ORIGINAL","ZARA COAT 3","IPHONE 13 PRO"});
		//map2.put("email", "wanshitong@gmail.com");
		//map2.put("password", "Admin@123");
		//map2.put("products",new String[] {"IPHONE 13 PRO"});
		//System.out.println(map1.get("email")[0]);
		List<Object> listedproducts = Arrays.asList(map1.get("products"));
		List<String> listedProducts =  listedproducts.stream()
				   .map(object -> Objects.toString(object, null))
				   .toList();

		for(String l : listedProducts)
		{
			System.out.println(l);
		}


	}
}
