package com.example.internship.Models;

import java.util.ArrayList;

public class LangModel {
    ArrayList<languages> languages;

    public ArrayList<LangModel.languages> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<LangModel.languages> languages) {
        this.languages = languages;
    }

    public class languages{
        String iso639_1,iso639_2,name,nativeName;

        public String getIso639_1() {
            return iso639_1;
        }

        public void setIso639_1(String iso639_1) {
            this.iso639_1 = iso639_1;
        }

        public String getIso639_2() {
            return iso639_2;
        }

        public void setIso639_2(String iso639_2) {
            this.iso639_2 = iso639_2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }
    }

}
