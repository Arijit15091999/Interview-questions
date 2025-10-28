import java.util.*;

class FoodRatings {
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;
    private Map<String, Food> foodMap;
    private Map<String, PriorityQueue<Food>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        init();
    }

    public void changeRating(String food, int newRating) {
        Food foodInfo = new Food(this.foodMap.get(food));
        foodInfo.foodRating = newRating;
        this.foodMap.put(food, foodInfo);
        PriorityQueue<Food> pq = this.cuisineMap.get(foodInfo.cuisineName);
        pq.offer(foodInfo);
        this.cuisineMap.put(foodInfo.cuisineName, pq);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = this.cuisineMap.get(cuisine);
        Food food = pq.peek();
        if(food == null) {
            return null;
        }

        while(food.foodRating != this.foodMap.get(food.foodName).foodRating) {
            pq.poll();
            food = pq.peek();
        }

        return food.foodName;
    }

    private class Food implements Comparable<Food>{
        public String foodName;
        public String cuisineName;
        public int foodRating;

        public Food(String foodName, String cuisineName, int foodRating) {
            this.foodName = foodName;
            this.cuisineName = cuisineName;
            this.foodRating = foodRating;
        }
        public Food(Food other) {
            this.foodName = other.foodName;
            this.cuisineName = other.cuisineName;
            this.foodRating = other.foodRating;
        }

        @Override
        public int compareTo(Food other) {
            if(this.foodRating == other.foodRating) {
                return this.foodName.compareTo(other.foodName);
            }
            return -1 * (this.foodRating - other.foodRating);
        }

    }
    private void init() {
        this.foodMap = new HashMap<>();
        this.cuisineMap = new HashMap<>();
        for(int i = 0; i < this.foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            this.foodMap.put(foods[i], food);
            PriorityQueue<Food> pq = this.cuisineMap.getOrDefault(cuisines[i], new PriorityQueue<>());
            pq.offer(food);
            this.cuisineMap.put(cuisines[i], pq);
        }
    }
}

//Input
//        ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
//        [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]],
//        ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
//        Output
//        [null, "kimchi", "ramen", null, "sushi", null, "ramen"]