package com.company.servicii;

import java.sql.Timestamp;

public class Audit {
    private static Audit instance = null;
    private String fisierAudit;

    Audit() {
        fisierAudit = "audit.csv";
    }

    public static Audit getInstance() {
        if (instance == null)
            instance = new Audit();
        return instance;
    }

    public void scrieAudit(String actiune) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String data = actiune + ", " + timestamp;
        Fisiere.getInstance().scrieFisier(this.fisierAudit, data);

    }
}