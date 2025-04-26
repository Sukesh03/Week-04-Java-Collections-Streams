import java.util.ArrayList;
import java.util.List;

// MealPlan Interface
interface MealPlan {
    void showMealDetails();
}

// MealPlan Types
class VegetarianMeal implements MealPlan {
    @Override
    public void showMealDetails() {
        System.out.println("Vegetarian Meal: Includes vegetables, fruits, grains, and dairy.");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public void showMealDetails() {
        System.out.println("Vegan Meal: Includes only plant-based foods. No animal products.");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public void showMealDetails() {
        System.out.println("Keto Meal: High-fat, low-carb diet plan.");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public void showMealDetails() {
        System.out.println("High-Protein Meal: Rich in meats, legumes, dairy, and nuts.");
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMeal() {
        mealType.showMealDetails();
    }
}

// Meal Generator Utility
class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("Generating your personalized meal plan...");
        return new Meal<>(mealType);
    }
}

// Main class
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> userMealPlans = new ArrayList<>();

        // User chooses different meal types
        VegetarianMeal vegMeal = new VegetarianMeal();
        KetoMeal ketoMeal = new KetoMeal();
        VeganMeal veganMeal = new VeganMeal();

        // Generate meal plans dynamically
        Meal<VegetarianMeal> userVegMeal = MealGenerator.generateMealPlan(vegMeal);
        Meal<KetoMeal> userKetoMeal = MealGenerator.generateMealPlan(ketoMeal);
        Meal<VeganMeal> userVeganMeal = MealGenerator.generateMealPlan(veganMeal);

        // Add to user's meal plan list
        userMealPlans.add(userVegMeal);
        userMealPlans.add(userKetoMeal);
        userMealPlans.add(userVeganMeal);

        System.out.println("\n=== Your Personalized Meal Plans ===");
        for (Meal<? extends MealPlan> meal : userMealPlans) {
            meal.displayMeal();
            System.out.println("---");
        }
    }
}
