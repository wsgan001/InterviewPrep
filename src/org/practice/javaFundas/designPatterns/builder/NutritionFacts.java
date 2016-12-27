package org.practice.javaFundas.designPatterns.builder;

//Builder Design Pattern :
//Consider a builder when faced with many constructor parameters
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
    }

    public String toString() {
        return "servingSize: "+servingSize+" servings: "+servings+" calories: "+calories+" fat: "+fat+" sodium: "+sodium;
    }

    public static void main(String args[]) {
        NutritionFacts cococola = new Builder(240, 8).calories(100).fat(10).sodium(20).build();
        System.out.println(cococola.toString());
    }
}
