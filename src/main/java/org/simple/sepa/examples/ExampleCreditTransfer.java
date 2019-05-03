package org.simple.sepa.examples;

import org.simple.sepa.SEPA;
import org.simple.sepa.SEPABankAccount;
import org.simple.sepa.SEPACreditTransfer;
import org.simple.sepa.SEPATransaction;

import java.util.ArrayList;
import java.util.List;

public class ExampleCreditTransfer {

    // PAIN 001.001.003

    public static void main(String[] args) {
        final SEPABankAccount sender = new SEPABankAccount(
                "DE89370400440532013000",
                "DEUTDEBBXXX",
                "Joe Doe"
        );

        final List<SEPATransaction> transactions = new ArrayList<SEPATransaction>() {{
            add(new SEPATransaction(
                            new SEPABankAccount(
                                    "DE05500105173195282731",
                                    "VBRSDE33347",
                                    "Peter Parker"
                            ),
                            2000.20d,
                            "Salary PP 2018-07",
                            SEPATransaction.Currency.EUR,
                            "No Information"
                    )
            );

            add(new SEPATransaction(
                            new SEPABankAccount(
                                    "DK5250511963137134",
                                    "UINVDEFFXXX",
                                    "Carl White"
                            ),
                            1000.00d,
                            "Salary CW 2015-12",
                            SEPATransaction.Currency.EUR,
                            "No Information"
                    )
            );

            add(new SEPATransaction(
                            new SEPABankAccount(
                                    "CZ7627005991764514418145",
                                    "SWBSDESSXXX",
                                    "Frank Black"
                            ),
                            5000.00d,
                            "Salary FB 2017-05",
                            SEPATransaction.Currency.EUR,
                            "No Information"
                    )
            );
        }};

        final SEPA sepa = new SEPACreditTransfer(sender, transactions);
        sepa.write(System.out);
    }
}
