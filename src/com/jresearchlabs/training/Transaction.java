package com.jresearchlabs.training;

class Transaction {
	int id;
	String transactiondId; // mandatory
	String bankName;
	String branchName;
	String name;           // mandatory
	String merchantId;

	public Transaction(int id, String transactiondId, String bankName, String branchName, String name,
			String merchantId) {
		super();
		this.id = id;
		this.transactiondId = transactiondId;
		this.bankName = bankName;
		this.branchName = branchName;
		this.name = name;
		this.merchantId = merchantId;
	}

	public Transaction(String objectName) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactiondId() {
		return transactiondId;
	}

	public void setTransactiondId(String transactiondId) {
		this.transactiondId = transactiondId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactiondId=" + transactiondId + ", bankName=" + bankName
				+ ", branchName=" + branchName + ", name=" + name + ", merchantId=" + merchantId + "]";
	}
}