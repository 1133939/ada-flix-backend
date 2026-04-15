package com.ada.projeto_final.enums;

import java.util.Arrays;

public enum GeneroEnum {
    AVENTURA("Adventure"), ACAO("Action"), DRAMA("Drama"), COMEDIA("Comedy"), SCI_FI("Sci-Fi"), ROMANCE("Romance"), THRILLER("Thriller"), GUERRA("War"), MISTERIO("Mystery"), CRIME("Crime"), DOCUMENTARIO("Documentary"), FANTASIA("Fantasy"), OUTRO("Outro");

    String name;

    GeneroEnum(String name) {
        this.name = name;
    }

    public static GeneroEnum getFromName(String genero){
        return Arrays.stream(GeneroEnum.values()).filter( gen -> gen.name.equals(genero)).findFirst().orElse(OUTRO);
    }

}
