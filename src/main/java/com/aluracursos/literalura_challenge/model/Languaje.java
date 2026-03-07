package com.aluracursos.literalura_challenge.model;


public enum Languaje {
    es("es", "español"),
    en("en", "inglés"),
    fr("fr", "francés"),
    nl("nl", "holandés"),
    de("de", "alemán"),
    tl("tl", "tagalog"),
    zh("zh", "chino"),
    pt("pt", "portugués");

    private String idiomaAPI;
    private String idiomaNombreCompleto;

    Languaje(String idiomaAPI, String idiomaNombreCompleto) {
        this.idiomaAPI = idiomaAPI;
        this.idiomaNombreCompleto = idiomaNombreCompleto;
    }

    public static Languaje fromString(String text) {
        for (Languaje idi : Languaje.values()) {
            if (idi.idiomaAPI.equalsIgnoreCase(text) || idi.idiomaNombreCompleto.equalsIgnoreCase(text)) {
                return idi;
            }
        }
        return null;
    }

    public String getParaImprimir() {
        return idiomaAPI + " - " + idiomaNombreCompleto;
    }
}
