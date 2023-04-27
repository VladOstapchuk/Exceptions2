public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String gen;

    Gender(String gen) {
        this.gen = gen;
    }

    public String getGender() {
        return gen;
    }

    public static Gender getGenderbyString(String str) {
        for (Gender gnd : values()) {
            if (gnd.getGender().equals(str)) {
                return gnd;
            }
        }
        throw new IllegalArgumentException("No enum found with gender: [" + str + "]");
    }



}
