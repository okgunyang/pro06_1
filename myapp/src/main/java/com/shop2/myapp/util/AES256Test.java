package com.shop2.myapp.util;

public class AES256Test {
	public static void main(String[] args) throws Exception {
        AES256 aes256 = new AES256();
        String text = "!! Hello World !!";
        String cipherText = aes256.encrypt(text);
        System.out.println(text);
        System.out.println(cipherText);
        System.out.println(aes256.decrypt(cipherText));
        
        text = "1234";
        cipherText = aes256.encrypt(text);
        System.out.println(cipherText);
	}
}
