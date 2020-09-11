package com.jresearchlabs.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jerome4Java
 * 
 *         This program demonstrates to prepare the list of error records which
 *         pertains to the particular mandatory field which is empty.
 *         ex. mandatory fields: name, transactionId
 */
public class ReportErrorTransaction {
	public static void main(String[] args) {

		List<Transaction> transactionList = prepareTransactionList();
		List<Transaction> errorList = new ArrayList<>();
		errorList = prepareErrorList(transactionList);
		errorList.forEach(System.out::println);	
		
	}

	private static List<Transaction> prepareErrorList(List<Transaction> transactionList) {
		List<Transaction> errorList;
		errorList = transactionList.stream()  											// created stream out of main list
		.filter(transList -> Stream.of(transactionList.stream() 						// apply main filter with same list
				.filter(n -> n.getName().isEmpty() || n.getTransactiondId().isEmpty()) 	// apply sub filter to obtain records without values
				.map(Transaction::getMerchantId) 										// get common filtered field for future matching 
				.collect(Collectors.joining(",")).split(",")) 							// created a delimited list for main list parsing 
				.map(String::trim) 														// remove blankspaces
				.collect(Collectors.toList())
				.parallelStream()
				.anyMatch(tempList -> tempList											// matching the filtered field with main list 
				.equals(transList.getMerchantId())))
				.sorted(Comparator.comparingInt(Transaction::getId))					// ordered the list based on id
				.collect(Collectors.toList());
		return errorList;
	}

	private static List<Transaction> prepareTransactionList() {
		List<Transaction> transactionList = new ArrayList<>();
		Transaction t1 = new Transaction(1, "8761sd5tJ", "HDFC", "Karapakkam", "Jerome", "walmart");
		Transaction t2 = new Transaction(1, "876s431k", "HDFC", "Karapakkam", "Jerome", "walmart");
		Transaction t6 = new Transaction(2, "2361J", "HDFC", "Karapakkam", "Aravind", "Volvo");
		Transaction t7 = new Transaction(2, "2ds361J", "HDFC", "Karapakkam", "Aravind", "Volvo");
		Transaction t8 = new Transaction(2, "236dd1J", "HDFC", "Karapakkam", "Aravind", "Volvo");
		Transaction t5 = new Transaction(1, "", "HDFC", "Karapakkam", "Jerome", "walmart"); // kept mandatory field empty
		Transaction t19 = new Transaction(4, "8761fJ", "HDFC", "Karapakkam", "Saravanan", "Cognizant");
		Transaction t20 = new Transaction(4, "8761v", "HDFC", "Karapakkam", "Saravanan", "Cognizant");
		Transaction t21 = new Transaction(5, "8761dJ", "HDFC", "Karapakkam", "Bala", "Fiserv");
		Transaction t9 = new Transaction(2, "236sds1J", "HDFC", "Karapakkam", "Aravind", "Volvo");
		Transaction t10 = new Transaction(2, "2361J", "HDFC", "Karapakkam", "Aravind", "Volvo");
		Transaction t11 = new Transaction(3, "84541J", "HDFC", "Karapakkam", "JP", "Intellect");
		Transaction t12 = new Transaction(3, "8764J", "HDFC", "Karapakkam", "JP", "Intellect");
		Transaction t13 = new Transaction(3, "8766J", "HDFC", "Karapakkam", "", "Intellect"); // kept mandatory field empty
		Transaction t14 = new Transaction(3, "876kJ", "HDFC", "Karapakkam", "JP", "Intellect");
		Transaction t22 = new Transaction(5, "436dfd", "HDFC", "Karapakkam", "Bala", "Fiserv");
		Transaction t23 = new Transaction(5, "8761Jd", "HDFC", "Karapakkam", "Bala", "Fiserv");
		Transaction t24 = new Transaction(5, "8761sdJ", "HDFC", "Karapakkam", "Bala", "Fiserv");
		Transaction t25 = new Transaction(5, "8761Jsd", "HDFC", "Karapakkam", "Bala", "Fiserv");
		Transaction t15 = new Transaction(3, "876gJ", "HDFC", "Karapakkam", "JP", "Intellect");
		Transaction t16 = new Transaction(4, "8761rJ", "HDFC", "Karapakkam", "Saravanan", "Cognizant");
		Transaction t17 = new Transaction(4, "8761fgf", "HDFC", "Karapakkam", "", "Cognizant");  // kept mandatory field empty
		Transaction t18 = new Transaction(4, "8761g", "HDFC", "Karapakkam", "Saravanan", "Cognizant");
		Transaction t3 = new Transaction(1, "8761rf67", "HDFC", "Karapakkam", "Jerome", "walmart");
		Transaction t4 = new Transaction(1, "8761dsd", "HDFC", "Karapakkam", "Jerome", "walmart");
		transactionList.add(t13);
		transactionList.add(t5);
		transactionList.add(t7);
		transactionList.add(t14);
		transactionList.add(t11);
		transactionList.add(t12);
		transactionList.add(t19);
		transactionList.add(t20);
		transactionList.add(t21);
		transactionList.add(t15);
		transactionList.add(t3);
		transactionList.add(t4);
		transactionList.add(t8);
		transactionList.add(t16);
		transactionList.add(t17);
		transactionList.add(t18);
		transactionList.add(t10);
		transactionList.add(t22);
		transactionList.add(t23);
		transactionList.add(t6);
		transactionList.add(t24);
		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t9);
		transactionList.add(t25);
		return transactionList;
	}

}
