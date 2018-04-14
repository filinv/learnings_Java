public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }

    /**сформирует строку из всех блюд */
    public static String allDishesToString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<Dish.values().length;i++){
            sb.append(Dish.values()[i]);
            if(i!=Dish.values().length-1)sb.append(", ");
        }
        return sb.toString();
    }
}
