package com.br.jireh.jirehconfeccoes.utils;

public class RemoveCaracteres {

        public static String inuptCharacteres(String string) {
            return string.replaceAll("[^a-zZ-Z1-9 ]", "");
        }
}
