package com.developersstack.medex.view.tm;

public class DoctorComboView {
    private int index;
    private String docId;
    private String name;

    public DoctorComboView() {
    }

    public DoctorComboView(int index, String docId, String name) {
        this.index = index;
        this.docId = docId;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
