package com.itctraining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RajyasabhaData {
	static Set<String> uniqueministry = new HashSet<>();
	static List<String> allMinistry = new ArrayList<String>();
	static Map<String, Integer> countings = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {

	Stream<String> ministrydata = Files.lines(
	Paths.get("/home/test14/Documents/java/rajyasabha_data.csv"));
	Stream<String> ministrydata2 = Files.lines(
	Paths.get("/home/test14/Documents/java/rajyasabha_data.csv"
			+ ""));
	uniqueministry = ministrydata.map(x -> x.split(",")).map(x -> x[2].trim()).collect(Collectors.toSet());
	allMinistry = ministrydata2.map(x -> x.split(",")).map(x -> x[2].trim()).collect(Collectors.toList());
//	        System.out.println("Unique Ministries: ");
//	        uniqueministry.forEach((e) -> { System.out.println(e); });
	int countOfMinistry = (int) uniqueministry.stream().count();
	System.out.println("The total number of ministries are: " + countOfMinistry);
	System.out.println("The ministries with number of questions are: ");

	calculateQuestion();
	ministrydata.close();
	ministrydata2.close();

	}

	static void calculateQuestion() {
	int count = 0;
	try {

	for (String uniqueMinistries : uniqueministry) {
	for (String allMinistries : allMinistry) {
	if (uniqueMinistries.equals(allMinistries)) {
	count++;
	}
	countings.put(uniqueMinistries, count);

	}
	count = 0;

	}
	for (Map.Entry<String, Integer> entry : countings.entrySet()) {
	System.out.println(
	"Ministries : " + entry.getKey() + "\nCount of Questions asked: " + entry.getValue() + "\n");
	}
	} catch (Exception e) {
	e.printStackTrace();


	}

	}
	}