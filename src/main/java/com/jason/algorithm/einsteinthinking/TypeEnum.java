package com.jason.algorithm.einsteinthinking;

/**
 *
 * @author jason-geng
 * @date 12/17/17
 */
public class TypeEnum {
    public enum ITEM_TYPE {
        HOUSE(0),
        NATION(1),
        DRINK(2),
        PET(3),
        CIGERATE(4);

        private int type;

        ITEM_TYPE(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public enum HOUSE_TYPE {
        BLUE(0, "BLUE"),
        RED(1, "RED"),
        YELLOW(2, "YELLOW"),
        GREEN(3, "GREEN"),
        WHITE(4, "WHITE");

        private int type;
        private String value;

        HOUSE_TYPE(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public static String matchValue(int type) {
            for (HOUSE_TYPE item: HOUSE_TYPE.values()) {
                if (item.getType() == type){
                    return item.getValue();
                }
            }
            return "";
        }
    }

    public enum DRINK_TYPE {
        BEER(0, "BEER"),
        COOFEE(1, "COOFEE"),
        TEA(2, "TEA"),
        WATER(3, "WATER"),
        MILK(4, "MILK");

        private int type;
        private String value;

        DRINK_TYPE(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public static String matchValue(int type) {
            for (DRINK_TYPE item: DRINK_TYPE.values()) {
                if (item.getType() == type){
                    return item.getValue();
                }
            }
            return "";
        }
    }

    public enum CIGERATE_TYPE {
        PALL_MALL(0, "PALL_MALL"),
        DUNHILL(1, "DUNHILL"),
        BLENDS(2, "BLENDS"),
        BLUE_MASTER(3, "BLUE_MASTER"),
        PRINCE(4, "PRINCE");

        private int type;
        private String value;

        CIGERATE_TYPE(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public static String matchValue(int type) {
            for (CIGERATE_TYPE item: CIGERATE_TYPE.values()) {
                if (item.getType() == type){
                    return item.getValue();
                }
            }
            return "";
        }
    }

    public enum PET_TYPE {
        DOG(0, "DOG"),
        FISH(1, "FISH"),
        BIRD(2, "BIRD"),
        CAT(3, "CAT"),
        HORSE(4, "HORSE");

        private int type;
        private String value;

        PET_TYPE(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public static String matchValue(int type) {
            for (PET_TYPE item: PET_TYPE.values()) {
                if (item.getType() == type){
                    return item.getValue();
                }
            }
            return "";
        }
    }

    public enum NATION_TYPE {
        ENGLAND(0, "ENGLAND"),
        DANMARK(1, "DANMARK"),
        GERMANY(2, "GERMANY"),
        SWIRZERLAND(3, "SWIRZERLAND"),
        NORWAY(4, "NORWAY");

        private int type;
        private String value;

        NATION_TYPE(int type, String value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        public static String matchValue(int type) {
            for (NATION_TYPE item: NATION_TYPE.values()) {
                if (item.getType() == type){
                    return item.getValue();
                }
            }
            return "";
        }
    }
}
