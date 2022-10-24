package com.saha.amit.productServices.util;

import java.util.UUID;

public class ProductUtil {
	public static String getUUID() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
