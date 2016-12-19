package test;

import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String args[]){
		Map<Integer,String> mapmain=new TreeMap<Integer,String>();
		mapmain.put(1, "2016-12-10");
		mapmain.put(2, "2016-12-12");
		mapmain.put(15, "2016-12-15");
		System.out.println(mapmain.toString());
		System.out.println(mapmain.get("1"));
		System.out.println(mapmain.get(15));
	}
}
