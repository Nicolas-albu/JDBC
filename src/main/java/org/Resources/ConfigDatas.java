package org.Resources;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigDatas {
    private static final Dotenv configurations = Dotenv.load();

    public static String getUrlDatabase() {
        return String.format("jdbc:%s://%s:%s/%s",
                configurations.get("DB_TYPE"),
                configurations.get("DB_HOST"),
                configurations.get("DB_PORT"),
                configurations.get("DB_NAME"));
    }

    public static String getDbUser() {
        return configurations.get("DB_USER");
    }

    public static String getDbPassword() {
        return configurations.get("DB_PASSWORD");
    }
}
