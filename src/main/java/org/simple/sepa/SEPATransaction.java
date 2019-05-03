package org.simple.sepa;

import java.util.Date;

public class SEPATransaction {

	public enum Currency {
		BGN, HRK, CZK, DKK,
		EUR, GIP, HUF, ISK,
		NOK, PLN, RON, SEK,
		CHF, GBP
	}

	private SEPABankAccount bankAccount;

	private String subject;
	private double value;
	private Date date;

	private String mandatReference;
	private Date mandatReferenceDate;

	private Currency currency;
	private String remittance;

	public SEPATransaction(
		SEPABankAccount bankAccount,
		double value,
		String subject,
		Date date,
		String mandatReference,
		Date mandatReferenceDate,
		Currency currency,
        String remittance
	) {
		this.bankAccount = bankAccount;
		this.subject = subject;
		this.value = value;
		this.date = date;
		this.mandatReference = mandatReference;
		this.mandatReferenceDate = mandatReferenceDate;
		this.currency = currency;
		this.remittance = remittance;
	}

	public SEPATransaction(
			SEPABankAccount bankAccount,
			double value,
			String subject,
			Date date,
			String mandatReference,
			Date mandatReferenceDate,
            String remittance
	) {
		this(bankAccount, value, subject, date, mandatReference, mandatReferenceDate, Currency.EUR, remittance);
	}

	public SEPATransaction(SEPABankAccount bankAccount, Double value, String subject, String remittance) {
		this(bankAccount, value, subject, new Date(), null, null, Currency.EUR, remittance);
	}

	public SEPATransaction(SEPABankAccount bankAccount, Double value, String subject, Currency currency, String remittance) {
		this(bankAccount, value, subject, new Date(), null, null, currency, remittance);
	}

	public SEPABankAccount getBankAccount() {
		return bankAccount;
	}

	public double getValue() {
		return Math.round(value * 100.0) / 100.0;
	}

	public String getSubject() {
		return subject;
	}

	public String getMandatReference() {
		return mandatReference;
	}
	
	public Date getMandatReferenceDate() {
		return mandatReferenceDate;
	}

	public Date getDate() {
		return date;
	}

	public Currency getCurrency() {
		return currency;
	}

	public String getRemittance() { return remittance; }
}
